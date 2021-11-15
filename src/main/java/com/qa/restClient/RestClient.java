package com.qa.restClient;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
//Get MEthod
	public void get(String url) throws ClientProtocolException, IOException {
		
	CloseableHttpClient httpClient=HttpClients.createDefault();
	HttpGet httpget=new HttpGet(url);//http get request
	
	CloseableHttpResponse closablehttpresponse=httpClient.execute(httpget);//hit the GET url
	
	//a-status code
	int statusCode=closablehttpresponse.getStatusLine().getStatusCode();
	System.out.println("Status code is: "+statusCode);
	
	
	//JSON String
	
	
	String responseString=EntityUtils.toString(closablehttpresponse.getEntity(),"UTF-8");
	
	JSONObject responseJSON=new JSONObject(responseString);
	System.out.println("Json Code is : "+responseJSON);
	
	//All Headers
	
	Header[] headerArray=closablehttpresponse.getAllHeaders();
	
	HashMap<String, String> allHeaders=new HashMap<String, String>();
	
	for(Header header:headerArray) {
		
		allHeaders.put(header.getName(), header.getValue());
	}
	System.out.println("Headers Array-->"+allHeaders);
	
	}
	
	
	
	
	
	
	
}
