package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;

public final class ListenerHolder<L> {
  private final zaa zaa;
  
  private volatile L zab;
  
  private volatile ListenerKey<L> zac;
  
  ListenerHolder(Looper paramLooper, L paramL, String paramString) {
    this.zaa = new zaa(this, paramLooper);
    this.zab = (L)Preconditions.checkNotNull(paramL, "Listener must not be null");
    this.zac = new ListenerKey<L>(paramL, Preconditions.checkNotEmpty(paramString));
  }
  
  public final void clear() {
    this.zab = null;
    this.zac = null;
  }
  
  public final ListenerKey<L> getListenerKey() {
    return this.zac;
  }
  
  public final boolean hasListener() {
    return (this.zab != null);
  }
  
  public final void notifyListener(Notifier<? super L> paramNotifier) {
    Preconditions.checkNotNull(paramNotifier, "Notifier must not be null");
    Message message = this.zaa.obtainMessage(1, paramNotifier);
    this.zaa.sendMessage(message);
  }
  
  final void notifyListenerInternal(Notifier<? super L> paramNotifier) {
    L l = this.zab;
    if (l == null) {
      paramNotifier.onNotifyListenerFailed();
      return;
    } 
    try {
      paramNotifier.notifyListener(l);
      return;
    } catch (RuntimeException runtimeException) {
      paramNotifier.onNotifyListenerFailed();
      throw runtimeException;
    } 
  }
  
  public static final class ListenerKey<L> {
    private final L zaa;
    
    private final String zab;
    
    ListenerKey(L param1L, String param1String) {
      this.zaa = param1L;
      this.zab = param1String;
    }
    
    public final boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (!(param1Object instanceof ListenerKey))
        return false; 
      param1Object = param1Object;
      return (this.zaa == ((ListenerKey)param1Object).zaa && this.zab.equals(((ListenerKey)param1Object).zab));
    }
    
    public final int hashCode() {
      return System.identityHashCode(this.zaa) * 31 + this.zab.hashCode();
    }
  }
  
  public static interface Notifier<L> {
    void notifyListener(L param1L);
    
    void onNotifyListenerFailed();
  }
  
  final class zaa extends zap {
    public zaa(ListenerHolder this$0, Looper param1Looper) {
      super(param1Looper);
    }
    
    public final void handleMessage(Message param1Message) {
      int i = param1Message.what;
      boolean bool = true;
      if (i != 1)
        bool = false; 
      Preconditions.checkArgument(bool);
      ListenerHolder.Notifier notifier = (ListenerHolder.Notifier)param1Message.obj;
      this.zaa.notifyListenerInternal(notifier);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\ListenerHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */