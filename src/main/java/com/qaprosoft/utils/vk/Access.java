package com.qaprosoft.utils.vk;

public enum Access {

	ACCESS_TOKEN("63ce21085564a28acb80a786d9fe29bab80e1342d802e2e405b5a515f6e9f40b069dfec17d5b7e0b718b9");

	private String token;

	Access(String token) {
		this.token = token;
	}

	public String token() {
		return token;
	}

	public String getToken() {
		return token;
	}

}
