package org.interview.prep.services;

import java.util.HashMap;
import java.util.Map;
import org.interview.prep.models.Gender;
import org.interview.prep.models.Ride;
import org.interview.prep.models.RideStatistics;
import org.interview.prep.v2.models.services.RideStatsServiceImpl;
import org.junit.jupiter.api.Test;

class RideManagerTest {

	@Test
	void test() {
		final UserManager userManager = new UserManagerImpl(new HashMap<>(), new RideStatsServiceImpl(new HashMap<>()));
		RideManager rideManager = new RideManagerImpl(new HashMap<>(), userManager, new HashMap<>());

		final String user1 = "USER1";
		userManager.addUser(user1, Gender.MALE, 20);
		final String user2 = "USER2";
		userManager.addUser(user2, Gender.MALE, 20);
		final String user3 = "USER3";
		userManager.addUser(user3, Gender.MALE, 20);
		final String user4 = "USER4";
		userManager.addUser(user4, Gender.MALE, 20);

		userManager.addVehicle(user1, "ACTIVA", "ABC");
		userManager.addVehicle(user1, "TAXI", "ABC1");
		userManager.addVehicle(user2, "XUV", "DEF");
		userManager.addVehicle(user3, "BALENO", "GHI");
		userManager.addVehicle(user4, "ACTIVA", "JKL");


		printStats(rideManager);

		rideManager.offerRide(user1, "A", "B", "ACTIVA", "ABC", 1);
		rideManager.offerRide(user1, "A", "B", "TAXI", "ABC1", 2);
		rideManager.offerRide(user2, "A", "B", "XUV", "DEF", 3);

		printStats(rideManager);

		System.out.println("userManager.getUserMap() = " + userManager.getUserMap());


		final Ride ride = rideManager.selectRide("A", "B", 2, "Most Vacant");
		System.out.println("ride = " + ride);
		final Ride ride1 = rideManager.selectRide("A", "B", 1, "A=XUV");
		System.out.println("ride1 = " + ride1);

		try {
			final Ride ride2 = rideManager.selectRide("A", "B", 1, "A=XUV");
			System.out.println("ride2 = " + ride2);
		} catch (Exception e) {
			System.out.println("e.getMessage() = " + e.getMessage());
		}

		rideManager.endRide(ride1);

		final Ride ride2 = rideManager.selectRide("A", "B", 1, "A=XUV");
		System.out.println("ride2 = " + ride2);


	}

	void printStats(RideManager manager) {
		final Map<String, RideStatistics> stats = manager.getStats();

		System.out.println("stats = " + stats);

	}

}
