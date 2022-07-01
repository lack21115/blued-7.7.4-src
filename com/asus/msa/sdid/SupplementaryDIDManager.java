package com.asus.msa.sdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.Keep;
import android.util.Log;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

@Keep
public class SupplementaryDIDManager {
  public static boolean DEBUG = false;
  
  public static final String TAG = "SupplementaryDIDManager";
  
  public boolean isBinded = false;
  
  public Context mContext;
  
  public IDidAidlInterface mDidService;
  
  public IDIDBinderStatusListener mListener;
  
  public ServiceConnection mServiceConnection = new ServiceConnection(this) {
      public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        if (SupplementaryDIDManager.DEBUG)
          Log.i("SupplementaryDIDManager", "did service binded"); 
        SupplementaryDIDManager.access$102(this.a, IDidAidlInterface.Stub.a(param1IBinder));
        this.a.notifyAllListeners(true);
      }
      
      public void onServiceDisconnected(ComponentName param1ComponentName) {
        this.a.notifyAllListeners(false);
      }
    };
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public SupplementaryDIDManager(Context paramContext) {
    this.mContext = paramContext;
  }
  
  private void notifyAllListeners(boolean paramBoolean) {
    if (paramBoolean)
      try {
        this.mListener.a(this.mDidService);
        return;
      } catch (Exception exception) {
        if (DEBUG)
          Log.e("SupplementaryDIDManager", "notify did bind status error :" + exception.getMessage()); 
        return;
      }  
    this.mListener.b();
  }
  
  public void deInit() {
    try {
      if (this.isBinded && this.mServiceConnection != null && this.mContext != null) {
        if (DEBUG)
          Log.i("SupplementaryDIDManager", "start to unbind did service"); 
        this.isBinded = false;
        this.mContext.unbindService(this.mServiceConnection);
      } 
      return;
    } catch (Exception exception) {
      Log.w("SupplementaryDIDManager", exception.getMessage());
      return;
    } 
  }
  
  public void init(IDIDBinderStatusListener paramIDIDBinderStatusListener) {
    try {
      this.mListener = paramIDIDBinderStatusListener;
      Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
      ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
      intent = new Intent(intent);
      intent.setComponent(componentName);
      if (DEBUG)
        Log.i("SupplementaryDIDManager", "start to bind did service."); 
      this.isBinded = this.mContext.bindService(intent, this.mServiceConnection, 1);
      return;
    } catch (Exception exception) {
      notifyAllListeners(false);
      return;
    } 
  }
  
  public void showLog(boolean paramBoolean) {
    DEBUG = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\asus\msa\sdid\SupplementaryDIDManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */