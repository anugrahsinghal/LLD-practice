package com.example.room.management;

import com.example.room.management.handlers.*;
import com.example.room.management.repo.BookingRepo;
import com.example.room.management.repo.BuildingRepo;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class RoomManagementApplication {

    public static final String SPLIT_CHARACTER = " ";

    public static void main(String[] args) throws Exception {
        List<String[]> commands = parseFile(args[0]);
        final BookingRepo bookingRepo = new BookingRepo();
        final BuildingRepo buildingRepo = new BuildingRepo();

        CommandProcessor commandProcessor = new CommandProcessor(
                new AddBuildingRequestHandler(buildingRepo),
                new AddFloorRequestHandler(buildingRepo),
                new AddConferenceRoomRequestHandler(buildingRepo, bookingRepo),
                new BookingRequestHandler(bookingRepo),
                new CancelBookingRequestHandler(bookingRepo),
                new ListBookingRequestHandler(bookingRepo)
        );

        for (String[] command : commands) {
            final Object request = RequestFactory.parseRequest(command);
            commandProcessor.process(request);
        }
    }

    private static List<String[]> parseFile(String filePath) throws IOException {
        final List<String> strings = Files.readAllLines(Paths.get(filePath));

        return strings.stream()
                .map(string -> string.split(SPLIT_CHARACTER))
                .collect(Collectors.toList());
    }

}
