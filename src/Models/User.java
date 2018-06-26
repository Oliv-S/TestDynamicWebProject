package Models;

import java.time.LocalDate;

public class User {
	private String name;
	private String password;
	private LocalDate birthDate;
	
	public User(String name, String password, LocalDate date) {
		super();
		this.name = name;
		this.password = password;
		this.birthDate = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDate() {
		return birthDate;
	}

	public void setDate(LocalDate date) {
		this.birthDate = date;
	}
	

}
