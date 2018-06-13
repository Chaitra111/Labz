package com.bridgelabz.oops;

import java.util.ArrayList;

/**
 * @author Chaitra Ankolekar 
 * Date : 18/05/2018 
 * Purpose :
 */
public class UserList {

	ArrayList<UserDetails> userList = new ArrayList<UserDetails>();

	public ArrayList<UserDetails> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<UserDetails> userList) {
		this.userList = userList;
	}
}
