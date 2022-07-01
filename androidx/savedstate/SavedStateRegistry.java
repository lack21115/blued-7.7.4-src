package androidx.savedstate;

import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Map;

public final class SavedStateRegistry {
  boolean a = true;
  
  private SafeIterableMap<String, SavedStateProvider> b = new SafeIterableMap();
  
  private Bundle c;
  
  private boolean d;
  
  private Recreator.SavedStateProvider e;
  
  void a(Bundle paramBundle) {
    Bundle bundle1 = new Bundle();
    Bundle bundle2 = this.c;
    if (bundle2 != null)
      bundle1.putAll(bundle2); 
    SafeIterableMap.IteratorWithAdditions<Map.Entry> iteratorWithAdditions = this.b.iteratorWithAdditions();
    while (iteratorWithAdditions.hasNext()) {
      Map.Entry entry = iteratorWithAdditions.next();
      bundle1.putBundle((String)entry.getKey(), ((SavedStateProvider)entry.getValue()).saveState());
    } 
    paramBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle1);
  }
  
  void a(Lifecycle paramLifecycle, Bundle paramBundle) {
    if (!this.d) {
      if (paramBundle != null)
        this.c = paramBundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key"); 
      paramLifecycle.addObserver((LifecycleObserver)new GenericLifecycleObserver(this) {
            public void onStateChanged(LifecycleOwner param1LifecycleOwner, Lifecycle.Event param1Event) {
              if (param1Event == Lifecycle.Event.ON_START) {
                this.a.a = true;
                return;
              } 
              if (param1Event == Lifecycle.Event.ON_STOP)
                this.a.a = false; 
            }
          });
      this.d = true;
      return;
    } 
    throw new IllegalStateException("SavedStateRegistry was already restored.");
  }
  
  public Bundle consumeRestoredStateForKey(String paramString) {
    if (this.d) {
      Bundle bundle = this.c;
      if (bundle != null) {
        bundle = bundle.getBundle(paramString);
        this.c.remove(paramString);
        if (this.c.isEmpty())
          this.c = null; 
        return bundle;
      } 
      return null;
    } 
    throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
  }
  
  public boolean isRestored() {
    return this.d;
  }
  
  public void registerSavedStateProvider(String paramString, SavedStateProvider paramSavedStateProvider) {
    if ((SavedStateProvider)this.b.putIfAbsent(paramString, paramSavedStateProvider) == null)
      return; 
    throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
  }
  
  public void runOnNextRecreation(Class<? extends AutoRecreated> paramClass) {
    if (this.a) {
      if (this.e == null)
        this.e = new Recreator.SavedStateProvider(this); 
      try {
        paramClass.getDeclaredConstructor(new Class[0]);
        this.e.a(paramClass.getName());
        return;
      } catch (NoSuchMethodException noSuchMethodException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Class");
        stringBuilder.append(paramClass.getSimpleName());
        stringBuilder.append(" must have default constructor in order to be automatically recreated");
        throw new IllegalArgumentException(stringBuilder.toString(), noSuchMethodException);
      } 
    } 
    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
  }
  
  public void unregisterSavedStateProvider(String paramString) {
    this.b.remove(paramString);
  }
  
  public static interface AutoRecreated {
    void onRecreated(SavedStateRegistryOwner param1SavedStateRegistryOwner);
  }
  
  public static interface SavedStateProvider {
    Bundle saveState();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\savedstate\SavedStateRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */