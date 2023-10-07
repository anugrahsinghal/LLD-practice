package com.example.room.management.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddFloorRequest {

    private String buildingId;
    private int numFloors;
}
