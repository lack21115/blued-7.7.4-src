package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

public class e {
  private static HashMap<String, ArrayList<String>> a = new HashMap<String, ArrayList<String>>();
  
  public static String a(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    ArrayList<String> arrayList = a(paramContext, "SHA1");
    if (arrayList != null && arrayList.size() != 0)
      for (int i = 0; i < arrayList.size(); i++) {
        stringBuilder.append(arrayList.get(i));
        if (i < arrayList.size() - 1)
          stringBuilder.append(","); 
      }  
    return stringBuilder.toString();
  }
  
  private static String a(Signature paramSignature, String paramString) {
    byte[] arrayOfByte = paramSignature.toByteArray();
    try {
      MessageDigest messageDigest = MessageDigest.getInstance(paramString);
      if (messageDigest != null) {
        arrayOfByte = messageDigest.digest(arrayOfByte);
        StringBuilder stringBuilder = new StringBuilder();
        int j = arrayOfByte.length;
        for (int i = 0; i < j; i++) {
          stringBuilder.append(Integer.toHexString(arrayOfByte[i] & 0xFF | 0x100).substring(1, 3).toUpperCase());
          stringBuilder.append(":");
        } 
        return stringBuilder.substring(0, stringBuilder.length() - 1).toString();
      } 
    } catch (Exception exception) {
      t.b(exception.toString());
    } 
    return "error!";
  }
  
  public static ArrayList<String> a(Context paramContext, String paramString) {
    ArrayList<String> arrayList = null;
    if (paramContext != null) {
      if (paramString == null)
        return null; 
      String str = paramContext.getPackageName();
      if (str == null)
        return null; 
      if (a.get(paramString) != null)
        return a.get(paramString); 
      arrayList = new ArrayList();
      try {
        for (Signature signature : b(paramContext, str)) {
          String str1 = "error!";
          if ("MD5".equals(paramString)) {
            str1 = a(signature, "MD5");
          } else if ("SHA1".equals(paramString)) {
            str1 = a(signature, "SHA1");
          } else if ("SHA256".equals(paramString)) {
            str1 = a(signature, "SHA256");
          } 
          arrayList.add(str1);
        } 
      } catch (Exception exception) {
        t.b(exception.toString());
      } 
      a.put(paramString, arrayList);
    } 
    return arrayList;
  }
  
  private static Signature[] b(Context paramContext, String paramString) {
    try {
      return (paramContext.getPackageManager().getPackageInfo(paramString, 64)).signatures;
    } catch (Exception exception) {
      t.b(exception.toString());
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */