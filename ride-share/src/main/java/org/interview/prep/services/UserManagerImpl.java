package org.interview.prep.services;

import java.util.Map;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.interview.prep.models.Gender;
import org.interview.prep.models.User;
import org.interview.prep.models.Vehicle;
import org.interview.prep.v2.models.services.RideStatsService;

@Getter
@RequiredArgsConstructor
public class UserManagerImpl implements UserManager {

	private final Map<String, User> userMap;
	private final RideStatsService rideStatsService;


	@Override
	public boolean addUser(@NonNull String name, @NonNull Gender gender, int age) {
		if (userMap.containsKey(name)) {
			throw new IllegalArgumentException("NO TWO USER WITH SAME NAME SUPPORTED");
		}
		final User user = userMap.put(name, new User(name, gender, age));

		rideStatsService.addUser(name);

		return user != null;
	}

	@Override
	public boolean addVehicle(@NonNull String ownerName, @NonNull String vehicleName, @NonNull String registrationNumber) {
		final User user = userMap.get(ownerName);
		if (user == null) {
			throw new IllegalArgumentException("NO USER FOUND");
		}

		return user.addVehicle(new Vehicle(vehicleName, registrationNumber));
	}

}
