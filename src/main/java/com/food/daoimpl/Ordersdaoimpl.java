package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.Connection.ConnectionDB;
import com.food.dao.Ordersdao;
import com.food.model.Orders;

public class Ordersdaoimpl implements Ordersdao {
    
    Connection con = ConnectionDB.connect();  
    ArrayList<Orders> OrderList = new ArrayList<Orders>();  
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet rs;
    private Orders k;
    
    
    static String insert = "insert into Orders (UserID, RestaurantID, Totalamount, Status, PaymentMode) values(?,?,?,?,?)";
    static String fetchall = "select * from Orders";
    static String fetchone = "select * from Orders where Orderid=?";
    static String update = "update Orders set totalamount=? where orderid=?";
    static String delete = "delete from orders where orderid=?";
    
    @Override
    public int insert(Orders O) {
        try {
            
            pstmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);  

            pstmt.setInt(1, O.getUserId());
            pstmt.setInt(2, O.getRestaurantId());
            pstmt.setFloat(3, O.getTotalAmount());
            pstmt.setString(4, O.getStatus());
            pstmt.setString(5, O.getPaymentMode());

            int affectedRows = pstmt.executeUpdate();  

            if (affectedRows > 0) {
                
                rs = pstmt.getGeneratedKeys();  
                if (rs.next()) {
                    
                    int generatedOrderId = rs.getInt(1);  
                    System.out.println("Generated OrderID: " + generatedOrderId);  
                    return generatedOrderId;  
                }
            }

            return 0;  
        } catch (Exception e) {
            e.printStackTrace();
            return 0;  
        }
    }

    @Override
    public ArrayList<Orders> fetchall() {
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(fetchall);
            OrderList = extractallfromtable(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OrderList;
    }

    ArrayList<Orders> extractallfromtable(ResultSet rs) {
        try {
            while (rs.next()) {
                OrderList.add(new Orders(
                        rs.getInt("OrderID"),
                        rs.getInt("UserID"),
                        rs.getInt("RestaurantID"),
                        rs.getFloat("TotalAmount"),
                        rs.getString("Status"),
                        rs.getString("PaymentMode")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OrderList;
    }

    @Override
    public Orders fetchone(int id) {
        try {
            pstmt = con.prepareStatement(fetchone);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            k = extractallfromtable(rs).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }

    @Override
    public int update(int totalamount, int id) {
        try {
            pstmt = con.prepareStatement(update);
            pstmt.setInt(1, totalamount);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(int id) {
        try {
            pstmt = con.prepareStatement(delete);
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
