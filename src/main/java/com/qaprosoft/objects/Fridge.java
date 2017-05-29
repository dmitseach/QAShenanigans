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
		this.brand = brand;
		this.colour = colour;
		this.coolSyst = coolSyst;
		this.constrType = constrType;
	}

	public long getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public String getBrand() {
		return brand;
	}

	public String getColour() {
		return colour;
	}

	public String getCoolSyst() {
		return coolSyst;
	}

	public String getConstrType() {
		return constrType;
	}

}
