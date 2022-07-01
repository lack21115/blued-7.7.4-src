package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zaz;

public class BaseImplementation {
  public static abstract class ApiMethodImpl<R extends Result, A extends Api.AnyClient> extends BasePendingResult<R> implements ResultHolder<R> {
    private final Api<?> mApi;
    
    private final Api.AnyClientKey<A> mClientKey;
    
    @Deprecated
    protected ApiMethodImpl(Api.AnyClientKey<A> param1AnyClientKey, GoogleApiClient param1GoogleApiClient) {
      super((GoogleApiClient)Preconditions.checkNotNull(param1GoogleApiClient, "GoogleApiClient must not be null"));
      this.mClientKey = (Api.AnyClientKey<A>)Preconditions.checkNotNull(param1AnyClientKey);
      this.mApi = null;
    }
    
    public ApiMethodImpl(Api<?> param1Api, GoogleApiClient param1GoogleApiClient) {
      super((GoogleApiClient)Preconditions.checkNotNull(param1GoogleApiClient, "GoogleApiClient must not be null"));
      Preconditions.checkNotNull(param1Api, "Api must not be null");
      this.mClientKey = param1Api.zac();
      this.mApi = param1Api;
    }
    
    protected ApiMethodImpl(BasePendingResult.CallbackHandler<R> param1CallbackHandler) {
      super(param1CallbackHandler);
      this.mClientKey = new Api.AnyClientKey();
      this.mApi = null;
    }
    
    private void setFailedResult(RemoteException param1RemoteException) {
      setFailedResult(new Status(8, param1RemoteException.getLocalizedMessage(), null));
    }
    
    protected abstract void doExecute(A param1A) throws RemoteException;
    
    public final Api<?> getApi() {
      return this.mApi;
    }
    
    public final Api.AnyClientKey<A> getClientKey() {
      return this.mClientKey;
    }
    
    protected void onSetFailedResult(R param1R) {}
    
    public final void run(A param1A) throws DeadObjectException {
      Api.zaa zaa;
      A a = param1A;
      if (param1A instanceof zaz) {
        zaz zaz = (zaz)param1A;
        zaa = zaz.zaa();
      } 
      try {
        doExecute((A)zaa);
        return;
      } catch (DeadObjectException deadObjectException) {
        setFailedResult((RemoteException)deadObjectException);
        throw deadObjectException;
      } catch (RemoteException remoteException) {
        setFailedResult(remoteException);
        return;
      } 
    }
    
    public final void setFailedResult(Status param1Status) {
      Preconditions.checkArgument(param1Status.isSuccess() ^ true, "Failed result must not be success");
      param1Status = (Status)createFailedResult(param1Status);
      setResult((R)param1Status);
      onSetFailedResult((R)param1Status);
    }
  }
  
  public static interface ResultHolder<R> {
    void setFailedResult(Status param1Status);
    
    void setResult(R param1R);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\BaseImplementation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */