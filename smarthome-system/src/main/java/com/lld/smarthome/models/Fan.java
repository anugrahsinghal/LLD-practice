package com.lld.smarthome.models;

import com.lld.smarthome.models.behaviours.GenericDevice;
import com.lld.smarthome.models.behaviours.LevelTunable;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.function.Function;

@AllArgsConstructor
public class Fan extends SmartHomeDevice implements GenericDevice, LevelTunable {

  private int currentSpeed;

  public Fan(String name, String location) {
    super(name, location);
    currentSpeed = 0;
  }

  @Override
  public void turnOn() {
    currentSpeed = 5;
    System.out.println("on");
  }

  @Override
  public void turnOff() {
    currentSpeed = 0;
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
        },

        "increase", s -> {
          increase();
          return "";
        },

        "decrease", s -> {
          decrease();
          return "";
        }
    );
  }

  @Override
  public void increase() {
    if (currentSpeed != max()) {
      currentSpeed++;
      System.out.println("Increase Speed");
    } else {
      System.out.println("Sorry");
    }
  }

  @Override
  public void decrease() {
    if (currentSpeed != min()) {
      currentSpeed--;
      System.out.println("Decrease Speed");
    } else {
      System.out.println("Sorry");
    }
  }

  @Override
  public int min() {
    return 1;
  }

  @Override
  public int max() {
    return 10;
  }
}
