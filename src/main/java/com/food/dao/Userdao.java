package com.food.dao;

import java.util.ArrayList;

import com.food.model.User;

public interface Userdao {

	int insert(User u);

	ArrayList<User> fetchall();

	User fetchone(int id);

	int update(int id, String password);

	int delete(int id);
	

	User fetchemail(String email);

}
