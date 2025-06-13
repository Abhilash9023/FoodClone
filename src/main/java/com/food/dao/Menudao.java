package com.food.dao;

import java.util.ArrayList;

import com.food.model.Menu;

public interface Menudao {

	int insert(Menu m);

	Menu fetchone(int id);

	int update(int id, String name);

	int delete(int id);
	ArrayList<Menu> fetchall();
	ArrayList<Menu> fetchbyrestid(int restauid);

}
