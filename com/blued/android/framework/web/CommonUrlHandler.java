package com.blued.android.framework.web;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.blued.android.core.AppInfo;
import java.util.List;

public class CommonUrlHandler {
  public static boolean a(Context paramContext, String paramString) {
    if (paramString.startsWith("tel:")) {
      b(paramContext, paramString);
      return true;
    } 
    if (paramString.startsWith("wtai://wp/mc")) {
      c(paramContext, paramString);
      return true;
    } 
    if (paramString.startsWith("sms:")) {
      d(paramContext, paramString);
      return true;
    } 
    if (paramString.startsWith("mailto:")) {
      e(paramContext, paramString);
      return true;
    } 
    return false;
  }
  
  public static boolean a(Intent paramIntent) {
    List list = AppInfo.d().getPackageManager().queryIntentActivities(paramIntent, 65536);
    return (list != null && list.size() > 0);
  }
  
  private static void b(Context paramContext, String paramString) {
    Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(paramString));
    if (a(intent)) {
      paramContext.startActivity(intent);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("不支持该url处理, url:");
    stringBuilder.append(paramString);
    Log.e("CommonUrlHandler", stringBuilder.toString());
  }
  
  private static void c(Context paramContext, String paramString) {
    String[] arrayOfString = paramString.split(";");
    if (arrayOfString.length == 2) {
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("tel://");
      stringBuilder2.append(arrayOfString[1]);
      Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(stringBuilder2.toString()));
      if (a(intent)) {
        paramContext.startActivity(intent);
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("不支持该url处理, url:");
      stringBuilder1.append(paramString);
      Log.e("CommonUrlHandler", stringBuilder1.toString());
    } 
  }
  
  private static void d(Context paramContext, String paramString) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("smsto:");
    stringBuilder2.append(paramString.substring(4, paramString.length()));
    Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(stringBuilder2.toString()));
    intent.putExtra("sms_body", "");
    if (a(intent)) {
      paramContext.startActivity(intent);
      return;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("不支持该url处理, url:");
    stringBuilder1.append(paramString);
    Log.e("CommonUrlHandler", stringBuilder1.toString());
  }
  
  private static void e(Context paramContext, String paramString) {
    Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(paramString));
    if (a(intent)) {
      paramContext.startActivity(intent);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("不支持该url处理, url:");
    stringBuilder.append(paramString);
    Log.e("CommonUrlHandler", stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\web\CommonUrlHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */