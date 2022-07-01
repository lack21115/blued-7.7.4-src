package com.bytedance.sdk.adnet.core;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class HttpResponse {
  private final int a;
  
  private final List<Header> b;
  
  private final int c;
  
  private final InputStream d;
  
  public HttpResponse(int paramInt, List<Header> paramList) {
    this(paramInt, paramList, -1, null);
  }
  
  public HttpResponse(int paramInt1, List<Header> paramList, int paramInt2, InputStream paramInputStream) {
    this.a = paramInt1;
    this.b = paramList;
    this.c = paramInt2;
    this.d = paramInputStream;
  }
  
  public final int a() {
    return this.a;
  }
  
  public final List<Header> b() {
    return Collections.unmodifiableList(this.b);
  }
  
  public final int c() {
    return this.c;
  }
  
  public final InputStream d() {
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\core\HttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */