package org.interview.prep.v2.models.services.matching;

import java.util.List;
import java.util.Map;
import org.interview.prep.models.SRC_DEST;
import org.interview.prep.services.UserManager;
import org.interview.prep.v2.models.OfferRide;
import org.interview.prep.v2.models.SelectRide;

public class RideMatchingFactory {

	public static OfferRide matchRide(SelectRide rideDetail, Map<SRC_DEST, List<OfferRide>> offeredRides, UserManager userManager) {
		final RideMatchingStrategy matchingStrategy;
		if (rideDetail.getSelectionStrategy().equalsIgnoreCase("MOST VACANT")) {
			matchingStrategy = new MostVacantMatchingStrategy();
			return matchingStrategy.matchRide(rideDetail, offeredRides, userManager);
		} else {
			matchingStrategy = new PreferredVehicleMatchingStrategy();
			return matchingStrategy.matchRide(rideDetail, offeredRides, userManager);
		}
	}


}
