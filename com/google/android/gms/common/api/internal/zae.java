package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zae extends zac<Void> {
  private final zabs zac;
  
  public zae(zabs paramzabs, TaskCompletionSource<Void> paramTaskCompletionSource) {
    super(3, paramTaskCompletionSource);
    this.zac = paramzabs;
  }
  
  public final void zab(GoogleApiManager.zaa<?> paramzaa) throws RemoteException {
    this.zac.zaa.registerListener(paramzaa.zab(), this.zab);
    ListenerHolder.ListenerKey<?> listenerKey = this.zac.zaa.getListenerKey();
    if (listenerKey != null)
      paramzaa.zac().put(listenerKey, this.zac); 
  }
  
  public final Feature[] zac(GoogleApiManager.zaa<?> paramzaa) {
    return this.zac.zaa.getRequiredFeatures();
  }
  
  public final boolean zad(GoogleApiManager.zaa<?> paramzaa) {
    return this.zac.zaa.zaa();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */