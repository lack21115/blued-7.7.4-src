package com.ss.android.socialbase.downloader.m;

import android.content.Context;

public class k {
  private static Boolean a;
  
  public static boolean a() {
    // Byte code:
    //   0: ldc com/ss/android/socialbase/downloader/m/k
    //   2: monitorenter
    //   3: getstatic com/ss/android/socialbase/downloader/m/k.a : Ljava/lang/Boolean;
    //   6: ifnull -> 21
    //   9: getstatic com/ss/android/socialbase/downloader/m/k.a : Ljava/lang/Boolean;
    //   12: invokevirtual booleanValue : ()Z
    //   15: istore_0
    //   16: ldc com/ss/android/socialbase/downloader/m/k
    //   18: monitorexit
    //   19: iload_0
    //   20: ireturn
    //   21: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   24: invokevirtual getPath : ()Ljava/lang/String;
    //   27: astore_1
    //   28: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   31: ldc 'mount'
    //   33: invokevirtual exec : (Ljava/lang/String;)Ljava/lang/Process;
    //   36: astore_2
    //   37: new java/io/BufferedReader
    //   40: dup
    //   41: new java/io/InputStreamReader
    //   44: dup
    //   45: aload_2
    //   46: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   49: invokespecial <init> : (Ljava/io/InputStream;)V
    //   52: invokespecial <init> : (Ljava/io/Reader;)V
    //   55: astore_3
    //   56: aload_2
    //   57: invokevirtual waitFor : ()I
    //   60: pop
    //   61: aload_3
    //   62: invokevirtual readLine : ()Ljava/lang/String;
    //   65: astore #4
    //   67: aload #4
    //   69: ifnull -> 166
    //   72: aload #4
    //   74: ldc '\s+'
    //   76: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   79: astore #4
    //   81: aload #4
    //   83: arraylength
    //   84: ifne -> 90
    //   87: goto -> 61
    //   90: aload #4
    //   92: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   95: astore #4
    //   97: aload #4
    //   99: ldc 'fuse'
    //   101: invokeinterface contains : (Ljava/lang/Object;)Z
    //   106: ifne -> 112
    //   109: goto -> 61
    //   112: aload #4
    //   114: invokeinterface iterator : ()Ljava/util/Iterator;
    //   119: astore #4
    //   121: aload #4
    //   123: invokeinterface hasNext : ()Z
    //   128: ifeq -> 61
    //   131: aload_1
    //   132: aload #4
    //   134: invokeinterface next : ()Ljava/lang/Object;
    //   139: checkcast java/lang/String
    //   142: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   145: ifeq -> 121
    //   148: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
    //   151: putstatic com/ss/android/socialbase/downloader/m/k.a : Ljava/lang/Boolean;
    //   154: getstatic com/ss/android/socialbase/downloader/m/k.a : Ljava/lang/Boolean;
    //   157: invokevirtual booleanValue : ()Z
    //   160: istore_0
    //   161: ldc com/ss/android/socialbase/downloader/m/k
    //   163: monitorexit
    //   164: iload_0
    //   165: ireturn
    //   166: aload_3
    //   167: invokevirtual close : ()V
    //   170: aload_2
    //   171: invokevirtual destroy : ()V
    //   174: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   177: putstatic com/ss/android/socialbase/downloader/m/k.a : Ljava/lang/Boolean;
    //   180: getstatic com/ss/android/socialbase/downloader/m/k.a : Ljava/lang/Boolean;
    //   183: invokevirtual booleanValue : ()Z
    //   186: istore_0
    //   187: ldc com/ss/android/socialbase/downloader/m/k
    //   189: monitorexit
    //   190: iload_0
    //   191: ireturn
    //   192: astore_1
    //   193: aload_1
    //   194: invokevirtual printStackTrace : ()V
    //   197: ldc com/ss/android/socialbase/downloader/m/k
    //   199: monitorexit
    //   200: iconst_0
    //   201: ireturn
    //   202: astore_1
    //   203: ldc com/ss/android/socialbase/downloader/m/k
    //   205: monitorexit
    //   206: aload_1
    //   207: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	202	finally
    //   21	61	192	finally
    //   61	67	192	finally
    //   72	87	192	finally
    //   90	109	192	finally
    //   112	121	192	finally
    //   121	161	192	finally
    //   166	187	192	finally
    //   193	197	202	finally
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2) {
    try {
    
    } finally {
      paramContext = null;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\m\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */