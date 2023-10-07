package org.interview.prep.v2.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.interview.prep.models.SRC_DEST;
import org.interview.prep.models.User;
import org.interview.prep.models.Vehicle;
import org.interview.prep.services.UserManager;
import org.interview.prep.v2.models.OfferRide;
import org.interview.prep.v2.models.SelectRide;
import org.interview.prep.v2.models.services.matching.RideMatchingFactory;

@ToString
@Getter
@RequiredArgsConstructor
public class RideManagerV2Impl implements RideManagerV2 {

	private final RideStatsService rideStatsService;
	private final UserManager userManager;

	private final Map<SRC_DEST, List<OfferRide>> offeredRides;
	private final Map<OfferRide, String> rideToRideTaker;

	/*
	 *
	 * SRC_DEST - List<RideDetail> - live rides
	 * Set<RideDetail> - when ride is ended it is removed from this
	 * */

	@Override
	public void offerRide(OfferRide rideDetail) {
		// get User
		final User user = getUser(rideDetail.getUsername());
		// get Vehicle from user
		final Optional<Vehicle> vehicleOptional = findVehicle(user, rideDetail.getVehicle(), rideDetail.getVehicleNumber());
		if (!vehicleOptional.isPresent()) {
			// exception that no vehicle is there
			throw new IllegalStateException("NO VEHICLE");
		}
		final Vehicle vehicle = vehicleOptional.get();
		// validate not offered and not occupied
		if (!vehicle.isOffered() && !vehicle.isOccupied()) {
			// if both no then add to offeredRides
			addNewRide(rideDetail);

			updateVehicleStatus(
					rideDetail.getUsername(), rideDetail.getVehicle(),
					rideDetail.getVehicleNumber(), false, true
			);

			// update user stats
			rideStatsService.updateStats(user.getName(), "OFFERED");
		}

	}

	private void addNewRide(OfferRide rideDetail) {
		final SRC_DEST key = new SRC_DEST(rideDetail.getSource(), rideDetail.getDestination());
		List<OfferRide> ridesOnRoute = offeredRides.get(key);
		if (ridesOnRoute == null) {
			ridesOnRoute = new ArrayList<>();
		}
		ridesOnRoute.add(rideDetail);
		offeredRides.put(key, ridesOnRoute);
	}

	@Override
	public void selectRide(SelectRide rideDetail) {
		// Delegate to RideMatchingFactory
		/*
		 * Should match by selection Strategy
		 *
		 * should remove the ride from offeredRides
		 * */
		final OfferRide rideTaken = RideMatchingFactory.matchRide(rideDetail, offeredRides, userManager);

		// update vehicle as occupied
		updateVehicleAsOccupied(rideTaken.getUsername(), rideTaken.getVehicle(), rideTaken.getVehicleNumber());

		rideToRideTaker.put(rideTaken, rideDetail.getUsername());
	}

	@Override
	public void endRide(OfferRide rideDetail) {
		// remove from active rides if present
		if (rideToRideTaker.containsKey(rideDetail)) {
			final String user = rideToRideTaker.remove(rideDetail);
			// update vehicle status to not occupied
			updateVehicleStatus(rideDetail.getUsername(), rideDetail.getVehicle(),
					rideDetail.getVehicleNumber(), false, false);

			// update user stats for the ride taken
			rideStatsService.updateStats(user, "TAKEN");
		}
	}

	private User getUser(String owner) {
		final Map<String, User> userMap = userManager.getUserMap();
		final User user = userMap.get(owner);

		if (user == null) {
			throw new IllegalStateException("USER NOT FOUND");
		}

		return user;
	}

	private Optional<Vehicle> findVehicle(User user, String vehicleName, String registrationNumber) {
		return user.getVehicles().stream()
				.filter(vehicle -> vehicle.getVehicleType().equals(vehicleName) && vehicle.getRegisteredNumber().equals(registrationNumber))
				.findAny();
	}

	private void updateVehicleStatus(String vehicleOwnerName, String vehicleName, String vehicleNumber, boolean occupied, boolean offered) {
		final User user = getUser(vehicleOwnerName);
		final Optional<Vehicle> vehicleOpt = findVehicle(user, vehicleName, vehicleNumber);
		if (!vehicleOpt.isPresent()) {
			// exception that no vehicle is there
			throw new IllegalStateException("NO VEHICLE");
		}
		final Vehicle vehicle = vehicleOpt.get();
		vehicle.setOccupied(occupied);
		vehicle.setOffered(offered);
	}


	private void updateVehicleAsOccupied(String username, String vehicle, String vehicleNumber) {
		updateVehicleStatus(username, vehicle, vehicleNumber, true, true);
	}

}
