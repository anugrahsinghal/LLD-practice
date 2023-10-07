package com.example.room.management.repo;

import lombok.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BookingRepo {
    // BOOK 1:5 b1 7 C1
    // B1 - 7th floor - room c1
    // book from 1-5

    Map<ConfRoomId, String[]> confRoomBookingForUserMap = new HashMap<>();
    // we keep hourly log

    public boolean roomExists(String buildingId,
                              String floorId,
                              String conferenceRoomId) {
        final ConfRoomId key = new ConfRoomId(buildingId, floorId, conferenceRoomId);
        return confRoomBookingForUserMap.containsKey(key);
    }

    public boolean allSlotsEmpty(String buildingId,
                                 String floorId,
                                 String conferenceRoomId,
                                 int startBlock, int endBlock) {
        final ConfRoomId key = new ConfRoomId(buildingId, floorId, conferenceRoomId);
        final String[] slots = confRoomBookingForUserMap.get(key);
        return IntStream.range(startBlock, endBlock + 1)
                .allMatch(time -> slots[time].isEmpty());
    }

    public boolean anySlotsNotBookedByUser(String buildingId,
                                           String floorId,
                                           String conferenceRoomId,
                                           String userId,
                                           int startBlock, int endBlock) {
        final ConfRoomId key = new ConfRoomId(buildingId, floorId, conferenceRoomId);
        final String[] slots = confRoomBookingForUserMap.get(key);
        return IntStream.range(startBlock, endBlock + 1)
                .anyMatch(time -> !slots[time].equals(userId));
    }


    public void bookRoom(String buildingId,
                         String floorId,
                         String conferenceRoomId,
                         String userId,
                         int startBlock, int endBlock) {
        final ConfRoomId key = new ConfRoomId(buildingId, floorId, conferenceRoomId);
        if (!confRoomBookingForUserMap.containsKey(key)) {
            throw new RuntimeException("room do not exist");
        }
        final String[] slots = confRoomBookingForUserMap.get(key);
        if (!allSlotsEmpty(buildingId, floorId, conferenceRoomId, startBlock, endBlock)) {
            System.out.println("Cannot Book");
            return;
        }

        // book the slots
        IntStream.range(startBlock, endBlock + 1)
                .forEach(time -> slots[time] = userId);
    }

    public void addRoom(String buildingId, String floorId, String conferenceRoomId) {
        final ConfRoomId key = new ConfRoomId(buildingId, floorId, conferenceRoomId);
        if (confRoomBookingForUserMap.containsKey(key)) {
            throw new RuntimeException("Unexpected");
        }
        final String[] slots = new String[25];
        Arrays.fill(slots, "");
        slots[0] = "X";
        confRoomBookingForUserMap.put(key, slots);
    }

    public void cancelBooking(String buildingId,
                              String floorId,
                              String conferenceRoomId,
                              String userId,
                              int startBlock, int endBlock) {
        final ConfRoomId key = new ConfRoomId(buildingId, floorId, conferenceRoomId);
        if (!confRoomBookingForUserMap.containsKey(key)) {
            throw new RuntimeException("room do not exist");
        }
        final String[] bookedByUser = confRoomBookingForUserMap.get(key);
        final boolean anySlotsNotBookedByUser = IntStream.range(startBlock, endBlock + 1)
                .anyMatch(time -> !bookedByUser[time].equals(userId));
        if (anySlotsNotBookedByUser(buildingId, floorId, conferenceRoomId, userId, startBlock, endBlock)) {
            System.out.println("Cannot cancel for slots not bookedByUser " + userId);
            return;
        }

        // book by theUser
        // then clear booking
        IntStream.range(startBlock, endBlock + 1)
                .forEach(time -> bookedByUser[time] = "");
    }

    public Map<ConfRoomId, List<Range>> listBooking(String userId) {
        List<BookedSlot> bookedSlots = new ArrayList<>();
        for (Map.Entry<ConfRoomId, String[]> entry : confRoomBookingForUserMap.entrySet()) {
            ConfRoomId confRoomId = entry.getKey();
            String[] bookings = entry.getValue();
            for (int i = 1; i < bookings.length; i++) {
                if (bookings[i].equals(userId)) {
                    bookedSlots.add(new BookedSlot(confRoomId, i));
                }
            }
        }
        // apply merge intervals like technique
        final Map<ConfRoomId, List<BookedSlot>> confRoomBookingForUser = bookedSlots.stream()
                .collect(Collectors.groupingBy(it -> it.roomId));

        Map<ConfRoomId, List<Range>> confRoomBookingRange = new HashMap<>();
        for (Map.Entry<ConfRoomId, List<BookedSlot>> entry : confRoomBookingForUser.entrySet()) {
            ConfRoomId room = entry.getKey();
            confRoomBookingRange.put(room, new ArrayList<>());
            int[] slots = new int[25];
            List<BookedSlot> slotsList = entry.getValue();
            slotsList.forEach(i -> slots[i.slot] = 1);

            for (int i = 1; i < slots.length; i++) {
                Range range = null;
                if (slots[i] == 1) {// start of range
                    range = new Range(i, i);
                    range.end = i;
                    int j = i;
                    while (slots[j] == 1) {
                        range.end = j;
                        j++;
                    }
                    i = j;
                }
                if (range != null) {
                    confRoomBookingRange.get(room).add(range);
                }
            }

        }


        return confRoomBookingRange;
    }

    public record BookedSlot(ConfRoomId roomId, int slot) {
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    @NoArgsConstructor
    static final class Range {
        private int start;
        private int end;
    }

}

