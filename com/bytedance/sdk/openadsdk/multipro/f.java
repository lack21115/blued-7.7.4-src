package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.multipro.a.b;
import com.bytedance.sdk.openadsdk.multipro.c.a;
import com.bytedance.sdk.openadsdk.multipro.c.b;
import com.bytedance.sdk.openadsdk.multipro.d.c;
import com.bytedance.sdk.openadsdk.utils.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class f implements a {
  private static volatile f a;
  
  private static WeakReference<Context> b;
  
  private static List<a> c = Collections.synchronizedList(new ArrayList<a>());
  
  static {
    c.add(new c());
    c.add(new b());
    c.add(new b());
    c.add(new a());
    Iterator<a> iterator = c.iterator();
    while (iterator.hasNext())
      ((a)iterator.next()).b(); 
  }
  
  private a b(Uri paramUri) {
    if (paramUri == null)
      return null; 
    if (!c(paramUri)) {
      t.b("TTProviderManager", "uri is error1");
      return null;
    } 
    String[] arrayOfString = paramUri.getPath().split("/");
    if (arrayOfString.length < 2) {
      t.b("TTProviderManager", "uri is error2");
      return null;
    } 
    String str = arrayOfString[1];
    if (TextUtils.isEmpty(str)) {
      t.b("TTProviderManager", "uri is error3");
      return null;
    } 
    for (a a1 : c) {
      if (str.equals(a1.a()))
        return a1; 
    } 
    t.b("TTProviderManager", "uri is error4");
    return null;
  }
  
  public static f b(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 18
    //   4: new java/lang/ref/WeakReference
    //   7: dup
    //   8: aload_0
    //   9: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   12: invokespecial <init> : (Ljava/lang/Object;)V
    //   15: putstatic com/bytedance/sdk/openadsdk/multipro/f.b : Ljava/lang/ref/WeakReference;
    //   18: getstatic com/bytedance/sdk/openadsdk/multipro/f.a : Lcom/bytedance/sdk/openadsdk/multipro/f;
    //   21: ifnonnull -> 55
    //   24: ldc com/bytedance/sdk/openadsdk/multipro/f
    //   26: monitorenter
    //   27: getstatic com/bytedance/sdk/openadsdk/multipro/f.a : Lcom/bytedance/sdk/openadsdk/multipro/f;
    //   30: ifnonnull -> 43
    //   33: new com/bytedance/sdk/openadsdk/multipro/f
    //   36: dup
    //   37: invokespecial <init> : ()V
    //   40: putstatic com/bytedance/sdk/openadsdk/multipro/f.a : Lcom/bytedance/sdk/openadsdk/multipro/f;
    //   43: ldc com/bytedance/sdk/openadsdk/multipro/f
    //   45: monitorexit
    //   46: goto -> 55
    //   49: astore_0
    //   50: ldc com/bytedance/sdk/openadsdk/multipro/f
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    //   55: getstatic com/bytedance/sdk/openadsdk/multipro/f.a : Lcom/bytedance/sdk/openadsdk/multipro/f;
    //   58: areturn
    // Exception table:
    //   from	to	target	type
    //   27	43	49	finally
    //   43	46	49	finally
    //   50	53	49	finally
  }
  
  private boolean c(Uri paramUri) {
    return true;
  }
  
  public int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString) {
    try {
      a a1 = b(paramUri);
    } finally {
      paramUri = null;
    } 
    return 0;
  }
  
  public int a(Uri paramUri, String paramString, String[] paramArrayOfString) {
    try {
      a a1 = b(paramUri);
    } finally {
      paramUri = null;
    } 
    return 0;
  }
  
  public Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2) {
    try {
      a a1 = b(paramUri);
    } finally {
      paramUri = null;
    } 
    return null;
  }
  
  public Uri a(Uri paramUri, ContentValues paramContentValues) {
    try {
      a a1 = b(paramUri);
    } finally {
      paramUri = null;
    } 
    return null;
  }
  
  public String a() {
    return "";
  }
  
  public String a(Uri paramUri) {
    try {
      a a1 = b(paramUri);
    } finally {
      paramUri = null;
    } 
    return null;
  }
  
  public void a(Context paramContext) {
    Iterator<a> iterator = c.iterator();
    while (iterator.hasNext())
      ((a)iterator.next()).a(paramContext); 
  }
  
  public void b() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */