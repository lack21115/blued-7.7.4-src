package com.cmic.sso.sdk.utils.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;

public abstract class d {
  protected abstract int a();
  
  protected int a(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    int i;
    for (i = 0; i < paramInt2; i++) {
      int j = paramInputStream.read();
      if (j == -1) {
        paramInt1 = i;
        if (i == 0)
          paramInt1 = -1; 
        return paramInt1;
      } 
      paramArrayOfbyte[i + paramInt1] = (byte)j;
    } 
    return paramInt2;
  }
  
  public void a(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
    paramInputStream = new PushbackInputStream(paramInputStream);
    a((PushbackInputStream)paramInputStream, paramOutputStream);
    try {
      while (true) {
        int j = c((PushbackInputStream)paramInputStream, paramOutputStream);
        int i;
        for (i = 0; a() + i < j; i += a())
          a((PushbackInputStream)paramInputStream, paramOutputStream, a()); 
        if (a() + i == j) {
          a((PushbackInputStream)paramInputStream, paramOutputStream, a());
        } else {
          a((PushbackInputStream)paramInputStream, paramOutputStream, j - i);
        } 
        d((PushbackInputStream)paramInputStream, paramOutputStream);
      } 
    } catch (c c) {
      b((PushbackInputStream)paramInputStream, paramOutputStream);
      return;
    } 
  }
  
  protected void a(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream) throws IOException {}
  
  protected void a(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream, int paramInt) throws IOException {
    throw new c();
  }
  
  public byte[] a(String paramString) throws IOException {
    byte[] arrayOfByte = new byte[paramString.length()];
    paramString.getBytes(0, paramString.length(), arrayOfByte, 0);
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    a(byteArrayInputStream, byteArrayOutputStream);
    return byteArrayOutputStream.toByteArray();
  }
  
  protected abstract int b();
  
  protected void b(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream) throws IOException {}
  
  protected int c(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream) throws IOException {
    return b();
  }
  
  protected void d(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream) throws IOException {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */