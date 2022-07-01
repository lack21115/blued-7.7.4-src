package com.qq.e.comm.net.rr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public abstract class AbstractResponse implements Response {
  private final HttpURLConnection a;
  
  private int b = 0;
  
  public AbstractResponse(HttpURLConnection paramHttpURLConnection) {
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
  
  public void close() throws IllegalStateException, IOException {
    this.a.disconnect();
  }
  
  public byte[] getBytesContent() throws IllegalStateException, IOException {
    if (200 != getStatusCode())
      return null; 
    InputStream inputStream = getStreamContent();
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
  
  public int getStatusCode() {
    return this.b;
  }
  
  public InputStream getStreamContent() throws IllegalStateException, IOException {
    return this.a.getInputStream();
  }
  
  public String getStringContent() throws IOException {
    return getStringContent("UTF-8");
  }
  
  public String getStringContent(String paramString) throws IOException {
    byte[] arrayOfByte = getBytesContent();
    String str = null;
    if (arrayOfByte == null)
      return null; 
    if (arrayOfByte.length == 0)
      return ""; 
    try {
      String str1 = this.a.getContentEncoding();
      str = str1;
    } finally {
      Exception exception;
    } 
    if (str != null)
      paramString = str; 
    return new String(arrayOfByte, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\net\rr\AbstractResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */