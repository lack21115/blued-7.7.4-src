package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;

public class AuthMap {
  private static int b = 0;
  
  public static AuthMap sInstance;
  
  public final String KEY_CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  
  public HashMap<String, Auth> authMap = new HashMap<String, Auth>();
  
  private String a(String paramString1, String paramString2) {
    if (a || paramString1.length() % 2 == 0) {
      StringBuilder stringBuilder = new StringBuilder();
      int k = paramString2.length();
      int m = paramString1.length() / 2;
      int i = 0;
      int j = 0;
      while (i < m) {
        int n = i * 2;
        stringBuilder.append((char)(Integer.parseInt(paramString1.substring(n, n + 2), 16) ^ paramString2.charAt(j)));
        j = (j + 1) % k;
        i++;
      } 
      return stringBuilder.toString();
    } 
    throw new AssertionError();
  }
  
  public static AuthMap getInstance() {
    if (sInstance == null)
      sInstance = new AuthMap(); 
    return sInstance;
  }
  
  public static int getSerial() {
    int i = b + 1;
    b = i;
    return i;
  }
  
  public String decode(String paramString1, String paramString2) {
    return a(paramString1, paramString2);
  }
  
  public Auth get(String paramString) {
    return this.authMap.get(paramString);
  }
  
  public String makeKey() {
    int j = (int)Math.ceil(Math.random() * 20.0D + 3.0D);
    char[] arrayOfChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    int k = arrayOfChar.length;
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < j; i++)
      stringBuffer.append(arrayOfChar[(int)(Math.random() * k)]); 
    return stringBuffer.toString();
  }
  
  public void remove(String paramString) {
    this.authMap.remove(paramString);
  }
  
  public String set(Auth paramAuth) {
    StringBuilder stringBuilder;
    int i = getSerial();
    try {
      HashMap<String, Auth> hashMap = this.authMap;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("");
      stringBuilder1.append(i);
      hashMap.put(stringBuilder1.toString(), paramAuth);
    } finally {
      paramAuth = null;
    } 
    stringBuilder.append("");
    stringBuilder.append(i);
    return stringBuilder.toString();
  }
  
  public static class Auth {
    public AuthDialog dialog;
    
    public String key;
    
    public IUiListener listener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\auth\AuthMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */