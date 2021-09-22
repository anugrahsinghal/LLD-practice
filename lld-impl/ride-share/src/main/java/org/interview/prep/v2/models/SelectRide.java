package org.interview.prep.v2.models;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class SelectRide extends RideDetail {
	/*select_ride(“Nandini, Origin=Bangalore, Destination=Mysore, Seats=1, Most Vacant”)

	 */
	private final String selectionStrategy;


	public SelectRide(int id, String username, String source, String destination, int seats, String selectionStrategy) {
		super(id, username, source, destination, seats);
		this.selectionStrategy = selectionStrategy;
	}

}
