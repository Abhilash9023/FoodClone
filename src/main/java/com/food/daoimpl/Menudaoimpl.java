package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.Connection.ConnectionDB;
import com.food.dao.Menudao;
import com.food.model.Menu;

public class Menudaoimpl implements Menudao{
	Connection con=ConnectionDB.connect();
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	ArrayList<Menu> MenuList=new ArrayList<Menu>();
	private ResultSet x;
	private Menu k;
	
	private final static String insert="insert into menu  (menuid,restaurantid,name,description,price,isavailable,imagepath) values (?,?,?,?,?,?,?)";
	static String fetchall="select * from menu";
	static String fetchone="select * from menu where menuid=?";
	static String update="update menu set name=? where menuid=?";
	static String delete="delete from menu where menuid=?";
	static String fetchbyrestid="select * from menu where restaurantid=?";
	@Override
	public int insert(Menu m) {
		try {
			pstmt=con.prepareStatement(insert);
			pstmt.setInt(1,m.getMenuId());
			pstmt.setInt(2, m.getRestaurantId());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getDescription());
			pstmt.setInt(5, m.getPrice());
			pstmt.setBoolean(6, m.getIsAvailable());
			pstmt.setString(7,m.getImagepath());
			return pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
   
	ArrayList<Menu> extractallvaluesfrommenu(ResultSet k){
	      try {
	    	  while(k.next()) {
	    		  MenuList.add(new Menu(k.getInt(1),
	    				  k.getInt(2),
	    				  k.getString(3),
	    				  k.getString(4),
	    				  k.getInt(5),
	    				  k.getBoolean(6),
	    				  k.getString(7)
	    				  ));
	    	  }
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
		return MenuList;
	}
	@Override
	public Menu fetchone(int id) {
		try {
		pstmt=con.prepareStatement(fetchone);
		pstmt.setInt(1,id);
	     x=pstmt.executeQuery();
	    MenuList= extractallvaluesfrommenu(x);
	     k=MenuList.get(0);
	        }
		catch(Exception e) {
	
			e.printStackTrace();
	         }return k;
		
	}
	@Override
	public int update(int id,String name) {
		try {
			pstmt=con.prepareStatement(update);
			pstmt.setString(1,name);
			pstmt.setInt(2,id);
		return	pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public int delete(int id) {
		try {
			pstmt=con.prepareStatement(delete);
			pstmt.setInt(1,id);
		return	pstmt.executeUpdate();
		}
		catch
		(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

		public ArrayList<Menu> fetchall() {
			try {
				stmt=con.createStatement();
			rs=stmt.executeQuery(fetchall);
			MenuList=extractallvaluesfrommenu(rs);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return MenuList;
			
		}

		@Override
		public ArrayList<Menu> fetchbyrestid(int restauid) {
			try {
			pstmt=con.prepareStatement(fetchbyrestid);
			pstmt.setInt(1, restauid);
		   rs=pstmt.executeQuery();
		   MenuList=extractallvaluesfrommenu(rs);
			
		}
			catch(Exception e) {
			e.printStackTrace();
		}
		
		
	return MenuList;
	
		}
}
