package com.blued.android.module.location.lifecycle;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.module.location.utils.ThreadUtils;
import java.util.HashMap;
import java.util.Map;

public class LiveEvent<T> implements Observable<T> {
  private final String a;
  
  private final LifecycleLiveData<T> b;
  
  private final Map<Observer, ObserverWrapper<T>> c = new HashMap<Observer, ObserverWrapper<T>>();
  
  public LiveEvent(String paramString) {
    this.a = paramString;
    this.b = new LifecycleLiveData<T>();
  }
  
  private void a(Observer<T> paramObserver) {
    Observer<T> observer = paramObserver;
    if (this.c.containsKey(paramObserver))
      observer = this.c.remove(paramObserver); 
    this.b.removeObserver(observer);
  }
  
  private void b(LifecycleOwner paramLifecycleOwner, Observer<T> paramObserver) {
    boolean bool;
    paramObserver = new ObserverWrapper<T>(paramObserver);
    if (this.b.getVersion() > -1) {
      bool = true;
    } else {
      bool = false;
    } 
    paramObserver.a(bool);
    this.b.observe(paramLifecycleOwner, paramObserver);
  }
  
  private void b(T paramT) {
    this.b.setValue(paramT);
  }
  
  public void a(LifecycleOwner paramLifecycleOwner, Observer<T> paramObserver) {
    if (ThreadUtils.a()) {
      b(paramLifecycleOwner, paramObserver);
      return;
    } 
    ThreadUtils.a(new Runnable(this, paramLifecycleOwner, paramObserver) {
          public void run() {
            LiveEvent.a(this.c, this.a, this.b);
          }
        });
  }
  
  public void a(T paramT) {
    if (ThreadUtils.a()) {
      b(paramT);
      return;
    } 
    ThreadUtils.a(new PostValueTask(this, paramT));
  }
  
  class PostValueTask implements Runnable {
    private Object b;
    
    public PostValueTask(LiveEvent this$0, Object param1Object) {
      this.b = param1Object;
    }
    
    public void run() {
      LiveEvent.a(this.a, this.b);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\location\lifecycle\LiveEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */