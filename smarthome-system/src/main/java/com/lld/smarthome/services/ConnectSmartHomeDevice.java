package com.lld.smarthome.services;

import com.lld.smarthome.models.InterfaceDevice;
import com.lld.smarthome.models.SmartHomeDevice;
import com.lld.smarthome.repos.Home;
import com.lld.smarthome.repos.SmartHomeDeviceRepo;
import com.lld.smarthome.services.request.ConnectSmartHomeDeviceRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectSmartHomeDevice implements CommandHandler<ConnectSmartHomeDeviceRequest> {

  private final SmartHomeDeviceRepo smartHomeDeviceRepo;
  private final Home home;

  @Override
  public void handle(ConnectSmartHomeDeviceRequest req) {
    final InterfaceDevice interfaceDevice = home.getByKeyword(req.activation());
    if (interfaceDevice == null) {
      // get a default interface device
      System.out.println("Invalid input");
      return;
    }
    final SmartHomeDevice smartHomeDevice = smartHomeDeviceRepo.getByKeyword(req.deviceName(), req.location());
    if (smartHomeDevice == null) {
      System.out.println("Invalid input");
      return;
    }
    interfaceDevice.addSmartHomeDevice(smartHomeDevice);
    System.out.println("Connected");

  }

}
