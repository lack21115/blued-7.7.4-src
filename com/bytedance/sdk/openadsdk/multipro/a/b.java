package com.bytedance.sdk.openadsdk.multipro.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.e;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.a;
import com.bytedance.sdk.openadsdk.utils.t;

public class b implements a {
  private static final Object b = new Object();
  
  private Context a;
  
  private boolean b(Uri paramUri) {
    boolean bool;
    if (paramUri == null || TextUtils.isEmpty(paramUri.getPath())) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool)
      t.b("DBMultiProviderImpl", "==check uri is null=="); 
    return bool;
  }
  
  private Context c() {
    Context context2 = this.a;
    Context context1 = context2;
    if (context2 == null)
      context1 = o.a(); 
    return context1;
  }
  
  public int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update: ");
    stringBuilder.append(String.valueOf(paramUri));
    t.b("DBMultiProviderImpl", stringBuilder.toString());
    synchronized (b) {
      if (b(paramUri))
        return 0; 
      String[] arrayOfString = paramUri.getPath().split("/");
      if (arrayOfString == null || arrayOfString.length < 4)
        return 0; 
      String str1 = arrayOfString[2];
      String str2 = arrayOfString[3];
      if ("ttopensdk.db".equals(str1))
        return e.a(c()).a().a(str2, paramContentValues, paramString, paramArrayOfString); 
      return 0;
    } 
  }
  
  public int a(Uri paramUri, String paramString, String[] paramArrayOfString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("delete: ");
    stringBuilder.append(String.valueOf(paramUri));
    t.b("DBMultiProviderImpl", stringBuilder.toString());
    synchronized (b) {
      if (b(paramUri))
        return 0; 
      String[] arrayOfString = paramUri.getPath().split("/");
      if (arrayOfString == null || arrayOfString.length < 4)
        return 0; 
      String str1 = arrayOfString[2];
      String str2 = arrayOfString[3];
      if ("ttopensdk.db".equals(str1))
        return e.a(c()).a().a(str2, paramString, paramArrayOfString); 
      return 0;
    } 
  }
  
  public Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("query: ");
    stringBuilder.append(String.valueOf(paramUri));
    t.b("DBMultiProviderImpl", stringBuilder.toString());
    synchronized (b) {
      if (b(paramUri))
        return null; 
      String[] arrayOfString = paramUri.getPath().split("/");
      if (arrayOfString == null || arrayOfString.length < 4)
        return null; 
      String str1 = arrayOfString[2];
      String str2 = arrayOfString[3];
      if ("ttopensdk.db".equals(str1))
        return e.a(c()).a().a(str2, paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2); 
      return null;
    } 
  }
  
  public Uri a(Uri paramUri, ContentValues paramContentValues) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("insert: ");
    stringBuilder.append(String.valueOf(paramUri));
    t.b("DBMultiProviderImpl", stringBuilder.toString());
    synchronized (b) {
      if (b(paramUri))
        return null; 
      String[] arrayOfString = paramUri.getPath().split("/");
      if (arrayOfString == null || arrayOfString.length < 4)
        return null; 
      String str1 = arrayOfString[2];
      String str2 = arrayOfString[3];
      if ("ttopensdk.db".equals(str1))
        e.a(c()).a().a(str2, null, paramContentValues); 
      return null;
    } 
  }
  
  public String a() {
    return "t_db";
  }
  
  public String a(Uri paramUri) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getType: ");
    stringBuilder.append(String.valueOf(paramUri));
    t.b("DBMultiProviderImpl", stringBuilder.toString());
    synchronized (b) {
      if (b(paramUri))
        return null; 
      String[] arrayOfString = paramUri.getPath().split("/");
      if (arrayOfString == null || arrayOfString.length < 5)
        return null; 
      String str1 = arrayOfString[2];
      String str3 = arrayOfString[3];
      String str2 = arrayOfString[4];
      if ("ttopensdk.db".equals(str1))
        if ("execSQL".equals(str2)) {
          String str = paramUri.getQueryParameter("sql");
          e.a(c()).a().a(str);
        } else if ("transactionBegin".equals(str2)) {
          e.a(c()).a().a();
        } else if ("transactionSetSuccess".equals(str2)) {
          e.a(c()).a().b();
        } else if ("transactionEnd".equals(str2)) {
          e.a(c()).a().c();
        }  
      return null;
    } 
  }
  
  public void a(Context paramContext) {
    this.a = paramContext;
  }
  
  public void b() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */