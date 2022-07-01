package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.internal.base.zap;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zal extends LifecycleCallback implements DialogInterface.OnCancelListener {
  protected volatile boolean zaa;
  
  protected final AtomicReference<zak> zab = new AtomicReference<zak>(null);
  
  protected final GoogleApiAvailability zac;
  
  private final Handler zad = (Handler)new zap(Looper.getMainLooper());
  
  protected zal(LifecycleFragment paramLifecycleFragment) {
    this(paramLifecycleFragment, GoogleApiAvailability.getInstance());
  }
  
  zal(LifecycleFragment paramLifecycleFragment, GoogleApiAvailability paramGoogleApiAvailability) {
    super(paramLifecycleFragment);
    this.zac = paramGoogleApiAvailability;
  }
  
  private static int zaa(zak paramzak) {
    return (paramzak == null) ? -1 : paramzak.zaa();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    zak zak = this.zab.get();
    int i = 1;
    boolean bool = true;
    if (paramInt1 != 1) {
      if (paramInt1 != 2) {
        zak zak1 = zak;
      } else {
        i = this.zac.isGooglePlayServicesAvailable((Context)getActivity());
        if (i == 0) {
          paramInt1 = bool;
        } else {
          paramInt1 = 0;
        } 
        if (zak == null)
          return; 
        zak zak1 = zak;
        paramInt2 = paramInt1;
        if (zak.zab().getErrorCode() == 18) {
          zak1 = zak;
          paramInt2 = paramInt1;
          if (i == 18)
            return; 
        } 
        if (paramInt2 != 0) {
          zab();
          return;
        } 
      } 
    } else {
      if (paramInt2 == -1) {
        zak zak1 = zak;
        paramInt2 = i;
      } else {
        zak zak1 = zak;
        if (paramInt2 == 0) {
          if (zak == null)
            return; 
          paramInt1 = 13;
          if (paramIntent != null)
            paramInt1 = paramIntent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13); 
          zak1 = new zak(new ConnectionResult(paramInt1, null, zak.zab().toString()), zaa(zak));
          this.zab.set(zak1);
        } 
        paramInt2 = 0;
      } 
      if (paramInt2 != 0) {
        zab();
        return;
      } 
    } 
    paramInt2 = 0;
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {
    zaa(new ConnectionResult(13, null), zaa(this.zab.get()));
    zab();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (paramBundle != null) {
      AtomicReference<zak> atomicReference = this.zab;
      if (paramBundle.getBoolean("resolving_error", false)) {
        zak zak = new zak(new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution")), paramBundle.getInt("failed_client_id", -1));
      } else {
        paramBundle = null;
      } 
      atomicReference.set(paramBundle);
    } 
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    zak zak = this.zab.get();
    if (zak != null) {
      paramBundle.putBoolean("resolving_error", true);
      paramBundle.putInt("failed_client_id", zak.zaa());
      paramBundle.putInt("failed_status", zak.zab().getErrorCode());
      paramBundle.putParcelable("failed_resolution", (Parcelable)zak.zab().getResolution());
    } 
  }
  
  public void onStart() {
    super.onStart();
    this.zaa = true;
  }
  
  public void onStop() {
    super.onStop();
    this.zaa = false;
  }
  
  protected abstract void zaa();
  
  protected abstract void zaa(ConnectionResult paramConnectionResult, int paramInt);
  
  protected final void zab() {
    this.zab.set(null);
    zaa();
  }
  
  public final void zab(ConnectionResult paramConnectionResult, int paramInt) {
    zak zak = new zak(paramConnectionResult, paramInt);
    if (this.zab.compareAndSet(null, zak))
      this.zad.post(new zan(this, zak)); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */