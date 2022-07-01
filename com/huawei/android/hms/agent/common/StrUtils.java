package com.huawei.android.hms.agent.common;

public final class StrUtils {
  public static String objDesc(Object paramObject) {
    if (paramObject == null)
      return "null"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramObject.getClass().getName());
    stringBuilder.append('@');
    stringBuilder.append(Integer.toHexString(paramObject.hashCode()));
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\agent\common\StrUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */