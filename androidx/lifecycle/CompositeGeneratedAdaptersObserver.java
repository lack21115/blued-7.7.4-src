package androidx.lifecycle;

class CompositeGeneratedAdaptersObserver implements LifecycleEventObserver {
  private final GeneratedAdapter[] mGeneratedAdapters;
  
  CompositeGeneratedAdaptersObserver(GeneratedAdapter[] paramArrayOfGeneratedAdapter) {
    this.mGeneratedAdapters = paramArrayOfGeneratedAdapter;
  }
  
  public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent) {
    MethodCallsLogger methodCallsLogger = new MethodCallsLogger();
    GeneratedAdapter[] arrayOfGeneratedAdapter = this.mGeneratedAdapters;
    int j = arrayOfGeneratedAdapter.length;
    boolean bool = false;
    int i;
    for (i = 0; i < j; i++)
      arrayOfGeneratedAdapter[i].callMethods(paramLifecycleOwner, paramEvent, false, methodCallsLogger); 
    arrayOfGeneratedAdapter = this.mGeneratedAdapters;
    j = arrayOfGeneratedAdapter.length;
    for (i = bool; i < j; i++)
      arrayOfGeneratedAdapter[i].callMethods(paramLifecycleOwner, paramEvent, true, methodCallsLogger); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\lifecycle\CompositeGeneratedAdaptersObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */