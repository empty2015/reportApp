package com.test;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

//import org.apache.log4j.Logger;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.hsfs.Conf;
//import com.hsfs.Init;
//import com.task.JobUtil2;

public class HttpClient2{
//	static Logger logger = Logger.getLogger(HttpClient2.class);
  public static String getContent(String urlPath){
	 InputStreamReader inputStreamReader = null;
	 BufferedReader bufferedReader = null;
	 HttpURLConnection connection = null;
	 StringBuilder pageHTML = new StringBuilder();;
    try {
      URL url = new URL(urlPath);
      connection = (HttpURLConnection)url.openConnection();
      Map<String,String> paramskey_value = K.c();
      System.out.println(paramskey_value);
    
      connection.setRequestProperty("appid", paramskey_value.get("appid"));
      connection.setRequestProperty("appuk", paramskey_value.get("appuk"));
      connection.setRequestProperty("devicetoken", paramskey_value.get("devicetoken"));
      connection.setRequestProperty("signature", paramskey_value.get("signature"));
      connection.setRequestProperty("timestamp", paramskey_value.get("timestamp"));
      connection.setRequestProperty("Accept-Encoding", "gzip");
//      connection.setRequestProperty("Cache-Control", "private");
//      connection.setRequestProperty("Vary", "Accept-Encoding");
//      connection.setRequestProperty("X-Cache", "MISS from ucar_7302_bitautotech.com");
      connection.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
      connection.setRequestProperty("Accept-Language", "zh-CN");
      //appid: app.android
      connection.setRequestProperty("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 6.0; EVA-AL10 Build/HUAWEIEVA-AL10)");
      connection.setRequestProperty("Host", "appapi.taoche.cn");
      connection.setRequestProperty("Connection", "Keep-Alive");
      
      connection.setConnectTimeout(10000);
      connection.setReadTimeout(10000);
      
      inputStreamReader = new InputStreamReader(connection.getInputStream(), "UTF-8");
      bufferedReader = new BufferedReader(inputStreamReader);
      
      pageHTML.delete(0, pageHTML.length());
      String line = null;
      while ((line = bufferedReader.readLine()) != null) {
        pageHTML.append(line);
      }
    } catch (Exception e) {
//    		ExceptionRecord.record(e.fillInStackTrace().toString());
        e.printStackTrace();
    }finally{
    		try {
    			if(null != inputStreamReader){
    				inputStreamReader.close();
    			}
				if(null != bufferedReader){
		    		bufferedReader.close();
		    	}
		        if(null != connection){
		        	connection.disconnect();
		    	}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    return pageHTML.toString();
  }

  public static String getHost(String url) {
    String tem = url.substring(url.indexOf(":") + 3);
    tem = tem.substring(0, tem.indexOf("/"));
    return tem;
  }

  public static void main(String[] args) throws UnsupportedEncodingException{
	  
	  //String url = "http://cheapi.58.com/api/detail/phone/get/28299589496892?clientType=7";
	  //System.out.println(Init.getMobileByInfoId("28251031031611"));
  String str ="http://appapi.taoche.cn/get?v=5.9.6&psize=6&yidaid=e3ae8261-2fb7-4e1e-ab02-1cd7ec3f639e&imei=862002031581104&ordertype=0&action=getcarlist&brandid=3698&cid=2401&entry=taocheapp&exucarids=13313773&pindex=1&orderid=0";
//	  String Str2 = "http://appapi.taoche.cn/get?action=getcardetails&v=5.9.6&scale=2&ucarid=13313773";
	  //System.out.println(JSONObject.parse(getContent("http://appapi.taoche.cn/get?ordertype=0&action=getcardetails&cid=2401&entry=taocheapp&pindex=1&v=5.9.6&getlist=0&cartype=1&psize=20&yidaid=e3ae8261-2fb7-4e1e-ab02-1cd7ec3f639e&imei=862002031581104&ucarid=13588289&scale=3&carconf=222222222222222222&orderid=0")));
	  Log.e("app",getContent("http://appapi.taoche.cn/get?ordertype=0&action=getcardetails&cid=2401&entry=taocheapp&pindex=1&v=5.9.6&getlist=0&cartype=1&psize=20&yidaid=e3ae8261-2fb7-4e1e-ab02-1cd7ec3f639e&imei=862002031581104&ucarid=13588289&scale=3&carconf=222222222222222222&orderid=0"));
	 // System.out.println(UCARJNI.a().signKey());
     }
}
