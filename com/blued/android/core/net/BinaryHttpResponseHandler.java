package com.blued.android.core.net;

import com.blued.android.core.AppMethods;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.ResponseBody;

public abstract class BinaryHttpResponseHandler extends HttpResponseHandler<byte[]> {
  public BinaryHttpResponseHandler() {}
  
  public BinaryHttpResponseHandler(boolean paramBoolean) {
    super(paramBoolean);
  }
  
  protected byte[] a(int paramInt, ResponseBody paramResponseBody) throws IOException {
    if (paramResponseBody != null) {
      long l = paramResponseBody.b();
      byte[] arrayOfByte = AppMethods.a(new FilterInputStream(this, paramResponseBody.d(), l) {
            int a = 0;
            
            public int read() throws IOException {
              int i = super.read();
              if (i > 0) {
                this.a += i;
                BinaryHttpResponseHandler binaryHttpResponseHandler = this.c;
                int j = this.a;
                BinaryHttpResponseHandler.a(binaryHttpResponseHandler, (int)(j * 100.0F / (float)this.b), j);
              } 
              return i;
            }
            
            public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
              param1Int1 = super.read(param1ArrayOfbyte, param1Int1, param1Int2);
              if (param1Int1 > 0) {
                this.a += param1Int1;
                BinaryHttpResponseHandler binaryHttpResponseHandler = this.c;
                param1Int2 = this.a;
                BinaryHttpResponseHandler.b(binaryHttpResponseHandler, (int)(param1Int2 * 100.0F / (float)this.b), param1Int2);
              } 
              return param1Int1;
            }
          }(int)l);
      paramResponseBody.close();
      return arrayOfByte;
    } 
    return null;
  }
  
  public long b(byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte == null) ? 0L : paramArrayOfbyte.length;
  }
  
  public String getResponseType() {
    return "binary";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\BinaryHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */