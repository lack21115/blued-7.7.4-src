package com.datavisor.vangogh.f.h;

import android.content.Context;
import com.datavisor.vangogh.f.d;
import com.datavisor.vangogh.f.f;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Map;

public class a {
  private static String a(BufferedInputStream paramBufferedInputStream) {
    if (paramBufferedInputStream == null)
      return ""; 
    byte[] arrayOfByte = new byte[8192];
    StringBuilder stringBuilder = new StringBuilder();
    try {
      while (true) {
        int i = paramBufferedInputStream.read(arrayOfByte);
        if (i != -1) {
          if (i > 0)
            stringBuilder.append(new String(arrayOfByte, 0, i)); 
          continue;
        } 
        break;
      } 
    } finally {}
    String str2 = stringBuilder.toString();
    String str1 = str2;
    if (str2.length() > 0) {
      str1 = str2;
      if (str2.substring(str2.length() - 1, str2.length()).equals("\n"))
        str1 = str2.substring(0, str2.length() - 1); 
    } 
    return str1;
  }
  
  public static String a(String paramString) {
    try {
      Class<?> clazz = Context.class.getClassLoader().loadClass("android.os.SystemProperties");
      return (String)method.invoke(clazz, new Object[] { paramString });
    } finally {
      paramString = null;
      d.a((Throwable)paramString);
    } 
  }
  
  public static Map<String, Integer> a() {
    String str = b("/proc/self/cgroup");
    if (str != null) {
      if (str.length() == 0)
        return null; 
      int k = str.lastIndexOf("uid");
      int j = str.lastIndexOf("/pid");
      if (k < 0)
        return null; 
      int i = j;
      if (j <= 0)
        i = str.length(); 
      str = str.substring(k + 4, i);
      try {
        str = str.replaceAll("\n", "");
        return null;
      } finally {
        str = null;
      } 
    } 
    return null;
  }
  
  public static String b(String paramString) {
    StringBuilder stringBuilder = new StringBuilder("");
    try {
      FileInputStream fileInputStream = new FileInputStream(paramString);
    } finally {
      paramString = null;
    } 
    if (paramString != null)
      try {
        return null;
      } finally {
        paramString = null;
      }  
    return null;
  }
  
  public static String c(String paramString) {
    if (f.a(paramString)) {
      d.a("command is empty");
      return null;
    } 
    try {
      Process process = Runtime.getRuntime().exec(paramString);
    } finally {
      paramString = null;
    } 
    String str2 = null;
    String str3 = str2;
    String str1 = paramString;
    paramString = str3;
    if (str2 != null)
      try {
        str2.close();
      } finally {} 
    if (paramString != null)
      try {
        paramString.close();
      } finally {} 
    if (str1 != null)
      str1.destroy(); 
    return null;
  }
  
  public static String d(String paramString) {
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
      return null;
    } finally {
      paramString = null;
    } 
    if (paramString != null)
      try {
        return null;
      } finally {
        paramString = null;
      }  
  }
  
  private static boolean e(String paramString) {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\f\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */