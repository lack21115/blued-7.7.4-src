package com.facebook.stetho.server.http;

public class LightHttpResponse extends LightHttpMessage {
  public LightHttpBody body;
  
  public int code;
  
  public String reasonPhrase;
  
  public void prepare() {
    LightHttpBody lightHttpBody = this.body;
    if (lightHttpBody != null) {
      addHeader("Content-Type", lightHttpBody.contentType());
      addHeader("Content-Length", String.valueOf(this.body.contentLength()));
    } 
  }
  
  public void reset() {
    super.reset();
    this.code = -1;
    this.reasonPhrase = null;
    this.body = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\server\http\LightHttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */