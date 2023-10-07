package org.interview.prep.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.interview.prep.models.Ride;
import org.interview.prep.models.RideOffering;
import org.interview.prep.models.RideStatistics;
import org.interview.prep.models.SRC_DEST;
import org.interview.prep.models.User;
import org.interview.prep.models.VehicleSeat;

@ToString
@Getter
@RequiredArgsConstructor
public class RideManagerImplV2 implements RideManager {

	private final Map<SRC_DEST, List<RideOffering>> rideOfferings;
	private final UserManager userManager;
	private final Map<User, RideStatistics> rideStatistics;

	/*
	* RIDE_ID - Ride_offered_details // ride id is unique
	* Vehicle - offered
	* Vehicle - occupied
	*
	* */



	@Override
	public Ride selectRide(String src, String dest, int numSeats, String selection) {
		return null;
	}

	@Override
	public String offerRide(String userName, String src, String dest, String vehicleName, String registrationNumber, int availableSeats) {
		return null;
	}

	@Override
	public boolean endRide(Ride ride) {
		return false;
	}

	@Override
	public Map<String, RideStatistics> getStats() {
		return null;
	}
}
