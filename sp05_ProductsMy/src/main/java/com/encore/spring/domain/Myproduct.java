package com.encore.spring.domain;

public class Myproduct {
	
	private int id;
	private String name;
	private String maker;
	private int price;
	
	public Myproduct() {} // 기본 생성자
	public Myproduct(String name, String maker, int price) {
		super();
		this.name = name;
		this.maker = maker;
		this.price = price;
	}
	public Myproduct(int id, String name, String maker, int price) {
		super();
		this.id = id;
		this.name = name;
		this.maker = maker;
		this.price = price;
	}
	
	// setter, getter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// toString()
	@Override
	public String toString() {
		return "Myproduct [id=" + id + ", name=" + name + ", maker=" + maker + ", price=" + price + "]";
	}
	
}
