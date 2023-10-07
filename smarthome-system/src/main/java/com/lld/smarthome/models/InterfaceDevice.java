package com.lld.smarthome.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InterfaceDevice {
  private String name;
  private String location;
  private String activation;
  private List<SmartHomeDevice> smartHomeDevices;


  public List<SmartHomeDevice> getByLocation(String location) {
    return smartHomeDevices.stream().filter(it -> it.getLocation().equals(location)).toList();
  }

  public void addSmartHomeDevice(SmartHomeDevice s) {
    smartHomeDevices.add(s);
  }

  public void removeSmartHomeDevice(SmartHomeDevice s) {
    smartHomeDevices.remove(s);
  }

  public boolean hasConnected(SmartHomeDevice smartHomeDevice) {
    return smartHomeDevices.contains(smartHomeDevice);
  }
}

