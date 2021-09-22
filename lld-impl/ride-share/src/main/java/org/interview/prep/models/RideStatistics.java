package org.interview.prep.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class RideStatistics {


	private int ridesTaken;
	private int ridesOffered;

	public void rideTaken() {
		ridesTaken++;
	}

	public void rideOffered() {
		ridesOffered++;
	}

}
