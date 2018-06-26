package Repositories;

import java.util.List;

import Models.User;

public interface UserRepository {
	public boolean isUserExist(String userName, String password);
	public User getUserByName(String userName);
}
