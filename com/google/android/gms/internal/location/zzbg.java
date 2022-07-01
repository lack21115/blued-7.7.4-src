package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public final class zzbg extends AbstractSafeParcelable implements Geofence {
  public static final Parcelable.Creator<zzbg> CREATOR = new zzbf();
  
  private final String zza;
  
  private final long zzb;
  
  private final short zzc;
  
  private final double zzd;
  
  private final double zze;
  
  private final float zzf;
  
  private final int zzg;
  
  private final int zzh;
  
  private final int zzi;
  
  public zzbg(String paramString, int paramInt1, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt2, int paramInt3) {
    if (paramString == null || paramString.length() > 100) {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "requestId is null or too long: ".concat(paramString);
      } else {
        paramString = new String("requestId is null or too long: ");
      } 
      throw new IllegalArgumentException(paramString);
    } 
    if (paramFloat > 0.0F) {
      if (paramDouble1 <= 90.0D && paramDouble1 >= -90.0D) {
        if (paramDouble2 <= 180.0D && paramDouble2 >= -180.0D) {
          int i = paramInt1 & 0x7;
          if (i != 0) {
            this.zzc = paramShort;
            this.zza = paramString;
            this.zzd = paramDouble1;
            this.zze = paramDouble2;
            this.zzf = paramFloat;
            this.zzb = paramLong;
            this.zzg = i;
            this.zzh = paramInt2;
            this.zzi = paramInt3;
            return;
          } 
          StringBuilder stringBuilder3 = new StringBuilder(46);
          stringBuilder3.append("No supported transition specified: ");
          stringBuilder3.append(paramInt1);
          throw new IllegalArgumentException(stringBuilder3.toString());
        } 
        StringBuilder stringBuilder2 = new StringBuilder(43);
        stringBuilder2.append("invalid longitude: ");
        stringBuilder2.append(paramDouble2);
        throw new IllegalArgumentException(stringBuilder2.toString());
      } 
      StringBuilder stringBuilder1 = new StringBuilder(42);
      stringBuilder1.append("invalid latitude: ");
      stringBuilder1.append(paramDouble1);
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder(31);
    stringBuilder.append("invalid radius: ");
    stringBuilder.append(paramFloat);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static zzbg zza(byte[] paramArrayOfbyte) {
    Parcel parcel = Parcel.obtain();
    parcel.unmarshall(paramArrayOfbyte, 0, paramArrayOfbyte.length);
    parcel.setDataPosition(0);
    zzbg zzbg1 = (zzbg)CREATOR.createFromParcel(parcel);
    parcel.recycle();
    return zzbg1;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof zzbg))
      return false; 
    paramObject = paramObject;
    return (this.zzf != ((zzbg)paramObject).zzf) ? false : ((this.zzd != ((zzbg)paramObject).zzd) ? false : ((this.zze != ((zzbg)paramObject).zze) ? false : (!(this.zzc != ((zzbg)paramObject).zzc))));
  }
  
  public final String getRequestId() {
    return this.zza;
  }
  
  public final int hashCode() {
    long l = Double.doubleToLongBits(this.zzd);
    int i = (int)(l ^ l >>> 32L);
    l = Double.doubleToLongBits(this.zze);
    return ((((i + 31) * 31 + (int)(l ^ l >>> 32L)) * 31 + Float.floatToIntBits(this.zzf)) * 31 + this.zzc) * 31 + this.zzg;
  }
  
  public final String toString() {
    String str;
    Locale locale = Locale.US;
    if (this.zzc != 1) {
      str = null;
    } else {
      str = "CIRCLE";
    } 
    return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] { str, this.zza.replaceAll("\\p{C}", "?"), Integer.valueOf(this.zzg), Double.valueOf(this.zzd), Double.valueOf(this.zze), Float.valueOf(this.zzf), Integer.valueOf(this.zzh / 1000), Integer.valueOf(this.zzi), Long.valueOf(this.zzb) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getRequestId(), false);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzb);
    SafeParcelWriter.writeShort(paramParcel, 3, this.zzc);
    SafeParcelWriter.writeDouble(paramParcel, 4, this.zzd);
    SafeParcelWriter.writeDouble(paramParcel, 5, this.zze);
    SafeParcelWriter.writeFloat(paramParcel, 6, this.zzf);
    SafeParcelWriter.writeInt(paramParcel, 7, this.zzg);
    SafeParcelWriter.writeInt(paramParcel, 8, this.zzh);
    SafeParcelWriter.writeInt(paramParcel, 9, this.zzi);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */