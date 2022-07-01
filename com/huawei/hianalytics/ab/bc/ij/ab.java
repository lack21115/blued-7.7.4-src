package com.huawei.hianalytics.ab.bc.ij;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hianalytics.ab.ab.cd;
import java.util.Map;

public class ab {
  public static long ab(Context paramContext, String paramString1, String paramString2, long paramLong) {
    if (paramContext == null || TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
      com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", "context is null or spName empty or spkey is empty");
      return paramLong;
    } 
    SharedPreferences sharedPreferences = cd(paramContext, paramString1);
    long l = paramLong;
    if (sharedPreferences != null)
      l = sharedPreferences.getLong(paramString2, paramLong); 
    return l;
  }
  
  public static String ab(Context paramContext, String paramString1, String paramString2, String paramString3) {
    if (paramContext == null || TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
      com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", "context is null or spName empty or spkey is empty");
      return paramString3;
    } 
    SharedPreferences sharedPreferences = cd(paramContext, paramString1);
    String str = paramString3;
    if (sharedPreferences != null)
      str = sharedPreferences.getString(paramString2, paramString3); 
    return str;
  }
  
  public static void ab(Context paramContext, String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", "clearTypeDataByTag() eventTag is null or empty!");
      return;
    } 
    if ("_default_config_tag".equals(paramString)) {
      ab(paramContext, "stat_v2_1", new String[] { paramString });
      ab(paramContext, "cached_v2_1", new String[] { paramString });
      return;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramString);
    stringBuilder1.append("-");
    stringBuilder1.append("oper");
    String str1 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString);
    stringBuilder2.append("-");
    stringBuilder2.append("maint");
    String str2 = stringBuilder2.toString();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramString);
    stringBuilder3.append("-");
    stringBuilder3.append("diffprivacy");
    paramString = stringBuilder3.toString();
    ab(paramContext, "stat_v2_1", new String[] { str1 });
    ab(paramContext, "cached_v2_1", new String[] { str1 });
    ab(paramContext, "stat_v2_1", new String[] { str2 });
    ab(paramContext, "cached_v2_1", new String[] { str2 });
    ab(paramContext, "stat_v2_1", new String[] { paramString });
    ab(paramContext, "cached_v2_1", new String[] { paramString });
  }
  
  public static void ab(Context paramContext, String paramString, String... paramVarArgs) {
    SharedPreferences sharedPreferences;
    if (paramContext == null || TextUtils.isEmpty(paramString)) {
      String str = "clearData(): parameter error.context,spname";
    } else {
      String str;
      if (paramVarArgs == null) {
        str = "clearData(): No data need to be deleted,keys is null";
      } else {
        sharedPreferences = cd((Context)str, paramString);
        if (sharedPreferences != null) {
          SharedPreferences.Editor editor = sharedPreferences.edit();
          if (paramVarArgs.length == 0) {
            editor.clear();
            editor.commit();
            return;
          } 
          int j = paramVarArgs.length;
          for (int i = 0; i < j; i++) {
            String str1 = paramVarArgs[i];
            if (sharedPreferences.contains(str1)) {
              editor.remove(str1);
              editor.commit();
            } 
          } 
        } 
        return;
      } 
    } 
    com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", (String)sharedPreferences);
  }
  
  public static Map<String, ?> bc(Context paramContext, String paramString) {
    return cd(paramContext, paramString).getAll();
  }
  
  public static void bc(Context paramContext, String paramString1, String paramString2, long paramLong) {
    if (paramContext == null || TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
      com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", "context is null or spName empty or spkey is empty");
      return;
    } 
    SharedPreferences sharedPreferences = cd(paramContext, paramString1);
    if (sharedPreferences != null) {
      SharedPreferences.Editor editor = sharedPreferences.edit();
      editor.putLong(paramString2, paramLong);
      editor.commit();
    } 
  }
  
  public static void bc(Context paramContext, String paramString1, String paramString2, String paramString3) {
    if (paramContext == null || TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
      com.huawei.hianalytics.ab.bc.ef.ab.ef("hmsSdk", "context is null or spName empty or spkey is empty");
      return;
    } 
    SharedPreferences sharedPreferences = cd(paramContext, paramString1);
    if (sharedPreferences != null) {
      SharedPreferences.Editor editor = sharedPreferences.edit();
      editor.putString(paramString2, paramString3);
      editor.commit();
    } 
  }
  
  private static SharedPreferences cd(Context paramContext, String paramString) {
    return paramContext.getSharedPreferences(de(paramContext, paramString), 0);
  }
  
  public static String de(Context paramContext, String paramString) {
    StringBuilder stringBuilder1;
    String str1 = paramContext.getPackageName();
    String str2 = cd.kl("_hms_config_tag", "oper");
    if (TextUtils.isEmpty(str2)) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("hms_");
      stringBuilder1.append(paramString);
      stringBuilder1.append("_");
      stringBuilder1.append(str1);
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("hms_");
    stringBuilder2.append(paramString);
    stringBuilder2.append("_");
    stringBuilder2.append(str1);
    stringBuilder2.append("_");
    stringBuilder2.append((String)stringBuilder1);
    return stringBuilder2.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\ij\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */