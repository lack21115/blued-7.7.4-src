package com.blued.android.framework.qrcode;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.google.common.base.Charsets;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class ImageReader {
  private SharedPreferences a() {
    return (AppInfo.d() != null) ? AppInfo.d().getSharedPreferences("qrcode_recent_list", 0) : null;
  }
  
  private Bitmap a(String paramString, Rect paramRect) {
    Bitmap bitmap;
    if (TextUtils.isEmpty(paramString))
      return null; 
    if (!(new File(paramString)).exists())
      return null; 
    try {
      Bitmap bitmap1;
      BitmapFactory.Options options = new BitmapFactory.Options();
      options.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, options);
      options.inJustDecodeBounds = false;
      int j = options.outWidth;
      int i = options.outHeight;
      if (paramRect != null) {
        float f;
        int m = paramRect.left * j / 100;
        int n = paramRect.top * i / 100;
        j = (paramRect.right - paramRect.left) * j / 100;
        int k = (paramRect.bottom - paramRect.top) * i / 100;
        i = j;
        if (m + j > options.outWidth)
          i = options.outWidth - m; 
        j = k;
        if (n + k > options.outHeight)
          j = options.outHeight - n; 
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        bitmap1 = BitmapFactory.decodeFile(paramString, options);
        bitmap = Bitmap.createBitmap(bitmap1, m, n, i, j);
        bitmap1.recycle();
        k = Math.max(i, j);
        if (k < 150) {
          f = 2.0F;
        } else if (k > 500) {
          f = 0.5F;
        } else {
          f = 1.0F;
        } 
        if (f != 1.0F)
          return Bitmap.createScaledBitmap(bitmap, (int)(i * f), (int)(j * f), false); 
      } else {
        j = (int)(Math.max(j, i) / 1000.0F);
        i = j;
        if (j <= 0)
          i = 1; 
        options.inSampleSize = i;
        return BitmapFactory.decodeFile((String)bitmap1, options);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
    return bitmap;
  }
  
  private Result a(Bitmap paramBitmap) {
    if (paramBitmap == null)
      return null; 
    try {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      int[] arrayOfInt = new int[i * j];
      paramBitmap.getPixels(arrayOfInt, 0, i, 0, 0, i, j);
      paramBitmap.recycle();
      BinaryBitmap binaryBitmap = new BinaryBitmap((Binarizer)new GlobalHistogramBinarizer((LuminanceSource)new RGBLuminanceSource(i, j, arrayOfInt)));
      QRCodeReader qRCodeReader = new QRCodeReader();
      Vector<BarcodeFormat> vector = new Vector();
      vector.add(BarcodeFormat.f);
      vector.add(BarcodeFormat.l);
      vector.add(BarcodeFormat.a);
      Hashtable<Object, Object> hashtable = new Hashtable<Object, Object>(3);
      hashtable.put(DecodeHintType.c, vector);
      hashtable.put(DecodeHintType.e, "utf-8");
      hashtable.put(DecodeHintType.d, Boolean.valueOf(true));
      return qRCodeReader.a(binaryBitmap, hashtable);
    } catch (NotFoundException notFoundException) {
      notFoundException.printStackTrace();
      return null;
    } catch (ChecksumException checksumException) {
      checksumException.printStackTrace();
      return null;
    } catch (FormatException formatException) {
      formatException.printStackTrace();
      return null;
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } catch (OutOfMemoryError outOfMemoryError) {
      outOfMemoryError.printStackTrace();
      return null;
    } 
  }
  
  private String a(long paramLong) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: new java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial <init> : ()V
    //   10: astore_3
    //   11: aload_3
    //   12: ldc '('
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload_3
    //   19: ldc 'mime_type'
    //   21: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_3
    //   26: ldc '=? or '
    //   28: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_3
    //   33: ldc 'mime_type'
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_3
    //   40: ldc '=?) and '
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_3
    //   47: ldc 'date_added'
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_3
    //   54: ldc ' >= ?'
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: new java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: astore #5
    //   69: aload #5
    //   71: ldc ''
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload #5
    //   79: invokestatic currentTimeMillis : ()J
    //   82: ldc2_w 1000
    //   85: ldiv
    //   86: lload_1
    //   87: lsub
    //   88: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload #5
    //   94: invokevirtual toString : ()Ljava/lang/String;
    //   97: astore #5
    //   99: invokestatic d : ()Landroid/content/Context;
    //   102: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   105: astore #6
    //   107: getstatic android/provider/MediaStore$Images$Media.EXTERNAL_CONTENT_URI : Landroid/net/Uri;
    //   110: astore #7
    //   112: aload_3
    //   113: invokevirtual toString : ()Ljava/lang/String;
    //   116: astore_3
    //   117: aload #6
    //   119: aload #7
    //   121: iconst_2
    //   122: anewarray java/lang/String
    //   125: dup
    //   126: iconst_0
    //   127: ldc_w '_id'
    //   130: aastore
    //   131: dup
    //   132: iconst_1
    //   133: ldc_w '_data'
    //   136: aastore
    //   137: aload_3
    //   138: iconst_3
    //   139: anewarray java/lang/String
    //   142: dup
    //   143: iconst_0
    //   144: ldc_w 'image/jpeg'
    //   147: aastore
    //   148: dup
    //   149: iconst_1
    //   150: ldc_w 'image/png'
    //   153: aastore
    //   154: dup
    //   155: iconst_2
    //   156: aload #5
    //   158: aastore
    //   159: ldc_w 'date_added DESC'
    //   162: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   165: astore_3
    //   166: aload_3
    //   167: ifnull -> 220
    //   170: aload_3
    //   171: astore #4
    //   173: aload_3
    //   174: invokeinterface moveToFirst : ()Z
    //   179: ifeq -> 220
    //   182: aload_3
    //   183: astore #4
    //   185: aload_3
    //   186: aload_3
    //   187: ldc_w '_data'
    //   190: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   195: invokeinterface getString : (I)Ljava/lang/String;
    //   200: astore #5
    //   202: aload_3
    //   203: ifnull -> 212
    //   206: aload_3
    //   207: invokeinterface close : ()V
    //   212: aload #5
    //   214: areturn
    //   215: astore #5
    //   217: goto -> 235
    //   220: aload_3
    //   221: ifnull -> 253
    //   224: goto -> 247
    //   227: astore_3
    //   228: goto -> 256
    //   231: astore #5
    //   233: aconst_null
    //   234: astore_3
    //   235: aload_3
    //   236: astore #4
    //   238: aload #5
    //   240: invokevirtual printStackTrace : ()V
    //   243: aload_3
    //   244: ifnull -> 253
    //   247: aload_3
    //   248: invokeinterface close : ()V
    //   253: aconst_null
    //   254: areturn
    //   255: astore_3
    //   256: aload #4
    //   258: ifnull -> 268
    //   261: aload #4
    //   263: invokeinterface close : ()V
    //   268: aload_3
    //   269: athrow
    // Exception table:
    //   from	to	target	type
    //   3	166	231	java/lang/Exception
    //   3	166	227	finally
    //   173	182	215	java/lang/Exception
    //   173	182	255	finally
    //   185	202	215	java/lang/Exception
    //   185	202	255	finally
    //   238	243	255	finally
  }
  
  private String a(String paramString) {
    String str = paramString;
    try {
      if (Charset.forName("ISO-8859-1").newEncoder().canEncode(paramString))
        return new String(paramString.getBytes(Charsets.b), "GB2312"); 
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  private void a(String paramString, Rect paramRect, OnReadFinishListener paramOnReadFinishListener) {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokespecial a : (Landroid/graphics/Rect;)Z
    //   5: ifeq -> 35
    //   8: aload_0
    //   9: aload_0
    //   10: aload_1
    //   11: aload_2
    //   12: invokespecial a : (Ljava/lang/String;Landroid/graphics/Rect;)Landroid/graphics/Bitmap;
    //   15: invokespecial a : (Landroid/graphics/Bitmap;)Lcom/google/zxing/Result;
    //   18: astore_2
    //   19: aload_2
    //   20: ifnull -> 35
    //   23: aload_0
    //   24: aload_2
    //   25: invokevirtual a : ()Ljava/lang/String;
    //   28: invokespecial a : (Ljava/lang/String;)Ljava/lang/String;
    //   31: astore_2
    //   32: goto -> 37
    //   35: aconst_null
    //   36: astore_2
    //   37: aload_3
    //   38: ifnull -> 59
    //   41: invokestatic n : ()Landroid/os/Handler;
    //   44: new com/blued/android/framework/qrcode/ImageReader$4
    //   47: dup
    //   48: aload_0
    //   49: aload_3
    //   50: aload_1
    //   51: aload_2
    //   52: invokespecial <init> : (Lcom/blued/android/framework/qrcode/ImageReader;Lcom/blued/android/framework/qrcode/ImageReader$OnReadFinishListener;Ljava/lang/String;Ljava/lang/String;)V
    //   55: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   58: pop
    //   59: return
  }
  
  private boolean a(Rect paramRect) {
    if (paramRect != null)
      if (paramRect.left >= 0 && paramRect.top >= 0 && paramRect.right <= 100) {
        if (paramRect.bottom > 100)
          return false; 
        if (paramRect.left >= paramRect.right || paramRect.top >= paramRect.bottom)
          return false; 
      } else {
        return false;
      }  
    return true;
  }
  
  private boolean a(String paramString, long paramLong) {
    boolean bool = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool)
      return false; 
    SharedPreferences sharedPreferences = a();
    if (sharedPreferences == null)
      return false; 
    bool = bool2;
    try {
      ArrayList<String> arrayList = new ArrayList();
      bool = bool2;
      Iterator<Map.Entry> iterator = sharedPreferences.getAll().entrySet().iterator();
      while (true) {
        bool = bool1;
        if (iterator.hasNext()) {
          bool = bool1;
          Map.Entry entry = iterator.next();
          bool = bool1;
          String str = (String)entry.getKey();
          bool = bool1;
          if (!TextUtils.isEmpty(str)) {
            bool = bool1;
            if (System.currentTimeMillis() < Long.parseLong(str) + paramLong * 1000L) {
              bool = bool1;
              String str1 = entry.getValue().toString();
              bool = bool1;
              if (!TextUtils.isEmpty(str1)) {
                bool = bool1;
                if (TextUtils.equals(str1, paramString))
                  bool1 = true; 
              } 
              continue;
            } 
            bool = bool1;
            arrayList.add(str);
          } 
          continue;
        } 
        bool = bool1;
        if (arrayList.size() > 0) {
          bool = bool1;
          SharedPreferences.Editor editor = sharedPreferences.edit();
          bool = bool1;
          Iterator<String> iterator1 = arrayList.iterator();
          while (true) {
            bool = bool1;
            if (iterator1.hasNext()) {
              bool = bool1;
              editor.remove(iterator1.next());
              continue;
            } 
            bool = bool1;
            editor.commit();
            bool = bool1;
            arrayList.clear();
            break;
          } 
        } 
        if (!bool1) {
          bool = bool1;
          SharedPreferences.Editor editor = sharedPreferences.edit();
          bool = bool1;
          editor.putString(String.valueOf(System.currentTimeMillis()), paramString);
          bool = bool1;
          editor.commit();
        } 
        return bool1;
      } 
    } catch (Exception exception) {
      return bool;
    } 
  }
  
  public void a(String paramString, OnReadFinishListener paramOnReadFinishListener) {
    if (paramOnReadFinishListener == null)
      return; 
    ThreadManager.a().a(new ThreadExecutor(this, "ReadImageQRCode", paramString, paramOnReadFinishListener) {
          public void execute() {
            ImageReader.a(this.c, this.a, null, this.b);
          }
        });
  }
  
  public static interface OnReadFinishListener {
    void a(String param1String1, String param1String2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\qrcode\ImageReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */