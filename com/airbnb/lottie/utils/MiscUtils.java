package com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.List;

public class MiscUtils {
  private static PointF a = new PointF();
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3) {
    return paramDouble1 + paramDouble3 * (paramDouble2 - paramDouble1);
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3) {
    return paramFloat1 + paramFloat3 * (paramFloat2 - paramFloat1);
  }
  
  static int a(float paramFloat1, float paramFloat2) {
    return a((int)paramFloat1, (int)paramFloat2);
  }
  
  private static int a(int paramInt1, int paramInt2) {
    return paramInt1 - paramInt2 * b(paramInt1, paramInt2);
  }
  
  public static int a(int paramInt1, int paramInt2, float paramFloat) {
    return (int)(paramInt1 + paramFloat * (paramInt2 - paramInt1));
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3) {
    return Math.max(paramInt2, Math.min(paramInt3, paramInt1));
  }
  
  public static PointF a(PointF paramPointF1, PointF paramPointF2) {
    return new PointF(paramPointF1.x + paramPointF2.x, paramPointF1.y + paramPointF2.y);
  }
  
  public static void a(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2, KeyPathElementContent paramKeyPathElementContent) {
    if (paramKeyPath1.c(paramKeyPathElementContent.b(), paramInt))
      paramList.add(paramKeyPath2.a(paramKeyPathElementContent.b()).a((KeyPathElement)paramKeyPathElementContent)); 
  }
  
  public static void a(ShapeData paramShapeData, Path paramPath) {
    paramPath.reset();
    PointF pointF = paramShapeData.a();
    paramPath.moveTo(pointF.x, pointF.y);
    a.set(pointF.x, pointF.y);
    for (int i = 0; i < paramShapeData.c().size(); i++) {
      CubicCurveData cubicCurveData = paramShapeData.c().get(i);
      pointF = cubicCurveData.a();
      PointF pointF1 = cubicCurveData.b();
      PointF pointF2 = cubicCurveData.c();
      if (pointF.equals(a) && pointF1.equals(pointF2)) {
        paramPath.lineTo(pointF2.x, pointF2.y);
      } else {
        paramPath.cubicTo(pointF.x, pointF.y, pointF1.x, pointF1.y, pointF2.x, pointF2.y);
      } 
      a.set(pointF2.x, pointF2.y);
    } 
    if (paramShapeData.b())
      paramPath.close(); 
  }
  
  public static float b(float paramFloat1, float paramFloat2, float paramFloat3) {
    return Math.max(paramFloat2, Math.min(paramFloat3, paramFloat1));
  }
  
  private static int b(int paramInt1, int paramInt2) {
    boolean bool;
    int j = paramInt1 / paramInt2;
    if ((paramInt1 ^ paramInt2) >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    int i = j;
    if (!bool) {
      i = j;
      if (paramInt1 % paramInt2 != 0)
        i = j - 1; 
    } 
    return i;
  }
  
  public static boolean c(float paramFloat1, float paramFloat2, float paramFloat3) {
    return (paramFloat1 >= paramFloat2 && paramFloat1 <= paramFloat3);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lotti\\utils\MiscUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */