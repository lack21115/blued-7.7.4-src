package com.huawei.hms.push;

import android.os.Parcel;
import android.os.Parcelable;

public final class b implements Parcelable.Creator<RemoteMessage> {
  public RemoteMessage createFromParcel(Parcel paramParcel) {
    return new RemoteMessage(paramParcel);
  }
  
  public RemoteMessage[] newArray(int paramInt) {
    return new RemoteMessage[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\push\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */