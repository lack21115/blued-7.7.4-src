package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtils {
  private static void delete(File paramFile) {
    if (paramFile != null && paramFile.exists()) {
      if (paramFile.delete())
        return; 
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramFile.getAbsolutePath()));
      stringBuilder.append(" doesn't be deleted!");
      throw new RuntimeException(stringBuilder.toString());
    } 
  }
  
  private static boolean deleteDependon(String paramString) {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2)
      return false; 
    File file = new File(paramString);
    int i = 1;
    while (!bool1 && i <= 5 && file.isFile()) {
      if (!file.exists())
        return bool1; 
      bool2 = file.delete();
      bool1 = bool2;
      if (!bool2) {
        i++;
        bool1 = bool2;
      } 
    } 
    return bool1;
  }
  
  private static boolean isFileExisted(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : ((new File(paramString)).exists());
  }
  
  private static boolean isParentExist(File paramFile) {
    if (paramFile == null)
      return false; 
    File file = paramFile.getParentFile();
    return (file != null && !file.exists()) ? (!(!paramFile.exists() && !paramFile.mkdirs())) : false;
  }
  
  public static boolean isWifi(Context paramContext) {
    NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (networkInfo != null && networkInfo.getType() == 1);
  }
  
  private static void makesureFileExist(String paramString) {
    if (paramString == null)
      return; 
    File file = new File(paramString);
    if (!file.exists() && isParentExist(file)) {
      if (file.exists())
        delete(file); 
      try {
        file.createNewFile();
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
    } 
  }
  
  private static void revitionImageSize(String paramString, int paramInt1, int paramInt2) throws IOException {
    if (paramInt1 > 0) {
      if (!isFileExisted(paramString)) {
        String str = paramString;
        if (paramString == null)
          str = "null"; 
        throw new FileNotFoundException(str);
      } 
      if (BitmapHelper.verifyBitmap(paramString)) {
        FileInputStream fileInputStream = new FileInputStream(paramString);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(fileInputStream, null, options);
        try {
          fileInputStream.close();
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        for (int i = 0;; i++) {
          if (options.outWidth >> i <= paramInt1 && options.outHeight >> i <= paramInt1) {
            options.inSampleSize = (int)Math.pow(2.0D, i);
            options.inJustDecodeBounds = false;
            Bitmap bitmap = safeDecodeBimtapFile(paramString, options);
            if (bitmap != null) {
              deleteDependon(paramString);
              makesureFileExist(paramString);
              FileOutputStream fileOutputStream = new FileOutputStream(paramString);
              if (options.outMimeType != null && options.outMimeType.contains("png")) {
                bitmap.compress(Bitmap.CompressFormat.PNG, paramInt2, fileOutputStream);
              } else {
                bitmap.compress(Bitmap.CompressFormat.JPEG, paramInt2, fileOutputStream);
              } 
              try {
                fileOutputStream.close();
              } catch (Exception exception) {
                exception.printStackTrace();
              } 
              bitmap.recycle();
              return;
            } 
            throw new IOException("Bitmap decode error!");
          } 
        } 
      } 
      throw new IOException("");
    } 
    throw new IllegalArgumentException("size must be greater than 0!");
  }
  
  private static void revitionImageSizeHD(String paramString, int paramInt1, int paramInt2) throws IOException {
    if (paramInt1 > 0) {
      if (!isFileExisted(paramString)) {
        String str = paramString;
        if (paramString == null)
          str = "null"; 
        throw new FileNotFoundException(str);
      } 
      if (BitmapHelper.verifyBitmap(paramString)) {
        int j = paramInt1 * 2;
        FileInputStream fileInputStream = new FileInputStream(paramString);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(fileInputStream, null, options);
        try {
          fileInputStream.close();
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        for (int i = 0;; i++) {
          if (options.outWidth >> i <= j && options.outHeight >> i <= j) {
            options.inSampleSize = (int)Math.pow(2.0D, i);
            options.inJustDecodeBounds = false;
            Bitmap bitmap = safeDecodeBimtapFile(paramString, options);
            if (bitmap != null) {
              deleteDependon(paramString);
              makesureFileExist(paramString);
              if (bitmap.getWidth() > bitmap.getHeight()) {
                i = bitmap.getWidth();
              } else {
                i = bitmap.getHeight();
              } 
              float f = paramInt1 / i;
              Bitmap bitmap1 = bitmap;
              if (f < 1.0F) {
                while (true) {
                  try {
                    bitmap1 = Bitmap.createBitmap((int)(bitmap.getWidth() * f), (int)(bitmap.getHeight() * f), Bitmap.Config.ARGB_8888);
                    if (bitmap1 == null)
                      bitmap.recycle(); 
                    Canvas canvas = new Canvas(bitmap1);
                    Matrix matrix = new Matrix();
                    matrix.setScale(f, f);
                    canvas.drawBitmap(bitmap, matrix, new Paint());
                    bitmap.recycle();
                    FileOutputStream fileOutputStream = new FileOutputStream(paramString);
                    if (options.outMimeType != null && options.outMimeType.contains("png")) {
                      bitmap1.compress(Bitmap.CompressFormat.PNG, paramInt2, fileOutputStream);
                    } else {
                      bitmap1.compress(Bitmap.CompressFormat.JPEG, paramInt2, fileOutputStream);
                    } 
                    try {
                      fileOutputStream.close();
                    } catch (Exception exception) {
                      exception.printStackTrace();
                    } 
                    bitmap1.recycle();
                    return;
                  } catch (OutOfMemoryError outOfMemoryError) {
                    System.gc();
                    f = (float)(f * 0.8D);
                  } 
                } 
                break;
              } 
              continue;
            } 
            throw new IOException("Bitmap decode error!");
          } 
        } 
      } 
      throw new IOException("");
    } 
    throw new IllegalArgumentException("size must be greater than 0!");
  }
  
  public static boolean revitionPostImageSize(Context paramContext, String paramString) {
    try {
      if (NetworkHelper.isWifiValid(paramContext)) {
        revitionImageSizeHD(paramString, 1600, 75);
      } else {
        revitionImageSize(paramString, 1024, 75);
      } 
      return true;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return false;
    } 
  }
  
  private static Bitmap safeDecodeBimtapFile(String paramString, BitmapFactory.Options paramOptions) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 22
    //   4: new android/graphics/BitmapFactory$Options
    //   7: dup
    //   8: invokespecial <init> : ()V
    //   11: astore #5
    //   13: aload #5
    //   15: iconst_1
    //   16: putfield inSampleSize : I
    //   19: goto -> 25
    //   22: aload_1
    //   23: astore #5
    //   25: iconst_0
    //   26: istore_2
    //   27: aconst_null
    //   28: astore #4
    //   30: aload #4
    //   32: astore_3
    //   33: iload_2
    //   34: iconst_5
    //   35: if_icmplt -> 40
    //   38: aload_3
    //   39: areturn
    //   40: aload_3
    //   41: astore #6
    //   43: new java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: invokespecial <init> : (Ljava/lang/String;)V
    //   51: astore #7
    //   53: aload_3
    //   54: astore #4
    //   56: aload_3
    //   57: astore #6
    //   59: aload #7
    //   61: aconst_null
    //   62: aload_1
    //   63: invokestatic decodeStream : (Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   66: astore_3
    //   67: aload_3
    //   68: astore #4
    //   70: aload_3
    //   71: astore #6
    //   73: aload #7
    //   75: invokevirtual close : ()V
    //   78: aload_3
    //   79: areturn
    //   80: astore #8
    //   82: aload_3
    //   83: astore #4
    //   85: aload_3
    //   86: astore #6
    //   88: aload #8
    //   90: invokevirtual printStackTrace : ()V
    //   93: aload_3
    //   94: areturn
    //   95: astore #6
    //   97: aload #4
    //   99: astore_3
    //   100: aload #7
    //   102: astore #4
    //   104: goto -> 109
    //   107: astore #6
    //   109: aload #6
    //   111: invokevirtual printStackTrace : ()V
    //   114: aload #5
    //   116: aload #5
    //   118: getfield inSampleSize : I
    //   121: iconst_2
    //   122: imul
    //   123: putfield inSampleSize : I
    //   126: aload #4
    //   128: invokevirtual close : ()V
    //   131: goto -> 141
    //   134: astore #6
    //   136: aload #6
    //   138: invokevirtual printStackTrace : ()V
    //   141: iload_2
    //   142: iconst_1
    //   143: iadd
    //   144: istore_2
    //   145: goto -> 33
    //   148: astore_0
    //   149: aload #6
    //   151: areturn
    // Exception table:
    //   from	to	target	type
    //   43	53	107	java/lang/OutOfMemoryError
    //   43	53	148	java/io/FileNotFoundException
    //   59	67	95	java/lang/OutOfMemoryError
    //   59	67	148	java/io/FileNotFoundException
    //   73	78	80	java/io/IOException
    //   73	78	95	java/lang/OutOfMemoryError
    //   73	78	148	java/io/FileNotFoundException
    //   88	93	95	java/lang/OutOfMemoryError
    //   88	93	148	java/io/FileNotFoundException
    //   126	131	134	java/io/IOException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sd\\utils\ImageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */