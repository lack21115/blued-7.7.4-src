package com.google.android.gms.vision;

public abstract class Detector {
  private final Object zzlft = new Object();
  
  private Detector$Processor zzlfu;
  
  public void release() {
    synchronized (this.zzlft) {
      if (this.zzlfu != null)
        this.zzlfu = null; 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\Detector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */