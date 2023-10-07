package com.example.room.management.handlers;

import com.example.room.management.RequestHandler;
import com.example.room.management.models.Building;
import com.example.room.management.repo.BuildingRepo;
import com.example.room.management.request.AddBuildingRequest;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class AddBuildingRequestHandler implements RequestHandler<AddBuildingRequest> {
    private final BuildingRepo buildingRepo;
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    @Override
    public void handleRequest(AddBuildingRequest request) {

        final Building b = new Building("B" + idGenerator.getAndIncrement(), new ArrayList<>());
        buildingRepo.save(b);

        System.out.println("Created building " + b);
    }
}

