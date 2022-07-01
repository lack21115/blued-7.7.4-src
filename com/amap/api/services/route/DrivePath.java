package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class DrivePath extends Path implements Parcelable {
  public static final Parcelable.Creator<DrivePath> CREATOR = new Parcelable.Creator<DrivePath>() {
    
    };
  
  private String a;
  
  private float b;
  
  private float c;
  
  private int d;
  
  private List<DriveStep> e = new ArrayList<DriveStep>();
  
  private int f;
  
  public DrivePath() {}
  
  public DrivePath(Parcel paramParcel) {
    super(paramParcel);
    this.a = paramParcel.readString();
    this.b = paramParcel.readFloat();
    this.c = paramParcel.readFloat();
    this.e = paramParcel.createTypedArrayList(DriveStep.CREATOR);
    this.d = paramParcel.readInt();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public int getRestriction() {
    return this.f;
  }
  
  public List<DriveStep> getSteps() {
    return this.e;
  }
  
  public String getStrategy() {
    return this.a;
  }
  
  public float getTollDistance() {
    return this.c;
  }
  
  public float getTolls() {
    return this.b;
  }
  
  public int getTotalTrafficlights() {
    return this.d;
  }
  
  public void setRestriction(int paramInt) {
    this.f = paramInt;
  }
  
  public void setSteps(List<DriveStep> paramList) {
    this.e = paramList;
  }
  
  public void setStrategy(String paramString) {
    this.a = paramString;
  }
  
  public void setTollDistance(float paramFloat) {
    this.c = paramFloat;
  }
  
  public void setTolls(float paramFloat) {
    this.b = paramFloat;
  }
  
  public void setTotalTrafficlights(int paramInt) {
    this.d = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeFloat(this.b);
    paramParcel.writeFloat(this.c);
    paramParcel.writeTypedList(this.e);
    paramParcel.writeInt(this.d);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\DrivePath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */