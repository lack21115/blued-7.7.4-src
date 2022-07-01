package com.bytedance.sdk.a.b;

import java.io.IOException;

public enum w {
  a("http/1.0"),
  b("http/1.1"),
  c("spdy/3.1"),
  d("h2");
  
  private final String e;
  
  w(String paramString1) {
    this.e = paramString1;
  }
  
  public static w a(String paramString) throws IOException {
    if (paramString.equals(a.e))
      return a; 
    if (paramString.equals(b.e))
      return b; 
    if (paramString.equals(d.e))
      return d; 
    if (paramString.equals(c.e))
      return c; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected protocol: ");
    stringBuilder.append(paramString);
    throw new IOException(stringBuilder.toString());
  }
  
  public String toString() {
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */