package com.soft.blued.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.imagecache.RecyclingUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class BitmapUtils {
  public static int a(Context paramContext, ImageView paramImageView, int paramInt, boolean paramBoolean) {
    if (paramInt >= 0) {
      int i = paramInt;
      if (paramInt >= 34)
        i = 34; 
      if (i < 10) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("00");
        stringBuilder1.append(i);
        str = stringBuilder1.toString();
      } else if (i < 100) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("0");
        stringBuilder1.append(i);
        str = stringBuilder1.toString();
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(i);
        stringBuilder1.append("");
        str = stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("rich");
      stringBuilder.append(str);
      String str = stringBuilder.toString();
      paramInt = paramContext.getResources().getIdentifier(str, "drawable", paramContext.getPackageName());
      if (paramImageView != null) {
        paramImageView.setImageResource(paramInt);
        if (i == 0 && paramBoolean) {
          paramImageView.setVisibility(8);
          return paramInt;
        } 
        paramImageView.setVisibility(0);
      } 
      return paramInt;
    } 
    if (paramImageView != null)
      paramImageView.setVisibility(8); 
    return -1;
  }
  
  public static Bitmap a(int paramInt, Bitmap paramBitmap) {
    if (paramBitmap == null)
      return null; 
    Matrix matrix = new Matrix();
    matrix.postRotate(paramInt);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), matrix, true);
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2) {
    return a(paramBitmap1, paramBitmap2, paramInt1, paramBitmap1.getHeight() - paramBitmap2.getHeight() - paramInt2);
  }
  
  public static Bitmap a(Context paramContext, View paramView) {
    if (paramView == null)
      return null; 
    paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    paramView.buildDrawingCache();
    return paramView.getDrawingCache();
  }
  
  public static Bitmap a(Bitmap paramBitmap) {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (i < 4096 && j < 4096)
      return paramBitmap; 
    float f = 'က';
    f = Math.min(f / i, f / j);
    Matrix matrix = new Matrix();
    matrix.postScale(f, f);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, matrix, true);
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat) {
    Matrix matrix = new Matrix();
    matrix.postScale(paramFloat, paramFloat);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), matrix, true);
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2) {
    if (paramBitmap1 == null)
      return null; 
    int i = paramBitmap1.getWidth();
    int j = paramBitmap1.getHeight();
    int k = paramBitmap2.getWidth();
    int m = paramBitmap2.getHeight();
    Bitmap bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    canvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, null);
    canvas.drawBitmap(paramBitmap2, ((i - k) / 2), ((j - m) / 2), null);
    canvas.save();
    canvas.restore();
    return bitmap;
  }
  
  private static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2) {
    if (paramBitmap1 == null)
      return null; 
    if (paramBitmap2 != null) {
      if (paramBitmap1.getWidth() < paramBitmap2.getWidth() + paramInt1 * 2)
        return paramBitmap1; 
      int i = paramBitmap1.getWidth();
      int j = paramBitmap1.getHeight();
      try {
        Bitmap bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      } catch (Exception null) {
        exception.printStackTrace();
        try {
          Bitmap bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
        } catch (Exception exception) {
          exception.printStackTrace();
          exception = null;
        } 
      } 
      if (exception == null)
        return null; 
      Canvas canvas = new Canvas((Bitmap)exception);
      canvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, null);
      canvas.drawBitmap(paramBitmap2, paramInt1, paramInt2, null);
      canvas.save();
      canvas.restore();
      return (Bitmap)exception;
    } 
    return paramBitmap1;
  }
  
  public static Bitmap a(Drawable paramDrawable) {
    Bitmap bitmap;
    try {
      Bitmap.Config config;
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if (paramDrawable.getOpacity() != -1) {
        config = Bitmap.Config.ARGB_8888;
      } else {
        config = Bitmap.Config.RGB_565;
      } 
      bitmap = Bitmap.createBitmap(i, j, config);
    } catch (Exception exception) {
      Bitmap.Config config;
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if (paramDrawable.getOpacity() != -1) {
        config = Bitmap.Config.ARGB_4444;
      } else {
        config = Bitmap.Config.RGB_565;
      } 
      bitmap = Bitmap.createBitmap(i, j, config);
    } 
    Canvas canvas = new Canvas(bitmap);
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    paramDrawable.draw(canvas);
    return bitmap;
  }
  
  public static Bitmap a(View paramView) {
    return a(paramView, Bitmap.Config.RGB_565);
  }
  
  public static Bitmap a(View paramView, Bitmap.Config paramConfig) {
    if (paramView == null)
      return null; 
    paramView.buildDrawingCache(true);
    if (paramView.getDrawingCache(true) == null)
      return null; 
    Bitmap bitmap = paramView.getDrawingCache(true).copy(paramConfig, false);
    paramView.setDrawingCacheEnabled(true);
    if (bitmap == null)
      return null; 
    paramView.setDrawingCacheEnabled(false);
    paramView.destroyDrawingCache();
    return bitmap;
  }
  
  public static Bitmap a(String paramString) {
    // Byte code:
    //   0: ldc 'ddrb'
    //   2: iconst_1
    //   3: anewarray java/lang/Object
    //   6: dup
    //   7: iconst_0
    //   8: ldc 'imageCompression'
    //   10: aastore
    //   11: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   14: invokestatic d : ()Landroid/content/Context;
    //   17: invokestatic a : (Landroid/content/Context;)Z
    //   20: istore #8
    //   22: getstatic android/os/Build$VERSION.SDK_INT : I
    //   25: istore_3
    //   26: sipush #1080
    //   29: istore_2
    //   30: iload_3
    //   31: bipush #11
    //   33: if_icmple -> 48
    //   36: iload #8
    //   38: ifeq -> 60
    //   41: sipush #1620
    //   44: istore_2
    //   45: goto -> 60
    //   48: iload #8
    //   50: ifeq -> 56
    //   53: goto -> 60
    //   56: sipush #720
    //   59: istore_2
    //   60: new android/graphics/BitmapFactory$Options
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: astore #11
    //   69: aload #11
    //   71: iconst_1
    //   72: putfield inJustDecodeBounds : Z
    //   75: aload_0
    //   76: aload #11
    //   78: invokestatic decodeFile : (Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   81: pop
    //   82: aload #11
    //   84: getfield outWidth : I
    //   87: istore #4
    //   89: aload #11
    //   91: getfield outHeight : I
    //   94: istore #5
    //   96: aload #11
    //   98: getfield outWidth : I
    //   101: iload_2
    //   102: idiv
    //   103: istore_3
    //   104: aload #11
    //   106: getfield outHeight : I
    //   109: iload_2
    //   110: idiv
    //   111: istore #6
    //   113: aload #11
    //   115: getfield outWidth : I
    //   118: aload #11
    //   120: getfield outHeight : I
    //   123: imul
    //   124: iload_2
    //   125: iload_2
    //   126: imul
    //   127: idiv
    //   128: istore #7
    //   130: aload #11
    //   132: iload_3
    //   133: iload #6
    //   135: invokestatic max : (II)I
    //   138: putfield inSampleSize : I
    //   141: aload #11
    //   143: iload #7
    //   145: aload #11
    //   147: getfield inSampleSize : I
    //   150: invokestatic min : (II)I
    //   153: putfield inSampleSize : I
    //   156: aload #11
    //   158: iconst_1
    //   159: aload #11
    //   161: getfield inSampleSize : I
    //   164: invokestatic max : (II)I
    //   167: putfield inSampleSize : I
    //   170: aload #11
    //   172: iconst_0
    //   173: putfield inJustDecodeBounds : Z
    //   176: new java/io/FileInputStream
    //   179: dup
    //   180: new java/io/File
    //   183: dup
    //   184: aload_0
    //   185: invokespecial <init> : (Ljava/lang/String;)V
    //   188: invokespecial <init> : (Ljava/io/File;)V
    //   191: astore #9
    //   193: iconst_0
    //   194: istore_3
    //   195: iload_3
    //   196: iconst_2
    //   197: if_icmpge -> 265
    //   200: aload #9
    //   202: astore_0
    //   203: aload #9
    //   205: invokevirtual getFD : ()Ljava/io/FileDescriptor;
    //   208: aconst_null
    //   209: aload #11
    //   211: invokestatic decodeFileDescriptor : (Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   214: astore #10
    //   216: goto -> 268
    //   219: astore #10
    //   221: goto -> 360
    //   224: astore #10
    //   226: aload #9
    //   228: astore_0
    //   229: aload #10
    //   231: invokevirtual printStackTrace : ()V
    //   234: aload #9
    //   236: astore_0
    //   237: invokestatic a : ()Lcom/blued/android/core/imagecache/MemoryRequest;
    //   240: invokevirtual b : ()V
    //   243: aload #9
    //   245: astore_0
    //   246: aload #11
    //   248: aload #11
    //   250: getfield inSampleSize : I
    //   253: iconst_2
    //   254: imul
    //   255: putfield inSampleSize : I
    //   258: iload_3
    //   259: iconst_1
    //   260: iadd
    //   261: istore_3
    //   262: goto -> 195
    //   265: aconst_null
    //   266: astore #10
    //   268: aload #10
    //   270: ifnonnull -> 287
    //   273: aload #9
    //   275: invokevirtual close : ()V
    //   278: aconst_null
    //   279: areturn
    //   280: astore_0
    //   281: aload_0
    //   282: invokevirtual printStackTrace : ()V
    //   285: aconst_null
    //   286: areturn
    //   287: iload #4
    //   289: iload_2
    //   290: if_icmple -> 332
    //   293: iload #5
    //   295: iload_2
    //   296: if_icmpgt -> 302
    //   299: goto -> 332
    //   302: iload_2
    //   303: i2f
    //   304: fstore_1
    //   305: aload #9
    //   307: astore_0
    //   308: aload #10
    //   310: fload_1
    //   311: invokestatic b : (Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   314: astore #10
    //   316: aload #9
    //   318: invokevirtual close : ()V
    //   321: aload #10
    //   323: areturn
    //   324: astore_0
    //   325: aload_0
    //   326: invokevirtual printStackTrace : ()V
    //   329: aload #10
    //   331: areturn
    //   332: aload #9
    //   334: invokevirtual close : ()V
    //   337: aload #10
    //   339: areturn
    //   340: astore_0
    //   341: aload_0
    //   342: invokevirtual printStackTrace : ()V
    //   345: aload #10
    //   347: areturn
    //   348: astore #9
    //   350: aconst_null
    //   351: astore_0
    //   352: goto -> 412
    //   355: astore #10
    //   357: aconst_null
    //   358: astore #9
    //   360: aload #9
    //   362: astore_0
    //   363: ldc 'ddrb'
    //   365: iconst_2
    //   366: anewarray java/lang/Object
    //   369: dup
    //   370: iconst_0
    //   371: ldc_w 'imageCompression e = '
    //   374: aastore
    //   375: dup
    //   376: iconst_1
    //   377: aload #10
    //   379: aastore
    //   380: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   383: aload #9
    //   385: astore_0
    //   386: aload #10
    //   388: invokevirtual printStackTrace : ()V
    //   391: aload #9
    //   393: ifnull -> 408
    //   396: aload #9
    //   398: invokevirtual close : ()V
    //   401: aconst_null
    //   402: areturn
    //   403: astore_0
    //   404: aload_0
    //   405: invokevirtual printStackTrace : ()V
    //   408: aconst_null
    //   409: areturn
    //   410: astore #9
    //   412: aload_0
    //   413: ifnull -> 428
    //   416: aload_0
    //   417: invokevirtual close : ()V
    //   420: goto -> 428
    //   423: astore_0
    //   424: aload_0
    //   425: invokevirtual printStackTrace : ()V
    //   428: aload #9
    //   430: athrow
    // Exception table:
    //   from	to	target	type
    //   176	193	355	java/lang/Exception
    //   176	193	348	finally
    //   203	216	224	java/lang/OutOfMemoryError
    //   203	216	219	java/lang/Exception
    //   203	216	410	finally
    //   229	234	219	java/lang/Exception
    //   229	234	410	finally
    //   237	243	219	java/lang/Exception
    //   237	243	410	finally
    //   246	258	219	java/lang/Exception
    //   246	258	410	finally
    //   273	278	280	java/io/IOException
    //   308	316	219	java/lang/Exception
    //   308	316	410	finally
    //   316	321	324	java/io/IOException
    //   332	337	340	java/io/IOException
    //   363	383	410	finally
    //   386	391	410	finally
    //   396	401	403	java/io/IOException
    //   416	420	423	java/io/IOException
  }
  
  public static Bitmap a(String paramString, int paramInt) {
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, options);
    int i = options.outWidth / paramInt;
    paramInt = options.outHeight / paramInt;
    if (i > 1 || paramInt > 1)
      if (i > paramInt) {
        options.inSampleSize = i;
      } else {
        options.inSampleSize = paramInt;
      }  
    options.inJustDecodeBounds = false;
    try {
      return BitmapFactory.decodeFile(paramString, options);
    } catch (OutOfMemoryError outOfMemoryError) {
      MemoryRequest.a().b();
      return null;
    } 
  }
  
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
  
  public static void a(Bitmap paramBitmap, String paramString, int paramInt) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, byteArrayOutputStream);
      FileOutputStream fileOutputStream = new FileOutputStream(paramString);
      fileOutputStream.write(byteArrayOutputStream.toByteArray());
      Logger.a("drb", new Object[] { "baos.size() = ", Integer.valueOf(byteArrayOutputStream.size()) });
      fileOutputStream.flush();
      fileOutputStream.close();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  private static Bitmap b(Bitmap paramBitmap, float paramFloat) {
    Bitmap bitmap;
    if (paramBitmap == null)
      return null; 
    if (paramBitmap.getWidth() >= paramBitmap.getHeight() && paramBitmap.getWidth() > paramFloat) {
      float f = paramBitmap.getHeight() * paramFloat / paramBitmap.getWidth();
      Bitmap bitmap1 = Bitmap.createScaledBitmap(paramBitmap, (int)paramFloat, (int)f, true);
      bitmap = bitmap1;
      if (!paramBitmap.isRecycled()) {
        bitmap = bitmap1;
        if (!paramBitmap.equals(bitmap1)) {
          paramBitmap.recycle();
          return bitmap1;
        } 
      } 
    } else if (paramBitmap.getHeight() > paramBitmap.getWidth() && paramBitmap.getHeight() > paramFloat) {
      Bitmap bitmap1 = Bitmap.createScaledBitmap(paramBitmap, (int)(paramBitmap.getWidth() * paramFloat / paramBitmap.getHeight()), (int)paramFloat, true);
      bitmap = bitmap1;
      if (paramBitmap != null) {
        bitmap = bitmap1;
        if (!paramBitmap.isRecycled()) {
          bitmap = bitmap1;
          if (!paramBitmap.equals(bitmap1)) {
            paramBitmap.recycle();
            return bitmap1;
          } 
        } 
      } 
    } else {
      bitmap = paramBitmap;
    } 
    return bitmap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\BitmapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */