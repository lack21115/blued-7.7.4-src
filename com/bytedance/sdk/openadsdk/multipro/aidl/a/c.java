package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonDialogListener;
import java.util.HashMap;

public class c extends a {
  public static HashMap<String, RemoteCallbackList<ICommonDialogListener>> a = new HashMap<String, RemoteCallbackList<ICommonDialogListener>>();
  
  private static volatile c b;
  
  public static c a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/c.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/c;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/multipro/aidl/a/c
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/c.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/c;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/multipro/aidl/a/c
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/c.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/c;
    //   25: ldc com/bytedance/sdk/openadsdk/multipro/aidl/a/c
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/multipro/aidl/a/c
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/multipro/aidl/a/c.b : Lcom/bytedance/sdk/openadsdk/multipro/aidl/a/c;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void broadcastDialogListener(String paramString, int paramInt) throws RemoteException {
    RemoteCallbackList remoteCallbackList = a.remove(paramString);
    if (remoteCallbackList == null)
      return; 
    int j = remoteCallbackList.beginBroadcast();
    for (int i = 0; i < j; i++) {
      ICommonDialogListener iCommonDialogListener = (ICommonDialogListener)remoteCallbackList.getBroadcastItem(i);
      if (iCommonDialogListener != null)
        if (paramInt != 1) {
          if (paramInt != 2) {
            if (paramInt != 3) {
              iCommonDialogListener.onDialogCancel();
            } else {
              iCommonDialogListener.onDialogCancel();
            } 
          } else {
            iCommonDialogListener.onDialogBtnNo();
          } 
        } else {
          iCommonDialogListener.onDialogBtnYes();
        }  
    } 
    remoteCallbackList.finishBroadcast();
    remoteCallbackList.kill();
  }
  
  public void registerDialogListener(String paramString, ICommonDialogListener paramICommonDialogListener) throws RemoteException {
    if (paramICommonDialogListener == null)
      return; 
    RemoteCallbackList<ICommonDialogListener> remoteCallbackList = new RemoteCallbackList();
    remoteCallbackList.register((IInterface)paramICommonDialogListener);
    a.put(paramString, remoteCallbackList);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\aidl\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */