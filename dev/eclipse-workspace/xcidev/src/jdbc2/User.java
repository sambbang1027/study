package jdbc2;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
	private String username;
	private String password;
	private String name;
	private String email;
	private int birthYear;

	public User () {}
	
	public User(String username, String password, String name, String email, int birthYear) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.birthYear = birthYear;
	}
	
	
	public User(String username, String name, String email, int birthYear) {
		this.username = username;
		this.name = name;
		this.email = email;
		this.birthYear = birthYear;
	}

}
