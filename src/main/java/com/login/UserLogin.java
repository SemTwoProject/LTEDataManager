package com.login;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;


public class UserLogin {
	
    private String username = null;
	private String password = null;
	
    public UserLogin() {
    }

	public String getUsername() {
		return username;
	}

	@FormParam("username")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	@FormParam("password")
	public void setPassword(String password) {
		this.password = password;
	}
}
