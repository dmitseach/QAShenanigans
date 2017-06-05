package com.qaprosoft.utils;

import com.qaprosoft.carina.core.foundation.utils.Configuration;

public interface Constants {
	public interface URLS {
		String ONLINER_URL = Configuration.getEnvArg("onliner_url");
		String VK_API_URL = Configuration.getEnvArg("vk.users.get.api.url");
	}

	public interface DB {
		String MYBATIS_CFG = "mybatis-config.xml";
		String USER_XLS = "json/XLS_DATA/User.xls";
		String DB_CFG = "database.properties";
	}

	public interface API {
		String USER_XLS = "json/XLS_DATA/UserByID.xls";
		String MSSG_XLS = "json/XLS_DATA/Message.xls";
	}
}
