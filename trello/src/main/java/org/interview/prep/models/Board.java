package org.interview.prep.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Board {

	@Getter
	private final String id;
	private final String url;
	private final List<User> members;
	private final List<ProjectList> projects;

	@Setter
	private Privacy privacy;
	@Setter
	private String name;

	public Board(String name) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.url = "/url" + this.id;
		this.members = new ArrayList<>();
		this.projects = new ArrayList<>();
		this.privacy = Privacy.PUBLIC;
	}

	public Board(String id, String url, List<User> members, List<ProjectList> projects, Privacy privacy, String name) {
		this.id = id;
		this.url = url;
		this.members = members;
		this.projects = projects;
		this.privacy = privacy;
		this.name = name;
	}

	public void addMember(User user) {
		this.members.add(user);
	}


	public void removeMember(String memberId) {
		int memberIdx = -1;
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getUserId().equals(memberId)) {
				memberIdx = i;
				break;
			}
		}
		if (memberIdx != -1) {
			members.remove(memberIdx);
		}
	}

}

