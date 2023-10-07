package org.interview.prep.v2.models.services;

import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.interview.prep.models.RideStatistics;

@Getter
@RequiredArgsConstructor
public class RideStatsServiceImpl implements RideStatsService {

	private final Map<String, RideStatistics> rideStatistics;

	@Override
	public Map<String, RideStatistics> getStats() {
		return rideStatistics;
	}

	@Override
	public void updateStats(String userName, String type) {
		if (type.equalsIgnoreCase("TAKEN")) {
			updateRidesTakenStats(userName);
		} else {
			updateRidesOfferedStats(userName);
		}
	}

	@Override
	public void addUser(String userName) {
		rideStatistics.put(userName, new RideStatistics());
	}

	private void updateRidesOfferedStats(String userName) {
		final RideStatistics ridestats = rideStatistics.getOrDefault(userName, new RideStatistics());
		ridestats.rideOffered();
		rideStatistics.put(userName, ridestats);
	}

	private void updateRidesTakenStats(String userName) {
		final RideStatistics ridestats = rideStatistics.getOrDefault(userName, new RideStatistics());
		ridestats.rideTaken();
		rideStatistics.put(userName, ridestats);
	}

}
