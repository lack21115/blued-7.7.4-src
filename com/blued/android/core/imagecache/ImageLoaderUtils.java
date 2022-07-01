package com.blued.android.core.imagecache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.blued.android.core.AppInfo;
import java.io.IOException;

public class ImageLoaderUtils {
  public static boolean a = false;
  
  public static String b;
  
  public static String c;
  
  public static int a() {
    return (AppInfo.l > 0) ? (AppInfo.l * 2) : 2048;
  }
  
  public static int a(int paramInt1, int paramInt2, String paramString) {
    byte b = 1;
    int i = b;
    if (paramInt1 > 0) {
      i = b;
      if (paramInt2 > 0) {
        i = b;
        if (!TextUtils.isEmpty(paramString)) {
          int j = a(paramString);
          i = b(paramString);
          if (paramInt2 > i && i > 0) {
            paramInt2 = (int)(paramInt2 / i);
          } else {
            paramInt2 = 1;
          } 
          i = b;
          if (paramInt1 > j) {
            i = b;
            if (j > 0)
              i = Math.min((int)(paramInt1 / j), paramInt2); 
          } 
        } 
      } 
    } 
    return i;
  }
  
  public static int a(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      int i = paramString.indexOf('*');
      if (i > 0)
        return Integer.parseInt(paramString.substring(0, i)); 
    } 
    return 0;
  }
  
  public static Bitmap a(String paramString, Bitmap paramBitmap) {
    int i;
    int k;
    String str = null;
    if (paramBitmap == null)
      return null; 
    if (TextUtils.isEmpty(paramString))
      return paramBitmap; 
    try {
      Matrix matrix;
      Bitmap bitmap1;
      Bitmap bitmap2;
      int i2 = (new ExifInterface(paramString)).getAttributeInt("Orientation", 0);
      k = paramBitmap.getWidth();
      i = paramBitmap.getHeight();
      int i3 = k >> 1;
      int i4 = i >> 1;
      paramString = str;
      int n = k;
      int i1 = i;
      switch (i2) {
        case 8:
          matrix = new Matrix();
          matrix.postRotate(270.0F, i3, i4);
          matrix.postTranslate((i4 - i3), (i3 - i4));
          break;
        case 6:
          matrix = new Matrix();
          matrix.postRotate(90.0F, i3, i4);
          matrix.postTranslate((i4 - i3), (i3 - i4));
          break;
        case 5:
          matrix = new Matrix();
          matrix.setTranslate(k, i);
          matrix.setScale(-1.0F, -1.0F);
          n = k;
          i1 = i;
        case 4:
          matrix = new Matrix();
          matrix.setTranslate(0.0F, i);
          matrix.setScale(1.0F, -1.0F);
          n = k;
          i1 = i;
        case 3:
          matrix = new Matrix();
          matrix.setRotate(180.0F, i3, i4);
          n = k;
          i1 = i;
        case 2:
          matrix = new Matrix();
          matrix.setTranslate(k, 0.0F);
          matrix.setScale(-1.0F, 1.0F);
          i1 = i;
          n = k;
        case 7:
          if (matrix != null && !matrix.isIdentity()) {
            bitmap2 = Bitmap.createBitmap(n, i1, paramBitmap.getConfig());
            (new Canvas(bitmap2)).drawBitmap(paramBitmap, matrix, new Paint());
            paramBitmap.recycle();
            return bitmap2;
          } 
          return paramBitmap;
        default:
          bitmap1 = bitmap2;
          n = k;
          i1 = i;
      } 
    } catch (IOException iOException) {
      return paramBitmap;
    } 
    int j = i;
    int m = k;
  }
  
  public static BitmapFactory.Options a(BitmapFactory.Options paramOptions, boolean paramBoolean) {
    BitmapFactory.Options options = paramOptions;
    if (paramOptions == null)
      options = new BitmapFactory.Options(); 
    options.inJustDecodeBounds = false;
    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    options.inDither = false;
    if (!paramBoolean) {
      options.inPurgeable = true;
      options.inInputShareable = true;
    } 
    options.inSampleSize = 1;
    return options;
  }
  
  public static String a(int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(paramInt1);
    stringBuilder.append('*');
    stringBuilder.append(paramInt2);
    return stringBuilder.toString();
  }
  
  public static int b(int paramInt1, int paramInt2, String paramString) {
    int j;
    int i = a(paramInt1, paramInt2, paramString);
    int k = a();
    while (true) {
      j = i;
      if (paramInt1 / i > k) {
        i *= 2;
        continue;
      } 
      break;
    } 
    while (paramInt2 / j > k)
      j *= 2; 
    return j;
  }
  
  public static int b(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      int i = paramString.indexOf('*');
      if (i >= 0 && i < paramString.length())
        return Integer.parseInt(paramString.substring(i + 1)); 
    } 
    return 0;
  }
  
  public static String b() {
    if (TextUtils.isEmpty(b))
      if (AppInfo.l > 0 && AppInfo.m > 0) {
        b = a(AppInfo.l, AppInfo.m);
      } else {
        DisplayMetrics displayMetrics = AppInfo.d().getResources().getDisplayMetrics();
        b = a(displayMetrics.widthPixels, displayMetrics.heightPixels);
      }  
    return b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\ImageLoaderUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */