package com.baidu.mobads.production;

import android.content.Context;
import dalvik.system.DexClassLoader;

public class a {
  private static DexClassLoader a;
  
  public static DexClassLoader a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/baidu/mobads/production/a.a : Ldalvik/system/DexClassLoader;
    //   3: ifnonnull -> 140
    //   6: aload_0
    //   7: ldc 'baidu_ad_sdk'
    //   9: iconst_0
    //   10: invokevirtual getDir : (Ljava/lang/String;I)Ljava/io/File;
    //   13: astore_1
    //   14: new java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore_2
    //   22: aload_2
    //   23: aload_1
    //   24: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_2
    //   32: ldc '/'
    //   34: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_2
    //   39: invokevirtual toString : ()Ljava/lang/String;
    //   42: astore_2
    //   43: aload_0
    //   44: invokevirtual getFilesDir : ()Ljava/io/File;
    //   47: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   50: astore_1
    //   51: new java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial <init> : ()V
    //   58: astore_3
    //   59: aload_3
    //   60: aload_2
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_3
    //   66: ldc 'local_vr_imageview.jar'
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: new java/io/File
    //   75: dup
    //   76: aload_3
    //   77: invokevirtual toString : ()Ljava/lang/String;
    //   80: invokespecial <init> : (Ljava/lang/String;)V
    //   83: astore_2
    //   84: ldc com/baidu/mobads/production/a
    //   86: monitorenter
    //   87: aload_2
    //   88: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   91: astore_2
    //   92: aload_0
    //   93: invokevirtual getClass : ()Ljava/lang/Class;
    //   96: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   99: astore_0
    //   100: invokestatic currentTimeMillis : ()J
    //   103: pop2
    //   104: new dalvik/system/DexClassLoader
    //   107: dup
    //   108: aload_2
    //   109: aload_1
    //   110: aconst_null
    //   111: aload_0
    //   112: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   115: astore_0
    //   116: invokestatic currentTimeMillis : ()J
    //   119: pop2
    //   120: aload_0
    //   121: putstatic com/baidu/mobads/production/a.a : Ldalvik/system/DexClassLoader;
    //   124: ldc com/baidu/mobads/production/a
    //   126: monitorexit
    //   127: goto -> 140
    //   130: astore_0
    //   131: ldc com/baidu/mobads/production/a
    //   133: monitorexit
    //   134: aload_0
    //   135: athrow
    //   136: aconst_null
    //   137: putstatic com/baidu/mobads/production/a.a : Ldalvik/system/DexClassLoader;
    //   140: getstatic com/baidu/mobads/production/a.a : Ldalvik/system/DexClassLoader;
    //   143: areturn
    //   144: astore_0
    //   145: goto -> 136
    // Exception table:
    //   from	to	target	type
    //   6	87	144	java/lang/Exception
    //   87	127	130	finally
    //   131	134	130	finally
    //   134	136	144	java/lang/Exception
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */