package com.naman14.androidlame;

public class AndroidLame {
  static {
    System.loadLibrary("mp3lame");
  }
  
  public AndroidLame() {
    initializeDefault();
  }
  
  public AndroidLame(LameBuilder paramLameBuilder) {
    a(paramLameBuilder);
  }
  
  private static int a(LameBuilder.Mode paramMode) {
    int i = null.a[paramMode.ordinal()];
    byte b = 1;
    if (i != 1) {
      if (i != 2) {
        b = 3;
        if (i != 3) {
          b = 4;
          if (i != 4)
            return -1; 
        } 
      } 
      return b;
    } 
    return 0;
  }
  
  private static int a(LameBuilder.VbrMode paramVbrMode) {
    int i = null.b[paramVbrMode.ordinal()];
    if (i != 1) {
      byte b = 2;
      if (i != 2) {
        b = 3;
        if (i != 3) {
          b = 4;
          if (i != 4)
            return (i != 5) ? -1 : 6; 
        } 
      } 
      return b;
    } 
    return 0;
  }
  
  private void a(LameBuilder paramLameBuilder) {
    initialize(paramLameBuilder.a, paramLameBuilder.d, paramLameBuilder.b, paramLameBuilder.c, paramLameBuilder.j, a(paramLameBuilder.k), a(paramLameBuilder.l), paramLameBuilder.e, paramLameBuilder.f, paramLameBuilder.g, paramLameBuilder.h, paramLameBuilder.i, paramLameBuilder.m, paramLameBuilder.n, paramLameBuilder.o, paramLameBuilder.q, paramLameBuilder.p);
  }
  
  private static native int encodeBufferInterleaved(short[] paramArrayOfshort, int paramInt, byte[] paramArrayOfbyte);
  
  private static native void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  private static native void initializeDefault();
  
  private static native void lameClose();
  
  private static native int lameEncode(short[] paramArrayOfshort1, short[] paramArrayOfshort2, int paramInt, byte[] paramArrayOfbyte);
  
  private static native int lameFlush(byte[] paramArrayOfbyte);
  
  public int a(byte[] paramArrayOfbyte) {
    return lameFlush(paramArrayOfbyte);
  }
  
  public int a(short[] paramArrayOfshort1, short[] paramArrayOfshort2, int paramInt, byte[] paramArrayOfbyte) {
    return lameEncode(paramArrayOfshort1, paramArrayOfshort2, paramInt, paramArrayOfbyte);
  }
  
  public void a() {
    lameClose();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\naman14\androidlame\AndroidLame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */