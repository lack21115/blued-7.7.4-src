package com.bun.miitmdid.supplier.msa;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bun.lib.c;

public class MsaClient {
  private static String TAG = "MSA Client library";
  
  private static String TARGET_PACKAGE = "com.mdid.msa";
  
  private com.bun.miitmdid.c.e.a _BindService;
  
  private ServiceConnection mConnection;
  
  private Context mContext;
  
  private c mDeviceidInterface;
  
  public MsaClient(Context paramContext, com.bun.miitmdid.c.e.a parama) {
    if (paramContext != null) {
      this.mContext = paramContext;
      this._BindService = parama;
      this.mConnection = new a(this, parama);
      return;
    } 
    throw new NullPointerException("Context can not be null.");
  }
  
  public static native boolean CheckService(Context paramContext);
  
  public static native void StartMsaKlService(Context paramContext, String paramString);
  
  public native void BindService(String paramString);
  
  public native String getAAID();
  
  public native String getOAID();
  
  public native String getUDID();
  
  public native String getVAID();
  
  public native boolean isSupported();
  
  public native void shutdown();
  
  class a implements ServiceConnection {
    a(MsaClient this$0, com.bun.miitmdid.c.e.a param1a) {}
    
    public synchronized native void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder);
    
    public native void onServiceDisconnected(ComponentName param1ComponentName);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bun\miitmdid\supplier\msa\MsaClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */