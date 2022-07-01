package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.mtl.log.e.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DimensionSet implements Parcelable {
  public static final Parcelable.Creator<DimensionSet> CREATOR = new Parcelable.Creator<DimensionSet>() {
      public DimensionSet[] a(int param1Int) {
        return new DimensionSet[param1Int];
      }
      
      public DimensionSet b(Parcel param1Parcel) {
        return DimensionSet.a(param1Parcel);
      }
    };
  
  private List<Dimension> c = new ArrayList<Dimension>(3);
  
  static DimensionSet a(Parcel paramParcel) {
    DimensionSet dimensionSet = create();
    try {
    
    } finally {
      paramParcel = null;
      i.a("DimensionSet", "[readFromParcel]", (Throwable)paramParcel);
    } 
    int i;
    for (i = 0; i < paramParcel.length; i++) {
      if (paramParcel[i] != null && paramParcel[i] instanceof Dimension) {
        dimensionSet.c.add((Dimension)paramParcel[i]);
      } else {
        i.a("DimensionSet", new Object[] { "parcelables[i]:", paramParcel[i] });
      } 
    } 
    return dimensionSet;
  }
  
  public static DimensionSet create() {
    return new DimensionSet();
  }
  
  public static DimensionSet create(Collection<String> paramCollection) {
    DimensionSet dimensionSet = new DimensionSet();
    if (paramCollection != null) {
      Iterator<String> iterator = paramCollection.iterator();
      while (iterator.hasNext())
        dimensionSet.addDimension(new Dimension(iterator.next())); 
    } 
    return dimensionSet;
  }
  
  public static DimensionSet create(String[] paramArrayOfString) {
    DimensionSet dimensionSet = new DimensionSet();
    if (paramArrayOfString != null) {
      int j = paramArrayOfString.length;
      for (int i = 0; i < j; i++)
        dimensionSet.addDimension(new Dimension(paramArrayOfString[i])); 
    } 
    return dimensionSet;
  }
  
  public DimensionSet addDimension(Dimension paramDimension) {
    if (this.c.contains(paramDimension))
      return this; 
    this.c.add(paramDimension);
    return this;
  }
  
  public DimensionSet addDimension(String paramString) {
    return addDimension(new Dimension(paramString));
  }
  
  public DimensionSet addDimension(String paramString1, String paramString2) {
    return addDimension(new Dimension(paramString1, paramString2));
  }
  
  public int describeContents() {
    return 0;
  }
  
  public Dimension getDimension(String paramString) {
    for (Dimension dimension : this.c) {
      if (dimension.getName().equals(paramString))
        return dimension; 
    } 
    return null;
  }
  
  public List<Dimension> getDimensions() {
    return this.c;
  }
  
  public void setConstantValue(DimensionValueSet paramDimensionValueSet) {
    List<Dimension> list = this.c;
    if (list != null && paramDimensionValueSet != null)
      for (Dimension dimension : list) {
        if (dimension.getConstantValue() != null && paramDimensionValueSet.getValue(dimension.getName()) == null)
          paramDimensionValueSet.setValue(dimension.getName(), dimension.getConstantValue()); 
      }  
  }
  
  public boolean valid(DimensionValueSet paramDimensionValueSet) {
    List<Dimension> list = this.c;
    if (list != null)
      if (paramDimensionValueSet != null) {
        Iterator<Dimension> iterator = list.iterator();
        label9: while (iterator.hasNext()) {
          if (!paramDimensionValueSet.containValue(((Dimension)iterator.next()).getName()))
            break label9; 
        } 
      } else {
        return false;
      }  
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    List<Dimension> list = this.c;
    if (list != null)
      try {
        Dimension[] arrayOfDimension;
        Object[] arrayOfObject = list.toArray();
        list = null;
        if (arrayOfObject != null) {
          Dimension[] arrayOfDimension1 = new Dimension[arrayOfObject.length];
          int i = 0;
          while (true) {
            arrayOfDimension = arrayOfDimension1;
            if (i < arrayOfObject.length) {
              arrayOfDimension1[i] = (Dimension)arrayOfObject[i];
              i++;
              continue;
            } 
            break;
          } 
        } 
        paramParcel.writeParcelableArray((Parcelable[])arrayOfDimension, paramInt);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\DimensionSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */