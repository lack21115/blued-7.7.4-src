package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;

public class ApiExceptionMapper implements StatusExceptionMapper {
  public Exception getException(Status paramStatus) {
    return (Exception)ApiExceptionUtil.fromStatus(paramStatus);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\ApiExceptionMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */