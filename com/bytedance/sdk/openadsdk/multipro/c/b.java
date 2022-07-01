package com.bytedance.sdk.openadsdk.multipro.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.a;
import com.bytedance.sdk.openadsdk.multipro.e;
import com.bytedance.sdk.openadsdk.utils.t;

public class b implements a {
  private Context a;
  
  public static boolean a(String paramString) {
    if (o.a() == null)
      return false; 
    try {
      ContentResolver contentResolver = e();
      return false;
    } finally {
      paramString = null;
    } 
  }
  
  public static boolean c() {
    if (o.a() == null)
      return false; 
    try {
      ContentResolver contentResolver = e();
      return false;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String d() {
    if (o.a() == null)
      return null; 
    try {
      ContentResolver contentResolver = e();
      return null;
    } finally {
      Exception exception = null;
    } 
  }
  
  private static ContentResolver e() {
    try {
      if (o.a() != null)
        return o.a().getContentResolver(); 
    } finally {
      Exception exception;
    } 
    return null;
  }
  
  private static String f() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(e.b);
    stringBuilder.append("/");
    stringBuilder.append("t_frequent");
    stringBuilder.append("/");
    return stringBuilder.toString();
  }
  
  public int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString) {
    return 0;
  }
  
  public int a(Uri paramUri, String paramString, String[] paramArrayOfString) {
    return 0;
  }
  
  public Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2) {
    return null;
  }
  
  public Uri a(Uri paramUri, ContentValues paramContentValues) {
    return null;
  }
  
  public String a() {
    return "t_frequent";
  }
  
  public String a(Uri paramUri) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("get type uri: ");
    stringBuilder.append(String.valueOf(paramUri));
    t.b("FrequentCallProviderImpl", stringBuilder.toString());
    String str = paramUri.getPath().split("/")[2];
    if ("checkFrequency".equals(str)) {
      String str1 = paramUri.getQueryParameter("rit");
      return a.a().a(str1) ? "true" : "false";
    } 
    return "isSilent".equals(str) ? (a.a().b() ? "true" : "false") : ("maxRit".equals(str) ? a.a().c() : null);
  }
  
  public void a(Context paramContext) {
    this.a = paramContext;
  }
  
  public void b() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */