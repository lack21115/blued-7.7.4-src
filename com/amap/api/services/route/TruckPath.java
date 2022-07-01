package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class TruckPath implements Parcelable {
  public static final Parcelable.Creator<TruckPath> CREATOR = new Parcelable.Creator<TruckPath>() {
    
    };
  
  private float a;
  
  private long b;
  
  private String c;
  
  private float d;
  
  private float e;
  
  private int f;
  
  private int g;
  
  private List<TruckStep> h;
  
  public TruckPath() {}
  
  protected TruckPath(Parcel paramParcel) {
    this.a = paramParcel.readFloat();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readString();
    this.d = paramParcel.readFloat();
    this.e = paramParcel.readFloat();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.createTypedArrayList(TruckStep.CREATOR);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public float getDistance() {
    return this.a;
  }
  
  public long getDuration() {
    return this.b;
  }
  
  public int getRestriction() {
    return this.g;
  }
  
  public List<TruckStep> getSteps() {
    return this.h;
  }
  
  public String getStrategy() {
    return this.c;
  }
  
  public float getTollDistance() {
    return this.e;
  }
  
  public float getTolls() {
    return this.d;
  }
  
  public int getTotalTrafficlights() {
    return this.f;
  }
  
  public void setDistance(float paramFloat) {
    this.a = paramFloat;
  }
  
  public void setDuration(long paramLong) {
    this.b = paramLong;
  }
  
  public void setRestriction(int paramInt) {
    this.g = paramInt;
  }
  
  public void setSteps(List<TruckStep> paramList) {
    this.h = paramList;
  }
  
  public void setStrategy(String paramString) {
    this.c = paramString;
  }
  
  public void setTollDistance(float paramFloat) {
    this.e = paramFloat;
  }
  
  public void setTolls(float paramFloat) {
    this.d = paramFloat;
  }
  
  public void setTotalTrafficlights(int paramInt) {
    this.f = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeFloat(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeFloat(this.d);
    paramParcel.writeFloat(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeTypedList(this.h);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\TruckPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */