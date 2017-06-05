package com.qaprosoft.tests;

import com.qaprosoft.utils.vk.Access;
import com.qaprosoft.utils.vk.IDs;
import com.qaprosoft.utils.vk.Methods;
import com.qaprosoft.utils.vk.Parameters;
import com.qaprosoft.utils.vk.VersionApi;

public class StringsTest {
	public static void main(String[] args){
	String TEMPLATE = Methods.GET_USERS.getMethod() + Parameters.GET_INFO_BY_ID.getParameter()
	+ IDs.MY_ID.getId() + Parameters.GET_BDATE.getParameter() + VersionApi.V.getVersion()
	+ Access.TOKEN_JOB.getToken();

	System.out.println(TEMPLATE);
	
	String TEMPLATE2 = Methods.SEND_MSSG.getMethod() + Parameters.SELECT_ID.getParameter()
	+ IDs.SSEMKOV_ID.getId() + Parameters.MESSAGE.getParameter() + VersionApi.V.getVersion()
	+ Access.TOKEN_APP.getToken();
	
	System.out.println(TEMPLATE2);
	
	}
}
