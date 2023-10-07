package com.lld.smarthome.services.request;

public record DisconnectSmartHomeDeviceRequest(
    String activation,
    String deviceName,
    String location
) {
}
