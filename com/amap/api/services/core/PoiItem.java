package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.SubPoiItem;
import java.util.ArrayList;
import java.util.List;

public class PoiItem implements Parcelable {
  public static final Parcelable.Creator<PoiItem> CREATOR = new Parcelable.Creator<PoiItem>() {
    
    };
  
  private String A;
  
  private String B;
  
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e = "";
  
  private int f = -1;
  
  private final LatLonPoint g;
  
  private final String h;
  
  private final String i;
  
  private LatLonPoint j;
  
  private LatLonPoint k;
  
  private String l;
  
  private String m;
  
  private String n;
  
  private String o;
  
  private String p;
  
  private String q;
  
  private String r;
  
  private boolean s;
  
  private IndoorData t;
  
  private String u;
  
  private String v;
  
  private String w;
  
  private List<SubPoiItem> x = new ArrayList<SubPoiItem>();
  
  private List<Photo> y = new ArrayList<Photo>();
  
  private PoiItemExtension z;
  
  protected PoiItem(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.c = paramParcel.readString();
    this.b = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readInt();
    this.g = (LatLonPoint)paramParcel.readValue(LatLonPoint.class.getClassLoader());
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.d = paramParcel.readString();
    this.j = (LatLonPoint)paramParcel.readValue(LatLonPoint.class.getClassLoader());
    this.k = (LatLonPoint)paramParcel.readValue(LatLonPoint.class.getClassLoader());
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    boolean[] arrayOfBoolean = new boolean[1];
    paramParcel.readBooleanArray(arrayOfBoolean);
    this.s = arrayOfBoolean[0];
    this.o = paramParcel.readString();
    this.p = paramParcel.readString();
    this.q = paramParcel.readString();
    this.r = paramParcel.readString();
    this.u = paramParcel.readString();
    this.v = paramParcel.readString();
    this.w = paramParcel.readString();
    this.x = paramParcel.readArrayList(SubPoiItem.class.getClassLoader());
    this.t = (IndoorData)paramParcel.readValue(IndoorData.class.getClassLoader());
    this.y = paramParcel.createTypedArrayList(Photo.CREATOR);
    this.z = (PoiItemExtension)paramParcel.readParcelable(PoiItemExtension.class.getClassLoader());
    this.A = paramParcel.readString();
    this.B = paramParcel.readString();
  }
  
  public PoiItem(String paramString1, LatLonPoint paramLatLonPoint, String paramString2, String paramString3) {
    this.a = paramString1;
    this.g = paramLatLonPoint;
    this.h = paramString2;
    this.i = paramString3;
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
    String str = this.a;
    if (str == null) {
      if (((PoiItem)paramObject).a != null)
        return false; 
    } else if (!str.equals(((PoiItem)paramObject).a)) {
      return false;
    } 
    return true;
  }
  
  public String getAdCode() {
    return this.c;
  }
  
  public String getAdName() {
    return this.r;
  }
  
  public String getBusinessArea() {
    return this.v;
  }
  
  public String getCityCode() {
    return this.d;
  }
  
  public String getCityName() {
    return this.q;
  }
  
  public String getDirection() {
    return this.o;
  }
  
  public int getDistance() {
    return this.f;
  }
  
  public String getEmail() {
    return this.n;
  }
  
  public LatLonPoint getEnter() {
    return this.j;
  }
  
  public LatLonPoint getExit() {
    return this.k;
  }
  
  public IndoorData getIndoorData() {
    return this.t;
  }
  
  public LatLonPoint getLatLonPoint() {
    return this.g;
  }
  
  public String getParkingType() {
    return this.w;
  }
  
  public List<Photo> getPhotos() {
    return this.y;
  }
  
  public PoiItemExtension getPoiExtension() {
    return this.z;
  }
  
  public String getPoiId() {
    return this.a;
  }
  
  public String getPostcode() {
    return this.m;
  }
  
  public String getProvinceCode() {
    return this.u;
  }
  
  public String getProvinceName() {
    return this.p;
  }
  
  public String getShopID() {
    return this.B;
  }
  
  public String getSnippet() {
    return this.i;
  }
  
  public List<SubPoiItem> getSubPois() {
    return this.x;
  }
  
  public String getTel() {
    return this.b;
  }
  
  public String getTitle() {
    return this.h;
  }
  
  public String getTypeCode() {
    return this.A;
  }
  
  public String getTypeDes() {
    return this.e;
  }
  
  public String getWebsite() {
    return this.l;
  }
  
  public int hashCode() {
    int i;
    String str = this.a;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    } 
    return i + 31;
  }
  
  public boolean isIndoorMap() {
    return this.s;
  }
  
  public void setAdCode(String paramString) {
    this.c = paramString;
  }
  
  public void setAdName(String paramString) {
    this.r = paramString;
  }
  
  public void setBusinessArea(String paramString) {
    this.v = paramString;
  }
  
  public void setCityCode(String paramString) {
    this.d = paramString;
  }
  
  public void setCityName(String paramString) {
    this.q = paramString;
  }
  
  public void setDirection(String paramString) {
    this.o = paramString;
  }
  
  public void setDistance(int paramInt) {
    this.f = paramInt;
  }
  
  public void setEmail(String paramString) {
    this.n = paramString;
  }
  
  public void setEnter(LatLonPoint paramLatLonPoint) {
    this.j = paramLatLonPoint;
  }
  
  public void setExit(LatLonPoint paramLatLonPoint) {
    this.k = paramLatLonPoint;
  }
  
  public void setIndoorDate(IndoorData paramIndoorData) {
    this.t = paramIndoorData;
  }
  
  public void setIndoorMap(boolean paramBoolean) {
    this.s = paramBoolean;
  }
  
  public void setParkingType(String paramString) {
    this.w = paramString;
  }
  
  public void setPhotos(List<Photo> paramList) {
    this.y = paramList;
  }
  
  public void setPoiExtension(PoiItemExtension paramPoiItemExtension) {
    this.z = paramPoiItemExtension;
  }
  
  public void setPostcode(String paramString) {
    this.m = paramString;
  }
  
  public void setProvinceCode(String paramString) {
    this.u = paramString;
  }
  
  public void setProvinceName(String paramString) {
    this.p = paramString;
  }
  
  public void setShopID(String paramString) {
    this.B = paramString;
  }
  
  public void setSubPois(List<SubPoiItem> paramList) {
    this.x = paramList;
  }
  
  public void setTel(String paramString) {
    this.b = paramString;
  }
  
  public void setTypeCode(String paramString) {
    this.A = paramString;
  }
  
  public void setTypeDes(String paramString) {
    this.e = paramString;
  }
  
  public void setWebsite(String paramString) {
    this.l = paramString;
  }
  
  public String toString() {
    return this.h;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeValue(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.d);
    paramParcel.writeValue(this.j);
    paramParcel.writeValue(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeBooleanArray(new boolean[] { this.s });
    paramParcel.writeString(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.q);
    paramParcel.writeString(this.r);
    paramParcel.writeString(this.u);
    paramParcel.writeString(this.v);
    paramParcel.writeString(this.w);
    paramParcel.writeList(this.x);
    paramParcel.writeValue(this.t);
    paramParcel.writeTypedList(this.y);
    paramParcel.writeParcelable((Parcelable)this.z, paramInt);
    paramParcel.writeString(this.A);
    paramParcel.writeString(this.B);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\core\PoiItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */