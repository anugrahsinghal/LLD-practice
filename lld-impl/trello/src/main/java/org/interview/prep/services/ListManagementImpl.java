package org.interview.prep.services;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.interview.prep.factory.list.ListModifierFactory;
import org.interview.prep.models.Board;
import org.interview.prep.models.Card;
import org.interview.prep.models.ProjectList;

public class ListManagementImpl implements ListManagement {

	private final ProjectManagementImpl boardService;

	public ListManagementImpl(ProjectManagementImpl boardService) {
		this.boardService = boardService;
	}

	@Override
	public ProjectList getById(String id) {
		final Optional<ProjectList> list = getProjectListStream()
				.filter(subProject -> subProject.getId().equals(id))
				.findAny();
		return list.orElseThrow(() -> new IllegalArgumentException(id));
	}

	@Override
	public Collection<ProjectList> getAll() {
		return getProjectListStream()
				.collect(Collectors.toList());
	}

	private Stream<ProjectList> getProjectListStream() {
		return boardService.getAll()
				.stream()
				.flatMap(board -> board.getProjects().stream());
	}

	@Override
	public void delete(ProjectList subProject) {
		OUTER:
		for (Board board : boardService.getAll()) {
			for (Iterator<ProjectList> iterator = board.getProjects().iterator(); iterator.hasNext(); ) {
				ProjectList item = iterator.next();
				if (item.equals(subProject)) {
					iterator.remove();
					break OUTER;
				}
			}
		}
	}

	@Override
	public boolean addCardToList(String subProjectId, Card card) {
		final Optional<ProjectList> list = getProjectListStream()
				.filter(projectList -> projectList.getId().equals(subProjectId)).findAny();

		return list.map(projectList -> projectList.addCard(card)).orElse(false);
	}

	@Override
	public String create(String boardId, String subProjectName) {
		final Board boardById = boardService.getBoardById(boardId);
		final ProjectList e = new ProjectList(subProjectName);
		boardById.getProjects().add(e);
		return e.getId();
	}

	@Override
	public void show(String subProjectId) {
		final Board boardById = boardService.getBoardById(subProjectId);
		System.out.println(boardById.getProjects());
	}

	@Override
	public void modifyList(String subProjectId, String attribute, String value) {
		final Optional<ProjectList> list = getProjectListStream()
				.filter(subProject -> subProject.getId().equals(subProjectId))
				.findAny();

		list.ifPresent(subProject -> ListModifierFactory.get(attribute).accept(subProject, value));
	}
}
