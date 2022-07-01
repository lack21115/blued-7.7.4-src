package com.bytedance.sdk.a.b.a.c;

public final class f {
  public static boolean a(String paramString) {
    return (paramString.equals("POST") || paramString.equals("PATCH") || paramString.equals("PUT") || paramString.equals("DELETE") || paramString.equals("MOVE"));
  }
  
  public static boolean b(String paramString) {
    return (paramString.equals("POST") || paramString.equals("PUT") || paramString.equals("PATCH") || paramString.equals("PROPPATCH") || paramString.equals("REPORT"));
  }
  
  public static boolean c(String paramString) {
    return (b(paramString) || paramString.equals("OPTIONS") || paramString.equals("DELETE") || paramString.equals("PROPFIND") || paramString.equals("MKCOL") || paramString.equals("LOCK"));
  }
  
  public static boolean d(String paramString) {
    return paramString.equals("PROPFIND");
  }
  
  public static boolean e(String paramString) {
    return paramString.equals("PROPFIND") ^ true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */