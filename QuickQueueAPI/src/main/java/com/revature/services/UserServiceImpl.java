package com.revature.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exceptions.InternalErrorServer;
import com.revature.exceptions.UserNotFound;
import com.revature.models.User;
import com.revature.repositories.IUserDao;

@Service
public class UserServiceImpl implements IUserService {
	
	IUserDao ud;
	
	@Autowired
	public UserServiceImpl(IUserDao ud) {
		this.ud = ud;
	}

	@Override
	public User login(String username, String password){				
		try {
			User u = ud.findUserbyUsernameAndPassword(username, password);
			if(u!=null) {
				u.setCartOwners(null);
				u.setCartShopper(null);
				u.setPassword(null);
				return u;
			}
			else {
				throw new UserNotFound();
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new InternalErrorServer();
		}
		
		
	}

}
