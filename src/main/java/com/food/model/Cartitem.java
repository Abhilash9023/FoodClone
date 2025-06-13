package com.food.model;

public class Cartitem {
  private int menuid;
  private int restaurantid;
  private String name;
  private int price;
  private int quantity;
public Cartitem() {
	super();
}
public Cartitem(int menuid, int restaurantid, String name, int price, int quantity) {
	super();
	this.menuid = menuid;
	this.restaurantid = restaurantid;
	this.name = name;
	this.price = price;
	this.quantity = quantity;
}
public int getMenuid() {
	return menuid;
}
public void setMenuid(int menuid) {
	this.menuid = menuid;
}
public int getRestaurantid() {
	return restaurantid;
}
public void setRestaurantid(int restaurantid) {
	this.restaurantid = restaurantid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return  menuid + "   " + restaurantid + "   " + name + "   " + price
			+ "   " + quantity ;
}

}
