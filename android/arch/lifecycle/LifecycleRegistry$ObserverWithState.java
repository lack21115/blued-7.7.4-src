package android.arch.lifecycle;

final class LifecycleRegistry$ObserverWithState {
  private GenericLifecycleObserver mLifecycleObserver;
  
  Lifecycle$State mState;
  
  final void dispatchEvent(LifecycleOwner paramLifecycleOwner, Lifecycle$Event paramLifecycle$Event) {
    Lifecycle$State lifecycle$State2 = LifecycleRegistry.getStateAfter(paramLifecycle$Event);
    Lifecycle$State lifecycle$State3 = this.mState;
    Lifecycle$State lifecycle$State1 = lifecycle$State3;
    if (lifecycle$State2 != null) {
      lifecycle$State1 = lifecycle$State3;
      if (lifecycle$State2.compareTo((E)lifecycle$State3) < 0)
        lifecycle$State1 = lifecycle$State2; 
    } 
    this.mState = lifecycle$State1;
    this.mLifecycleObserver.onStateChanged(paramLifecycleOwner, paramLifecycle$Event);
    this.mState = lifecycle$State2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\arch\lifecycle\LifecycleRegistry$ObserverWithState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */