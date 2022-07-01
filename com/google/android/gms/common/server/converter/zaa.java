package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse;

public final class zaa extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zaa> CREATOR = new zab();
  
  private final int zaa;
  
  private final StringToIntConverter zab;
  
  zaa(int paramInt, StringToIntConverter paramStringToIntConverter) {
    this.zaa = paramInt;
    this.zab = paramStringToIntConverter;
  }
  
  private zaa(StringToIntConverter paramStringToIntConverter) {
    this.zaa = 1;
    this.zab = paramStringToIntConverter;
  }
  
  public static zaa zaa(FastJsonResponse.FieldConverter<?, ?> paramFieldConverter) {
    if (paramFieldConverter instanceof StringToIntConverter)
      return new zaa((StringToIntConverter)paramFieldConverter); 
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zaa);
    SafeParcelWriter.writeParcelable(paramParcel, 2, (Parcelable)this.zab, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final FastJsonResponse.FieldConverter<?, ?> zaa() {
    StringToIntConverter stringToIntConverter = this.zab;
    if (stringToIntConverter != null)
      return stringToIntConverter; 
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\server\converter\zaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */