package com.lld.smarthome.repos;


import com.lld.smarthome.models.InterfaceDevice;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Home {
  Map<String, InterfaceDevice> interfaceDevices = new HashMap<>();

  public void save(InterfaceDevice id) {
    interfaceDevices.put(id.getActivation(), id);
  }

  public InterfaceDevice getByKeyword(String id) {
    return interfaceDevices.get(id);
  }
  
  public Collection<InterfaceDevice> all() {
    return interfaceDevices.values();
  }
}
