package org.interview.prep.services.matching;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.interview.prep.models.Ride;
import org.interview.prep.models.SRC_DEST;
import org.interview.prep.models.User;
import org.interview.prep.models.Vehicle;
import org.interview.prep.models.VehicleSeat;

public class VehicleMatchingStrategy implements RideMatchingStrategy {

	@Override
	public Ride selectRide(String src, String dest, int numSeats, String selection,
	                       Map<String, User> userMap, Map<SRC_DEST, List<VehicleSeat>> rideOfferings) {
		Optional<SRC_DEST> ride = findRide(src, dest, rideOfferings);
		if (ride.isPresent()) {
			final List<VehicleSeat> rides = rideOfferings.get(ride.get());
			String preferredVehicle = selection.split("=")[1];
			if (rides != null && !rides.isEmpty()) {
				final Optional<VehicleSeat> rideShareOpt = rides.stream()
						.filter(r -> r.getVehicle().getVehicleType().equals(preferredVehicle))
						.findFirst();
				if (rideShareOpt.isPresent() && rideShareOpt.get().getCount() >= numSeats) {
					final VehicleSeat rideShare = rideShareOpt.get();
					final Vehicle vehicle = rideShare.getVehicle();
					final User owner = findOwner(vehicle, userMap);
					rideShare.setCount(rideShare.getCount() - numSeats);

					return new Ride(owner, numSeats, vehicle, ride.get());
				} else {
					throw new IllegalArgumentException("NO RIDE AVAILABLE");
				}

			} else {
				throw new IllegalArgumentException("NO RIDE AVAILABLE");
			}

		} else {
			throw new IllegalArgumentException("NO RIDE AVAILABLE");
		}
	}

	private Optional<SRC_DEST> findRide(String src, String dest, Map<SRC_DEST, List<VehicleSeat>> rideOfferings) {
		return rideOfferings.keySet().stream()
				.filter(ride -> ride.getSrc().equals(src) && ride.getDest().equals(dest))
				.findFirst();
	}

	User findOwner(Vehicle vehicle, Map<String, User> userMap) {
		for (User value : userMap.values()) {
			final Optional<Vehicle> any = value.getVehicles().stream()
					.filter(vehicle1 -> vehicle1.equals(vehicle))
					.findAny();
			if (any.isPresent()) {
				return value;
			}
		}

		throw new IllegalStateException("NOT HAVE OCCURED");
	}

}
