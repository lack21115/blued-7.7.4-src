package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.LinkedHashMap;
import java.util.Map;

public class MeasureValueSet implements Parcelable, b {
  public static final Parcelable.Creator<MeasureValueSet> CREATOR = new Parcelable.Creator<MeasureValueSet>() {
      public MeasureValueSet[] a(int param1Int) {
        return new MeasureValueSet[param1Int];
      }
      
      public MeasureValueSet b(Parcel param1Parcel) {
        return MeasureValueSet.a(param1Parcel);
      }
    };
  
  private Map<String, MeasureValue> map = new LinkedHashMap<String, MeasureValue>();
  
  static MeasureValueSet a(Parcel paramParcel) {
    try {
      MeasureValueSet measureValueSet = create();
    } finally {
      paramParcel = null;
    } 
  }
  
  private static Double a(String paramString) {
    try {
      return Double.valueOf(paramString);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static MeasureValueSet create() {
    return (MeasureValueSet)a.a().a(MeasureValueSet.class, new Object[0]);
  }
  
  @Deprecated
  public static MeasureValueSet create(int paramInt) {
    return (MeasureValueSet)a.a().a(MeasureValueSet.class, new Object[0]);
  }
  
  public static MeasureValueSet create(Map<String, Double> paramMap) {
    MeasureValueSet measureValueSet = (MeasureValueSet)a.a().a(MeasureValueSet.class, new Object[0]);
    if (paramMap != null)
      for (String str : paramMap.keySet()) {
        Double double_ = paramMap.get(str);
        if (double_ != null)
          measureValueSet.map.put(str, a.a().a(MeasureValue.class, new Object[] { double_ })); 
      }  
    return measureValueSet;
  }
  
  public static MeasureValueSet fromStringMap(Map<String, String> paramMap) {
    MeasureValueSet measureValueSet = (MeasureValueSet)a.a().a(MeasureValueSet.class, new Object[0]);
    if (paramMap != null)
      for (Map.Entry<String, String> entry : paramMap.entrySet()) {
        Double double_ = a((String)entry.getValue());
        if (double_ != null)
          measureValueSet.map.put((String)entry.getKey(), a.a().a(MeasureValue.class, new Object[] { double_ })); 
      }  
    return measureValueSet;
  }
  
  public void clean() {
    for (MeasureValue measureValue : this.map.values())
      a.a().a(measureValue); 
    this.map.clear();
  }
  
  public boolean containValue(String paramString) {
    return this.map.containsKey(paramString);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void fill(Object... paramVarArgs) {
    if (this.map == null)
      this.map = new LinkedHashMap<String, MeasureValue>(); 
  }
  
  public Map<String, MeasureValue> getMap() {
    return this.map;
  }
  
  public MeasureValue getValue(String paramString) {
    return this.map.get(paramString);
  }
  
  public boolean isEmpty() {
    return this.map.isEmpty();
  }
  
  public void merge(MeasureValueSet paramMeasureValueSet) {
    for (String str : this.map.keySet())
      ((MeasureValue)this.map.get(str)).merge(paramMeasureValueSet.getValue(str)); 
  }
  
  public void setMap(Map<String, MeasureValue> paramMap) {
    this.map = paramMap;
  }
  
  public MeasureValueSet setValue(String paramString, double paramDouble) {
    this.map.put(paramString, a.a().a(MeasureValue.class, new Object[] { Double.valueOf(paramDouble) }));
    return this;
  }
  
  public void setValue(String paramString, MeasureValue paramMeasureValue) {
    this.map.put(paramString, paramMeasureValue);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeMap(this.map);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\MeasureValueSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */