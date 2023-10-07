package com.example.room.management.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookingRequest {
    private String buildingId;
    private String floorId;
    private String conferenceRoomId;
    private String userId;
    private int startBlock;
    private int endBlock;
}
