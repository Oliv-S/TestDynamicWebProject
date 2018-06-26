package Repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Models.User;

public class UserRepositoryInMemory implements UserRepository {
	private List<User> userList;
	
	
	
	public UserRepositoryInMemory() {
		userList = new ArrayList<>();
		
		userList.add(new User("Alex","pass1",LocalDate.parse("2010-09-29")));
		userList.add(new User("John","pass2",LocalDate.parse("2008-01-19")));
		userList.add(new User("Mona","pass3",LocalDate.parse("1980-12-02")));
	}





	@Override
	public User getUserByName(String userName) {
		// TODO Auto-generated method stub
		for (User user : userList) {
			if (user.getName().equals(userName))
				return user;
		}
		return null;
	}





	@Override
	public boolean isUserExist(String userName, String password) {
		// TODO Auto-generated method stub
		for (User user : userList) {
			if (user.getName().equals(userName)&&user.getPassword().equals(password))
				return true;
		}
		return false;
	}
	
	
}
