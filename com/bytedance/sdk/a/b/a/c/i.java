package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.s;
import com.bytedance.sdk.a.b.y;
import java.net.Proxy;

public final class i {
  public static String a(s params) {
    String str2 = params.h();
    String str3 = params.j();
    String str1 = str2;
    if (str3 != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append('?');
      stringBuilder.append(str3);
      str1 = stringBuilder.toString();
    } 
    return str1;
  }
  
  public static String a(y paramy, Proxy.Type paramType) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramy.b());
    stringBuilder.append(' ');
    if (b(paramy, paramType)) {
      stringBuilder.append(paramy.a());
    } else {
      stringBuilder.append(a(paramy.a()));
    } 
    stringBuilder.append(" HTTP/1.1");
    return stringBuilder.toString();
  }
  
  private static boolean b(y paramy, Proxy.Type paramType) {
    return (!paramy.g() && paramType == Proxy.Type.HTTP);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\c\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */