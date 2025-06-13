package com.food.model;
public class Ordersitems {
    private int ordersitemid;
    private int orderid;
    private int menuid;
    private int quantity;
    private int itemtotal;
	public Ordersitems() {
		super();
	}
	public Ordersitems(int ordersitemid, int orderid, int menuid, int quantity, int itemtotal) {
		super();
		this.ordersitemid = ordersitemid;
		this.orderid = orderid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.itemtotal = itemtotal;
	}
	public Ordersitems(int orderid, int menuid, int quantity,int itemtotal) {
		super();
		this.orderid = orderid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.itemtotal = itemtotal;
	}
	public int getOrdersitemid() {
		return ordersitemid;
	}
	public void setOrdersitemid(int ordersitemid) {
		this.ordersitemid = ordersitemid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getItemtotal() {
		return itemtotal;
	}
	public void setItemtotal(int itemtotal) {
		this.itemtotal = itemtotal;
	}
	@Override
	public String toString() {
		return  + ordersitemid + "   " + orderid + "   " + menuid
				+ "   " + quantity + "   " + itemtotal;
	}
    
}
