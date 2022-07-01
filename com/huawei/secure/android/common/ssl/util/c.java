package com.huawei.secure.android.common.ssl.util;

import android.content.Context;

public class c {
  private static Context a;
  
  public static Context a() {
    return a;
  }
  
  public static void a(Context paramContext) {
    if (paramContext != null && a == null)
      a = paramContext.getApplicationContext(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\ss\\util\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */