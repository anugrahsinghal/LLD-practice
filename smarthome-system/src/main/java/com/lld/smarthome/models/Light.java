package com.lld.smarthome.models;

import com.lld.smarthome.models.behaviours.ChangeColors;
import com.lld.smarthome.models.behaviours.GenericDevice;
import com.lld.smarthome.models.behaviours.LevelTunable;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.function.Function;

@AllArgsConstructor
public class Light extends SmartHomeDevice implements GenericDevice, LevelTunable, ChangeColors {

  private int currentBrightness;
  private Color color;

  public Light(String name, String location) {
    super(name, location);
    currentBrightness = 0;
    this.color = null;
  }

  @Override
  public void turnOn() {
    currentBrightness = 5;
    this.color = Color.WHITE;
    System.out.println("on");
  }

  @Override
  public void turnOff() {
    currentBrightness = 0;
    this.color = null;
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
        },
        "white", s -> {
          setColor(Color.WHITE);
          return "";
        },
        "red", s -> {
          setColor(Color.RED);
          return "";
        },
        "blue", s -> {
          setColor(Color.BLUE);
          return "";
        },
        "green", s -> {
          setColor(Color.GREEN);
          return "";
        }
    );
  }

  @Override
  public void increase() {
    if (currentBrightness != max()) {
      currentBrightness++;
      System.out.println("Increase Brightness");
    } else {
      System.out.println("Sorry");
    }
  }

  @Override
  public void decrease() {
    if (currentBrightness != min()) {
      currentBrightness--;
      System.out.println("Deccrease Brightness");
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

  @Override
  public void setColor(Color color) {
    this.color = color;
    System.out.println("change to " + this.color);
  }

}
