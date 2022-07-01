package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.api.internal.LifecycleFragment;

public abstract class zad implements DialogInterface.OnClickListener {
  public static zad zaa(Activity paramActivity, Intent paramIntent, int paramInt) {
    return new zac(paramIntent, paramActivity, paramInt);
  }
  
  public static zad zaa(Fragment paramFragment, Intent paramIntent, int paramInt) {
    return new zaf(paramIntent, paramFragment, paramInt);
  }
  
  public static zad zaa(LifecycleFragment paramLifecycleFragment, Intent paramIntent, int paramInt) {
    return new zae(paramIntent, paramLifecycleFragment, 2);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    Exception exception;
    try {
      zaa();
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
  
  protected abstract void zaa();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */