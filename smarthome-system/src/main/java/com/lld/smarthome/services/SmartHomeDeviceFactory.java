package com.lld.smarthome.services;

import com.lld.smarthome.models.Fan;
import com.lld.smarthome.models.GenericDevice;
import com.lld.smarthome.models.Light;
import com.lld.smarthome.models.SmartHomeDevice;

public class SmartHomeDeviceFactory {

  public static SmartHomeDevice smartHomeDevice(String name, String location) {
    if (name.equalsIgnoreCase("FAN")) {
      return new Fan(name, location);
    } else if (name.equalsIgnoreCase("LIGHT")) {
      return new Light(name, location);
    } else {
      return new GenericDevice(name, location);
    }
  }

}
