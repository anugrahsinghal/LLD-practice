package com.example.room.management.handlers;

import com.example.room.management.RequestHandler;
import com.example.room.management.repo.BookingRepo;
import com.example.room.management.request.ListBookingRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ListBookingRequestHandler implements RequestHandler<ListBookingRequest> {
    private final BookingRepo bookingRepo;

    @Override
    public void handleRequest(ListBookingRequest request) {
        System.out.println("bookingRepo.listBooking(request.getUserId()) = \n\n" + bookingRepo.listBooking(request.getUserId()));
    }
}
