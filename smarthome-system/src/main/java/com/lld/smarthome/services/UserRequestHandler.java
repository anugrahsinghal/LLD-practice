package com.lld.smarthome.services;

import com.lld.smarthome.models.InterfaceDevice;
import com.lld.smarthome.models.SmartHomeDevice;
import com.lld.smarthome.repos.Home;
import com.lld.smarthome.repos.SmartHomeDeviceRepo;
import com.lld.smarthome.services.request.UserRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRequestHandler implements CommandHandler<UserRequest> {

  private final SmartHomeDeviceRepo smartHomeDeviceRepo;
  private final Home home;

  @Override
  public void handle(UserRequest req) {
    final InterfaceDevice interfaceDevice = home.getByKeyword(req.activation());
    if (interfaceDevice == null) {
      // get a default interface device
      System.out.println("Invalid input");
      return;
    }
    final SmartHomeDevice smartHomeDevice = smartHomeDeviceRepo.getByKeyword(req.name(), req.location());
    if (smartHomeDevice == null) {
      System.out.println("Invalid input");
      return;
    }

    // validate id has shd
    // if yes then execute command
    if (!interfaceDevice.hasConnected(smartHomeDevice)) {
      System.out.println("Invalid input");
      return;
    }

    smartHomeDevice.executeCommand(req.commandValue());

  }

}


