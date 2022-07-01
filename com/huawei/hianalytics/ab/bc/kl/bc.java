package com.huawei.hianalytics.ab.bc.kl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.ef.ab;
import com.huawei.hianalytics.ab.bc.ij.ab;
import java.io.File;

public class bc {
  public static boolean ab(Context paramContext) {
    long l = ab.ab(paramContext, "Privacy_MY", "flashKeyTime", -1L);
    return (System.currentTimeMillis() - l > 43200000L);
  }
  
  public static boolean ab(Context paramContext, String paramString) {
    if (paramContext == null)
      return true; 
    if (Build.VERSION.SDK_INT < 23) {
      if (paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) != 0) {
        ab.fg("hmsSdk", "not have read phone permission!");
        return true;
      } 
    } else if (paramContext.checkSelfPermission(paramString) != 0) {
      ab.fg("hmsSdk", "not have read phone permission!");
      return true;
    } 
    return false;
  }
  
  public static boolean ab(Context paramContext, String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(ab.de(paramContext, paramString));
    stringBuilder.append(".xml");
    paramString = stringBuilder.toString();
    File file = paramContext.getFilesDir();
    stringBuilder = new StringBuilder();
    stringBuilder.append("../shared_prefs/");
    stringBuilder.append(paramString);
    long l = (new File(file, stringBuilder.toString())).length();
    if (l > paramInt) {
      ab.cd("hmsSdk", String.format("reach local file limited size - file len: %d limitedSize: %d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt) }));
      return true;
    } 
    return false;
  }
  
  public static boolean ab(String paramString, long paramLong1, long paramLong2) {
    if (TextUtils.isEmpty(paramString))
      return true; 
    try {
      long l = Long.parseLong(paramString);
      return (paramLong1 - l > paramLong2);
    } catch (NumberFormatException numberFormatException) {
      ab.fg("hmsSdk", "isTimeExpired(): Data type conversion error : number format !");
      return true;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\kl\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */