package com.ta.utdid2.a.a;

import android.os.Build;

public class c {
  public static boolean a() {
    int i = Build.VERSION.SDK_INT;
    boolean bool = true;
    if (i < 29) {
      if (Build.VERSION.CODENAME.length() == 1 && Build.VERSION.CODENAME.charAt(0) >= 'Q' && Build.VERSION.CODENAME.charAt(0) <= 'Z')
        return true; 
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\t\\utdid2\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */