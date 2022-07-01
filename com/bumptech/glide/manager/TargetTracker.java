package com.bumptech.glide.manager;

import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class TargetTracker implements LifecycleListener {
  private final Set<Target<?>> a = Collections.newSetFromMap(new WeakHashMap<Target<?>, Boolean>());
  
  public List<Target<?>> a() {
    return Util.a(this.a);
  }
  
  public void a(Target<?> paramTarget) {
    this.a.add(paramTarget);
  }
  
  public void b(Target<?> paramTarget) {
    this.a.remove(paramTarget);
  }
  
  public void e() {
    this.a.clear();
  }
  
  public void o_() {
    Iterator<Target> iterator = Util.a(this.a).iterator();
    while (iterator.hasNext())
      ((Target)iterator.next()).o_(); 
  }
  
  public void p_() {
    Iterator<Target> iterator = Util.a(this.a).iterator();
    while (iterator.hasNext())
      ((Target)iterator.next()).p_(); 
  }
  
  public void q_() {
    Iterator<Target> iterator = Util.a(this.a).iterator();
    while (iterator.hasNext())
      ((Target)iterator.next()).q_(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\manager\TargetTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */