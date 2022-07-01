package com.bytedance.sdk.openadsdk.h.f;

import java.io.Serializable;

public class b implements Serializable {
  public String a;
  
  public int b = 204800;
  
  public String c;
  
  public b a(int paramInt) {
    if (paramInt > 0)
      this.b = paramInt; 
    return this;
  }
  
  public b a(String paramString) {
    this.a = paramString;
    return this;
  }
  
  public b b(String paramString) {
    this.c = paramString;
    return this;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("VideoUrlModel{url='");
    stringBuilder.append(this.a);
    stringBuilder.append('\'');
    stringBuilder.append(", maxPreloadSize=");
    stringBuilder.append(this.b);
    stringBuilder.append(", fileNameKey='");
    stringBuilder.append(this.c);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */