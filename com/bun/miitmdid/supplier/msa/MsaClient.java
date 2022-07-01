package com.bun.miitmdid.supplier.msa;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Keep;
import com.bun.lib.c;

@Keep
public class MsaClient {
  private static String TAG = "MSA Client library";
  
  private static String TARGET_PACKAGE = "com.mdid.msa";
  
  private com.bun.miitmdid.c.e.a _BindService;
  
  private ServiceConnection mConnection;
  
  private Context mContext;
  
  private c mDeviceidInterface;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public MsaClient(Context paramContext, com.bun.miitmdid.c.e.a parama) {
    if (paramContext != null) {
      this.mContext = paramContext;
      this._BindService = parama;
      this.mConnection = new a(this, parama);
      return;
    } 
    throw new NullPointerException("Context can not be null.");
  }
  
  public static boolean CheckService(Context paramContext) {
    try {
      paramContext.getPackageManager().getPackageInfo(TARGET_PACKAGE, 0);
      return true;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return false;
    } 
  }
  
  public static void StartMsaKlService(Context paramContext, String paramString) {
    Intent intent = new Intent();
    intent.setClassName(TARGET_PACKAGE, "com.mdid.msa.service.MsaKlService");
    intent.setAction("com.bun.msa.action.start.service");
    intent.putExtra("com.bun.msa.param.pkgname", paramString);
    try {
      intent.putExtra("com.bun.msa.param.runinset", true);
      if (paramContext.startService(intent) == null)
        com.bun.lib.a.a(TAG, "start msa kl service error"); 
      return;
    } catch (Exception exception) {
      com.bun.lib.a.a(TAG, "start msa kl service exception", exception);
      return;
    } 
  }
  
  public void BindService(String paramString) {
    Intent intent = new Intent();
    intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
    intent.setAction("com.bun.msa.action.bindto.service");
    intent.putExtra("com.bun.msa.param.pkgname", paramString);
    if (this.mContext.bindService(intent, this.mConnection, 1)) {
      com.bun.lib.a.b(TAG, "bindService Successful!");
      return;
    } 
    com.bun.miitmdid.c.e.a a1 = this._BindService;
    if (a1 != null)
      a1.b(); 
    com.bun.lib.a.b(TAG, "bindService Failed!");
  }
  
  public String getAAID() {
    try {
      if (this.mDeviceidInterface != null)
        return this.mDeviceidInterface.getAAID(); 
    } catch (RemoteException remoteException) {
      com.bun.lib.a.b(TAG, "getAAID error, RemoteException!");
    } 
    return "";
  }
  
  public String getOAID() {
    try {
      if (this.mDeviceidInterface != null)
        return this.mDeviceidInterface.getOAID(); 
    } catch (RemoteException remoteException) {
      com.bun.lib.a.a(TAG, "getOAID error, RemoteException!");
      remoteException.printStackTrace();
    } 
    return "";
  }
  
  public String getUDID() {
    return "";
  }
  
  public String getVAID() {
    try {
      if (this.mDeviceidInterface != null)
        return this.mDeviceidInterface.getVAID(); 
    } catch (RemoteException remoteException) {
      com.bun.lib.a.b(TAG, "getVAID error, RemoteException!");
    } 
    return "";
  }
  
  public boolean isSupported() {
    boolean bool = false;
    try {
      if (this.mDeviceidInterface != null) {
        com.bun.lib.a.b(TAG, "Device support opendeviceid");
        bool = this.mDeviceidInterface.isSupported();
      } 
      return bool;
    } catch (Exception exception) {
      com.bun.lib.a.b(TAG, "isSupport error, RemoteException!");
      return false;
    } 
  }
  
  public void shutdown() {
    null = this.mDeviceidInterface;
    if (null == null)
      return; 
    try {
      null.shutDown();
      if (this.mConnection != null)
        this.mContext.unbindService(this.mConnection); 
      com.bun.lib.a.b(TAG, "unBind Service successful");
      return;
    } catch (Exception exception) {
      com.bun.lib.a.b(TAG, "unBind Service exception");
      return;
    } finally {
      this.mConnection = null;
      this.mDeviceidInterface = null;
    } 
  }
  
  class a implements ServiceConnection {
    a(MsaClient this$0, com.bun.miitmdid.c.e.a param1a) {}
    
    public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : Lcom/bun/miitmdid/supplier/msa/MsaClient;
      //   6: aload_2
      //   7: invokestatic a : (Landroid/os/IBinder;)Lcom/bun/lib/c;
      //   10: invokestatic access$002 : (Lcom/bun/miitmdid/supplier/msa/MsaClient;Lcom/bun/lib/c;)Lcom/bun/lib/c;
      //   13: pop
      //   14: new com/bun/miitmdid/supplier/msa/a
      //   17: dup
      //   18: aload_0
      //   19: getfield b : Lcom/bun/miitmdid/supplier/msa/MsaClient;
      //   22: invokestatic access$000 : (Lcom/bun/miitmdid/supplier/msa/MsaClient;)Lcom/bun/lib/c;
      //   25: aload_0
      //   26: getfield a : Lcom/bun/miitmdid/c/e/a;
      //   29: invokespecial <init> : (Lcom/bun/lib/c;Lcom/bun/miitmdid/c/e/a;)V
      //   32: getstatic android/os/AsyncTask.THREAD_POOL_EXECUTOR : Ljava/util/concurrent/Executor;
      //   35: iconst_0
      //   36: anewarray java/lang/Void
      //   39: invokevirtual executeOnExecutor : (Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;
      //   42: pop
      //   43: invokestatic access$100 : ()Ljava/lang/String;
      //   46: ldc 'Service onServiceConnected'
      //   48: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
      //   51: aload_0
      //   52: monitorexit
      //   53: return
      //   54: astore_1
      //   55: aload_0
      //   56: monitorexit
      //   57: aload_1
      //   58: athrow
      // Exception table:
      //   from	to	target	type
      //   2	51	54	finally
    }
    
    public void onServiceDisconnected(ComponentName param1ComponentName) {
      MsaClient.access$002(this.b, null);
      com.bun.lib.a.b(MsaClient.TAG, "Service onServiceDisconnected");
      MsaClient.access$002(this.b, null);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\supplier\msa\MsaClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */