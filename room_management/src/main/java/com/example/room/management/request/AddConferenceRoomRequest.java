package com.example.room.management.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddConferenceRoomRequest {
    private String conferenceRoomName;
    private String floorId;
    private String buildingId;
}
