package com.example.room.management;

import com.example.room.management.handlers.*;
import com.example.room.management.request.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommandProcessor {
    private final AddBuildingRequestHandler addBuildingRequestHandler;
    private final AddFloorRequestHandler addFloorRequestHandler;
    private final AddConferenceRoomRequestHandler addConferenceRoomRequestHandler;
    private final BookingRequestHandler bookingRequestHandler;
    private final CancelBookingRequestHandler cancelBookingRequestHandler;
    private final ListBookingRequestHandler listBookingRequestHandler;

    public void process(Object request) {

        if (request instanceof AddBuildingRequest) {
            addBuildingRequestHandler.handleRequest((AddBuildingRequest) request);
        } else if (request instanceof AddFloorRequest) {
            addFloorRequestHandler.handleRequest((AddFloorRequest) request);
        } else if (request instanceof AddConferenceRoomRequest) {
            addConferenceRoomRequestHandler.handleRequest((AddConferenceRoomRequest) request);
        } else if (request instanceof BookingRequest) {
            bookingRequestHandler.handleRequest((BookingRequest) request);
        } else if (request instanceof CancelBookingRequest) {
            cancelBookingRequestHandler.handleRequest((CancelBookingRequest) request);
        } else if (request instanceof ListBookingRequest) {
            listBookingRequestHandler.handleRequest((ListBookingRequest) request);
        }
//        else if (request instanceof SuggestRequest) {
//            suggestRequestHandler.handleRequest((SuggestRequest) request);
//        }

    }
}

