package com.asus.msa.sdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

public class SupplementaryDIDManager {
  public static boolean DEBUG = false;
  
  public static final String TAG = "SupplementaryDIDManager";
  
  public boolean isBinded = false;
  
  public Context mContext;
  
  public IDidAidlInterface mDidService;
  
  public IDIDBinderStatusListener mListener;
  
  public ServiceConnection mServiceConnection = new ServiceConnection(this) {
      public native void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder);
      
      public native void onServiceDisconnected(ComponentName param1ComponentName);
    };
  
  public SupplementaryDIDManager(Context paramContext) {
    this.mContext = paramContext;
  }
  
  private native void notifyAllListeners(boolean paramBoolean);
  
  public native void deInit();
  
  public native void init(IDIDBinderStatusListener paramIDIDBinderStatusListener);
  
  public native void showLog(boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\asus\msa\sdid\SupplementaryDIDManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */