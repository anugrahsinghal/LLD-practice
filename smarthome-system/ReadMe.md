Smart Home

Description
To build an IoT-based Home Automation System

Home Features:
● An Interface device  - device
    ○ Google Home
    ○ Alexa
    ○ More can be added

● A SmartHome device - device
    ○ Generic Electrical Devices
    ■ Can be turned on and off

○ Lights - device
    ■ Can be turned on and off
    ■ Brightness can be changed between a level of 1 to 10 if turned on
    ■ Color can be set only 4 [White, Red, Blue, Green] if turned on

○ Fans - device
    ■ Can be turned on and off
    ■ Speed can be controlled between a level of 1 to 5 if turned on

○ More can be added

● A home can have 1 or more Interface devices
● A home can have 1 or more SmartHome devices
● 1 SmartHome device can be connected to 1 or more interfaces.

Requirement
● Add 1 or more Interface Devices
● Add 1 or more SmartHome Devices with a default Interface Device they are connected to


● User should be able to send a command to any SmartHome device via a Connected Interface device by using 

Activation Keyword(Ex: “OK Google”)

● SmartHome device can respond to the command as follows:
    ○ Can only accept a valid command (described above) and change its internal state - >>
    ○ Can reject an invalid command with appropriate message to the interface device - >>
    ● Interface device should provide all connected devices and their status - >>
    ● User should be able to connect or disconnect a SmartHome device to an interface device. - >>

● User should be able to give special commands[Details listed below]
Command Definition

// done
● Add_interface_device
    ○ Interface name
    ○ Location
    ○ Activation Keyword (unique)
    ○ Output=>Added/Invalid Input
● Add_smarthome_device (name + location -> unique)
    ○ Activation Keyword (of default interface or it could be null if its not needed to be added to any interface)
    ○ SmartHome device name
    ○ Location
    ○ Output=>Added/Invalid Input
● Give_command
    ○ Activation Keyword
    ○ Device name
    ○ Device Location
    ○ Device Command Value
    ○ Output=>OK, <Command Description>/Sorry, <Invalid Command Description> 
● Print_connected_device
    ○ Activation Keyword
    ○ Location
    ○ Output=>List<SmartHome device Name, SmartHome device Location, Status>
● Connect_SmartHome_device
    ○ Activation Keyword
    ○ SmartHome device name
    ○ SmartHome device Location
    ○ Output=>Connected/Invalid Input
● Disconnect_SmartHome_device
    ○ Activation Keyword
    ○ SmartHome device name
    ○ SmartHome device Location
    ○ Output=>Disconnected/Invalid Input

Bonus :
Implement below command :
● Give_special_command
○ Activation Keyword
○ Commands
■ “I am home”=>Switch ON all SmartHome devices
■ “Leaving home”=>Switch OFF all SmartHome devices
■ “Good Night”=>Switch OFF all Lights

Guidelines:
1. Do not use any database or NoSQL store, use in-memory data-structure for now.
2. Do not create any UI or API’s for the application.
3. Input can be read from a file or STDIN or coded in a driver method.
4. Output can be written to a file or STDOUT.
5. Please prioritize code compilation, execution and completion.
6. Work on the expected output first and then add good-to-have features of your own. 7. Code should be in Java only.
8. Input and output format

Expectations:
1. Make sure that you have working and demonstrable code.
2. Make sure that code is functionally correct.
3. Code should be modular and readable.
4. Separation of concern should be addressed.
5. Code should easily accommodate new requirements with minimal changes.
6. Code should be easily testable.

Example commands:
1. add_interface_device(“Google Home”, “Living Room”, “OK Google’”)->Added ->
2. add_interface_device(“Alexa”,”Drawing Room”, “Alexa’”)->Added
3. add_smarthome_device(”Alexa”,“Light”,”Drawing Room”)->Added
4. add_smarthome_device(“OK Google”,“Fan“,“Living Room”)->Added
5. add_smarthome_device(null,“Smart Charger”, null,)->Added
6. connect_smarthome_device(“Alexa”,“Smart Charger”, null,)->Ok, connected
7. give_command(“Alexa”,“Light”,”Drawing Room”,”ON”) -> OK, Drawing Room Light Turned On
8. give_command(“Alexa”,”RGB Light”,” Drawing Room”,”ON”) -> Sorry, Drawing Room RGB Light Not found
9. give_command(“OK Google”,“Fan”,”Living Room”,”ON”) -> OK, Living Room Fan turned on
10. give_command(“OK Google”,“Fan”,”Living Room”,”5”) -> OK, Living Room Fan speed set to 5
11. give_command(“OK Google”,“Fan”,”Living Room”,”7”) -> Sorry, Cannot set Living Room Fan speed to 7 (outside the predefined range of 1 - 5)
12. give_command(“Alexa”,”Light”,”Drawing Room”,”8”) -> OK, Drawing Room Light Brightness set to 8
13. give_command(“Alexa”,”Smart Charger”,null,”ON”) -> OK, Smart Charger turned on
14. give_command(“Alexa”,”Smart Charger”,null,”OFF”) -> OK, Smart Charger turned off
15. give_command(“OK Google”,”Fan”,”Living Room”,”OFF”) -> OK, Living Room Fan turned off
16. give_command(“OK Google”,”Fan”,”Living Room”,”3”) -> Sorry, Living Room Fan is not turned on
17. print_connected_device(“Alexa”,”Drawing Room”)
    1 Drawing Room Light ON
    2 Smart Charger OFF
18. give_special_command(“OK Google”,”I am home”) -> OK, Switching on everything

Example commands:
1. add_interface_device(“Google Home”, “Living Room”, “OK Google’”)->Added
2. add_interface_device(“Alexa”,”Drawing Room”, “Alexa’”)->Added
3. add_interface_device(“Alexa”,”Kitchen”, “Alexa’”)->Added
4. add_smarthome_device(”Alexa”,“Light”,”Drawing Room”)->Added
5. add_smarthome_device(”Alexa”,“Light”,”Kitchen”)->Added
6. add_smarthome_device(“OK Google”,“Fan“,“Living Room”)->Added
7. add_smarthome_device(”Alexa”,“Smart Charger”, null,)->Added
8. add_smarthome_device(”Alexa”,“Chimney”,”Kitchen”)->Added
9. give_command(“Alexa”,“Light”,”Drawing Room”,”ON”) -> OK, Drawing Room Light Turned On
10. give_command(“Alexa”,”Light”,”Drawing Room”,”Black”) -> Sorry, Drawing Room Light can not be set to Black.
11. give_command(“Alexa”,”RGB Light”,” Drawing Room”,”ON”) -> Sorry, Drawing Room RGB Light Not found
12. give_command(“OK Google”,“Fan”,”Living Room”,”ON”) -> OK, Living Room Fan turned on
13. give_command(“OK Google”,“Fan”,”Living Room”,”5”) -> OK, Living Room Fan speed set to 5
14. give_command(“OK Google”,“Fan”,”Living Room”,”7”) -> Sorry, Cannot set Living Room Fan speed to 7 (outside the predefined range of 1 - 5)
15. give_command(“Alexa”,”Light”,”Drawing Room”,”8”) -> OK, Drawing Room Light Brightness set to 8
16. give_command(“Alexa”,“Light”,”Kitchen”,”ON”) -> OK, Kitchen Light Turned On
17. give_command(“Alexa”,”Light”,”Kitchen”,”White”) -> Ok, Kitchen Light is set to White
18. give_command(“Alexa”,“Chimney”,”Kitchen”,”ON”) -> OK, Kitchen Chimney Turned On
19. give_command(“Alexa”,”Smart Charger”,null,”ON”) -> OK, Smart Charger turned on
20. give_command(“Alexa”,”Smart Charger”,null,”OFF”) -> OK, Smart Charger turned off
21. give_command(“Alexa”,“Light”,”Kitchen”,”OFF”) -> OK, Kitchen Light Turned Off
22. give_command(“OK Google”,”Fan”,”Living Room”,”OFF”) -> OK, Living Room Fan turned off
23. give_command(“OK Google”,”Fan”,”Living Room”,”3”) -> Sorry, Living Room Fan is not turned on
24. print_connected_device(“Alexa”,”Drawing Room”)
    1 Drawing Room Light ON
    2 Smart Charger OFF
25. print_connected_device(“Alexa”,”Kitchen”)
    1 Chimney ON
    2 Light OFF
26. disconnect_smarthome_device(“Alexa”, “Kitchen”, “Chimney”) -> OK, Kitchen Chimney disconnected
27. give_special_command(“OK Google”,”I am home”) -> OK, Switching on everything 