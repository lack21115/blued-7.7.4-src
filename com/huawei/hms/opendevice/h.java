package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Messenger;
import com.huawei.hms.support.log.HMSLog;

public class h {
  public ServiceConnection a;
  
  public Messenger b = null;
  
  public boolean a(Context paramContext, Bundle paramBundle, Intent paramIntent) {
    paramContext = paramContext.getApplicationContext();
    this.a = new g(this, paramBundle, paramContext);
    HMSLog.i("RemoteService", "remote service bind service start");
    return paramContext.bindService(paramIntent, this.a, 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */