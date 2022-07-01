package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class TimeInfosElement implements Parcelable {
  public static final Parcelable.Creator<TimeInfosElement> CREATOR = new Parcelable.Creator<TimeInfosElement>() {
    
    };
  
  int a;
  
  float b;
  
  float c;
  
  int d;
  
  private List<TMC> e = new ArrayList<TMC>();
  
  public TimeInfosElement() {}
  
  public TimeInfosElement(Parcel paramParcel) {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readFloat();
    this.c = paramParcel.readFloat();
    this.d = paramParcel.readInt();
    this.e = paramParcel.createTypedArrayList(TMC.CREATOR);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public float getDuration() {
    return this.b;
  }
  
  public int getPathindex() {
    return this.a;
  }
  
  public int getRestriction() {
    return this.d;
  }
  
  public List<TMC> getTMCs() {
    return this.e;
  }
  
  public float getTolls() {
    return this.c;
  }
  
  public void setDuration(float paramFloat) {
    this.b = paramFloat;
  }
  
  public void setPathindex(int paramInt) {
    this.a = paramInt;
  }
  
  public void setRestriction(int paramInt) {
    this.d = paramInt;
  }
  
  public void setTMCs(List<TMC> paramList) {
    this.e = paramList;
  }
  
  public void setTolls(float paramFloat) {
    this.c = paramFloat;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.a);
    paramParcel.writeFloat(this.b);
    paramParcel.writeFloat(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeTypedList(this.e);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\TimeInfosElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */