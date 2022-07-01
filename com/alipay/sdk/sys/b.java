package com.alipay.sdk.sys;

import android.content.Context;
import com.alipay.sdk.data.c;
import com.alipay.sdk.util.c;
import com.ta.utdid2.device.UTDevice;
import java.io.File;

public class b {
  private static b a;
  
  private Context b;
  
  public static b a() {
    if (a == null)
      a = new b(); 
    return a;
  }
  
  public static boolean d() {
    String[] arrayOfString = new String[10];
    arrayOfString[0] = "/system/app/Superuser.apk";
    arrayOfString[1] = "/sbin/su";
    arrayOfString[2] = "/system/bin/su";
    arrayOfString[3] = "/system/xbin/su";
    arrayOfString[4] = "/data/local/xbin/su";
    arrayOfString[5] = "/data/local/bin/su";
    arrayOfString[6] = "/system/sd/xbin/su";
    arrayOfString[7] = "/system/bin/failsafe/su";
    arrayOfString[8] = "/data/local/su";
    arrayOfString[9] = "/su/bin/su";
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      if ((new File(arrayOfString[i])).exists())
        return true; 
    } 
    return false;
  }
  
  public void a(Context paramContext) {
    c.b();
    this.b = paramContext.getApplicationContext();
  }
  
  public Context b() {
    return this.b;
  }
  
  public c c() {
    return c.b();
  }
  
  public String e() {
    try {
      return UTDevice.getUtdid(this.b);
    } finally {
      Exception exception = null;
      c.a(exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\sys\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */