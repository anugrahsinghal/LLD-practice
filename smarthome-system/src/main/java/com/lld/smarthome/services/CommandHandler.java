package com.lld.smarthome.services;

public interface CommandHandler<T> {
  void handle(T t);
}


