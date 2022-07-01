package com.blued.android.framework.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ImageUtils {
  public static void a(Bitmap paramBitmap) {
    a(paramBitmap, 100);
  }
  
  public static void a(Bitmap paramBitmap, int paramInt) {
    if ("mounted".equals(Environment.getExternalStorageState())) {
      File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(file.getAbsolutePath());
      stringBuilder.append(File.separator);
      stringBuilder.append("blued");
      a(paramBitmap, stringBuilder.toString(), paramInt);
    } 
  }
  
  public static void a(Bitmap paramBitmap, String paramString, int paramInt) {
    a(paramBitmap, paramString, paramInt, true);
  }
  
  public static void a(Bitmap paramBitmap, String paramString, int paramInt, boolean paramBoolean) {
    if (paramBitmap == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append(".jpg");
    String str = stringBuilder.toString();
    if ("mounted".equals(Environment.getExternalStorageState())) {
      StringBuilder stringBuilder1;
      String str2 = paramString;
      if (paramString == null) {
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(file.getAbsolutePath());
        stringBuilder3.append(File.separator);
        stringBuilder3.append("blued");
        str2 = stringBuilder3.toString();
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str2);
      stringBuilder2.append(File.separator);
      stringBuilder2.append(str);
      String str1 = stringBuilder2.toString();
      if (Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy()) {
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(Environment.DIRECTORY_PICTURES);
        stringBuilder3.append("/blued");
        a(paramBitmap, str, stringBuilder3.toString(), paramInt, false);
        if (paramBoolean) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(AppInfo.d().getString(R.string.pic_save));
          stringBuilder1.append(str1);
          AppMethods.a(stringBuilder1.toString());
          return;
        } 
      } else {
        b((Bitmap)stringBuilder1, str1, paramInt, false);
        AppUtils.a(AppInfo.d(), str1, paramBoolean);
      } 
    } 
  }
  
  public static void a(Bitmap paramBitmap, String paramString1, String paramString2, int paramInt, boolean paramBoolean) {
    ContentValues contentValues = new ContentValues();
    contentValues.put("description", "Blued image");
    contentValues.put("_display_name", paramString1);
    contentValues.put("mime_type", "image/jpeg");
    contentValues.put("title", paramString1);
    contentValues.put("relative_path", paramString2);
    ContentResolver contentResolver = AppInfo.d().getContentResolver();
    try {
      Uri uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    } catch (Exception exception1) {
      exception1.printStackTrace();
      exception1 = null;
    } 
    exception2 = exception1;
    if (exception1 == null)
      try {
        Uri uri = contentResolver.insert(MediaStore.Images.Media.INTERNAL_CONTENT_URI, contentValues);
      } catch (Exception exception2) {
        exception2.printStackTrace();
        exception2 = exception1;
      }  
    if (exception2 != null && paramBitmap != null)
      try {
        OutputStream outputStream = contentResolver.openOutputStream((Uri)exception2);
        if (outputStream != null) {
          paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, outputStream);
          outputStream.flush();
          outputStream.close();
        } 
        if (paramBoolean)
          try {
            paramBitmap.recycle();
            return;
          } catch (Exception exception) {
            exception.printStackTrace();
            return;
          }  
      } catch (Exception exception3) {
        exception3.printStackTrace();
        if (paramBoolean) {
          exception.recycle();
          return;
        } 
      } finally {} 
  }
  
  public static byte[] b(Bitmap paramBitmap, String paramString, int paramInt) {
    return b(paramBitmap, paramString, paramInt, false);
  }
  
  public static byte[] b(Bitmap paramBitmap, String paramString, int paramInt, boolean paramBoolean) {
    FileUtils.a(paramString, true);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, byteArrayOutputStream);
      FileOutputStream fileOutputStream = new FileOutputStream(paramString);
      fileOutputStream.write(byteArrayOutputStream.toByteArray());
      fileOutputStream.flush();
      fileOutputStream.close();
      if (paramBoolean)
        try {
          paramBitmap.recycle();
        } catch (Exception exception) {
          exception.printStackTrace();
        }  
    } catch (Exception exception1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" compressBmpToFile = ");
      stringBuilder.append(exception1.toString());
      Log.v("ddrb", stringBuilder.toString());
      if (paramBoolean)
        exception.recycle(); 
    } finally {}
    return byteArrayOutputStream.toByteArray();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\ImageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */