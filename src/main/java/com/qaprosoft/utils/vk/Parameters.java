package com.qaprosoft.utils.vk;

public enum Parameters {

	GET_INFO_BY_ID("user_ids="), 
	GET_BDATE("fields=bdate");
	
	private String parameter;

	Parameters(String parameter) {
		this.setParameter(parameter);
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
}
