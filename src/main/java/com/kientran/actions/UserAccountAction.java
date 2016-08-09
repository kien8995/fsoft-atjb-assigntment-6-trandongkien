package com.kientran.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.kientran.entities.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAccountAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userAccount;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private User user;
	private Map<String, Object> session;

	@Override
	public String execute() throws Exception {
		user = new User(userAccount, userFirstName, userLastName, userEmail);
		if (user.validate()) {
			session.put("user", user);
			return "trainees";
		}
		return SUCCESS;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}
}
