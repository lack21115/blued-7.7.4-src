package com.facebook.stetho.inspector.domstorage;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;

public class SharedPreferencesHelper {
  private static final String PREFS_SUFFIX = ".xml";
  
  public static List<String> getSharedPreferenceTags(Context paramContext) {
    ArrayList<String> arrayList = new ArrayList();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append((paramContext.getApplicationInfo()).dataDir);
    stringBuilder.append("/shared_prefs");
    File file = new File(stringBuilder.toString());
    if (file.exists()) {
      File[] arrayOfFile = file.listFiles();
      int j = arrayOfFile.length;
      for (int i = 0; i < j; i++) {
        String str = arrayOfFile[i].getName();
        if (str.endsWith(".xml"))
          arrayList.add(str.substring(0, str.length() - 4)); 
      } 
    } 
    Collections.sort(arrayList);
    return arrayList;
  }
  
  private static Boolean parseBoolean(String paramString) throws IllegalArgumentException {
    if ("1".equals(paramString) || "true".equalsIgnoreCase(paramString))
      return Boolean.TRUE; 
    if ("0".equals(paramString) || "false".equalsIgnoreCase(paramString))
      return Boolean.FALSE; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected boolean, got ");
    stringBuilder.append(paramString);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  @Nullable
  public static Object valueFromString(String paramString, Object paramObject) throws IllegalArgumentException {
    if (paramObject instanceof Integer)
      return Integer.valueOf(Integer.parseInt(paramString)); 
    if (paramObject instanceof Long)
      return Long.valueOf(Long.parseLong(paramString)); 
    if (paramObject instanceof Float)
      return Float.valueOf(Float.parseFloat(paramString)); 
    if (paramObject instanceof Boolean)
      return parseBoolean(paramString); 
    if (paramObject instanceof String)
      return paramString; 
    if (paramObject instanceof Set)
      try {
        JSONArray jSONArray = new JSONArray(paramString);
        int j = jSONArray.length();
        paramObject = new HashSet(j);
        for (int i = 0; i < j; i++)
          paramObject.add(jSONArray.getString(i)); 
        return paramObject;
      } catch (JSONException jSONException) {
        throw new IllegalArgumentException(jSONException);
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unsupported type: ");
    stringBuilder.append(paramObject.getClass().getName());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static String valueToString(Object paramObject) {
    if (paramObject != null) {
      if (paramObject instanceof Set) {
        JSONArray jSONArray = new JSONArray();
        paramObject = ((Set)paramObject).iterator();
        while (paramObject.hasNext())
          jSONArray.put(paramObject.next()); 
        return jSONArray.toString();
      } 
      return paramObject.toString();
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\domstorage\SharedPreferencesHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */