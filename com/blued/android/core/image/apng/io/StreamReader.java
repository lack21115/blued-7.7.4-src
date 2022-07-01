package com.blued.android.core.image.apng.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamReader extends FilterInputStream implements Reader {
  private int a;
  
  public StreamReader(InputStream paramInputStream) {
    super(paramInputStream);
    try {
      paramInputStream.reset();
      return;
    } catch (IOException iOException) {
      return;
    } 
  }
  
  public int b() {
    return this.a;
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    paramInt1 = super.read(paramArrayOfbyte, paramInt1, paramInt2);
    this.a += Math.max(0, paramInt1);
    return paramInt1;
  }
  
  public void reset() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial reset : ()V
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield a : I
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	14	finally
  }
  
  public byte s_() throws IOException {
    byte b = (byte)read();
    this.a++;
    return b;
  }
  
  public long skip(long paramLong) throws IOException {
    paramLong = super.skip(paramLong);
    this.a = (int)(this.a + paramLong);
    return paramLong;
  }
  
  public InputStream t_() throws IOException {
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\io\StreamReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */