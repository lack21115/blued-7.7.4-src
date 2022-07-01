package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.a.f;
import com.tencent.open.utils.AsynLoadImgBack;
import com.tencent.open.utils.Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class a {
  public static final int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2) {
    int i = b(paramOptions, paramInt1, paramInt2);
    if (i <= 8) {
      paramInt1 = 1;
      while (true) {
        paramInt2 = paramInt1;
        if (paramInt1 < i) {
          paramInt1 <<= 1;
          continue;
        } 
        break;
      } 
    } else {
      paramInt2 = (i + 7) / 8 * 8;
    } 
    return paramInt2;
  }
  
  private static Bitmap a(Bitmap paramBitmap, int paramInt) {
    Matrix matrix = new Matrix();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (i <= j)
      i = j; 
    float f = paramInt / i;
    matrix.postScale(f, f);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), matrix, true);
  }
  
  public static final Bitmap a(String paramString, int paramInt) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    try {
      BitmapFactory.decodeFile(paramString, options);
    } catch (OutOfMemoryError outOfMemoryError) {
      outOfMemoryError.printStackTrace();
    } 
    int i = options.outWidth;
    int j = options.outHeight;
    if (!options.mCancel && options.outWidth != -1) {
      Bitmap bitmap;
      if (options.outHeight == -1)
        return null; 
      if (i <= j)
        i = j; 
      options.inPreferredConfig = Bitmap.Config.RGB_565;
      if (i > paramInt)
        options.inSampleSize = a(options, -1, paramInt * paramInt); 
      options.inJustDecodeBounds = false;
      try {
        Bitmap bitmap1 = BitmapFactory.decodeFile(paramString, options);
      } catch (OutOfMemoryError outOfMemoryError1) {
        outOfMemoryError1.printStackTrace();
        outOfMemoryError1 = null;
      } 
      if (outOfMemoryError1 == null)
        return null; 
      j = options.outWidth;
      int k = options.outHeight;
      i = k;
      if (j > k)
        i = j; 
      OutOfMemoryError outOfMemoryError2 = outOfMemoryError1;
      if (i > paramInt)
        bitmap = a((Bitmap)outOfMemoryError1, paramInt); 
      return bitmap;
    } 
    return null;
  }
  
  protected static final String a(Bitmap paramBitmap, String paramString1, String paramString2) {
    File file2 = new File(paramString1);
    if (!file2.exists())
      file2.mkdirs(); 
    StringBuffer stringBuffer = new StringBuffer(paramString1);
    stringBuffer.append(paramString2);
    String str = stringBuffer.toString();
    File file1 = new File(str);
    if (file1.exists())
      file1.delete(); 
    if (paramBitmap != null)
      try {
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        paramBitmap.recycle();
        return str;
      } catch (FileNotFoundException fileNotFoundException) {
        fileNotFoundException.printStackTrace();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
    return null;
  }
  
  public static final void a(Context paramContext, String paramString, AsynLoadImgBack paramAsynLoadImgBack) {
    f.b("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage");
    if (TextUtils.isEmpty(paramString)) {
      paramAsynLoadImgBack.saved(1, null);
      return;
    } 
    if (!Util.hasSDCard()) {
      paramAsynLoadImgBack.saved(2, null);
      return;
    } 
    (new Thread(new Runnable(paramString, new Handler(paramContext.getMainLooper(), paramAsynLoadImgBack) {
            public void handleMessage(Message param1Message) {
              int i = param1Message.what;
              if (i != 101) {
                if (i != 102) {
                  super.handleMessage(param1Message);
                  return;
                } 
                i = param1Message.arg1;
                this.a.saved(i, null);
                return;
              } 
              String str = (String)param1Message.obj;
              this.a.saved(0, str);
            }
          }) {
          public void run() {
            Bitmap bitmap = a.a(this.a, 140);
            if (bitmap != null) {
              String str1;
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append(Environment.getExternalStorageDirectory());
              stringBuilder2.append("/tmp/");
              String str2 = stringBuilder2.toString();
              String str3 = Util.encrypt(this.a);
              StringBuilder stringBuilder3 = new StringBuilder();
              stringBuilder3.append("share2qq_temp");
              stringBuilder3.append(str3);
              stringBuilder3.append(".jpg");
              str3 = stringBuilder3.toString();
              if (!a.a(this.a, 140, 140)) {
                f.b("openSDK_LOG.AsynScaleCompressImage", "not out of bound,not compress!");
                str1 = this.a;
              } else {
                f.b("openSDK_LOG.AsynScaleCompressImage", "out of bound,compress!");
                str1 = a.a((Bitmap)str1, str2, str3);
              } 
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("-->destFilePath: ");
              stringBuilder1.append(str1);
              f.b("openSDK_LOG.AsynScaleCompressImage", stringBuilder1.toString());
              if (str1 != null) {
                Message message1 = this.b.obtainMessage(101);
                message1.obj = str1;
                this.b.sendMessage(message1);
                return;
              } 
            } 
            Message message = this.b.obtainMessage(102);
            message.arg1 = 3;
            this.b.sendMessage(message);
          }
        })).start();
  }
  
  public static final void a(Context paramContext, ArrayList<String> paramArrayList, AsynLoadImgBack paramAsynLoadImgBack) {
    f.b("openSDK_LOG.AsynScaleCompressImage", "batchScaleCompressImage");
    if (paramArrayList == null) {
      paramAsynLoadImgBack.saved(1, null);
      return;
    } 
    (new Thread(new Runnable(paramArrayList, new Handler(paramContext.getMainLooper(), paramAsynLoadImgBack) {
            public void handleMessage(Message param1Message) {
              if (param1Message.what != 101) {
                super.handleMessage(param1Message);
                return;
              } 
              ArrayList arrayList = param1Message.getData().getStringArrayList("images");
              this.a.batchSaved(0, arrayList);
            }
          }) {
          public void run() {
            for (int i = 0; i < this.a.size(); i++) {
              String str = this.a.get(i);
              if (!Util.isValidUrl(str) && Util.fileExists(str)) {
                Bitmap bitmap = a.a(str, 10000);
                if (bitmap != null) {
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append(Environment.getExternalStorageDirectory());
                  stringBuilder1.append("/tmp/");
                  String str1 = stringBuilder1.toString();
                  String str2 = Util.encrypt(str);
                  StringBuilder stringBuilder2 = new StringBuilder();
                  stringBuilder2.append("share2qzone_temp");
                  stringBuilder2.append(str2);
                  stringBuilder2.append(".jpg");
                  str2 = stringBuilder2.toString();
                  if (!a.a(str, 640, 10000)) {
                    f.b("openSDK_LOG.AsynScaleCompressImage", "not out of bound,not compress!");
                  } else {
                    f.b("openSDK_LOG.AsynScaleCompressImage", "out of bound, compress!");
                    str = a.a(bitmap, str1, str2);
                  } 
                  if (str != null)
                    this.a.set(i, str); 
                } 
              } 
            } 
            Message message = this.b.obtainMessage(101);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("images", this.a);
            message.setData(bundle);
            this.b.sendMessage(message);
          }
        })).start();
  }
  
  private static int b(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2) {
    int i;
    int j;
    double d1 = paramOptions.outWidth;
    double d2 = paramOptions.outHeight;
    if (paramInt2 == -1) {
      i = 1;
    } else {
      i = (int)Math.ceil(Math.sqrt(d1 * d2 / paramInt2));
    } 
    if (paramInt1 == -1) {
      j = 128;
    } else {
      double d = paramInt1;
      j = (int)Math.min(Math.floor(d1 / d), Math.floor(d2 / d));
    } 
    return (j < i) ? i : ((paramInt2 == -1 && paramInt1 == -1) ? 1 : ((paramInt1 == -1) ? i : j));
  }
  
  private static final boolean b(String paramString, int paramInt1, int paramInt2) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    try {
      BitmapFactory.decodeFile(paramString, options);
    } catch (OutOfMemoryError outOfMemoryError) {
      outOfMemoryError.printStackTrace();
    } 
    int i = options.outWidth;
    int j = options.outHeight;
    if (!options.mCancel && options.outWidth != -1) {
      int k;
      if (options.outHeight == -1)
        return false; 
      if (i > j) {
        k = i;
      } else {
        k = j;
      } 
      if (i >= j)
        i = j; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("longSide=");
      stringBuilder.append(k);
      stringBuilder.append("shortSide=");
      stringBuilder.append(i);
      f.b("openSDK_LOG.AsynScaleCompressImage", stringBuilder.toString());
      options.inPreferredConfig = Bitmap.Config.RGB_565;
      return (k <= paramInt2) ? ((i > paramInt1)) : true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\share\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */