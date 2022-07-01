package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MeasureSet implements Parcelable {
  public static final Parcelable.Creator<MeasureSet> CREATOR = new Parcelable.Creator<MeasureSet>() {
      public MeasureSet[] a(int param1Int) {
        return new MeasureSet[param1Int];
      }
      
      public MeasureSet b(Parcel param1Parcel) {
        return MeasureSet.a(param1Parcel);
      }
    };
  
  private List<Measure> d = new ArrayList<Measure>(3);
  
  static MeasureSet a(Parcel paramParcel) {
    MeasureSet measureSet = create();
    try {
      Parcelable[] arrayOfParcelable = paramParcel.readParcelableArray(MeasureSet.class.getClassLoader());
    } finally {
      paramParcel = null;
    } 
    return measureSet;
  }
  
  public static MeasureSet create() {
    return new MeasureSet();
  }
  
  public static MeasureSet create(Collection<String> paramCollection) {
    MeasureSet measureSet = new MeasureSet();
    if (paramCollection != null) {
      Iterator<String> iterator = paramCollection.iterator();
      while (iterator.hasNext())
        measureSet.addMeasure(iterator.next()); 
    } 
    return measureSet;
  }
  
  public static MeasureSet create(String[] paramArrayOfString) {
    MeasureSet measureSet = new MeasureSet();
    if (paramArrayOfString != null) {
      int j = paramArrayOfString.length;
      for (int i = 0; i < j; i++)
        measureSet.addMeasure(paramArrayOfString[i]); 
    } 
    return measureSet;
  }
  
  public MeasureSet addMeasure(Measure paramMeasure) {
    if (!this.d.contains(paramMeasure))
      this.d.add(paramMeasure); 
    return this;
  }
  
  public MeasureSet addMeasure(String paramString) {
    return addMeasure(new Measure(paramString));
  }
  
  public int describeContents() {
    return 0;
  }
  
  public Measure getMeasure(String paramString) {
    for (Measure measure : this.d) {
      if (measure.getName().equals(paramString))
        return measure; 
    } 
    return null;
  }
  
  public List<Measure> getMeasures() {
    return this.d;
  }
  
  public void setConstantValue(MeasureValueSet paramMeasureValueSet) {
    List<Measure> list = this.d;
    if (list != null && paramMeasureValueSet != null)
      for (Measure measure : list) {
        if (measure.getConstantValue() != null && paramMeasureValueSet.getValue(measure.getName()) == null)
          paramMeasureValueSet.setValue(measure.getName(), measure.getConstantValue().doubleValue()); 
      }  
  }
  
  public void upateMeasure(Measure paramMeasure) {
    int j = this.d.size();
    for (int i = 0; i < j; i++) {
      if (TextUtils.equals(((Measure)this.d.get(i)).name, paramMeasure.name)) {
        ((Measure)this.d.get(i)).setMax(paramMeasure.getMax());
        ((Measure)this.d.get(i)).setMin(paramMeasure.getMin());
        ((Measure)this.d.get(i)).setConstantValue(paramMeasure.getConstantValue());
      } 
    } 
  }
  
  public void upateMeasures(List<Measure> paramList) {
    int j = this.d.size();
    int k = paramList.size();
    for (int i = 0; i < j; i++) {
      for (int m = 0; m < k; m++) {
        if (TextUtils.equals(((Measure)this.d.get(i)).name, ((Measure)paramList.get(m)).name)) {
          ((Measure)this.d.get(i)).setMax(((Measure)paramList.get(m)).getMax());
          ((Measure)this.d.get(i)).setMin(((Measure)paramList.get(m)).getMin());
        } 
      } 
    } 
  }
  
  public boolean valid(MeasureValueSet paramMeasureValueSet) {
    if (this.d != null)
      if (paramMeasureValueSet != null) {
        for (int i = 0; i < this.d.size(); i++) {
          Measure measure = this.d.get(i);
          if (measure != null) {
            String str = measure.getName();
            if (!paramMeasureValueSet.containValue(str))
              return false; 
            if (!measure.valid(paramMeasureValueSet.getValue(str)))
              return false; 
          } 
        } 
      } else {
        return false;
      }  
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    List<Measure> list = this.d;
    if (list != null)
      try {
        Measure[] arrayOfMeasure;
        Object[] arrayOfObject = list.toArray();
        list = null;
        if (arrayOfObject != null) {
          Measure[] arrayOfMeasure1 = new Measure[arrayOfObject.length];
          int i = 0;
          while (true) {
            arrayOfMeasure = arrayOfMeasure1;
            if (i < arrayOfObject.length) {
              arrayOfMeasure1[i] = (Measure)arrayOfObject[i];
              i++;
              continue;
            } 
            break;
          } 
        } 
        paramParcel.writeParcelableArray((Parcelable[])arrayOfMeasure, paramInt);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\MeasureSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */