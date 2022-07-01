package com.qiniu.pili.droid.shortvideo.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build;
import android.util.Log;
import com.qiniu.pili.droid.shortvideo.gl.c.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class d {
  public static final Object a = new Object();
  
  public static float[] b = new float[] { -1.0F, -1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F, 1.0F };
  
  public static float[] c = new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  
  public static float[] d = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  
  public static float[] e = new float[] { 1.0F, -1.0F, 1.0F, 1.0F, -1.0F, -1.0F, -1.0F, 1.0F };
  
  public static final float[] f = new float[16];
  
  private static int g = 2;
  
  static {
    Matrix.setIdentityM(f, 0);
  }
  
  private static int a(int paramInt, String paramString) {
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    int[] arrayOfInt = new int[1];
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0) {
      GLES20.glDeleteShader(paramInt);
      Log.e("GLUtils", "Compilation of shader failed.");
      return 0;
    } 
    return paramInt;
  }
  
  public static int a(Bitmap paramBitmap) {
    if (paramBitmap == null) {
      e.w.e("GLUtils", "loadTextureByBitmap，load bitmap error, check the file path is correct!");
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
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    } 
    if (arrayOfInt[0] == 0)
      e.w.e("GLUtils", "loadTextureByBitmap, the texture id is 0!"); 
    return arrayOfInt[0];
  }
  
  public static int a(String paramString1, String paramString2) {
    int i = a(35633, paramString1);
    int j = a(35632, paramString2);
    if (i != 0) {
      if (j == 0)
        return -1; 
      int k = GLES20.glCreateProgram();
      GLES20.glAttachShader(k, i);
      GLES20.glAttachShader(k, j);
      GLES20.glLinkProgram(k);
      int[] arrayOfInt = new int[1];
      GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
      if (arrayOfInt[0] == 0) {
        GLES20.glDeleteProgram(k);
        Log.d("GLUtils", "Linking of program failed !");
        return -1;
      } 
      return !b(k) ? -1 : k;
    } 
    return -1;
  }
  
  public static int a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3) {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    a("glGenTextures");
    GLES20.glBindTexture(3553, i);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    a("loadImageTexture");
    GLES20.glTexImage2D(3553, 0, paramInt3, paramInt1, paramInt2, 0, paramInt3, 5121, paramByteBuffer);
    a("loadImageTexture");
    return i;
  }
  
  public static Bitmap a(Context paramContext, Uri paramUri, int paramInt1, int paramInt2) {
    if (paramContext == null || paramUri == null) {
      e.w.e("GLUtils", "loadSuitableBitmap error : context and uri can'tt be null!");
      return null;
    } 
    try {
      Bitmap bitmap;
      InputStream inputStream = paramContext.getContentResolver().openInputStream(paramUri);
      if (paramInt1 <= 0 || paramInt2 <= 0) {
        bitmap = BitmapFactory.decodeStream(inputStream);
        try {
          inputStream.close();
          return bitmap;
        } catch (IOException iOException) {
          iOException.printStackTrace();
          return bitmap;
        } 
      } 
      BitmapFactory.Options options = new BitmapFactory.Options();
      options.inJustDecodeBounds = true;
      BitmapFactory.decodeStream(inputStream, null, options);
      try {
        inputStream.close();
      } catch (IOException iOException1) {
        iOException1.printStackTrace();
      } 
      options.inJustDecodeBounds = false;
      int i = options.outWidth;
      int j = options.outHeight;
      e e = e.w;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("loadSuitableBitmap, bitmap size = ");
      stringBuilder.append(i);
      stringBuilder.append("x");
      stringBuilder.append(j);
      e.c("GLUtils", stringBuilder.toString());
      i /= paramInt1;
      j /= paramInt2;
      if (i >= j)
        i = j; 
      j = i;
      if (i <= 0)
        j = 1; 
      options.inSampleSize = j;
      e = e.w;
      stringBuilder = new StringBuilder();
      stringBuilder.append("loadSuitableBitmap, inSampleSize = ");
      stringBuilder.append(j);
      e.c("GLUtils", stringBuilder.toString());
      try {
        InputStream inputStream1 = bitmap.getContentResolver().openInputStream((Uri)iOException);
        Bitmap bitmap1 = BitmapFactory.decodeStream(inputStream1, null, options);
        try {
          inputStream1.close();
        } catch (IOException iOException1) {
          iOException1.printStackTrace();
        } 
        if (bitmap1.getWidth() == paramInt1) {
          Bitmap bitmap2 = bitmap1;
          return (bitmap1.getHeight() != paramInt2) ? a(bitmap1, paramInt1, paramInt2) : bitmap2;
        } 
        return a(bitmap1, paramInt1, paramInt2);
      } catch (FileNotFoundException fileNotFoundException) {
        fileNotFoundException.printStackTrace();
        return null;
      } 
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
      e.w.e("GLUtils", "loadSuitableBitmap error : parsing uri error!");
      return null;
    } 
  }
  
  private static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2) {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    Matrix matrix = new Matrix();
    matrix.postScale(f1, f2);
    Bitmap bitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, matrix, false);
    paramBitmap.recycle();
    return bitmap;
  }
  
  public static g a(int paramInt1, int paramInt2) {
    g g = new g();
    g.a(paramInt1, paramInt2);
    g.b();
    return g;
  }
  
  public static boolean a() {
    return (g > 2);
  }
  
  public static boolean a(String paramString) {
    int i = GLES20.glGetError();
    if (i != 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(": glError 0x");
      stringBuilder.append(Integer.toHexString(i));
      Log.e("GLUtils", stringBuilder.toString());
      return false;
    } 
    return true;
  }
  
  public static int[] a(int paramInt) {
    int[] arrayOfInt = new int[paramInt];
    GLES20.glGenTextures(paramInt, arrayOfInt, 0);
    return arrayOfInt;
  }
  
  public static g b(int paramInt1, int paramInt2) {
    g g = new g();
    g.a(paramInt1, paramInt2);
    g.b();
    return g;
  }
  
  public static boolean b() {
    if (Build.VERSION.SDK_INT >= 17)
      try {
        EGL14.eglGetCurrentContext();
        return true;
      } catch (NoClassDefFoundError noClassDefFoundError) {
        Log.i("GLUtils", "EGL14 isn't supported on this platform, change to use EGL10.");
      }  
    return false;
  }
  
  private static boolean b(int paramInt) {
    GLES20.glValidateProgram(paramInt);
    int[] arrayOfInt = new int[1];
    GLES20.glGetProgramiv(paramInt, 35715, arrayOfInt, 0);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Results of validating program: ");
    stringBuilder.append(arrayOfInt[0]);
    stringBuilder.append("\nLog:");
    stringBuilder.append(GLES20.glGetProgramInfoLog(paramInt));
    Log.d("GLUtils", stringBuilder.toString());
    return (arrayOfInt[0] != 0);
  }
  
  public static int c() {
    return a(1)[0];
  }
  
  public static int d() {
    int[] arrayOfInt = new int[1];
    GLES30.glGenVertexArrays(1, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  public static int e() {
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    return arrayOfInt[0];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */