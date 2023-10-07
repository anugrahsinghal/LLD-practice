# Room Management


One of the core problems which people face at every company is the unavailability of conference rooms. 
So we thought of building one conference room management system. The system should have the following features.

Assumptions:

Conference rooms are scattered across multiple buildings and multiple floors and each floor can have multiple conference rooms, 
but **each conference room should be uniquely identifiable**

Booking will be done for slots in hours. 
Hours will be taken in 24 hours format eg. 
**Book from 1am to 3am {1:3}, from 12pm to 1pm {12:13}**

Each conference room **can be booked given that no one has already booked for that slot**.

**User id should be mandatory for all operations.**

**Booking can be done for a maximum of 12 hours.**

Features:

Users should be able to list down **all the conference rooms available in any building**.
Eg:Alpha building has conference rooms with names: a1, a2, a3, a4 etc.

Users should be able to **find suitable rooms to book for a given slot**.

Users should be able to **cancel existing booking** and **rooms should be free to be booked again for that slot**.

List down **all the bookings by the given user**.

Commands:

NOTE: User ID is mandatory for the inputs.

## ADD BUILDING //Adds building in the system

Eg: ADD BUILDING

Output: Added building b1 into the system.

## ADD FLOOR

Eg. ADD FLOOR b1 2

## ADD CONFROOM

Eg: ADD CONFROOM c1 1 cb1

The above commands adds c1 conference room in first floor of building b1

Output: Added conference room c1 on first floor in b1

## BOOK

Books the given Conference room for a given slot, on the given floor of the building.

Eg: BOOK 1:5 b1 7 C1

## CANCEL

Cancels the slot booked for the floor in a given building.

## LIST BOOKING

Should list down all the bookings by user

Output format:

2:6 3 b1 c1

6:10 3 b1 c2

Bonus Questions/Features:

Existing search will return empty results if no rooms are available for a given slot. 
**Users want a suggestion functionality using which users can get a list of possible future slots [Size limit to 3] which can be booked.**

Eg. Assume no room is available for a slot then the search will return an empty result while SUGGEST command will return the next 3 suggestions.

## Command: SUGGEST 3:10

2.Unit tests and Logging.

Expectation

Code should be Demo-able and functionally complete.
Code should fail gracefully with a proper error message for corner/invalid cases, use exceptions for handling these cases.
Code should be modular, try thinking in terms of Object-Oriented Design.
Input can be taken from the command line or in the main function.
Do not use any database or NoSQL store, use in-memory data structure.
Do not create any UI for the application
Driver class can be designed as per your choice, but it should cover all the scenarios.
Please prioritize code compilation, execution, and completion.
Work on the expected output first and then only work on bonus features.