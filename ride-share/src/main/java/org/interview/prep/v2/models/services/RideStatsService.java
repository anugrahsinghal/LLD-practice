package org.interview.prep.v2.models.services;

import java.util.Map;
import org.interview.prep.models.RideStatistics;

public interface RideStatsService {

	Map<String, RideStatistics> getStats();

	void updateStats(String userName, String type);

	void addUser(String userName);

}
