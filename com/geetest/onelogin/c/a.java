package com.geetest.onelogin.c;

import android.content.Context;
import android.text.TextUtils;
import com.geetest.onelogin.j.c;

public class a {
  private static boolean a = false;
  
  private static String b = "";
  
  public static String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("dpSessionId = ");
    stringBuilder.append(b);
    c.a(stringBuilder.toString());
    return b;
  }
  
  public static void a(Context paramContext, boolean paramBoolean) {
    a = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("init DeepKnow hasSdk=");
    stringBuilder.append(a);
    c.a(stringBuilder.toString());
    if (a)
      b.a(paramContext, paramBoolean); 
  }
  
  static void a(String paramString) {
    b = paramString;
  }
  
  public static boolean b() {
    return (a && !TextUtils.isEmpty(b));
  }
  
  private static boolean c() {
    // Byte code:
    //   0: ldc 'com.geetest.deepknow.DPAPI'
    //   2: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   5: invokevirtual getName : ()Ljava/lang/String;
    //   8: ldc 'com.geetest.deepknow.DPAPI'
    //   10: invokevirtual equals : (Ljava/lang/Object;)Z
    //   13: istore_0
    //   14: iload_0
    //   15: ifeq -> 20
    //   18: iconst_1
    //   19: ireturn
    //   20: iconst_0
    //   21: ireturn
    //   22: astore_1
    //   23: goto -> 20
    // Exception table:
    //   from	to	target	type
    //   0	14	22	java/lang/ClassNotFoundException
    //   0	14	22	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */