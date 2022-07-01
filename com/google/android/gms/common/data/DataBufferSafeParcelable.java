package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DataBufferSafeParcelable<T extends SafeParcelable> extends AbstractDataBuffer<T> {
  private static final String[] zaa = new String[] { "data" };
  
  private final Parcelable.Creator<T> zab;
  
  public DataBufferSafeParcelable(DataHolder paramDataHolder, Parcelable.Creator<T> paramCreator) {
    super(paramDataHolder);
    this.zab = paramCreator;
  }
  
  public static <T extends SafeParcelable> void addValue(DataHolder.Builder paramBuilder, T paramT) {
    Parcel parcel = Parcel.obtain();
    paramT.writeToParcel(parcel, 0);
    ContentValues contentValues = new ContentValues();
    contentValues.put("data", parcel.marshall());
    paramBuilder.withRow(contentValues);
    parcel.recycle();
  }
  
  public static DataHolder.Builder buildDataHolder() {
    return DataHolder.builder(zaa);
  }
  
  public T get(int paramInt) {
    DataHolder dataHolder = (DataHolder)Preconditions.checkNotNull(this.mDataHolder);
    byte[] arrayOfByte = dataHolder.getByteArray("data", paramInt, dataHolder.getWindowIndex(paramInt));
    Parcel parcel = Parcel.obtain();
    parcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
    parcel.setDataPosition(0);
    SafeParcelable safeParcelable = (SafeParcelable)this.zab.createFromParcel(parcel);
    parcel.recycle();
    return (T)safeParcelable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\data\DataBufferSafeParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */