package com.facebook.stetho.server.http;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public abstract class LightHttpBody {
  public static LightHttpBody create(String paramString1, String paramString2) {
    try {
      return create(paramString1.getBytes("UTF-8"), paramString2);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new RuntimeException(unsupportedEncodingException);
    } 
  }
  
  public static LightHttpBody create(final byte[] body, final String contentType) {
    return new LightHttpBody() {
        public int contentLength() {
          return body.length;
        }
        
        public String contentType() {
          return contentType;
        }
        
        public void writeTo(OutputStream param1OutputStream) throws IOException {
          param1OutputStream.write(body);
        }
      };
  }
  
  public abstract int contentLength();
  
  public abstract String contentType();
  
  public abstract void writeTo(OutputStream paramOutputStream) throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\server\http\LightHttpBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */