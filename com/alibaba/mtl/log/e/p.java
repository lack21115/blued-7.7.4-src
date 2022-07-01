package com.alibaba.mtl.log.e;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class p {
  public static Map<String, String> b(Map<String, String> paramMap) {
    if (paramMap != null) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      for (String str : paramMap.keySet()) {
        if (str instanceof String) {
          String str1 = paramMap.get(str);
          if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str1))
            try {
              hashMap.put(URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(str1, "UTF-8"));
            } catch (UnsupportedEncodingException unsupportedEncodingException) {
              unsupportedEncodingException.printStackTrace();
            }  
        } 
      } 
      return (Map)hashMap;
    } 
    return paramMap;
  }
  
  public static String c(Map<String, String> paramMap) {
    if (paramMap != null) {
      boolean bool = true;
      StringBuffer stringBuffer = new StringBuffer();
      for (String str2 : paramMap.keySet()) {
        String str1 = convertObjectToString(paramMap.get(str2));
        str2 = convertObjectToString(str2);
        if (str1 != null && str2 != null) {
          if (bool) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(str2);
            stringBuilder1.append("=");
            stringBuilder1.append(str1);
            stringBuffer.append(stringBuilder1.toString());
            bool = false;
            continue;
          } 
          stringBuffer.append(",");
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str2);
          stringBuilder.append("=");
          stringBuilder.append(str1);
          stringBuffer.append(stringBuilder.toString());
        } 
      } 
      return stringBuffer.toString();
    } 
    return null;
  }
  
  public static String convertObjectToString(Object paramObject) {
    if (paramObject != null) {
      if (paramObject instanceof String)
        return ((String)paramObject).toString(); 
      if (paramObject instanceof Integer) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(((Integer)paramObject).intValue());
        return stringBuilder.toString();
      } 
      if (paramObject instanceof Long) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(((Long)paramObject).longValue());
        return stringBuilder.toString();
      } 
      if (paramObject instanceof Double) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(((Double)paramObject).doubleValue());
        return stringBuilder.toString();
      } 
      if (paramObject instanceof Float) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(((Float)paramObject).floatValue());
        return stringBuilder.toString();
      } 
      if (paramObject instanceof Short) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(((Short)paramObject).shortValue());
        return stringBuilder.toString();
      } 
      if (paramObject instanceof Byte) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(((Byte)paramObject).byteValue());
        return stringBuilder.toString();
      } 
      return (paramObject instanceof Boolean) ? ((Boolean)paramObject).toString() : ((paramObject instanceof Character) ? ((Character)paramObject).toString() : paramObject.toString());
    } 
    return "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */