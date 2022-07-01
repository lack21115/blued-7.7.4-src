package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonDialogListener;
import com.bytedance.sdk.openadsdk.ICommonPermissionListener;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;

public abstract class a extends IListenerManager.Stub {
  public void broadcastDialogListener(String paramString, int paramInt) throws RemoteException {}
  
  public void broadcastPermissionListener(String paramString1, String paramString2) throws RemoteException {}
  
  public void executeAppDownloadCallback(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3, String paramString4) throws RemoteException {}
  
  public void executeFullVideoCallback(String paramString1, String paramString2) throws RemoteException {}
  
  public void executeRewardVideoCallback(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3) throws RemoteException {}
  
  public void registerDialogListener(String paramString, ICommonDialogListener paramICommonDialogListener) throws RemoteException {}
  
  public void registerFullVideoListener(String paramString, IFullScreenVideoAdInteractionListener paramIFullScreenVideoAdInteractionListener) throws RemoteException {}
  
  public void registerPermissionListener(String paramString, ICommonPermissionListener paramICommonPermissionListener) throws RemoteException {}
  
  public void registerRewardVideoListener(String paramString, IRewardAdInteractionListener paramIRewardAdInteractionListener) throws RemoteException {}
  
  public void registerTTAppDownloadListener(String paramString, ITTAppDownloadListener paramITTAppDownloadListener) throws RemoteException {}
  
  public void unregisterTTAppDownloadListener(String paramString, ITTAppDownloadListener paramITTAppDownloadListener) throws RemoteException {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\aidl\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */