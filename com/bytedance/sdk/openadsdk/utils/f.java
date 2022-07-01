package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class f {
  public static Bitmap a(Bitmap paramBitmap, int paramInt) {
    Bitmap bitmap = paramBitmap;
    if (paramBitmap != null) {
      if (paramBitmap.getRowBytes() * paramBitmap.getHeight() < paramInt)
        return paramBitmap; 
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
      for (int i = 90; (byteArrayOutputStream.toByteArray()).length > paramInt; i -= 10) {
        byteArrayOutputStream.reset();
        paramBitmap.compress(Bitmap.CompressFormat.PNG, i, byteArrayOutputStream);
      } 
      bitmap = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
    } 
    return bitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2) {
    Bitmap bitmap;
    if (paramBitmap == null)
      return null; 
    if (paramBitmap.isRecycled())
      return paramBitmap; 
    int j = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(j);
    stringBuilder2.append(" originWidth");
    Log.i("BitmapUtils", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(i);
    stringBuilder2.append(" originHeight");
    Log.i("BitmapUtils", stringBuilder2.toString());
    if (j < paramInt1 && i < paramInt2)
      return paramBitmap; 
    if (j > paramInt1) {
      double d = j * 1.0D / paramInt1;
      int k = (int)Math.floor(i / d);
      i = k;
      bitmap = paramBitmap;
      j = paramInt1;
      if (paramInt1 > 0) {
        i = k;
        bitmap = paramBitmap;
        j = paramInt1;
        if (k > 0) {
          i = k;
          bitmap = paramBitmap;
          j = paramInt1;
          if (!paramBitmap.isRecycled()) {
            bitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt1, k, false);
            i = k;
            j = paramInt1;
          } 
        } 
      } 
    } else {
      bitmap = paramBitmap;
    } 
    if (i > paramInt2) {
      paramBitmap = bitmap;
      paramInt1 = paramInt2;
      if (j > 0) {
        paramBitmap = bitmap;
        paramInt1 = paramInt2;
        if (paramInt2 > 0) {
          paramBitmap = bitmap;
          paramInt1 = paramInt2;
          if (!bitmap.isRecycled()) {
            paramBitmap = Bitmap.createBitmap(bitmap, 0, 0, j, paramInt2);
            paramInt1 = paramInt2;
          } 
        } 
      } 
    } else {
      paramInt1 = i;
      paramBitmap = bitmap;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(j);
    stringBuilder1.append(" width");
    Log.i("BitmapUtils", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt1);
    stringBuilder1.append(" height");
    Log.i("BitmapUtils", stringBuilder1.toString());
    return paramBitmap;
  }
  
  public static Bitmap a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    try {
      return BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
    } finally {
      paramString = null;
    } 
  }
  
  public static String a(Bitmap paramBitmap) {
    String str1;
    String str2 = null;
    if (paramBitmap == null)
      return null; 
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    } finally {
      paramBitmap = null;
    } 
    if (paramBitmap != null) {
      str1 = str2;
    } else {
      return null;
    } 
    try {
      paramBitmap.flush();
      return str1;
    } finally {
      paramBitmap = null;
    } 
  }
  
  public static byte[] b(Bitmap paramBitmap) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(paramBitmap.getByteCount());
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
    return byteArrayOutputStream.toByteArray();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */