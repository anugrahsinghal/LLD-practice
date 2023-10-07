package com.lld.smarthome.repos;


import com.lld.smarthome.models.SmartHomeDevice;

import java.util.HashMap;
import java.util.Map;

public class SmartHomeDeviceRepo {
  Map<String, SmartHomeDevice> shDevice = new HashMap<>();

  public void save(SmartHomeDevice sh) {
    shDevice.put(sh.getName() + "--" + sh.getLocation(), sh);
  }

  public SmartHomeDevice getByKeyword(String name, String location) {
    return shDevice.get(name + "--" + location);
  }

}
