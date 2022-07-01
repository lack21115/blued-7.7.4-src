package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;

public final class zzcfs extends zzbgl {
  public static final Parcelable.Creator CREATOR = new zzcft();
  
  private String packageName;
  
  private int uid;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public zzcfs(int paramInt, String paramString) {
    this.uid = paramInt;
    this.packageName = paramString;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject != null) {
      if (!(paramObject instanceof zzcfs))
        return false; 
      paramObject = paramObject;
      if (((zzcfs)paramObject).uid == this.uid && zzbg.equal(((zzcfs)paramObject).packageName, this.packageName))
        return true; 
    } 
    return false;
  }
  
  public final int hashCode() {
    return this.uid;
  }
  
  public final String toString() {
    return String.format("%d:%s", new Object[] { Integer.valueOf(this.uid), this.packageName });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 1, this.uid);
    zzbgo.zza(paramParcel, 2, this.packageName, false);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzcfs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */