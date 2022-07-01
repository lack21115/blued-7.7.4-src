package com.ishumei.l111l11111Il;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import com.ishumei.l111l1111llIl.l111l1111l1Il;
import com.ishumei.l111l1111llIl.l111l1111lI1l;
import java.util.ArrayList;
import java.util.Collections;

public final class l11l1111I11l {
  public static String l1111l111111Il() {
    String str = "";
    try {
      Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
      if (context != null) {
        str = l111l1111lI1l.l111l11111Il("9e919b8d90969bd18f8d9089969b9a8dd1ac9a8b8b9691988cdbac9a9c8a8d9a");
        String str1 = l111l1111lI1l.l111l11111Il("989a8bac8b8d969198");
        ContentResolver contentResolver = context.getContentResolver();
        String str2 = l111l1111lI1l.l111l11111Il("9e919b8d90969ba0969b");
        str = (String)l111l1111l1Il.l1111l111111Il(str, str1, new Class[] { ContentResolver.class, String.class }, new Object[] { contentResolver, str2 });
        if (str == null)
          return ""; 
      } 
      return str;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public static int l111l11111I1l() {
    Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
    if (context == null)
      return -1; 
    try {
      String str1 = l111l1111lI1l.l111l11111Il("9e919b8d90969bd18f8d9089969b9a8dd1ac9a8b8b9691988cdbac868c8b9a92");
      String str2 = l111l1111lI1l.l111l11111Il("989a8bb6918b");
      ContentResolver contentResolver = context.getContentResolver();
      String str3 = l111l1111lI1l.l111l11111Il("8c9c8d9a9a91a09d8d9698978b919a8c8c");
      return ((Integer)l111l1111l1Il.l1111l111111Il(str1, str2, new Class[] { ContentResolver.class, String.class }, new Object[] { contentResolver, str3 })).intValue();
    } catch (SecurityException securityException) {
      return -1001;
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  public static int l111l11111Il() {
    boolean bool;
    Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
    if (context == null)
      return 0; 
    if (Settings.Secure.getInt(context.getContentResolver(), "mock_location", 0) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool ? 1 : 0;
  }
  
  public static long l111l11111lIl() {
    try {
      ArrayList<Long> arrayList = new ArrayList();
      for (int i = 0; i < 11; i++)
        arrayList.add(Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime())); 
      Collections.sort(arrayList);
      return ((Long)arrayList.get(5)).longValue();
    } catch (Exception exception) {
      return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    } 
  }
  
  public static int l111l1111l1Il() {
    Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
    int i = -1;
    if (context == null)
      return -1; 
    if (Build.VERSION.SDK_INT >= 17)
      try {
        return Settings.Global.getInt(context.getContentResolver(), "wifi_connected_mac_randomization_enabled");
      } finally {
        context = null;
      }  
    return i;
  }
  
  private static long l111l1111llIl() {
    return System.currentTimeMillis() - SystemClock.elapsedRealtime();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l11l1111I11l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */