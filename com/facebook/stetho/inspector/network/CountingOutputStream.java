package com.facebook.stetho.inspector.network;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class CountingOutputStream extends FilterOutputStream {
  private long mCount;
  
  public CountingOutputStream(OutputStream paramOutputStream) {
    super(paramOutputStream);
  }
  
  public long getCount() {
    return this.mCount;
  }
  
  public void write(int paramInt) throws IOException {
    this.out.write(paramInt);
    this.mCount++;
  }
  
  public void write(byte[] paramArrayOfbyte) throws IOException {
    write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    this.out.write(paramArrayOfbyte, paramInt1, paramInt2);
    this.mCount += paramInt2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\network\CountingOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */