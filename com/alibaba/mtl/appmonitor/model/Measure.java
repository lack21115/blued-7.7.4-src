package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Measure implements Parcelable {
  public static final Parcelable.Creator<Measure> CREATOR = new Parcelable.Creator<Measure>() {
      public Measure[] a(int param1Int) {
        return new Measure[param1Int];
      }
      
      public Measure b(Parcel param1Parcel) {
        return Measure.a(param1Parcel);
      }
    };
  
  protected Double a;
  
  protected Double b;
  
  protected Double c;
  
  protected String name;
  
  public Measure(String paramString) {
    this(paramString, Double.valueOf(0.0D));
  }
  
  public Measure(String paramString, Double paramDouble) {
    this(paramString, paramDouble, Double.valueOf(0.0D), null);
  }
  
  public Measure(String paramString, Double paramDouble1, Double paramDouble2, Double paramDouble3) {
    double d = 0.0D;
    Double double_ = Double.valueOf(0.0D);
    this.a = double_;
    this.b = double_;
    this.c = double_;
    this.a = paramDouble2;
    this.b = paramDouble3;
    this.name = paramString;
    if (paramDouble1 != null)
      d = paramDouble1.doubleValue(); 
    this.c = Double.valueOf(d);
  }
  
  static Measure a(Parcel paramParcel) {
    Double double_1;
    Double double_2;
    String str;
    try {
      int i = paramParcel.readInt();
      boolean bool = true;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i == 0) {
        double_1 = Double.valueOf(paramParcel.readDouble());
      } else {
        double_1 = null;
      } 
      if (paramParcel.readInt() == 0) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i == 0) {
        double_2 = Double.valueOf(paramParcel.readDouble());
      } else {
        double_2 = null;
      } 
      str = paramParcel.readString();
    } finally {
      paramParcel = null;
      paramParcel.printStackTrace();
    } 
    paramParcel = null;
    return new Measure(str, (Double)paramParcel, double_2, double_1);
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
      if (((Measure)paramObject).name != null)
        return false; 
    } else if (!str.equals(((Measure)paramObject).name)) {
      return false;
    } 
    return true;
  }
  
  public Double getConstantValue() {
    return this.c;
  }
  
  public Double getMax() {
    return this.b;
  }
  
  public Double getMin() {
    return this.a;
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
  
  public void setConstantValue(Double paramDouble) {
    this.c = paramDouble;
  }
  
  public void setMax(Double paramDouble) {
    this.b = paramDouble;
  }
  
  public void setMin(Double paramDouble) {
    this.a = paramDouble;
  }
  
  public void setRange(Double paramDouble1, Double paramDouble2) {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public boolean valid(MeasureValue paramMeasureValue) {
    Double double_ = Double.valueOf(paramMeasureValue.getValue());
    return (double_ != null && (this.a == null || double_.doubleValue() >= this.a.doubleValue()) && (this.b == null || double_.doubleValue() <= this.b.doubleValue()));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    try {
      Double double_ = this.b;
      boolean bool = false;
      if (double_ == null) {
        paramInt = 0;
      } else {
        paramInt = 1;
      } 
      paramParcel.writeInt(paramInt);
      if (this.b != null)
        paramParcel.writeDouble(this.b.doubleValue()); 
      if (this.a == null) {
        paramInt = 0;
      } else {
        paramInt = 1;
      } 
      paramParcel.writeInt(paramInt);
      if (this.a != null)
        paramParcel.writeDouble(this.a.doubleValue()); 
      paramParcel.writeString(this.name);
      if (this.c == null) {
        paramInt = bool;
      } else {
        paramInt = 1;
      } 
      paramParcel.writeInt(paramInt);
      return;
    } finally {
      paramParcel = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\Measure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */