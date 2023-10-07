package org.interview.prep.commands;

public class ModificationReqFactory {

	Request getReq() {
		return new BoardNameModification();
	}


}
