package com.qaprosoft.utils;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.Configuration.Parameter;

public interface Constants {
	public interface URLS {
		String ONLINER_URL = Configuration.getEnvArg("onliner_url");
	}

	public interface DB {
		String MYBATIS_CFG = R.CONFIG.get("mybatis-config.xml");
		String DB_CFG = R.CONFIG.get("database.properties");
		String ENV = Configuration.get(Parameter.ENV).toLowerCase();
	}
}
