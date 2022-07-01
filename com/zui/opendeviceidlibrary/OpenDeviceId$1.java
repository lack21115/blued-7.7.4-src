package com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.zui.deviceidservice.IDeviceidInterface;

class OpenDeviceId$1 implements ServiceConnection {
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Lcom/zui/opendeviceidlibrary/OpenDeviceId;
    //   6: aload_2
    //   7: invokestatic a : (Landroid/os/IBinder;)Lcom/zui/deviceidservice/IDeviceidInterface;
    //   10: invokestatic a : (Lcom/zui/opendeviceidlibrary/OpenDeviceId;Lcom/zui/deviceidservice/IDeviceidInterface;)Lcom/zui/deviceidservice/IDeviceidInterface;
    //   13: pop
    //   14: aload_0
    //   15: getfield a : Lcom/zui/opendeviceidlibrary/OpenDeviceId;
    //   18: invokestatic a : (Lcom/zui/opendeviceidlibrary/OpenDeviceId;)Lcom/zui/opendeviceidlibrary/OpenDeviceId$CallBack;
    //   21: ifnull -> 40
    //   24: aload_0
    //   25: getfield a : Lcom/zui/opendeviceidlibrary/OpenDeviceId;
    //   28: invokestatic a : (Lcom/zui/opendeviceidlibrary/OpenDeviceId;)Lcom/zui/opendeviceidlibrary/OpenDeviceId$CallBack;
    //   31: aload_0
    //   32: getfield a : Lcom/zui/opendeviceidlibrary/OpenDeviceId;
    //   35: invokeinterface a : (Lcom/zui/opendeviceidlibrary/OpenDeviceId;)V
    //   40: aload_0
    //   41: getfield a : Lcom/zui/opendeviceidlibrary/OpenDeviceId;
    //   44: ldc 'Service onServiceConnected'
    //   46: invokestatic a : (Lcom/zui/opendeviceidlibrary/OpenDeviceId;Ljava/lang/String;)V
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   2	40	52	finally
    //   40	49	52	finally
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {
    OpenDeviceId.a(this.a, (IDeviceidInterface)null);
    OpenDeviceId.a(this.a, "Service onServiceDisconnected");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\zui\opendeviceidlibrary\OpenDeviceId$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */