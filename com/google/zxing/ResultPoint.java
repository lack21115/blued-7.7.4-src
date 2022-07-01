package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;

public class ResultPoint {
  private final float a;
  
  private final float b;
  
  public ResultPoint(float paramFloat1, float paramFloat2) {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public static float a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2) {
    return MathUtils.a(paramResultPoint1.a, paramResultPoint1.b, paramResultPoint2.a, paramResultPoint2.b);
  }
  
  private static float a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3) {
    float f1 = paramResultPoint2.a;
    float f2 = paramResultPoint2.b;
    return (paramResultPoint3.a - f1) * (paramResultPoint1.b - f2) - (paramResultPoint3.b - f2) * (paramResultPoint1.a - f1);
  }
  
  public static void a(ResultPoint[] paramArrayOfResultPoint) {
    ResultPoint resultPoint1;
    ResultPoint resultPoint2;
    ResultPoint resultPoint3;
    float f1 = a(paramArrayOfResultPoint[0], paramArrayOfResultPoint[1]);
    float f2 = a(paramArrayOfResultPoint[1], paramArrayOfResultPoint[2]);
    float f3 = a(paramArrayOfResultPoint[0], paramArrayOfResultPoint[2]);
    if (f2 >= f1 && f2 >= f3) {
      resultPoint3 = paramArrayOfResultPoint[0];
      resultPoint1 = paramArrayOfResultPoint[1];
      resultPoint2 = paramArrayOfResultPoint[2];
    } else if (f3 >= f2 && f3 >= f1) {
      resultPoint3 = paramArrayOfResultPoint[1];
      resultPoint1 = paramArrayOfResultPoint[0];
      resultPoint2 = paramArrayOfResultPoint[2];
    } else {
      resultPoint3 = paramArrayOfResultPoint[2];
      resultPoint1 = paramArrayOfResultPoint[0];
      resultPoint2 = paramArrayOfResultPoint[1];
    } 
    ResultPoint resultPoint5 = resultPoint1;
    ResultPoint resultPoint4 = resultPoint2;
    if (a(resultPoint1, resultPoint3, resultPoint2) < 0.0F) {
      resultPoint4 = resultPoint1;
      resultPoint5 = resultPoint2;
    } 
    paramArrayOfResultPoint[0] = resultPoint5;
    paramArrayOfResultPoint[1] = resultPoint3;
    paramArrayOfResultPoint[2] = resultPoint4;
  }
  
  public final float a() {
    return this.a;
  }
  
  public final float b() {
    return this.b;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject instanceof ResultPoint) {
      paramObject = paramObject;
      if (this.a == ((ResultPoint)paramObject).a && this.b == ((ResultPoint)paramObject).b)
        return true; 
    } 
    return false;
  }
  
  public final int hashCode() {
    return Float.floatToIntBits(this.a) * 31 + Float.floatToIntBits(this.b);
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("(");
    stringBuilder.append(this.a);
    stringBuilder.append(',');
    stringBuilder.append(this.b);
    stringBuilder.append(')');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\ResultPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */