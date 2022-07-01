package com.bytedance.sdk.openadsdk.g;

import android.content.Context;
import android.location.Address;
import com.bytedance.sdk.adnet.c.b;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import java.util.Map;

public class c implements b {
  String a = "sp_multi_ttadnet_config";
  
  private Context b;
  
  public c(Context paramContext) {
    this.b = paramContext;
  }
  
  public int a() {
    return Integer.parseInt("1371");
  }
  
  public Address a(Context paramContext) {
    return null;
  }
  
  public String a(Context paramContext, String paramString1, String paramString2) {
    return a.b(this.a, paramString1, paramString2);
  }
  
  public void a(Context paramContext, Map<String, ?> paramMap) {
    if (paramMap != null)
      try {
        return;
      } finally {
        paramContext = null;
      }  
  }
  
  public String b() {
    return "openadsdk";
  }
  
  public String c() {
    return "android";
  }
  
  public int d() {
    return 2956;
  }
  
  public String e() {
    return j.a(this.b);
  }
  
  public String[] f() {
    return new String[] { "dm.toutiao.com", "dm.bytedance.com", "dm.pstatp.com" };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */