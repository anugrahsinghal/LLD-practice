package com.lld.smarthome.models.behaviours;

import java.util.Map;
import java.util.function.Function;

public interface SupportedCommands {
  Map<String, Function<String, String>> commands();
}
