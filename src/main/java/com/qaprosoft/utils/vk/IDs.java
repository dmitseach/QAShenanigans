package com.qaprosoft.utils.vk;

public enum IDs {

	MY_ID("420781997"), 
	ANAZARENKO_ID("17516433"), 
	SSEMKOV_ID("83385079"), 
	MY_GROUP_ID("67494791"), 
	MY_APP_ID("6060235"),
	ALESYA("156800470");
	
	private String id;

	IDs(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
