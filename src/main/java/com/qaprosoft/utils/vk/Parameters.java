package com.qaprosoft.utils.vk;

public enum Parameters {

	GET_INFO_BY_ID("?user_ids="), 
	SELECT_ID("?user_id="),
	GET_BDATE("&fields=bdate"),
	MESSAGE("&message=test-ok");
	
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
