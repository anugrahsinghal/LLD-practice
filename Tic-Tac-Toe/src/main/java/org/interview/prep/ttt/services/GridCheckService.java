package org.interview.prep.ttt.services;

import org.interview.prep.ttt.models.Game;

public interface GridCheckService {

	boolean checkGridForFilledState(Game game);

	boolean checkGridForWinningState(Game game);


}
