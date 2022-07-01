package com.blued.android.core.image.apng.io;

import java.io.IOException;
import java.io.InputStream;

public class FilterReader implements Reader {
  protected Reader a;
  
  public FilterReader(Reader paramReader) {
    this.a = paramReader;
  }
  
  public int available() throws IOException {
    return this.a.available();
  }
  
  public int b() {
    return this.a.b();
  }
  
  public void close() throws IOException {
    this.a.close();
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    return this.a.read(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  public void reset() throws IOException {
    this.a.reset();
  }
  
  public byte s_() throws IOException {
    return this.a.s_();
  }
  
  public long skip(long paramLong) throws IOException {
    return this.a.skip(paramLong);
  }
  
  public InputStream t_() throws IOException {
    reset();
    return this.a.t_();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\io\FilterReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */