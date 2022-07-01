package com.huawei.hms.common.internal.safeparcel;

import com.huawei.hms.support.api.client.Result;

public abstract class AbstractSafeParcelable extends Result implements SafeParcelable {
  public final int describeContents() {
    return 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\safeparcel\AbstractSafeParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */