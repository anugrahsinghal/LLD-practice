package com.example.room.management.handlers;

import com.example.room.management.RequestHandler;
import com.example.room.management.repo.BookingRepo;
import com.example.room.management.request.BookingRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookingRequestHandler implements RequestHandler<BookingRequest> {
    private final BookingRepo bookingRepo;

    @Override
    public void handleRequest(BookingRequest request) {

        if (!bookingRepo.roomExists(request.getBuildingId(), request.getFloorId(), request.getConferenceRoomId())) {
            System.out.println("invalid request - room does not exist");
            return;
        }
        if (!bookingRepo.allSlotsEmpty(request.getBuildingId(), request.getFloorId(), request.getConferenceRoomId(), request.getStartBlock(), request.getEndBlock())) {
            System.out.println("invalid request - slots are not empty");
            return;
        }
        if (request.getStartBlock() > request.getEndBlock()) {
            System.out.println("invalid request - time values");
            return;
        }

        bookingRepo.bookRoom(request.getBuildingId(), request.getFloorId(), request.getConferenceRoomId(), request.getUserId(), request.getStartBlock(), request.getEndBlock());

        System.out.println("Booked Room");
    }
}
