package com.qaprosoft.objects;

public class Phone {
	private long id;
	private String model;
	private String resolution;
	private Brand brand;
	private String os;
	private String display;
	private String year;

	public Phone(long id, String model, Brand brand, String resolution, String os, String display, String year) {
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.resolution = resolution;
		this.os = os;
		this.display = display;
		this.year = year;
	}

	public long getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public String getResolution() {
		return resolution;
	}

	public Brand getBrand() {
		return brand;
	}

	public String getOs() {
		return os;
	}

	public String getDisplay() {
		return display;
	}

	public String getYear() {
		return year;
	}

}
