package com.blued.android.module.location.lifecycle;

import androidx.lifecycle.Observer;

public class ObserverWrapper<T> implements Observer<T> {
  private final Observer<T> a;
  
  private boolean b = false;
  
  ObserverWrapper(Observer<T> paramObserver) {
    this.a = paramObserver;
  }
  
  public void a(boolean paramBoolean) {
    this.b = paramBoolean;
  }
  
  public void onChanged(T paramT) {
    if (this.b) {
      this.b = false;
      return;
    } 
    try {
      this.a.onChanged(paramT);
      return;
    } catch (ClassCastException classCastException) {
      classCastException.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\location\lifecycle\ObserverWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */