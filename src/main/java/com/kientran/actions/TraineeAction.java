package com.kientran.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.kientran.entities.User;
import com.kientran.services.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class TraineeAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService service = new UserService();
	private User user;
	private List<User> users = new ArrayList<>();
	public boolean isExist;
	private Map<String, Object> session;

	@Override
	public String execute() throws Exception {
		user = (User) session.get("user");
		if (user != null && user.validate()) {
			isExist = service.isExist(user);
			if (!isExist) {
				service.save(user);
			} else {
				service.update(user);
			}
			users = service.getAll();
			return SUCCESS;
		}
		return "user-account";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
