package com.huawei.hianalytics.ab.bc.kl;

import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.ef.ab;
import java.util.Map;
import java.util.regex.Pattern;

public class cd {
  public static String ab(String paramString1, String paramString2, String paramString3, String paramString4) {
    StringBuilder stringBuilder;
    if (TextUtils.isEmpty(paramString2)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("checkStrParameter() Parameter verification failure! Parameter:");
      stringBuilder.append(paramString1);
      ab.fg("hmsSdk", stringBuilder.toString());
      return paramString4;
    } 
    return (String)(ab(paramString1, (String)stringBuilder, paramString3) ? stringBuilder : paramString4);
  }
  
  public static boolean ab(String paramString) {
    return ab("eventId", paramString, 256) ^ true;
  }
  
  public static boolean ab(String paramString1, String paramString2, int paramInt) {
    StringBuilder stringBuilder;
    if (TextUtils.isEmpty(paramString2)) {
      stringBuilder = new StringBuilder();
      String str = "checkString() Parameter is empty : ";
      stringBuilder.append(str);
      stringBuilder.append(paramString1);
      ab.fg("hmsSdk", stringBuilder.toString());
      return false;
    } 
    if (stringBuilder.length() > paramInt) {
      stringBuilder = new StringBuilder();
      String str = "checkString() Failure of parameter length check! Parameter:";
      stringBuilder.append(str);
      stringBuilder.append(paramString1);
      ab.fg("hmsSdk", stringBuilder.toString());
      return false;
    } 
    return true;
  }
  
  public static boolean ab(String paramString1, String paramString2, String paramString3) {
    if (TextUtils.isEmpty(paramString2)) {
      stringBuilder = new StringBuilder();
      paramString3 = "checkString() Parameter is null! Parameter:";
      stringBuilder.append(paramString3);
      stringBuilder.append(paramString1);
      ab.fg("hmsSdk", stringBuilder.toString());
      return false;
    } 
    if (Pattern.compile(paramString3).matcher(stringBuilder).matches())
      return true; 
    StringBuilder stringBuilder = new StringBuilder();
    paramString3 = "checkString() Parameter verification failure! Parameter:";
    stringBuilder.append(paramString3);
    stringBuilder.append(paramString1);
    ab.fg("hmsSdk", stringBuilder.toString());
    return false;
  }
  
  public static boolean ab(Map<String, String> paramMap) {
    String str;
    if (paramMap == null || paramMap.size() == 0) {
      str = "onEvent() mapValue has not data.so,The data will be empty";
      ab.fg("hmsSdk", str);
      return false;
    } 
    if (str.size() == 1 && (str.get("constants") != null || str.get("_constants") != null)) {
      str = "checkMap() the key can't be constants or _constants";
      ab.fg("hmsSdk", str);
      return false;
    } 
    if (str.size() > 2048 || str.toString().length() > 204800) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("checkMap Map data is too big! size: ");
      stringBuilder.append(str.size());
      stringBuilder.append(" length: ");
      stringBuilder.append(str.toString().length());
      str = stringBuilder.toString();
      ab.fg("hmsSdk", str);
      return false;
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\kl\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */