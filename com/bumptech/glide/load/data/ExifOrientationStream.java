package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ExifOrientationStream extends FilterInputStream {
  private static final byte[] a = new byte[] { 
      -1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 
      77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 
      1, 18, 0, 2, 0, 0, 0, 1, 0 };
  
  private static final int b = a.length;
  
  private static final int c = b + 2;
  
  private final byte d;
  
  private int e;
  
  public ExifOrientationStream(InputStream paramInputStream, int paramInt) {
    super(paramInputStream);
    if (paramInt >= -1 && paramInt <= 8) {
      this.d = (byte)paramInt;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot add invalid orientation: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void mark(int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  public boolean markSupported() {
    return false;
  }
  
  public int read() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield e : I
    //   4: istore_1
    //   5: iload_1
    //   6: iconst_2
    //   7: if_icmplt -> 50
    //   10: getstatic com/bumptech/glide/load/data/ExifOrientationStream.c : I
    //   13: istore_2
    //   14: iload_1
    //   15: iload_2
    //   16: if_icmple -> 22
    //   19: goto -> 50
    //   22: iload_1
    //   23: iload_2
    //   24: if_icmpne -> 35
    //   27: aload_0
    //   28: getfield d : B
    //   31: istore_1
    //   32: goto -> 55
    //   35: getstatic com/bumptech/glide/load/data/ExifOrientationStream.a : [B
    //   38: iload_1
    //   39: iconst_2
    //   40: isub
    //   41: baload
    //   42: sipush #255
    //   45: iand
    //   46: istore_1
    //   47: goto -> 55
    //   50: aload_0
    //   51: invokespecial read : ()I
    //   54: istore_1
    //   55: iload_1
    //   56: iconst_m1
    //   57: if_icmpeq -> 70
    //   60: aload_0
    //   61: aload_0
    //   62: getfield e : I
    //   65: iconst_1
    //   66: iadd
    //   67: putfield e : I
    //   70: iload_1
    //   71: ireturn
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    int i = this.e;
    int j = c;
    if (i > j) {
      paramInt1 = super.read(paramArrayOfbyte, paramInt1, paramInt2);
    } else if (i == j) {
      paramArrayOfbyte[paramInt1] = this.d;
      paramInt1 = 1;
    } else if (i < 2) {
      paramInt1 = super.read(paramArrayOfbyte, paramInt1, 2 - i);
    } else {
      paramInt2 = Math.min(j - i, paramInt2);
      System.arraycopy(a, this.e - 2, paramArrayOfbyte, paramInt1, paramInt2);
      paramInt1 = paramInt2;
    } 
    if (paramInt1 > 0)
      this.e += paramInt1; 
    return paramInt1;
  }
  
  public void reset() throws IOException {
    throw new UnsupportedOperationException();
  }
  
  public long skip(long paramLong) throws IOException {
    paramLong = super.skip(paramLong);
    if (paramLong > 0L)
      this.e = (int)(this.e + paramLong); 
    return paramLong;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\data\ExifOrientationStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */