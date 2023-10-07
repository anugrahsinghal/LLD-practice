package org.interview.prep.v2.models.services.matching;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.interview.prep.models.SRC_DEST;
import org.interview.prep.services.UserManager;
import org.interview.prep.v2.models.OfferRide;
import org.interview.prep.v2.models.SelectRide;

public class PreferredVehicleMatchingStrategy implements RideMatchingStrategy {

	public static final RuntimeException NO_RIDE = new RuntimeException("NO RIDE");

	@Override
	public OfferRide matchRide(SelectRide rideDetail, Map<SRC_DEST, List<OfferRide>> offeredRides, UserManager userManager) {

		final List<OfferRide> availableRides = offeredRides.get(new SRC_DEST(rideDetail.getSource(), rideDetail.getDestination()));

		if (availableRides != null && !availableRides.isEmpty()) {

			final String preferredVehicle = rideDetail.getSelectionStrategy().split("=")[1];

			OfferRide preferredRide = getFirstAvailablePreferredRide(rideDetail, availableRides, preferredVehicle);

			if (preferredRide == null) {
				throw NO_RIDE;
			}
			// original DS will be modified
			availableRides.remove(preferredRide);

			return preferredRide;
		} else {
			throw NO_RIDE;
		}

	}

	private OfferRide getFirstAvailablePreferredRide(SelectRide rideDetail, List<OfferRide> availableRides, String preferredVehicle) {
		final List<OfferRide> preferredRides = availableRides.stream()
				.filter(offerRide -> offerRide.getVehicle().equals(preferredVehicle))
				.collect(Collectors.toList());

		OfferRide preferredRide = null;
		for (OfferRide ride : preferredRides) {
			if (ride.getSeats() >= rideDetail.getSeats()) {
				preferredRide = ride;
				break;
			}
		}
		return preferredRide;
	}

}
