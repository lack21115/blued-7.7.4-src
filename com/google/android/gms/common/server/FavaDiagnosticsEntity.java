package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
  public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new zaa();
  
  private final int zaa;
  
  private final String zab;
  
  private final int zac;
  
  public FavaDiagnosticsEntity(int paramInt1, String paramString, int paramInt2) {
    this.zaa = paramInt1;
    this.zab = paramString;
    this.zac = paramInt2;
  }
  
  public FavaDiagnosticsEntity(String paramString, int paramInt) {
    this.zaa = 1;
    this.zab = paramString;
    this.zac = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zaa);
    SafeParcelWriter.writeString(paramParcel, 2, this.zab, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zac);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\server\FavaDiagnosticsEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */