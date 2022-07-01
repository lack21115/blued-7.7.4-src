package org.chromium.base;

import org.chromium.base.annotations.CalledByNative;

public class ApkAssets {
  @CalledByNative
  public static long[] open(String paramString) {
    // Byte code:
    //   0: getstatic org/chromium/base/ContextUtils.sApplicationContext : Landroid/content/Context;
    //   3: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   6: aload_0
    //   7: invokevirtual openNonAssetFd : (Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   10: astore_2
    //   11: aload_2
    //   12: astore_1
    //   13: iconst_3
    //   14: newarray long
    //   16: astore_3
    //   17: aload_2
    //   18: astore_1
    //   19: aload_3
    //   20: iconst_0
    //   21: aload_2
    //   22: invokevirtual getParcelFileDescriptor : ()Landroid/os/ParcelFileDescriptor;
    //   25: invokevirtual detachFd : ()I
    //   28: i2l
    //   29: lastore
    //   30: aload_2
    //   31: astore_1
    //   32: aload_3
    //   33: iconst_1
    //   34: aload_2
    //   35: invokevirtual getStartOffset : ()J
    //   38: lastore
    //   39: aload_2
    //   40: astore_1
    //   41: aload_3
    //   42: iconst_2
    //   43: aload_2
    //   44: invokevirtual getLength : ()J
    //   47: lastore
    //   48: aload_2
    //   49: ifnull -> 71
    //   52: aload_2
    //   53: invokevirtual close : ()V
    //   56: goto -> 71
    //   59: astore_0
    //   60: ldc 'ApkAssets'
    //   62: ldc 'Unable to close AssetFileDescriptor'
    //   64: aload_0
    //   65: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   68: pop
    //   69: aload_3
    //   70: areturn
    //   71: aload_3
    //   72: areturn
    //   73: astore_3
    //   74: goto -> 86
    //   77: astore_0
    //   78: aconst_null
    //   79: astore_1
    //   80: goto -> 219
    //   83: astore_3
    //   84: aconst_null
    //   85: astore_2
    //   86: aload_2
    //   87: astore_1
    //   88: aload_3
    //   89: invokevirtual getMessage : ()Ljava/lang/String;
    //   92: ldc ''
    //   94: invokevirtual equals : (Ljava/lang/Object;)Z
    //   97: ifne -> 167
    //   100: aload_2
    //   101: astore_1
    //   102: aload_3
    //   103: invokevirtual getMessage : ()Ljava/lang/String;
    //   106: aload_0
    //   107: invokevirtual equals : (Ljava/lang/Object;)Z
    //   110: ifne -> 167
    //   113: aload_2
    //   114: astore_1
    //   115: new java/lang/StringBuilder
    //   118: dup
    //   119: ldc 'Error while loading asset '
    //   121: invokespecial <init> : (Ljava/lang/String;)V
    //   124: astore #4
    //   126: aload_2
    //   127: astore_1
    //   128: aload #4
    //   130: aload_0
    //   131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_2
    //   136: astore_1
    //   137: aload #4
    //   139: ldc ': '
    //   141: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_2
    //   146: astore_1
    //   147: aload #4
    //   149: aload_3
    //   150: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_2
    //   155: astore_1
    //   156: ldc 'ApkAssets'
    //   158: aload #4
    //   160: invokevirtual toString : ()Ljava/lang/String;
    //   163: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   166: pop
    //   167: aload_2
    //   168: astore_1
    //   169: iconst_3
    //   170: newarray long
    //   172: astore_0
    //   173: aload_0
    //   174: dup
    //   175: iconst_0
    //   176: ldc2_w -1
    //   179: lastore
    //   180: dup
    //   181: iconst_1
    //   182: ldc2_w -1
    //   185: lastore
    //   186: dup
    //   187: iconst_2
    //   188: ldc2_w -1
    //   191: lastore
    //   192: pop
    //   193: aload_2
    //   194: ifnull -> 216
    //   197: aload_2
    //   198: invokevirtual close : ()V
    //   201: goto -> 216
    //   204: astore_1
    //   205: ldc 'ApkAssets'
    //   207: ldc 'Unable to close AssetFileDescriptor'
    //   209: aload_1
    //   210: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   213: pop
    //   214: aload_0
    //   215: areturn
    //   216: aload_0
    //   217: areturn
    //   218: astore_0
    //   219: aload_1
    //   220: ifnull -> 240
    //   223: aload_1
    //   224: invokevirtual close : ()V
    //   227: goto -> 240
    //   230: astore_1
    //   231: ldc 'ApkAssets'
    //   233: ldc 'Unable to close AssetFileDescriptor'
    //   235: aload_1
    //   236: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   239: pop
    //   240: aload_0
    //   241: athrow
    // Exception table:
    //   from	to	target	type
    //   0	11	83	java/io/IOException
    //   0	11	77	finally
    //   13	17	73	java/io/IOException
    //   13	17	218	finally
    //   19	30	73	java/io/IOException
    //   19	30	218	finally
    //   32	39	73	java/io/IOException
    //   32	39	218	finally
    //   41	48	73	java/io/IOException
    //   41	48	218	finally
    //   52	56	59	java/io/IOException
    //   88	100	218	finally
    //   102	113	218	finally
    //   115	126	218	finally
    //   128	135	218	finally
    //   137	145	218	finally
    //   147	154	218	finally
    //   156	167	218	finally
    //   169	173	218	finally
    //   197	201	204	java/io/IOException
    //   223	227	230	java/io/IOException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\ApkAssets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */