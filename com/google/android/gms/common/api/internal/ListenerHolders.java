package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public class ListenerHolders {
  private final Set<ListenerHolder<?>> zaa = Collections.newSetFromMap(new WeakHashMap<ListenerHolder<?>, Boolean>());
  
  public static <L> ListenerHolder<L> createListenerHolder(L paramL, Looper paramLooper, String paramString) {
    Preconditions.checkNotNull(paramL, "Listener must not be null");
    Preconditions.checkNotNull(paramLooper, "Looper must not be null");
    Preconditions.checkNotNull(paramString, "Listener type must not be null");
    return new ListenerHolder<L>(paramLooper, paramL, paramString);
  }
  
  public static <L> ListenerHolder.ListenerKey<L> createListenerKey(L paramL, String paramString) {
    Preconditions.checkNotNull(paramL, "Listener must not be null");
    Preconditions.checkNotNull(paramString, "Listener type must not be null");
    Preconditions.checkNotEmpty(paramString, "Listener type must not be empty");
    return new ListenerHolder.ListenerKey<L>(paramL, paramString);
  }
  
  public final <L> ListenerHolder<L> zaa(L paramL, Looper paramLooper, String paramString) {
    ListenerHolder<L> listenerHolder = createListenerHolder(paramL, paramLooper, paramString);
    this.zaa.add(listenerHolder);
    return listenerHolder;
  }
  
  public final void zaa() {
    Iterator<ListenerHolder<?>> iterator = this.zaa.iterator();
    while (iterator.hasNext())
      ((ListenerHolder)iterator.next()).clear(); 
    this.zaa.clear();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\ListenerHolders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */