package com.squareup.okhttp.internal.framed;

public enum HeadersMode {
  HTTP_20_HEADERS, SPDY_HEADERS, SPDY_REPLY, SPDY_SYN_STREAM;
  
  static {
    SPDY_REPLY = new HeadersMode("SPDY_REPLY", 1);
    SPDY_HEADERS = new HeadersMode("SPDY_HEADERS", 2);
    HTTP_20_HEADERS = new HeadersMode("HTTP_20_HEADERS", 3);
    $VALUES = new HeadersMode[] { SPDY_SYN_STREAM, SPDY_REPLY, SPDY_HEADERS, HTTP_20_HEADERS };
  }
  
  public boolean failIfHeadersAbsent() {
    return (this == SPDY_HEADERS);
  }
  
  public boolean failIfHeadersPresent() {
    return (this == SPDY_REPLY);
  }
  
  public boolean failIfStreamAbsent() {
    return (this == SPDY_REPLY || this == SPDY_HEADERS);
  }
  
  public boolean failIfStreamPresent() {
    return (this == SPDY_SYN_STREAM);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\framed\HeadersMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */