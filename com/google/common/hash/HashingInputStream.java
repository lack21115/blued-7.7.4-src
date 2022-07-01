package com.google.common.hash;

import java.io.FilterInputStream;
import java.io.IOException;

public final class HashingInputStream extends FilterInputStream {
  private final Hasher a;
  
  public void mark(int paramInt) {}
  
  public boolean markSupported() {
    return false;
  }
  
  public int read() throws IOException {
    int i = this.in.read();
    if (i != -1)
      this.a.b((byte)i); 
    return i;
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    paramInt2 = this.in.read(paramArrayOfbyte, paramInt1, paramInt2);
    if (paramInt2 != -1)
      this.a.b(paramArrayOfbyte, paramInt1, paramInt2); 
    return paramInt2;
  }
  
  public void reset() throws IOException {
    throw new IOException("reset not supported");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\HashingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */