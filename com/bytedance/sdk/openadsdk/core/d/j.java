package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTImage;

public class j {
  private String a;
  
  private int b;
  
  private int c;
  
  public static TTImage a(j paramj) {
    return (paramj == null || !paramj.d()) ? null : new TTImage(paramj.c(), paramj.b(), paramj.a());
  }
  
  public String a() {
    return this.a;
  }
  
  public void a(int paramInt) {
    this.b = paramInt;
  }
  
  public void a(String paramString) {
    this.a = paramString;
  }
  
  public int b() {
    return this.b;
  }
  
  public void b(int paramInt) {
    this.c = paramInt;
  }
  
  public int c() {
    return this.c;
  }
  
  public boolean d() {
    return (!TextUtils.isEmpty(this.a) && this.b > 0 && this.c > 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\d\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */