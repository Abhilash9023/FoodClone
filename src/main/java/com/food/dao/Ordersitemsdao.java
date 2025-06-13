package com.food.dao;

import java.util.ArrayList;

import com.food.model.Ordersitems;

public interface Ordersitemsdao {
         int insert(Ordersitems o);
         ArrayList<Ordersitems> fetchall();
         Ordersitems fetchone(int id);
		int update(float total, int id);
		int delete(int id);
}
