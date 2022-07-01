package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class UnregisterListenerMethod<A extends Api.AnyClient, L> {
  private final ListenerHolder.ListenerKey<L> zaa;
  
  protected UnregisterListenerMethod(ListenerHolder.ListenerKey<L> paramListenerKey) {
    this.zaa = paramListenerKey;
  }
  
  public ListenerHolder.ListenerKey<L> getListenerKey() {
    return this.zaa;
  }
  
  protected abstract void unregisterListener(A paramA, TaskCompletionSource<Boolean> paramTaskCompletionSource) throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\UnregisterListenerMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */