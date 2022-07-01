package com.blued.android.core.imagecache.drawable.apng;

import android.graphics.Bitmap;

public class ApngImageUtils {
  public static Bitmap a(String paramString, Bitmap paramBitmap) {
    // Byte code:
    //   0: getstatic com/blued/android/core/imagecache/RecyclingUtils$Scheme.c : Lcom/blued/android/core/imagecache/RecyclingUtils$Scheme;
    //   3: aload_0
    //   4: invokevirtual c : (Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_0
    //   8: aload_0
    //   9: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   12: istore #5
    //   14: aconst_null
    //   15: astore #8
    //   17: aconst_null
    //   18: astore #7
    //   20: iload #5
    //   22: ifeq -> 27
    //   25: aconst_null
    //   26: areturn
    //   27: new android/graphics/BitmapFactory$Options
    //   30: dup
    //   31: invokespecial <init> : ()V
    //   34: astore #9
    //   36: aload #9
    //   38: iconst_1
    //   39: putfield inJustDecodeBounds : Z
    //   42: aload_0
    //   43: aload #9
    //   45: invokestatic decodeFile : (Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   48: pop
    //   49: aload #9
    //   51: iconst_1
    //   52: putfield inSampleSize : I
    //   55: iconst_0
    //   56: istore_2
    //   57: aload_1
    //   58: ifnull -> 167
    //   61: aload_1
    //   62: invokevirtual isRecycled : ()Z
    //   65: ifne -> 167
    //   68: aload_1
    //   69: invokevirtual isMutable : ()Z
    //   72: ifeq -> 167
    //   75: aload #9
    //   77: getfield inPurgeable : Z
    //   80: ifne -> 89
    //   83: aload #9
    //   85: iconst_1
    //   86: putfield inMutable : Z
    //   89: aload #9
    //   91: getfield outWidth : I
    //   94: istore_3
    //   95: aload #9
    //   97: getfield outHeight : I
    //   100: istore #4
    //   102: aload_1
    //   103: invokevirtual getAllocationByteCount : ()I
    //   106: iload_3
    //   107: iload #4
    //   109: imul
    //   110: iconst_4
    //   111: imul
    //   112: if_icmplt -> 167
    //   115: aload_1
    //   116: invokevirtual getWidth : ()I
    //   119: aload #9
    //   121: getfield outWidth : I
    //   124: if_icmpne -> 139
    //   127: aload_1
    //   128: invokevirtual getHeight : ()I
    //   131: aload #9
    //   133: getfield outHeight : I
    //   136: if_icmpeq -> 156
    //   139: aload_1
    //   140: aload #9
    //   142: getfield outWidth : I
    //   145: aload #9
    //   147: getfield outHeight : I
    //   150: getstatic android/graphics/Bitmap$Config.ARGB_8888 : Landroid/graphics/Bitmap$Config;
    //   153: invokevirtual reconfigure : (IILandroid/graphics/Bitmap$Config;)V
    //   156: aload_1
    //   157: iconst_0
    //   158: invokevirtual eraseColor : (I)V
    //   161: aload #9
    //   163: aload_1
    //   164: putfield inBitmap : Landroid/graphics/Bitmap;
    //   167: aload #9
    //   169: iconst_0
    //   170: putfield inJustDecodeBounds : Z
    //   173: aload #9
    //   175: iconst_1
    //   176: putfield inMutable : Z
    //   179: new java/io/FileInputStream
    //   182: dup
    //   183: aload_0
    //   184: invokespecial <init> : (Ljava/lang/String;)V
    //   187: astore #6
    //   189: aload #7
    //   191: astore_1
    //   192: iload_2
    //   193: iconst_3
    //   194: if_icmpgt -> 313
    //   197: iload_2
    //   198: iconst_1
    //   199: iadd
    //   200: istore_2
    //   201: aload #6
    //   203: astore_0
    //   204: aload #6
    //   206: invokevirtual getFD : ()Ljava/io/FileDescriptor;
    //   209: aconst_null
    //   210: aload #9
    //   212: invokestatic decodeFileDescriptor : (Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   215: astore_1
    //   216: goto -> 313
    //   219: astore #7
    //   221: aload #6
    //   223: astore_1
    //   224: goto -> 339
    //   227: astore_1
    //   228: aload #6
    //   230: astore_0
    //   231: aload_1
    //   232: invokevirtual printStackTrace : ()V
    //   235: aload #7
    //   237: astore_1
    //   238: goto -> 313
    //   241: astore_1
    //   242: aload #6
    //   244: astore_0
    //   245: aload_1
    //   246: invokevirtual printStackTrace : ()V
    //   249: aload #7
    //   251: astore_1
    //   252: aload #6
    //   254: astore_0
    //   255: aload #9
    //   257: getfield inBitmap : Landroid/graphics/Bitmap;
    //   260: ifnull -> 313
    //   263: aload #6
    //   265: astore_0
    //   266: aload #9
    //   268: aconst_null
    //   269: putfield inBitmap : Landroid/graphics/Bitmap;
    //   272: goto -> 189
    //   275: aload #6
    //   277: astore_0
    //   278: ldc 'ApngDrawable2'
    //   280: ldc 'OutOfMemoryError, try to decrease inSampleSize'
    //   282: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   285: pop
    //   286: aload #6
    //   288: astore_0
    //   289: invokestatic a : ()Lcom/blued/android/core/imagecache/MemoryRequest;
    //   292: invokevirtual b : ()V
    //   295: aload #6
    //   297: astore_0
    //   298: aload #9
    //   300: aload #9
    //   302: getfield inSampleSize : I
    //   305: iconst_2
    //   306: imul
    //   307: putfield inSampleSize : I
    //   310: goto -> 189
    //   313: aload_1
    //   314: astore_0
    //   315: aload #6
    //   317: invokevirtual close : ()V
    //   320: aload_1
    //   321: areturn
    //   322: astore_1
    //   323: aload_1
    //   324: invokevirtual printStackTrace : ()V
    //   327: aload_0
    //   328: areturn
    //   329: astore_0
    //   330: aconst_null
    //   331: astore_1
    //   332: goto -> 366
    //   335: astore #7
    //   337: aconst_null
    //   338: astore_1
    //   339: aload_1
    //   340: astore_0
    //   341: aload #7
    //   343: invokevirtual printStackTrace : ()V
    //   346: aload_1
    //   347: ifnull -> 357
    //   350: aload #8
    //   352: astore_0
    //   353: aload_1
    //   354: invokevirtual close : ()V
    //   357: aconst_null
    //   358: areturn
    //   359: astore #6
    //   361: aload_0
    //   362: astore_1
    //   363: aload #6
    //   365: astore_0
    //   366: aload_1
    //   367: ifnull -> 382
    //   370: aload_1
    //   371: invokevirtual close : ()V
    //   374: goto -> 382
    //   377: astore_1
    //   378: aload_1
    //   379: invokevirtual printStackTrace : ()V
    //   382: aload_0
    //   383: athrow
    //   384: astore_0
    //   385: goto -> 275
    // Exception table:
    //   from	to	target	type
    //   179	189	335	java/io/FileNotFoundException
    //   179	189	329	finally
    //   204	216	384	java/lang/OutOfMemoryError
    //   204	216	241	java/lang/IllegalArgumentException
    //   204	216	227	java/lang/Exception
    //   204	216	219	java/io/FileNotFoundException
    //   204	216	359	finally
    //   231	235	219	java/io/FileNotFoundException
    //   231	235	359	finally
    //   245	249	219	java/io/FileNotFoundException
    //   245	249	359	finally
    //   255	263	219	java/io/FileNotFoundException
    //   255	263	359	finally
    //   266	272	219	java/io/FileNotFoundException
    //   266	272	359	finally
    //   278	286	219	java/io/FileNotFoundException
    //   278	286	359	finally
    //   289	295	219	java/io/FileNotFoundException
    //   289	295	359	finally
    //   298	310	219	java/io/FileNotFoundException
    //   298	310	359	finally
    //   315	320	322	java/io/IOException
    //   341	346	359	finally
    //   353	357	322	java/io/IOException
    //   370	374	377	java/io/IOException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\drawable\apng\ApngImageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */