package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;

public final class SavedStateRegistryController {
  private final SavedStateRegistryOwner a;
  
  private final SavedStateRegistry b;
  
  private SavedStateRegistryController(SavedStateRegistryOwner paramSavedStateRegistryOwner) {
    this.a = paramSavedStateRegistryOwner;
    this.b = new SavedStateRegistry();
  }
  
  public static SavedStateRegistryController create(SavedStateRegistryOwner paramSavedStateRegistryOwner) {
    return new SavedStateRegistryController(paramSavedStateRegistryOwner);
  }
  
  public SavedStateRegistry getSavedStateRegistry() {
    return this.b;
  }
  
  public void performRestore(Bundle paramBundle) {
    Lifecycle lifecycle = this.a.getLifecycle();
    if (lifecycle.getCurrentState() == Lifecycle.State.INITIALIZED) {
      lifecycle.addObserver((LifecycleObserver)new Recreator(this.a));
      this.b.a(lifecycle, paramBundle);
      return;
    } 
    throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
  }
  
  public void performSave(Bundle paramBundle) {
    this.b.a(paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\savedstate\SavedStateRegistryController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */