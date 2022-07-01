package com.huawei.hms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;

public final class FeatureCreator implements Parcelable.Creator<Feature> {
  public final Feature createFromParcel(Parcel paramParcel) {
    int k = SafeParcelReader.validateObjectHeader(paramParcel);
    int j = 0;
    String str = null;
    long l = -1L;
    int i = 0;
    while (j <= k && paramParcel.dataPosition() < k) {
      j++;
      int m = SafeParcelReader.readHeader(paramParcel);
      int n = SafeParcelReader.getFieldId(m);
      if (n != 1) {
        if (n != 2) {
          if (n != 3) {
            SafeParcelReader.skipUnknownField(paramParcel, m);
            continue;
          } 
          l = SafeParcelReader.readLong(paramParcel, m);
          continue;
        } 
        i = SafeParcelReader.readInt(paramParcel, m);
        continue;
      } 
      str = SafeParcelReader.createString(paramParcel, m);
    } 
    SafeParcelReader.ensureAtEnd(paramParcel, k);
    return new Feature(str, i, l);
  }
  
  public final Feature[] newArray(int paramInt) {
    return new Feature[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\FeatureCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */