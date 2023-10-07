package org.interview.prep.controller;

import org.interview.prep.services.ListManagement;

public class ListController {

	private final ListManagement listService;

	public ListController(ListManagement listService) {
		this.listService = listService;
	}

	String createList(String boardId, String subProjectName) {
		return listService.create(boardId, subProjectName);
	}

	void showList(String subProjectId) {
		listService.show(subProjectId);
	}

	void modifyList(String subProjectId, String attribute, String value) {
		listService.modifyList(subProjectId, attribute, value);
	}


}
