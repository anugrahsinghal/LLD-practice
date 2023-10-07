package com.example.room.management.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Floor {
    private String floorId;
    private List<ConferenceRoom> conferenceRooms;

    public ConferenceRoom addConferenceRoom(String conferenceRoomId) {
        final ConferenceRoom conferenceRoom = new ConferenceRoom(conferenceRoomId);
        conferenceRooms.add(conferenceRoom);
        return conferenceRoom;
    }
}
