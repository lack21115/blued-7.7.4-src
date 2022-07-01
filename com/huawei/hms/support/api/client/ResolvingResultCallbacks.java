package com.huawei.hms.support.api.client;

import android.app.Activity;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.log.HMSLog;

@Deprecated
public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {
  private static final String TAG = "ResolvingResultCallbacks";
  
  private final Activity mActivity;
  
  private final int requestCode;
  
  protected ResolvingResultCallbacks(Activity paramActivity, int paramInt) {
    this.mActivity = (Activity)Preconditions.checkNotNull(paramActivity, "Activity must not be null");
    this.requestCode = paramInt;
  }
  
  public final void onFailure(Status paramStatus) {
    try {
      if (paramStatus.hasResolution()) {
        paramStatus.startResolutionForResult(this.mActivity, this.requestCode);
        return;
      } 
      onUnresolvableFailure(paramStatus);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to start resolution: ");
      stringBuilder.append(exception);
      HMSLog.e("ResolvingResultCallbacks", stringBuilder.toString());
      onUnresolvableFailure(Status.RESULT_INTERNAL_ERROR);
      return;
    } 
  }
  
  public abstract void onSuccess(R paramR);
  
  public abstract void onUnresolvableFailure(Status paramStatus);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\client\ResolvingResultCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */