package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.internal.zzcf;

public abstract class zzv implements DialogInterface.OnClickListener {
  public static zzv zza(Activity paramActivity, Intent paramIntent, int paramInt) {
    return new zzw(paramIntent, paramActivity, paramInt);
  }
  
  public static zzv zza$5e0d627(zzcf paramzzcf, Intent paramIntent) {
    return new zzy(paramIntent, paramzzcf, 2);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    Exception exception;
    try {
      zzamo();
      paramDialogInterface.dismiss();
      return;
    } catch (ActivityNotFoundException activityNotFoundException) {
      Log.e("DialogRedirect", "Failed to start resolution intent", (Throwable)activityNotFoundException);
      paramDialogInterface.dismiss();
      return;
    } finally {}
    paramDialogInterface.dismiss();
    throw exception;
  }
  
  protected abstract void zzamo();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */