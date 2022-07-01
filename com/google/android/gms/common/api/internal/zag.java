package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zag extends zac<Boolean> {
  private final ListenerHolder.ListenerKey<?> zac;
  
  public zag(ListenerHolder.ListenerKey<?> paramListenerKey, TaskCompletionSource<Boolean> paramTaskCompletionSource) {
    super(4, paramTaskCompletionSource);
    this.zac = paramListenerKey;
  }
  
  public final void zab(GoogleApiManager.zaa<?> paramzaa) throws RemoteException {
    zabs zabs = paramzaa.zac().remove(this.zac);
    if (zabs != null) {
      zabs.zab.unregisterListener(paramzaa.zab(), this.zab);
      zabs.zaa.clearListener();
      return;
    } 
    this.zab.trySetResult(Boolean.valueOf(false));
  }
  
  public final Feature[] zac(GoogleApiManager.zaa<?> paramzaa) {
    zabs zabs = paramzaa.zac().get(this.zac);
    return (zabs == null) ? null : zabs.zaa.getRequiredFeatures();
  }
  
  public final boolean zad(GoogleApiManager.zaa<?> paramzaa) {
    zabs zabs = paramzaa.zac().get(this.zac);
    return (zabs != null && zabs.zaa.zaa());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */