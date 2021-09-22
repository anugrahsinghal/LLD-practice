package org.interview.prep.models;

import java.util.Objects;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public class SRC_DEST {

	private final String src;
	private final String dest;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof SRC_DEST)) {
			return false;
		}
		SRC_DEST ride = (SRC_DEST) o;
		return getSrc().equals(ride.getSrc()) && getDest().equals(ride.getDest());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getSrc(), getDest());
	}

}

