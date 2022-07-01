package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.road.Road;
import java.util.ArrayList;
import java.util.List;

public final class RegeocodeAddress implements Parcelable {
  public static final Parcelable.Creator<RegeocodeAddress> CREATOR = new Parcelable.Creator<RegeocodeAddress>() {
    
    };
  
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private StreetNumber h;
  
  private String i;
  
  private String j;
  
  private String k;
  
  private List<RegeocodeRoad> l = new ArrayList<RegeocodeRoad>();
  
  private List<Crossroad> m = new ArrayList<Crossroad>();
  
  private List<PoiItem> n = new ArrayList<PoiItem>();
  
  private List<BusinessArea> o = new ArrayList<BusinessArea>();
  
  private List<AoiItem> p = new ArrayList<AoiItem>();
  
  private String q;
  
  private String r;
  
  public RegeocodeAddress() {}
  
  private RegeocodeAddress(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = (StreetNumber)paramParcel.readValue(StreetNumber.class.getClassLoader());
    this.l = paramParcel.readArrayList(Road.class.getClassLoader());
    this.m = paramParcel.readArrayList(Crossroad.class.getClassLoader());
    this.n = paramParcel.readArrayList(PoiItem.class.getClassLoader());
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.o = paramParcel.readArrayList(BusinessArea.class.getClassLoader());
    this.p = paramParcel.readArrayList(AoiItem.class.getClassLoader());
    this.k = paramParcel.readString();
    this.q = paramParcel.readString();
    this.r = paramParcel.readString();
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final String getAdCode() {
    return this.j;
  }
  
  public final List<AoiItem> getAois() {
    return this.p;
  }
  
  public final String getBuilding() {
    return this.g;
  }
  
  public final List<BusinessArea> getBusinessAreas() {
    return this.o;
  }
  
  public final String getCity() {
    return this.c;
  }
  
  public final String getCityCode() {
    return this.i;
  }
  
  public final String getCountry() {
    return this.q;
  }
  
  public final String getCountryCode() {
    return this.r;
  }
  
  public final List<Crossroad> getCrossroads() {
    return this.m;
  }
  
  public final String getDistrict() {
    return this.d;
  }
  
  public final String getFormatAddress() {
    return this.a;
  }
  
  public final String getNeighborhood() {
    return this.f;
  }
  
  public final List<PoiItem> getPois() {
    return this.n;
  }
  
  public final String getProvince() {
    return this.b;
  }
  
  public final List<RegeocodeRoad> getRoads() {
    return this.l;
  }
  
  public final StreetNumber getStreetNumber() {
    return this.h;
  }
  
  public final String getTowncode() {
    return this.k;
  }
  
  public final String getTownship() {
    return this.e;
  }
  
  public final void setAdCode(String paramString) {
    this.j = paramString;
  }
  
  public final void setAois(List<AoiItem> paramList) {
    this.p = paramList;
  }
  
  public final void setBuilding(String paramString) {
    this.g = paramString;
  }
  
  public final void setBusinessAreas(List<BusinessArea> paramList) {
    this.o = paramList;
  }
  
  public final void setCity(String paramString) {
    this.c = paramString;
  }
  
  public final void setCityCode(String paramString) {
    this.i = paramString;
  }
  
  public final void setCountry(String paramString) {
    this.q = paramString;
  }
  
  public final void setCountryCode(String paramString) {
    this.r = paramString;
  }
  
  public final void setCrossroads(List<Crossroad> paramList) {
    this.m = paramList;
  }
  
  public final void setDistrict(String paramString) {
    this.d = paramString;
  }
  
  public final void setFormatAddress(String paramString) {
    this.a = paramString;
  }
  
  public final void setNeighborhood(String paramString) {
    this.f = paramString;
  }
  
  public final void setPois(List<PoiItem> paramList) {
    this.n = paramList;
  }
  
  public final void setProvince(String paramString) {
    this.b = paramString;
  }
  
  public final void setRoads(List<RegeocodeRoad> paramList) {
    this.l = paramList;
  }
  
  public final void setStreetNumber(StreetNumber paramStreetNumber) {
    this.h = paramStreetNumber;
  }
  
  public final void setTowncode(String paramString) {
    this.k = paramString;
  }
  
  public final void setTownship(String paramString) {
    this.e = paramString;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeValue(this.h);
    paramParcel.writeList(this.l);
    paramParcel.writeList(this.m);
    paramParcel.writeList(this.n);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeList(this.o);
    paramParcel.writeList(this.p);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.q);
    paramParcel.writeString(this.r);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\geocoder\RegeocodeAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */