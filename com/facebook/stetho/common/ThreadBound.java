package com.facebook.stetho.common;

public interface ThreadBound {
  boolean checkThreadAccess();
  
  <V> V postAndWait(UncheckedCallable<V> paramUncheckedCallable);
  
  void postAndWait(Runnable paramRunnable);
  
  void postDelayed(Runnable paramRunnable, long paramLong);
  
  void removeCallbacks(Runnable paramRunnable);
  
  void verifyThreadAccess();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\ThreadBound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */