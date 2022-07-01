package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import java.io.File;

public final class HardwareConfigState {
  private static final File a = new File("/proc/self/fd");
  
  private static volatile HardwareConfigState b;
  
  private final boolean c = b();
  
  private final int d;
  
  private final int e;
  
  private int f;
  
  private boolean g = true;
  
  HardwareConfigState() {
    if (Build.VERSION.SDK_INT >= 28) {
      this.d = 20000;
      this.e = 0;
      return;
    } 
    this.d = 700;
    this.e = 128;
  }
  
  public static HardwareConfigState a() {
    // Byte code:
    //   0: getstatic com/bumptech/glide/load/resource/bitmap/HardwareConfigState.b : Lcom/bumptech/glide/load/resource/bitmap/HardwareConfigState;
    //   3: ifnonnull -> 37
    //   6: ldc com/bumptech/glide/load/resource/bitmap/HardwareConfigState
    //   8: monitorenter
    //   9: getstatic com/bumptech/glide/load/resource/bitmap/HardwareConfigState.b : Lcom/bumptech/glide/load/resource/bitmap/HardwareConfigState;
    //   12: ifnonnull -> 25
    //   15: new com/bumptech/glide/load/resource/bitmap/HardwareConfigState
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bumptech/glide/load/resource/bitmap/HardwareConfigState.b : Lcom/bumptech/glide/load/resource/bitmap/HardwareConfigState;
    //   25: ldc com/bumptech/glide/load/resource/bitmap/HardwareConfigState
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bumptech/glide/load/resource/bitmap/HardwareConfigState
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bumptech/glide/load/resource/bitmap/HardwareConfigState.b : Lcom/bumptech/glide/load/resource/bitmap/HardwareConfigState;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private static boolean b() {
    String str = Build.MODEL;
    boolean bool = true;
    if (str != null) {
      byte b;
      if (Build.MODEL.length() < 7)
        return true; 
      str = Build.MODEL.substring(0, 7);
      switch (str.hashCode()) {
        default:
          b = -1;
          break;
        case -1398222624:
          if (str.equals("SM-N935")) {
            b = 0;
            break;
          } 
        case -1398343746:
          if (str.equals("SM-J720")) {
            b = 1;
            break;
          } 
        case -1398431068:
          if (str.equals("SM-G965")) {
            b = 3;
            break;
          } 
        case -1398431073:
          if (str.equals("SM-G960")) {
            b = 2;
            break;
          } 
        case -1398431161:
          if (str.equals("SM-G935")) {
            b = 4;
            break;
          } 
        case -1398431166:
          if (str.equals("SM-G930")) {
            b = 5;
            break;
          } 
        case -1398613787:
          if (str.equals("SM-A520")) {
            b = 6;
            break;
          } 
      } 
      switch (b) {
        default:
          return true;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
          break;
      } 
      if (Build.VERSION.SDK_INT != 26)
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  private boolean c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : I
    //   6: iconst_1
    //   7: iadd
    //   8: istore_1
    //   9: aload_0
    //   10: iload_1
    //   11: putfield f : I
    //   14: iload_1
    //   15: bipush #50
    //   17: if_icmplt -> 113
    //   20: iconst_0
    //   21: istore_2
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield f : I
    //   27: getstatic com/bumptech/glide/load/resource/bitmap/HardwareConfigState.a : Ljava/io/File;
    //   30: invokevirtual list : ()[Ljava/lang/String;
    //   33: arraylength
    //   34: istore_1
    //   35: iload_1
    //   36: aload_0
    //   37: getfield d : I
    //   40: if_icmpge -> 45
    //   43: iconst_1
    //   44: istore_2
    //   45: aload_0
    //   46: iload_2
    //   47: putfield g : Z
    //   50: aload_0
    //   51: getfield g : Z
    //   54: ifne -> 113
    //   57: ldc 'Downsampler'
    //   59: iconst_5
    //   60: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   63: ifeq -> 113
    //   66: new java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial <init> : ()V
    //   73: astore_3
    //   74: aload_3
    //   75: ldc 'Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors '
    //   77: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_3
    //   82: iload_1
    //   83: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_3
    //   88: ldc ', limit '
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_3
    //   95: aload_0
    //   96: getfield d : I
    //   99: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: ldc 'Downsampler'
    //   105: aload_3
    //   106: invokevirtual toString : ()Ljava/lang/String;
    //   109: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   112: pop
    //   113: aload_0
    //   114: getfield g : Z
    //   117: istore_2
    //   118: aload_0
    //   119: monitorexit
    //   120: iload_2
    //   121: ireturn
    //   122: astore_3
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_3
    //   126: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	122	finally
    //   22	35	122	finally
    //   35	43	122	finally
    //   45	113	122	finally
    //   113	118	122	finally
  }
  
  boolean a(int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, boolean paramBoolean1, boolean paramBoolean2) {
    paramBoolean1 = a(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (paramBoolean1) {
      paramOptions.inPreferredConfig = Bitmap.Config.HARDWARE;
      paramOptions.inMutable = false;
    } 
    return paramBoolean1;
  }
  
  public boolean a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBoolean1) {
      bool1 = bool2;
      if (this.c) {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 26) {
          if (paramBoolean2)
            return false; 
          int i = this.e;
          bool1 = bool2;
          if (paramInt1 >= i) {
            bool1 = bool2;
            if (paramInt2 >= i) {
              bool1 = bool2;
              if (c())
                bool1 = true; 
            } 
          } 
        } 
      } 
    } 
    return bool1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\HardwareConfigState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */