package com.lld.smarthome.services;

import com.lld.smarthome.models.InterfaceDevice;
import com.lld.smarthome.repos.Home;
import com.lld.smarthome.services.request.PrintDevicesRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PrintDevices implements CommandHandler<PrintDevicesRequest> {

  private final Home home;

  @Override
  public void handle(PrintDevicesRequest req) {
    final InterfaceDevice interfaceDevice = home.getByKeyword(req.activation());
    if (interfaceDevice == null) {
      // get a default interface device
      System.out.println("Invalid input");
      return;
    }

    System.out.println("interfaceDevice.getByLocation(req.location()) = " +
        interfaceDevice.getByLocation(req.location()));
  }

}
