package com.qiniu.pili.droid.shortvideo.c.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class b {
  public static int a(Context paramContext, String paramString, boolean paramBoolean) {
    StringBuilder stringBuilder;
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    if (arrayOfInt[0] != 0) {
      Bitmap bitmap;
      e e;
      if (paramBoolean) {
        bitmap = a(paramContext, paramString);
      } else {
        bitmap = a(paramString);
      } 
      if (bitmap == null) {
        e = e.w;
        stringBuilder = new StringBuilder();
        stringBuilder.append("bitmap create error, name is : ");
        stringBuilder.append(paramString);
        e.e("OpenGlUtils", stringBuilder.toString());
        return 0;
      } 
      GLES20.glBindTexture(3553, stringBuilder[0]);
      GLES20.glTexParameteri(3553, 10240, 9729);
      GLES20.glTexParameteri(3553, 10241, 9729);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      GLUtils.texImage2D(3553, 0, (Bitmap)e, 0);
      e.recycle();
    } 
    if (stringBuilder[0] != null)
      return stringBuilder[0]; 
    throw new RuntimeException("Error loading texture.");
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2) {
    Bitmap bitmap = b(paramString, paramInt1, paramInt2);
    if (bitmap == null) {
      e.w.e("OpenGlUtils", "loadTextureByPath，load bitmap error, check the file path is correct!");
      return 0;
    } 
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    if (arrayOfInt[0] != 0) {
      GLES20.glBindTexture(3553, arrayOfInt[0]);
      GLES20.glTexParameteri(3553, 10240, 9729);
      GLES20.glTexParameteri(3553, 10241, 9729);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      GLUtils.texImage2D(3553, 0, bitmap, 0);
    } 
    if (arrayOfInt[0] == 0)
      e.w.e("OpenGlUtils", "loadTextureByPath, the texture id is 0!"); 
    return arrayOfInt[0];
  }
  
  private static Bitmap a(Context paramContext, String paramString) {
    Bitmap bitmap;
    AssetManager assetManager = paramContext.getResources().getAssets();
    Context context = null;
    paramContext = context;
    try {
      InputStream inputStream = assetManager.open(paramString);
      paramContext = context;
      Bitmap bitmap1 = BitmapFactory.decodeStream(inputStream);
      bitmap = bitmap1;
      inputStream.close();
      return bitmap1;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return bitmap;
    } 
  }
  
  private static Bitmap a(String paramString) {
    return (new File(paramString)).exists() ? BitmapFactory.decodeFile(paramString) : null;
  }
  
  public static void a(int paramInt) {
    if (paramInt == 0)
      return; 
    GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
  }
  
  private static Bitmap b(String paramString, int paramInt1, int paramInt2) {
    if (paramInt1 <= 0 || paramInt2 <= 0)
      return BitmapFactory.decodeFile(paramString); 
    BitmapFactory.Options options = new BitmapFactory.Options();
    boolean bool = true;
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, options);
    options.inJustDecodeBounds = false;
    int j = options.outWidth;
    int i = options.outHeight;
    e e = e.w;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("loadSuitableBitmap, bitmap size = ");
    stringBuilder.append(j);
    stringBuilder.append("x");
    stringBuilder.append(i);
    e.c("OpenGlUtils", stringBuilder.toString());
    paramInt1 = j / paramInt1;
    paramInt2 = i / paramInt2;
    if (paramInt1 >= paramInt2)
      paramInt1 = paramInt2; 
    if (paramInt1 <= 0)
      paramInt1 = bool; 
    options.inSampleSize = paramInt1;
    e = e.w;
    stringBuilder = new StringBuilder();
    stringBuilder.append("loadSuitableBitmap, inSampleSize = ");
    stringBuilder.append(paramInt1);
    e.c("OpenGlUtils", stringBuilder.toString());
    return BitmapFactory.decodeFile(paramString, options);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\c\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */