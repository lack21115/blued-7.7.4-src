package com.bumptech.glide.load.engine.executor;

import android.os.Build;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

final class RuntimeCompat {
  static int a() {
    int j = Runtime.getRuntime().availableProcessors();
    int i = j;
    if (Build.VERSION.SDK_INT < 17)
      i = Math.max(b(), j); 
    return i;
  }
  
  private static int b() {
    // Byte code:
    //   0: invokestatic allowThreadDiskReads : ()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore_2
    //   4: new java/io/File
    //   7: dup
    //   8: ldc '/sys/devices/system/cpu/'
    //   10: invokespecial <init> : (Ljava/lang/String;)V
    //   13: new com/bumptech/glide/load/engine/executor/RuntimeCompat$1
    //   16: dup
    //   17: ldc 'cpu[0-9]+'
    //   19: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   22: invokespecial <init> : (Ljava/util/regex/Pattern;)V
    //   25: invokevirtual listFiles : (Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   28: astore_1
    //   29: aload_2
    //   30: invokestatic setThreadPolicy : (Landroid/os/StrictMode$ThreadPolicy;)V
    //   33: goto -> 62
    //   36: astore_1
    //   37: ldc 'GlideRuntimeCompat'
    //   39: bipush #6
    //   41: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   44: ifeq -> 56
    //   47: ldc 'GlideRuntimeCompat'
    //   49: ldc 'Failed to calculate accurate cpu count'
    //   51: aload_1
    //   52: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   55: pop
    //   56: aload_2
    //   57: invokestatic setThreadPolicy : (Landroid/os/StrictMode$ThreadPolicy;)V
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull -> 72
    //   66: aload_1
    //   67: arraylength
    //   68: istore_0
    //   69: goto -> 74
    //   72: iconst_0
    //   73: istore_0
    //   74: iconst_1
    //   75: iload_0
    //   76: invokestatic max : (II)I
    //   79: ireturn
    //   80: astore_1
    //   81: aload_2
    //   82: invokestatic setThreadPolicy : (Landroid/os/StrictMode$ThreadPolicy;)V
    //   85: aload_1
    //   86: athrow
    // Exception table:
    //   from	to	target	type
    //   4	29	36	finally
    //   37	56	80	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\executor\RuntimeCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */