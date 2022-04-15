package com.mycom.myapp.dto;

public class CarDto {
	private String name;
	private int price;
	private String owner;
	
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
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public CarDto() {}
	public CarDto(String name, int price, String owner) {
		super();
		this.name = name;
		this.price = price;
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		return "CarDto [name=" + name + ", price=" + price + ", owner=" + owner + "]";
	}
	
}
