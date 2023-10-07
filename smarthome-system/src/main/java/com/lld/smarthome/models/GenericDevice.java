package com.lld.smarthome.models;

import com.lld.smarthome.models.behaviours.SupportedCommands;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.function.Function;

@AllArgsConstructor
public class GenericDevice extends SmartHomeDevice implements com.lld.smarthome.models.behaviours.GenericDevice, SupportedCommands {

  public GenericDevice(String name, String location) {
    super(name, location);
  }

  @Override
  public void turnOn() {
    System.out.println("on");
  }

  @Override
  public void turnOff() {
    System.out.println("off");
  }

  @Override
  public Map<String, Function<String, String>> commands() {
    return Map.of(
        "on", s -> {
          turnOn();
          return "";
        },
        "off", s -> {
          turnOff();
          return "";
        }
    );
  }
}
