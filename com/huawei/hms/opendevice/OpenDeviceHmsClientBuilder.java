package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;

public class OpenDeviceHmsClientBuilder extends AbstractClientBuilder<OpenDeviceHmsClient, OpenDeviceOptions> {
  public OpenDeviceHmsClient buildClient(Context paramContext, ClientSettings paramClientSettings, BaseHmsClient.OnConnectionFailedListener paramOnConnectionFailedListener, BaseHmsClient.ConnectionCallbacks paramConnectionCallbacks) {
    return new OpenDeviceHmsClient(paramContext, paramClientSettings, paramOnConnectionFailedListener, paramConnectionCallbacks);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\OpenDeviceHmsClientBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */