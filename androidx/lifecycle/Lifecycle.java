package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

public abstract class Lifecycle {
  AtomicReference<Object> mInternalScopeRef = new AtomicReference();
  
  public abstract void addObserver(LifecycleObserver paramLifecycleObserver);
  
  public abstract State getCurrentState();
  
  public abstract void removeObserver(LifecycleObserver paramLifecycleObserver);
  
  public enum Event {
    ON_ANY, ON_CREATE, ON_DESTROY, ON_PAUSE, ON_RESUME, ON_START, ON_STOP;
    
    static {
      ON_PAUSE = new Event("ON_PAUSE", 3);
      ON_STOP = new Event("ON_STOP", 4);
      ON_DESTROY = new Event("ON_DESTROY", 5);
      ON_ANY = new Event("ON_ANY", 6);
      $VALUES = new Event[] { ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY, ON_ANY };
    }
  }
  
  public enum State {
    DESTROYED, CREATED, INITIALIZED, RESUMED, STARTED;
    
    static {
      RESUMED = new State("RESUMED", 4);
      $VALUES = new State[] { DESTROYED, INITIALIZED, CREATED, STARTED, RESUMED };
    }
    
    public boolean isAtLeast(State param1State) {
      return (compareTo(param1State) >= 0);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\lifecycle\Lifecycle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */