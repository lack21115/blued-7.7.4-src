package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

public class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
  public static final Parcelable.Creator<ParcelableSparseArray> CREATOR = (Parcelable.Creator<ParcelableSparseArray>)new Parcelable.ClassLoaderCreator<ParcelableSparseArray>() {
      public ParcelableSparseArray a(Parcel param1Parcel) {
        return new ParcelableSparseArray(param1Parcel, null);
      }
      
      public ParcelableSparseArray a(Parcel param1Parcel, ClassLoader param1ClassLoader) {
        return new ParcelableSparseArray(param1Parcel, param1ClassLoader);
      }
      
      public ParcelableSparseArray[] a(int param1Int) {
        return new ParcelableSparseArray[param1Int];
      }
    };
  
  public ParcelableSparseArray() {}
  
  public ParcelableSparseArray(Parcel paramParcel, ClassLoader paramClassLoader) {
    int j = paramParcel.readInt();
    int[] arrayOfInt = new int[j];
    paramParcel.readIntArray(arrayOfInt);
    Parcelable[] arrayOfParcelable = paramParcel.readParcelableArray(paramClassLoader);
    for (int i = 0; i < j; i++)
      put(arrayOfInt[i], arrayOfParcelable[i]); 
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    int j = size();
    int[] arrayOfInt = new int[j];
    Parcelable[] arrayOfParcelable = new Parcelable[j];
    for (int i = 0; i < j; i++) {
      arrayOfInt[i] = keyAt(i);
      arrayOfParcelable[i] = (Parcelable)valueAt(i);
    } 
    paramParcel.writeInt(j);
    paramParcel.writeIntArray(arrayOfInt);
    paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\ParcelableSparseArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */