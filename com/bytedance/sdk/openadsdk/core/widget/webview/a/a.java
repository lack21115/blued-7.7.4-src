package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.webkit.WebResourceResponse;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.o;
import com.bytedance.sdk.openadsdk.core.d.p;
import com.bytedance.sdk.openadsdk.core.h.m;
import java.io.File;
import java.util.Set;

public class a {
  public static WebResourceResponse a(String paramString, e.a parama) {
    // Byte code:
    //   0: invokestatic g : ()Z
    //   3: ifeq -> 98
    //   6: invokestatic f : ()Lcom/bytedance/sdk/openadsdk/core/d/o;
    //   9: invokevirtual d : ()Ljava/util/List;
    //   12: invokeinterface iterator : ()Ljava/util/Iterator;
    //   17: astore_3
    //   18: aload_3
    //   19: invokeinterface hasNext : ()Z
    //   24: ifeq -> 98
    //   27: aload_3
    //   28: invokeinterface next : ()Ljava/lang/Object;
    //   33: checkcast com/bytedance/sdk/openadsdk/core/d/o$a
    //   36: astore_2
    //   37: aload_2
    //   38: invokevirtual a : ()Ljava/lang/String;
    //   41: ifnull -> 18
    //   44: aload_2
    //   45: invokevirtual a : ()Ljava/lang/String;
    //   48: aload_0
    //   49: invokevirtual equals : (Ljava/lang/Object;)Z
    //   52: ifeq -> 18
    //   55: aload_2
    //   56: invokevirtual a : ()Ljava/lang/String;
    //   59: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_0
    //   63: new java/io/File
    //   66: dup
    //   67: invokestatic e : ()Ljava/io/File;
    //   70: aload_0
    //   71: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   74: astore_0
    //   75: aload_0
    //   76: invokestatic a : (Ljava/io/File;)Ljava/lang/String;
    //   79: astore_3
    //   80: aload_2
    //   81: invokevirtual b : ()Ljava/lang/String;
    //   84: ifnull -> 98
    //   87: aload_2
    //   88: invokevirtual b : ()Ljava/lang/String;
    //   91: aload_3
    //   92: invokevirtual equals : (Ljava/lang/Object;)Z
    //   95: ifne -> 100
    //   98: aconst_null
    //   99: astore_0
    //   100: aload_0
    //   101: ifnull -> 137
    //   104: new android/webkit/WebResourceResponse
    //   107: dup
    //   108: aload_1
    //   109: invokevirtual a : ()Ljava/lang/String;
    //   112: ldc 'utf-8'
    //   114: new java/io/FileInputStream
    //   117: dup
    //   118: aload_0
    //   119: invokespecial <init> : (Ljava/io/File;)V
    //   122: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   125: astore_0
    //   126: aload_0
    //   127: areturn
    //   128: astore_0
    //   129: ldc 'TTDynamic'
    //   131: ldc 'get html WebResourceResponse error'
    //   133: aload_0
    //   134: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   137: aconst_null
    //   138: areturn
    // Exception table:
    //   from	to	target	type
    //   104	126	128	finally
  }
  
  public static p a(String paramString) {
    return d.a().a(paramString);
  }
  
  public static void a() {
    b.a();
    d.a();
  }
  
  public static void a(k paramk) {
    d.a().a(paramk);
  }
  
  public static void a(m paramm) {
    d.a().a(paramm, "");
  }
  
  public static void a(Set<String> paramSet) {
    d.a().a(paramSet);
  }
  
  public static p b(k paramk) {
    if (paramk == null || paramk.x() == null)
      return null; 
    String str = paramk.x().b();
    return d.a().a(str);
  }
  
  public static void b() {
    try {
      f.d();
      File file = b.e();
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static void c() {
    d.a().b();
  }
  
  public static String d() {
    return c.c();
  }
  
  public static void e() {
    d.a().c();
  }
  
  public static o f() {
    return b.a().c();
  }
  
  public static boolean g() {
    return b.a().b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\webview\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */