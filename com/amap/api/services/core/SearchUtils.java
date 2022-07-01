package com.amap.api.services.core;

import android.content.Context;
import android.content.pm.Signature;
import com.amap.api.col.s.i;
import java.security.MessageDigest;

public class SearchUtils {
  public static String getPkgName(Context paramContext) {
    try {
      return paramContext.getApplicationContext().getPackageName();
    } finally {
      paramContext = null;
      i.a((Throwable)paramContext, "SearchUtils", "getPkgName");
    } 
  }
  
  public static String getSHA1(Context paramContext) {
    try {
      Signature[] arrayOfSignature = (paramContext.getApplicationContext().getPackageManager().getPackageInfo(paramContext.getPackageName(), 64)).signatures;
      int i = 0;
      byte[] arrayOfByte = arrayOfSignature[0].toByteArray();
      arrayOfByte = MessageDigest.getInstance("SHA1").digest(arrayOfByte);
      return stringBuffer.toString();
    } finally {
      paramContext = null;
      i.a((Throwable)paramContext, "SearchUtils", "getSHA1");
    } 
  }
  
  public static String getVersion() {
    return "7.7.0";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\core\SearchUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */