package com.food.dao;

import java.util.ArrayList;

import com.food.model.Orders;

public interface Ordersdao {
             int insert(Orders O);
             ArrayList<Orders> fetchall();
			Orders fetchone(int id);
			int update(int totalamount, int id);
			int delete(int id);
             
}
