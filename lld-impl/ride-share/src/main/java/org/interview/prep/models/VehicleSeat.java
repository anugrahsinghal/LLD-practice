package org.interview.prep.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor


public class VehicleSeat {

	private final Vehicle vehicle;
	@Setter
	private Integer count;

	public VehicleSeat(Vehicle vehicle, Integer count) {
		this.vehicle = vehicle;
		this.count = count;
	}

}
