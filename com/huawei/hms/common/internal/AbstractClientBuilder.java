package com.huawei.hms.common.internal;

import android.content.Context;

public abstract class AbstractClientBuilder<TClient extends AnyClient, TOption> {
  public abstract TClient buildClient(Context paramContext, ClientSettings paramClientSettings, BaseHmsClient.OnConnectionFailedListener paramOnConnectionFailedListener, BaseHmsClient.ConnectionCallbacks paramConnectionCallbacks);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\AbstractClientBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */