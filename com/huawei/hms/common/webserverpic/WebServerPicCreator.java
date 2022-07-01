package com.huawei.hms.common.webserverpic;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public final class WebServerPicCreator implements Parcelable.Creator<WebServerPic> {
  public WebServerPic createFromParcel(Parcel paramParcel) {
    return new WebServerPic((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()), paramParcel.readInt(), paramParcel.readInt());
  }
  
  public WebServerPic[] newArray(int paramInt) {
    return new WebServerPic[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\webserverpic\WebServerPicCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */