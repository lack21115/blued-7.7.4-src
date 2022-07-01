package com.squareup.okhttp;

import java.io.IOException;

public enum Protocol {
  HTTP_1_0("http/1.0"),
  HTTP_1_1("http/1.1"),
  HTTP_2("http/1.1"),
  SPDY_3("spdy/3.1");
  
  private final String protocol;
  
  static {
    HTTP_2 = new Protocol("HTTP_2", 3, "h2");
    $VALUES = new Protocol[] { HTTP_1_0, HTTP_1_1, SPDY_3, HTTP_2 };
  }
  
  Protocol(String paramString1) {
    this.protocol = paramString1;
  }
  
  public static Protocol get(String paramString) throws IOException {
    if (paramString.equals(HTTP_1_0.protocol))
      return HTTP_1_0; 
    if (paramString.equals(HTTP_1_1.protocol))
      return HTTP_1_1; 
    if (paramString.equals(HTTP_2.protocol))
      return HTTP_2; 
    if (paramString.equals(SPDY_3.protocol))
      return SPDY_3; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected protocol: ");
    stringBuilder.append(paramString);
    throw new IOException(stringBuilder.toString());
  }
  
  public String toString() {
    return this.protocol;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\Protocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */