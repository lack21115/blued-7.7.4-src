package com.soft.blued.model;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

public class SingleLiveEvent<T> extends MutableLiveData<T> {
  private final AtomicBoolean mPending = new AtomicBoolean(false);
  
  public void observe(LifecycleOwner paramLifecycleOwner, final Observer<? super T> observer) {
    super.observe(paramLifecycleOwner, new Observer<T>() {
          public void onChanged(T param1T) {
            if (SingleLiveEvent.this.mPending.compareAndSet(true, false))
              observer.onChanged(param1T); 
          }
        });
  }
  
  public void setValue(T paramT) {
    this.mPending.set(true);
    super.setValue(paramT);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\model\SingleLiveEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */