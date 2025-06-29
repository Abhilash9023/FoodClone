package com.food.model;

public class Menu {
    private int  menuId;
    private int restaurantId;
    private String name;
    private String description;
    private int price;
    private Boolean isAvailable;
    private String imagepath;
	public Menu() {
		super();
	}
	public Menu(int menuId, int restaurantId, String name, String description, int price, Boolean isAvailable,
			String imagepath) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.imagepath = imagepath;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isActive) {
		this.isAvailable = isActive;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	@Override
	public String toString() {
		return menuId + "   " + restaurantId + "   " + name + "   "+ description + "   " + price + "   " + isAvailable + "   " + imagepath;
	}
	
    
}
