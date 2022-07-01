package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class ClientIdentity extends AbstractSafeParcelable {
  public static final Parcelable.Creator<ClientIdentity> CREATOR = new zaa();
  
  private final int zaa;
  
  private final String zab;
  
  public ClientIdentity(int paramInt, String paramString) {
    this.zaa = paramInt;
    this.zab = paramString;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ClientIdentity))
      return false; 
    paramObject = paramObject;
    return (((ClientIdentity)paramObject).zaa == this.zaa && Objects.equal(((ClientIdentity)paramObject).zab, this.zab));
  }
  
  public int hashCode() {
    return this.zaa;
  }
  
  public String toString() {
    int i = this.zaa;
    String str = this.zab;
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 12);
    stringBuilder.append(i);
    stringBuilder.append(":");
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zaa);
    SafeParcelWriter.writeString(paramParcel, 2, this.zab, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\ClientIdentity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */