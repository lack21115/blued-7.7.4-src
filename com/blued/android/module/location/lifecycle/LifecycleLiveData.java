package com.blued.android.module.location.lifecycle;

import androidx.lifecycle.BaseLiveData;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

public class LifecycleLiveData<T> extends BaseLiveData<T> {
  public void observe(LifecycleOwner paramLifecycleOwner, Observer<? super T> paramObserver) {
    super.observe(paramLifecycleOwner, paramObserver);
  }
  
  public Lifecycle.State observerActiveLevel() {
    return Lifecycle.State.CREATED;
  }
  
  public void removeObserver(Observer<? super T> paramObserver) {
    super.removeObserver(paramObserver);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\location\lifecycle\LifecycleLiveData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */