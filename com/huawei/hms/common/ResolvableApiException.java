package com.huawei.hms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import com.huawei.hms.support.api.client.Status;

public class ResolvableApiException extends ApiException {
  public ResolvableApiException(Status paramStatus) {
    super(paramStatus);
  }
  
  public PendingIntent getResolution() {
    return this.mStatus.getResolution();
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt) throws IntentSender.SendIntentException {
    this.mStatus.startResolutionForResult(paramActivity, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\ResolvableApiException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */