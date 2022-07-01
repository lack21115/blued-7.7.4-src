package com.datavisor.vangogh.f;

public class f {
  public static boolean a(String paramString) {
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
  
  public static boolean b(String paramString) {
    return a(paramString) ^ true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\f\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */