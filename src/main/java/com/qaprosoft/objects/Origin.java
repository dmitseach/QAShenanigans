package com.qaprosoft.objects;

import java.util.ArrayList;
 
public class Origin {
	private long id;
	private String name;
	private String city;
	private ArrayList<Brand> brands;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public ArrayList<Brand> getBrands() {
		return brands;
	}

	public void setBrands(ArrayList<Brand> brands) {
		this.brands = brands;
	}

}
