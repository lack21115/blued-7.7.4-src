package com.amap.api.mapcore2d;

public class cl {
  public static boolean a(double paramDouble1, double paramDouble2) {
    int i = (int)((paramDouble2 - 73.0D) / 0.5D);
    int j = (int)((paramDouble1 - 3.5D) / 0.5D);
    boolean bool = false;
    if (j >= 0 && j < 101 && i >= 0) {
      if (i >= 124)
        return false; 
      try {
        return bool;
      } finally {
        Exception exception = null;
        exception.printStackTrace();
      } 
    } 
    return false;
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3) {
    double d1 = 156543.0339D / (1 << paramInt3);
    double d2 = (paramInt1 * 256);
    double d3 = (-paramInt2 * 256);
    float f = (float)((d2 * d1 - 2.003750834E7D) * 180.0D / 2.003750834E7D);
    return a((float)((Math.atan(Math.exp((float)((d3 * d1 + 2.003750834E7D) * 180.0D / 2.003750834E7D) * Math.PI / 180.0D)) * 2.0D - 1.5707963267948966D) * 57.29577951308232D), f);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */