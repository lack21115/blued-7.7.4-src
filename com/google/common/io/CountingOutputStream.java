package com.google.common.io;

import java.io.FilterOutputStream;
import java.io.IOException;

public final class CountingOutputStream extends FilterOutputStream {
  private long a;
  
  public void close() throws IOException {
    this.out.close();
  }
  
  public void write(int paramInt) throws IOException {
    this.out.write(paramInt);
    this.a++;
  }
  
  public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    this.out.write(paramArrayOfbyte, paramInt1, paramInt2);
    this.a += paramInt2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\CountingOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */