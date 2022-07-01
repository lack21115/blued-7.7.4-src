package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ContentLengthInputStream extends FilterInputStream {
  private final long a;
  
  private int b;
  
  private ContentLengthInputStream(InputStream paramInputStream, long paramLong) {
    super(paramInputStream);
    this.a = paramLong;
  }
  
  private int a(int paramInt) throws IOException {
    if (paramInt >= 0) {
      this.b += paramInt;
      return paramInt;
    } 
    if (this.a - this.b <= 0L)
      return paramInt; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failed to read all expected data, expected: ");
    stringBuilder.append(this.a);
    stringBuilder.append(", but read: ");
    stringBuilder.append(this.b);
    throw new IOException(stringBuilder.toString());
  }
  
  public static InputStream a(InputStream paramInputStream, long paramLong) {
    return new ContentLengthInputStream(paramInputStream, paramLong);
  }
  
  public int available() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : J
    //   6: aload_0
    //   7: getfield b : I
    //   10: i2l
    //   11: lsub
    //   12: aload_0
    //   13: getfield in : Ljava/io/InputStream;
    //   16: invokevirtual available : ()I
    //   19: i2l
    //   20: invokestatic max : (JJ)J
    //   23: lstore_2
    //   24: lload_2
    //   25: l2i
    //   26: istore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_1
    //   30: ireturn
    //   31: astore #4
    //   33: aload_0
    //   34: monitorexit
    //   35: aload #4
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	31	finally
  }
  
  public int read() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial read : ()I
    //   6: istore_2
    //   7: iload_2
    //   8: iflt -> 31
    //   11: iconst_1
    //   12: istore_1
    //   13: goto -> 16
    //   16: aload_0
    //   17: iload_1
    //   18: invokespecial a : (I)I
    //   21: pop
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_2
    //   25: ireturn
    //   26: astore_3
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_3
    //   30: athrow
    //   31: iconst_m1
    //   32: istore_1
    //   33: goto -> 16
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
    //   16	22	26	finally
  }
  
  public int read(byte[] paramArrayOfbyte) throws IOException {
    return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: aload_1
    //   5: iload_2
    //   6: iload_3
    //   7: invokespecial read : ([BII)I
    //   10: invokespecial a : (I)I
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	18	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glid\\util\ContentLengthInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */