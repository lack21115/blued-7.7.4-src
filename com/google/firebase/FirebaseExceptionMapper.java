package com.google.firebase;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;

public class FirebaseExceptionMapper implements StatusExceptionMapper {
  public Exception getException(Status paramStatus) {
    return (paramStatus.getStatusCode() == 8) ? new FirebaseException(paramStatus.zza()) : new FirebaseApiNotAvailableException(paramStatus.zza());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\firebase\FirebaseExceptionMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */