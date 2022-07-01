package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.b;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.c;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.d;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.e;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.f;
import com.bytedance.sdk.openadsdk.utils.t;

public class BinderPoolService extends Service {
  private Binder a = (Binder)new a();
  
  public IBinder onBind(Intent paramIntent) {
    t.b("MultiProcess", "BinderPoolService onBind ! ");
    return (IBinder)this.a;
  }
  
  public void onCreate() {
    super.onCreate();
    t.b("MultiProcess", "BinderPoolService has been created ! ");
  }
  
  public void onDestroy() {
    super.onDestroy();
    t.b("MultiProcess", "BinderPoolService is destroy ! ");
  }
  
  public static class a extends IBinderPool.Stub {
    public IBinder queryBinder(int param1Int) throws RemoteException {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("queryBinder...........binderCode=");
      stringBuilder.append(param1Int);
      t.c("MultiProcess", stringBuilder.toString());
      return (IBinder)((param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? null : d.a()) : b.a()) : c.a()) : e.a()) : f.a());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\aidl\BinderPoolService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */