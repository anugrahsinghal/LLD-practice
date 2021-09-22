package com.interview.prep.coding.blox.services.interfaces;

import com.interview.prep.coding.blox.models.Contest;
import com.interview.prep.coding.blox.models.UserData;
import java.util.Map;
import java.util.Set;
import lombok.NonNull;

public interface UserScoreGenerator {

	void generateRandomScoreForUsers(Contest contest, Set<UserData> userData);

}
