package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

public class RegistrationMethods<A extends Api.AnyClient, L> {
  public final RegisterListenerMethod<A, L> zaa;
  
  public final UnregisterListenerMethod<A, L> zab;
  
  public final Runnable zac;
  
  private RegistrationMethods(RegisterListenerMethod<A, L> paramRegisterListenerMethod, UnregisterListenerMethod<A, L> paramUnregisterListenerMethod, Runnable paramRunnable) {
    this.zaa = paramRegisterListenerMethod;
    this.zab = paramUnregisterListenerMethod;
    this.zac = paramRunnable;
  }
  
  public static <A extends Api.AnyClient, L> Builder<A, L> builder() {
    return new Builder<A, L>(null);
  }
  
  public static class Builder<A extends Api.AnyClient, L> {
    private RemoteCall<A, TaskCompletionSource<Void>> zaa;
    
    private RemoteCall<A, TaskCompletionSource<Boolean>> zab;
    
    private Runnable zac = zabu.zaa;
    
    private ListenerHolder<L> zad;
    
    private Feature[] zae;
    
    private boolean zaf = true;
    
    private Builder() {}
    
    public RegistrationMethods<A, L> build() {
      boolean bool1;
      RemoteCall<A, TaskCompletionSource<Void>> remoteCall = this.zaa;
      boolean bool2 = true;
      if (remoteCall != null) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      Preconditions.checkArgument(bool1, "Must set register function");
      if (this.zab != null) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      Preconditions.checkArgument(bool1, "Must set unregister function");
      if (this.zad != null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      Preconditions.checkArgument(bool1, "Must set holder");
      ListenerHolder.ListenerKey listenerKey = (ListenerHolder.ListenerKey)Preconditions.checkNotNull(this.zad.getListenerKey(), "Key must not be null");
      return new RegistrationMethods<A, L>(new zaby(this, this.zad, this.zae, this.zaf), new zabx(this, listenerKey), this.zac, null);
    }
    
    public Builder<A, L> onConnectionSuspended(Runnable param1Runnable) {
      this.zac = param1Runnable;
      return this;
    }
    
    public Builder<A, L> register(RemoteCall<A, TaskCompletionSource<Void>> param1RemoteCall) {
      this.zaa = param1RemoteCall;
      return this;
    }
    
    @Deprecated
    public Builder<A, L> register(BiConsumer<A, TaskCompletionSource<Void>> param1BiConsumer) {
      this.zaa = new zabw(param1BiConsumer);
      return this;
    }
    
    public Builder<A, L> setAutoResolveMissingFeatures(boolean param1Boolean) {
      this.zaf = param1Boolean;
      return this;
    }
    
    public Builder<A, L> setFeatures(Feature... param1VarArgs) {
      this.zae = param1VarArgs;
      return this;
    }
    
    public Builder<A, L> unregister(RemoteCall<A, TaskCompletionSource<Boolean>> param1RemoteCall) {
      this.zab = param1RemoteCall;
      return this;
    }
    
    @Deprecated
    public Builder<A, L> unregister(BiConsumer<A, TaskCompletionSource<Boolean>> param1BiConsumer) {
      this.zaa = new zabv(this);
      return this;
    }
    
    public Builder<A, L> withHolder(ListenerHolder<L> param1ListenerHolder) {
      this.zad = param1ListenerHolder;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\RegistrationMethods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */