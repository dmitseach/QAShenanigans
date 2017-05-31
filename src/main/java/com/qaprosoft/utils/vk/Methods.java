package com.qaprosoft.utils.vk;

public enum Methods {

	GET_USERS("users.get"), GET_GROUPS("groups.get");

	private String method;

	Methods(String method) {
		this.method = method;
	}

	public String getMethod() {
		return method;
	}

}
