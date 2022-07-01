package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d.a;

public class d {
  private static volatile d a;
  
  private final SharedPreferences b;
  
  private d(Context paramContext) {
    this.b = paramContext.getSharedPreferences("ttopenadsdk", 0);
  }
  
  public static d a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/d.a : Lcom/bytedance/sdk/openadsdk/core/d;
    //   3: ifnonnull -> 38
    //   6: ldc com/bytedance/sdk/openadsdk/core/d
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/core/d.a : Lcom/bytedance/sdk/openadsdk/core/d;
    //   12: ifnonnull -> 26
    //   15: new com/bytedance/sdk/openadsdk/core/d
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/bytedance/sdk/openadsdk/core/d.a : Lcom/bytedance/sdk/openadsdk/core/d;
    //   26: ldc com/bytedance/sdk/openadsdk/core/d
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/bytedance/sdk/openadsdk/core/d
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/bytedance/sdk/openadsdk/core/d.a : Lcom/bytedance/sdk/openadsdk/core/d;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  public void a(String paramString, float paramFloat) {
    if (b.b()) {
      a.a("ttopenadsdk", paramString, Float.valueOf(paramFloat));
      return;
    } 
    this.b.edit().putFloat(paramString, paramFloat).apply();
  }
  
  public void a(String paramString, int paramInt) {
    if (b.b()) {
      a.a("ttopenadsdk", paramString, Integer.valueOf(paramInt));
      return;
    } 
    this.b.edit().putInt(paramString, paramInt).apply();
  }
  
  public void a(String paramString, long paramLong) {
    if (b.b()) {
      a.a("ttopenadsdk", paramString, Long.valueOf(paramLong));
      return;
    } 
    this.b.edit().putLong(paramString, paramLong).apply();
  }
  
  public void a(String paramString1, String paramString2) {
    if (b.b()) {
      a.a("ttopenadsdk", paramString1, paramString2);
      return;
    } 
    this.b.edit().putString(paramString1, paramString2).apply();
  }
  
  public void a(String paramString, boolean paramBoolean) {
    if (b.b()) {
      a.a("ttopenadsdk", paramString, Boolean.valueOf(paramBoolean));
      return;
    } 
    this.b.edit().putBoolean(paramString, paramBoolean).apply();
  }
  
  public float b(String paramString, float paramFloat) {
    return b.b() ? a.a("ttopenadsdk", paramString, paramFloat) : this.b.getFloat(paramString, paramFloat);
  }
  
  public int b(String paramString, int paramInt) {
    return b.b() ? a.a("ttopenadsdk", paramString, paramInt) : this.b.getInt(paramString, paramInt);
  }
  
  public Long b(String paramString, long paramLong) {
    if (b.b()) {
      paramLong = a.a("ttopenadsdk", paramString, paramLong);
    } else {
      paramLong = this.b.getLong(paramString, paramLong);
    } 
    return Long.valueOf(paramLong);
  }
  
  public String b(String paramString1, String paramString2) {
    return b.b() ? a.b("ttopenadsdk", paramString1, paramString2) : this.b.getString(paramString1, paramString2);
  }
  
  public boolean b(String paramString, boolean paramBoolean) {
    return b.b() ? a.a("ttopenadsdk", paramString, paramBoolean) : this.b.getBoolean(paramString, paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */