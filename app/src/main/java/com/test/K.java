package com.test;

import android.content.Context;


import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class K {
	
	private static String str = "ordertype=0&action=getcardetails&cid=2401&entry=taocheapp&pindex=1&v=5.9.6&getlist=0&cartype=1&psize=20&yidaid=e3ae8261-2fb7-4e1e-ab02-1cd7ec3f639e&imei=862002031581104&ucarid=13588289&scale=3&carconf=222222222222222222&orderid=0";

	
	  @SuppressWarnings("rawtypes")
	public static  Map<String, String> c(){
		HashMap<String,String> localHashMap = new HashMap<String,String>();
		String key = "com.taoche.appapi";
		//Map localMap = this.w.c;
		Map<String,String> localMap = new HashMap<String,String>();
		String p [] = str.split("&");
		for (String str_ : p) {
			String p1 [] = str_.split("=");
			localMap.put(p1[0], p1[1]);
		}
		localMap.put("v", "5.9.6");
		  localMap=b(localMap);
		String str1 = System.currentTimeMillis() + "";
		String str3 = "4CE2F5717538336340B7ED53D8D384009B66FF306B3F2016EAC056BE9CB0163C437D187CB81AA3530022DB3902D8CEE55518C93E5D37C40DED3184036518B4EDE050E6EFD29502C6D6D1D7B175A69C20845A09D21CE77D5ABD7069E596F158DC4718AAD1B25848E587029210982FBD612BF367ECFBA49D2152356B66B5F932A82AFDFFF74512FA802B3EF38D664AE39AF1F971E05D74CA768CA444CDD4C78D54A3A4C554DA092A45504D5AF53104F94F85421177933684CBD09509B079640BE9964B5DB5E5254AC639B2AFBA86E896A2E56F458FA30B50950B80320F824843C44A34F1A95FF14A1DC802FA68DC17C05DA9DBA123529726A8AC1D9B6DDFA6CD15C71D2B154EB25B11924B1F9D0B554809B1C8D6D8D72C680BBEBE3D4D648A5173CE1CC7656E252434F18010E9A0672905"; //appuk
		String str4 = "862002031581104";
		String str5 = str1 + a(localMap) + key;
		String str6 = a(a(str5));
		localHashMap.put("appid", "app.android");
		localHashMap.put("appuk", str3);
		localHashMap.put("timestamp", str1);
		localHashMap.put("signature", str6);
		localHashMap.put("devicetoken", str4);
		return localHashMap;

	  }

	  public static String a(String paramString){
	    int i = 0;
	    char[] arrayOfChar1 = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
	    try{
	      byte[] arrayOfByte1 = paramString.getBytes();
	      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
	      localMessageDigest.update(arrayOfByte1);
	      byte[] arrayOfByte2 = localMessageDigest.digest();
	      int j = arrayOfByte2.length;
	      char[] arrayOfChar2 = new char[j * 2];
	      int k = 0;
	      while (i < j)
	      {
	        int m = arrayOfByte2[i];
	        int n = k + 1;
	        arrayOfChar2[k] = arrayOfChar1[(0xF & m >>> 4)];
	        k = n + 1;
	        arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
	        i++;
	      }
	      String str = new String(arrayOfChar2).toUpperCase();
	      return str;
	    }
	    catch (Exception localException)
	    {
	      localException.printStackTrace();
	    }
	    return null;
	  }
	  
	  public static String a(Map<String, String> paramMap){
	    SortedMap localSortedMap = b(paramMap);
	    if (localSortedMap == null) {
	      return null;
	    }
	    StringBuffer localStringBuffer = new StringBuffer();
	    localSortedMap.remove("action");
	    Iterator localIterator = localSortedMap.entrySet().iterator();
	    while (localIterator.hasNext())
	    {
	      Map.Entry localEntry = (Map.Entry)localIterator.next();
	      localStringBuffer.append((String)localEntry.getKey() + (String)localEntry.getValue());
	    }
	    return localStringBuffer.toString();
	  }

	  public static SortedMap<String, String> b(Map<String, String> paramMap)
	  {
	    if (paramMap == null) {
	      return null;
	    }
	    TreeMap localTreeMap = new TreeMap();
	    Iterator localIterator = paramMap.keySet().iterator();
	    while (localIterator.hasNext())
	    {
	      String str = (String)localIterator.next();
	      Object localObject = paramMap.get(str);
	      if ((localObject != null) && (!"".equals(localObject))) {
	        localTreeMap.put(str, localObject.toString());
	      }
	    }
	    return localTreeMap;
	  }



}
