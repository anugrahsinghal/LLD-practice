package com.example.room.management.handlers;

import com.example.room.management.RequestHandler;
import com.example.room.management.models.Building;
import com.example.room.management.models.Floor;
import com.example.room.management.repo.BuildingRepo;
import com.example.room.management.request.AddFloorRequest;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class AddFloorRequestHandler implements RequestHandler<AddFloorRequest> {
    private final BuildingRepo buildingRepo;

    @Override
    public void handleRequest(AddFloorRequest request) {
        final Building building = buildingRepo.getBuilding(request.getBuildingId());

        for (int i = 0; i < request.getNumFloors(); i++) {
            building.addFloor();
        }
        System.out.println("Created " + request.getNumFloors() + " floor");
    }
}
