package org.interview.prep.services;

import java.util.Map;
import org.interview.prep.models.Ride;
import org.interview.prep.models.RideStatistics;

public interface RideManager {

	Ride selectRide(String src, String dest, int numSeats, String selection);

	String offerRide(String userName, String src, String dest, String vehicleName, String registrationNumber, int availableSeats);

	boolean endRide(Ride ride);

	Map<String, RideStatistics> getStats();

}
