package com.example.room.management.handlers;

import com.example.room.management.RequestHandler;
import com.example.room.management.models.Building;
import com.example.room.management.models.ConferenceRoom;
import com.example.room.management.models.Floor;
import com.example.room.management.repo.BookingRepo;
import com.example.room.management.repo.BuildingRepo;
import com.example.room.management.request.AddConferenceRoomRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddConferenceRoomRequestHandler implements RequestHandler<AddConferenceRoomRequest> {

    private final BuildingRepo buildingRepo;
    private final BookingRepo bookingRepo;

    @Override
    public void handleRequest(AddConferenceRoomRequest request) {
        final Building building = buildingRepo.getBuilding(request.getBuildingId());

        Floor floor = building.getFloor(request.getFloorId());

        final ConferenceRoom conferenceRoom = floor.addConferenceRoom(request.getConferenceRoomName());

        System.out.println("Created " + conferenceRoom);

        bookingRepo.addRoom(building.getBuildingId(), floor.getFloorId(), conferenceRoom.getConferenceRoomId());
    }


}
