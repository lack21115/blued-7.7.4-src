package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class TransformationUtils {
  static {
    if (d.contains(Build.MODEL)) {
      ReentrantLock reentrantLock = new ReentrantLock();
    } else {
      noLock = new NoLock();
    } 
    e = noLock;
    c = new Paint(7);
    c.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
  }
  
  public static int a(int paramInt) {
    switch (paramInt) {
      default:
        return 0;
      case 7:
      case 8:
        return 270;
      case 5:
      case 6:
        return 90;
      case 3:
      case 4:
        break;
    } 
    return 180;
  }
  
  private static Bitmap.Config a(Bitmap paramBitmap) {
    return (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(paramBitmap.getConfig())) ? Bitmap.Config.RGBA_F16 : Bitmap.Config.ARGB_8888;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt) {
    if (paramInt != 0)
      try {
        Matrix matrix = new Matrix();
        matrix.setRotate(paramInt);
        return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), matrix, true);
      } catch (Exception exception) {
        if (Log.isLoggable("TransformationUtils", 6))
          Log.e("TransformationUtils", "Exception when trying to orient image", exception); 
      }  
    return paramBitmap;
  }
  
  private static Bitmap a(BitmapPool paramBitmapPool, Bitmap paramBitmap) {
    Bitmap.Config config = a(paramBitmap);
    if (config.equals(paramBitmap.getConfig()))
      return paramBitmap; 
    Bitmap bitmap = paramBitmapPool.a(paramBitmap.getWidth(), paramBitmap.getHeight(), config);
    (new Canvas(bitmap)).drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    return bitmap;
  }
  
  public static Bitmap a(BitmapPool paramBitmapPool, Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    return a(paramBitmapPool, paramBitmap, new DrawRoundedCornerFn(paramFloat1, paramFloat2, paramFloat3, paramFloat4) {
          public void a(Canvas param1Canvas, Paint param1Paint, RectF param1RectF) {
            Path path = new Path();
            float f1 = this.a;
            float f2 = this.b;
            float f3 = this.c;
            float f4 = this.d;
            Path.Direction direction = Path.Direction.CW;
            path.addRoundRect(param1RectF, new float[] { f1, f1, f2, f2, f3, f3, f4, f4 }, direction);
            param1Canvas.drawPath(path, param1Paint);
          }
        });
  }
  
  public static Bitmap a(BitmapPool paramBitmapPool, Bitmap paramBitmap, int paramInt) {
    if (!b(paramInt))
      return paramBitmap; 
    Matrix matrix = new Matrix();
    a(paramInt, matrix);
    RectF rectF = new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight());
    matrix.mapRect(rectF);
    Bitmap bitmap = paramBitmapPool.a(Math.round(rectF.width()), Math.round(rectF.height()), b(paramBitmap));
    matrix.postTranslate(-rectF.left, -rectF.top);
    bitmap.setHasAlpha(paramBitmap.hasAlpha());
    a(paramBitmap, bitmap, matrix);
    return bitmap;
  }
  
  public static Bitmap a(BitmapPool paramBitmapPool, Bitmap paramBitmap, int paramInt1, int paramInt2) {
    float f1;
    float f2;
    if (paramBitmap.getWidth() == paramInt1 && paramBitmap.getHeight() == paramInt2)
      return paramBitmap; 
    Matrix matrix = new Matrix();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f3 = 0.0F;
    if (i * paramInt2 > j * paramInt1) {
      f1 = paramInt2 / paramBitmap.getHeight();
      f2 = (paramInt1 - paramBitmap.getWidth() * f1) * 0.5F;
    } else {
      f1 = paramInt1 / paramBitmap.getWidth();
      f3 = (paramInt2 - paramBitmap.getHeight() * f1) * 0.5F;
      f2 = 0.0F;
    } 
    matrix.setScale(f1, f1);
    matrix.postTranslate((int)(f2 + 0.5F), (int)(f3 + 0.5F));
    Bitmap bitmap = paramBitmapPool.a(paramInt1, paramInt2, b(paramBitmap));
    a(paramBitmap, bitmap);
    a(paramBitmap, bitmap, matrix);
    return bitmap;
  }
  
  private static Bitmap a(BitmapPool paramBitmapPool, Bitmap paramBitmap, DrawRoundedCornerFn paramDrawRoundedCornerFn) {
    Bitmap.Config config = a(paramBitmap);
    Bitmap bitmap1 = a(paramBitmapPool, paramBitmap);
    Bitmap bitmap2 = paramBitmapPool.a(bitmap1.getWidth(), bitmap1.getHeight(), config);
    bitmap2.setHasAlpha(true);
    BitmapShader bitmapShader = new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setShader((Shader)bitmapShader);
    RectF rectF = new RectF(0.0F, 0.0F, bitmap2.getWidth(), bitmap2.getHeight());
    e.lock();
    try {
      Canvas canvas = new Canvas(bitmap2);
      canvas.drawColor(0, PorterDuff.Mode.CLEAR);
      paramDrawRoundedCornerFn.a(canvas, paint, rectF);
      a(canvas);
      e.unlock();
      return bitmap2;
    } finally {
      e.unlock();
    } 
  }
  
  public static Lock a() {
    return e;
  }
  
  static void a(int paramInt, Matrix paramMatrix) {
    switch (paramInt) {
      default:
        return;
      case 8:
        paramMatrix.setRotate(-90.0F);
        return;
      case 7:
        paramMatrix.setRotate(-90.0F);
        paramMatrix.postScale(-1.0F, 1.0F);
        return;
      case 6:
        paramMatrix.setRotate(90.0F);
        return;
      case 5:
        paramMatrix.setRotate(90.0F);
        paramMatrix.postScale(-1.0F, 1.0F);
        return;
      case 4:
        paramMatrix.setRotate(180.0F);
        paramMatrix.postScale(-1.0F, 1.0F);
        return;
      case 3:
        paramMatrix.setRotate(180.0F);
        return;
      case 2:
        break;
    } 
    paramMatrix.setScale(-1.0F, 1.0F);
  }
  
  public static void a(Bitmap paramBitmap1, Bitmap paramBitmap2) {
    paramBitmap2.setHasAlpha(paramBitmap1.hasAlpha());
  }
  
  private static void a(Bitmap paramBitmap1, Bitmap paramBitmap2, Matrix paramMatrix) {
    e.lock();
    try {
      Canvas canvas = new Canvas(paramBitmap2);
      canvas.drawBitmap(paramBitmap1, paramMatrix, a);
      a(canvas);
      return;
    } finally {
      e.unlock();
    } 
  }
  
  private static void a(Canvas paramCanvas) {
    paramCanvas.setBitmap(null);
  }
  
  private static Bitmap.Config b(Bitmap paramBitmap) {
    return (paramBitmap.getConfig() != null) ? paramBitmap.getConfig() : Bitmap.Config.ARGB_8888;
  }
  
  public static Bitmap b(BitmapPool paramBitmapPool, Bitmap paramBitmap, int paramInt) {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "roundingRadius must be greater than 0.");
    return a(paramBitmapPool, paramBitmap, new DrawRoundedCornerFn(paramInt) {
          public void a(Canvas param1Canvas, Paint param1Paint, RectF param1RectF) {
            int i = this.a;
            param1Canvas.drawRoundRect(param1RectF, i, i, param1Paint);
          }
        });
  }
  
  public static Bitmap b(BitmapPool paramBitmapPool, Bitmap paramBitmap, int paramInt1, int paramInt2) {
    if (paramBitmap.getWidth() == paramInt1 && paramBitmap.getHeight() == paramInt2) {
      if (Log.isLoggable("TransformationUtils", 2))
        Log.v("TransformationUtils", "requested target size matches input, returning input"); 
      return paramBitmap;
    } 
    float f = Math.min(paramInt1 / paramBitmap.getWidth(), paramInt2 / paramBitmap.getHeight());
    int i = Math.round(paramBitmap.getWidth() * f);
    int j = Math.round(paramBitmap.getHeight() * f);
    if (paramBitmap.getWidth() == i && paramBitmap.getHeight() == j) {
      if (Log.isLoggable("TransformationUtils", 2))
        Log.v("TransformationUtils", "adjusted target size matches input, returning input"); 
      return paramBitmap;
    } 
    Bitmap bitmap = paramBitmapPool.a((int)(paramBitmap.getWidth() * f), (int)(paramBitmap.getHeight() * f), b(paramBitmap));
    a(paramBitmap, bitmap);
    if (Log.isLoggable("TransformationUtils", 2)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("request: ");
      stringBuilder.append(paramInt1);
      stringBuilder.append("x");
      stringBuilder.append(paramInt2);
      Log.v("TransformationUtils", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("toFit:   ");
      stringBuilder.append(paramBitmap.getWidth());
      stringBuilder.append("x");
      stringBuilder.append(paramBitmap.getHeight());
      Log.v("TransformationUtils", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("toReuse: ");
      stringBuilder.append(bitmap.getWidth());
      stringBuilder.append("x");
      stringBuilder.append(bitmap.getHeight());
      Log.v("TransformationUtils", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("minPct:   ");
      stringBuilder.append(f);
      Log.v("TransformationUtils", stringBuilder.toString());
    } 
    Matrix matrix = new Matrix();
    matrix.setScale(f, f);
    a(paramBitmap, bitmap, matrix);
    return bitmap;
  }
  
  public static boolean b(int paramInt) {
    switch (paramInt) {
      default:
        return false;
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
        break;
    } 
    return true;
  }
  
  public static Bitmap c(BitmapPool paramBitmapPool, Bitmap paramBitmap, int paramInt1, int paramInt2) {
    if (paramBitmap.getWidth() <= paramInt1 && paramBitmap.getHeight() <= paramInt2) {
      if (Log.isLoggable("TransformationUtils", 2))
        Log.v("TransformationUtils", "requested target size larger or equal to input, returning input"); 
      return paramBitmap;
    } 
    if (Log.isLoggable("TransformationUtils", 2))
      Log.v("TransformationUtils", "requested target size too big for input, fit centering instead"); 
    return b(paramBitmapPool, paramBitmap, paramInt1, paramInt2);
  }
  
  public static Bitmap d(BitmapPool paramBitmapPool, Bitmap paramBitmap, int paramInt1, int paramInt2) {
    paramInt1 = Math.min(paramInt1, paramInt2);
    float f2 = paramInt1;
    float f1 = f2 / 2.0F;
    paramInt2 = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    float f3 = paramInt2;
    float f5 = f2 / f3;
    float f4 = i;
    f5 = Math.max(f5, f2 / f4);
    f3 *= f5;
    f4 = f5 * f4;
    f5 = (f2 - f3) / 2.0F;
    f2 = (f2 - f4) / 2.0F;
    RectF rectF = new RectF(f5, f2, f3 + f5, f4 + f2);
    Bitmap bitmap1 = a(paramBitmapPool, paramBitmap);
    Bitmap bitmap2 = paramBitmapPool.a(paramInt1, paramInt1, a(paramBitmap));
    bitmap2.setHasAlpha(true);
    e.lock();
    try {
      Canvas canvas = new Canvas(bitmap2);
      canvas.drawCircle(f1, f1, f1, b);
      canvas.drawBitmap(bitmap1, null, rectF, c);
      a(canvas);
      e.unlock();
      return bitmap2;
    } finally {
      e.unlock();
    } 
  }
  
  static {
    NoLock noLock;
  }
  
  private static final Paint a = new Paint(6);
  
  private static final Paint b = new Paint(7);
  
  private static final Paint c;
  
  private static final Set<String> d = new HashSet<String>(Arrays.asList(new String[] { 
          "XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", 
          "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", 
          "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079" }));
  
  private static final Lock e;
  
  static interface DrawRoundedCornerFn {
    void a(Canvas param1Canvas, Paint param1Paint, RectF param1RectF);
  }
  
  static final class NoLock implements Lock {
    public void lock() {}
    
    public void lockInterruptibly() throws InterruptedException {}
    
    public Condition newCondition() {
      throw new UnsupportedOperationException("Should not be called");
    }
    
    public boolean tryLock() {
      return true;
    }
    
    public boolean tryLock(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException {
      return true;
    }
    
    public void unlock() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\TransformationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */