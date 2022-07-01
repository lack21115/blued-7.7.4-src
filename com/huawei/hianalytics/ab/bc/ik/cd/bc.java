package com.huawei.hianalytics.ab.bc.ik.cd;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class bc {
  private static bc bc = new bc();
  
  private static bc cd = new bc();
  
  private ThreadPoolExecutor ab;
  
  private bc() {
    LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue(5000);
    this.ab = new ThreadPoolExecutor(0, 1, 60000L, TimeUnit.MILLISECONDS, linkedBlockingQueue);
  }
  
  public static bc ab() {
    return cd;
  }
  
  public static bc bc() {
    return bc;
  }
  
  public void ab(ab paramab) {
    try {
      this.ab.execute(new ab(paramab));
      return;
    } catch (RejectedExecutionException rejectedExecutionException) {
      com.huawei.hianalytics.ab.bc.ef.ab.ef("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
      return;
    } 
  }
  
  static {
    new bc();
    new bc();
  }
  
  static class ab implements Runnable {
    private Runnable ab;
    
    public ab(Runnable param1Runnable) {
      this.ab = param1Runnable;
    }
    
    public void run() {
      Runnable runnable = this.ab;
      if (runnable != null)
        try {
          runnable.run();
          return;
        } catch (Exception exception) {
          com.huawei.hianalytics.ab.bc.ef.ab.ef("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
        }  
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\ik\cd\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */