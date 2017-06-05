package com.qaprosoft.objects;

public class Fridge {
	private long id;
	private String model;
	private String brand;
	private String colour;
	private String coolSyst;
	private String constrType;

	public Fridge(long id, String model, String brand, String colour, String coolSyst, String constrType) {
		this.id = id;
		this.model = model;
		this.coolSyst = coolSyst;
		this.constrType = constrType;
		this.colour = colour;
		this.brand = brand;
	}

	public long getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public String getCoolSyst() {
		return coolSyst;
	}

	public String getConstrType() {
		return constrType;
	}

	public String getBrand() {
		return brand;
	}

	public String getColour() {
		return colour;
	}

}
