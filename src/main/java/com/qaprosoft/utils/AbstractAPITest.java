package com.qaprosoft.utils;

import java.io.FileReader;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.qaprosoft.utils.JsonUtils;
import com.qaprosoft.carina.core.foundation.APITest;

public abstract class AbstractAPITest extends APITest {

	protected final static JSONParser parser = new JSONParser();

	protected final static String USER_URL = "/v1/user-api/user";
	protected final static String USER_JSON = "json/requests/User.json";

	protected final static String SECRET_KEY = "key=8WRAig3bXUIHQZrL6ftTsoou7LGVTw1TOeqdmjb/";
	protected final static String CONTENT_TYPE = "Content-Type=application/json";

	protected final static String REQUEST_TYPE = "GET";
	
	protected final static String AUTH_USERNAME = "madadmin";
	protected final static String AUTH_PASSWORD = "m4dapp4r3l";

	protected final static String AUTH_USERNAME_USER = "kevin@liveathos.com";
	protected final static String AUTH_PASSWORD_USER = "wordpass";

	protected final static String EMAIL = "qaprosoft.t1@gmail.com";
	protected final static String EMAIL_PASSWORD = "p@ssw0rd0123";
	protected final static String PASSWORD = "power123";

	protected final static String CRETE_SESSION_JSON = "json/requests/CreateSession.json";
	protected final static String SESSION_URL = "/v1/session-api/session";

	protected void populateParams(Map<String, String> params, JSONObject json) {
		for (Entry<String, String> entry : params.entrySet()) {
			if (StringUtils.isNotEmpty(entry.getKey())) {
				JsonUtils.addOrChangeJSONValue(entry.getKey(), entry.getValue(), json);
			}
		}
	}

	protected JSONObject getRequest(String path) throws Exception {
		return (JSONObject) parser.parse(new FileReader(ClassLoader.getSystemResource(path).getFile()));
	}
}
