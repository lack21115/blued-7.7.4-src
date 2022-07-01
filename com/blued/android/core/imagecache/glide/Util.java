package com.blued.android.core.imagecache.glide;

import android.graphics.Bitmap;
import android.os.Build;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.regex.Pattern;

public final class Util {
  private static final char[] a = "0123456789abcdef".toCharArray();
  
  private static final char[] b = new char[64];
  
  public static int a() {
    // Byte code:
    //   0: invokestatic allowThreadDiskReads : ()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore_2
    //   4: new java/io/File
    //   7: dup
    //   8: ldc '/sys/devices/system/cpu/'
    //   10: invokespecial <init> : (Ljava/lang/String;)V
    //   13: new com/blued/android/core/imagecache/glide/Util$1
    //   16: dup
    //   17: ldc 'cpu[0-9]+'
    //   19: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   22: invokespecial <init> : (Ljava/util/regex/Pattern;)V
    //   25: invokevirtual listFiles : (Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   28: astore_1
    //   29: aload_2
    //   30: invokestatic setThreadPolicy : (Landroid/os/StrictMode$ThreadPolicy;)V
    //   33: goto -> 58
    //   36: astore_1
    //   37: getstatic com/blued/android/core/imagecache/ImageLoaderUtils.a : Z
    //   40: ifeq -> 52
    //   43: ldc 'IMAGE_LOADER'
    //   45: ldc 'Failed to calculate accurate cpu count'
    //   47: aload_1
    //   48: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   51: pop
    //   52: aload_2
    //   53: invokestatic setThreadPolicy : (Landroid/os/StrictMode$ThreadPolicy;)V
    //   56: aconst_null
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull -> 68
    //   62: aload_1
    //   63: arraylength
    //   64: istore_0
    //   65: goto -> 70
    //   68: iconst_0
    //   69: istore_0
    //   70: bipush #6
    //   72: iconst_1
    //   73: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   76: invokevirtual availableProcessors : ()I
    //   79: invokestatic max : (II)I
    //   82: iload_0
    //   83: invokestatic max : (II)I
    //   86: invokestatic min : (II)I
    //   89: ireturn
    //   90: astore_1
    //   91: aload_2
    //   92: invokestatic setThreadPolicy : (Landroid/os/StrictMode$ThreadPolicy;)V
    //   95: aload_1
    //   96: athrow
    // Exception table:
    //   from	to	target	type
    //   4	29	36	finally
    //   37	52	90	finally
  }
  
  public static int a(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
    return paramInt1 * paramInt2 * a(paramConfig);
  }
  
  private static int a(Bitmap.Config paramConfig) {
    boolean bool;
    Bitmap.Config config = paramConfig;
    if (paramConfig == null)
      config = Bitmap.Config.ARGB_8888; 
    int i = null.a[config.ordinal()];
    byte b = 2;
    if (i != 1) {
      bool = b;
      if (i != 2) {
        bool = b;
        if (i != 3)
          return 4; 
      } 
    } else {
      bool = true;
    } 
    return bool;
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
  
  public static <T> Queue<T> a(int paramInt) {
    return new ArrayDeque<T>(paramInt);
  }
  
  public static boolean a(Object paramObject1, Object paramObject2) {
    return (paramObject1 == null) ? ((paramObject2 == null)) : paramObject1.equals(paramObject2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\glide\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */