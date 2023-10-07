package com.example.room.management.models;


import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Building {
    private final AtomicInteger floorIdGen = new AtomicInteger(1);
    private String buildingId;
    private List<Floor> floors;

    public Floor addFloor() {
        final Floor floor = new Floor("F" + floorIdGen.getAndIncrement(), new ArrayList<>());
        floors.add(floor);
        return floor;
    }

    public Floor getFloor(String floorId) {
        return floors.stream()
                .filter(it -> it.getFloorId().equals(floorId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Floor not found"));
    }
}

