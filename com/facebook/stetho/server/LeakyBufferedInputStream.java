package com.facebook.stetho.server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LeakyBufferedInputStream extends BufferedInputStream {
  private boolean mLeaked;
  
  private boolean mMarked;
  
  public LeakyBufferedInputStream(InputStream paramInputStream, int paramInt) {
    super(paramInputStream, paramInt);
  }
  
  private byte[] clearBufferLocked() {
    byte[] arrayOfByte = new byte[this.count - this.pos];
    System.arraycopy(this.buf, this.pos, arrayOfByte, 0, arrayOfByte.length);
    this.pos = 0;
    this.count = 0;
    return arrayOfByte;
  }
  
  private void throwIfLeaked() {
    if (!this.mLeaked)
      return; 
    throw new IllegalStateException();
  }
  
  private void throwIfMarked() {
    if (!this.mMarked)
      return; 
    throw new IllegalStateException();
  }
  
  public InputStream leakBufferAndStream() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial throwIfLeaked : ()V
    //   6: aload_0
    //   7: invokespecial throwIfMarked : ()V
    //   10: aload_0
    //   11: iconst_1
    //   12: putfield mLeaked : Z
    //   15: new com/facebook/stetho/server/CompositeInputStream
    //   18: dup
    //   19: iconst_2
    //   20: anewarray java/io/InputStream
    //   23: dup
    //   24: iconst_0
    //   25: new java/io/ByteArrayInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial clearBufferLocked : ()[B
    //   33: invokespecial <init> : ([B)V
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: aload_0
    //   40: getfield in : Ljava/io/InputStream;
    //   43: aastore
    //   44: invokespecial <init> : ([Ljava/io/InputStream;)V
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: areturn
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   2	48	52	finally
  }
  
  public void mark(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial throwIfLeaked : ()V
    //   6: aload_0
    //   7: iconst_1
    //   8: putfield mMarked : Z
    //   11: aload_0
    //   12: iload_1
    //   13: invokespecial mark : (I)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	19	finally
  }
  
  public boolean markSupported() {
    return true;
  }
  
  public void reset() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial throwIfLeaked : ()V
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield mMarked : Z
    //   11: aload_0
    //   12: invokespecial reset : ()V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	18	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\server\LeakyBufferedInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */