package com.huawei.hms.aaid.task;

import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import java.util.Arrays;

public class PushClientBuilder extends AbstractClientBuilder<PushClient, Api.ApiOptions.NoOptions> {
  public PushClient buildClient(Context paramContext, ClientSettings paramClientSettings, BaseHmsClient.OnConnectionFailedListener paramOnConnectionFailedListener, BaseHmsClient.ConnectionCallbacks paramConnectionCallbacks) {
    paramClientSettings.setApiName(Arrays.asList(new String[] { "HuaweiPush.API", "Core.API" }));
    return new PushClient(paramContext, paramClientSettings, paramOnConnectionFailedListener, paramConnectionCallbacks);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\aaid\task\PushClientBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */