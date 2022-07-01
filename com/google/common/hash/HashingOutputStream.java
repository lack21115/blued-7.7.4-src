package com.google.common.hash;

import java.io.FilterOutputStream;
import java.io.IOException;

public final class HashingOutputStream extends FilterOutputStream {
  private final Hasher a;
  
  public void close() throws IOException {
    this.out.close();
  }
  
  public void write(int paramInt) throws IOException {
    this.a.b((byte)paramInt);
    this.out.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    this.a.b(paramArrayOfbyte, paramInt1, paramInt2);
    this.out.write(paramArrayOfbyte, paramInt1, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\HashingOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */