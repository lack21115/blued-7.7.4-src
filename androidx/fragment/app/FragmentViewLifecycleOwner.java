package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

class FragmentViewLifecycleOwner implements LifecycleOwner {
  private LifecycleRegistry a = null;
  
  void a() {
    if (this.a == null)
      this.a = new LifecycleRegistry(this); 
  }
  
  void a(Lifecycle.Event paramEvent) {
    this.a.handleLifecycleEvent(paramEvent);
  }
  
  boolean b() {
    return (this.a != null);
  }
  
  public Lifecycle getLifecycle() {
    a();
    return (Lifecycle)this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\fragment\app\FragmentViewLifecycleOwner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */