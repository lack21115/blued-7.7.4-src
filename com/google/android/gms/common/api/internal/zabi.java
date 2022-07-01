package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zabi<O extends Api.ApiOptions> extends zaab {
  @NotOnlyInitialized
  private final GoogleApi<O> zaa;
  
  public zabi(GoogleApi<O> paramGoogleApi) {
    super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
    this.zaa = paramGoogleApi;
  }
  
  public final <A extends Api.AnyClient, R extends com.google.android.gms.common.api.Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT) {
    return (T)this.zaa.doRead((BaseImplementation.ApiMethodImpl)paramT);
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends com.google.android.gms.common.api.Result, A>> T execute(T paramT) {
    return (T)this.zaa.doWrite((BaseImplementation.ApiMethodImpl)paramT);
  }
  
  public final Context getContext() {
    return this.zaa.getApplicationContext();
  }
  
  public final Looper getLooper() {
    return this.zaa.getLooper();
  }
  
  public final void zaa(zaci paramzaci) {}
  
  public final void zab(zaci paramzaci) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zabi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */