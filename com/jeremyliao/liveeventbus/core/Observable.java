package com.jeremyliao.liveeventbus.core;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

public interface Observable<T> {
  void broadcast(T paramT);
  
  void broadcast(T paramT, boolean paramBoolean);
  
  void observe(LifecycleOwner paramLifecycleOwner, Observer<T> paramObserver);
  
  void observeForever(Observer<T> paramObserver);
  
  void observeSticky(LifecycleOwner paramLifecycleOwner, Observer<T> paramObserver);
  
  void observeStickyForever(Observer<T> paramObserver);
  
  void post(T paramT);
  
  void postDelay(LifecycleOwner paramLifecycleOwner, T paramT, long paramLong);
  
  void postDelay(T paramT, long paramLong);
  
  void postOrderly(T paramT);
  
  void removeObserver(Observer<T> paramObserver);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jeremyliao\liveeventbus\core\Observable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */