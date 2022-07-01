package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import java.util.ArrayList;

public final class DistrictResult implements Parcelable {
  public Parcelable.Creator<DistrictResult> CREATOR = new Parcelable.Creator<DistrictResult>(this) {
    
    };
  
  private DistrictSearchQuery a;
  
  private ArrayList<DistrictItem> b = new ArrayList<DistrictItem>();
  
  private int c;
  
  private AMapException d;
  
  public DistrictResult() {}
  
  protected DistrictResult(Parcel paramParcel) {
    this.a = (DistrictSearchQuery)paramParcel.readParcelable(DistrictSearchQuery.class.getClassLoader());
    this.b = paramParcel.createTypedArrayList(DistrictItem.CREATOR);
  }
  
  public DistrictResult(DistrictSearchQuery paramDistrictSearchQuery, ArrayList<DistrictItem> paramArrayList) {
    this.a = paramDistrictSearchQuery;
    this.b = paramArrayList;
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    DistrictSearchQuery districtSearchQuery = this.a;
    if (districtSearchQuery == null) {
      if (((DistrictResult)paramObject).a != null)
        return false; 
    } else if (!districtSearchQuery.equals(((DistrictResult)paramObject).a)) {
      return false;
    } 
    ArrayList<DistrictItem> arrayList = this.b;
    if (arrayList == null) {
      if (((DistrictResult)paramObject).b != null)
        return false; 
    } else if (!arrayList.equals(((DistrictResult)paramObject).b)) {
      return false;
    } 
    return true;
  }
  
  public final AMapException getAMapException() {
    return this.d;
  }
  
  public final ArrayList<DistrictItem> getDistrict() {
    return this.b;
  }
  
  public final int getPageCount() {
    return this.c;
  }
  
  public final DistrictSearchQuery getQuery() {
    return this.a;
  }
  
  public final int hashCode() {
    int i;
    DistrictSearchQuery districtSearchQuery = this.a;
    int j = 0;
    if (districtSearchQuery == null) {
      i = 0;
    } else {
      i = districtSearchQuery.hashCode();
    } 
    ArrayList<DistrictItem> arrayList = this.b;
    if (arrayList != null)
      j = arrayList.hashCode(); 
    return (i + 31) * 31 + j;
  }
  
  public final void setAMapException(AMapException paramAMapException) {
    this.d = paramAMapException;
  }
  
  public final void setDistrict(ArrayList<DistrictItem> paramArrayList) {
    this.b = paramArrayList;
  }
  
  public final void setPageCount(int paramInt) {
    this.c = paramInt;
  }
  
  public final void setQuery(DistrictSearchQuery paramDistrictSearchQuery) {
    this.a = paramDistrictSearchQuery;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("DistrictResult [mDisQuery=");
    stringBuilder.append(this.a);
    stringBuilder.append(", mDistricts=");
    stringBuilder.append(this.b);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeTypedList(this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\district\DistrictResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */