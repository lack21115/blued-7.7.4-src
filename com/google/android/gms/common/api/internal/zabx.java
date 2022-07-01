package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zabx extends UnregisterListenerMethod<A, L> {
  zabx(RegistrationMethods.Builder paramBuilder, ListenerHolder.ListenerKey<L> paramListenerKey) {
    super(paramListenerKey);
  }
  
  protected final void unregisterListener(A paramA, TaskCompletionSource<Boolean> paramTaskCompletionSource) throws RemoteException {
    RegistrationMethods.Builder.zab(this.zaa).accept(paramA, paramTaskCompletionSource);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zabx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */