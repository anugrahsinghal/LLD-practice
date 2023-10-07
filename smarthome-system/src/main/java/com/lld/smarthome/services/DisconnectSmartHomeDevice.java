package com.lld.smarthome.services;

import com.lld.smarthome.models.InterfaceDevice;
import com.lld.smarthome.models.SmartHomeDevice;
import com.lld.smarthome.repos.Home;
import com.lld.smarthome.repos.SmartHomeDeviceRepo;
import com.lld.smarthome.services.request.DisconnectSmartHomeDeviceRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DisconnectSmartHomeDevice implements CommandHandler<DisconnectSmartHomeDeviceRequest> {

  private final SmartHomeDeviceRepo smartHomeDeviceRepo;
  private final Home home;

  @Override
  public void handle(DisconnectSmartHomeDeviceRequest req) {
    final InterfaceDevice interfaceDevice = home.getByKeyword(req.activation());
    if (interfaceDevice == null) {
      // get a default interface device
      System.out.println("Invalid input");
      return;
    }
    final SmartHomeDevice smartHomeDevice = smartHomeDeviceRepo.getByKeyword(req.deviceName(), req.location());
    if (smartHomeDevice != null) {
      System.out.println("Invalid input");
      return;
    }

    interfaceDevice.removeSmartHomeDevice(smartHomeDevice);
    System.out.println("DisConnected");

  }

}
