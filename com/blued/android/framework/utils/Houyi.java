package com.blued.android.framework.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Houyi implements Handler.Callback {
  private String a;
  
  private String b;
  
  private OnCompressListener c;
  
  private Handler d;
  
  private Houyi(Builder paramBuilder) {
    this.a = Builder.a(paramBuilder);
    this.b = Builder.b(paramBuilder);
    this.c = Builder.c(paramBuilder);
    this.d = new Handler(Looper.getMainLooper(), this);
  }
  
  private static Bitmap a(int paramInt, Bitmap paramBitmap) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("rotaingImageView bitmap = ");
    stringBuilder.append(paramBitmap);
    Log.v("Houyi", stringBuilder.toString());
    if (paramBitmap == null)
      return null; 
    Matrix matrix = new Matrix();
    matrix.postRotate(paramInt);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), matrix, true);
  }
  
  private Bitmap a(Bitmap paramBitmap, float paramFloat) {
    Bitmap bitmap;
    Log.v("Houyi", "scaleImg");
    if (paramBitmap == null)
      return null; 
    if (paramBitmap.getWidth() >= paramBitmap.getHeight() && paramBitmap.getWidth() > paramFloat) {
      float f = paramBitmap.getHeight() * paramFloat / paramBitmap.getWidth();
      Bitmap bitmap1 = Bitmap.createScaledBitmap(paramBitmap, (int)paramFloat, (int)f, true);
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
  
  private Bitmap a(String paramString) {
    // Byte code:
    //   0: ldc 'Houyi'
    //   2: ldc 'imageCompression'
    //   4: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   7: pop
    //   8: new android/graphics/BitmapFactory$Options
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: astore #11
    //   17: aload #11
    //   19: iconst_1
    //   20: putfield inJustDecodeBounds : Z
    //   23: aload_1
    //   24: aload #11
    //   26: invokestatic decodeFile : (Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   29: pop
    //   30: aload #11
    //   32: getfield outWidth : I
    //   35: istore #5
    //   37: aload #11
    //   39: getfield outHeight : I
    //   42: istore #6
    //   44: new java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial <init> : ()V
    //   51: astore #9
    //   53: aload #9
    //   55: ldc 'imageCompression outWidth：'
    //   57: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload #9
    //   63: iload #5
    //   65: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload #9
    //   71: ldc ' | outHeight：'
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload #9
    //   79: iload #6
    //   81: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: ldc 'Houyi'
    //   87: aload #9
    //   89: invokevirtual toString : ()Ljava/lang/String;
    //   92: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   95: pop
    //   96: iload #5
    //   98: ifle -> 132
    //   101: iload #6
    //   103: ifle -> 132
    //   106: iload #5
    //   108: iload #6
    //   110: invokestatic max : (II)I
    //   113: iload #5
    //   115: iload #6
    //   117: invokestatic min : (II)I
    //   120: idiv
    //   121: iconst_3
    //   122: if_icmplt -> 132
    //   125: sipush #4096
    //   128: istore_3
    //   129: goto -> 136
    //   132: sipush #1620
    //   135: istore_3
    //   136: aload #11
    //   138: getfield outWidth : I
    //   141: iload_3
    //   142: idiv
    //   143: istore #4
    //   145: aload #11
    //   147: getfield outHeight : I
    //   150: iload_3
    //   151: idiv
    //   152: istore #7
    //   154: aload #11
    //   156: getfield outWidth : I
    //   159: aload #11
    //   161: getfield outHeight : I
    //   164: imul
    //   165: iload_3
    //   166: iload_3
    //   167: imul
    //   168: idiv
    //   169: istore #8
    //   171: aload #11
    //   173: iload #4
    //   175: iload #7
    //   177: invokestatic max : (II)I
    //   180: putfield inSampleSize : I
    //   183: aload #11
    //   185: iload #8
    //   187: aload #11
    //   189: getfield inSampleSize : I
    //   192: invokestatic min : (II)I
    //   195: putfield inSampleSize : I
    //   198: aload #11
    //   200: iconst_1
    //   201: aload #11
    //   203: getfield inSampleSize : I
    //   206: invokestatic max : (II)I
    //   209: putfield inSampleSize : I
    //   212: iconst_0
    //   213: istore #4
    //   215: aload #11
    //   217: iconst_0
    //   218: putfield inJustDecodeBounds : Z
    //   221: new java/io/FileInputStream
    //   224: dup
    //   225: new java/io/File
    //   228: dup
    //   229: aload_1
    //   230: invokespecial <init> : (Ljava/lang/String;)V
    //   233: invokespecial <init> : (Ljava/io/File;)V
    //   236: astore #9
    //   238: iload #4
    //   240: iconst_2
    //   241: if_icmpge -> 362
    //   244: aload #9
    //   246: astore_1
    //   247: aload #9
    //   249: invokevirtual getFD : ()Ljava/io/FileDescriptor;
    //   252: aconst_null
    //   253: aload #11
    //   255: invokestatic decodeFileDescriptor : (Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   258: astore #10
    //   260: goto -> 365
    //   263: astore #10
    //   265: goto -> 458
    //   268: astore #10
    //   270: aload #9
    //   272: astore_1
    //   273: aload #10
    //   275: invokevirtual printStackTrace : ()V
    //   278: aload #9
    //   280: astore_1
    //   281: invokestatic a : ()Lcom/blued/android/core/imagecache/MemoryRequest;
    //   284: invokevirtual b : ()V
    //   287: aload #9
    //   289: astore_1
    //   290: aload #11
    //   292: aload #11
    //   294: getfield inSampleSize : I
    //   297: iconst_2
    //   298: imul
    //   299: putfield inSampleSize : I
    //   302: aload #9
    //   304: astore_1
    //   305: new java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial <init> : ()V
    //   312: astore #10
    //   314: aload #9
    //   316: astore_1
    //   317: aload #10
    //   319: ldc 'oom, opts.inSampleSize:'
    //   321: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload #9
    //   327: astore_1
    //   328: aload #10
    //   330: aload #11
    //   332: getfield inSampleSize : I
    //   335: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload #9
    //   341: astore_1
    //   342: ldc 'Houyi'
    //   344: aload #10
    //   346: invokevirtual toString : ()Ljava/lang/String;
    //   349: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   352: pop
    //   353: iload #4
    //   355: iconst_1
    //   356: iadd
    //   357: istore #4
    //   359: goto -> 238
    //   362: aconst_null
    //   363: astore #10
    //   365: aload #10
    //   367: ifnonnull -> 384
    //   370: aload #9
    //   372: invokevirtual close : ()V
    //   375: aconst_null
    //   376: areturn
    //   377: astore_1
    //   378: aload_1
    //   379: invokevirtual printStackTrace : ()V
    //   382: aconst_null
    //   383: areturn
    //   384: iload #5
    //   386: iload_3
    //   387: if_icmple -> 430
    //   390: iload #6
    //   392: iload_3
    //   393: if_icmpgt -> 399
    //   396: goto -> 430
    //   399: iload_3
    //   400: i2f
    //   401: fstore_2
    //   402: aload #9
    //   404: astore_1
    //   405: aload_0
    //   406: aload #10
    //   408: fload_2
    //   409: invokespecial a : (Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   412: astore #10
    //   414: aload #9
    //   416: invokevirtual close : ()V
    //   419: aload #10
    //   421: areturn
    //   422: astore_1
    //   423: aload_1
    //   424: invokevirtual printStackTrace : ()V
    //   427: aload #10
    //   429: areturn
    //   430: aload #9
    //   432: invokevirtual close : ()V
    //   435: aload #10
    //   437: areturn
    //   438: astore_1
    //   439: aload_1
    //   440: invokevirtual printStackTrace : ()V
    //   443: aload #10
    //   445: areturn
    //   446: astore #9
    //   448: aconst_null
    //   449: astore_1
    //   450: goto -> 487
    //   453: astore #10
    //   455: aconst_null
    //   456: astore #9
    //   458: aload #9
    //   460: astore_1
    //   461: aload #10
    //   463: invokevirtual printStackTrace : ()V
    //   466: aload #9
    //   468: ifnull -> 483
    //   471: aload #9
    //   473: invokevirtual close : ()V
    //   476: aconst_null
    //   477: areturn
    //   478: astore_1
    //   479: aload_1
    //   480: invokevirtual printStackTrace : ()V
    //   483: aconst_null
    //   484: areturn
    //   485: astore #9
    //   487: aload_1
    //   488: ifnull -> 503
    //   491: aload_1
    //   492: invokevirtual close : ()V
    //   495: goto -> 503
    //   498: astore_1
    //   499: aload_1
    //   500: invokevirtual printStackTrace : ()V
    //   503: aload #9
    //   505: athrow
    // Exception table:
    //   from	to	target	type
    //   221	238	453	java/lang/Exception
    //   221	238	446	finally
    //   247	260	268	java/lang/OutOfMemoryError
    //   247	260	263	java/lang/Exception
    //   247	260	485	finally
    //   273	278	263	java/lang/Exception
    //   273	278	485	finally
    //   281	287	263	java/lang/Exception
    //   281	287	485	finally
    //   290	302	263	java/lang/Exception
    //   290	302	485	finally
    //   305	314	263	java/lang/Exception
    //   305	314	485	finally
    //   317	325	263	java/lang/Exception
    //   317	325	485	finally
    //   328	339	263	java/lang/Exception
    //   328	339	485	finally
    //   342	353	263	java/lang/Exception
    //   342	353	485	finally
    //   370	375	377	java/io/IOException
    //   405	414	263	java/lang/Exception
    //   405	414	485	finally
    //   414	419	422	java/io/IOException
    //   430	435	438	java/io/IOException
    //   461	466	485	finally
    //   471	476	478	java/io/IOException
    //   491	495	498	java/io/IOException
  }
  
  public static Builder a() {
    return new Builder();
  }
  
  private static boolean a(Bitmap paramBitmap, String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("compressBmpToFile bmp = ");
    stringBuilder.append(paramBitmap);
    Log.v("Houyi", stringBuilder.toString());
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    boolean bool = false;
    try {
      boolean bool1 = paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, byteArrayOutputStream);
      bool = bool1;
      StringBuilder stringBuilder1 = new StringBuilder();
      bool = bool1;
      stringBuilder1.append("compressBmpToFile isCompressSuccess = ");
      bool = bool1;
      stringBuilder1.append(bool1);
      bool = bool1;
      Log.v("Houyi", stringBuilder1.toString());
      bool = bool1;
      FileOutputStream fileOutputStream = new FileOutputStream(paramString);
      bool = bool1;
      fileOutputStream.write(byteArrayOutputStream.toByteArray());
      bool = bool1;
      StringBuilder stringBuilder2 = new StringBuilder();
      bool = bool1;
      stringBuilder2.append("compressBmpToFile baos.size() = ");
      bool = bool1;
      stringBuilder2.append(byteArrayOutputStream.size());
      bool = bool1;
      Log.v("Houyi", stringBuilder2.toString());
      bool = bool1;
      fileOutputStream.flush();
      bool = bool1;
      fileOutputStream.close();
      return bool1;
    } catch (Exception exception) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("compressBmpToFile e = ");
      stringBuilder1.append(exception.toString());
      Log.v("Houyi", stringBuilder1.toString());
      return bool;
    } 
  }
  
  private boolean a(String paramString1, String paramString2) {
    Bitmap bitmap1 = a(paramString1);
    if (bitmap1 == null)
      return false; 
    Bitmap bitmap2 = a(b(paramString1), bitmap1);
    if (bitmap2 != null) {
      if (bitmap2 != bitmap1 && bitmap1 != null && !bitmap1.isRecycled())
        bitmap1.recycle(); 
      bitmap1 = bitmap2;
    } 
    if (!TextUtils.isEmpty(paramString2))
      paramString1 = paramString2; 
    boolean bool = a(bitmap1, paramString1, 90);
    if (bitmap1 != null && !bitmap1.isRecycled())
      bitmap1.recycle(); 
    return bool;
  }
  
  private static int b(String paramString) {
    try {
      int i = (new ExifInterface(paramString)).getAttributeInt("Orientation", 1);
      return (i != 3) ? ((i != 6) ? ((i != 8) ? 0 : 270) : 90) : 180;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return 0;
    } 
  }
  
  private void b() {
    if (TextUtils.isEmpty(this.a)) {
      OnCompressListener onCompressListener = this.c;
      if (onCompressListener != null)
        onCompressListener.a(new RuntimeException("image originalPath cannot be null")); 
    } 
    (new Thread(new Runnable(this) {
          public void run() {
            Houyi.a(this.a).sendMessage(Houyi.a(this.a).obtainMessage(1));
            Houyi houyi = this.a;
            if (Houyi.a(houyi, Houyi.b(houyi), Houyi.c(this.a))) {
              String str;
              Handler handler1 = Houyi.a(this.a);
              Handler handler2 = Houyi.a(this.a);
              if (!TextUtils.isEmpty(Houyi.c(this.a))) {
                str = Houyi.c(this.a);
              } else {
                str = Houyi.b(this.a);
              } 
              handler1.sendMessage(handler2.obtainMessage(0, str));
              return;
            } 
            Houyi.a(this.a).sendMessage(Houyi.a(this.a).obtainMessage(2, new RuntimeException("Image processing exception, please try again later.")));
          }
        })).start();
  }
  
  private boolean c() {
    return a(this.a, this.b);
  }
  
  public boolean handleMessage(Message paramMessage) {
    if (this.c == null)
      return false; 
    int i = paramMessage.what;
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return false; 
        this.c.a((Throwable)paramMessage.obj);
        return false;
      } 
      this.c.a();
      return false;
    } 
    this.c.a((String)paramMessage.obj);
    return false;
  }
  
  public static class Builder {
    private String a;
    
    private String b;
    
    private Houyi.OnCompressListener c;
    
    private Houyi c() {
      return new Houyi(this);
    }
    
    public Builder a(Houyi.OnCompressListener param1OnCompressListener) {
      this.c = param1OnCompressListener;
      return this;
    }
    
    public Builder a(String param1String) {
      this.a = param1String;
      return this;
    }
    
    public Builder a(String param1String1, String param1String2) {
      this.a = param1String1;
      this.b = param1String2;
      return this;
    }
    
    public void a() {
      Houyi.d(c());
    }
    
    public boolean b() {
      return Houyi.e(c());
    }
  }
  
  public static interface OnCompressListener {
    void a();
    
    void a(String param1String);
    
    void a(Throwable param1Throwable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\Houyi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */