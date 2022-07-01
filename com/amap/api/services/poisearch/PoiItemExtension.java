package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

public class PoiItemExtension implements Parcelable {
  public static final Parcelable.Creator<PoiItemExtension> CREATOR = new Parcelable.Creator<PoiItemExtension>() {
    
    };
  
  private String a;
  
  private String b;
  
  protected PoiItemExtension(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  public PoiItemExtension(String paramString1, String paramString2) {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getOpentime() {
    return this.a;
  }
  
  public String getmRating() {
    return this.b;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\poisearch\PoiItemExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */