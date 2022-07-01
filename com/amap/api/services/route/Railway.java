package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

public class Railway implements Parcelable {
  public static final Parcelable.Creator<Railway> CREATOR = new Parcelable.Creator<Railway>() {
    
    };
  
  private String a;
  
  private String b;
  
  public Railway() {}
  
  protected Railway(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getID() {
    return this.a;
  }
  
  public String getName() {
    return this.b;
  }
  
  public void setID(String paramString) {
    this.a = paramString;
  }
  
  public void setName(String paramString) {
    this.b = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\Railway.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */