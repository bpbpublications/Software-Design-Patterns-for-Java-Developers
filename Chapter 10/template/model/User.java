package edu.bpb.oops.pattern.ch10.template.model;

/**
 * @author Lalit Mehra
 *
 */
public class User {

	private long userId;
	private boolean active;
	private String name;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}