package com.lld.smarthome.services.request;

public record PrintDevicesRequest(
    String activation,
    String location
) {
}
