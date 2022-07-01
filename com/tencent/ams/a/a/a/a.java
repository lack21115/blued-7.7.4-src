package com.tencent.ams.a.a.a;

import android.content.Context;
import com.tencent.ams.a.a.c.c;
import java.util.Map;

public class a {
  public static Context a;
  
  private static a b = new a();
  
  private boolean c;
  
  private Map<String, String> d;
  
  public static a a() {
    return b;
  }
  
  private void b(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq -> 14
    //   11: goto -> 69
    //   14: aload_1
    //   15: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   18: putstatic com/tencent/ams/a/a/a/a.a : Landroid/content/Context;
    //   21: aload_0
    //   22: getfield d : Ljava/util/Map;
    //   25: ifnonnull -> 38
    //   28: aload_0
    //   29: getstatic com/tencent/ams/a/a/a/a.a : Landroid/content/Context;
    //   32: invokestatic e : (Landroid/content/Context;)Ljava/util/Map;
    //   35: putfield d : Ljava/util/Map;
    //   38: getstatic com/tencent/ams/a/a/a/a.a : Landroid/content/Context;
    //   41: invokestatic a : (Landroid/content/Context;)V
    //   44: aload_0
    //   45: iconst_1
    //   46: putfield c : Z
    //   49: new java/lang/Thread
    //   52: dup
    //   53: new com/tencent/ams/a/a/a/a$1
    //   56: dup
    //   57: aload_0
    //   58: aload_1
    //   59: aload_2
    //   60: invokespecial <init> : (Lcom/tencent/ams/a/a/a/a;Landroid/content/Context;Ljava/lang/String;)V
    //   63: invokespecial <init> : (Ljava/lang/Runnable;)V
    //   66: invokevirtual start : ()V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: goto -> 69
    // Exception table:
    //   from	to	target	type
    //   2	7	72	finally
    //   14	38	77	java/lang/Exception
    //   14	38	72	finally
    //   38	69	77	java/lang/Exception
    //   38	69	72	finally
  }
  
  public String a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mma_origin_url: ");
    stringBuilder.append(paramString);
    com.tencent.ams.a.b.a.a(stringBuilder.toString());
  }
  
  public void a(Context paramContext, String paramString) {
    if (!this.c) {
      if (paramContext == null)
        return; 
      b(paramContext, paramString);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ams\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */