package com.qq.e.comm.plugin.util;

import java.util.concurrent.atomic.AtomicInteger;

public class ae {
  private static AtomicInteger a = new AtomicInteger();
  
  public static int a() {
    return a.incrementAndGet();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */