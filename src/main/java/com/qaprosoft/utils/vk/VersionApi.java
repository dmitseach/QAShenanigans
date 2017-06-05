package com.qaprosoft.utils.vk;

public enum VersionApi {

	V("&v=5.64");

	private String version;

	VersionApi(String version) {
		this.version = version;
	}

	public String version() {
		return version;
	}

	public String getVersion() {
		return version;
	}
}
