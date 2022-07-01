package com.qq.e.comm.plugin.t.b;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public abstract class b implements f {
  private final HttpURLConnection a;
  
  private int b = 0;
  
  public b(HttpURLConnection paramHttpURLConnection) {
    if (paramHttpURLConnection != null) {
      this.a = paramHttpURLConnection;
      try {
        this.b = this.a.getResponseCode();
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    } 
    throw new AssertionError("AbstractResponse parameter is null");
  }
  
  public String a(String paramString) {
    return this.a.getHeaderField(paramString);
  }
  
  public byte[] a() throws IllegalStateException, IOException {
    if (200 != e())
      return null; 
    InputStream inputStream = b();
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    while (true) {
      int i = inputStream.read(arrayOfByte);
      if (i > 0) {
        byteArrayOutputStream.write(arrayOfByte, 0, i);
        continue;
      } 
      inputStream.close();
      return byteArrayOutputStream.toByteArray();
    } 
  }
  
  public InputStream b() throws IllegalStateException, IOException {
    return this.a.getInputStream();
  }
  
  public void c() throws IllegalStateException, IOException {
    b().close();
    this.a.disconnect();
  }
  
  public String d() throws IOException {
    byte[] arrayOfByte = a();
    String str1 = null;
    if (arrayOfByte == null)
      return null; 
    if (arrayOfByte.length == 0)
      return ""; 
    try {
      String str = this.a.getContentEncoding();
      str1 = str;
    } finally {
      Exception exception;
    } 
    String str2 = str1;
    if (str1 == null)
      str2 = "UTF-8"; 
    return new String(arrayOfByte, str2);
  }
  
  public int e() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\t\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */