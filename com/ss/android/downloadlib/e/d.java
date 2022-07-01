package com.ss.android.downloadlib.e;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.m.i;

public class d {
  public static com.ss.android.downloadlib.a.b.d a(Context paramContext, Uri paramUri) {
    if (paramContext == null || paramUri == null || !"market".equals(paramUri.getScheme()))
      return new com.ss.android.downloadlib.a.b.d(6); 
    try {
      Intent intent = new Intent("android.intent.action.VIEW", paramUri);
      if (!g.a(paramContext, intent))
        return new com.ss.android.downloadlib.a.b.d(6, 1); 
      String str = i.h();
      if (g.c(paramContext, str) && !i.e())
        intent.setPackage(str); 
      if (!(paramContext instanceof android.app.Activity))
        intent.addFlags(268435456); 
      paramContext.startActivity(intent);
      return new com.ss.android.downloadlib.a.b.d(5);
    } catch (Exception exception) {
      return new com.ss.android.downloadlib.a.b.d(6);
    } 
  }
  
  public static com.ss.android.downloadlib.a.b.d a(Context paramContext, String paramString) {
    if (paramContext == null || TextUtils.isEmpty(paramString))
      return new com.ss.android.downloadlib.a.b.d(6); 
    if (i.e() && g.c(paramContext, "com.sec.android.app.samsungapps"))
      return d(paramContext, paramString); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("market://details?id=");
    stringBuilder.append(paramString);
    return a(paramContext, Uri.parse(stringBuilder.toString()));
  }
  
  public static com.ss.android.downloadlib.a.b.d a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return new com.ss.android.downloadlib.a.b.d(2, 3); 
    Context context = j.a();
    Uri uri = Uri.parse(paramString);
    Intent intent = new Intent("android.intent.action.VIEW");
    intent.setData(uri);
    intent.addFlags(268435456);
    if (g.b(context, intent)) {
      if (j.i().optInt("open_url_mode") == 0 && j.k() != null && j.k().a() && Build.VERSION.SDK_INT < 29) {
        TTDelegateActivity.a(paramString);
      } else if (j.i().optInt("open_url_mode") == 1 && Build.VERSION.SDK_INT >= 26 && Build.VERSION.SDK_INT < 29) {
        TTDelegateActivity.a(paramString);
      } else {
        intent.putExtra("open_url", paramString);
        intent.addFlags(268435456);
        try {
          j.a().startActivity(intent);
          return new com.ss.android.downloadlib.a.b.d(1);
        } catch (Exception exception) {
          return new com.ss.android.downloadlib.a.b.d(2);
        } 
      } 
      return new com.ss.android.downloadlib.a.b.d(1);
    } 
    return new com.ss.android.downloadlib.a.b.d(2);
  }
  
  public static com.ss.android.downloadlib.a.b.d a(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1))
      return b(j.a(), paramString2); 
    com.ss.android.downloadlib.a.b.d d2 = a(paramString1);
    com.ss.android.downloadlib.a.b.d d1 = d2;
    if (d2.a() == 2)
      d1 = b(j.a(), paramString2); 
    return d1;
  }
  
  public static com.ss.android.downloadlib.a.b.d b(Context paramContext, String paramString) {
    Intent intent = g.e(paramContext, paramString);
    if (intent == null)
      return new com.ss.android.downloadlib.a.b.d(4); 
    intent.putExtra("START_ONLY_FOR_ANDROID", true);
    try {
      paramContext.startActivity(intent);
      return new com.ss.android.downloadlib.a.b.d(3);
    } catch (Exception exception) {
      return new com.ss.android.downloadlib.a.b.d(4);
    } 
  }
  
  public static boolean c(Context paramContext, String paramString) {
    if (paramContext == null)
      return false; 
    try {
      Uri uri = Uri.parse(paramString);
      Intent intent = new Intent("android.intent.action.VIEW");
      intent.setData(uri);
      intent.addFlags(268435456);
      return true;
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  private static com.ss.android.downloadlib.a.b.d d(Context paramContext, String paramString) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("http://www.samsungapps.com/appquery/appDetail.as?appId=");
      stringBuilder.append(paramString);
      Uri uri = Uri.parse(stringBuilder.toString());
      Intent intent = new Intent();
      intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
      intent.setData(uri);
      paramContext.startActivity(intent);
      return new com.ss.android.downloadlib.a.b.d(5);
    } catch (Exception exception) {
      return new com.ss.android.downloadlib.a.b.d(6);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */