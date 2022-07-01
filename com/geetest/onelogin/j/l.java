package com.geetest.onelogin.j;

import android.text.TextUtils;
import com.geetest.onelogin.e.a.f;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class l {
  public static String a() {
    Random random = new Random();
    List<String> list = Arrays.asList("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
    Collections.shuffle(list);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(System.nanoTime());
    stringBuilder.append(a(list));
    stringBuilder.append(random.nextInt(99999));
    String str2 = f.a(stringBuilder.toString());
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = UUID.randomUUID().toString(); 
    return str1;
  }
  
  public static String a(String paramString) {
    if (TextUtils.isEmpty(paramString) || paramString.length() < 16)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString.substring(0, 8));
    stringBuilder.append(paramString.substring(paramString.length() - 8, paramString.length()));
    return f.a(stringBuilder.toString()).substring(0, 16);
  }
  
  private static String a(List<String> paramList) {
    if (paramList == null)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<String> iterator = paramList.iterator();
    while (iterator.hasNext())
      stringBuilder.append(iterator.next()); 
    return stringBuilder.toString();
  }
  
  public static String b(String paramString) {
    if (TextUtils.isEmpty(paramString) || paramString.length() < 16)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString.substring(0, 8));
    stringBuilder.append(paramString.substring(paramString.length() - 8, paramString.length()));
    return f.a(stringBuilder.toString()).substring(paramString.length() - 8, paramString.length());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\j\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */