package com.alibaba.mtl.appmonitor.f;

public class b {
  public static boolean c(String paramString) {
    return isBlank(paramString) ^ true;
  }
  
  public static boolean isBlank(String paramString) {
    if (paramString != null) {
      int j = paramString.length();
      if (j == 0)
        return true; 
      for (int i = 0; i < j; i++) {
        if (!Character.isWhitespace(paramString.charAt(i)))
          return false; 
      } 
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */