package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;

public final class Header {
  private final String a;
  
  private final String b;
  
  public Header(String paramString1, String paramString2) {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public final String a() {
    return this.a;
  }
  
  public final String b() {
    return this.b;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      return (TextUtils.equals(this.a, ((Header)paramObject).a) && TextUtils.equals(this.b, ((Header)paramObject).b));
    } 
    return false;
  }
  
  public int hashCode() {
    return this.a.hashCode() * 31 + this.b.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Header[name=");
    stringBuilder.append(this.a);
    stringBuilder.append(",value=");
    stringBuilder.append(this.b);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\core\Header.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */