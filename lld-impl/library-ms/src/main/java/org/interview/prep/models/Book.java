package org.interview.prep.models;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
public class Book {

	String id;
	String title;
	List<Author> authors;
	List<Publisher> publishers;

}
