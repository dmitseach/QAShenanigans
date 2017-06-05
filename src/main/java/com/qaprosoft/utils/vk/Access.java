package com.qaprosoft.utils.vk;

public enum Access {

	TOKEN_JOB("&access_token=63ce21085564a28acb80a786d9fe29bab80e1342d802e2e405b5a515f6e9f40b069dfec17d5b7e0b718b9"),
	TOKEN_APP("&access_token=97104e019d3be9bd96ea02395649e58483cf7d65b64843e040d171f17556e1138d541e7bff76cf50813bd"),
	TOKEN_HOME("&access_token=631ecd01393712d4c82fac01ca42a45e0c00daaf90870ab1388e30f51d104ec6c93bee82c4153f882800a");
	
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
