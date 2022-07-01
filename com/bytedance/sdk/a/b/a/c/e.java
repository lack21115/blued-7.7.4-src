package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.l;
import com.bytedance.sdk.a.b.m;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.s;
import java.util.List;
import java.util.regex.Pattern;

public final class e {
  private static final Pattern a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
  
  public static int a(String paramString, int paramInt) {
    while (paramInt < paramString.length()) {
      char c = paramString.charAt(paramInt);
      if (c != ' ' && c != '\t')
        return paramInt; 
      paramInt++;
    } 
    return paramInt;
  }
  
  public static int a(String paramString1, int paramInt, String paramString2) {
    while (paramInt < paramString1.length()) {
      if (paramString2.indexOf(paramString1.charAt(paramInt)) != -1)
        return paramInt; 
      paramInt++;
    } 
    return paramInt;
  }
  
  public static long a(aa paramaa) {
    return a(paramaa.f());
  }
  
  public static long a(r paramr) {
    return a(paramr.a("Content-Length"));
  }
  
  private static long a(String paramString) {
    if (paramString == null)
      return -1L; 
    try {
      return Long.parseLong(paramString);
    } catch (NumberFormatException numberFormatException) {
      return -1L;
    } 
  }
  
  public static void a(m paramm, s params, r paramr) {
    if (paramm == m.a)
      return; 
    List list = l.a(params, paramr);
    if (list.isEmpty())
      return; 
    paramm.a(params, list);
  }
  
  public static int b(String paramString, int paramInt) {
    try {
      long l = Long.parseLong(paramString);
      return (l > 2147483647L) ? Integer.MAX_VALUE : ((l < 0L) ? 0 : (int)l);
    } catch (NumberFormatException numberFormatException) {
      return paramInt;
    } 
  }
  
  public static boolean b(aa paramaa) {
    if (paramaa.a().b().equals("HEAD"))
      return false; 
    int i = paramaa.c();
    return ((i < 100 || i >= 200) && i != 204 && i != 304) ? true : ((a(paramaa) == -1L) ? ("chunked".equalsIgnoreCase(paramaa.a("Transfer-Encoding"))) : true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */