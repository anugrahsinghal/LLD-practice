package com.lld.smarthome.models.behaviours;

public interface LevelTunable {
  void increase();

  void decrease();

  int min();

  int max();

}
