package com.ishumei.l111l11111Il;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ishumei.l1111l111111Il.l111l11111lIl;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

public final class l11l1111Il {
  private static String l1111l111111Il() {
    byte b1;
    byte b2 = 0;
    try {
      String str = l1111l111111Il("cat /proc/self/cgroup");
      b1 = b2;
      if (!TextUtils.isEmpty(str)) {
        int k = str.lastIndexOf("uid");
        int j = str.lastIndexOf("/pid");
        b1 = b2;
        if (k >= 0) {
          b1 = j;
          if (j <= 0)
            b1 = str.length(); 
          str = str.substring(k + 4, b1).replaceAll("\n", "");
          if (str == null || str.length() == 0) {
            j = 0;
          } else {
            for (b1 = 0; b1 < str.length(); b1++) {
              if (!Character.isDigit(str.charAt(b1)))
                // Byte code: goto -> 201 
            } 
            j = 1;
          } 
          b1 = b2;
          if (j != 0)
            b1 = Integer.valueOf(str).intValue(); 
        } 
      } 
    } catch (Exception exception) {
      b1 = b2;
    } 
    int i = b1;
    if (b1 == 0)
      try {
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        i = b1;
        if (context != null)
          i = (context.getApplicationInfo()).uid; 
      } catch (Exception exception) {
        i = b1;
      }  
    return (i == 0) ? null : l1111l111111Il(i);
  }
  
  private static String l1111l111111Il(int paramInt) {
    if (Build.VERSION.SDK_INT > 27)
      return String.format(Locale.CHINA, "u0_a%d", new Object[] { Integer.valueOf(paramInt - 10000) }); 
    try {
      Field field = Class.forName("libcore.io.Libcore").getDeclaredField("os");
      if (!field.isAccessible())
        field.setAccessible(true); 
      Object object = field.get((Object)null);
      if (object != null) {
        Method method = object.getClass().getMethod("getpwuid", new Class[] { int.class });
        if (method != null) {
          if (!method.isAccessible())
            method.setAccessible(true); 
          object = method.invoke(object, new Object[] { Integer.valueOf(paramInt) });
          if (object != null) {
            Field field1 = object.getClass().getDeclaredField("pw_name");
            if (!field1.isAccessible())
              field1.setAccessible(true); 
            return (String)field1.get(object);
          } 
        } 
      } 
      return null;
    } catch (Exception exception) {
      return String.format(Locale.CHINA, "u0_a%d", new Object[] { Integer.valueOf(paramInt - 10000) });
    } 
  }
  
  private static String l1111l111111Il(BufferedInputStream paramBufferedInputStream) {
    byte[] arrayOfByte = new byte[512];
    StringBuilder stringBuilder = new StringBuilder();
    try {
      while (true) {
        int i = paramBufferedInputStream.read(arrayOfByte);
        if (i > 0)
          stringBuilder.append(new String(arrayOfByte, 0, i)); 
        if (i >= 512)
          continue; 
        break;
      } 
    } catch (Exception exception) {}
    return stringBuilder.toString();
  }
  
  private static String l1111l111111Il(String paramString) {
    Process process;
    String str = null;
    try {
    
    } catch (Exception exception1) {
    
    } finally {
      process = null;
      if (exception != null)
        try {
          exception.close();
        } catch (IOException iOException) {} 
      if (process != null)
        process.destroy(); 
    } 
    if (paramString != null)
      try {
        paramString.close();
      } catch (IOException iOException) {} 
    if (process != null)
      process.destroy(); 
    return null;
  }
  
  public static void l1111l111111Il(l111l11111lIl paraml111l11111lIl) {
    try {
      String str1 = l1111l111111Il();
      if (TextUtils.isEmpty(str1))
        return; 
      String str2 = l1111l111111Il("ps");
      if (TextUtils.isEmpty(str2))
        return; 
      if ((str2.split("\n")).length <= 0)
        return; 
      paraml111l11111lIl.l111l11l11Ill(str1);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private static void l111l11111lIl(l111l11111lIl paraml111l11111lIl) {
    try {
      String str1 = l1111l111111Il();
      if (TextUtils.isEmpty(str1))
        return; 
      String str2 = l1111l111111Il("ps");
      if (TextUtils.isEmpty(str2))
        return; 
      if ((str2.split("\n")).length <= 0)
        return; 
      paraml111l11111lIl.l111l11l11Ill(str1);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private static boolean l111l11111lIl(String paramString) {
    if (paramString != null) {
      if (paramString.length() == 0)
        return false; 
      for (int i = 0; i < paramString.length(); i++) {
        if (!Character.isDigit(paramString.charAt(i)))
          return false; 
      } 
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l11l1111Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */