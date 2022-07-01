package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonPermissionListener;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.HashMap;

public class d extends a {
  private static HashMap<String, RemoteCallbackList<ICommonPermissionListener>> a = new HashMap<String, RemoteCallbackList<ICommonPermissionListener>>();
  
  private static volatile d b;
  
  public static d a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/d.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/d;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/multipro/aidl/a/d
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/d.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/d;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/multipro/aidl/a/d
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/d.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/d;
    //   25: ldc com/bytedance/sdk/openadsdk/multipro/aidl/a/d
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/multipro/aidl/a/d
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/d.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/d;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void broadcastPermissionListener(String paramString1, String paramString2) throws RemoteException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("00000 CommonPermissionListenerManagerImpl broadcastDialogListener: 00000");
    stringBuilder.append(String.valueOf(paramString1));
    stringBuilder.append(", ");
    stringBuilder.append(paramString2);
    t.b("MultiProcess", stringBuilder.toString());
    RemoteCallbackList remoteCallbackList = a.remove(paramString1);
    if (remoteCallbackList == null)
      return; 
    int j = remoteCallbackList.beginBroadcast();
    for (int i = 0; i < j; i++) {
      ICommonPermissionListener iCommonPermissionListener = (ICommonPermissionListener)remoteCallbackList.getBroadcastItem(i);
      if (iCommonPermissionListener != null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("CommonPermissionListenerManagerImpl broadcastDialogListener: ");
        stringBuilder1.append(String.valueOf(paramString1));
        stringBuilder1.append(", ");
        stringBuilder1.append(paramString2);
        t.b("MultiProcess", stringBuilder1.toString());
        if (paramString2 == null) {
          iCommonPermissionListener.onGranted();
        } else {
          iCommonPermissionListener.onDenied(paramString2);
        } 
      } 
    } 
    remoteCallbackList.finishBroadcast();
    remoteCallbackList.kill();
  }
  
  public void registerPermissionListener(String paramString, ICommonPermissionListener paramICommonPermissionListener) throws RemoteException {
    if (paramICommonPermissionListener == null)
      return; 
    t.b("MultiProcess", "CommonPermissionListenerManagerImpl registerPermissionListener");
    RemoteCallbackList<ICommonPermissionListener> remoteCallbackList = new RemoteCallbackList();
    remoteCallbackList.register((IInterface)paramICommonPermissionListener);
    a.put(paramString, remoteCallbackList);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\aidl\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */