package com.example.room.management.repo;

import com.example.room.management.models.Building;

import java.util.HashMap;
import java.util.Map;

public class BuildingRepo {
    Map<String, Building> buildingMap = new HashMap<>();

    public void save(Building b) {
        buildingMap.put(b.getBuildingId(), b);
    }

    public Building getBuilding(String buildingId) {
        return buildingMap.get(buildingId);
    }
}
