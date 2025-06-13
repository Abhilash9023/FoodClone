package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.Connection.ConnectionDB;
import com.food.dao.Restaurantdao;
import com.food.model.Restaurant;

public class Restaurantdaoimpl implements Restaurantdao {
	Connection con=ConnectionDB.connect();

	private PreparedStatement pstmt;

	private int s;

	private Statement stmt;

	

	private ResultSet rs;

	ArrayList<Restaurant> RestaurantList=new ArrayList<Restaurant>();

	private Restaurant r;

	private int d;


	
	static String insert="insert into restaurant (RestaurantID,Name_of_the_restaurant,Cuisine,Delivery_Time,Address,Ratings,IsActive,ImagePath) values(?,?,?,?,?,?,?,?)";
	static String fetchall="select * from restaurant";
	static String fetchone="select * from restaurant where restaurantid=?";
	static String update="update restaurant set address=? where Restaurantid=?";
	static String delete="delete  from restaurant where restaurantid=?";

	public int insert(Restaurant r) {
	try {
		pstmt=con.prepareStatement(insert);
		pstmt.setInt(1,r.getRestaurantid());
		pstmt.setString(2,r.getName_of_the_restaurant());
		pstmt.setString(3,r.getCuisine());
		pstmt.setInt(4,r.getDeliveryTime());
		pstmt.setString(5, r.getAddress());
		pstmt.setFloat(6, r.getRatings());
		pstmt.setBoolean(7, r.isActive());
		pstmt.setString(8,r.getImagepath());
		
		s=pstmt.executeUpdate();
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public ArrayList<Restaurant> fetchall() {
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(fetchall);
			
			while(rs.next()) {
				
			RestaurantList.add(new Restaurant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getFloat(6),rs.getBoolean(7),rs.getString(8)));
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return RestaurantList;
	}

	public Restaurant fetchone(int id) {
		try {
			pstmt=con.prepareStatement(fetchone);
			pstmt.setInt(1,id);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				r=new Restaurant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getFloat(6),rs.getBoolean(7),rs.getString(8));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
					}
		return r;
	}

	@Override
	public int update(String add,int s) {
		try {
			pstmt=con.prepareStatement(update);
			pstmt.setString(1, add);
			pstmt.setInt(2, s);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return	0;
		}
		

	}

	@Override
	public int delete(int id) {
		try {
			pstmt=con.prepareStatement(delete);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	

}