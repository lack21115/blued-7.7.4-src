package com.datavisor.vangogh.f.g;

import com.datavisor.vangogh.f.d;
import com.datavisor.vangogh.f.f;
import java.security.MessageDigest;

public class a {
  public static String a(String paramString) {
    try {
      if (f.a(paramString))
        return null; 
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
      messageDigest.update(paramString.getBytes("UTF-8"));
      byte[] arrayOfByte = messageDigest.digest();
      StringBuilder stringBuilder = new StringBuilder();
      int i = 0;
      while (true) {
        int j = arrayOfByte.length;
        if (i < j) {
          stringBuilder.append(String.format("%02x", new Object[] { Byte.valueOf(arrayOfByte[i]) }));
          i++;
          continue;
        } 
        return stringBuilder.toString();
      } 
    } catch (Exception exception) {
      d.a(exception);
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\f\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */