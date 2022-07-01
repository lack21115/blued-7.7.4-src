package com.idlefish.flutterboost;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.alibaba.fastjson.JSON;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.Map;

public class Utils {
  public static String a(String paramString, Map<String, Object> paramMap) {
    StringBuilder stringBuilder = new StringBuilder(paramString);
    if (paramMap != null && !paramMap.isEmpty()) {
      if (!stringBuilder.toString().contains("?"))
        stringBuilder.append("?"); 
      for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
        if (entry.getValue() instanceof Map)
          for (Map.Entry entry1 : ((Map)entry.getValue()).entrySet()) {
            String str1;
            String str2 = (String)entry1.getKey();
            boolean bool = entry1.getValue() instanceof Map;
            entry = null;
            if (bool || entry1.getValue() instanceof java.util.List) {
              try {
                String str = URLEncoder.encode(JSON.toJSONString(entry1.getValue()), "UTF-8");
                str1 = str;
              } catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
              } 
            } else if (unsupportedEncodingException.getValue() != null) {
              str1 = URLEncoder.encode(String.valueOf(unsupportedEncodingException.getValue()));
            } 
            if (str1 == null)
              continue; 
            if (stringBuilder.toString().endsWith("?")) {
              stringBuilder.append(str2);
              stringBuilder.append("=");
              stringBuilder.append(str1);
              continue;
            } 
            stringBuilder.append("&");
            stringBuilder.append(str2);
            stringBuilder.append("=");
            stringBuilder.append(str1);
          }  
      } 
    } 
    return stringBuilder.toString();
  }
  
  public static void a() {
    if (Looper.myLooper() != Looper.getMainLooper())
      Debuger.b("must call method on main thread"); 
  }
  
  public static void a(Context paramContext) {
    if (paramContext == null)
      return; 
    InputMethodManager inputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    if (inputMethodManager == null)
      return; 
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "mLastSrvView";
    arrayOfString[1] = "mServedView";
    arrayOfString[2] = "mNextServedView";
    int i = 0;
    while (true) {
      if (i < arrayOfString.length) {
        String str = arrayOfString[i];
        try {
          Field field = inputMethodManager.getClass().getDeclaredField(str);
          if (!field.isAccessible())
            field.setAccessible(true); 
          Object object = field.get(inputMethodManager);
          if (object != null && object instanceof View)
            if (((View)object).getContext() == paramContext) {
              field.set(inputMethodManager, (Object)null);
            } else {
              return;
            }  
        } finally {}
        i++;
        continue;
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */