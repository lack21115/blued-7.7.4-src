package com.blued.android.core.image.http;

import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.utils.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.ResponseBody;

public abstract class InputStreamHttpResponseHandler extends HttpResponseHandler<InputStream> {
  private ResponseBody a;
  
  protected InputStream a(int paramInt, ResponseBody paramResponseBody) {
    this.a = paramResponseBody;
    return (paramResponseBody != null) ? new FilterInputStream(this, paramResponseBody.d()) {
        public int read() throws IOException {
          return super.read();
        }
        
        public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
          return super.read(param1ArrayOfbyte, param1Int1, param1Int2);
        }
      } : null;
  }
  
  public void a() {
    if (ImageLoader.a())
      Log.e("IMAGE", "InputStreamHttpResponseHandler : close"); 
    ResponseBody responseBody = this.a;
    if (responseBody != null) {
      responseBody.close();
      this.a = null;
    } 
  }
  
  public long b(InputStream paramInputStream) {
    if (paramInputStream != null)
      try {
        int i = paramInputStream.available();
        return i;
      } catch (Exception exception) {} 
    return 0L;
  }
  
  public String getResponseType() {
    return "inputstream";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\http\InputStreamHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */