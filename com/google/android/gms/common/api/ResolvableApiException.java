package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;

public class ResolvableApiException extends ApiException {
  public ResolvableApiException(Status paramStatus) {
    super(paramStatus);
  }
  
  public PendingIntent getResolution() {
    return getStatus().getResolution();
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt) throws IntentSender.SendIntentException {
    getStatus().startResolutionForResult(paramActivity, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\ResolvableApiException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */