package com.datavisor.vangogh.f;

import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class a {
  public static boolean a(String paramString) {
    if (paramString != null) {
      int j = paramString.length();
      if (j == 0)
        return true; 
      for (int i = 0; i < j; i++) {
        if (!Character.isWhitespace(paramString.charAt(i)))
          return false; 
      } 
    } 
    return true;
  }
  
  public static boolean a(Map paramMap) {
    return (paramMap == null || paramMap.size() <= 0);
  }
  
  public static JSONObject b(Map<String, String> paramMap) {
    JSONObject jSONObject = new JSONObject();
    if (a(paramMap))
      return jSONObject; 
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    try {
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        jSONObject.put((String)entry.getKey(), entry.getValue());
      } 
    } finally {
      iterator = null;
    } 
  }
  
  public static boolean b(String paramString) {
    return a(paramString) ^ true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */