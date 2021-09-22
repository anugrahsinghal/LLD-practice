package org.interview.prep.services.matching;

import java.util.List;
import java.util.Map;
import org.interview.prep.models.Ride;
import org.interview.prep.models.SRC_DEST;
import org.interview.prep.models.User;
import org.interview.prep.models.VehicleSeat;

public interface RideMatchingStrategy {
	/*@Override
	public Ride selectRide(String src, String dest, int numSeats, String selection) {
		return null;
	}*/

	Ride selectRide(String src, String dest, int numSeats, String selection, Map<String, User> userMap,
	                Map<SRC_DEST, List<VehicleSeat>> rideOfferings);

}
