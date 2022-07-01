package com.datavisor.vangogh.f.i;

import com.datavisor.vangogh.f.f;
import com.datavisor.vangogh.face.HostType;

public class a {
  private static HostType a = HostType.c;
  
  private static String b = "";
  
  public static String a() {
    String str = c();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("https://");
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
  
  public static void a(String paramString) {
    b = paramString;
  }
  
  public static String b() {
    String str = d();
    if (f.b(str)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("https://");
      stringBuilder.append(str);
      return stringBuilder.toString();
    } 
    return null;
  }
  
  public static String c() {
    if (f.b(b))
      return b; 
    int i = a.a[a.ordinal()];
    return (i != 1) ? ((i != 2) ? "gw-picasso.datavisor.cn" : "gw-picasso-test.datavisor.cn") : "gw-picasso-dev.datavisor.cn";
  }
  
  public static String d() {
    if (f.b(b))
      try {
        String[] arrayOfString = b.split("\\.");
        int j = arrayOfString.length;
        int i = 1;
        if (j > 1) {
          j = arrayOfString.length;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("cdn-");
          stringBuilder.append(arrayOfString[arrayOfString.length - 2]);
          arrayOfString[j - 2] = stringBuilder.toString();
        } 
        return null;
      } finally {
        Exception exception = null;
      }  
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\f\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */