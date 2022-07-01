package com.huawei.hms.common.internal;

import android.os.Parcelable;

public interface ResponseErrorCode {
  int getErrorCode();
  
  String getErrorReason();
  
  Parcelable getParcelable();
  
  String getResolution();
  
  int getStatusCode();
  
  String getTransactionId();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\ResponseErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */