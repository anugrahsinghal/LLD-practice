package com.example.room.management;

import com.example.room.management.request.*;

public class RequestFactory {

    public static final String TYPE_ADD_BUILDING = "ADD_BUILDING";
    public static final String TYPE_ADD_FLOOR = "ADD_FLOOR";
    public static final String TYPE_ADD_CONFROOM = "ADD_CONFROOM";
    public static final String TYPE_BOOK = "BOOK";
    public static final String TYPE_CANCEL = "CANCEL";
    public static final String TYPE_LIST_BOOKING = "LIST_BOOKING";
    public static final String TYPE_SUGGEST = "SUGGEST";

    public static Object parseRequest(String[] input) {
        Object request;
        switch (input[0]) {
            case TYPE_ADD_BUILDING: {
                request = parse_TYPE_ADD_BUILDING(input);
                break;
            }
            case TYPE_ADD_FLOOR: {
                request = parse_TYPE_ADD_FLOOR(input);
                break;
            }
            case TYPE_ADD_CONFROOM: {
                request = parse_TYPE_ADD_CONFROOM(input);
                break;
            }
            case TYPE_BOOK: {
                request = parse_TYPE_BOOK(input);
                break;
            }
            case TYPE_CANCEL: {
                request = parse_TYPE_CANCEL(input);
                break;
            }
            case TYPE_LIST_BOOKING: {
                request = parse_TYPE_LIST_BOOKING(input);
                break;
            }
//            case TYPE_SUGGEST: {
//                request = parse_TYPE_SUGGEST(input);
//                break;
//            }
            default:
                throw new IllegalArgumentException("invalid  " + input[0]);
        }
        return request;
    }

    private static Object parse_TYPE_CANCEL(String[] input) {
        return null;
    }

    private static Object parse_TYPE_BOOK(String[] input) {
        final String[] split = input[1].split(":");
        final int start = Integer.parseInt(split[0]);
        final int end = Integer.parseInt(split[1]);
        return new BookingRequest(input[2], input[3], input[4],"DAVE", start, end);
    }

    private static Object parse_TYPE_LIST_BOOKING(String[] input) {
        return new ListBookingRequest("DAVE");
    }

//    private static Object parse_TYPE_SUGGEST(String[] input) {
//        return null;
//    }

    private static Object parse_TYPE_ADD_CONFROOM(String[] input) {
        return new AddConferenceRoomRequest(input[1], input[2], input[3]);
    }

    private static Object parse_TYPE_ADD_FLOOR(String[] input) {
        return new AddFloorRequest(input[1], Integer.parseInt(input[2]));
    }

    private static Object parse_TYPE_ADD_BUILDING(String[] input) {
        return new AddBuildingRequest();
    }

}
