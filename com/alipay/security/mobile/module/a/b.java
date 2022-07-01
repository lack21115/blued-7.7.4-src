package com.alipay.security.mobile.module.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public final class b {
  public static String a(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    String str = null;
    try {
      BufferedReader bufferedReader;
      File file = new File(paramString1, paramString2);
      if (!file.exists())
        return null; 
    } catch (IOException iOException) {
    
    } finally {
      paramString2 = str;
      if (paramString2 != null)
        try {
          paramString2.close();
        } finally {} 
    } 
    if (paramString1 != null) {
      paramString2 = paramString1;
    } else {
      return stringBuilder.toString();
    } 
    try {
      paramString2.close();
    } finally {}
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */