package com.google.android.gms.dynamic;

import android.os.Bundle;
import java.util.Iterator;

final class zab implements OnDelegateCreatedListener<T> {
  zab(DeferredLifecycleHelper paramDeferredLifecycleHelper) {}
  
  public final void onDelegateCreated(T paramT) {
    DeferredLifecycleHelper.zaa(this.zaa, (LifecycleDelegate)paramT);
    Iterator<DeferredLifecycleHelper.zaa> iterator = DeferredLifecycleHelper.zaa(this.zaa).iterator();
    while (iterator.hasNext())
      ((DeferredLifecycleHelper.zaa)iterator.next()).zaa(DeferredLifecycleHelper.zab(this.zaa)); 
    DeferredLifecycleHelper.zaa(this.zaa).clear();
    DeferredLifecycleHelper.zaa(this.zaa, (Bundle)null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\dynamic\zab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */