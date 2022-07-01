package com.facebook.stetho.inspector.network;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;

final class AsyncPrettyPrinterExecutorHolder {
  private static ExecutorService sExecutorService;
  
  public static void ensureInitialized() {
    if (sExecutorService == null)
      sExecutorService = Executors.newCachedThreadPool(); 
  }
  
  @Nullable
  public static ExecutorService getExecutorService() {
    return sExecutorService;
  }
  
  public static void shutdown() {
    sExecutorService.shutdown();
    sExecutorService = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\network\AsyncPrettyPrinterExecutorHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */