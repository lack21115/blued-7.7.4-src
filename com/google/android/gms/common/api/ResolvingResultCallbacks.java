package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;

public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {
  private final Activity zza;
  
  private final int zzb;
  
  protected ResolvingResultCallbacks(Activity paramActivity, int paramInt) {
    this.zza = (Activity)Preconditions.checkNotNull(paramActivity, "Activity must not be null");
    this.zzb = paramInt;
  }
  
  public final void onFailure(Status paramStatus) {
    if (paramStatus.hasResolution())
      try {
        paramStatus.startResolutionForResult(this.zza, this.zzb);
        return;
      } catch (android.content.IntentSender.SendIntentException sendIntentException) {
        Log.e("ResolvingResultCallback", "Failed to start resolution", (Throwable)sendIntentException);
        onUnresolvableFailure(new Status(8));
        return;
      }  
    onUnresolvableFailure((Status)sendIntentException);
  }
  
  public abstract void onSuccess(R paramR);
  
  public abstract void onUnresolvableFailure(Status paramStatus);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\ResolvingResultCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */