package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.i;

public class DistrictSearchQuery implements Parcelable, Cloneable {
  public static final Parcelable.Creator<DistrictSearchQuery> CREATOR = new Parcelable.Creator<DistrictSearchQuery>() {
    
    };
  
  public static final String KEYWORDS_BUSINESS = "biz_area";
  
  public static final String KEYWORDS_CITY = "city";
  
  public static final String KEYWORDS_COUNTRY = "country";
  
  public static final String KEYWORDS_DISTRICT = "district";
  
  public static final String KEYWORDS_PROVINCE = "province";
  
  private int a = 1;
  
  private int b = 20;
  
  private String c;
  
  private String d;
  
  private boolean e = true;
  
  private boolean f = false;
  
  private boolean g = false;
  
  private int h = 1;
  
  public DistrictSearchQuery() {}
  
  public DistrictSearchQuery(String paramString1, String paramString2, int paramInt) {
    this.c = paramString1;
    this.d = paramString2;
    this.a = paramInt;
  }
  
  public DistrictSearchQuery(String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2) {
    this(paramString1, paramString2, paramInt1);
    this.e = paramBoolean;
    this.b = paramInt2;
  }
  
  public boolean checkKeyWords() {
    String str = this.c;
    return (str == null) ? false : (!str.trim().equalsIgnoreCase(""));
  }
  
  public boolean checkLevels() {
    String str = this.d;
    return (str == null) ? false : ((str.trim().equals("country") || this.d.trim().equals("province") || this.d.trim().equals("city") || this.d.trim().equals("district") || this.d.trim().equals("biz_area")));
  }
  
  public DistrictSearchQuery clone() {
    try {
      super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      i.a(cloneNotSupportedException, "DistrictSearchQuery", "clone");
    } 
    DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
    districtSearchQuery.setKeywords(this.c);
    districtSearchQuery.setKeywordsLevel(this.d);
    districtSearchQuery.setPageNum(this.a);
    districtSearchQuery.setPageSize(this.b);
    districtSearchQuery.setShowChild(this.e);
    districtSearchQuery.setSubDistrict(this.h);
    districtSearchQuery.setShowBoundary(this.g);
    districtSearchQuery.setShowBusinessArea(this.f);
    return districtSearchQuery;
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
    if (this.g != ((DistrictSearchQuery)paramObject).g)
      return false; 
    String str = this.c;
    if (str == null) {
      if (((DistrictSearchQuery)paramObject).c != null)
        return false; 
    } else if (!str.equals(((DistrictSearchQuery)paramObject).c)) {
      return false;
    } 
    return (this.a != ((DistrictSearchQuery)paramObject).a) ? false : ((this.b != ((DistrictSearchQuery)paramObject).b) ? false : ((this.e != ((DistrictSearchQuery)paramObject).e) ? false : (!(this.h != ((DistrictSearchQuery)paramObject).h))));
  }
  
  public String getKeywords() {
    return this.c;
  }
  
  public String getKeywordsLevel() {
    return this.d;
  }
  
  public int getPageNum() {
    int j = this.a;
    int i = j;
    if (j <= 0)
      i = 1; 
    return i;
  }
  
  public int getPageSize() {
    return this.b;
  }
  
  public int getSubDistrict() {
    return this.h;
  }
  
  public int hashCode() {
    char c1;
    int i;
    boolean bool = this.g;
    char c2 = 'ӏ';
    if (bool) {
      c1 = 'ӏ';
    } else {
      c1 = 'ӕ';
    } 
    String str = this.c;
    int j = 0;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    } 
    str = this.d;
    if (str != null)
      j = str.hashCode(); 
    int k = this.a;
    int m = this.b;
    if (!this.e)
      c2 = 'ӕ'; 
    return ((((((c1 + 31) * 31 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + c2) * 31 + this.h;
  }
  
  public boolean isShowBoundary() {
    return this.g;
  }
  
  public boolean isShowBusinessArea() {
    return this.f;
  }
  
  public boolean isShowChild() {
    return this.e;
  }
  
  public void setKeywords(String paramString) {
    this.c = paramString;
  }
  
  public void setKeywordsLevel(String paramString) {
    this.d = paramString;
  }
  
  public void setPageNum(int paramInt) {
    this.a = paramInt;
  }
  
  public void setPageSize(int paramInt) {
    this.b = paramInt;
  }
  
  public void setShowBoundary(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public void setShowBusinessArea(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public void setShowChild(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  public void setSubDistrict(int paramInt) {
    this.h = paramInt;
  }
  
  public boolean weakEquals(DistrictSearchQuery paramDistrictSearchQuery) {
    if (this == paramDistrictSearchQuery)
      return true; 
    if (paramDistrictSearchQuery == null)
      return false; 
    String str = this.c;
    if (str == null) {
      if (paramDistrictSearchQuery.c != null)
        return false; 
    } else if (!str.equals(paramDistrictSearchQuery.c)) {
      return false;
    } 
    return (this.b != paramDistrictSearchQuery.b) ? false : ((this.e != paramDistrictSearchQuery.e) ? false : ((this.g != paramDistrictSearchQuery.g) ? false : (!(this.h != paramDistrictSearchQuery.h))));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeByte((byte)this.e);
    paramParcel.writeByte((byte)this.g);
    paramParcel.writeByte((byte)this.f);
    paramParcel.writeInt(this.h);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\district\DistrictSearchQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */