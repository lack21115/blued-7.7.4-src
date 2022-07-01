package com.blued.android.module.player;

import android.os.Environment;

public class Config {
  public static final String a = Environment.getExternalStorageDirectory().getAbsolutePath();
  
  public static final String b;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("/TX/PLDroidPlayer");
    b = stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */