package org.chromium.android_webview;

import android.content.Context;
import android.os.Process;

public class AwServiceWorkerSettings {
  private boolean mAllowContentUrlAccess;
  
  private boolean mAllowFileUrlAccess;
  
  private final Object mAwServiceWorkerSettingsLock;
  
  private boolean mBlockNetworkLoads;
  
  private int mCacheMode;
  
  private final boolean mHasInternetPermission;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public AwServiceWorkerSettings(Context paramContext) {
    boolean bool;
    this.mCacheMode = -1;
    this.mAllowContentUrlAccess = true;
    this.mAllowFileUrlAccess = true;
    this.mAwServiceWorkerSettingsLock = new Object();
    if (paramContext.checkPermission("android.permission.INTERNET", Process.myPid(), Process.myUid()) == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    synchronized (this.mAwServiceWorkerSettingsLock) {
      this.mHasInternetPermission = bool;
      this.mBlockNetworkLoads = bool ^ true;
      return;
    } 
  }
  
  public final boolean getAllowContentAccess() {
    synchronized (this.mAwServiceWorkerSettingsLock) {
      return this.mAllowContentUrlAccess;
    } 
  }
  
  public final boolean getAllowFileAccess() {
    synchronized (this.mAwServiceWorkerSettingsLock) {
      return this.mAllowFileUrlAccess;
    } 
  }
  
  public final boolean getBlockNetworkLoads() {
    synchronized (this.mAwServiceWorkerSettingsLock) {
      return this.mBlockNetworkLoads;
    } 
  }
  
  public final int getCacheMode() {
    synchronized (this.mAwServiceWorkerSettingsLock) {
      return this.mCacheMode;
    } 
  }
  
  public final void setAllowContentAccess(boolean paramBoolean) {
    synchronized (this.mAwServiceWorkerSettingsLock) {
      if (this.mAllowContentUrlAccess != paramBoolean)
        this.mAllowContentUrlAccess = paramBoolean; 
      return;
    } 
  }
  
  public final void setAllowFileAccess(boolean paramBoolean) {
    synchronized (this.mAwServiceWorkerSettingsLock) {
      if (this.mAllowFileUrlAccess != paramBoolean)
        this.mAllowFileUrlAccess = paramBoolean; 
      return;
    } 
  }
  
  public final void setBlockNetworkLoads(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mAwServiceWorkerSettingsLock : Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: iload_1
    //   8: ifne -> 31
    //   11: aload_0
    //   12: getfield mHasInternetPermission : Z
    //   15: ifeq -> 21
    //   18: goto -> 31
    //   21: new java/lang/SecurityException
    //   24: dup
    //   25: ldc 'Permission denied - application missing INTERNET permission'
    //   27: invokespecial <init> : (Ljava/lang/String;)V
    //   30: athrow
    //   31: aload_0
    //   32: iload_1
    //   33: putfield mBlockNetworkLoads : Z
    //   36: aload_2
    //   37: monitorexit
    //   38: return
    //   39: aload_2
    //   40: monitorexit
    //   41: aload_3
    //   42: athrow
    //   43: astore_3
    //   44: goto -> 39
    // Exception table:
    //   from	to	target	type
    //   11	18	43	finally
    //   21	31	43	finally
    //   31	38	43	finally
    //   39	41	43	finally
  }
  
  public final void setCacheMode(int paramInt) {
    synchronized (this.mAwServiceWorkerSettingsLock) {
      if (this.mCacheMode != paramInt)
        this.mCacheMode = paramInt; 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwServiceWorkerSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */