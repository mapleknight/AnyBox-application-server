package com.anybox.model;

import javax.persistence.Entity;

@Entity
public class UserRefererModel {
	
	private int id;
	
	private String inviteBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInviteBy() {
		return inviteBy;
	}

	public void setInviteBy(String inviteBy) {
		this.inviteBy = inviteBy;
	}

}
