package com.blued.android.core.imagecache;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.drawable.RecyclingBitmapDrawable;
import com.blued.android.core.imagecache.glide.Util;
import com.blued.android.core.net.BinaryHttpResponseHandler;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.utils.ByteArrayPool;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.Md5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecyclingUtils {
  public static int a(float paramFloat) {
    if (paramFloat >= 0.05F && paramFloat <= 0.8F)
      return Math.round(paramFloat * (float)Runtime.getRuntime().maxMemory()); 
    throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.05 and 0.8 (inclusive)");
  }
  
  public static int a(RecyclingBitmapDrawable paramRecyclingBitmapDrawable) {
    Bitmap bitmap = paramRecyclingBitmapDrawable.getBitmap();
    return AppMethods.c(12) ? bitmap.getByteCount() : (bitmap.getRowBytes() * bitmap.getHeight());
  }
  
  public static int a(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      int i = paramString.indexOf("_");
      if (i > 0)
        try {
          return Integer.parseInt(paramString.substring(0, i));
        } catch (Exception exception) {
          exception.printStackTrace();
          return 0;
        }  
      try {
        return Integer.valueOf((String)exception).intValue();
      } catch (Exception exception1) {
        exception1.printStackTrace();
      } 
    } 
    return 0;
  }
  
  public static Drawable a(Context paramContext, String paramString, LoadOptions paramLoadOptions) {
    if (ImageLoaderUtils.a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("decodeLocalDrawable(), uri:");
      stringBuilder.append(paramString);
      Log.a("IMAGE_LOADER", stringBuilder.toString());
    } 
    return a(paramString, paramLoadOptions, paramContext.getResources());
  }
  
  public static Drawable a(String paramString, LoadOptions paramLoadOptions, Resources paramResources) {
    // Byte code:
    //   0: getstatic com/blued/android/core/imagecache/ImageLoaderUtils.a : Z
    //   3: ifeq -> 41
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore #6
    //   15: aload #6
    //   17: ldc 'decodeRemoteDrawable(), uri:'
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload #6
    //   25: aload_0
    //   26: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 'IMAGE_LOADER'
    //   32: aload #6
    //   34: invokevirtual toString : ()Ljava/lang/String;
    //   37: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   40: pop
    //   41: getstatic com/blued/android/core/imagecache/RecyclingUtils$Scheme.f : Lcom/blued/android/core/imagecache/RecyclingUtils$Scheme;
    //   44: aload_0
    //   45: invokevirtual c : (Ljava/lang/String;)Ljava/lang/String;
    //   48: invokestatic a : (Ljava/lang/String;)I
    //   51: istore #4
    //   53: aload_1
    //   54: getfield k : Z
    //   57: ifeq -> 82
    //   60: new pl/droidsonroids/gif/GifDrawable
    //   63: dup
    //   64: aload_2
    //   65: iload #4
    //   67: invokespecial <init> : (Landroid/content/res/Resources;I)V
    //   70: astore #6
    //   72: aload #6
    //   74: areturn
    //   75: astore #6
    //   77: aload #6
    //   79: invokevirtual printStackTrace : ()V
    //   82: new android/graphics/BitmapFactory$Options
    //   85: dup
    //   86: invokespecial <init> : ()V
    //   89: astore #6
    //   91: aload #6
    //   93: iconst_1
    //   94: putfield inJustDecodeBounds : Z
    //   97: aload_2
    //   98: iload #4
    //   100: aload #6
    //   102: invokestatic decodeResource : (Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   105: pop
    //   106: invokestatic b : ()Z
    //   109: istore #5
    //   111: aload #6
    //   113: iload #5
    //   115: invokestatic a : (Landroid/graphics/BitmapFactory$Options;Z)Landroid/graphics/BitmapFactory$Options;
    //   118: astore #10
    //   120: aload #10
    //   122: aload #10
    //   124: getfield outWidth : I
    //   127: aload #10
    //   129: getfield outHeight : I
    //   132: aload_1
    //   133: getfield f : Ljava/lang/String;
    //   136: invokestatic a : (IILjava/lang/String;)I
    //   139: putfield inSampleSize : I
    //   142: aconst_null
    //   143: astore #9
    //   145: aconst_null
    //   146: astore_1
    //   147: iconst_0
    //   148: istore_3
    //   149: aload #9
    //   151: astore #8
    //   153: aload_1
    //   154: astore #7
    //   156: iload_3
    //   157: iconst_3
    //   158: if_icmpgt -> 294
    //   161: iload_3
    //   162: iconst_1
    //   163: iadd
    //   164: istore_3
    //   165: iload #5
    //   167: ifeq -> 181
    //   170: aload_1
    //   171: astore #7
    //   173: aload_1
    //   174: astore #6
    //   176: aload #10
    //   178: invokestatic a : (Landroid/graphics/BitmapFactory$Options;)V
    //   181: aload_1
    //   182: astore #7
    //   184: aload_1
    //   185: astore #6
    //   187: aload_2
    //   188: iload #4
    //   190: aload #10
    //   192: invokestatic decodeResource : (Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   195: astore_1
    //   196: aload #9
    //   198: astore #8
    //   200: aload_1
    //   201: astore #7
    //   203: aload_1
    //   204: ifnonnull -> 294
    //   207: aload_1
    //   208: astore #7
    //   210: aload_1
    //   211: astore #6
    //   213: aload_2
    //   214: iload #4
    //   216: invokevirtual getDrawable : (I)Landroid/graphics/drawable/Drawable;
    //   219: astore #8
    //   221: aload_1
    //   222: astore #7
    //   224: goto -> 294
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual printStackTrace : ()V
    //   232: invokestatic a : ()Lcom/blued/android/core/imagecache/MemoryRequest;
    //   235: invokevirtual b : ()V
    //   238: aload #10
    //   240: aload #10
    //   242: getfield inSampleSize : I
    //   245: iconst_2
    //   246: imul
    //   247: putfield inSampleSize : I
    //   250: aload #7
    //   252: astore_1
    //   253: goto -> 149
    //   256: astore_1
    //   257: aload_1
    //   258: invokevirtual printStackTrace : ()V
    //   261: aload #9
    //   263: astore #8
    //   265: aload #6
    //   267: astore #7
    //   269: aload #10
    //   271: invokestatic c : (Landroid/graphics/BitmapFactory$Options;)Z
    //   274: ifeq -> 294
    //   277: ldc 'IMAGE_LOADER'
    //   279: ldc 'inBitmap cause exception, cancel it and retry'
    //   281: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   284: pop
    //   285: iconst_0
    //   286: istore #5
    //   288: aload #6
    //   290: astore_1
    //   291: goto -> 149
    //   294: aload #7
    //   296: ifnull -> 344
    //   299: new com/blued/android/core/imagecache/drawable/RecyclingBitmapDrawable
    //   302: dup
    //   303: aload_2
    //   304: aload #7
    //   306: invokespecial <init> : (Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   309: astore_1
    //   310: aload_1
    //   311: aload_0
    //   312: invokevirtual a : (Ljava/lang/String;)V
    //   315: aload_1
    //   316: aload #10
    //   318: getfield outHeight : I
    //   321: putfield b : I
    //   324: aload_1
    //   325: aload #10
    //   327: getfield outWidth : I
    //   330: putfield a : I
    //   333: aload_1
    //   334: aload #10
    //   336: getfield inSampleSize : I
    //   339: putfield c : I
    //   342: aload_1
    //   343: areturn
    //   344: aload #8
    //   346: areturn
    // Exception table:
    //   from	to	target	type
    //   60	72	75	java/io/IOException
    //   176	181	256	java/lang/IllegalArgumentException
    //   176	181	227	java/lang/OutOfMemoryError
    //   187	196	256	java/lang/IllegalArgumentException
    //   187	196	227	java/lang/OutOfMemoryError
    //   213	221	256	java/lang/IllegalArgumentException
    //   213	221	227	java/lang/OutOfMemoryError
  }
  
  public static Drawable a(String paramString, LoadOptions paramLoadOptions, Handler paramHandler, ImageLoadingListener paramImageLoadingListener) throws Throwable {
    String str = d(paramString);
    File file = new File(str);
    if (file.exists() && file.length() > 0L && file.canRead())
      try {
        return drawable;
      } finally {
        str = null;
        str.printStackTrace();
      }  
    if (paramLoadOptions.h) {
      if (paramLoadOptions.m)
        try {
          return b(paramString, paramLoadOptions, paramHandler, paramImageLoadingListener);
        } finally {
          str = null;
        }  
      if (ImageLoaderUtils.a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("download file failed, try to memory, uri:");
        stringBuilder.append(paramString);
        Log.b("IMAGE_LOADER", stringBuilder.toString());
      } 
      return c(paramString, paramLoadOptions, paramHandler, paramImageLoadingListener);
    } 
    return null;
  }
  
  public static Drawable a(String paramString, InputStream paramInputStream, LoadOptions paramLoadOptions) throws Throwable {
    if (ImageLoaderUtils.a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("decodeInputStreamToDrawable(), uri:");
      stringBuilder.append(paramString);
      Log.a("IMAGE_LOADER", stringBuilder.toString());
    } 
    return (paramInputStream == null) ? null : a(paramString, AppMethods.a(paramInputStream), paramLoadOptions);
  }
  
  public static Drawable a(String paramString, byte[] paramArrayOfbyte, LoadOptions paramLoadOptions) throws Throwable {
    // Byte code:
    //   0: getstatic com/blued/android/core/imagecache/ImageLoaderUtils.a : Z
    //   3: ifeq -> 42
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore #5
    //   15: aload #5
    //   17: ldc_w 'decodeBytesToDrawable(), uri:'
    //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload #5
    //   26: aload_0
    //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: ldc 'IMAGE_LOADER'
    //   33: aload #5
    //   35: invokevirtual toString : ()Ljava/lang/String;
    //   38: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   41: pop
    //   42: aload_1
    //   43: ifnonnull -> 48
    //   46: aconst_null
    //   47: areturn
    //   48: aload_2
    //   49: getfield k : Z
    //   52: ifeq -> 64
    //   55: new pl/droidsonroids/gif/GifDrawable
    //   58: dup
    //   59: aload_1
    //   60: invokespecial <init> : ([B)V
    //   63: areturn
    //   64: new android/graphics/BitmapFactory$Options
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: astore #5
    //   73: aload #5
    //   75: iconst_1
    //   76: putfield inJustDecodeBounds : Z
    //   79: aload_1
    //   80: iconst_0
    //   81: aload_1
    //   82: arraylength
    //   83: aload #5
    //   85: invokestatic decodeByteArray : ([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   88: pop
    //   89: invokestatic b : ()Z
    //   92: istore #4
    //   94: aload #5
    //   96: iload #4
    //   98: invokestatic a : (Landroid/graphics/BitmapFactory$Options;Z)Landroid/graphics/BitmapFactory$Options;
    //   101: astore #6
    //   103: aload #6
    //   105: aload #6
    //   107: getfield outWidth : I
    //   110: aload #6
    //   112: getfield outHeight : I
    //   115: aload_2
    //   116: getfield f : Ljava/lang/String;
    //   119: invokestatic a : (IILjava/lang/String;)I
    //   122: putfield inSampleSize : I
    //   125: aconst_null
    //   126: astore_2
    //   127: iconst_0
    //   128: istore_3
    //   129: aload_2
    //   130: astore #5
    //   132: iload_3
    //   133: iconst_3
    //   134: if_icmpgt -> 229
    //   137: iload_3
    //   138: iconst_1
    //   139: iadd
    //   140: istore_3
    //   141: iload #4
    //   143: ifeq -> 151
    //   146: aload #6
    //   148: invokestatic a : (Landroid/graphics/BitmapFactory$Options;)V
    //   151: aload_1
    //   152: iconst_0
    //   153: aload_1
    //   154: arraylength
    //   155: aload #6
    //   157: invokestatic decodeByteArray : ([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   160: astore #5
    //   162: aload #5
    //   164: astore_1
    //   165: goto -> 234
    //   168: astore #5
    //   170: goto -> 229
    //   173: astore_2
    //   174: aload_2
    //   175: invokevirtual printStackTrace : ()V
    //   178: invokestatic a : ()Lcom/blued/android/core/imagecache/MemoryRequest;
    //   181: invokevirtual b : ()V
    //   184: aload #6
    //   186: aload #6
    //   188: getfield inSampleSize : I
    //   191: iconst_2
    //   192: imul
    //   193: putfield inSampleSize : I
    //   196: goto -> 129
    //   199: astore_2
    //   200: aload_2
    //   201: invokevirtual printStackTrace : ()V
    //   204: aload_2
    //   205: astore #5
    //   207: aload #6
    //   209: invokestatic c : (Landroid/graphics/BitmapFactory$Options;)Z
    //   212: ifeq -> 229
    //   215: ldc 'IMAGE_LOADER'
    //   217: ldc 'inBitmap cause exception, cancel it and retry'
    //   219: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   222: pop
    //   223: iconst_0
    //   224: istore #4
    //   226: goto -> 129
    //   229: aconst_null
    //   230: astore_1
    //   231: aload #5
    //   233: astore_2
    //   234: aload_1
    //   235: ifnull -> 287
    //   238: new com/blued/android/core/imagecache/drawable/RecyclingBitmapDrawable
    //   241: dup
    //   242: invokestatic d : ()Landroid/content/Context;
    //   245: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   248: aload_1
    //   249: invokespecial <init> : (Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   252: astore_1
    //   253: aload_1
    //   254: aload_0
    //   255: invokevirtual a : (Ljava/lang/String;)V
    //   258: aload_1
    //   259: aload #6
    //   261: getfield outHeight : I
    //   264: putfield b : I
    //   267: aload_1
    //   268: aload #6
    //   270: getfield outWidth : I
    //   273: putfield a : I
    //   276: aload_1
    //   277: aload #6
    //   279: getfield inSampleSize : I
    //   282: putfield c : I
    //   285: aload_1
    //   286: areturn
    //   287: aload_2
    //   288: ifnull -> 293
    //   291: aload_2
    //   292: athrow
    //   293: new com/blued/android/core/imagecache/LoadDrawableException
    //   296: dup
    //   297: getstatic com/blued/android/core/imagecache/FailReason$FailType.j : Lcom/blued/android/core/imagecache/FailReason$FailType;
    //   300: aconst_null
    //   301: invokespecial <init> : (Lcom/blued/android/core/imagecache/FailReason$FailType;Ljava/lang/Throwable;)V
    //   304: athrow
    // Exception table:
    //   from	to	target	type
    //   146	151	199	java/lang/IllegalArgumentException
    //   146	151	173	java/lang/OutOfMemoryError
    //   146	151	168	java/lang/Exception
    //   151	162	199	java/lang/IllegalArgumentException
    //   151	162	173	java/lang/OutOfMemoryError
    //   151	162	168	java/lang/Exception
  }
  
  public static File a(File paramFile, String paramString) {
    if (paramFile != null && paramFile.exists()) {
      File file = new File(d(paramString));
      file.delete();
      paramFile.renameTo(file);
      return file;
    } 
    return null;
  }
  
  public static String a() {
    File file = AppInfo.d().getExternalFilesDir(null);
    if (file != null) {
      file = new File(file, "img");
      if (!file.exists())
        file.mkdirs(); 
      if (file.exists() && file.canRead() && file.canWrite())
        return file.getAbsolutePath(); 
    } 
    file = AppInfo.d().getCacheDir();
    if (file != null) {
      file = new File(file, "img");
      if (!file.exists())
        file.mkdirs(); 
      if (file.exists())
        return file.getAbsolutePath(); 
    } 
    return null;
  }
  
  public static String a(int paramInt) {
    return String.valueOf(paramInt);
  }
  
  public static String a(String paramString, LoadOptions paramLoadOptions) {
    StringBuilder stringBuilder = new StringBuilder(paramString);
    stringBuilder.append("*");
    stringBuilder.append(paramLoadOptions.f);
    stringBuilder.append("*");
    stringBuilder.append(paramLoadOptions.k);
    return stringBuilder.toString();
  }
  
  protected static void a(BitmapFactory.Options paramOptions) {
    if (paramOptions.inBitmap != null)
      return; 
    if (!paramOptions.inPurgeable)
      paramOptions.inMutable = true; 
    Bitmap bitmap = b(paramOptions);
    if (bitmap != null) {
      if (ImageLoaderUtils.a)
        Log.b("IMAGE_LOADER", "Found bitmap to use for inBitmap"); 
      paramOptions.inBitmap = bitmap;
    } 
  }
  
  private static boolean a(File paramFile) {
    boolean bool = false;
    File file2 = null;
    iOException = null;
    byte[] arrayOfByte = null;
    try {
    
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException1) {
      return false;
    } finally {
      iOException = null;
      paramFile = file1;
      IOException iOException1 = iOException;
      AppMethods.b((InputStream)paramFile);
    } 
    File file1 = paramFile;
    iOException.printStackTrace();
    AppMethods.b((InputStream)paramFile);
    return false;
  }
  
  public static boolean a(InputStream paramInputStream, File paramFile) {
    byte[] arrayOfByte5 = null;
    byte[] arrayOfByte6 = null;
    byte[] arrayOfByte4 = null;
    byte[] arrayOfByte1 = arrayOfByte4;
    byte[] arrayOfByte2 = arrayOfByte5;
    byte[] arrayOfByte3 = arrayOfByte6;
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(paramFile, false);
      arrayOfByte1 = arrayOfByte4;
      arrayOfByte2 = arrayOfByte5;
      arrayOfByte3 = arrayOfByte6;
      byte[] arrayOfByte = ByteArrayPool.a.a(1024);
      while (true) {
        arrayOfByte1 = arrayOfByte;
        arrayOfByte2 = arrayOfByte;
        arrayOfByte3 = arrayOfByte;
        int i = paramInputStream.read(arrayOfByte);
        if (i > 0) {
          arrayOfByte1 = arrayOfByte;
          arrayOfByte2 = arrayOfByte;
          arrayOfByte3 = arrayOfByte;
          fileOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        arrayOfByte1 = arrayOfByte;
        arrayOfByte2 = arrayOfByte;
        arrayOfByte3 = arrayOfByte;
        fileOutputStream.close();
        arrayOfByte1 = arrayOfByte;
        arrayOfByte2 = arrayOfByte;
        arrayOfByte3 = arrayOfByte;
        paramInputStream.close();
        ByteArrayPool.a.a(arrayOfByte);
        return true;
      } 
    } catch (FileNotFoundException fileNotFoundException) {
      arrayOfByte1 = arrayOfByte3;
      fileNotFoundException.printStackTrace();
      ByteArrayPool.a.a(arrayOfByte3);
      return false;
    } catch (IOException iOException) {
      arrayOfByte1 = arrayOfByte2;
      iOException.printStackTrace();
      ByteArrayPool.a.a(arrayOfByte2);
      return false;
    } finally {}
    ByteArrayPool.a.a(arrayOfByte1);
    throw paramInputStream;
  }
  
  protected static Bitmap b(BitmapFactory.Options paramOptions) {
    if (paramOptions.outHeight > 0 && paramOptions.outWidth > 0) {
      int i = paramOptions.outWidth / paramOptions.inSampleSize;
      int j = paramOptions.outHeight / paramOptions.inSampleSize;
      synchronized ((RecyclingImageLoader.a()).b) {
        return (RecyclingImageLoader.a()).b.a(i, j, paramOptions.inPreferredConfig);
      } 
    } 
    return null;
  }
  
  public static Drawable b(String paramString, LoadOptions paramLoadOptions) {
    return a(AppInfo.d(), paramString, paramLoadOptions);
  }
  
  private static Drawable b(String paramString, LoadOptions paramLoadOptions, Handler paramHandler, ImageLoadingListener paramImageLoadingListener) throws Throwable {
    LoadDrawableException loadDrawableException;
    Object object;
    boolean bool;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("decodeHttpToDrawable(), uri:");
    stringBuilder.append(paramString);
    Log.a("IMAGE_LOADER", stringBuilder.toString());
    File file = new File(e(paramString));
    if (file.exists())
      file.delete(); 
    FileHttpResponseHandler fileHttpResponseHandler = new FileHttpResponseHandler(paramImageLoadingListener, paramHandler) {
        private long c = 0L;
        
        private int d = -1;
        
        private int e = 0;
        
        private long f = 0L;
        
        public void a(File param1File) {
          if (param1File != null) {
            if (param1File.length() != this.f) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("文件长度下载不匹配, orgfileLength:");
              stringBuilder.append(this.f);
              stringBuilder.append(", downloadfileLength:");
              stringBuilder.append(param1File.length());
              Log.e("IMAGE_LOADER", stringBuilder.toString());
            } 
            setData(Boolean.valueOf(true));
            return;
          } 
          Log.e("IMAGE_LOADER", "content is null");
        }
        
        public void a(Throwable param1Throwable, int param1Int, File param1File) {
          super.onFailure(param1Throwable, param1Int, param1File);
          if (param1Throwable instanceof java.net.UnknownHostException || param1Throwable instanceof java.net.SocketTimeoutException || param1Throwable instanceof java.net.SocketException) {
            param1Throwable = new LoadDrawableException(FailReason.FailType.e, param1Throwable);
          } else if (param1Throwable instanceof IOException) {
            String str = ((IOException)param1Throwable).getMessage();
            if (!TextUtils.isEmpty(str) && (str.contains("ENOSPC") || str.contains("No space left on device")))
              AutoClearImageDiskCache.a().b(); 
          } else {
            param1Throwable = new LoadDrawableException(FailReason.FailType.e, param1Throwable);
          } 
          setData(param1Throwable);
        }
        
        public boolean onAccept(int param1Int, long param1Long) {
          this.f = param1Long;
          return super.onAccept(param1Int, param1Long);
        }
        
        public void onCancel() {
          super.onCancel();
        }
        
        public void onFinish() {
          super.onFinish();
        }
        
        public void onProgress(int param1Int1, int param1Int2) {
          // Byte code:
          //   0: aload_0
          //   1: iload_1
          //   2: iload_2
          //   3: invokespecial onProgress : (II)V
          //   6: aload_0
          //   7: getfield a : Lcom/blued/android/core/imagecache/ImageLoadingListener;
          //   10: astore #6
          //   12: aload #6
          //   14: ifnull -> 133
          //   17: aload #6
          //   19: invokeinterface a : ()Z
          //   24: ifne -> 28
          //   27: return
          //   28: invokestatic currentTimeMillis : ()J
          //   31: lstore #4
          //   33: lload #4
          //   35: aload_0
          //   36: getfield c : J
          //   39: lsub
          //   40: aload_0
          //   41: getfield e : I
          //   44: i2l
          //   45: lcmp
          //   46: iflt -> 57
          //   49: iload_1
          //   50: aload_0
          //   51: getfield d : I
          //   54: if_icmpne -> 81
          //   57: iload_1
          //   58: bipush #100
          //   60: if_icmpeq -> 81
          //   63: aload_0
          //   64: getfield d : I
          //   67: istore_3
          //   68: iload_1
          //   69: iload_3
          //   70: if_icmpeq -> 133
          //   73: iload_1
          //   74: iload_3
          //   75: isub
          //   76: bipush #10
          //   78: if_icmplt -> 133
          //   81: aload_0
          //   82: getfield b : Landroid/os/Handler;
          //   85: astore #6
          //   87: aload #6
          //   89: ifnull -> 111
          //   92: aload #6
          //   94: new com/blued/android/core/imagecache/RecyclingUtils$1$1
          //   97: dup
          //   98: aload_0
          //   99: iload_1
          //   100: iload_2
          //   101: invokespecial <init> : (Lcom/blued/android/core/imagecache/RecyclingUtils$1;II)V
          //   104: invokevirtual post : (Ljava/lang/Runnable;)Z
          //   107: pop
          //   108: goto -> 122
          //   111: aload_0
          //   112: getfield a : Lcom/blued/android/core/imagecache/ImageLoadingListener;
          //   115: iload_1
          //   116: iload_2
          //   117: invokeinterface a : (II)V
          //   122: aload_0
          //   123: lload #4
          //   125: putfield c : J
          //   128: aload_0
          //   129: iload_1
          //   130: putfield d : I
          //   133: return
        }
        
        public void onStart() {
          super.onStart();
          if (this.a != null)
            this.e = 10; 
        }
      };
    if (paramLoadOptions.a() && f(paramString)) {
      bool = true;
    } else {
      bool = false;
    } 
    boolean bool1 = false;
    while (true) {
      String str1;
      if (bool) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString);
        stringBuilder1.append(".webp");
        str1 = stringBuilder1.toString();
      } else {
        str1 = paramString;
      } 
      long l1 = System.currentTimeMillis();
      if (ImageLoaderUtils.a) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("downloadTest, image downloading, downloadUrl:");
        stringBuilder1.append(str1);
        Log.a("IMAGE_LOADER", stringBuilder1.toString());
      } 
      FileDownloader.a(str1, file.getAbsolutePath(), fileHttpResponseHandler);
      long l2 = System.currentTimeMillis();
      if (ImageLoaderUtils.a) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("downloadTest, downloadTime:");
        stringBuilder1.append(l2 - l1);
        stringBuilder1.append(", downloadUrl:");
        stringBuilder1.append(str1);
        Log.a("IMAGE_LOADER", stringBuilder1.toString());
      } 
      object = fileHttpResponseHandler.getData();
      if (object instanceof Boolean)
        bool1 = ((Boolean)object).booleanValue(); 
      if (!bool1 && bool) {
        bool = false;
        continue;
      } 
      break;
    } 
    if (file.exists() && bool1) {
      object = a(file, paramString);
      if (HttpManager.c())
        if (a((File)object)) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("webp file, url:");
          stringBuilder1.append(paramString);
          Log.a("IMAGE_LOADER", stringBuilder1.toString());
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("not webp file, url:");
          stringBuilder1.append(paramString);
          Log.a("IMAGE_LOADER", stringBuilder1.toString());
        }  
      if (paramLoadOptions.i)
        try {
          Drawable drawable = c(Scheme.c.b(object.getAbsolutePath()), paramLoadOptions);
          return drawable;
        } finally {
          paramString.printStackTrace();
        }  
      return null;
    } 
    if (object instanceof Throwable) {
      Throwable throwable = (Throwable)object;
    } else {
      paramString = null;
    } 
    String str = paramString;
    if (paramString == null)
      loadDrawableException = new LoadDrawableException(FailReason.FailType.e, null); 
    throw loadDrawableException;
  }
  
  protected static InputStream b(String paramString) throws FileNotFoundException {
    return AppInfo.d().getContentResolver().openInputStream(Uri.parse(paramString));
  }
  
  public static boolean b() {
    return true;
  }
  
  public static int c() {
    int j = Util.a();
    int i = j;
    if (j <= 0)
      i = 6; 
    if (ImageLoaderUtils.a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("default thread count:");
      stringBuilder.append(i);
      Log.a("IMAGE_LOADER", stringBuilder.toString());
    } 
    return i;
  }
  
  public static Drawable c(String paramString, LoadOptions paramLoadOptions) throws Throwable {
    // Byte code:
    //   0: getstatic com/blued/android/core/imagecache/ImageLoaderUtils.a : Z
    //   3: ifeq -> 42
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore #8
    //   15: aload #8
    //   17: ldc_w 'decodeFileToDrawable(), uri:'
    //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload #8
    //   26: aload_0
    //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: ldc 'IMAGE_LOADER'
    //   33: aload #8
    //   35: invokevirtual toString : ()Ljava/lang/String;
    //   38: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   41: pop
    //   42: getstatic com/blued/android/core/imagecache/RecyclingUtils$Scheme.c : Lcom/blued/android/core/imagecache/RecyclingUtils$Scheme;
    //   45: aload_0
    //   46: invokevirtual c : (Ljava/lang/String;)Ljava/lang/String;
    //   49: astore #17
    //   51: aload #17
    //   53: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   56: ifne -> 864
    //   59: aload_1
    //   60: getfield i : Z
    //   63: ifne -> 68
    //   66: aconst_null
    //   67: areturn
    //   68: new android/graphics/BitmapFactory$Options
    //   71: dup
    //   72: invokespecial <init> : ()V
    //   75: astore #8
    //   77: aload #8
    //   79: iconst_1
    //   80: putfield inJustDecodeBounds : Z
    //   83: new java/io/File
    //   86: dup
    //   87: aload #17
    //   89: invokespecial <init> : (Ljava/lang/String;)V
    //   92: astore #18
    //   94: aload #17
    //   96: aload #8
    //   98: invokestatic decodeFile : (Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   101: pop
    //   102: aload #8
    //   104: getfield outMimeType : Ljava/lang/String;
    //   107: astore #9
    //   109: aload #9
    //   111: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   114: ifne -> 145
    //   117: aload #9
    //   119: ldc_w 'gif'
    //   122: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   125: ifeq -> 145
    //   128: aload_1
    //   129: getfield k : Z
    //   132: ifeq -> 145
    //   135: new pl/droidsonroids/gif/GifDrawable
    //   138: dup
    //   139: aload #17
    //   141: invokespecial <init> : (Ljava/lang/String;)V
    //   144: areturn
    //   145: aload #8
    //   147: getfield outHeight : I
    //   150: istore #5
    //   152: aload #8
    //   154: getfield outWidth : I
    //   157: istore #6
    //   159: aload #8
    //   161: getfield outWidth : I
    //   164: aload #8
    //   166: getfield outHeight : I
    //   169: aload_1
    //   170: getfield f : Ljava/lang/String;
    //   173: invokestatic a : (IILjava/lang/String;)I
    //   176: istore_2
    //   177: aload #8
    //   179: getfield outWidth : I
    //   182: aload #8
    //   184: getfield outHeight : I
    //   187: aload_1
    //   188: getfield f : Ljava/lang/String;
    //   191: invokestatic b : (IILjava/lang/String;)I
    //   194: istore_3
    //   195: invokestatic b : ()Z
    //   198: istore #7
    //   200: aload #8
    //   202: iload #7
    //   204: invokestatic a : (Landroid/graphics/BitmapFactory$Options;Z)Landroid/graphics/BitmapFactory$Options;
    //   207: astore #19
    //   209: aload #19
    //   211: iload_2
    //   212: putfield inSampleSize : I
    //   215: aload_1
    //   216: invokevirtual b : ()Z
    //   219: ifne -> 230
    //   222: aload #19
    //   224: iload_3
    //   225: putfield inSampleSize : I
    //   228: iload_3
    //   229: istore_2
    //   230: new java/io/FileInputStream
    //   233: dup
    //   234: aload #17
    //   236: invokespecial <init> : (Ljava/lang/String;)V
    //   239: astore #16
    //   241: aconst_null
    //   242: astore #10
    //   244: aload #10
    //   246: astore #13
    //   248: iconst_0
    //   249: istore_3
    //   250: aload #10
    //   252: astore #9
    //   254: aload #13
    //   256: astore #12
    //   258: iload_3
    //   259: iconst_3
    //   260: if_icmpgt -> 682
    //   263: iload_3
    //   264: iconst_1
    //   265: iadd
    //   266: istore #4
    //   268: iload #7
    //   270: ifeq -> 288
    //   273: iload_2
    //   274: istore_3
    //   275: aload #10
    //   277: astore #8
    //   279: aload #16
    //   281: astore #15
    //   283: aload #19
    //   285: invokestatic a : (Landroid/graphics/BitmapFactory$Options;)V
    //   288: iload_2
    //   289: istore_3
    //   290: aload #10
    //   292: astore #8
    //   294: aload #10
    //   296: astore #12
    //   298: aload #10
    //   300: astore #11
    //   302: aload #10
    //   304: astore #14
    //   306: aload #16
    //   308: astore #15
    //   310: aload #16
    //   312: invokevirtual getFD : ()Ljava/io/FileDescriptor;
    //   315: aconst_null
    //   316: aload #19
    //   318: invokestatic decodeFileDescriptor : (Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   321: astore #9
    //   323: aload #9
    //   325: astore #10
    //   327: aload #9
    //   329: ifnull -> 396
    //   332: aload #9
    //   334: astore #10
    //   336: iload_2
    //   337: istore_3
    //   338: aload #9
    //   340: astore #8
    //   342: aload #9
    //   344: astore #12
    //   346: aload #9
    //   348: astore #11
    //   350: aload #9
    //   352: astore #14
    //   354: aload #16
    //   356: astore #15
    //   358: aload_1
    //   359: getfield j : Z
    //   362: ifeq -> 396
    //   365: iload_2
    //   366: istore_3
    //   367: aload #9
    //   369: astore #8
    //   371: aload #9
    //   373: astore #12
    //   375: aload #9
    //   377: astore #11
    //   379: aload #9
    //   381: astore #14
    //   383: aload #16
    //   385: astore #15
    //   387: aload #17
    //   389: aload #9
    //   391: invokestatic a : (Ljava/lang/String;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   394: astore #10
    //   396: aload #10
    //   398: astore #9
    //   400: aload #13
    //   402: astore #12
    //   404: aload #10
    //   406: ifnonnull -> 682
    //   409: iload_2
    //   410: istore_3
    //   411: aload #10
    //   413: astore #8
    //   415: aload #10
    //   417: astore #11
    //   419: aload #10
    //   421: astore #14
    //   423: aload #16
    //   425: astore #15
    //   427: aload #18
    //   429: invokevirtual delete : ()Z
    //   432: pop
    //   433: aload #10
    //   435: astore #9
    //   437: aload #13
    //   439: astore #12
    //   441: goto -> 682
    //   444: astore_1
    //   445: iload_3
    //   446: istore_2
    //   447: aload #16
    //   449: astore #9
    //   451: goto -> 733
    //   454: astore_1
    //   455: iload_2
    //   456: istore_3
    //   457: aload #12
    //   459: astore #8
    //   461: aload #16
    //   463: astore #15
    //   465: new java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial <init> : ()V
    //   472: astore #9
    //   474: iload_2
    //   475: istore_3
    //   476: aload #12
    //   478: astore #8
    //   480: aload #16
    //   482: astore #15
    //   484: aload #9
    //   486: ldc_w 'decodeFileToDrawable - '
    //   489: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: iload_2
    //   494: istore_3
    //   495: aload #12
    //   497: astore #8
    //   499: aload #16
    //   501: astore #15
    //   503: aload #9
    //   505: aload_1
    //   506: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: iload_2
    //   511: istore_3
    //   512: aload #12
    //   514: astore #8
    //   516: aload #16
    //   518: astore #15
    //   520: ldc 'IMAGE_LOADER'
    //   522: aload #9
    //   524: invokevirtual toString : ()Ljava/lang/String;
    //   527: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   530: pop
    //   531: aload #12
    //   533: astore #9
    //   535: aload_1
    //   536: astore #12
    //   538: goto -> 682
    //   541: astore #13
    //   543: iload_2
    //   544: istore_3
    //   545: aload #11
    //   547: astore #8
    //   549: aload #16
    //   551: astore #15
    //   553: aload #13
    //   555: invokevirtual printStackTrace : ()V
    //   558: iload_2
    //   559: istore_3
    //   560: aload #11
    //   562: astore #8
    //   564: aload #11
    //   566: astore #9
    //   568: aload #13
    //   570: astore #12
    //   572: aload #16
    //   574: astore #15
    //   576: aload #19
    //   578: invokestatic c : (Landroid/graphics/BitmapFactory$Options;)Z
    //   581: ifeq -> 682
    //   584: iload_2
    //   585: istore_3
    //   586: aload #11
    //   588: astore #8
    //   590: aload #16
    //   592: astore #15
    //   594: ldc 'IMAGE_LOADER'
    //   596: ldc 'inBitmap cause exception, cancel it and retry'
    //   598: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   601: pop
    //   602: iload #4
    //   604: istore_3
    //   605: iconst_0
    //   606: istore #7
    //   608: aload #11
    //   610: astore #10
    //   612: goto -> 250
    //   615: astore #13
    //   617: iload_2
    //   618: istore_3
    //   619: aload #14
    //   621: astore #8
    //   623: aload #16
    //   625: astore #15
    //   627: ldc 'IMAGE_LOADER'
    //   629: ldc_w 'OutOfMemoryError, try to decrease inSampleSize'
    //   632: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   635: pop
    //   636: iload_2
    //   637: istore_3
    //   638: aload #14
    //   640: astore #8
    //   642: aload #16
    //   644: astore #15
    //   646: invokestatic a : ()Lcom/blued/android/core/imagecache/MemoryRequest;
    //   649: invokevirtual b : ()V
    //   652: iload_2
    //   653: iconst_2
    //   654: imul
    //   655: istore_2
    //   656: iload_2
    //   657: istore_3
    //   658: aload #14
    //   660: astore #8
    //   662: aload #16
    //   664: astore #15
    //   666: aload #19
    //   668: iload_2
    //   669: putfield inSampleSize : I
    //   672: iload #4
    //   674: istore_3
    //   675: aload #14
    //   677: astore #10
    //   679: goto -> 250
    //   682: iload_2
    //   683: istore_3
    //   684: aload #9
    //   686: astore #11
    //   688: aload #12
    //   690: astore #10
    //   692: aload #16
    //   694: invokevirtual close : ()V
    //   697: iload_2
    //   698: istore_3
    //   699: aload #9
    //   701: astore #11
    //   703: aload #12
    //   705: astore #10
    //   707: goto -> 778
    //   710: astore_1
    //   711: aload_1
    //   712: invokevirtual printStackTrace : ()V
    //   715: goto -> 778
    //   718: astore_0
    //   719: aconst_null
    //   720: astore #15
    //   722: goto -> 844
    //   725: astore_1
    //   726: aconst_null
    //   727: astore #9
    //   729: aload #9
    //   731: astore #8
    //   733: aload #9
    //   735: astore #15
    //   737: aload_1
    //   738: invokevirtual printStackTrace : ()V
    //   741: iload_2
    //   742: istore_3
    //   743: aload #8
    //   745: astore #11
    //   747: aload_1
    //   748: astore #10
    //   750: aload #9
    //   752: ifnull -> 778
    //   755: iload_2
    //   756: istore_3
    //   757: aload #8
    //   759: astore #11
    //   761: aload_1
    //   762: astore #10
    //   764: aload #9
    //   766: invokevirtual close : ()V
    //   769: aload_1
    //   770: astore #10
    //   772: aload #8
    //   774: astore #11
    //   776: iload_2
    //   777: istore_3
    //   778: aload #11
    //   780: ifnull -> 823
    //   783: new com/blued/android/core/imagecache/drawable/RecyclingBitmapDrawable
    //   786: dup
    //   787: invokestatic d : ()Landroid/content/Context;
    //   790: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   793: aload #11
    //   795: invokespecial <init> : (Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   798: astore_1
    //   799: aload_1
    //   800: aload_0
    //   801: invokevirtual a : (Ljava/lang/String;)V
    //   804: aload_1
    //   805: iload #5
    //   807: putfield b : I
    //   810: aload_1
    //   811: iload #6
    //   813: putfield a : I
    //   816: aload_1
    //   817: iload_3
    //   818: putfield c : I
    //   821: aload_1
    //   822: areturn
    //   823: aload #10
    //   825: ifnull -> 831
    //   828: aload #10
    //   830: athrow
    //   831: new com/blued/android/core/imagecache/LoadDrawableException
    //   834: dup
    //   835: getstatic com/blued/android/core/imagecache/FailReason$FailType.j : Lcom/blued/android/core/imagecache/FailReason$FailType;
    //   838: aconst_null
    //   839: invokespecial <init> : (Lcom/blued/android/core/imagecache/FailReason$FailType;Ljava/lang/Throwable;)V
    //   842: athrow
    //   843: astore_0
    //   844: aload #15
    //   846: ifnull -> 862
    //   849: aload #15
    //   851: invokevirtual close : ()V
    //   854: goto -> 862
    //   857: astore_1
    //   858: aload_1
    //   859: invokevirtual printStackTrace : ()V
    //   862: aload_0
    //   863: athrow
    //   864: new java/lang/Exception
    //   867: dup
    //   868: ldc_w 'unknown'
    //   871: invokespecial <init> : (Ljava/lang/String;)V
    //   874: athrow
    //   875: astore_1
    //   876: aload #10
    //   878: astore #9
    //   880: aload #13
    //   882: astore #12
    //   884: goto -> 682
    // Exception table:
    //   from	to	target	type
    //   230	241	725	java/io/FileNotFoundException
    //   230	241	718	finally
    //   283	288	444	java/io/FileNotFoundException
    //   283	288	843	finally
    //   310	323	615	java/lang/OutOfMemoryError
    //   310	323	541	java/lang/IllegalArgumentException
    //   310	323	454	java/lang/Exception
    //   310	323	444	java/io/FileNotFoundException
    //   310	323	843	finally
    //   358	365	615	java/lang/OutOfMemoryError
    //   358	365	541	java/lang/IllegalArgumentException
    //   358	365	454	java/lang/Exception
    //   358	365	444	java/io/FileNotFoundException
    //   358	365	843	finally
    //   387	396	615	java/lang/OutOfMemoryError
    //   387	396	541	java/lang/IllegalArgumentException
    //   387	396	454	java/lang/Exception
    //   387	396	444	java/io/FileNotFoundException
    //   387	396	843	finally
    //   427	433	875	java/lang/Exception
    //   427	433	615	java/lang/OutOfMemoryError
    //   427	433	541	java/lang/IllegalArgumentException
    //   427	433	444	java/io/FileNotFoundException
    //   427	433	843	finally
    //   465	474	444	java/io/FileNotFoundException
    //   465	474	843	finally
    //   484	493	444	java/io/FileNotFoundException
    //   484	493	843	finally
    //   503	510	444	java/io/FileNotFoundException
    //   503	510	843	finally
    //   520	531	444	java/io/FileNotFoundException
    //   520	531	843	finally
    //   553	558	444	java/io/FileNotFoundException
    //   553	558	843	finally
    //   576	584	444	java/io/FileNotFoundException
    //   576	584	843	finally
    //   594	602	444	java/io/FileNotFoundException
    //   594	602	843	finally
    //   627	636	444	java/io/FileNotFoundException
    //   627	636	843	finally
    //   646	652	444	java/io/FileNotFoundException
    //   646	652	843	finally
    //   666	672	444	java/io/FileNotFoundException
    //   666	672	843	finally
    //   692	697	710	java/io/IOException
    //   737	741	843	finally
    //   764	769	710	java/io/IOException
    //   849	854	857	java/io/IOException
  }
  
  private static Drawable c(String paramString, LoadOptions paramLoadOptions, Handler paramHandler, ImageLoadingListener paramImageLoadingListener) throws Throwable {
    // Byte code:
    //   0: new com/blued/android/core/imagecache/RecyclingUtils$2
    //   3: dup
    //   4: aload_3
    //   5: aload_2
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial <init> : (Lcom/blued/android/core/imagecache/ImageLoadingListener;Landroid/os/Handler;Ljava/lang/String;Lcom/blued/android/core/imagecache/LoadOptions;)V
    //   11: astore_2
    //   12: aload_1
    //   13: invokevirtual a : ()Z
    //   16: ifeq -> 32
    //   19: aload_0
    //   20: invokestatic f : (Ljava/lang/String;)Z
    //   23: ifeq -> 32
    //   26: iconst_1
    //   27: istore #4
    //   29: goto -> 35
    //   32: iconst_0
    //   33: istore #4
    //   35: iload #4
    //   37: ifeq -> 70
    //   40: new java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial <init> : ()V
    //   47: astore_1
    //   48: aload_1
    //   49: aload_0
    //   50: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_1
    //   55: ldc_w '.webp'
    //   58: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_1
    //   63: invokevirtual toString : ()Ljava/lang/String;
    //   66: astore_1
    //   67: goto -> 72
    //   70: aload_0
    //   71: astore_1
    //   72: aload_1
    //   73: aload_2
    //   74: invokestatic a : (Ljava/lang/String;Lcom/blued/android/core/net/BinaryHttpResponseHandler;)V
    //   77: aload_2
    //   78: getfield e : Landroid/graphics/drawable/Drawable;
    //   81: ifnonnull -> 99
    //   84: aload_2
    //   85: getfield f : Ljava/lang/Throwable;
    //   88: ifnull -> 99
    //   91: iload #4
    //   93: ifeq -> 99
    //   96: goto -> 32
    //   99: aload_2
    //   100: getfield e : Landroid/graphics/drawable/Drawable;
    //   103: ifnull -> 111
    //   106: aload_2
    //   107: getfield e : Landroid/graphics/drawable/Drawable;
    //   110: areturn
    //   111: aload_2
    //   112: getfield f : Ljava/lang/Throwable;
    //   115: astore_1
    //   116: aload_1
    //   117: astore_0
    //   118: aload_1
    //   119: ifnonnull -> 134
    //   122: new com/blued/android/core/imagecache/LoadDrawableException
    //   125: dup
    //   126: getstatic com/blued/android/core/imagecache/FailReason$FailType.e : Lcom/blued/android/core/imagecache/FailReason$FailType;
    //   129: aconst_null
    //   130: invokespecial <init> : (Lcom/blued/android/core/imagecache/FailReason$FailType;Ljava/lang/Throwable;)V
    //   133: astore_0
    //   134: aload_0
    //   135: athrow
  }
  
  public static InputStream c(String paramString) throws IOException {
    paramString = Scheme.e.c(paramString);
    return AppInfo.d().getAssets().open(paramString);
  }
  
  private static boolean c(BitmapFactory.Options paramOptions) {
    if (paramOptions.inBitmap != null) {
      paramOptions.inBitmap = null;
      return true;
    } 
    return false;
  }
  
  public static String d(String paramString) {
    File file = AppInfo.d().getExternalFilesDir(null);
    if (file != null) {
      file = new File(file, "img");
      if (file.exists() || file.mkdirs())
        return (new File(file, Md5.a(paramString.toLowerCase().trim()))).getAbsolutePath(); 
    } 
    file = AppInfo.d().getFilesDir();
    if (file != null) {
      file = new File(file, "img");
      if (file.exists() || file.mkdirs())
        return (new File(file, Md5.a(paramString.toLowerCase().trim()))).getAbsolutePath(); 
    } 
    return null;
  }
  
  public static String e(String paramString) {
    File file = AppInfo.d().getExternalFilesDir(null);
    if (file != null) {
      file = new File(file, "img");
      if (file.exists() || file.mkdirs()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("temp_");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("_");
        stringBuilder.append(Md5.a(paramString.toLowerCase().trim()));
        return (new File(file, stringBuilder.toString())).getAbsolutePath();
      } 
    } 
    file = AppInfo.d().getFilesDir();
    if (file != null) {
      file = new File(file, "img");
      if (file.exists() || file.mkdirs()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("temp_");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("_");
        stringBuilder.append(Md5.a(paramString.toLowerCase().trim()));
        return (new File(file, stringBuilder.toString())).getAbsolutePath();
      } 
    } 
    return null;
  }
  
  public static boolean f(String paramString) {
    return true;
  }
  
  public enum CropType {
    a, b, c;
  }
  
  static abstract class ImageBinaryDownloadResponse extends BinaryHttpResponseHandler {
    protected Drawable e = null;
    
    protected Throwable f = null;
    
    private ImageBinaryDownloadResponse() {}
  }
  
  public enum Scheme {
    a("http"),
    b("https"),
    c("file"),
    d("content"),
    e("assets"),
    f("drawable"),
    g("");
    
    private String h;
    
    private String i;
    
    Scheme(String param1String1) {
      this.h = param1String1;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1String1);
      stringBuilder.append("://");
      this.i = stringBuilder.toString();
    }
    
    public static Scheme a(String param1String) {
      if (param1String != null)
        for (Scheme scheme : values()) {
          if (scheme.d(param1String))
            return scheme; 
        }  
      return g;
    }
    
    private boolean d(String param1String) {
      return param1String.startsWith(this.i);
    }
    
    public String b(String param1String) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.i);
      stringBuilder.append(param1String);
      return stringBuilder.toString();
    }
    
    public String c(String param1String) {
      if (d(param1String))
        return param1String.substring(this.i.length()); 
      throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", new Object[] { param1String, this.h }));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\RecyclingUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */