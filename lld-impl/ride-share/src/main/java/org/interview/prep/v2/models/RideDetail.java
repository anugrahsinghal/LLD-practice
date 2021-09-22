package org.interview.prep.v2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

// used to offer/end ride
@ToString
@Getter
@AllArgsConstructor
public class RideDetail {
	/*offer_ride(“Rohan, Origin=Hyderabad, Available Seats=1, Vehicle=Swift, KA-01-12345, Destination= Bangalore”)*/

	final int id;
	final String username;
	final String source;
	final String destination;
	final int seats;

}
