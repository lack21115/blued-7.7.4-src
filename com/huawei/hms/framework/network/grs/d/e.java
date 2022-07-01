package com.huawei.hms.framework.network.grs.d;

import com.huawei.hms.framework.common.Logger;

public class e {
  private static final String a = "e";
  
  public static boolean a(Long paramLong) {
    if (paramLong == null) {
      Logger.v(a, "Method isTimeExpire input param expireTime is null.");
      return true;
    } 
    try {
      long l = System.currentTimeMillis();
      if (paramLong.longValue() - l >= 0L) {
        String str1 = a;
        Logger.v(str1, "isSpExpire false.");
        return false;
      } 
      String str = a;
      Logger.v(str, "isSpExpire true.");
      return true;
    } catch (NumberFormatException numberFormatException) {
      Logger.v(a, "isSpExpire spValue NumberFormatException.");
      return true;
    } 
  }
  
  public static boolean a(Long paramLong, long paramLong1) {
    if (paramLong == null) {
      Logger.v(a, "Method isTimeWillExpire input param expireTime is null.");
      return true;
    } 
    try {
      long l = System.currentTimeMillis();
      if (paramLong.longValue() - l + paramLong1 >= 0L) {
        String str = a;
        Logger.v(str, "isSpExpire false.");
        return false;
      } 
    } catch (NumberFormatException numberFormatException) {
      Logger.v(a, "isSpExpire spValue NumberFormatException.");
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */