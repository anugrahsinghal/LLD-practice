package org.interview.prep.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.Getter;
import org.interview.prep.models.Ride;
import org.interview.prep.models.RideStatistics;
import org.interview.prep.models.SRC_DEST;
import org.interview.prep.models.User;
import org.interview.prep.models.Vehicle;
import org.interview.prep.models.VehicleSeat;
import org.interview.prep.services.matching.RideMatchingFactory;

@Getter
public class RideManagerImpl implements RideManager {

	//  SRC_DES, VEHICLE - NUMBER_OF_SEATS
	private final Map<SRC_DEST, List<VehicleSeat>> rideOfferings;
	private final UserManager userManager;
	private final Map<String, RideStatistics> rideStatistics;
	List<Ride> ongoingRides = new ArrayList<>();

	public RideManagerImpl(Map<SRC_DEST, List<VehicleSeat>> rideOfferings,
	                       UserManager userManager, Map<String, RideStatistics> rideStatistics) {
		this.rideOfferings = rideOfferings;
		this.userManager = userManager;
		this.rideStatistics = rideStatistics;
	}

	public Ride selectRide(String src, String dest, int numSeats, String selection) {
		final Ride ride = RideMatchingFactory.selectRide(src, dest, numSeats,
				selection, userManager.getUserMap(), rideOfferings);
		updateRidesTakenStats(ride.getUser().getName());
		ongoingRides.add(ride);
		return ride;
	}

	@Override
	public String offerRide(String userName, String src, String dest, String vehicleName,
	                        String registrationNumber, int availableSeats) {
		final User user = getUser(userName);
		Optional<Vehicle> vehicle = findVehicle(user, vehicleName, registrationNumber);
		if (vehicle.isPresent()) {
			if (!vehicle.get().isOffered()) {

				SRC_DEST ride = new SRC_DEST(src, dest);
				vehicle.get().setOffered(true);

				List<VehicleSeat> rides = rideOfferings.get(ride);
				if (rides == null) {
					rides = new ArrayList<>();
				}
				rides.add(new VehicleSeat(vehicle.get(), availableSeats));

				rideOfferings.put(ride, rides);

				updateRidesOfferedStats(userName);
			}
		} else {
			throw new IllegalArgumentException("NO VEHICELE FOUND");
		}

		return "OK";
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


	private Optional<Vehicle> findVehicle(User user, String vehicleName, String registrationNumber) {
		return user.getVehicles().stream()
				.filter(vehicle -> vehicle.getVehicleType().equals(vehicleName) && vehicle.getRegisteredNumber().equals(registrationNumber))
				.findAny();
	}

	@Override
	public boolean endRide(Ride ride) {
		final List<VehicleSeat> vehicleSeats = rideOfferings.get(ride.getSrc_dest());
		final Optional<VehicleSeat> vehicleSeatOptional = vehicleSeats.stream()
				.filter(vehicleSeat -> vehicleSeat.getVehicle().equals(ride.getVehicle()))
				.findAny();

		if (vehicleSeatOptional.isPresent()) {
			vehicleSeatOptional.get().getVehicle().setOffered(false);
			vehicleSeats.remove(vehicleSeatOptional.get());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Map<String, RideStatistics> getStats() {

		for (String username : userManager.getUserMap().keySet()) {
			rideStatistics.put(username, rideStatistics.getOrDefault(username, new RideStatistics()));
		}

		return rideStatistics;
	}


	private User getUser(String userName) {
		final Map<String, User> userMap = userManager.getUserMap();
		final User user = userMap.get(userName);

		if (user == null) {
			throw new IllegalStateException("");
		}

		return user;
	}
}
