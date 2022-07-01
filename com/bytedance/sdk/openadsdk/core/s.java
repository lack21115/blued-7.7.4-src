package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTSecAbs;
import com.bytedance.sdk.openadsdk.utils.e;
import com.bytedance.sdk.openadsdk.utils.j;

public class s {
  private static s a;
  
  private static t b;
  
  private volatile boolean c = false;
  
  private volatile boolean d = false;
  
  private String e = null;
  
  private s(String paramString) {
    this.e = paramString;
    if (b() == null) {
      b = t.b(paramString);
      return;
    } 
    if (!TextUtils.isEmpty(this.e)) {
      this.d = true;
      b().NM_setParams(this.e);
    } 
  }
  
  private TTSecAbs b() {
    return h.c().n();
  }
  
  public static s b(String paramString) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/s.a : Lcom/bytedance/sdk/openadsdk/core/s;
    //   3: ifnonnull -> 38
    //   6: ldc com/bytedance/sdk/openadsdk/core/s
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/core/s.a : Lcom/bytedance/sdk/openadsdk/core/s;
    //   12: ifnonnull -> 26
    //   15: new com/bytedance/sdk/openadsdk/core/s
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Ljava/lang/String;)V
    //   23: putstatic com/bytedance/sdk/openadsdk/core/s.a : Lcom/bytedance/sdk/openadsdk/core/s;
    //   26: ldc com/bytedance/sdk/openadsdk/core/s
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/bytedance/sdk/openadsdk/core/s
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/bytedance/sdk/openadsdk/core/s.a : Lcom/bytedance/sdk/openadsdk/core/s;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private boolean e(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      String[] arrayOfString = paramString.split(":");
      if (arrayOfString != null && arrayOfString.length >= 20) {
        int j = arrayOfString.length;
        for (int i = 0; i < j; i++) {
          if (!"00".equals(arrayOfString[i]))
            return true; 
        } 
      } 
    } 
    return false;
  }
  
  public String a() {
    String str2 = "";
    String str1 = null;
    try {
      if (b() != null) {
        str1 = b().NM_pullSg();
      } else if (b != null) {
        str1 = b.a();
      } 
      if (e(str1))
        return str1.toUpperCase(); 
      String str = e.a(o.a());
      str1 = str2;
      if (e(str))
        str1 = str.toUpperCase(); 
      return str1;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public void a(String paramString) {
    t t1 = b;
    if (t1 != null)
      t1.a(paramString); 
    if (TextUtils.isEmpty(paramString))
      return; 
    if (TextUtils.isEmpty(this.e))
      this.e = paramString; 
    if (!this.d && b() != null) {
      this.d = true;
      b().NM_setParams(paramString);
    } 
  }
  
  public void c(String paramString) {
    t t1 = b;
    if (t1 != null)
      t1.c(paramString); 
    if (this.c)
      return; 
    if (b() == null)
      return; 
    b().NM_reportNow(paramString);
    this.c = true;
  }
  
  public String d(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    String str = j.a(paramString);
    if (TextUtils.isEmpty(str))
      return ""; 
    if (b() != null)
      return b().NM_pullVer(str); 
    t t1 = b;
    return (t1 != null) ? t1.d(paramString) : "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */