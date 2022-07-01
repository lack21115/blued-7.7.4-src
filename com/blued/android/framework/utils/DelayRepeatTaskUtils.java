package com.blued.android.framework.utils;

import java.util.WeakHashMap;

public class DelayRepeatTaskUtils {
  private static WeakHashMap<String, Runnable> a = new WeakHashMap<String, Runnable>();
  
  public static void a(String paramString, Runnable paramRunnable) {
    a(paramString, paramRunnable, 200);
  }
  
  public static void a(String paramString, Runnable paramRunnable, int paramInt) {
    ThreadUtils.a(new -$$Lambda$DelayRepeatTaskUtils$0V4j3aJtDpZv5t14Stf_15-izAQ(paramString, paramRunnable, paramInt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\DelayRepeatTaskUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */