package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore2d.cm;
import com.amap.api.maps2d.AMapException;

public final class LatLngBounds implements Parcelable {
  public static final e CREATOR = new e();
  
  private final int a;
  
  public final LatLng northeast;
  
  public final LatLng southwest;
  
  LatLngBounds(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2) throws AMapException {
    if (paramLatLng1 != null) {
      if (paramLatLng2 != null) {
        if (paramLatLng2.latitude >= paramLatLng1.latitude) {
          this.a = paramInt;
          this.southwest = paramLatLng1;
          this.northeast = paramLatLng2;
          return;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("southern latitude exceeds northern latitude (");
        stringBuilder.append(paramLatLng1.latitude);
        stringBuilder.append(" > ");
        stringBuilder.append(paramLatLng2.latitude);
        stringBuilder.append(")");
        throw new AMapException(stringBuilder.toString());
      } 
      throw new AMapException("null northeast");
    } 
    throw new AMapException("null southwest");
  }
  
  public LatLngBounds(LatLng paramLatLng1, LatLng paramLatLng2) throws AMapException {
    this(1, paramLatLng1, paramLatLng2);
  }
  
  private boolean a(double paramDouble) {
    return (this.southwest.latitude <= paramDouble && paramDouble <= this.northeast.latitude);
  }
  
  private boolean a(LatLngBounds paramLatLngBounds) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLatLngBounds != null) {
      LatLng latLng = paramLatLngBounds.northeast;
      bool1 = bool2;
      if (latLng != null) {
        bool1 = bool2;
        if (paramLatLngBounds.southwest != null) {
          bool1 = bool2;
          if (this.northeast != null) {
            if (this.southwest == null)
              return false; 
            double d1 = latLng.longitude;
            double d2 = paramLatLngBounds.southwest.longitude;
            double d3 = this.northeast.longitude;
            double d4 = this.southwest.longitude;
            double d5 = this.northeast.longitude;
            double d6 = this.southwest.longitude;
            double d7 = paramLatLngBounds.northeast.longitude;
            double d8 = this.southwest.longitude;
            double d9 = paramLatLngBounds.northeast.latitude;
            double d10 = paramLatLngBounds.southwest.latitude;
            double d11 = this.northeast.latitude;
            double d12 = this.southwest.latitude;
            double d13 = this.northeast.latitude;
            double d14 = this.southwest.latitude;
            double d15 = paramLatLngBounds.northeast.latitude;
            double d16 = paramLatLngBounds.southwest.latitude;
            bool1 = bool2;
            if (Math.abs(d1 + d2 - d3 - d4) < d5 - d6 + d7 - d8) {
              bool1 = bool2;
              if (Math.abs(d9 + d10 - d11 - d12) < d13 - d14 + d15 - d16)
                bool1 = true; 
            } 
          } 
        } 
      } 
    } 
    return bool1;
  }
  
  private boolean b(double paramDouble) {
    double d1 = this.southwest.longitude;
    double d2 = this.northeast.longitude;
    boolean bool1 = false;
    boolean bool2 = false;
    if (d1 <= d2) {
      bool1 = bool2;
      if (this.southwest.longitude <= paramDouble) {
        bool1 = bool2;
        if (paramDouble <= this.northeast.longitude)
          bool1 = true; 
      } 
      return bool1;
    } 
    if (this.southwest.longitude <= paramDouble || paramDouble <= this.northeast.longitude)
      bool1 = true; 
    return bool1;
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  private static double c(double paramDouble1, double paramDouble2) {
    return (paramDouble1 - paramDouble2 + 360.0D) % 360.0D;
  }
  
  private static double d(double paramDouble1, double paramDouble2) {
    return (paramDouble2 - paramDouble1 + 360.0D) % 360.0D;
  }
  
  int a() {
    return this.a;
  }
  
  public boolean contains(LatLng paramLatLng) {
    boolean bool2 = false;
    if (paramLatLng == null)
      return false; 
    boolean bool1 = bool2;
    if (a(paramLatLng.latitude)) {
      bool1 = bool2;
      if (b(paramLatLng.longitude))
        bool1 = true; 
    } 
    return bool1;
  }
  
  public boolean contains(LatLngBounds paramLatLngBounds) {
    boolean bool2 = false;
    if (paramLatLngBounds == null)
      return false; 
    boolean bool1 = bool2;
    if (contains(paramLatLngBounds.southwest)) {
      bool1 = bool2;
      if (contains(paramLatLngBounds.northeast))
        bool1 = true; 
    } 
    return bool1;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof LatLngBounds))
      return false; 
    paramObject = paramObject;
    return (this.southwest.equals(((LatLngBounds)paramObject).southwest) && this.northeast.equals(((LatLngBounds)paramObject).northeast));
  }
  
  public int hashCode() {
    return cm.a(new Object[] { this.southwest, this.northeast });
  }
  
  public LatLngBounds including(LatLng paramLatLng) {
    if (paramLatLng == null)
      return this; 
    double d1 = Math.min(this.southwest.latitude, paramLatLng.latitude);
    double d2 = Math.max(this.northeast.latitude, paramLatLng.latitude);
    double d3 = this.northeast.longitude;
    double d4 = this.southwest.longitude;
    double d5 = paramLatLng.longitude;
    if (!b(d5)) {
      c(d4, d5);
      d(d3, d5);
    } 
    try {
      return new LatLngBounds(new LatLng(d1, d5), new LatLng(d2, d5));
    } finally {
      paramLatLng = null;
      paramLatLng.printStackTrace();
    } 
  }
  
  public boolean intersects(LatLngBounds paramLatLngBounds) {
    boolean bool = false;
    if (paramLatLngBounds == null)
      return false; 
    if (a(paramLatLngBounds) || paramLatLngBounds.a(this))
      bool = true; 
    return bool;
  }
  
  public String toString() {
    return cm.a(new String[] { cm.a("southwest", this.southwest), cm.a("northeast", this.northeast) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    e.a(this, paramParcel, paramInt);
  }
  
  public static final class Builder {
    private double a = Double.POSITIVE_INFINITY;
    
    private double b = Double.NEGATIVE_INFINITY;
    
    private double c = Double.NaN;
    
    private double d = Double.NaN;
    
    private boolean a(double param1Double) {
      double d1 = this.c;
      double d2 = this.d;
      boolean bool1 = false;
      boolean bool2 = false;
      if (d1 <= d2) {
        bool1 = bool2;
        if (d1 <= param1Double) {
          bool1 = bool2;
          if (param1Double <= d2)
            bool1 = true; 
        } 
        return bool1;
      } 
      if (d1 <= param1Double || param1Double <= d2)
        bool1 = true; 
      return bool1;
    }
    
    public LatLngBounds build() {
      try {
        if (Double.isNaN(this.c))
          return null; 
        return new LatLngBounds(new LatLng(this.a, this.c), new LatLng(this.b, this.d));
      } finally {
        Exception exception = null;
        cm.a(exception, "LatLngBounds", "build");
      } 
    }
    
    public Builder include(LatLng param1LatLng) {
      if (param1LatLng == null)
        return this; 
      this.a = Math.min(this.a, param1LatLng.latitude);
      this.b = Math.max(this.b, param1LatLng.latitude);
      double d = param1LatLng.longitude;
      if (Double.isNaN(this.c)) {
        this.c = d;
        this.d = d;
        return this;
      } 
      if (!a(d)) {
        if (LatLngBounds.a(this.c, d) < LatLngBounds.b(this.d, d)) {
          this.c = d;
          return this;
        } 
        this.d = d;
      } 
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\LatLngBounds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */