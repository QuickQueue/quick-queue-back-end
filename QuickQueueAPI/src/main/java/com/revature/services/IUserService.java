package com.revature.services;

import java.sql.SQLException;

import com.revature.exceptions.UserNotFound;
import com.revature.models.User;

public interface IUserService {

	public User login(String username, String password);
	public User register(User u);
}
