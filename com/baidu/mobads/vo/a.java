package com.baidu.mobads.vo;

import android.os.Parcel;
import android.os.Parcelable;

final class a implements Parcelable.Creator<XAdInstanceInfo> {
  public XAdInstanceInfo a(Parcel paramParcel) {
    return new XAdInstanceInfo(paramParcel, null);
  }
  
  public XAdInstanceInfo[] a(int paramInt) {
    return new XAdInstanceInfo[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\vo\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */