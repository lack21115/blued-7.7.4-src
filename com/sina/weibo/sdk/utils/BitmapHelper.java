package com.sina.weibo.sdk.utils;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class BitmapHelper {
  public static int getSampleSizeAutoFitToScreen(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (paramInt2 == 0 || paramInt1 == 0) ? 1 : Math.min(Math.max(paramInt3 / paramInt1, paramInt4 / paramInt2), Math.max(paramInt4 / paramInt1, paramInt3 / paramInt2));
  }
  
  public static int getSampleSizeOfNotTooLarge(Rect paramRect) {
    double d = paramRect.width() * paramRect.height() * 2.0D / 5242880.0D;
    return (d >= 1.0D) ? (int)d : 1;
  }
  
  public static boolean makesureSizeNotTooLarge(Rect paramRect) {
    return !(paramRect.width() * paramRect.height() * 2 > 5242880);
  }
  
  public static boolean verifyBitmap(InputStream paramInputStream) {
    if (paramInputStream == null)
      return false; 
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    if (!(paramInputStream instanceof BufferedInputStream))
      paramInputStream = new BufferedInputStream(paramInputStream); 
    BitmapFactory.decodeStream(paramInputStream, null, options);
    try {
      paramInputStream.close();
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    return (options.outHeight > 0 && options.outWidth > 0);
  }
  
  public static boolean verifyBitmap(String paramString) {
    try {
      return verifyBitmap(new FileInputStream(paramString));
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
      return false;
    } 
  }
  
  public static boolean verifyBitmap(byte[] paramArrayOfbyte) {
    return verifyBitmap(new ByteArrayInputStream(paramArrayOfbyte));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sd\\utils\BitmapHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */