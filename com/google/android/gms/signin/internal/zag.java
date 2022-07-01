package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

public final class zag extends AbstractSafeParcelable implements Result {
  public static final Parcelable.Creator<zag> CREATOR = new zai();
  
  private final List<String> zaa;
  
  private final String zab;
  
  public zag(List<String> paramList, String paramString) {
    this.zaa = paramList;
    this.zab = paramString;
  }
  
  public final Status getStatus() {
    return (this.zab != null) ? Status.RESULT_SUCCESS : Status.RESULT_CANCELED;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeStringList(paramParcel, 1, this.zaa, false);
    SafeParcelWriter.writeString(paramParcel, 2, this.zab, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\signin\internal\zag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */