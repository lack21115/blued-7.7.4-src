package androidx.lifecycle;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BaseLiveData<T> extends MutableLiveData<T> {
  public static final int START_VERSION = -1;
  
  private Object callMethodPutIfAbsent(Object paramObject1, Object paramObject2) throws Exception {
    Object object = getFieldObservers();
    Method method = object.getClass().getDeclaredMethod("putIfAbsent", new Class[] { Object.class, Object.class });
    method.setAccessible(true);
    return method.invoke(object, new Object[] { paramObject1, paramObject2 });
  }
  
  private Object getFieldObservers() throws Exception {
    Field field = LiveData.class.getDeclaredField("mObservers");
    field.setAccessible(true);
    return field.get(this);
  }
  
  public int getVersion() {
    return super.getVersion();
  }
  
  public void observe(LifecycleOwner paramLifecycleOwner, Observer<? super T> paramObserver) {
    if (paramLifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED)
      return; 
    try {
      ExternalLifecycleBoundObserver externalLifecycleBoundObserver = new ExternalLifecycleBoundObserver(paramLifecycleOwner, paramObserver);
      LiveData.LifecycleBoundObserver lifecycleBoundObserver = (LiveData.LifecycleBoundObserver)callMethodPutIfAbsent(paramObserver, externalLifecycleBoundObserver);
      if (lifecycleBoundObserver == null || lifecycleBoundObserver.isAttachedTo(paramLifecycleOwner)) {
        if (lifecycleBoundObserver != null)
          return; 
        paramLifecycleOwner.getLifecycle().addObserver(externalLifecycleBoundObserver);
        return;
      } 
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  protected Lifecycle.State observerActiveLevel() {
    return Lifecycle.State.CREATED;
  }
  
  class ExternalLifecycleBoundObserver extends LiveData<T>.LifecycleBoundObserver {
    ExternalLifecycleBoundObserver(LifecycleOwner param1LifecycleOwner, Observer<? super T> param1Observer) {
      super(param1LifecycleOwner, param1Observer);
    }
    
    boolean shouldBeActive() {
      return this.mOwner.getLifecycle().getCurrentState().isAtLeast(BaseLiveData.this.observerActiveLevel());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\lifecycle\BaseLiveData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */