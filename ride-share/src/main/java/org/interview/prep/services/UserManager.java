package org.interview.prep.services;

import java.util.Map;
import org.interview.prep.models.Gender;
import org.interview.prep.models.User;

public interface UserManager {

	boolean addUser(String name, Gender gender, int age);

	boolean addVehicle(String ownerName, String vehicleName, String registrationNumber);


	Map<String, User> getUserMap();

}
