package com.heytap.mcssdk;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.heytap.mcssdk.utils.LogUtil;
import com.mcs.aidl.IMcsSdkService;

final class d implements ServiceConnection {
  d(PushManager paramPushManager, Intent paramIntent) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    Bundle bundle = new Bundle();
    bundle.putAll(this.a.getExtras());
    try {
      IMcsSdkService.Stub.a(paramIBinder).a(bundle);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("bindMcsService exception:");
      stringBuilder.append(exception);
      LogUtil.a(stringBuilder.toString());
    } 
    PushManager.a(this.b).unbindService(this);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssdk\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */