package com.kingroot.springboot.nisum.app.utils;

import java.util.HashMap;

public class MessageUtilReturn {

	  public static HashMap<Object,Object> responseMessage(String key, Object value) {
		  	HashMap<Object,Object>  response = new HashMap<Object, Object>();
	        response.put(key, value);
	        return response;
	    }
	
}
