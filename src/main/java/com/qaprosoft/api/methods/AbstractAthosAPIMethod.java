package com.qaprosoft.api.methods;

import org.hamcrest.Matchers;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethod;
import com.qaprosoft.carina.core.foundation.http.HttpResponseStatusType;

public class AbstractAthosAPIMethod extends AbstractApiMethod
{

	@Override
	public void expectResponseStatus(HttpResponseStatusType status)
	{
		if(status.getCode() == 202)
		{
//			TODO: Add 201 CREATED status to CARINA
			request.expect().statusCode(201);
			request.expect().statusLine(Matchers.containsString("CREATED"));
		} else
		{
			request.expect().statusCode(status.getCode());
			request.expect().statusLine(Matchers.containsString(status.getMessage().toUpperCase()));
		}
	}
}
