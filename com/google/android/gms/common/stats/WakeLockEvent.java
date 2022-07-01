package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

public final class WakeLockEvent extends StatsEvent {
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzb();
  
  private final int zza;
  
  private final long zzb;
  
  private int zzc;
  
  private final String zzd;
  
  private final String zze;
  
  private final String zzf;
  
  private final int zzg;
  
  private final List<String> zzh;
  
  private final String zzi;
  
  private final long zzj;
  
  private int zzk;
  
  private final String zzl;
  
  private final float zzm;
  
  private final long zzn;
  
  private final boolean zzo;
  
  private long zzp;
  
  WakeLockEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, List<String> paramList, String paramString2, long paramLong2, int paramInt4, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5, boolean paramBoolean) {
    this.zza = paramInt1;
    this.zzb = paramLong1;
    this.zzc = paramInt2;
    this.zzd = paramString1;
    this.zze = paramString3;
    this.zzf = paramString5;
    this.zzg = paramInt3;
    this.zzp = -1L;
    this.zzh = paramList;
    this.zzi = paramString2;
    this.zzj = paramLong2;
    this.zzk = paramInt4;
    this.zzl = paramString4;
    this.zzm = paramFloat;
    this.zzn = paramLong3;
    this.zzo = paramBoolean;
  }
  
  public WakeLockEvent(long paramLong1, int paramInt1, String paramString1, int paramInt2, List<String> paramList, String paramString2, long paramLong2, int paramInt3, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5, boolean paramBoolean) {
    this(2, paramLong1, paramInt1, paramString1, paramInt2, paramList, paramString2, paramLong2, paramInt3, paramString3, paramString4, paramFloat, paramLong3, paramString5, paramBoolean);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zza);
    SafeParcelWriter.writeLong(paramParcel, 2, super.zza());
    SafeParcelWriter.writeString(paramParcel, 4, this.zzd, false);
    SafeParcelWriter.writeInt(paramParcel, 5, this.zzg);
    SafeParcelWriter.writeStringList(paramParcel, 6, this.zzh, false);
    SafeParcelWriter.writeLong(paramParcel, 8, this.zzj);
    SafeParcelWriter.writeString(paramParcel, 10, this.zze, false);
    SafeParcelWriter.writeInt(paramParcel, 11, super.zzb());
    SafeParcelWriter.writeString(paramParcel, 12, this.zzi, false);
    SafeParcelWriter.writeString(paramParcel, 13, this.zzl, false);
    SafeParcelWriter.writeInt(paramParcel, 14, this.zzk);
    SafeParcelWriter.writeFloat(paramParcel, 15, this.zzm);
    SafeParcelWriter.writeLong(paramParcel, 16, this.zzn);
    SafeParcelWriter.writeString(paramParcel, 17, this.zzf, false);
    SafeParcelWriter.writeBoolean(paramParcel, 18, this.zzo);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final long zza() {
    return this.zzb;
  }
  
  public final int zzb() {
    return this.zzc;
  }
  
  public final long zzc() {
    return this.zzp;
  }
  
  public final String zzd() {
    String str1;
    String str6 = this.zzd;
    int i = this.zzg;
    List<String> list = this.zzh;
    String str4 = "";
    if (list == null) {
      str1 = "";
    } else {
      str1 = TextUtils.join(",", (Iterable)str1);
    } 
    int j = this.zzk;
    String str3 = this.zze;
    String str2 = str3;
    if (str3 == null)
      str2 = ""; 
    String str5 = this.zzl;
    str3 = str5;
    if (str5 == null)
      str3 = ""; 
    float f = this.zzm;
    str5 = this.zzf;
    if (str5 != null)
      str4 = str5; 
    boolean bool = this.zzo;
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str6).length() + 51 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
    stringBuilder.append("\t");
    stringBuilder.append(str6);
    stringBuilder.append("\t");
    stringBuilder.append(i);
    stringBuilder.append("\t");
    stringBuilder.append(str1);
    stringBuilder.append("\t");
    stringBuilder.append(j);
    stringBuilder.append("\t");
    stringBuilder.append(str2);
    stringBuilder.append("\t");
    stringBuilder.append(str3);
    stringBuilder.append("\t");
    stringBuilder.append(f);
    stringBuilder.append("\t");
    stringBuilder.append(str4);
    stringBuilder.append("\t");
    stringBuilder.append(bool);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\stats\WakeLockEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */