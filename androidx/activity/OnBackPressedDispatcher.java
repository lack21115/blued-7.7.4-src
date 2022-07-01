package androidx.activity;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {
  final ArrayDeque<OnBackPressedCallback> a = new ArrayDeque<OnBackPressedCallback>();
  
  private final Runnable b;
  
  public OnBackPressedDispatcher() {
    this(null);
  }
  
  public OnBackPressedDispatcher(Runnable paramRunnable) {
    this.b = paramRunnable;
  }
  
  Cancellable a(OnBackPressedCallback paramOnBackPressedCallback) {
    this.a.add(paramOnBackPressedCallback);
    OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedCancellable(this, paramOnBackPressedCallback);
    paramOnBackPressedCallback.a(onBackPressedCancellable);
    return onBackPressedCancellable;
  }
  
  public void addCallback(OnBackPressedCallback paramOnBackPressedCallback) {
    a(paramOnBackPressedCallback);
  }
  
  public void addCallback(LifecycleOwner paramLifecycleOwner, OnBackPressedCallback paramOnBackPressedCallback) {
    Lifecycle lifecycle = paramLifecycleOwner.getLifecycle();
    if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED)
      return; 
    paramOnBackPressedCallback.a(new LifecycleOnBackPressedCancellable(this, lifecycle, paramOnBackPressedCallback));
  }
  
  public boolean hasEnabledCallbacks() {
    Iterator<OnBackPressedCallback> iterator = this.a.descendingIterator();
    while (iterator.hasNext()) {
      if (((OnBackPressedCallback)iterator.next()).isEnabled())
        return true; 
    } 
    return false;
  }
  
  public void onBackPressed() {
    Iterator<OnBackPressedCallback> iterator = this.a.descendingIterator();
    while (iterator.hasNext()) {
      OnBackPressedCallback onBackPressedCallback = iterator.next();
      if (onBackPressedCallback.isEnabled()) {
        onBackPressedCallback.handleOnBackPressed();
        return;
      } 
    } 
    Runnable runnable = this.b;
    if (runnable != null)
      runnable.run(); 
  }
  
  class LifecycleOnBackPressedCancellable implements Cancellable, LifecycleEventObserver {
    private final Lifecycle b;
    
    private final OnBackPressedCallback c;
    
    private Cancellable d;
    
    LifecycleOnBackPressedCancellable(OnBackPressedDispatcher this$0, Lifecycle param1Lifecycle, OnBackPressedCallback param1OnBackPressedCallback) {
      this.b = param1Lifecycle;
      this.c = param1OnBackPressedCallback;
      param1Lifecycle.addObserver((LifecycleObserver)this);
    }
    
    public void cancel() {
      this.b.removeObserver((LifecycleObserver)this);
      this.c.b(this);
      Cancellable cancellable = this.d;
      if (cancellable != null) {
        cancellable.cancel();
        this.d = null;
      } 
    }
    
    public void onStateChanged(LifecycleOwner param1LifecycleOwner, Lifecycle.Event param1Event) {
      if (param1Event == Lifecycle.Event.ON_START) {
        this.d = this.a.a(this.c);
        return;
      } 
      if (param1Event == Lifecycle.Event.ON_STOP) {
        Cancellable cancellable = this.d;
        if (cancellable != null) {
          cancellable.cancel();
          return;
        } 
      } else if (param1Event == Lifecycle.Event.ON_DESTROY) {
        cancel();
      } 
    }
  }
  
  class OnBackPressedCancellable implements Cancellable {
    private final OnBackPressedCallback b;
    
    OnBackPressedCancellable(OnBackPressedDispatcher this$0, OnBackPressedCallback param1OnBackPressedCallback) {
      this.b = param1OnBackPressedCallback;
    }
    
    public void cancel() {
      this.a.a.remove(this.b);
      this.b.b(this);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\activity\OnBackPressedDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */