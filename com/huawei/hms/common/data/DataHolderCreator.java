package com.huawei.hms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;

public final class DataHolderCreator implements Parcelable.Creator<DataHolder> {
  public final DataHolder createFromParcel(Parcel paramParcel) {
    CursorWindow[] arrayOfCursorWindow;
    String[] arrayOfString;
    int m = SafeParcelReader.validateObjectHeader(paramParcel);
    int k = 0;
    Bundle bundle3 = null;
    Bundle bundle1 = bundle3;
    Bundle bundle2 = bundle1;
    int j = 0;
    int i = 0;
    while (k <= m && paramParcel.dataPosition() < m) {
      k++;
      int n = SafeParcelReader.readHeader(paramParcel);
      int i1 = SafeParcelReader.getFieldId(n);
      if (i1 != 1) {
        if (i1 != 2) {
          if (i1 != 3) {
            if (i1 != 4) {
              if (i1 != 1000) {
                SafeParcelReader.skipUnknownField(paramParcel, n);
                continue;
              } 
              j = SafeParcelReader.readInt(paramParcel, n);
              continue;
            } 
            bundle2 = SafeParcelReader.createBundle(paramParcel, n);
            continue;
          } 
          i = SafeParcelReader.readInt(paramParcel, n);
          continue;
        } 
        arrayOfCursorWindow = (CursorWindow[])SafeParcelReader.createTypedArray(paramParcel, n, CursorWindow.CREATOR);
        continue;
      } 
      arrayOfString = SafeParcelReader.createStringArray(paramParcel, n);
    } 
    SafeParcelReader.ensureAtEnd(paramParcel, m);
    return new DataHolder(j, arrayOfString, arrayOfCursorWindow, i, bundle2);
  }
  
  public final DataHolder[] newArray(int paramInt) {
    return new DataHolder[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\data\DataHolderCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */