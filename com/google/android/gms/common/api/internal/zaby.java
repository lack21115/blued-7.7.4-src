package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zaby extends RegisterListenerMethod<A, L> {
  zaby(RegistrationMethods.Builder paramBuilder, ListenerHolder<L> paramListenerHolder, Feature[] paramArrayOfFeature, boolean paramBoolean) {
    super(paramListenerHolder, paramArrayOfFeature, paramBoolean);
  }
  
  protected final void registerListener(A paramA, TaskCompletionSource<Void> paramTaskCompletionSource) throws RemoteException {
    RegistrationMethods.Builder.zaa(this.zaa).accept(paramA, paramTaskCompletionSource);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zaby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */