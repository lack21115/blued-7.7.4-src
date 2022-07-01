package com.qq.e.comm.plugin.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class t {
  public static final ExecutorService a = Executors.newCachedThreadPool(new ThreadFactory() {
        public Thread newThread(Runnable param1Runnable) {
          return new Thread(param1Runnable, "GDT_IO_THREAD");
        }
      });
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */