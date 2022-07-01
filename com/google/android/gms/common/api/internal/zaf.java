package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

public final class zaf<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>> extends zab {
  private final A zab;
  
  public zaf(int paramInt, A paramA) {
    super(paramInt);
    this.zab = (A)Preconditions.checkNotNull(paramA, "Null methods are not runnable.");
  }
  
  public final void zaa(Status paramStatus) {
    this.zab.setFailedResult(paramStatus);
  }
  
  public final void zaa(GoogleApiManager.zaa<?> paramzaa) throws DeadObjectException {
    try {
      this.zab.run(paramzaa.zab());
      return;
    } catch (RuntimeException runtimeException) {
      super.zaa(runtimeException);
      return;
    } 
  }
  
  public final void zaa(zav paramzav, boolean paramBoolean) {
    paramzav.zaa((BasePendingResult<? extends Result>)this.zab, paramBoolean);
  }
  
  public final void zaa(Exception paramException) {
    String str2 = paramException.getClass().getSimpleName();
    String str1 = paramException.getLocalizedMessage();
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 2 + String.valueOf(str1).length());
    stringBuilder.append(str2);
    stringBuilder.append(": ");
    stringBuilder.append(str1);
    Status status = new Status(10, stringBuilder.toString());
    this.zab.setFailedResult(status);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */