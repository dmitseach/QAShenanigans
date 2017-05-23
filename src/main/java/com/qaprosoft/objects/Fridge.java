package com.qaprosoft.objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "fridge")
@XmlType(propOrder = { "id", "model", "brand", "colour", "coolSyst", "constrType" })
public class Fridge {
	private long id;
	private String model;
	private String brand;
	private String colour;
	private String coolSyst;
	private String constrType;

	public long getId() {
		return id;
	}

	@XmlElement
	public void setId(long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	@XmlElement
	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	@XmlElement
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColour() {
		return colour;
	}

	@XmlElement
	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getCoolSyst() {
		return coolSyst;
	}

	@XmlElement
	public void setCoolSyst(String coolSyst) {
		this.coolSyst = coolSyst;
	}

	public String getConstrType() {
		return constrType;
	}

	@XmlElement
	public void setConstrType(String constrType) {
		this.constrType = constrType;
	}

}
