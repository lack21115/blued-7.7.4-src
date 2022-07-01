package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {
  private final Feature[] zaa = null;
  
  private final boolean zab = false;
  
  @Deprecated
  public TaskApiCall() {}
  
  private TaskApiCall(Feature[] paramArrayOfFeature, boolean paramBoolean) {}
  
  public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder() {
    return new Builder<A, ResultT>(null);
  }
  
  protected abstract void doExecute(A paramA, TaskCompletionSource<ResultT> paramTaskCompletionSource) throws RemoteException;
  
  public boolean shouldAutoResolveMissingFeatures() {
    return this.zab;
  }
  
  public final Feature[] zaa() {
    return this.zaa;
  }
  
  public static class Builder<A extends Api.AnyClient, ResultT> {
    private RemoteCall<A, TaskCompletionSource<ResultT>> zaa;
    
    private boolean zab = true;
    
    private Feature[] zac;
    
    private Builder() {}
    
    public TaskApiCall<A, ResultT> build() {
      boolean bool;
      if (this.zaa != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "execute parameter required");
      return new zach(this, this.zac, this.zab);
    }
    
    @Deprecated
    public Builder<A, ResultT> execute(BiConsumer<A, TaskCompletionSource<ResultT>> param1BiConsumer) {
      this.zaa = new zacg(param1BiConsumer);
      return this;
    }
    
    public Builder<A, ResultT> run(RemoteCall<A, TaskCompletionSource<ResultT>> param1RemoteCall) {
      this.zaa = param1RemoteCall;
      return this;
    }
    
    public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean param1Boolean) {
      this.zab = param1Boolean;
      return this;
    }
    
    public Builder<A, ResultT> setFeatures(Feature... param1VarArgs) {
      this.zac = param1VarArgs;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\TaskApiCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */