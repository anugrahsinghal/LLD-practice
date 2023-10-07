package org.interview.prep.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class Vehicle {

	private final String vehicleType;
	private final String registeredNumber;


	@Setter
	private boolean offered = false;
	@Setter
	private boolean occupied = false;

}
