
package com.example.room.management.repo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
class ConfRoomId {
    String buildingId;
    String floorId;
    String conferenceRoomId;

    @Override
    public String toString() {
        return buildingId + "-" + floorId + "-" + conferenceRoomId;
    }
}