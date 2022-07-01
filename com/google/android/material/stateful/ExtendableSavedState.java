package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;

public class ExtendableSavedState extends AbsSavedState {
  public static final Parcelable.Creator<ExtendableSavedState> CREATOR = (Parcelable.Creator<ExtendableSavedState>)new Parcelable.ClassLoaderCreator<ExtendableSavedState>() {
      public ExtendableSavedState a(Parcel param1Parcel) {
        return new ExtendableSavedState(param1Parcel, null);
      }
      
      public ExtendableSavedState a(Parcel param1Parcel, ClassLoader param1ClassLoader) {
        return new ExtendableSavedState(param1Parcel, param1ClassLoader);
      }
      
      public ExtendableSavedState[] a(int param1Int) {
        return new ExtendableSavedState[param1Int];
      }
    };
  
  public final SimpleArrayMap<String, Bundle> a;
  
  private ExtendableSavedState(Parcel paramParcel, ClassLoader paramClassLoader) {
    super(paramParcel, paramClassLoader);
    int j = paramParcel.readInt();
    String[] arrayOfString = new String[j];
    paramParcel.readStringArray(arrayOfString);
    Bundle[] arrayOfBundle = new Bundle[j];
    paramParcel.readTypedArray((Object[])arrayOfBundle, Bundle.CREATOR);
    this.a = new SimpleArrayMap(j);
    for (int i = 0; i < j; i++)
      this.a.put(arrayOfString[i], arrayOfBundle[i]); 
  }
  
  public ExtendableSavedState(Parcelable paramParcelable) {
    super(paramParcelable);
    this.a = new SimpleArrayMap();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ExtendableSavedState{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" states=");
    stringBuilder.append(this.a);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    int i = this.a.size();
    paramParcel.writeInt(i);
    String[] arrayOfString = new String[i];
    Bundle[] arrayOfBundle = new Bundle[i];
    for (paramInt = 0; paramInt < i; paramInt++) {
      arrayOfString[paramInt] = (String)this.a.keyAt(paramInt);
      arrayOfBundle[paramInt] = (Bundle)this.a.valueAt(paramInt);
    } 
    paramParcel.writeStringArray(arrayOfString);
    paramParcel.writeTypedArray((Parcelable[])arrayOfBundle, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\stateful\ExtendableSavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */