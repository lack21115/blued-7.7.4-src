package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zach extends TaskApiCall<A, ResultT> {
  zach(TaskApiCall.Builder paramBuilder, Feature[] paramArrayOfFeature, boolean paramBoolean) {
    super(paramArrayOfFeature, paramBoolean, null);
  }
  
  protected final void doExecute(A paramA, TaskCompletionSource<ResultT> paramTaskCompletionSource) throws RemoteException {
    TaskApiCall.Builder.zaa(this.zaa).accept(paramA, paramTaskCompletionSource);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zach.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */