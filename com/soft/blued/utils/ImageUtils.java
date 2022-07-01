package com.soft.blued.utils;

import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import java.io.IOException;

public class ImageUtils {
  public static int[] a(int paramInt1, int paramInt2) {
    if (paramInt1 != 0 && paramInt2 != 0) {
      if (paramInt1 > paramInt2) {
        int i = AppInfo.l;
        paramInt2 = AppInfo.l * paramInt1 / paramInt2;
        paramInt1 = i;
      } else {
        int i = AppInfo.l;
        paramInt1 = AppInfo.l * paramInt2 / paramInt1;
        paramInt2 = i;
      } 
    } else {
      paramInt2 = 0;
      paramInt1 = 0;
    } 
    return new int[] { paramInt2, paramInt1 };
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 > paramInt2) {
      paramInt1 = paramInt1 * paramInt3 / paramInt2;
      paramInt2 = paramInt3;
    } else {
      paramInt2 = paramInt2 * paramInt3 / paramInt1;
      paramInt1 = paramInt3;
    } 
    return new int[] { paramInt1, paramInt2 };
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    int[] arrayOfInt = new int[2];
    if (paramInt1 == 0 || paramInt2 == 0) {
      arrayOfInt[0] = paramInt5;
      arrayOfInt[1] = paramInt6;
      return arrayOfInt;
    } 
    if (paramInt1 == paramInt2) {
      arrayOfInt[0] = paramInt5;
      arrayOfInt[1] = paramInt5;
      return arrayOfInt;
    } 
    float f4 = paramInt1 / paramInt2;
    if (paramInt1 > paramInt2) {
      float f6 = paramInt3 / f4;
      float f7 = paramInt4;
      float f5 = f6;
      if (f6 > f7)
        f5 = f7; 
      f7 = paramInt6;
      f6 = f5;
      if (f5 < f7)
        f6 = f7; 
      arrayOfInt[0] = paramInt3;
      arrayOfInt[1] = (int)f6;
      return arrayOfInt;
    } 
    float f2 = paramInt4 * f4;
    float f3 = paramInt3;
    float f1 = f2;
    if (f2 > f3) {
      paramInt4 = (int)(f3 / f4);
      f1 = f3;
    } 
    f3 = paramInt5;
    f2 = f1;
    if (f1 < f3)
      f2 = f3; 
    arrayOfInt[0] = (int)f2;
    arrayOfInt[1] = paramInt4;
    return arrayOfInt;
  }
  
  public static String[] a(String paramString) {
    if (paramString == null)
      return new String[] { "0", "0" }; 
    String[] arrayOfString = new String[2];
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, options);
    arrayOfString[0] = String.valueOf(options.outWidth);
    arrayOfString[1] = String.valueOf(options.outHeight);
    Logger.a("ddrb", new Object[] { "outWidth = ", arrayOfString[0] });
    Logger.a("ddrb", new Object[] { "outHeight = ", arrayOfString[1] });
    return arrayOfString;
  }
  
  public static int[] b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    int[] arrayOfInt = new int[2];
    if (paramInt1 == 0 || paramInt2 == 0) {
      arrayOfInt[0] = paramInt5;
      arrayOfInt[1] = paramInt6;
      return arrayOfInt;
    } 
    if (paramInt1 == paramInt2) {
      arrayOfInt[0] = paramInt5;
      arrayOfInt[1] = paramInt6;
      return arrayOfInt;
    } 
    float f = paramInt1 / paramInt2;
    if (paramInt1 > paramInt2) {
      f = paramInt3 / f;
      arrayOfInt[0] = paramInt3;
      arrayOfInt[1] = (int)f;
      return arrayOfInt;
    } 
    arrayOfInt[0] = (int)(f * paramInt4);
    arrayOfInt[1] = paramInt4;
    return arrayOfInt;
  }
  
  public static int[] b(String paramString) {
    if (paramString == null)
      return new int[] { 0, 0 }; 
    int[] arrayOfInt = new int[2];
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inInputShareable = true;
    options.inPurgeable = true;
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, options);
    arrayOfInt[0] = DensityUtils.b(AppInfo.d(), options.outWidth);
    arrayOfInt[1] = DensityUtils.b(AppInfo.d(), options.outHeight);
    Logger.a("ddrb", new Object[] { "outWidth = ", Integer.valueOf(arrayOfInt[0]) });
    Logger.a("ddrb", new Object[] { "outHeight = ", Integer.valueOf(arrayOfInt[1]) });
    return arrayOfInt;
  }
  
  public static int c(String paramString) {
    try {
      if (!StringUtils.e(paramString)) {
        int i = (new ExifInterface(paramString)).getAttributeInt("Orientation", 1);
        return (i != 3) ? ((i != 6) ? ((i != 8) ? 0 : 270) : 90) : 180;
      } 
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    return 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\ImageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */