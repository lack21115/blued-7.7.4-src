package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.LinkedHashMap;
import java.util.Map;

public class DimensionValueSet implements Parcelable, b {
  public static final Parcelable.Creator<DimensionValueSet> CREATOR = new Parcelable.Creator<DimensionValueSet>() {
      public DimensionValueSet[] a(int param1Int) {
        return new DimensionValueSet[param1Int];
      }
      
      public DimensionValueSet b(Parcel param1Parcel) {
        return DimensionValueSet.a(param1Parcel);
      }
    };
  
  protected Map<String, String> map;
  
  @Deprecated
  public DimensionValueSet() {
    if (this.map == null)
      this.map = new LinkedHashMap<String, String>(); 
  }
  
  static DimensionValueSet a(Parcel paramParcel) {
    Exception exception;
    try {
      DimensionValueSet dimensionValueSet = create();
    } finally {
      exception = null;
    } 
    exception.printStackTrace();
    return (DimensionValueSet)paramParcel;
  }
  
  public static DimensionValueSet create() {
    return (DimensionValueSet)a.a().a(DimensionValueSet.class, new Object[0]);
  }
  
  @Deprecated
  public static DimensionValueSet create(int paramInt) {
    return (DimensionValueSet)a.a().a(DimensionValueSet.class, new Object[0]);
  }
  
  public static DimensionValueSet fromStringMap(Map<String, String> paramMap) {
    DimensionValueSet dimensionValueSet = (DimensionValueSet)a.a().a(DimensionValueSet.class, new Object[0]);
    for (Map.Entry<String, String> entry : paramMap.entrySet()) {
      String str;
      Map<String, String> map = dimensionValueSet.map;
      Object object = entry.getKey();
      if (entry.getValue() != null) {
        str = (String)entry.getValue();
      } else {
        str = "null";
      } 
      map.put(object, str);
    } 
    return dimensionValueSet;
  }
  
  public DimensionValueSet addValues(DimensionValueSet paramDimensionValueSet) {
    if (paramDimensionValueSet != null) {
      Map<String, String> map = paramDimensionValueSet.getMap();
      if (map != null)
        for (Map.Entry<String, String> entry : map.entrySet()) {
          String str;
          Map<String, String> map1 = this.map;
          Object object = entry.getKey();
          if (entry.getValue() != null) {
            str = (String)entry.getValue();
          } else {
            str = "null";
          } 
          map1.put(object, str);
        }  
    } 
    return this;
  }
  
  public void clean() {
    this.map.clear();
  }
  
  public boolean containValue(String paramString) {
    return this.map.containsKey(paramString);
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
    Map<String, String> map = this.map;
    if (map == null) {
      if (((DimensionValueSet)paramObject).map != null)
        return false; 
    } else if (!map.equals(((DimensionValueSet)paramObject).map)) {
      return false;
    } 
    return true;
  }
  
  public void fill(Object... paramVarArgs) {
    if (this.map == null)
      this.map = new LinkedHashMap<String, String>(); 
  }
  
  public Map<String, String> getMap() {
    return this.map;
  }
  
  public String getValue(String paramString) {
    return this.map.get(paramString);
  }
  
  public int hashCode() {
    int i;
    Map<String, String> map = this.map;
    if (map == null) {
      i = 0;
    } else {
      i = map.hashCode();
    } 
    return 31 + i;
  }
  
  public void setMap(Map<String, String> paramMap) {
    for (Map.Entry<String, String> entry : paramMap.entrySet()) {
      String str;
      Map<String, String> map = this.map;
      Object object = entry.getKey();
      if (entry.getValue() != null) {
        str = (String)entry.getValue();
      } else {
        str = "null";
      } 
      map.put(object, str);
    } 
  }
  
  public DimensionValueSet setValue(String paramString1, String paramString2) {
    Map<String, String> map = this.map;
    if (paramString2 == null)
      paramString2 = "null"; 
    map.put(paramString1, paramString2);
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeMap(this.map);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\DimensionValueSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */