package com.huawei.agconnect.config.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class f implements b {
  private final Context a;
  
  private final String b;
  
  f(Context paramContext, String paramString) {
    this.a = paramContext;
    this.b = paramString;
  }
  
  private static String a(String paramString) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("agc_");
      stringBuilder.append(c.a(a(paramString.getBytes("UTF-8"))));
      return stringBuilder.toString();
    } catch (UnsupportedEncodingException|NoSuchAlgorithmException unsupportedEncodingException) {
      return "";
    } 
  }
  
  private static byte[] a(byte[] paramArrayOfbyte) throws NoSuchAlgorithmException {
    return MessageDigest.getInstance("SHA-256").digest(paramArrayOfbyte);
  }
  
  public String a(String paramString1, String paramString2) {
    paramString1 = a(paramString1);
    if (TextUtils.isEmpty(paramString1))
      return paramString2; 
    int i = this.a.getResources().getIdentifier(paramString1, "string", this.b);
    if (i == 0)
      return paramString2; 
    try {
      return this.a.getResources().getString(i);
    } catch (android.content.res.Resources.NotFoundException notFoundException) {
      return paramString2;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\agconnect\config\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */