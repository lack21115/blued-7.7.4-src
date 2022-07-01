package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class CloudItemDetail extends CloudItem implements Parcelable {
  public static final Parcelable.Creator<CloudItemDetail> CREATOR = new Parcelable.Creator<CloudItemDetail>() {
    
    };
  
  protected CloudItemDetail(Parcel paramParcel) {
    super(paramParcel);
  }
  
  public CloudItemDetail(String paramString1, LatLonPoint paramLatLonPoint, String paramString2, String paramString3) {
    super(paramString1, paramLatLonPoint, paramString2, paramString3);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\cloud\CloudItemDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */