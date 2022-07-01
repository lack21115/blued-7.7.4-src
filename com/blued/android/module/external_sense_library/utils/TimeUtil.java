package com.blued.android.module.external_sense_library.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
  private static final SimpleDateFormat a = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss:SSS");
  
  private static final SimpleDateFormat b = new SimpleDateFormat("HH:mm:ss.SSS");
  
  public static String a() {
    return a.format(new Date());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_librar\\utils\TimeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */