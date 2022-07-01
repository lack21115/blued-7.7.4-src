package com.geetest.onelogin.j;

import android.os.Environment;

public class m {
  public static boolean a() {
    try {
      return "mounted".equals(Environment.getExternalStorageState());
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public static String b() {
    try {
      return Environment.getExternalStorageDirectory().getAbsolutePath();
    } catch (Exception exception) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\j\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */