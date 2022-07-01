package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
  public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = new Parcelable.Creator<ParcelableSparseIntArray>() {
      public ParcelableSparseIntArray a(Parcel param1Parcel) {
        int j = param1Parcel.readInt();
        ParcelableSparseIntArray parcelableSparseIntArray = new ParcelableSparseIntArray(j);
        int[] arrayOfInt1 = new int[j];
        int[] arrayOfInt2 = new int[j];
        param1Parcel.readIntArray(arrayOfInt1);
        param1Parcel.readIntArray(arrayOfInt2);
        for (int i = 0; i < j; i++)
          parcelableSparseIntArray.put(arrayOfInt1[i], arrayOfInt2[i]); 
        return parcelableSparseIntArray;
      }
      
      public ParcelableSparseIntArray[] a(int param1Int) {
        return new ParcelableSparseIntArray[param1Int];
      }
    };
  
  public ParcelableSparseIntArray() {}
  
  public ParcelableSparseIntArray(int paramInt) {
    super(paramInt);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int[] arrayOfInt1 = new int[size()];
    int[] arrayOfInt2 = new int[size()];
    for (paramInt = 0; paramInt < size(); paramInt++) {
      arrayOfInt1[paramInt] = keyAt(paramInt);
      arrayOfInt2[paramInt] = valueAt(paramInt);
    } 
    paramParcel.writeInt(size());
    paramParcel.writeIntArray(arrayOfInt1);
    paramParcel.writeIntArray(arrayOfInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\ParcelableSparseIntArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */