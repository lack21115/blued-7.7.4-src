package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

public final class BufferedOutputStream extends OutputStream {
  private final OutputStream a;
  
  private byte[] b;
  
  private ArrayPool c;
  
  private int d;
  
  public BufferedOutputStream(OutputStream paramOutputStream, ArrayPool paramArrayPool) {
    this(paramOutputStream, paramArrayPool, 65536);
  }
  
  BufferedOutputStream(OutputStream paramOutputStream, ArrayPool paramArrayPool, int paramInt) {
    this.a = paramOutputStream;
    this.c = paramArrayPool;
    this.b = (byte[])paramArrayPool.a(paramInt, byte[].class);
  }
  
  private void a() throws IOException {
    int i = this.d;
    if (i > 0) {
      this.a.write(this.b, 0, i);
      this.d = 0;
    } 
  }
  
  private void b() throws IOException {
    if (this.d == this.b.length)
      a(); 
  }
  
  private void c() {
    byte[] arrayOfByte = this.b;
    if (arrayOfByte != null) {
      this.c.a(arrayOfByte);
      this.b = null;
    } 
  }
  
  public void close() throws IOException {
    try {
      flush();
      this.a.close();
      return;
    } finally {
      this.a.close();
    } 
  }
  
  public void flush() throws IOException {
    a();
    this.a.flush();
  }
  
  public void write(int paramInt) throws IOException {
    byte[] arrayOfByte = this.b;
    int i = this.d;
    this.d = i + 1;
    arrayOfByte[i] = (byte)paramInt;
    b();
  }
  
  public void write(byte[] paramArrayOfbyte) throws IOException {
    write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    int j;
    int i = 0;
    do {
      int k = paramInt2 - i;
      j = paramInt1 + i;
      if (this.d == 0 && k >= this.b.length) {
        this.a.write(paramArrayOfbyte, j, k);
        return;
      } 
      k = Math.min(k, this.b.length - this.d);
      System.arraycopy(paramArrayOfbyte, j, this.b, this.d, k);
      this.d += k;
      j = i + k;
      b();
      i = j;
    } while (j < paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\data\BufferedOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */