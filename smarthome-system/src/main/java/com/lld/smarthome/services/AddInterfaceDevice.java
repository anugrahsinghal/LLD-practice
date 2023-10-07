package com.lld.smarthome.services;

import com.lld.smarthome.models.InterfaceDevice;
import com.lld.smarthome.repos.Home;
import com.lld.smarthome.services.request.AddInterfaceDeviceRequest;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class AddInterfaceDevice implements CommandHandler<AddInterfaceDeviceRequest> {

  private final Home home;

  @Override
  public void handle(AddInterfaceDeviceRequest req) {
    if (home.getByKeyword(req.activation()) != null) {
      System.out.println("Invalid input");
      return;
    }
    home.save(new InterfaceDevice(req.name(), req.location(), req.activation(), new ArrayList<>()));
    System.out.println("Added");
  }
}
