package com.example.room.management.handlers;

import com.example.room.management.RequestHandler;
import com.example.room.management.repo.BookingRepo;
import com.example.room.management.request.CancelBookingRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CancelBookingRequestHandler implements RequestHandler<CancelBookingRequest> {
    private final BookingRepo bookingRepo;

    @Override
    public void handleRequest(CancelBookingRequest request) {

        if (!bookingRepo.roomExists(request.getBuildingId(), request.getFloorId(), request.getConferenceRoomId())) {
            System.out.println("invalid request - room does not exist");
            return;
        }
        if (!bookingRepo.anySlotsNotBookedByUser(request.getBuildingId(), request.getFloorId(), request.getConferenceRoomId(), request.getUserId(), request.getStartBlock(), request.getEndBlock())) {
            System.out.println("invalid request - slots are not empty");
            return;
        }
        bookingRepo.cancelBooking(request.getBuildingId(), request.getFloorId(), request.getConferenceRoomId(), request.getUserId(), request.getStartBlock(), request.getEndBlock());

    }
}
