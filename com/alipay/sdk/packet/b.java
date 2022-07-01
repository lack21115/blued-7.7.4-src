package com.alipay.sdk.packet;

import android.text.TextUtils;
import com.alipay.sdk.util.c;
import org.json.JSONObject;

public final class b {
  private final String a;
  
  private final String b;
  
  public b(String paramString1, String paramString2) {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String a() {
    return this.a;
  }
  
  public String b() {
    return this.b;
  }
  
  public JSONObject c() {
    if (TextUtils.isEmpty(this.b))
      return null; 
    try {
      return new JSONObject(this.b);
    } catch (Exception exception) {
      c.a(exception);
      return null;
    } 
  }
  
  public String toString() {
    return String.format("<Letter envelop=%s body=%s>", new Object[] { this.a, this.b });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\packet\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */