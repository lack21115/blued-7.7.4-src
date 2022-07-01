package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class ExceptionCatchingInputStream extends InputStream {
  private static final Queue<ExceptionCatchingInputStream> a = Util.a(0);
  
  private InputStream b;
  
  private IOException c;
  
  public static ExceptionCatchingInputStream a(InputStream paramInputStream) {
    Queue<ExceptionCatchingInputStream> queue;
    ExceptionCatchingInputStream exceptionCatchingInputStream;
    synchronized (a) {
      ExceptionCatchingInputStream exceptionCatchingInputStream1 = a.poll();
      exceptionCatchingInputStream = exceptionCatchingInputStream1;
      if (exceptionCatchingInputStream1 == null)
        exceptionCatchingInputStream = new ExceptionCatchingInputStream(); 
      exceptionCatchingInputStream.b(paramInputStream);
      return exceptionCatchingInputStream;
    } 
  }
  
  public IOException a() {
    return this.c;
  }
  
  public int available() throws IOException {
    return this.b.available();
  }
  
  public void b() {
    this.c = null;
    this.b = null;
    synchronized (a) {
      a.offer(this);
      return;
    } 
  }
  
  void b(InputStream paramInputStream) {
    this.b = paramInputStream;
  }
  
  public void close() throws IOException {
    this.b.close();
  }
  
  public void mark(int paramInt) {
    this.b.mark(paramInt);
  }
  
  public boolean markSupported() {
    return this.b.markSupported();
  }
  
  public int read() {
    try {
      return this.b.read();
    } catch (IOException iOException) {
      this.c = iOException;
      return -1;
    } 
  }
  
  public int read(byte[] paramArrayOfbyte) {
    try {
      return this.b.read(paramArrayOfbyte);
    } catch (IOException iOException) {
      this.c = iOException;
      return -1;
    } 
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    try {
      return this.b.read(paramArrayOfbyte, paramInt1, paramInt2);
    } catch (IOException iOException) {
      this.c = iOException;
      return -1;
    } 
  }
  
  public void reset() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/io/InputStream;
    //   6: invokevirtual reset : ()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
  }
  
  public long skip(long paramLong) {
    try {
      return this.b.skip(paramLong);
    } catch (IOException iOException) {
      this.c = iOException;
      return 0L;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glid\\util\ExceptionCatchingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */