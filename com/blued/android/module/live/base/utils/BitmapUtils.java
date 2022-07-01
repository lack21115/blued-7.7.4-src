package com.blued.android.module.live.base.utils;

import android.graphics.Bitmap;
import com.blued.android.core.imagecache.RecyclingUtils;
import java.io.File;

public class BitmapUtils {
  public static File a(String paramString, Bitmap paramBitmap, int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #6
    //   3: aconst_null
    //   4: astore #4
    //   6: aload_1
    //   7: ifnonnull -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: new java/io/File
    //   15: dup
    //   16: aload_0
    //   17: invokespecial <init> : (Ljava/lang/String;)V
    //   20: astore #7
    //   22: aload #7
    //   24: invokevirtual exists : ()Z
    //   27: ifne -> 53
    //   30: aload #7
    //   32: invokevirtual getParentFile : ()Ljava/io/File;
    //   35: invokevirtual exists : ()Z
    //   38: ifne -> 59
    //   41: aload #7
    //   43: invokevirtual getParentFile : ()Ljava/io/File;
    //   46: invokevirtual mkdirs : ()Z
    //   49: pop
    //   50: goto -> 59
    //   53: aload #7
    //   55: invokevirtual delete : ()Z
    //   58: pop
    //   59: aload #7
    //   61: invokevirtual createNewFile : ()Z
    //   64: pop
    //   65: goto -> 73
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual printStackTrace : ()V
    //   73: aload #4
    //   75: astore_0
    //   76: new java/io/BufferedOutputStream
    //   79: dup
    //   80: new java/io/FileOutputStream
    //   83: dup
    //   84: aload #7
    //   86: invokespecial <init> : (Ljava/io/File;)V
    //   89: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   92: astore #4
    //   94: aload_1
    //   95: getstatic android/graphics/Bitmap$CompressFormat.JPEG : Landroid/graphics/Bitmap$CompressFormat;
    //   98: iload_2
    //   99: aload #4
    //   101: invokevirtual compress : (Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   104: pop
    //   105: iload_3
    //   106: ifeq -> 113
    //   109: aload_1
    //   110: invokevirtual recycle : ()V
    //   113: aload #4
    //   115: invokevirtual flush : ()V
    //   118: aload #4
    //   120: invokevirtual close : ()V
    //   123: aload #7
    //   125: areturn
    //   126: astore #5
    //   128: aload #4
    //   130: astore_0
    //   131: aload #5
    //   133: astore #4
    //   135: goto -> 196
    //   138: astore #5
    //   140: goto -> 154
    //   143: astore #4
    //   145: goto -> 196
    //   148: astore #5
    //   150: aload #6
    //   152: astore #4
    //   154: aload #4
    //   156: astore_0
    //   157: aload #5
    //   159: invokevirtual printStackTrace : ()V
    //   162: aload #4
    //   164: ifnull -> 193
    //   167: iload_3
    //   168: ifeq -> 175
    //   171: aload_1
    //   172: invokevirtual recycle : ()V
    //   175: aload #4
    //   177: invokevirtual flush : ()V
    //   180: aload #4
    //   182: invokevirtual close : ()V
    //   185: aload #7
    //   187: areturn
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual printStackTrace : ()V
    //   193: aload #7
    //   195: areturn
    //   196: aload_0
    //   197: ifnull -> 224
    //   200: iload_3
    //   201: ifeq -> 208
    //   204: aload_1
    //   205: invokevirtual recycle : ()V
    //   208: aload_0
    //   209: invokevirtual flush : ()V
    //   212: aload_0
    //   213: invokevirtual close : ()V
    //   216: goto -> 224
    //   219: astore_0
    //   220: aload_0
    //   221: invokevirtual printStackTrace : ()V
    //   224: aload #4
    //   226: athrow
    // Exception table:
    //   from	to	target	type
    //   59	65	68	java/io/IOException
    //   76	94	148	java/io/IOException
    //   76	94	143	finally
    //   94	105	138	java/io/IOException
    //   94	105	126	finally
    //   109	113	188	java/io/IOException
    //   113	123	188	java/io/IOException
    //   157	162	143	finally
    //   171	175	188	java/io/IOException
    //   175	185	188	java/io/IOException
    //   204	208	219	java/io/IOException
    //   208	216	219	java/io/IOException
  }
  
  public static String a(Bitmap paramBitmap, boolean paramBoolean) {
    if (paramBitmap == null)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RecyclingUtils.e("shareImg"));
    stringBuilder.append(".jpg");
    String str = stringBuilder.toString();
    a(str, paramBitmap, 100, paramBoolean);
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\bas\\utils\BitmapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */