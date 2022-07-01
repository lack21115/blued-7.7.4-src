package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbi;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Arrays;

public final class Status extends zzbgl implements Result, ReflectedParcelable {
  public static final Parcelable.Creator CREATOR;
  
  public static final Status zzftq = new Status(0);
  
  public static final Status zzfts = new Status(8);
  
  public static final Status zzftt = new Status(15);
  
  public static final Status zzftu = new Status(16);
  
  final int zzcc;
  
  private int zzehz;
  
  private final PendingIntent zzekd;
  
  final String zzfqu;
  
  static {
    new Status(17);
    new Status(18);
    CREATOR = new zzg();
    throw new VerifyError("bad dex opcode");
  }
  
  public Status(int paramInt) {
    this(paramInt, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent) {
    this.zzehz = paramInt1;
    this.zzcc = paramInt2;
    this.zzfqu = paramString;
    this.zzekd = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString) {
    this(1, paramInt, paramString, null);
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent) {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  public final boolean equals(Object paramObject) {
    if (!(paramObject instanceof Status))
      return false; 
    paramObject = paramObject;
    return (this.zzehz == ((Status)paramObject).zzehz && this.zzcc == ((Status)paramObject).zzcc && zzbg.equal(this.zzfqu, ((Status)paramObject).zzfqu) && zzbg.equal(this.zzekd, ((Status)paramObject).zzekd));
  }
  
  public final Status getStatus() {
    return this;
  }
  
  public final int hashCode() {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.zzehz), Integer.valueOf(this.zzcc), this.zzfqu, this.zzekd });
  }
  
  public final boolean isSuccess() {
    return (this.zzcc <= 0);
  }
  
  public final String toString() {
    String str;
    zzbi zzbi = zzbg.zzx(this);
    if (this.zzfqu != null) {
      str = this.zzfqu;
    } else {
      str = CommonStatusCodes.getStatusCodeString(this.zzcc);
    } 
    return zzbi.zzg("statusCode", str).zzg("resolution", this.zzekd).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 1, this.zzcc);
    zzbgo.zza(paramParcel, 2, this.zzfqu, false);
    zzbgo.zza(paramParcel, 3, (Parcelable)this.zzekd, paramInt, false);
    zzbgo.zzc(paramParcel, 1000, this.zzehz);
    zzbgo.zzah(paramParcel, i);
  }
  
  static {
    new Status(14);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */