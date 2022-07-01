package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class DrivePlanPath implements Parcelable {
  public static final Parcelable.Creator<DrivePlanPath> CREATOR = new Parcelable.Creator<DrivePlanPath>() {
    
    };
  
  float a;
  
  int b;
  
  private List<DrivePlanStep> c = new ArrayList<DrivePlanStep>();
  
  public DrivePlanPath() {}
  
  public DrivePlanPath(Parcel paramParcel) {
    this.a = paramParcel.readFloat();
    this.b = paramParcel.readInt();
    this.c = paramParcel.createTypedArrayList(DrivePlanStep.CREATOR);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public float getDistance() {
    return this.a;
  }
  
  public List<DrivePlanStep> getSteps() {
    return this.c;
  }
  
  public float getTrafficLights() {
    return this.b;
  }
  
  public void setDistance(float paramFloat) {
    this.a = paramFloat;
  }
  
  public void setSteps(List<DrivePlanStep> paramList) {
    this.c = paramList;
  }
  
  public void setTrafficLights(int paramInt) {
    this.b = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeFloat(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeTypedList(this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\DrivePlanPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */