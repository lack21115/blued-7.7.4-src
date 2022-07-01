package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.e;
import com.bytedance.sdk.openadsdk.utils.j;
import com.pgl.sys.ces.out.ISdkLite;
import com.pgl.sys.ces.out.StcSDKLiteFactory;
import java.util.HashMap;

public class t {
  private static t a;
  
  private ISdkLite b = StcSDKLiteFactory.getSDK(o.a(), "df979cdb-05a7-448c-bece-92d5005a1247", 0);
  
  private volatile boolean c = false;
  
  private String d = null;
  
  private t(String paramString) {
    this.d = paramString;
    if (!TextUtils.isEmpty(this.d))
      this.b.setParams(paramString, null); 
    if (h.c().e() != null) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("app_id", h.c().e());
      this.b.setCustomInfo(hashMap);
    } 
  }
  
  public static t b(String paramString) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/t.a : Lcom/bytedance/sdk/openadsdk/core/t;
    //   3: ifnonnull -> 38
    //   6: ldc com/bytedance/sdk/openadsdk/core/t
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/core/t.a : Lcom/bytedance/sdk/openadsdk/core/t;
    //   12: ifnonnull -> 26
    //   15: new com/bytedance/sdk/openadsdk/core/t
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Ljava/lang/String;)V
    //   23: putstatic com/bytedance/sdk/openadsdk/core/t.a : Lcom/bytedance/sdk/openadsdk/core/t;
    //   26: ldc com/bytedance/sdk/openadsdk/core/t
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/bytedance/sdk/openadsdk/core/t
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/bytedance/sdk/openadsdk/core/t.a : Lcom/bytedance/sdk/openadsdk/core/t;
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
    String str = "";
    try {
      String str1 = this.b.pullSg();
      if (e(str1))
        return str1.toUpperCase(); 
      str1 = e.a(o.a());
      if (e(str1))
        str = str1.toUpperCase(); 
      return str;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    if (TextUtils.isEmpty(this.d)) {
      this.d = paramString;
      this.b.setParams(this.d, null);
    } 
    if (h.c().e() != null) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("app_id", h.c().e());
      this.b.setCustomInfo(hashMap);
    } 
  }
  
  public void c(String paramString) {
    if (this.c)
      return; 
    this.b.reportNow(paramString);
    this.c = true;
  }
  
  public String d(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    paramString = j.a(paramString);
    return TextUtils.isEmpty(paramString) ? "" : this.b.pullVer(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */