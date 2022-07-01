package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

public class zabo extends zal {
  private TaskCompletionSource<Void> zad = new TaskCompletionSource();
  
  private zabo(LifecycleFragment paramLifecycleFragment) {
    super(paramLifecycleFragment);
    this.mLifecycleFragment.addCallback("GmsAvailabilityHelper", this);
  }
  
  public static zabo zaa(Activity paramActivity) {
    LifecycleFragment lifecycleFragment = getFragment(paramActivity);
    zabo zabo1 = lifecycleFragment.<zabo>getCallbackOrNull("GmsAvailabilityHelper", zabo.class);
    if (zabo1 != null) {
      if (zabo1.zad.getTask().isComplete())
        zabo1.zad = new TaskCompletionSource(); 
      return zabo1;
    } 
    return new zabo(lifecycleFragment);
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.zad.trySetException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
  }
  
  protected final void zaa() {
    Activity activity = this.mLifecycleFragment.getLifecycleActivity();
    if (activity == null) {
      this.zad.trySetException((Exception)new ApiException(new Status(8)));
      return;
    } 
    int i = this.zac.isGooglePlayServicesAvailable((Context)activity);
    if (i == 0) {
      this.zad.trySetResult(null);
      return;
    } 
    if (!this.zad.getTask().isComplete())
      zab(new ConnectionResult(i, null), 0); 
  }
  
  protected final void zaa(ConnectionResult paramConnectionResult, int paramInt) {
    this.zad.setException((Exception)ApiExceptionUtil.fromStatus(new Status(paramConnectionResult.getErrorCode(), paramConnectionResult.getErrorMessage(), paramConnectionResult.getResolution())));
  }
  
  public final Task<Void> zac() {
    return this.zad.getTask();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zabo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */