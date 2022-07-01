package com.bytedance.sdk.openadsdk.multipro.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.c.e;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.c.i;
import com.bytedance.sdk.openadsdk.c.l;
import com.bytedance.sdk.openadsdk.c.n;
import com.bytedance.sdk.openadsdk.c.o;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.a;
import com.bytedance.sdk.openadsdk.multipro.e;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class a implements a {
  private Context a;
  
  public static void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    t.b("AdEventProviderImpl", "dispatch event");
    try {
    
    } finally {
      paramString = null;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("dispatch event Throwable:");
      stringBuilder.append(paramString.toString());
    } 
  }
  
  public static void a(String paramString, List<String> paramList, boolean paramBoolean) {
    if (!TextUtils.isEmpty(paramString) && paramList != null) {
      if (paramList.isEmpty())
        return; 
      try {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> iterator = paramList.iterator();
        while (iterator.hasNext()) {
          stringBuilder.append(com.bytedance.sdk.openadsdk.multipro.c.a(iterator.next()));
          stringBuilder.append(",");
        } 
        String str = com.bytedance.sdk.openadsdk.multipro.c.a(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("?did=");
        stringBuilder.append(String.valueOf(paramString));
        stringBuilder.append("&track=");
        stringBuilder.append(String.valueOf(str));
        stringBuilder.append("&replace=");
        stringBuilder.append(String.valueOf(paramBoolean));
        paramString = stringBuilder.toString();
        ContentResolver contentResolver = e();
        return;
      } finally {
        paramString = null;
      } 
    } 
  }
  
  public static void a(String paramString, boolean paramBoolean) {
    if (TextUtils.isEmpty(paramString))
      return; 
    try {
      ContentResolver contentResolver = e();
      return;
    } finally {
      paramString = null;
    } 
  }
  
  public static void a(boolean paramBoolean) {
    if (o.a() == null)
      return; 
    try {
      ContentResolver contentResolver = e();
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static void b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    try {
      ContentResolver contentResolver = e();
      return;
    } finally {
      paramString = null;
    } 
  }
  
  public static void c() {
    if (o.a() == null)
      return; 
    try {
      ContentResolver contentResolver = e();
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static void c(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    try {
      ContentResolver contentResolver = e();
      return;
    } finally {
      paramString = null;
    } 
  }
  
  public static void d() {
    try {
      ContentResolver contentResolver = e();
      return;
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
    stringBuilder.append("t_event_ad_event");
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
    return "t_event_ad_event";
  }
  
  public String a(Uri paramUri) {
    com.bytedance.sdk.openadsdk.c.a a1;
    String str = paramUri.getPath().split("/")[2];
    if ("adEventStart".equals(str)) {
      t.b("AdEventProviderImpl", "====ad event function will be start====");
      b.a().a();
      return null;
    } 
    if ("logStatusStart".equals(str)) {
      t.b("AdEventProviderImpl", "====log stats function will be start====");
      if (Boolean.valueOf(paramUri.getQueryParameter("isRealTime")).booleanValue()) {
        b.c().a();
        return null;
      } 
      b.b().a();
      return null;
    } 
    if ("adEventDispatch".equals(str)) {
      t.b("AdEventProviderImpl", "dispatch FUN_AD_EVENT_DISPATCH");
      a1 = com.bytedance.sdk.openadsdk.c.a.a(com.bytedance.sdk.openadsdk.multipro.c.b(paramUri.getQueryParameter("event")));
      if (a1 != null) {
        b.a().a((i)a1);
        return null;
      } 
    } else {
      com.bytedance.sdk.openadsdk.f.b.c.a a2;
      String str1;
      Boolean bool;
      String str2;
      StringBuilder stringBuilder;
      if ("logStatusDispatch".equals(str)) {
        bool = Boolean.valueOf(a1.getQueryParameter("isRealTime"));
        a2 = com.bytedance.sdk.openadsdk.f.b.c.a.a(com.bytedance.sdk.openadsdk.multipro.c.b(a1.getQueryParameter("event")));
        if (a2 == null)
          return null; 
        if (bool.booleanValue()) {
          b.c().a((i)a2);
          return null;
        } 
        b.b().a((i)a2);
        return null;
      } 
      if ("trackUrl".equals(bool))
        try {
          str2 = a2.getQueryParameter("did");
          boolean bool1 = Boolean.valueOf(a2.getQueryParameter("replace")).booleanValue();
          String[] arrayOfString = com.bytedance.sdk.openadsdk.multipro.c.b(a2.getQueryParameter("track")).split(",");
          return null;
        } finally {
          a2 = null;
        }  
      if ("trackFailed".equals(str2)) {
        str1 = a2.getQueryParameter("did");
        d.a().a(str1);
        stringBuilder = new StringBuilder();
        stringBuilder.append("track failed: ");
        stringBuilder.append(String.valueOf(str1));
        t.b("AdEventProviderImpl", stringBuilder.toString());
        return null;
      } 
      if ("logStatusInit".equals(stringBuilder)) {
        c.a().a();
        return null;
      } 
      if ("logStatusUpload".equals(stringBuilder)) {
        str1 = com.bytedance.sdk.openadsdk.multipro.c.b(str1.getQueryParameter("event"));
        if (!TextUtils.isEmpty(str1))
          c.a().a(a.a(str1)); 
      } 
    } 
    return null;
  }
  
  public void a(Context paramContext) {
    this.a = paramContext;
  }
  
  public void b() {}
  
  static class a implements com.bytedance.sdk.openadsdk.f.a.b {
    JSONObject a;
    
    private a(String param1String) {
      try {
        return;
      } finally {
        param1String = null;
      } 
    }
    
    private static a b(String param1String) {
      return new a(param1String);
    }
    
    public JSONObject a() {
      return this.a;
    }
  }
  
  static class b {
    private static volatile com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> a;
    
    private static volatile com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.f.b.c.a> b;
    
    private static volatile com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.f.b.c.a> c;
    
    static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> a() {
      // Byte code:
      //   0: getstatic com/bytedance/sdk/openadsdk/multipro/c/a$b.a : Lcom/bytedance/sdk/openadsdk/c/b;
      //   3: ifnonnull -> 56
      //   6: ldc com/bytedance/sdk/openadsdk/core/o
      //   8: monitorenter
      //   9: getstatic com/bytedance/sdk/openadsdk/multipro/c/a$b.a : Lcom/bytedance/sdk/openadsdk/c/b;
      //   12: ifnonnull -> 44
      //   15: new com/bytedance/sdk/openadsdk/c/b
      //   18: dup
      //   19: new com/bytedance/sdk/openadsdk/c/f
      //   22: dup
      //   23: invokestatic a : ()Landroid/content/Context;
      //   26: invokespecial <init> : (Landroid/content/Context;)V
      //   29: invokestatic f : ()Lcom/bytedance/sdk/openadsdk/core/p;
      //   32: invokestatic a : ()Lcom/bytedance/sdk/openadsdk/c/g$b;
      //   35: invokestatic d : ()Lcom/bytedance/sdk/openadsdk/c/g$a;
      //   38: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/c/e;Lcom/bytedance/sdk/openadsdk/core/p;Lcom/bytedance/sdk/openadsdk/c/g$b;Lcom/bytedance/sdk/openadsdk/c/g$a;)V
      //   41: putstatic com/bytedance/sdk/openadsdk/multipro/c/a$b.a : Lcom/bytedance/sdk/openadsdk/c/b;
      //   44: ldc com/bytedance/sdk/openadsdk/core/o
      //   46: monitorexit
      //   47: goto -> 56
      //   50: astore_0
      //   51: ldc com/bytedance/sdk/openadsdk/core/o
      //   53: monitorexit
      //   54: aload_0
      //   55: athrow
      //   56: getstatic com/bytedance/sdk/openadsdk/multipro/c/a$b.a : Lcom/bytedance/sdk/openadsdk/c/b;
      //   59: areturn
      // Exception table:
      //   from	to	target	type
      //   9	44	50	finally
      //   44	47	50	finally
      //   51	54	50	finally
    }
    
    public static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.f.b.c.a> a(String param1String1, String param1String2, boolean param1Boolean) {
      g.b b1;
      l l;
      if (param1Boolean) {
        n n = new n(o.a());
        b1 = g.b.a();
      } else {
        b1 = g.b.b();
        l = new l(o.a());
      } 
      g.a a = d();
      return new com.bytedance.sdk.openadsdk.c.b((e)l, null, b1, a, (g)new o(param1String1, param1String2, (e)l, null, b1, a));
    }
    
    public static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.f.b.c.a> b() {
      // Byte code:
      //   0: getstatic com/bytedance/sdk/openadsdk/multipro/c/a$b.c : Lcom/bytedance/sdk/openadsdk/c/b;
      //   3: ifnonnull -> 38
      //   6: ldc com/bytedance/sdk/openadsdk/core/o
      //   8: monitorenter
      //   9: getstatic com/bytedance/sdk/openadsdk/multipro/c/a$b.c : Lcom/bytedance/sdk/openadsdk/c/b;
      //   12: ifnonnull -> 26
      //   15: ldc 'ttad_bk_batch_stats'
      //   17: ldc 'AdStatsEventBatchThread'
      //   19: iconst_0
      //   20: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Z)Lcom/bytedance/sdk/openadsdk/c/b;
      //   23: putstatic com/bytedance/sdk/openadsdk/multipro/c/a$b.c : Lcom/bytedance/sdk/openadsdk/c/b;
      //   26: ldc com/bytedance/sdk/openadsdk/core/o
      //   28: monitorexit
      //   29: goto -> 38
      //   32: astore_0
      //   33: ldc com/bytedance/sdk/openadsdk/core/o
      //   35: monitorexit
      //   36: aload_0
      //   37: athrow
      //   38: getstatic com/bytedance/sdk/openadsdk/multipro/c/a$b.c : Lcom/bytedance/sdk/openadsdk/c/b;
      //   41: areturn
      // Exception table:
      //   from	to	target	type
      //   9	26	32	finally
      //   26	29	32	finally
      //   33	36	32	finally
    }
    
    public static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.f.b.c.a> c() {
      // Byte code:
      //   0: getstatic com/bytedance/sdk/openadsdk/multipro/c/a$b.b : Lcom/bytedance/sdk/openadsdk/c/b;
      //   3: ifnonnull -> 38
      //   6: ldc com/bytedance/sdk/openadsdk/core/o
      //   8: monitorenter
      //   9: getstatic com/bytedance/sdk/openadsdk/multipro/c/a$b.b : Lcom/bytedance/sdk/openadsdk/c/b;
      //   12: ifnonnull -> 26
      //   15: ldc 'ttad_bk_stats'
      //   17: ldc 'AdStatsEventThread'
      //   19: iconst_1
      //   20: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Z)Lcom/bytedance/sdk/openadsdk/c/b;
      //   23: putstatic com/bytedance/sdk/openadsdk/multipro/c/a$b.b : Lcom/bytedance/sdk/openadsdk/c/b;
      //   26: ldc com/bytedance/sdk/openadsdk/core/o
      //   28: monitorexit
      //   29: goto -> 38
      //   32: astore_0
      //   33: ldc com/bytedance/sdk/openadsdk/core/o
      //   35: monitorexit
      //   36: aload_0
      //   37: athrow
      //   38: getstatic com/bytedance/sdk/openadsdk/multipro/c/a$b.b : Lcom/bytedance/sdk/openadsdk/c/b;
      //   41: areturn
      // Exception table:
      //   from	to	target	type
      //   9	26	32	finally
      //   26	29	32	finally
      //   33	36	32	finally
    }
    
    private static g.a d() {
      return new g.a() {
          public boolean a() {
            return w.a(o.a());
          }
        };
    }
  }
  
  static final class null implements g.a {
    public boolean a() {
      return w.a(o.a());
    }
  }
  
  static class c {
    private static volatile com.bytedance.sdk.openadsdk.f.b.c a;
    
    public static com.bytedance.sdk.openadsdk.f.b.c a() {
      // Byte code:
      //   0: getstatic com/bytedance/sdk/openadsdk/multipro/c/a$c.a : Lcom/bytedance/sdk/openadsdk/f/b/c;
      //   3: ifnonnull -> 37
      //   6: ldc com/bytedance/sdk/openadsdk/f/b/c
      //   8: monitorenter
      //   9: getstatic com/bytedance/sdk/openadsdk/multipro/c/a$c.a : Lcom/bytedance/sdk/openadsdk/f/b/c;
      //   12: ifnonnull -> 25
      //   15: new com/bytedance/sdk/openadsdk/f/b/c
      //   18: dup
      //   19: invokespecial <init> : ()V
      //   22: putstatic com/bytedance/sdk/openadsdk/multipro/c/a$c.a : Lcom/bytedance/sdk/openadsdk/f/b/c;
      //   25: ldc com/bytedance/sdk/openadsdk/f/b/c
      //   27: monitorexit
      //   28: goto -> 37
      //   31: astore_0
      //   32: ldc com/bytedance/sdk/openadsdk/f/b/c
      //   34: monitorexit
      //   35: aload_0
      //   36: athrow
      //   37: getstatic com/bytedance/sdk/openadsdk/multipro/c/a$c.a : Lcom/bytedance/sdk/openadsdk/f/b/c;
      //   40: areturn
      // Exception table:
      //   from	to	target	type
      //   9	25	31	finally
      //   25	28	31	finally
      //   32	35	31	finally
    }
  }
  
  static class d {
    private static volatile com.bytedance.sdk.openadsdk.j.a a;
    
    public static com.bytedance.sdk.openadsdk.j.a a() {
      // Byte code:
      //   0: getstatic com/bytedance/sdk/openadsdk/multipro/c/a$d.a : Lcom/bytedance/sdk/openadsdk/j/a;
      //   3: ifnonnull -> 50
      //   6: ldc com/bytedance/sdk/openadsdk/j/a
      //   8: monitorenter
      //   9: getstatic com/bytedance/sdk/openadsdk/multipro/c/a$d.a : Lcom/bytedance/sdk/openadsdk/j/a;
      //   12: ifnonnull -> 38
      //   15: new com/bytedance/sdk/openadsdk/j/b
      //   18: dup
      //   19: invokestatic a : ()Landroid/content/Context;
      //   22: new com/bytedance/sdk/openadsdk/j/g
      //   25: dup
      //   26: invokestatic a : ()Landroid/content/Context;
      //   29: invokespecial <init> : (Landroid/content/Context;)V
      //   32: invokespecial <init> : (Landroid/content/Context;Lcom/bytedance/sdk/openadsdk/j/f;)V
      //   35: putstatic com/bytedance/sdk/openadsdk/multipro/c/a$d.a : Lcom/bytedance/sdk/openadsdk/j/a;
      //   38: ldc com/bytedance/sdk/openadsdk/j/a
      //   40: monitorexit
      //   41: goto -> 50
      //   44: astore_0
      //   45: ldc com/bytedance/sdk/openadsdk/j/a
      //   47: monitorexit
      //   48: aload_0
      //   49: athrow
      //   50: getstatic com/bytedance/sdk/openadsdk/multipro/c/a$d.a : Lcom/bytedance/sdk/openadsdk/j/a;
      //   53: areturn
      // Exception table:
      //   from	to	target	type
      //   9	38	44	finally
      //   38	41	44	finally
      //   45	48	44	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */