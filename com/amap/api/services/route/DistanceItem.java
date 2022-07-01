package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

public class DistanceItem implements Parcelable {
  public static final Parcelable.Creator<DistanceItem> CREATOR = new Parcelable.Creator<DistanceItem>() {
    
    };
  
  public final int ERROR_CODE_NOT_IN_CHINA = 3;
  
  public final int ERROR_CODE_NO_DRIVE = 1;
  
  public final int ERROR_CODE_TOO_FAR = 2;
  
  private int a = 1;
  
  private int b = 1;
  
  private float c = 0.0F;
  
  private float d = 0.0F;
  
  private String e;
  
  private int f;
  
  public DistanceItem() {}
  
  protected DistanceItem(Parcel paramParcel) {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readFloat();
    this.d = paramParcel.readFloat();
    this.e = paramParcel.readString();
    this.f = paramParcel.readInt();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public int getDestId() {
    return this.b;
  }
  
  public float getDistance() {
    return this.c;
  }
  
  public float getDuration() {
    return this.d;
  }
  
  public int getErrorCode() {
    return this.f;
  }
  
  public String getErrorInfo() {
    return this.e;
  }
  
  public int getOriginId() {
    return this.a;
  }
  
  public void setDestId(int paramInt) {
    this.b = paramInt;
  }
  
  public void setDistance(float paramFloat) {
    this.c = paramFloat;
  }
  
  public void setDuration(float paramFloat) {
    this.d = paramFloat;
  }
  
  public void setErrorCode(int paramInt) {
    this.f = paramInt;
  }
  
  public void setErrorInfo(String paramString) {
    this.e = paramString;
  }
  
  public void setOriginId(int paramInt) {
    this.a = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeFloat(this.c);
    paramParcel.writeFloat(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.f);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\DistanceItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */