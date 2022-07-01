package com.jeremyliao.liveeventbus.utils;

import android.os.Looper;

public final class ThreadUtils {
  public static boolean isMainThread() {
    return (Looper.myLooper() == Looper.getMainLooper());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jeremyliao\liveeventbu\\utils\ThreadUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */