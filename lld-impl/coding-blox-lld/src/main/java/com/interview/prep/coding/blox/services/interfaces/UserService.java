package com.interview.prep.coding.blox.services.interfaces;

import com.interview.prep.coding.blox.exceptions.UserDoesNotExistException;
import com.interview.prep.coding.blox.models.User;
import java.util.Collection;

public interface UserService {

	String createUser(String username);

	User getByName(String userName) throws UserDoesNotExistException;

	Collection<User> getAll();

}
