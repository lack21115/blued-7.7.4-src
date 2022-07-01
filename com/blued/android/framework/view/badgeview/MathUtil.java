package com.blued.android.framework.view.badgeview;

import android.graphics.PointF;
import java.util.List;

public class MathUtil {
  public static double a(double paramDouble) {
    return paramDouble / 6.283185307179586D * 360.0D;
  }
  
  public static double a(double paramDouble, int paramInt) {
    double d = paramDouble;
    if (paramDouble < 0.0D)
      d = paramDouble + 1.5707963267948966D; 
    return d + (paramInt - 1) * 1.5707963267948966D;
  }
  
  public static int a(PointF paramPointF1, PointF paramPointF2) {
    if (paramPointF1.x > paramPointF2.x) {
      if (paramPointF1.y > paramPointF2.y)
        return 4; 
      if (paramPointF1.y < paramPointF2.y)
        return 1; 
    } else if (paramPointF1.x < paramPointF2.x) {
      if (paramPointF1.y > paramPointF2.y)
        return 3; 
      if (paramPointF1.y < paramPointF2.y)
        return 2; 
    } 
    return -1;
  }
  
  public static void a(PointF paramPointF, float paramFloat, Double paramDouble, List<PointF> paramList) {
    float f;
    if (paramDouble != null) {
      double d1 = (float)Math.atan(paramDouble.doubleValue());
      double d2 = Math.cos(d1);
      double d3 = paramFloat;
      paramFloat = (float)(d2 * d3);
      f = (float)(Math.sin(d1) * d3);
    } else {
      f = 0.0F;
    } 
    paramList.add(new PointF(paramPointF.x + paramFloat, paramPointF.y + f));
    paramList.add(new PointF(paramPointF.x - paramFloat, paramPointF.y - f));
  }
  
  public static float b(PointF paramPointF1, PointF paramPointF2) {
    return (float)Math.sqrt(Math.pow((paramPointF1.x - paramPointF2.x), 2.0D) + Math.pow((paramPointF1.y - paramPointF2.y), 2.0D));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\badgeview\MathUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */