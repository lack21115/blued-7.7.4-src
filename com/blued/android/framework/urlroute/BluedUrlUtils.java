package com.blued.android.framework.urlroute;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class BluedUrlUtils {
  public static Map<String, String> a(String paramString) {
    int i = paramString.indexOf("?");
    if (i > 0 && i < paramString.length() - 1) {
      paramString = paramString.substring(i + 1);
    } else {
      paramString = null;
    } 
    if (TextUtils.isEmpty(paramString))
      return null; 
    ArrayMap<String, String> arrayMap = new ArrayMap();
    String[] arrayOfString = paramString.split("&");
    if (arrayOfString.length > 0)
      for (i = 0; i < arrayOfString.length; i++) {
        String[] arrayOfString1 = arrayOfString[i].split("=");
        if (arrayOfString1.length == 2) {
          paramString = arrayOfString1[1];
          try {
            String str = URLDecoder.decode(arrayOfString1[1], "utf-8");
            paramString = str;
          } catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
          } catch (Exception exception) {
            exception.printStackTrace();
          } 
          arrayMap.put(arrayOfString1[0].toLowerCase(), paramString);
        } 
      }  
    return (Map<String, String>)arrayMap;
  }
  
  public static Map<String, String> b(String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Map<String, String> map = a(paramString);
    if (map != null) {
      String str = map.get("blued_mode");
      if (!TextUtils.isEmpty(str))
        hashMap.put("blued_mode", str); 
    } 
    return (Map)hashMap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\urlroute\BluedUrlUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */