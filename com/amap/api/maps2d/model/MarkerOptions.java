package com.amap.api.maps2d.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class MarkerOptions implements Parcelable {
  public static final g CREATOR = new g();
  
  String a;
  
  private LatLng b;
  
  private String c;
  
  private String d;
  
  private float e = 0.5F;
  
  private float f = 1.0F;
  
  private boolean g = false;
  
  private boolean h = true;
  
  private boolean i = false;
  
  private float j;
  
  private ArrayList<BitmapDescriptor> k = new ArrayList<BitmapDescriptor>();
  
  private int l = 20;
  
  private void a() {
    if (this.k == null)
      this.k = new ArrayList<BitmapDescriptor>(); 
  }
  
  public MarkerOptions anchor(float paramFloat1, float paramFloat2) {
    this.e = paramFloat1;
    this.f = paramFloat2;
    return this;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public MarkerOptions draggable(boolean paramBoolean) {
    this.g = paramBoolean;
    return this;
  }
  
  public float getAnchorU() {
    return this.e;
  }
  
  public float getAnchorV() {
    return this.f;
  }
  
  public BitmapDescriptor getIcon() {
    ArrayList<BitmapDescriptor> arrayList = this.k;
    return (arrayList != null && arrayList.size() != 0) ? this.k.get(0) : null;
  }
  
  public ArrayList<BitmapDescriptor> getIcons() {
    return this.k;
  }
  
  public int getPeriod() {
    return this.l;
  }
  
  public LatLng getPosition() {
    return this.b;
  }
  
  public String getSnippet() {
    return this.d;
  }
  
  public String getTitle() {
    return this.c;
  }
  
  public float getZIndex() {
    return this.j;
  }
  
  public MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor) {
    try {
      a();
      this.k.clear();
      return this;
    } finally {
      paramBitmapDescriptor = null;
    } 
  }
  
  public MarkerOptions icons(ArrayList<BitmapDescriptor> paramArrayList) {
    this.k = paramArrayList;
    return this;
  }
  
  public boolean isDraggable() {
    return this.g;
  }
  
  public boolean isGps() {
    return this.i;
  }
  
  public boolean isVisible() {
    return this.h;
  }
  
  public MarkerOptions period(int paramInt) {
    if (paramInt <= 1) {
      this.l = 1;
      return this;
    } 
    this.l = paramInt;
    return this;
  }
  
  public MarkerOptions position(LatLng paramLatLng) {
    this.b = paramLatLng;
    return this;
  }
  
  public MarkerOptions setGps(boolean paramBoolean) {
    this.i = paramBoolean;
    return this;
  }
  
  public MarkerOptions snippet(String paramString) {
    this.d = paramString;
    return this;
  }
  
  public MarkerOptions title(String paramString) {
    this.c = paramString;
    return this;
  }
  
  public MarkerOptions visible(boolean paramBoolean) {
    this.h = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeParcelable(this.b, paramInt);
    ArrayList<BitmapDescriptor> arrayList = this.k;
    if (arrayList != null && arrayList.size() != 0)
      paramParcel.writeParcelable(this.k.get(0), paramInt); 
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeFloat(this.e);
    paramParcel.writeFloat(this.f);
    paramParcel.writeByte((byte)this.h);
    paramParcel.writeByte((byte)this.g);
    paramParcel.writeByte((byte)this.i);
    paramParcel.writeString(this.a);
    paramParcel.writeFloat(this.j);
    paramParcel.writeList(this.k);
  }
  
  public MarkerOptions zIndex(float paramFloat) {
    this.j = paramFloat;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\MarkerOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */