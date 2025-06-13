package com.food.model;

public class Restaurant {
     private int restaurantid;
     private String name_of_the_restaurant;
     private String cuisine;
     private int deliveryTime;
     private String address;
     private float ratings;
	 private  boolean isActive;
     private String imagepath;
	public Restaurant() {
		super();
	}
	public Restaurant(int restaurantid, String name_of_the_restaurant, String cuisine, int deliveryTime, String address,
			float ratings, boolean isActive, String imagepath) {
		super();
		this.restaurantid = restaurantid;
		this.name_of_the_restaurant = name_of_the_restaurant;
		this.cuisine = cuisine;
		this.deliveryTime = deliveryTime;
		this.address = address;
		this.ratings = ratings;
		this.isActive = isActive;
		this.imagepath = imagepath;
	}
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	public String getName_of_the_restaurant() {
		return name_of_the_restaurant;
	}
	public void setName_of_the_restaurant(String name_of_the_restaurant) {
		this.name_of_the_restaurant = name_of_the_restaurant;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	@Override
	public String toString() {
		return  restaurantid + "   " + name_of_the_restaurant
				+ "  " + cuisine + "  " + deliveryTime +"  " + address + "  "
				+ ratings + "  " + isActive + "  " + imagepath;
	}
	
}