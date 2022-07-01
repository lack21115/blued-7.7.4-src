package com.loc;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public final class cb {
  public static boolean a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null) {
      String str = null;
      try {
        byte[] arrayOfByte;
        di di = new di();
        di.b.put("Content-Type", "application/octet-stream");
        Map<String, String> map = di.b;
        StringBuilder stringBuilder = new StringBuilder("lc_");
        stringBuilder.append(de.a());
        map.put("aps_c_src", Base64.encodeToString(stringBuilder.toString().getBytes(), 2));
        map = di.b;
        stringBuilder = new StringBuilder();
        stringBuilder.append(de.c());
        stringBuilder.append("*");
        stringBuilder.append(de.f());
        map.put("aps_c_key", Base64.encodeToString(stringBuilder.toString().getBytes(), 2));
        di.d = paramArrayOfbyte;
        if (bs.a) {
          str1 = "http://cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
        } else {
          if (bs.b) {
            str1 = "https://";
          } else {
            str1 = "http://";
          } 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str1);
          stringBuilder1.append("cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&");
          str1 = stringBuilder1.toString();
        } 
        di.a = str1;
        dj dj = cv.a().a(di);
        String str1 = str;
        if (dj != null) {
          str1 = str;
          if (dj.a == 200)
            arrayOfByte = dj.c; 
        } 
        if (arrayOfByte != null) {
          boolean bool = "true".equals(new String(arrayOfByte, StandardCharsets.UTF_8));
          if (bool)
            return true; 
        } 
      } catch (Exception exception) {
        dg.a(exception);
      } 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */