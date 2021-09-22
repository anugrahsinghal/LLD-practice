package org.interview.prep.v2.models.services.matching;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.interview.prep.models.SRC_DEST;
import org.interview.prep.services.UserManager;
import org.interview.prep.v2.models.OfferRide;
import org.interview.prep.v2.models.RideDetail;
import org.interview.prep.v2.models.SelectRide;

public class MostVacantMatchingStrategy implements RideMatchingStrategy {

	public static final RuntimeException NO_RIDE = new RuntimeException("NO RIDE");

	@Override
	public OfferRide matchRide(SelectRide rideDetail, Map<SRC_DEST, List<OfferRide>> offeredRides, UserManager userManager) {

		final List<OfferRide> availableRides = offeredRides.get(new SRC_DEST(rideDetail.getSource(), rideDetail.getDestination()));

		if (availableRides != null && !availableRides.isEmpty()) {

			availableRides.sort(Comparator.comparing(RideDetail::getSeats).reversed()); // decreasing order

			final OfferRide firstRide = availableRides.get(0);
			if (firstRide.getSeats() < rideDetail.getSeats()) {
				throw NO_RIDE;
			}

			// original DS will be modified
			availableRides.remove(firstRide);

			return firstRide;
		} else {
			throw NO_RIDE;
		}

	}
}
