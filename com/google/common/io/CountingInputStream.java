package com.google.common.io;

import java.io.FilterInputStream;
import java.io.IOException;

public final class CountingInputStream extends FilterInputStream {
  private long a;
  
  private long b;
  
  public void mark(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield in : Ljava/io/InputStream;
    //   6: iload_1
    //   7: invokevirtual mark : (I)V
    //   10: aload_0
    //   11: aload_0
    //   12: getfield a : J
    //   15: putfield b : J
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: astore_2
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_2
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	21	finally
  }
  
  public int read() throws IOException {
    int i = this.in.read();
    if (i != -1)
      this.a++; 
    return i;
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    paramInt1 = this.in.read(paramArrayOfbyte, paramInt1, paramInt2);
    if (paramInt1 != -1)
      this.a += paramInt1; 
    return paramInt1;
  }
  
  public void reset() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield in : Ljava/io/InputStream;
    //   6: invokevirtual markSupported : ()Z
    //   9: ifeq -> 51
    //   12: aload_0
    //   13: getfield b : J
    //   16: ldc2_w -1
    //   19: lcmp
    //   20: ifeq -> 41
    //   23: aload_0
    //   24: getfield in : Ljava/io/InputStream;
    //   27: invokevirtual reset : ()V
    //   30: aload_0
    //   31: aload_0
    //   32: getfield b : J
    //   35: putfield a : J
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: new java/io/IOException
    //   44: dup
    //   45: ldc 'Mark not set'
    //   47: invokespecial <init> : (Ljava/lang/String;)V
    //   50: athrow
    //   51: new java/io/IOException
    //   54: dup
    //   55: ldc 'Mark not supported'
    //   57: invokespecial <init> : (Ljava/lang/String;)V
    //   60: athrow
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Exception table:
    //   from	to	target	type
    //   2	38	61	finally
    //   41	51	61	finally
    //   51	61	61	finally
  }
  
  public long skip(long paramLong) throws IOException {
    paramLong = this.in.skip(paramLong);
    this.a += paramLong;
    return paramLong;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\CountingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */