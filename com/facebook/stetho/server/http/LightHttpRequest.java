package com.facebook.stetho.server.http;

import android.net.Uri;

public class LightHttpRequest extends LightHttpMessage {
  public String method;
  
  public String protocol;
  
  public Uri uri;
  
  public void reset() {
    super.reset();
    this.method = null;
    this.uri = null;
    this.protocol = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\server\http\LightHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */