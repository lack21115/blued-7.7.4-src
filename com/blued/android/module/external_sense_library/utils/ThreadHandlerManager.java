package com.blued.android.module.external_sense_library.utils;

import android.os.HandlerThread;

public class ThreadHandlerManager {
  private static ThreadHandlerManager a;
  
  private HandlerThread b;
  
  private HandlerThread c;
  
  private ThreadHandlerManager() {
    c();
  }
  
  public static ThreadHandlerManager a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/external_sense_library/utils/ThreadHandlerManager.a : Lcom/blued/android/module/external_sense_library/utils/ThreadHandlerManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/external_sense_library/utils/ThreadHandlerManager
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/external_sense_library/utils/ThreadHandlerManager.a : Lcom/blued/android/module/external_sense_library/utils/ThreadHandlerManager;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/external_sense_library/utils/ThreadHandlerManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/external_sense_library/utils/ThreadHandlerManager.a : Lcom/blued/android/module/external_sense_library/utils/ThreadHandlerManager;
    //   25: ldc com/blued/android/module/external_sense_library/utils/ThreadHandlerManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/external_sense_library/utils/ThreadHandlerManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/external_sense_library/utils/ThreadHandlerManager.a : Lcom/blued/android/module/external_sense_library/utils/ThreadHandlerManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void c() {
    if (this.b == null) {
      this.b = new HandlerThread("data_thread");
      this.b.start();
    } 
    if (this.c == null) {
      this.c = new HandlerThread("log_thread");
      this.c.start();
    } 
  }
  
  public HandlerThread b() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_librar\\utils\ThreadHandlerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */