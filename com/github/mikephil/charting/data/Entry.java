package com.github.mikephil.charting.data;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;

public class Entry extends BaseEntry implements Parcelable {
  public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() {
      public Entry a(Parcel param1Parcel) {
        return new Entry(param1Parcel);
      }
      
      public Entry[] a(int param1Int) {
        return new Entry[param1Int];
      }
    };
  
  private float a = 0.0F;
  
  public Entry() {}
  
  public Entry(float paramFloat1, float paramFloat2, Object paramObject) {
    super(paramFloat2, paramObject);
    this.a = paramFloat1;
  }
  
  protected Entry(Parcel paramParcel) {
    this.a = paramParcel.readFloat();
    a(paramParcel.readFloat());
    if (paramParcel.readInt() == 1)
      a(paramParcel.readParcelable(Object.class.getClassLoader())); 
  }
  
  public int describeContents() {
    return 0;
  }
  
  public float i() {
    return this.a;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Entry, x: ");
    stringBuilder.append(this.a);
    stringBuilder.append(" y: ");
    stringBuilder.append(b());
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeFloat(this.a);
    paramParcel.writeFloat(b());
    if (h() != null) {
      if (h() instanceof Parcelable) {
        paramParcel.writeInt(1);
        paramParcel.writeParcelable((Parcelable)h(), paramInt);
        return;
      } 
      throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
    } 
    paramParcel.writeInt(0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\data\Entry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */