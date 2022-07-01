package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzbq;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzi extends zzo {
  private final SparseArray zzfuf = new SparseArray();
  
  private zzi(zzcf paramzzcf) {
    super(paramzzcf);
    this.zzgam.zza("AutoManageHelper", this);
  }
  
  public static zzi zza(zzce paramzzce) {
    zzdc zzdc;
    zzcg zzcg;
    if (paramzzce.zzgal instanceof FragmentActivity) {
      zzdc = zzdc.zza((FragmentActivity)paramzzce.zzgal);
    } else if (((zzce)zzdc).zzgal instanceof Activity) {
      zzcg = zzcg.zzp((Activity)((zzce)zzdc).zzgal);
    } else {
      throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    } 
    zzi zzi1 = (zzi)zzcg.zza("AutoManageHelper", zzi.class);
    return (zzi1 != null) ? zzi1 : new zzi(zzcg);
  }
  
  private final zzi$zza zzbr(int paramInt) {
    return (this.zzfuf.size() <= paramInt) ? null : (zzi$zza)this.zzfuf.get(this.zzfuf.keyAt(paramInt));
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    int i;
    for (i = 0; i < this.zzfuf.size(); i++) {
      zzi$zza zzi$zza = zzbr(i);
      if (zzi$zza != null) {
        paramPrintWriter.append(paramString).append("GoogleApiClient #").print(zzi$zza.zzfug);
        paramPrintWriter.println(":");
        zzi$zza.zzfuh.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      } 
    } 
  }
  
  public final void onStart() {
    super.onStart();
    boolean bool = this.mStarted;
    String str = String.valueOf(this.zzfuf);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 14);
    stringBuilder.append("onStart ");
    stringBuilder.append(bool);
    stringBuilder.append(" ");
    stringBuilder.append(str);
    if (this.zzfut.get() == null)
      for (int i = 0; i < this.zzfuf.size(); i++) {
        zzi$zza zzi$zza = zzbr(i);
        if (zzi$zza != null)
          zzi$zza.zzfuh.connect(); 
      }  
  }
  
  public final void onStop() {
    super.onStop();
    for (int i = 0; i < this.zzfuf.size(); i++) {
      zzi$zza zzi$zza = zzbr(i);
      if (zzi$zza != null)
        zzi$zza.zzfuh.disconnect(); 
    } 
  }
  
  public final void zza(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    zzbq.checkNotNull(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (this.zzfuf.indexOfKey(paramInt) < 0) {
      bool = true;
    } else {
      bool = false;
    } 
    StringBuilder stringBuilder1 = new StringBuilder(54);
    stringBuilder1.append("Already managing a GoogleApiClient with id ");
    stringBuilder1.append(paramInt);
    zzbq.zza(bool, stringBuilder1.toString());
    zzp zzp = this.zzfut.get();
    boolean bool = this.mStarted;
    String str = String.valueOf(zzp);
    StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(str).length() + 49);
    stringBuilder2.append("starting AutoManage for client ");
    stringBuilder2.append(paramInt);
    stringBuilder2.append(" ");
    stringBuilder2.append(bool);
    stringBuilder2.append(" ");
    stringBuilder2.append(str);
    paramOnConnectionFailedListener = new zzi$zza(this, paramInt, paramGoogleApiClient, paramOnConnectionFailedListener);
    this.zzfuf.put(paramInt, paramOnConnectionFailedListener);
    if (this.mStarted && zzp == null) {
      String str1 = String.valueOf(paramGoogleApiClient);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 11);
      stringBuilder.append("connecting ");
      stringBuilder.append(str1);
      paramGoogleApiClient.connect();
    } 
  }
  
  protected final void zza(ConnectionResult paramConnectionResult, int paramInt) {
    Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
    if (paramInt < 0) {
      Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
      return;
    } 
    zzi$zza zzi$zza = (zzi$zza)this.zzfuf.get(paramInt);
    if (zzi$zza != null) {
      zzi$zza zzi$zza1 = (zzi$zza)this.zzfuf.get(paramInt);
      this.zzfuf.remove(paramInt);
      if (zzi$zza1 != null) {
        zzi$zza1.zzfuh.unregisterConnectionFailedListener(zzi$zza1);
        zzi$zza1.zzfuh.disconnect();
      } 
      GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zzi$zza.zzfui;
      if (onConnectionFailedListener != null)
        onConnectionFailedListener.onConnectionFailed(paramConnectionResult); 
    } 
  }
  
  protected final void zzaih() {
    for (int i = 0; i < this.zzfuf.size(); i++) {
      zzi$zza zzi$zza = zzbr(i);
      if (zzi$zza != null)
        zzi$zza.zzfuh.connect(); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */