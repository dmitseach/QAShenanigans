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

	@Test(dataProvider = "SingleDataProvider", description = "1.1 Verify users info by id request (GET)")
	@XlsDataSourceParameters(path = USER_XLS, sheet = "user_get", dsUid = "TUID")
	public void getUserInfo(Map<String, String> params) throws Exception {
		params.remove("TUID");

		final String template = Methods.GET_USERS.getMethod() + Parameters.GET_INFO_BY_ID.getParameter()
				+ IDs.MY_ID.getId() + Parameters.GET_BDATE.getParameter() + VersionApi.V.getVersion();
				// + Access.TOKEN_APP.getToken();

		GetApiMethod request = new GetApiMethod(VK_API_URL + template);
		request.expectResponseStatus(HttpResponseStatusType.OK_200);
		JSONObject actual = (JSONObject) parser.parse(request.callAPI().asString());
		
		JSONObject expected = (JSONObject) parser
				.parse(new FileReader(ClassLoader.getSystemResource(USER_JSON).getFile()));
		
		Assert.assertEquals(actual, expected, "Data is not valid!");
		
		/*Assert.assertEquals(JsonUtils.getJSONValue("response.id", actual, true),
			JsonUtils.getJSONValue("id", expected, true), "User ids are not equal!");
		Assert.assertEquals(JsonUtils.getJSONValue("result.first_name", actual, true),
				JsonUtils.getJSONValue("first_name", expected, true), "User first names are not equal!");
		Assert.assertEquals(JsonUtils.getJSONValue("response.last_name", actual, true),
				JsonUtils.getJSONValue("last_name", expected, true), "Last_names ids are not equal!");
		Assert.assertEquals(JsonUtils.getJSONValue("response.bdate", actual, true),
				JsonUtils.getJSONValue("bdate", expected, true), "Bdates are not equal!");*/
	}

	@Test(description = "1.2 Verify sending a users info by id request (POST)")
	public void postMessageToUser() throws Exception {

		final String template = Methods.SEND_MSSG.getMethod() + Parameters.SELECT_ID.getParameter() + IDs.ALESYA.getId()
				+ Parameters.MESSAGE.getParameter() + VersionApi.V.getVersion() + Access.TOKEN_APP.getToken();

		PostApiMethod request = new PostApiMethod(VK_API_URL + template);
		request.expectResponseStatus(HttpResponseStatusType.OK_200);
		JSONObject actual = (JSONObject) parser.parse(request.callAPI().asString());
		Assert.assertEquals(JsonUtils.getJSONValue("response", actual, true), "943");
	
	}
}
