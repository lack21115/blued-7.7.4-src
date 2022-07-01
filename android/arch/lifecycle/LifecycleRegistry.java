package android.arch.lifecycle;

import android.arch.core.internal.FastSafeIterableMap;
import android.arch.core.internal.SafeIterableMap;
import java.util.ArrayList;
import java.util.Map;

public final class LifecycleRegistry extends Lifecycle {
  private int mAddingObserverCounter = 0;
  
  private boolean mHandlingEvent = false;
  
  private final LifecycleOwner mLifecycleOwner;
  
  private boolean mNewEventOccurred = false;
  
  private FastSafeIterableMap mObserverMap = new FastSafeIterableMap();
  
  private ArrayList mParentStates = new ArrayList();
  
  public Lifecycle$State mState;
  
  public LifecycleRegistry(LifecycleOwner paramLifecycleOwner) {
    this.mLifecycleOwner = paramLifecycleOwner;
    this.mState = Lifecycle$State.INITIALIZED;
  }
  
  private void forwardPass() {
    FastSafeIterableMap fastSafeIterableMap = this.mObserverMap;
    SafeIterableMap.IteratorWithAdditions<Map.Entry> iteratorWithAdditions = new SafeIterableMap.IteratorWithAdditions((SafeIterableMap)fastSafeIterableMap, (byte)0);
    ((SafeIterableMap)fastSafeIterableMap).mIterators.put(iteratorWithAdditions, Boolean.valueOf(false));
    while (iteratorWithAdditions.hasNext() && !this.mNewEventOccurred) {
      Map.Entry entry = iteratorWithAdditions.next();
      LifecycleRegistry$ObserverWithState lifecycleRegistry$ObserverWithState = (LifecycleRegistry$ObserverWithState)entry.getValue();
      while (lifecycleRegistry$ObserverWithState.mState.compareTo((E)this.mState) < 0 && !this.mNewEventOccurred && this.mObserverMap.contains(entry.getKey())) {
        Lifecycle$Event lifecycle$Event;
        StringBuilder stringBuilder;
        pushParentState(lifecycleRegistry$ObserverWithState.mState);
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
        Lifecycle$State lifecycle$State = lifecycleRegistry$ObserverWithState.mState;
        switch (LifecycleRegistry$1.$SwitchMap$android$arch$lifecycle$Lifecycle$State[lifecycle$State.ordinal()]) {
          default:
            stringBuilder = new StringBuilder("Unexpected state value ");
            stringBuilder.append(lifecycle$State);
            throw new IllegalArgumentException(stringBuilder.toString());
          case 4:
            throw new IllegalArgumentException();
          case 3:
            lifecycle$Event = Lifecycle$Event.ON_RESUME;
            break;
          case 2:
            lifecycle$Event = Lifecycle$Event.ON_START;
            break;
          case 1:
          case 5:
            lifecycle$Event = Lifecycle$Event.ON_CREATE;
            break;
        } 
        lifecycleRegistry$ObserverWithState.dispatchEvent(lifecycleOwner, lifecycle$Event);
        popParentState();
      } 
    } 
  }
  
  static Lifecycle$State getStateAfter(Lifecycle$Event paramLifecycle$Event) {
    StringBuilder stringBuilder;
    switch (LifecycleRegistry$1.$SwitchMap$android$arch$lifecycle$Lifecycle$Event[paramLifecycle$Event.ordinal()]) {
      default:
        stringBuilder = new StringBuilder("Unexpected event value ");
        stringBuilder.append(paramLifecycle$Event);
        throw new IllegalArgumentException(stringBuilder.toString());
      case 6:
        return Lifecycle$State.DESTROYED;
      case 5:
        return Lifecycle$State.RESUMED;
      case 3:
      case 4:
        return Lifecycle$State.STARTED;
      case 1:
      case 2:
        break;
    } 
    return Lifecycle$State.CREATED;
  }
  
  private void popParentState() {
    this.mParentStates.remove(this.mParentStates.size() - 1);
  }
  
  private void pushParentState(Lifecycle$State paramLifecycle$State) {
    this.mParentStates.add(paramLifecycle$State);
  }
  
  public final void handleLifecycleEvent(Lifecycle$Event paramLifecycle$Event) {
    this.mState = getStateAfter(paramLifecycle$Event);
    if (this.mHandlingEvent || this.mAddingObserverCounter != 0) {
      this.mNewEventOccurred = true;
      return;
    } 
    this.mHandlingEvent = true;
    while (true) {
      while (true)
        break; 
      if (!this.mNewEventOccurred && paramLifecycle$Event != null && this.mState.compareTo((E)((LifecycleRegistry$ObserverWithState)paramLifecycle$Event.getValue()).mState) > 0)
        forwardPass(); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\arch\lifecycle\LifecycleRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */