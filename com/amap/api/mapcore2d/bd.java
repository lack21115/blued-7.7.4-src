package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

class bd {
  private static int a(byte[] paramArrayOfbyte, int paramInt) {
    byte b1 = paramArrayOfbyte[paramInt + 0];
    byte b2 = paramArrayOfbyte[paramInt + 1];
    byte b3 = paramArrayOfbyte[paramInt + 2];
    return (paramArrayOfbyte[paramInt + 3] & 0xFF) << 24 | (b2 & 0xFF) << 8 | b1 & 0xFF | (b3 & 0xFF) << 16;
  }
  
  private static Bitmap a(InputStream paramInputStream) throws Exception {
    try {
      Bitmap bitmap = BitmapFactory.decodeStream(paramInputStream);
      byte[] arrayOfByte = a(bitmap);
      if (arrayOfByte == null)
        return bitmap; 
      return (Bitmap)field;
    } finally {
      paramInputStream = null;
    } 
  }
  
  public static Drawable a(Context paramContext, String paramString) throws Exception {
    Bitmap bitmap = b(paramContext, paramString);
    if (bitmap.getNinePatchChunk() == null)
      return (Drawable)new BitmapDrawable(bitmap); 
    Rect rect = new Rect();
    a(bitmap.getNinePatchChunk(), rect);
    return (Drawable)new NinePatchDrawable(paramContext.getResources(), bitmap, bitmap.getNinePatchChunk(), rect, null);
  }
  
  private static void a(Bitmap paramBitmap, byte[] paramArrayOfbyte) {
    int[] arrayOfInt = new int[paramBitmap.getWidth() - 2];
    paramBitmap.getPixels(arrayOfInt, 0, arrayOfInt.length, 1, paramBitmap.getHeight() - 1, arrayOfInt.length, 1);
    boolean bool = false;
    int i;
    for (i = 0; i < arrayOfInt.length; i++) {
      if (-16777216 == arrayOfInt[i]) {
        a(paramArrayOfbyte, 12, i);
        break;
      } 
    } 
    for (i = arrayOfInt.length - 1; i >= 0; i--) {
      if (-16777216 == arrayOfInt[i]) {
        a(paramArrayOfbyte, 16, arrayOfInt.length - i - 2);
        break;
      } 
    } 
    arrayOfInt = new int[paramBitmap.getHeight() - 2];
    paramBitmap.getPixels(arrayOfInt, 0, 1, paramBitmap.getWidth() - 1, 0, 1, arrayOfInt.length);
    for (i = bool; i < arrayOfInt.length; i++) {
      if (-16777216 == arrayOfInt[i]) {
        a(paramArrayOfbyte, 20, i);
        break;
      } 
    } 
    for (i = arrayOfInt.length - 1; i >= 0; i--) {
      if (-16777216 == arrayOfInt[i]) {
        a(paramArrayOfbyte, 24, arrayOfInt.length - i - 2);
        return;
      } 
    } 
  }
  
  private static void a(OutputStream paramOutputStream, int paramInt) throws IOException {
    paramOutputStream.write(paramInt >> 0 & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    paramOutputStream.write(paramInt >> 16 & 0xFF);
    paramOutputStream.write(paramInt >> 24 & 0xFF);
  }
  
  private static void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    paramArrayOfbyte[paramInt1 + 0] = (byte)(paramInt2 >> 0);
    paramArrayOfbyte[paramInt1 + 1] = (byte)(paramInt2 >> 8);
    paramArrayOfbyte[paramInt1 + 2] = (byte)(paramInt2 >> 16);
    paramArrayOfbyte[paramInt1 + 3] = (byte)(paramInt2 >> 24);
  }
  
  private static void a(byte[] paramArrayOfbyte, Rect paramRect) {
    paramRect.left = a(paramArrayOfbyte, 12);
    paramRect.right = a(paramArrayOfbyte, 16);
    paramRect.top = a(paramArrayOfbyte, 20);
    paramRect.bottom = a(paramArrayOfbyte, 24);
  }
  
  private static byte[] a(Bitmap paramBitmap) throws IOException {
    int j;
    ByteArrayOutputStream byteArrayOutputStream;
    try {
      j = paramBitmap.getWidth();
      i3 = paramBitmap.getHeight();
      byteArrayOutputStream = new ByteArrayOutputStream();
      int i5;
      for (i5 = 0; i5 < 32; i5++)
        byteArrayOutputStream.write(0); 
      i5 = j - 2;
      int[] arrayOfInt1 = new int[i5];
      paramBitmap.getPixels(arrayOfInt1, 0, j, 1, 0, i5, 1);
      if (arrayOfInt1[0] == -16777216) {
        k = 1;
      } else {
        k = 0;
      } 
      if (arrayOfInt1[arrayOfInt1.length - 1] == -16777216) {
        m = 1;
      } else {
        m = 0;
      } 
      int i7 = arrayOfInt1.length;
      j = 0;
      int i6 = 0;
    } finally {
      paramBitmap = null;
    } 
    int n = j + 1;
    int i = n;
    if (k)
      i = n - 1; 
    int k = i;
    if (m)
      k = i - 1; 
    i = i3 - 2;
    int[] arrayOfInt = new int[i];
    paramBitmap.getPixels(arrayOfInt, 0, 1, 0, 1, 1, i);
    if (arrayOfInt[0] == -16777216) {
      m = 1;
    } else {
      m = 0;
    } 
    if (arrayOfInt[arrayOfInt.length - 1] == -16777216) {
      n = 1;
    } else {
      n = 0;
    } 
    int i4 = arrayOfInt.length;
    int i1 = 0;
    int i3 = 0;
    for (i = 0;; i = i6) {
      int i5;
      int i6;
      if (i1 < i4) {
        i5 = i3;
        i6 = i;
        if (i3 != arrayOfInt[i1]) {
          i6 = i + 1;
          a(byteArrayOutputStream, i1);
          i5 = arrayOfInt[i1];
        } 
      } else {
        i1 = i;
        if (n != 0) {
          i1 = i + 1;
          a(byteArrayOutputStream, arrayOfInt.length);
        } 
        break;
      } 
      i1++;
      i3 = i5;
    } 
    int i2 = i1 + 1;
    i = i2;
    if (m)
      i = i2 - 1; 
    int m = i;
    if (n != 0)
      m = i - 1; 
    i = 0;
    while (true) {
      n = k * m;
      if (i < n) {
        a(byteArrayOutputStream, 1);
        i++;
        continue;
      } 
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      arrayOfByte[0] = 1;
      arrayOfByte[1] = (byte)j;
      arrayOfByte[2] = (byte)i1;
      arrayOfByte[3] = (byte)n;
      a(paramBitmap, arrayOfByte);
      return arrayOfByte;
    } 
  }
  
  private static Bitmap b(Context paramContext, String paramString) throws Exception {
    InputStream inputStream = paramContext.getAssets().open(paramString);
    Bitmap bitmap = a(inputStream);
    inputStream.close();
    return bitmap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */