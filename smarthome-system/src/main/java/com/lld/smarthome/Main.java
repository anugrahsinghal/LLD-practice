package com.lld.smarthome;

import com.lld.smarthome.repos.Home;
import com.lld.smarthome.repos.SmartHomeDeviceRepo;
import com.lld.smarthome.services.request.AddInterfaceDeviceRequest;
import com.lld.smarthome.services.request.AddSmartHomeDeviceRequest;
import com.lld.smarthome.services.request.ConnectSmartHomeDeviceRequest;
import com.lld.smarthome.services.request.UserRequest;
import com.lld.smarthome.services.*;

public class Main {

  public static void main(String[] args) throws Exception {
//    final String fileName = args[0];
    var home = new Home();
    var smartHomeDeviceRepo = new SmartHomeDeviceRepo();

    var addInterfaceDevice = new AddInterfaceDevice(home);
    var addSHDevice = new AddSmartHomeDevice(smartHomeDeviceRepo, home);
    var connectSHDHandler = new ConnectSmartHomeDevice(smartHomeDeviceRepo, home);
    var disConnectSHDHandler = new DisconnectSmartHomeDevice(smartHomeDeviceRepo, home);
    var printDeviceHandler = new PrintDevices(home);
    var userCommandHandler = new UserRequestHandler(smartHomeDeviceRepo, home);

    var iamhome = new IAmHome(home);
    var leavingHOme = new LeavingHome(home);
    var goodNight = new GoodNight(home);

    addInterfaceDevice.handle(new AddInterfaceDeviceRequest("alexa","abc","alexa!"));

    addSHDevice.handle(new AddSmartHomeDeviceRequest("fan","abc","alexa!"));
    addSHDevice.handle(new AddSmartHomeDeviceRequest("light","abc","alexa!"));
    addSHDevice.handle(new AddSmartHomeDeviceRequest("generic","abc","alexa!"));

    connectSHDHandler.handle(new ConnectSmartHomeDeviceRequest("alexa!", "fan","abc"));
    connectSHDHandler.handle(new ConnectSmartHomeDeviceRequest("alexa!", "light","abc"));
    connectSHDHandler.handle(new ConnectSmartHomeDeviceRequest("alexa!", "generic","abc"));

    System.out.println();
    iamhome.handle(null);
    leavingHOme.handle(null);

    System.out.println();
    System.out.println();

    iamhome.handle(null);
    goodNight.handle(null);

    userCommandHandler.handle(new UserRequest("alexa!", "light","abc", "green"));
  }

}