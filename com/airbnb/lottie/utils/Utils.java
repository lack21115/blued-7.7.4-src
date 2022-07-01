package com.airbnb.lottie.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.os.Build;
import android.provider.Settings;
import com.airbnb.lottie.L;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import java.io.Closeable;

public final class Utils {
  private static final PathMeasure a = new PathMeasure();
  
  private static final Path b = new Path();
  
  private static final Path c = new Path();
  
  private static final float[] d = new float[4];
  
  private static final float e = (float)Math.sqrt(2.0D);
  
  private static float f = -1.0F;
  
  public static float a() {
    if (f == -1.0F)
      f = (Resources.getSystem().getDisplayMetrics()).density; 
    return f;
  }
  
  public static float a(Context paramContext) {
    return (Build.VERSION.SDK_INT >= 17) ? Settings.Global.getFloat(paramContext.getContentResolver(), "animator_duration_scale", 1.0F) : Settings.System.getFloat(paramContext.getContentResolver(), "animator_duration_scale", 1.0F);
  }
  
  public static float a(Matrix paramMatrix) {
    float[] arrayOfFloat2 = d;
    arrayOfFloat2[0] = 0.0F;
    arrayOfFloat2[1] = 0.0F;
    float f1 = e;
    arrayOfFloat2[2] = f1;
    arrayOfFloat2[3] = f1;
    paramMatrix.mapPoints(arrayOfFloat2);
    float[] arrayOfFloat1 = d;
    f1 = arrayOfFloat1[2];
    float f2 = arrayOfFloat1[0];
    float f3 = arrayOfFloat1[3];
    float f4 = arrayOfFloat1[1];
    return (float)Math.hypot((f1 - f2), (f3 - f4)) / 2.0F;
  }
  
  public static int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    if (paramFloat1 != 0.0F) {
      j = (int)('ȏ' * paramFloat1);
    } else {
      j = 17;
    } 
    int i = j;
    if (paramFloat2 != 0.0F)
      i = (int)((j * 31) * paramFloat2); 
    int j = i;
    if (paramFloat3 != 0.0F)
      j = (int)((i * 31) * paramFloat3); 
    i = j;
    if (paramFloat4 != 0.0F)
      i = (int)((j * 31) * paramFloat4); 
    return i;
  }
  
  public static Path a(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4) {
    Path path = new Path();
    path.moveTo(paramPointF1.x, paramPointF1.y);
    if (paramPointF3 != null && paramPointF4 != null && (paramPointF3.length() != 0.0F || paramPointF4.length() != 0.0F)) {
      float f = paramPointF1.x;
      path.cubicTo(paramPointF3.x + f, paramPointF1.y + paramPointF3.y, paramPointF2.x + paramPointF4.x, paramPointF2.y + paramPointF4.y, paramPointF2.x, paramPointF2.y);
      return path;
    } 
    path.lineTo(paramPointF2.x, paramPointF2.y);
    return path;
  }
  
  public static void a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3) {
    L.a("applyTrimPathIfNeeded");
    a.setPath(paramPath, false);
    float f2 = a.getLength();
    if (paramFloat1 == 1.0F && paramFloat2 == 0.0F) {
      L.b("applyTrimPathIfNeeded");
      return;
    } 
    if (f2 < 1.0F || Math.abs(paramFloat2 - paramFloat1 - 1.0F) < 0.01D) {
      L.b("applyTrimPathIfNeeded");
      return;
    } 
    float f1 = paramFloat1 * f2;
    paramFloat2 *= f2;
    paramFloat1 = Math.min(f1, paramFloat2);
    f1 = Math.max(f1, paramFloat2);
    paramFloat3 *= f2;
    paramFloat2 = paramFloat1 + paramFloat3;
    f1 += paramFloat3;
    paramFloat3 = paramFloat2;
    paramFloat1 = f1;
    if (paramFloat2 >= f2) {
      paramFloat3 = paramFloat2;
      paramFloat1 = f1;
      if (f1 >= f2) {
        paramFloat3 = MiscUtils.a(paramFloat2, f2);
        paramFloat1 = MiscUtils.a(f1, f2);
      } 
    } 
    paramFloat2 = paramFloat3;
    if (paramFloat3 < 0.0F)
      paramFloat2 = MiscUtils.a(paramFloat3, f2); 
    paramFloat3 = paramFloat1;
    if (paramFloat1 < 0.0F)
      paramFloat3 = MiscUtils.a(paramFloat1, f2); 
    int i = paramFloat2 cmp paramFloat3;
    if (i == 0) {
      paramPath.reset();
      L.b("applyTrimPathIfNeeded");
      return;
    } 
    paramFloat1 = paramFloat2;
    if (i >= 0)
      paramFloat1 = paramFloat2 - f2; 
    b.reset();
    a.getSegment(paramFloat1, paramFloat3, b, true);
    if (paramFloat3 > f2) {
      c.reset();
      a.getSegment(0.0F, paramFloat3 % f2, c, true);
      b.addPath(c);
    } else if (paramFloat1 < 0.0F) {
      c.reset();
      a.getSegment(paramFloat1 + f2, f2, c, true);
      b.addPath(c);
    } 
    paramPath.set(b);
    L.b("applyTrimPathIfNeeded");
  }
  
  public static void a(Path paramPath, TrimPathContent paramTrimPathContent) {
    if (paramTrimPathContent != null) {
      if (paramTrimPathContent.g())
        return; 
      float f1 = ((FloatKeyframeAnimation)paramTrimPathContent.d()).i();
      float f2 = ((FloatKeyframeAnimation)paramTrimPathContent.e()).i();
      float f3 = ((FloatKeyframeAnimation)paramTrimPathContent.f()).i();
      a(paramPath, f1 / 100.0F, f2 / 100.0F, f3 / 360.0F);
    } 
  }
  
  public static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    boolean bool = false;
    if (paramInt1 < paramInt4)
      return false; 
    if (paramInt1 > paramInt4)
      return true; 
    if (paramInt2 < paramInt5)
      return false; 
    if (paramInt2 > paramInt5)
      return true; 
    if (paramInt3 >= paramInt6)
      bool = true; 
    return bool;
  }
  
  public static boolean b(Matrix paramMatrix) {
    float[] arrayOfFloat2 = d;
    arrayOfFloat2[0] = 0.0F;
    arrayOfFloat2[1] = 0.0F;
    arrayOfFloat2[2] = 37394.73F;
    arrayOfFloat2[3] = 39575.234F;
    paramMatrix.mapPoints(arrayOfFloat2);
    float[] arrayOfFloat1 = d;
    return (arrayOfFloat1[0] != arrayOfFloat1[2]) ? ((arrayOfFloat1[1] == arrayOfFloat1[3])) : true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lotti\\utils\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */