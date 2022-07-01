package com.bumptech.glide.manager;

import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

class ActivityFragmentLifecycle implements Lifecycle {
  private final Set<LifecycleListener> a = Collections.newSetFromMap(new WeakHashMap<LifecycleListener, Boolean>());
  
  private boolean b;
  
  private boolean c;
  
  void a() {
    this.b = true;
    Iterator<LifecycleListener> iterator = Util.a(this.a).iterator();
    while (iterator.hasNext())
      ((LifecycleListener)iterator.next()).o_(); 
  }
  
  public void a(LifecycleListener paramLifecycleListener) {
    this.a.add(paramLifecycleListener);
    if (this.c) {
      paramLifecycleListener.q_();
      return;
    } 
    if (this.b) {
      paramLifecycleListener.o_();
      return;
    } 
    paramLifecycleListener.p_();
  }
  
  void b() {
    this.b = false;
    Iterator<LifecycleListener> iterator = Util.a(this.a).iterator();
    while (iterator.hasNext())
      ((LifecycleListener)iterator.next()).p_(); 
  }
  
  public void b(LifecycleListener paramLifecycleListener) {
    this.a.remove(paramLifecycleListener);
  }
  
  void c() {
    this.c = true;
    Iterator<LifecycleListener> iterator = Util.a(this.a).iterator();
    while (iterator.hasNext())
      ((LifecycleListener)iterator.next()).q_(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\manager\ActivityFragmentLifecycle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */