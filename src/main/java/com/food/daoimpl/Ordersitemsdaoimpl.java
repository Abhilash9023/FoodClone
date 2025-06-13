package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.Connection.ConnectionDB;
import com.food.dao.Ordersitemsdao;
import com.food.model.Ordersitems;


public class Ordersitemsdaoimpl implements Ordersitemsdao {
   
	Connection con=ConnectionDB.connect();
	private PreparedStatement pstmt;
	ArrayList<Ordersitems> ItemList=new ArrayList<Ordersitems>();
	private Statement stmt;
	private ResultSet rs;
	private Ordersitems k;
	static String insert="insert into ordersitems (OrderID, MenuID, Quantity, ItemTotal) values(?,?,?,?)";
	static String fetchall="select * from ordersitems";
	static String fetchone="select * from ordersitems where Order_item_id=?";
	static String update="update ordersitems set itemtotal=? where Order_item_id=?";
	static String delete="delete from ordersitems where Order_item_id=?";

	@Override
	public int insert(Ordersitems o) {
		try {
			pstmt=con.prepareStatement(insert);
			pstmt.setInt(1, o.getOrderid());
			pstmt.setInt(2, o.getMenuid());
			pstmt.setInt(3,o.getQuantity());
			pstmt.setInt(4, o.getItemtotal());
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public ArrayList<Ordersitems> fetchall() {
	try {
		stmt=con.createStatement();
		rs=stmt.executeQuery(fetchall);
		ItemList=extract(rs);
	}catch(Exception e) {
		e.printStackTrace();
	}
		
		return ItemList;
	}
	
	ArrayList<Ordersitems> extract(ResultSet rs){
		try { 
			   while(rs.next()) {
	        ItemList.add(new Ordersitems(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5)));
	            }
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		return ItemList;
}

	@Override
	public Ordersitems fetchone(int id)  {
		try{
			pstmt=con.prepareStatement(fetchone);
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();
		   extract(rs);
		   k=extract(rs).get(0);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}

	@Override
	public int update(float total, int id) {
		try {
			pstmt=con.prepareStatement(update);
			pstmt.setFloat(1, total);
			pstmt.setInt(2,id);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			pstmt=con.prepareStatement(delete);
			pstmt.setInt(1, id);
		return	pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return 0;

		}
	}
	}
