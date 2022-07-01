package com.huawei.hms.push.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
  public static void a(JSONObject paramJSONObject, String paramString, Object paramObject, Bundle paramBundle) {
    if (paramObject == null) {
      HMSLog.w("JsonUtil", "transfer jsonObject to bundle failed, defaultValue is null.");
      return;
    } 
    if (paramObject instanceof String) {
      String str = (String)paramObject;
      paramObject = str;
      if (TextUtils.isEmpty(str))
        paramObject = null; 
      paramBundle.putString(paramString, getString(paramJSONObject, paramString, (String)paramObject));
      return;
    } 
    if (paramObject instanceof Integer) {
      paramBundle.putInt(paramString, getInt(paramJSONObject, paramString, ((Integer)paramObject).intValue()));
      return;
    } 
    if (paramObject instanceof int[]) {
      int[] arrayOfInt = (int[])paramObject;
      paramObject = arrayOfInt;
      if (arrayOfInt.length == 0)
        paramObject = null; 
      paramBundle.putIntArray(paramString, getIntArray(paramJSONObject, paramString, (int[])paramObject));
      return;
    } 
    if (paramObject instanceof long[]) {
      long[] arrayOfLong = (long[])paramObject;
      paramObject = arrayOfLong;
      if (arrayOfLong.length == 0)
        paramObject = null; 
      paramBundle.putLongArray(paramString, getLongArray(paramJSONObject, paramString, (long[])paramObject));
      return;
    } 
    if (paramObject instanceof String[]) {
      String[] arrayOfString = (String[])paramObject;
      paramObject = arrayOfString;
      if (arrayOfString.length == 0)
        paramObject = null; 
      paramBundle.putStringArray(paramString, getStringArray(paramJSONObject, paramString, (String[])paramObject));
      return;
    } 
    HMSLog.w("JsonUtil", "transfer jsonObject to bundle failed, invalid data type.");
  }
  
  public static int getInt(JSONObject paramJSONObject, String paramString, int paramInt) {
    if (paramJSONObject != null)
      try {
        if (paramJSONObject.has(paramString))
          return paramJSONObject.getInt(paramString); 
      } catch (JSONException jSONException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JSONException: get ");
        stringBuilder.append(paramString);
        stringBuilder.append(" error.");
        HMSLog.w("JsonUtil", stringBuilder.toString());
      }  
    return paramInt;
  }
  
  public static int[] getIntArray(JSONObject paramJSONObject, String paramString, int[] paramArrayOfint) {
    int[] arrayOfInt3 = null;
    int[] arrayOfInt1 = null;
    int[] arrayOfInt2 = arrayOfInt1;
    if (paramJSONObject != null) {
      arrayOfInt2 = arrayOfInt1;
      arrayOfInt1 = arrayOfInt3;
      try {
        if (paramJSONObject.has(paramString)) {
          arrayOfInt1 = arrayOfInt3;
          JSONArray jSONArray = paramJSONObject.getJSONArray(paramString);
          arrayOfInt1 = arrayOfInt3;
          int[] arrayOfInt = new int[jSONArray.length()];
          int i = 0;
          while (true) {
            arrayOfInt2 = arrayOfInt;
            arrayOfInt1 = arrayOfInt;
            if (i < jSONArray.length()) {
              arrayOfInt1 = arrayOfInt;
              arrayOfInt[i] = ((Integer)jSONArray.get(i)).intValue();
              i++;
              continue;
            } 
            break;
          } 
        } 
      } catch (JSONException jSONException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JSONException: get ");
        stringBuilder.append(paramString);
        stringBuilder.append(" error.");
        HMSLog.w("JsonUtil", stringBuilder.toString());
        arrayOfInt2 = arrayOfInt1;
      } 
    } 
    return (arrayOfInt2 == null) ? paramArrayOfint : arrayOfInt2;
  }
  
  public static JSONArray getIntJsonArray(int[] paramArrayOfint) {
    JSONArray jSONArray = new JSONArray();
    if (paramArrayOfint != null) {
      if (paramArrayOfint.length == 0)
        return jSONArray; 
      int j = paramArrayOfint.length;
      for (int i = 0; i < j; i++)
        jSONArray.put(paramArrayOfint[i]); 
    } 
    return jSONArray;
  }
  
  public static long[] getLongArray(JSONObject paramJSONObject, String paramString, long[] paramArrayOflong) {
    long[] arrayOfLong3 = null;
    long[] arrayOfLong1 = null;
    long[] arrayOfLong2 = arrayOfLong1;
    if (paramJSONObject != null) {
      arrayOfLong2 = arrayOfLong1;
      arrayOfLong1 = arrayOfLong3;
      try {
        if (paramJSONObject.has(paramString)) {
          arrayOfLong1 = arrayOfLong3;
          JSONArray jSONArray = paramJSONObject.getJSONArray(paramString);
          arrayOfLong1 = arrayOfLong3;
          long[] arrayOfLong = new long[jSONArray.length()];
          int i = 0;
          while (true) {
            arrayOfLong2 = arrayOfLong;
            arrayOfLong1 = arrayOfLong;
            if (i < jSONArray.length()) {
              arrayOfLong1 = arrayOfLong;
              arrayOfLong[i] = jSONArray.getLong(i);
              i++;
              continue;
            } 
            break;
          } 
        } 
      } catch (JSONException jSONException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JSONException: get ");
        stringBuilder.append(paramString);
        stringBuilder.append(" error.");
        HMSLog.w("JsonUtil", stringBuilder.toString());
        arrayOfLong2 = arrayOfLong1;
      } 
    } 
    return (arrayOfLong2 == null) ? paramArrayOflong : arrayOfLong2;
  }
  
  public static JSONArray getLongJsonArray(long[] paramArrayOflong) {
    JSONArray jSONArray = new JSONArray();
    if (paramArrayOflong != null) {
      if (paramArrayOflong.length == 0)
        return jSONArray; 
      int j = paramArrayOflong.length;
      for (int i = 0; i < j; i++)
        jSONArray.put(paramArrayOflong[i]); 
    } 
    return jSONArray;
  }
  
  public static String getString(JSONObject paramJSONObject, String paramString1, String paramString2) {
    if (paramJSONObject != null)
      try {
        if (paramJSONObject.has(paramString1) && paramJSONObject.get(paramString1) != null)
          return String.valueOf(paramJSONObject.get(paramString1)); 
      } catch (JSONException jSONException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JSONException: get ");
        stringBuilder.append(paramString1);
        stringBuilder.append(" error.");
        HMSLog.w("JsonUtil", stringBuilder.toString());
      }  
    return paramString2;
  }
  
  public static String[] getStringArray(JSONObject paramJSONObject, String paramString, String[] paramArrayOfString) {
    String[] arrayOfString2 = null;
    paramArrayOfString = null;
    String[] arrayOfString1 = paramArrayOfString;
    if (paramJSONObject != null) {
      arrayOfString1 = paramArrayOfString;
      paramArrayOfString = arrayOfString2;
      try {
        if (paramJSONObject.has(paramString)) {
          paramArrayOfString = arrayOfString2;
          JSONArray jSONArray = paramJSONObject.getJSONArray(paramString);
          paramArrayOfString = arrayOfString2;
          String[] arrayOfString = new String[jSONArray.length()];
          int i = 0;
          while (true) {
            arrayOfString1 = arrayOfString;
            paramArrayOfString = arrayOfString;
            if (i < jSONArray.length()) {
              paramArrayOfString = arrayOfString;
              arrayOfString[i] = (String)jSONArray.get(i);
              i++;
              continue;
            } 
            break;
          } 
        } 
      } catch (JSONException jSONException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JSONException: get ");
        stringBuilder.append(paramString);
        stringBuilder.append(" error.");
        HMSLog.w("JsonUtil", stringBuilder.toString());
        arrayOfString1 = paramArrayOfString;
      } 
    } 
    return arrayOfString1;
  }
  
  public static JSONArray getStringJsonArray(String[] paramArrayOfString) {
    JSONArray jSONArray = new JSONArray();
    if (paramArrayOfString != null) {
      if (paramArrayOfString.length == 0)
        return jSONArray; 
      int j = paramArrayOfString.length;
      for (int i = 0; i < j; i++)
        jSONArray.put(paramArrayOfString[i]); 
    } 
    return jSONArray;
  }
  
  public static void transferJsonObjectToBundle(JSONObject paramJSONObject, Bundle paramBundle, HashMap<String, Object> paramHashMap) {
    for (Map.Entry<String, Object> entry : paramHashMap.entrySet())
      a(paramJSONObject, (String)entry.getKey(), entry.getValue(), paramBundle); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\pus\\utils\JsonUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */