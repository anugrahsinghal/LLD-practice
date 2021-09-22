package org.interview.prep.v2.models.services;

import org.interview.prep.v2.models.OfferRide;
import org.interview.prep.v2.models.SelectRide;

public interface RideManagerV2 {

	void offerRide(OfferRide rideDetail);

	void selectRide(SelectRide rideDetail);

	void endRide(OfferRide ride);

}
