package org.interview.prep.v2.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// used to offer/end ride
@ToString
@Getter
public class OfferRide extends RideDetail {
	/*offer_ride(“Rohan, Origin=Hyderabad, Available Seats=1, Vehicle=Swift, KA-01-12345, Destination= Bangalore”)*/


	private final String vehicle;
	private final String vehicleNumber;

	public OfferRide(int id, String username, String source, String destination, int seats, String vehicle, String vehicleNumber) {
		super(id, username, source, destination, seats);
		this.vehicle = vehicle;
		this.vehicleNumber = vehicleNumber;
	}
}
