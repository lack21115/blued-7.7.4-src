package com.huawei.hianalytics.ab.bc.kl;

import android.util.Pair;
import com.huawei.hianalytics.ab.bc.ef.ab;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ef {
  public static long ab(String paramString, long paramLong) {
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(paramString, Locale.getDefault());
      return simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(paramLong))).getTime();
    } catch (ParseException parseException) {
      ab.fg("hmsSdk/stringUtil", "getMillisOfDate(): Time conversion Exception !");
      return 0L;
    } 
  }
  
  public static Pair<String, String> ab(String paramString) {
    if (!"_default_config_tag".equals(paramString)) {
      String str1;
      String str2;
      String[] arrayOfString = paramString.split("-");
      if (arrayOfString.length > 2) {
        str1 = arrayOfString[arrayOfString.length - 1];
        int i = str1.length();
        str2 = paramString.substring(0, paramString.length() - i - 1);
        paramString = str1;
        str1 = str2;
      } else {
        str1 = str2[0];
        paramString = str2[1];
      } 
      return new Pair(str1, paramString);
    } 
    return new Pair(paramString, "");
  }
  
  public static String ab(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? "alltype" : "diffprivacy") : "preins") : "maint") : "oper";
  }
  
  public static String ab(String paramString1, String paramString2) {
    if ("_default_config_tag".equals(paramString1))
      return paramString1; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append("-");
    stringBuilder.append(paramString2);
    return stringBuilder.toString();
  }
  
  public static String ab(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder1;
    if ("_default_config_tag".equals(paramString1)) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("_default_config_tag#");
      stringBuilder1.append(paramString3);
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append((String)stringBuilder1);
    stringBuilder2.append("-");
    stringBuilder2.append(paramString2);
    stringBuilder2.append("#");
    stringBuilder2.append(paramString3);
    return stringBuilder2.toString();
  }
  
  public static Set<String> ab(Set<String> paramSet) {
    if (paramSet == null || paramSet.size() == 0)
      return new HashSet<String>(); 
    HashSet<String> hashSet = new HashSet();
    for (String str : paramSet) {
      if (!"_default_config_tag".equals(str)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str);
        stringBuilder1.append("-");
        stringBuilder1.append("oper");
        String str1 = stringBuilder1.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append("-");
        stringBuilder2.append("maint");
        String str2 = stringBuilder2.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str);
        stringBuilder3.append("-");
        stringBuilder3.append("diffprivacy");
        str = stringBuilder3.toString();
        hashSet.add(str1);
        hashSet.add(str2);
        hashSet.add(str);
        continue;
      } 
      hashSet.add("_default_config_tag");
    } 
    return hashSet;
  }
  
  public static JSONObject ab(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3) {
    JSONObject jSONObject = paramJSONObject;
    if (paramJSONObject == null)
      jSONObject = new JSONObject(); 
    try {
      if ("OnPause".equals(paramString3))
        jSONObject.put("_event_duration", paramString2); 
      jSONObject.put("_activity_name", paramString1);
      return jSONObject;
    } catch (JSONException jSONException) {
      ab.fg("hmsSdk/stringUtil", "getEventContent(): JSONException");
      return jSONObject;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\kl\ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */