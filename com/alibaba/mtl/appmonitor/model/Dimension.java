package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Dimension implements Parcelable {
  public static final Parcelable.Creator<Dimension> CREATOR = new Parcelable.Creator<Dimension>() {
      public Dimension[] a(int param1Int) {
        return new Dimension[param1Int];
      }
      
      public Dimension b(Parcel param1Parcel) {
        return Dimension.a(param1Parcel);
      }
    };
  
  protected String name;
  
  protected String y = "null";
  
  public Dimension() {}
  
  public Dimension(String paramString) {
    this(paramString, null);
  }
  
  public Dimension(String paramString1, String paramString2) {
    this.name = paramString1;
    if (paramString2 == null)
      paramString2 = "null"; 
    this.y = paramString2;
  }
  
  static Dimension a(Parcel paramParcel) {
    try {
      return new Dimension(paramParcel.readString(), str);
    } finally {
      paramParcel = null;
    } 
  }
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    String str = this.name;
    if (str == null) {
      if (((Dimension)paramObject).name != null)
        return false; 
    } else if (!str.equals(((Dimension)paramObject).name)) {
      return false;
    } 
    return true;
  }
  
  public String getConstantValue() {
    return this.y;
  }
  
  public String getName() {
    return this.name;
  }
  
  public int hashCode() {
    int i;
    String str = this.name;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    } 
    return 31 + i;
  }
  
  public void setConstantValue(String paramString) {
    this.y = paramString;
  }
  
  public void setName(String paramString) {
    this.name = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.y);
    paramParcel.writeString(this.name);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\Dimension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */