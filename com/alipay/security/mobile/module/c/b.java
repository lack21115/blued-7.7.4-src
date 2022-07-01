package com.alipay.security.mobile.module.c;

import com.alipay.security.mobile.module.a.a;
import java.io.File;

public final class b {
  public static String a(String paramString) {
    String str1;
    String str2;
    try {
      str1 = f.a(paramString);
    } finally {
      Exception exception = null;
    } 
    if (a.a(str1)) {
      StringBuilder stringBuilder = new StringBuilder(".SystemConfig");
      stringBuilder.append(File.separator);
      stringBuilder.append(paramString);
      str2 = c.a(stringBuilder.toString());
    } 
    return str2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */