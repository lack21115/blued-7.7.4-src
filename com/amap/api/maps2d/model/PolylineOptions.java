package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolylineOptions implements Parcelable {
  public static final i CREATOR = new i();
  
  String a;
  
  private final List<LatLng> b = new ArrayList<LatLng>();
  
  private float c = 10.0F;
  
  private int d = -16777216;
  
  private float e = 0.0F;
  
  private boolean f = true;
  
  private boolean g = false;
  
  private boolean h = false;
  
  public PolylineOptions add(LatLng paramLatLng) {
    this.b.add(paramLatLng);
    return this;
  }
  
  public PolylineOptions add(LatLng... paramVarArgs) {
    this.b.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public PolylineOptions addAll(Iterable<LatLng> paramIterable) {
    if (paramIterable != null)
      try {
        ArrayList<LatLng> arrayList = new ArrayList();
        Iterator<LatLng> iterator = paramIterable.iterator();
        while (iterator != null && iterator.hasNext())
          arrayList.add(iterator.next()); 
        return this;
      } finally {
        paramIterable = null;
      }  
    return this;
  }
  
  public PolylineOptions color(int paramInt) {
    this.d = paramInt;
    return this;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public PolylineOptions geodesic(boolean paramBoolean) {
    this.g = paramBoolean;
    return this;
  }
  
  public int getColor() {
    return this.d;
  }
  
  public List<LatLng> getPoints() {
    return this.b;
  }
  
  public float getWidth() {
    return this.c;
  }
  
  public float getZIndex() {
    return this.e;
  }
  
  public boolean isDottedLine() {
    return this.h;
  }
  
  public boolean isGeodesic() {
    return this.g;
  }
  
  public boolean isVisible() {
    return this.f;
  }
  
  public PolylineOptions setDottedLine(boolean paramBoolean) {
    this.h = paramBoolean;
    return this;
  }
  
  public PolylineOptions visible(boolean paramBoolean) {
    this.f = paramBoolean;
    return this;
  }
  
  public PolylineOptions width(float paramFloat) {
    this.c = paramFloat;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeTypedList(getPoints());
    paramParcel.writeFloat(getWidth());
    paramParcel.writeInt(getColor());
    paramParcel.writeFloat(getZIndex());
    paramParcel.writeByte((byte)isVisible());
    paramParcel.writeString(this.a);
    paramParcel.writeByte((byte)isGeodesic());
    paramParcel.writeByte((byte)isDottedLine());
  }
  
  public PolylineOptions zIndex(float paramFloat) {
    this.e = paramFloat;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\PolylineOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */