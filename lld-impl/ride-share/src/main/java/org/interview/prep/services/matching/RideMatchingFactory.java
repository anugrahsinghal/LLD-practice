package org.interview.prep.services.matching;

import java.util.List;
import java.util.Map;
import org.interview.prep.models.Ride;
import org.interview.prep.models.SRC_DEST;
import org.interview.prep.models.User;
import org.interview.prep.models.VehicleSeat;

public class RideMatchingFactory {

	public static final String MOST_VACANT = "Most Vacant";

	public static Ride selectRide(String src, String dest, int numSeats, String selection,
	                              Map<String, User> userMap, Map<SRC_DEST, List<VehicleSeat>> rideOfferings) {
		RideMatchingStrategy rideMatchingStrategy;
		if (selection.equals(MOST_VACANT)) {
			rideMatchingStrategy = new MostVacantMatching();
			return rideMatchingStrategy.selectRide(src, dest, numSeats, selection, userMap, rideOfferings);
		} else {
			rideMatchingStrategy = new VehicleMatchingStrategy();
			return rideMatchingStrategy.selectRide(src, dest, numSeats, selection, userMap, rideOfferings);
		}
	}

}
