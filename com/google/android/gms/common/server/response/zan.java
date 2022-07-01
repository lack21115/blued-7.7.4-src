package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zan extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zan> CREATOR = new zai();
  
  final String zaa;
  
  final FastJsonResponse.Field<?, ?> zab;
  
  private final int zac;
  
  zan(int paramInt, String paramString, FastJsonResponse.Field<?, ?> paramField) {
    this.zac = paramInt;
    this.zaa = paramString;
    this.zab = paramField;
  }
  
  zan(String paramString, FastJsonResponse.Field<?, ?> paramField) {
    this.zac = 1;
    this.zaa = paramString;
    this.zab = paramField;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zac);
    SafeParcelWriter.writeString(paramParcel, 2, this.zaa, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)this.zab, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\server\response\zan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */