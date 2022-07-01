package com.huawei.hms.support.api.push.utils.common;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ReceiverThreadPoolExecutor {
  public static final Object LOCK_INST = new Object();
  
  public static ThreadPoolExecutor myExecutor = new ThreadPoolExecutor(1, 50, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
  
  public static ThreadPoolExecutor getInstance() {
    synchronized (LOCK_INST) {
      return myExecutor;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\pus\\utils\common\ReceiverThreadPoolExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */