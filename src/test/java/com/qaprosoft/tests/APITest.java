package com.qaprosoft.tests;

import static com.qaprosoft.utils.Constants.URLS.VK_API_URL;
import static com.qaprosoft.utils.Constants.API.USER_XLS;

import com.qaprosoft.utils.*;
import com.qaprosoft.utils.vk.*;
import com.qaprosoft.api.methods.*;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.http.HttpResponseStatusType;

import java.io.FileReader;
import java.util.Map;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest extends AbstractAPITest {
	private final static String TEMPLATE = Methods.GET_USERS.getMethod() + "?"
			+ Parameters.GET_INFO_BY_ID.getParameter() + IDs.MY_ID.getId() + "&" + Parameters.GET_BDATE.getParameter()
			+ "&" + "access_token=" + Access.ACCESS_TOKEN.getToken() + "&" + "v=" + VersionApi.V.getVersion();

	@Test(dataProvider = "SingleDataProvider")
	@XlsDataSourceParameters(path = USER_XLS, sheet = "user_get", dsUid = "TUID")
	public void getUserInfo(Map<String, String> params) throws Exception {
		GetApiMethod request = new GetApiMethod(VK_API_URL + TEMPLATE);
		request.expectResponseStatus(HttpResponseStatusType.OK_200);
		JSONObject actual = (JSONObject) parser.parse(request.callAPI().asString());
		JSONObject expected = (JSONObject) parser
				.parse(new FileReader(ClassLoader.getSystemResource(USER_JSON).getFile()));
		Assert.assertEquals(actual, expected, "Fucking error is detected!!!1");
	}
}
