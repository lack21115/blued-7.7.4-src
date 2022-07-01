package com.cmic.sso.sdk.utils;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class s {
  private static String a(String[] paramArrayOfString) {
    StringBuilder stringBuilder = new StringBuilder();
    ProcessBuilder processBuilder = new ProcessBuilder(paramArrayOfString);
    try {
      Process process = processBuilder.start();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
      while (true) {
        String str = bufferedReader.readLine();
        if (str != null) {
          stringBuilder.append(str);
          continue;
        } 
        process.getInputStream().close();
        process.destroy();
        return stringBuilder.toString();
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return stringBuilder.toString();
  }
  
  public static boolean a() {
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "/system/xbin/";
    arrayOfString[1] = "/system/bin/";
    arrayOfString[2] = "/system/sbin/";
    arrayOfString[3] = "/sbin/";
    arrayOfString[4] = "/vendor/bin/";
    arrayOfString[5] = "/su/bin/";
    boolean bool = false;
    try {
      int j = arrayOfString.length;
      for (int i = 0; i < j; i++) {
        String str = arrayOfString[i];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("su");
        str = stringBuilder.toString();
        if ((new File(str)).exists()) {
          String str1 = a(new String[] { "ls", "-l", str });
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("isRooted=");
          stringBuilder1.append(str1);
          f.b("cyb", stringBuilder1.toString());
          boolean bool1 = bool;
          if (!TextUtils.isEmpty(str1)) {
            i = str1.indexOf("root");
            j = str1.lastIndexOf("root");
            bool1 = bool;
            if (i != j)
              bool1 = true; 
          } 
          return bool1;
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */