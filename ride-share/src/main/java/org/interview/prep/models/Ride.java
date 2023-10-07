package org.interview.prep.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class Ride {

	final User user;
	final int seatsOccupied;
	final Vehicle vehicle;
	final SRC_DEST src_dest;

}
