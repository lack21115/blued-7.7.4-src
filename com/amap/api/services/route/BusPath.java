package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class BusPath extends Path implements Parcelable {
  public static final Parcelable.Creator<BusPath> CREATOR = new Parcelable.Creator<BusPath>() {
    
    };
  
  private float a;
  
  private boolean b;
  
  private float c;
  
  private float d;
  
  private List<BusStep> e = new ArrayList<BusStep>();
  
  public BusPath() {}
  
  public BusPath(Parcel paramParcel) {
    super(paramParcel);
    this.a = paramParcel.readFloat();
    boolean[] arrayOfBoolean = new boolean[1];
    paramParcel.readBooleanArray(arrayOfBoolean);
    this.b = arrayOfBoolean[0];
    this.c = paramParcel.readFloat();
    this.d = paramParcel.readFloat();
    this.e = paramParcel.createTypedArrayList(BusStep.CREATOR);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public float getBusDistance() {
    return this.d;
  }
  
  public float getCost() {
    return this.a;
  }
  
  public List<BusStep> getSteps() {
    return this.e;
  }
  
  public float getWalkDistance() {
    return this.c;
  }
  
  public boolean isNightBus() {
    return this.b;
  }
  
  public void setBusDistance(float paramFloat) {
    this.d = paramFloat;
  }
  
  public void setCost(float paramFloat) {
    this.a = paramFloat;
  }
  
  public void setNightBus(boolean paramBoolean) {
    this.b = paramBoolean;
  }
  
  public void setSteps(List<BusStep> paramList) {
    this.e = paramList;
  }
  
  public void setWalkDistance(float paramFloat) {
    this.c = paramFloat;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.a);
    paramParcel.writeBooleanArray(new boolean[] { this.b });
    paramParcel.writeFloat(this.c);
    paramParcel.writeFloat(this.d);
    paramParcel.writeTypedList(this.e);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\route\BusPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */