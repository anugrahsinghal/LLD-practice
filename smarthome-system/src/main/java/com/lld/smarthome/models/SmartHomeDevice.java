package com.lld.smarthome.models;

import com.lld.smarthome.models.behaviours.SupportedCommands;
import lombok.*;

import java.util.function.Function;

// SHD should be one of fan/light/generic

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class SmartHomeDevice implements SupportedCommands {
  private String name;
  private String location;

  public void executeCommand(String command) {
    final Function<String, String> commandExecutor = this.commands().get(command);
    if (commandExecutor == null) {
      System.out.println("Sorry");
      return;
    }
    commandExecutor.apply(command);
  }

}