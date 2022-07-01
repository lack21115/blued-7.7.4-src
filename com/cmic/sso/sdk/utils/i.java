package com.cmic.sso.sdk.utils;

import com.cmic.sso.sdk.auth.TokenListener;
import java.util.concurrent.ConcurrentHashMap;

public class i {
  private static ConcurrentHashMap<String, TokenListener> a = new ConcurrentHashMap<String, TokenListener>();
  
  private static ConcurrentHashMap<String, Boolean> b = new ConcurrentHashMap<String, Boolean>();
  
  public static void a(String paramString, TokenListener paramTokenListener) {
    a.put(paramString, paramTokenListener);
  }
  
  public static boolean a() {
    return a.isEmpty();
  }
  
  public static boolean a(String paramString) {
    return a.containsKey(paramString) ^ true;
  }
  
  public static void b(String paramString) {
    a.remove(paramString);
    if (b.containsKey(paramString))
      b.remove(paramString); 
  }
  
  public static TokenListener c(String paramString) {
    return a.get(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */