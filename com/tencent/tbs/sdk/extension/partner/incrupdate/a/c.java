package com.tencent.tbs.sdk.extension.partner.incrupdate.a;

import java.io.InputStream;
import java.io.OutputStream;

public class c {
  public int a(InputStream paramInputStream) {
    byte[] arrayOfByte = new byte[4];
    return (paramInputStream.read(arrayOfByte) > 0) ? h.a(arrayOfByte) : 0;
  }
  
  public void a(OutputStream paramOutputStream, int paramInt) {
    paramOutputStream.write(h.a(paramInt));
  }
  
  public void a(OutputStream paramOutputStream, long paramLong) {
    paramOutputStream.write(h.a(paramLong));
  }
  
  public void a(OutputStream paramOutputStream, String paramString) {
    byte[] arrayOfByte = paramString.getBytes();
    a(paramOutputStream, arrayOfByte.length);
    paramOutputStream.write(arrayOfByte);
  }
  
  public long b(InputStream paramInputStream) {
    byte[] arrayOfByte = new byte[8];
    return (paramInputStream.read(arrayOfByte) > 0) ? h.b(arrayOfByte) : 0L;
  }
  
  public String c(InputStream paramInputStream) {
    byte[] arrayOfByte = new byte[a(paramInputStream)];
    return (paramInputStream.read(arrayOfByte) > 0) ? new String(arrayOfByte) : "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\incrupdate\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */