package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;

public class ParcelableSparseBooleanArray extends SparseBooleanArray implements Parcelable {
  public static final Parcelable.Creator<ParcelableSparseBooleanArray> CREATOR = new Parcelable.Creator<ParcelableSparseBooleanArray>() {
      public ParcelableSparseBooleanArray a(Parcel param1Parcel) {
        int j = param1Parcel.readInt();
        ParcelableSparseBooleanArray parcelableSparseBooleanArray = new ParcelableSparseBooleanArray(j);
        int[] arrayOfInt = new int[j];
        boolean[] arrayOfBoolean = new boolean[j];
        param1Parcel.readIntArray(arrayOfInt);
        param1Parcel.readBooleanArray(arrayOfBoolean);
        for (int i = 0; i < j; i++)
          parcelableSparseBooleanArray.put(arrayOfInt[i], arrayOfBoolean[i]); 
        return parcelableSparseBooleanArray;
      }
      
      public ParcelableSparseBooleanArray[] a(int param1Int) {
        return new ParcelableSparseBooleanArray[param1Int];
      }
    };
  
  public ParcelableSparseBooleanArray() {}
  
  public ParcelableSparseBooleanArray(int paramInt) {
    super(paramInt);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int[] arrayOfInt = new int[size()];
    boolean[] arrayOfBoolean = new boolean[size()];
    for (paramInt = 0; paramInt < size(); paramInt++) {
      arrayOfInt[paramInt] = keyAt(paramInt);
      arrayOfBoolean[paramInt] = valueAt(paramInt);
    } 
    paramParcel.writeInt(size());
    paramParcel.writeIntArray(arrayOfInt);
    paramParcel.writeBooleanArray(arrayOfBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\ParcelableSparseBooleanArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */