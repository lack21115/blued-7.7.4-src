package com.qiniu.android.utils;

import com.google.gson.Gson;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class Json {
  public static String encodeList(Collection paramCollection) {
    return (new JSONArray(paramCollection)).toString();
  }
  
  public static String encodeMap(Map paramMap) {
    return (new JSONObject(paramMap)).toString();
  }
  
  public static String object2Json(Object paramObject) {
    try {
      return (new Gson()).toJson(paramObject);
    } finally {
      paramObject = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\androi\\utils\Json.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */