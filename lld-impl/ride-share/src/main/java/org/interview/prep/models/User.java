package org.interview.prep.models;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class User {

	private final String name;
	private final Gender gender;
	private final int age;
	private List<Vehicle> vehicles;

	public boolean addVehicle(Vehicle vehicle) {
		if (vehicles == null) {
			vehicles = new ArrayList<>();
		}
		return vehicles.add(vehicle);
	}

}
