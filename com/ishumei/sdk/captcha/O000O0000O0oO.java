package com.ishumei.sdk.captcha;

import android.text.TextUtils;
import java.io.Closeable;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class O000O0000O0oO {
  public static String O0000O000000oO(String paramString) {
    if (paramString != null) {
      if (paramString.length() == 0)
        return ""; 
      try {
        return URLDecoder.decode(paramString, "UTF-8");
      } catch (Exception exception) {
        return "";
      } 
    } 
    return "";
  }
  
  public static JSONArray O0000O000000oO(Object paramObject) {
    if (paramObject.getClass().isArray()) {
      int j = Array.getLength(paramObject);
      JSONArray jSONArray = new JSONArray();
      for (int i = 0; i < j; i++)
        jSONArray.put(O000O00000OoO(Array.get(paramObject, i))); 
      return jSONArray;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Not a primitive data: ");
    stringBuilder.append(paramObject.getClass());
    throw new JSONException(stringBuilder.toString());
  }
  
  public static JSONArray O0000O000000oO(Collection paramCollection) {
    JSONArray jSONArray = new JSONArray();
    if (paramCollection != null) {
      Iterator iterator = paramCollection.iterator();
      while (iterator.hasNext())
        jSONArray.put(O000O00000OoO(iterator.next())); 
    } 
    return jSONArray;
  }
  
  public static JSONObject O0000O000000oO(Map<?, ?> paramMap) {
    JSONObject jSONObject = new JSONObject();
    try {
      Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
      while (true) {
        if (iterator.hasNext()) {
          Map.Entry entry = iterator.next();
          String str = (String)entry.getKey();
          if (str != null) {
            try {
              jSONObject.put(str, O000O00000OoO(entry.getValue()));
            } catch (JSONException jSONException) {}
            continue;
          } 
          throw new NullPointerException("key == null");
        } 
        return jSONObject;
      } 
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  public static void O0000O000000oO(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static void O0000O000000oO(HttpURLConnection paramHttpURLConnection) {
    if (paramHttpURLConnection != null)
      try {
        paramHttpURLConnection.disconnect();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  private static Object O000O00000OoO(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (!(paramObject instanceof JSONArray)) {
      if (paramObject instanceof JSONObject)
        return paramObject; 
      try {
        if (paramObject instanceof Collection)
          return O0000O000000oO((Collection)paramObject); 
        if (paramObject.getClass().isArray())
          return O0000O000000oO(paramObject); 
        if (paramObject instanceof Map)
          return O0000O000000oO((Map<?, ?>)paramObject); 
        Object object = paramObject;
        if (!(paramObject instanceof Boolean)) {
          object = paramObject;
          if (!(paramObject instanceof Byte)) {
            object = paramObject;
            if (!(paramObject instanceof Character)) {
              object = paramObject;
              if (!(paramObject instanceof Double)) {
                object = paramObject;
                if (!(paramObject instanceof Float)) {
                  object = paramObject;
                  if (!(paramObject instanceof Integer)) {
                    object = paramObject;
                    if (!(paramObject instanceof Long)) {
                      object = paramObject;
                      if (!(paramObject instanceof Short)) {
                        if (paramObject instanceof String)
                          return paramObject; 
                        if (paramObject.getClass().getPackage().getName().startsWith("java."))
                          return paramObject.toString(); 
                      } else {
                        return object;
                      } 
                    } else {
                      return object;
                    } 
                  } else {
                    return object;
                  } 
                } else {
                  return object;
                } 
              } else {
                return object;
              } 
            } else {
              return object;
            } 
          } else {
            return object;
          } 
        } else {
          return object;
        } 
        return null;
      } catch (Exception exception) {
        return null;
      } 
    } 
    return exception;
  }
  
  public static String O000O00000OoO(String paramString) {
    if (paramString != null) {
      if (paramString.length() == 0)
        return ""; 
      try {
        return URLEncoder.encode(paramString, "UTF-8");
      } catch (Exception exception) {
        return "";
      } 
    } 
    return "";
  }
  
  public static String O000O00000OoO(Map<String, String> paramMap) {
    if (paramMap == null || paramMap.size() == 0)
      return ""; 
    int i = 0;
    StringBuilder stringBuilder = new StringBuilder();
    for (String str1 : paramMap.keySet()) {
      String str2 = paramMap.get(str1);
      stringBuilder.append(str1);
      stringBuilder.append("=");
      stringBuilder.append(O000O00000OoO(str2));
      int j = i + 1;
      i = j;
      if (j < paramMap.size()) {
        stringBuilder.append("&");
        i = j;
      } 
    } 
    return stringBuilder.toString();
  }
  
  public static Map<String, String> O000O00000o0O(String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (TextUtils.isEmpty(paramString))
      return (Map)hashMap; 
    int i = paramString.indexOf("?");
    if (i != -1) {
      if (++i == paramString.length())
        return (Map)hashMap; 
      String[] arrayOfString = paramString.substring(i).split("&");
      if (arrayOfString.length == 0)
        return (Map)hashMap; 
      int j = arrayOfString.length;
      for (i = 0; i < j; i++) {
        String[] arrayOfString1 = arrayOfString[i].split("=", 2);
        if (arrayOfString1.length == 2)
          hashMap.put(arrayOfString1[0], O0000O000000oO(arrayOfString1[1])); 
      } 
    } 
    return (Map)hashMap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\sdk\captcha\O000O0000O0oO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */