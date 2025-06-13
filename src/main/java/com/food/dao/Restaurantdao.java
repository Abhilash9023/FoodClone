package com.food.dao;

import java.util.ArrayList;

import com.food.model.Restaurant;

public interface Restaurantdao{
        int insert(Restaurant r);
        ArrayList<Restaurant> fetchall();
		Restaurant fetchone(int id);
		int update(String add, int s);
		int delete(int id);
}
