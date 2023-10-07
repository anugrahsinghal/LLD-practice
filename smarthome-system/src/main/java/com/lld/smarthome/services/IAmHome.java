package com.lld.smarthome.services;

import com.lld.smarthome.repos.Home;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IAmHome implements CommandHandler<Object> {

  private final Home home;

  @Override
  public void handle(Object ignore) {
    home.all().forEach(id -> id.getSmartHomeDevices().forEach(shd -> shd.executeCommand("on")));
  }
}
