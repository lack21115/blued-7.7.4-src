package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {
  private final ListenerHolder<L> zaa;
  
  private final Feature[] zab;
  
  private final boolean zac;
  
  protected RegisterListenerMethod(ListenerHolder<L> paramListenerHolder) {
    this.zaa = paramListenerHolder;
    this.zab = null;
    this.zac = false;
  }
  
  protected RegisterListenerMethod(ListenerHolder<L> paramListenerHolder, Feature[] paramArrayOfFeature, boolean paramBoolean) {
    this.zaa = paramListenerHolder;
    this.zab = paramArrayOfFeature;
    this.zac = paramBoolean;
  }
  
  public void clearListener() {
    this.zaa.clear();
  }
  
  public ListenerHolder.ListenerKey<L> getListenerKey() {
    return this.zaa.getListenerKey();
  }
  
  public Feature[] getRequiredFeatures() {
    return this.zab;
  }
  
  protected abstract void registerListener(A paramA, TaskCompletionSource<Void> paramTaskCompletionSource) throws RemoteException;
  
  public final boolean zaa() {
    return this.zac;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\RegisterListenerMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */