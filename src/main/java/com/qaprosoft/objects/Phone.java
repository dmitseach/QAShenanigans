package com.qaprosoft.objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "phone")
@XmlType(propOrder = { "id", "model", "resolution", "brand", "os", "display", "year" })
public class Phone {
	private long id;
	private String model;
	private String resolution;
	private String brand;
	private String os;
	private String display;
	private String year;

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

	public String getResolution() {
		return resolution;
	}

	@XmlElement
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getBrand() {
		return brand;
	}

	@XmlElement
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getOs() {
		return os;
	}

	@XmlElement
	public void setOs(String os) {
		this.os = os;
	}

	public String getDisplay() {
		return display;
	}

	@XmlElement
	public void setDisplay(String display) {
		this.display = display;
	}

	public String getYear() {
		return year;
	}

	@XmlElement
	public void setYear(String year) {
		this.year = year;
	}

}
