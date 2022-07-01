package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;

public abstract class zzdlc {
  private final Context mContext;
  
  private final Object mLock = new Object();
  
  private final String mTag;
  
  private boolean zzlhu = false;
  
  private Object zzlhv;
  
  public zzdlc(Context paramContext, String paramString) {
    this.mContext = paramContext;
    this.mTag = paramString;
  }
  
  public final boolean isOperational() {
    return (zzblo() != null);
  }
  
  public abstract Object zza(DynamiteModule paramDynamiteModule, Context paramContext);
  
  public abstract void zzbll();
  
  public final void zzbln() {
    synchronized (this.mLock) {
      if (this.zzlhv == null)
        return; 
      try {
        zzbll();
      } catch (RemoteException remoteException) {
        Log.e(this.mTag, "Could not finalize native handle", (Throwable)remoteException);
      } 
      return;
    } 
  }
  
  public final Object zzblo() {
    synchronized (this.mLock) {
      if (this.zzlhv != null)
        return this.zzlhv; 
      try {
        this.zzlhv = zza(DynamiteModule.zza(this.mContext, DynamiteModule.zzhdm, "com.google.android.gms.vision.dynamite"), this.mContext);
      } catch (com.google.android.gms.dynamite.DynamiteModule.zzc|RemoteException zzc) {
        Log.e(this.mTag, "Error creating remote native handle", (Throwable)zzc);
      } 
      if (!this.zzlhu && this.zzlhv == null) {
        Log.w(this.mTag, "Native handle not yet available. Reverting to no-op handle.");
        this.zzlhu = true;
      } else if (this.zzlhu && this.zzlhv != null) {
        Log.w(this.mTag, "Native handle is now available.");
      } 
      return this.zzlhv;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzdlc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */