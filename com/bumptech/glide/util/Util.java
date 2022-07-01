package com.bumptech.glide.util;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import com.bumptech.glide.load.model.Model;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

public final class Util {
  private static final char[] a = "0123456789abcdef".toCharArray();
  
  private static final char[] b = new char[64];
  
  public static int a(float paramFloat) {
    return a(paramFloat, 17);
  }
  
  public static int a(float paramFloat, int paramInt) {
    return b(Float.floatToIntBits(paramFloat), paramInt);
  }
  
  public static int a(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
    return paramInt1 * paramInt2 * a(paramConfig);
  }
  
  private static int a(Bitmap.Config paramConfig) {
    Bitmap.Config config = paramConfig;
    if (paramConfig == null)
      config = Bitmap.Config.ARGB_8888; 
    int i = null.a[config.ordinal()];
    return (i != 1) ? ((i != 2 && i != 3) ? ((i != 4) ? 4 : 8) : 2) : 1;
  }
  
  public static int a(Bitmap paramBitmap) {
    if (!paramBitmap.isRecycled()) {
      if (Build.VERSION.SDK_INT >= 19)
        try {
          return paramBitmap.getAllocationByteCount();
        } catch (NullPointerException nullPointerException) {} 
      return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot obtain size for recycled Bitmap: ");
    stringBuilder.append(paramBitmap);
    stringBuilder.append("[");
    stringBuilder.append(paramBitmap.getWidth());
    stringBuilder.append("x");
    stringBuilder.append(paramBitmap.getHeight());
    stringBuilder.append("] ");
    stringBuilder.append(paramBitmap.getConfig());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public static int a(Object paramObject, int paramInt) {
    int i;
    if (paramObject == null) {
      i = 0;
    } else {
      i = paramObject.hashCode();
    } 
    return b(i, paramInt);
  }
  
  public static int a(boolean paramBoolean, int paramInt) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    synchronized (b) {
      return a(paramArrayOfbyte, b);
    } 
  }
  
  private static String a(byte[] paramArrayOfbyte, char[] paramArrayOfchar) {
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      int j = paramArrayOfbyte[i] & 0xFF;
      int k = i * 2;
      char[] arrayOfChar = a;
      paramArrayOfchar[k] = arrayOfChar[j >>> 4];
      paramArrayOfchar[k + 1] = arrayOfChar[j & 0xF];
    } 
    return new String(paramArrayOfchar);
  }
  
  public static <T> List<T> a(Collection<T> paramCollection) {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: aload_0
    //   5: invokeinterface size : ()I
    //   10: invokespecial <init> : (I)V
    //   13: astore_1
    //   14: aload_0
    //   15: invokeinterface iterator : ()Ljava/util/Iterator;
    //   20: astore_0
    //   21: aload_0
    //   22: invokeinterface hasNext : ()Z
    //   27: ifeq -> 52
    //   30: aload_0
    //   31: invokeinterface next : ()Ljava/lang/Object;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull -> 21
    //   41: aload_1
    //   42: aload_2
    //   43: invokeinterface add : (Ljava/lang/Object;)Z
    //   48: pop
    //   49: goto -> 21
    //   52: aload_1
    //   53: areturn
  }
  
  public static <T> Queue<T> a(int paramInt) {
    return new ArrayDeque<T>(paramInt);
  }
  
  public static void a() {
    if (c())
      return; 
    throw new IllegalArgumentException("You must call this method on the main thread");
  }
  
  public static boolean a(int paramInt1, int paramInt2) {
    return (c(paramInt1) && c(paramInt2));
  }
  
  public static boolean a(Object paramObject1, Object paramObject2) {
    return (paramObject1 == null) ? ((paramObject2 == null)) : paramObject1.equals(paramObject2);
  }
  
  public static int b(int paramInt) {
    return b(paramInt, 17);
  }
  
  public static int b(int paramInt1, int paramInt2) {
    return paramInt2 * 31 + paramInt1;
  }
  
  public static void b() {
    if (d())
      return; 
    throw new IllegalArgumentException("You must call this method on a background thread");
  }
  
  public static boolean b(Object paramObject1, Object paramObject2) {
    return (paramObject1 == null) ? ((paramObject2 == null)) : ((paramObject1 instanceof Model) ? ((Model)paramObject1).a(paramObject2) : paramObject1.equals(paramObject2));
  }
  
  public static boolean c() {
    return (Looper.myLooper() == Looper.getMainLooper());
  }
  
  private static boolean c(int paramInt) {
    return (paramInt > 0 || paramInt == Integer.MIN_VALUE);
  }
  
  public static boolean d() {
    return c() ^ true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glid\\util\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */