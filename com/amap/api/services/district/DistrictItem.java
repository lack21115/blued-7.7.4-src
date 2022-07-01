package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class DistrictItem implements Parcelable {
  public static final Parcelable.Creator<DistrictItem> CREATOR = new Parcelable.Creator<DistrictItem>() {
    
    };
  
  private String a;
  
  private String b;
  
  private String c;
  
  private LatLonPoint d;
  
  private String e;
  
  private List<DistrictItem> f = new ArrayList<DistrictItem>();
  
  private String[] g = new String[0];
  
  public DistrictItem() {}
  
  public DistrictItem(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = (LatLonPoint)paramParcel.readParcelable(LatLonPoint.class.getClassLoader());
    this.e = paramParcel.readString();
    this.f = paramParcel.createTypedArrayList(CREATOR);
    this.g = new String[paramParcel.readInt()];
    paramParcel.readStringArray(this.g);
  }
  
  public DistrictItem(String paramString1, String paramString2, String paramString3, LatLonPoint paramLatLonPoint, String paramString4) {
    this.c = paramString1;
    this.a = paramString2;
    this.b = paramString3;
    this.d = paramLatLonPoint;
    this.e = paramString4;
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final String[] districtBoundary() {
    return this.g;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    String str3 = this.b;
    if (str3 == null) {
      if (((DistrictItem)paramObject).b != null)
        return false; 
    } else if (!str3.equals(((DistrictItem)paramObject).b)) {
      return false;
    } 
    LatLonPoint latLonPoint = this.d;
    if (latLonPoint == null) {
      if (((DistrictItem)paramObject).d != null)
        return false; 
    } else if (!latLonPoint.equals(((DistrictItem)paramObject).d)) {
      return false;
    } 
    String str2 = this.a;
    if (str2 == null) {
      if (((DistrictItem)paramObject).a != null)
        return false; 
    } else if (!str2.equals(((DistrictItem)paramObject).a)) {
      return false;
    } 
    if (!Arrays.equals((Object[])this.g, (Object[])((DistrictItem)paramObject).g))
      return false; 
    List<DistrictItem> list = this.f;
    if (list == null) {
      if (((DistrictItem)paramObject).f != null)
        return false; 
    } else if (!list.equals(((DistrictItem)paramObject).f)) {
      return false;
    } 
    String str1 = this.e;
    if (str1 == null) {
      if (((DistrictItem)paramObject).e != null)
        return false; 
    } else if (!str1.equals(((DistrictItem)paramObject).e)) {
      return false;
    } 
    str1 = this.c;
    if (str1 == null) {
      if (((DistrictItem)paramObject).c != null)
        return false; 
    } else if (!str1.equals(((DistrictItem)paramObject).c)) {
      return false;
    } 
    return true;
  }
  
  public final String getAdcode() {
    return this.b;
  }
  
  public final LatLonPoint getCenter() {
    return this.d;
  }
  
  public final String getCitycode() {
    return this.a;
  }
  
  public final String getLevel() {
    return this.e;
  }
  
  public final String getName() {
    return this.c;
  }
  
  public final List<DistrictItem> getSubDistrict() {
    return this.f;
  }
  
  public final int hashCode() {
    int i;
    int j;
    int k;
    int m;
    int n;
    String str3 = this.b;
    int i1 = 0;
    if (str3 == null) {
      i = 0;
    } else {
      i = str3.hashCode();
    } 
    LatLonPoint latLonPoint = this.d;
    if (latLonPoint == null) {
      j = 0;
    } else {
      j = latLonPoint.hashCode();
    } 
    String str2 = this.a;
    if (str2 == null) {
      k = 0;
    } else {
      k = str2.hashCode();
    } 
    int i2 = Arrays.hashCode((Object[])this.g);
    List<DistrictItem> list = this.f;
    if (list == null) {
      m = 0;
    } else {
      m = list.hashCode();
    } 
    String str1 = this.e;
    if (str1 == null) {
      n = 0;
    } else {
      n = str1.hashCode();
    } 
    str1 = this.c;
    if (str1 != null)
      i1 = str1.hashCode(); 
    return ((((((i + 31) * 31 + j) * 31 + k) * 31 + i2) * 31 + m) * 31 + n) * 31 + i1;
  }
  
  public final void setAdcode(String paramString) {
    this.b = paramString;
  }
  
  public final void setCenter(LatLonPoint paramLatLonPoint) {
    this.d = paramLatLonPoint;
  }
  
  public final void setCitycode(String paramString) {
    this.a = paramString;
  }
  
  public final void setDistrictBoundary(String[] paramArrayOfString) {
    this.g = paramArrayOfString;
  }
  
  public final void setLevel(String paramString) {
    this.e = paramString;
  }
  
  public final void setName(String paramString) {
    this.c = paramString;
  }
  
  public final void setSubDistrict(ArrayList<DistrictItem> paramArrayList) {
    this.f = paramArrayList;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("DistrictItem [mCitycode=");
    stringBuilder.append(this.a);
    stringBuilder.append(", mAdcode=");
    stringBuilder.append(this.b);
    stringBuilder.append(", mName=");
    stringBuilder.append(this.c);
    stringBuilder.append(", mCenter=");
    stringBuilder.append(this.d);
    stringBuilder.append(", mLevel=");
    stringBuilder.append(this.e);
    stringBuilder.append(", mDistricts=");
    stringBuilder.append(this.f);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeParcelable((Parcelable)this.d, paramInt);
    paramParcel.writeString(this.e);
    paramParcel.writeTypedList(this.f);
    paramParcel.writeInt(this.g.length);
    paramParcel.writeStringArray(this.g);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\district\DistrictItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */