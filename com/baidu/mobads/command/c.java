package com.baidu.mobads.command;

import android.os.Parcel;
import android.os.Parcelable;

final class c implements Parcelable.Creator<XAdLandingPageExtraInfo> {
  public XAdLandingPageExtraInfo a(Parcel paramParcel) {
    return new XAdLandingPageExtraInfo(paramParcel, null);
  }
  
  public XAdLandingPageExtraInfo[] a(int paramInt) {
    return new XAdLandingPageExtraInfo[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\command\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */