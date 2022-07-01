package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MarkEnforcingInputStream extends FilterInputStream {
  private int a = Integer.MIN_VALUE;
  
  public MarkEnforcingInputStream(InputStream paramInputStream) {
    super(paramInputStream);
  }
  
  private long a(long paramLong) {
    int i = this.a;
    if (i == 0)
      return -1L; 
    long l = paramLong;
    if (i != Integer.MIN_VALUE) {
      l = paramLong;
      if (paramLong > i)
        l = i; 
    } 
    return l;
  }
  
  private void b(long paramLong) {
    int i = this.a;
    if (i != Integer.MIN_VALUE && paramLong != -1L)
      this.a = (int)(i - paramLong); 
  }
  
  public int available() throws IOException {
    int i = this.a;
    return (i == Integer.MIN_VALUE) ? super.available() : Math.min(i, super.available());
  }
  
  public void mark(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial mark : (I)V
    //   7: aload_0
    //   8: iload_1
    //   9: putfield a : I
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: astore_2
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_2
    //   19: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	15	finally
  }
  
  public int read() throws IOException {
    if (a(1L) == -1L)
      return -1; 
    int i = super.read();
    b(1L);
    return i;
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    paramInt2 = (int)a(paramInt2);
    if (paramInt2 == -1)
      return -1; 
    paramInt1 = super.read(paramArrayOfbyte, paramInt1, paramInt2);
    b(paramInt1);
    return paramInt1;
  }
  
  public void reset() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial reset : ()V
    //   6: aload_0
    //   7: ldc -2147483648
    //   9: putfield a : I
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	15	finally
  }
  
  public long skip(long paramLong) throws IOException {
    paramLong = a(paramLong);
    if (paramLong == -1L)
      return 0L; 
    paramLong = super.skip(paramLong);
    b(paramLong);
    return paramLong;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glid\\util\MarkEnforcingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */