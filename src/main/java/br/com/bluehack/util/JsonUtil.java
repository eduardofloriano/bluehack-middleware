package br.com.bluehack.util;

import com.google.gson.Gson;

public class JsonUtil {

	public static String toJson(String param){
		return new Gson().toJson(param);
	}
	
}
