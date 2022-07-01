package com.amap.api.location;

public class CoordUtil {
  private static boolean a = false;
  
  public static native int convertToGcj(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2);
  
  public static boolean isLoadedSo() {
    return a;
  }
  
  public static void setLoadedSo(boolean paramBoolean) {
    a = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\location\CoordUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */