package com.lld.smarthome.services;

import com.lld.smarthome.models.InterfaceDevice;
import com.lld.smarthome.repos.Home;
import com.lld.smarthome.repos.SmartHomeDeviceRepo;
import com.lld.smarthome.services.request.AddSmartHomeDeviceRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddSmartHomeDevice implements CommandHandler<AddSmartHomeDeviceRequest> {

  private final SmartHomeDeviceRepo smartHomeDeviceRepo;
  private final Home home;


  @Override
  public void handle(AddSmartHomeDeviceRequest req) {
    final InterfaceDevice interfaceDevice = home.getByKeyword(req.activation());
    if (interfaceDevice == null) {
      // get a default interface device
    }
    if (smartHomeDeviceRepo.getByKeyword(req.name(), req.location()) != null) {
      System.out.println("Invalid input");
      return;
    }

    // todo - add parser to create a SHD of specific type
    smartHomeDeviceRepo.save(SmartHomeDeviceFactory.smartHomeDevice(req.name(), req.location()));
    System.out.println("Added");
  }
}
