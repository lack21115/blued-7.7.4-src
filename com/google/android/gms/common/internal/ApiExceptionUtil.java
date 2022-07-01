package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

public class ApiExceptionUtil {
  public static ApiException fromStatus(Status paramStatus) {
    return (ApiException)(paramStatus.hasResolution() ? new ResolvableApiException(paramStatus) : new ApiException(paramStatus));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\ApiExceptionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */