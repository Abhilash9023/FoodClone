package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.Connection.ConnectionDB;
import com.food.dao.Userdao;
import com.food.model.User;

public class Userdaoimpl implements Userdao {
	Connection  con=ConnectionDB.connect();
	private PreparedStatement pstmt;
	int s;
	private Statement stmt;
	private ResultSet resultset;
	static ArrayList<User> UserList=new ArrayList<User>();
	static String insertquery="insert into `User` (Username, Password, Email, Address) values (?,?,?,?)";
    static String fetchall="select * from user";
    static String fetchone="select * from user where userid=?";
    static String Update="update user set password=? where userid=?";
    static String delete="delete  from user where userid=?";
    static String deleteall="delete from user";
    static String fetchemail="select * from user where email=?";
	private User k;
	@Override
	public int insert(User u) {
		try {
		 pstmt=con.prepareStatement(insertquery,Statement.RETURN_GENERATED_KEYS);
		
   		 pstmt.setString(1,u.getUsername());
   		 pstmt.setString(2, u.getPassword());
   		 pstmt.setString(3,u.getEmail());
   		 pstmt.setString(4, u.getAddress());
   		 s= pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
      return s;
		
	}
	@Override
	public ArrayList<User> fetchall() {
		
	try {
		stmt=con.createStatement();
		resultset=stmt.executeQuery(fetchall);
		UserList=extractfromuser(resultset);
	}catch(Exception e) {
		e.printStackTrace();
	}
	return UserList;
	}
    
	
	
	ArrayList<User> extractfromuser(ResultSet resultset) {
    	try
    	{
    		while(resultset.next()) {
                    	  UserList.add(new User(
                    			resultset.getInt("userid"),
                    			resultset.getString("username"),
                    			resultset.getString("password"),
                    			resultset.getString("email"),
                    			resultset.getString("address")
                    			)
                    			);
    		
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}return UserList;
		
	}
	@Override
	public User fetchone(int id) {
		try {
			
			pstmt=con.prepareStatement(fetchone);
			pstmt.setInt(1,id);
			 resultset=pstmt.executeQuery();
			 
			 UserList=extractfromuser(resultset);
			 k=UserList.get(0);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	@Override
	public int update(int id,String password) {
		try {
			pstmt=con.prepareStatement(Update);
			 pstmt.setString(1,password);
			pstmt.setInt(2,id);
			return pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public int delete(int id) {
		try {
			pstmt=con.prepareStatement(delete);
			pstmt.setInt(1,id);
			return pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	@Override
	public User fetchemail(String email) {
		try {
			pstmt=con.prepareStatement(fetchemail);
			pstmt.setString(1,email);
			resultset=pstmt.executeQuery();
			UserList=extractfromuser(resultset);
			k=UserList.get(0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
		
	}
	
	
		

	
	
   
}
