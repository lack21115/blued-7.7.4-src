package com.geetest.onelogin.e.a;

import java.util.Random;

public final class g {
  public static String a(int paramInt) {
    StringBuffer stringBuffer = new StringBuffer();
    Random random = new Random();
    for (int i = 0; i < paramInt; i++)
      stringBuffer.append("0123456789abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(36))); 
    return stringBuffer.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\e\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */