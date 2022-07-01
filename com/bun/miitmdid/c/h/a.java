package com.bun.miitmdid.c.h;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

public class a {
  private static Uri a = Uri.parse("content://cn.nubia.identity/identity");
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static String a(Context paramContext) {
    try {
      Bundle bundle;
      if (Build.VERSION.SDK_INT >= 17) {
        ContentProviderClient contentProviderClient = paramContext.getContentResolver().acquireUnstableContentProviderClient(a);
        Bundle bundle1 = contentProviderClient.call("getOAID", null, null);
        bundle = bundle1;
        if (contentProviderClient != null)
          if (Build.VERSION.SDK_INT >= 24) {
            contentProviderClient.close();
            bundle = bundle1;
          } else {
            contentProviderClient.release();
            bundle = bundle1;
          }  
      } else {
        bundle = bundle.getContentResolver().call(a, "getOAID", null, null);
      } 
      if (bundle.getInt("code", -1) == 0) {
        String str1 = bundle.getString("id");
        com.bun.lib.a.b("NubiaLog", "succeed:" + str1);
        return str1;
      } 
    } catch (Exception null) {
      paramContext = null;
      exception.printStackTrace();
      return (String)paramContext;
    } 
    String str = paramContext.getString("message");
    try {
      com.bun.lib.a.b("NubiaLog", "failed:" + str);
      return str;
    } catch (Exception exception) {}
    exception.printStackTrace();
    return str;
  }
  
  public static String a(Context paramContext, String paramString) {
    try {
      Bundle bundle1;
      Bundle bundle2;
      if (Build.VERSION.SDK_INT >= 17) {
        ContentProviderClient contentProviderClient = paramContext.getContentResolver().acquireUnstableContentProviderClient(a);
        bundle2 = contentProviderClient.call("getAAID", paramString, null);
        bundle1 = bundle2;
        if (contentProviderClient != null)
          if (Build.VERSION.SDK_INT >= 24) {
            contentProviderClient.close();
            bundle1 = bundle2;
          } else {
            contentProviderClient.release();
            bundle1 = bundle2;
          }  
      } else {
        bundle1 = bundle1.getContentResolver().call(a, "getAAID", (String)bundle2, null);
      } 
      if (bundle1.getInt("code", -1) == 0) {
        String str1 = bundle1.getString("id");
        com.bun.lib.a.b("NubiaLog", "succeed:" + str1);
        return str1;
      } 
    } catch (Exception null) {
      paramContext = null;
      exception.printStackTrace();
      return (String)paramContext;
    } 
    String str = paramContext.getString("message");
    try {
      com.bun.lib.a.b("NubiaLog", "failed:" + str);
      return str;
    } catch (Exception exception) {}
    exception.printStackTrace();
    return str;
  }
  
  public static String b(Context paramContext, String paramString) {
    try {
      Bundle bundle1;
      Bundle bundle2;
      if (Build.VERSION.SDK_INT >= 17) {
        ContentProviderClient contentProviderClient = paramContext.getContentResolver().acquireUnstableContentProviderClient(a);
        bundle2 = contentProviderClient.call("getVAID", paramString, null);
        bundle1 = bundle2;
        if (contentProviderClient != null)
          if (Build.VERSION.SDK_INT >= 24) {
            contentProviderClient.close();
            bundle1 = bundle2;
          } else {
            contentProviderClient.release();
            bundle1 = bundle2;
          }  
      } else {
        bundle1.getContentResolver().call(a, "getVAID", (String)bundle2, null);
        bundle1 = null;
      } 
      if (bundle1.getInt("code", -1) == 0) {
        String str1 = bundle1.getString("id");
        com.bun.lib.a.b("NubiaLog", "succeed:" + str1);
        return str1;
      } 
    } catch (Exception null) {
      paramContext = null;
      exception.printStackTrace();
      return (String)paramContext;
    } 
    String str = paramContext.getString("message");
    try {
      com.bun.lib.a.b("NubiaLog", "failed:" + str);
      return str;
    } catch (Exception exception) {}
    exception.printStackTrace();
    return str;
  }
  
  public static boolean b(Context paramContext) {
    try {
      Bundle bundle;
      if (Build.VERSION.SDK_INT >= 17) {
        ContentProviderClient contentProviderClient = paramContext.getContentResolver().acquireUnstableContentProviderClient(a);
        Bundle bundle1 = contentProviderClient.call("isSupport", null, null);
        bundle = bundle1;
        if (contentProviderClient != null)
          if (Build.VERSION.SDK_INT >= 24) {
            contentProviderClient.close();
            bundle = bundle1;
          } else {
            contentProviderClient.release();
            bundle = bundle1;
          }  
      } else {
        bundle = bundle.getContentResolver().call(a, "isSupport", null, null);
      } 
      if (bundle.getInt("code", -1) == 0) {
        com.bun.lib.a.b("NubiaLog", "succeed");
        return bundle.getBoolean("issupport", true);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return false;
    } 
    String str = exception.getString("message");
    com.bun.lib.a.b("NubiaLog", "failed:" + str);
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\c\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */