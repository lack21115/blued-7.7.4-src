package org.chromium.net;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ThreadStatsUid {
  private static final Method sClearThreadStatsUid;
  
  private static final Method sSetThreadStatsUid;
  
  static {
    try {
      Class<int> clazz = int.class;
      throw new VerifyError("bad dex opcode");
    } catch (NoSuchMethodException|SecurityException noSuchMethodException) {
      throw new RuntimeException("Unable to get TrafficStats methods", noSuchMethodException);
    } 
  }
  
  public static void clear() {
    try {
      sClearThreadStatsUid.invoke(null, new Object[0]);
      return;
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", invocationTargetException);
    } 
  }
  
  public static void set(int paramInt) {
    try {
      sSetThreadStatsUid.invoke(null, new Object[] { Integer.valueOf(paramInt) });
      return;
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException("TrafficStats.setThreadStatsUid failed", illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      throw new RuntimeException("TrafficStats.setThreadStatsUid failed", invocationTargetException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\ThreadStatsUid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */