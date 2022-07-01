package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class ActivityTransitionEvent extends AbstractSafeParcelable {
  public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new zzh();
  
  private final int zza;
  
  private final int zzb;
  
  private final long zzc;
  
  public ActivityTransitionEvent(int paramInt1, int paramInt2, long paramLong) {
    ActivityTransition.zza(paramInt2);
    this.zza = paramInt1;
    this.zzb = paramInt2;
    this.zzc = paramLong;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof ActivityTransitionEvent))
      return false; 
    paramObject = paramObject;
    return (this.zza == ((ActivityTransitionEvent)paramObject).zza && this.zzb == ((ActivityTransitionEvent)paramObject).zzb && this.zzc == ((ActivityTransitionEvent)paramObject).zzc);
  }
  
  public int getActivityType() {
    return this.zza;
  }
  
  public long getElapsedRealTimeNanos() {
    return this.zzc;
  }
  
  public int getTransitionType() {
    return this.zzb;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Long.valueOf(this.zzc) });
  }
  
  public String toString() {
    StringBuilder stringBuilder1 = new StringBuilder();
    int i = this.zza;
    StringBuilder stringBuilder2 = new StringBuilder(24);
    stringBuilder2.append("ActivityType ");
    stringBuilder2.append(i);
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder1.append(" ");
    i = this.zzb;
    stringBuilder2 = new StringBuilder(26);
    stringBuilder2.append("TransitionType ");
    stringBuilder2.append(i);
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder1.append(" ");
    long l = this.zzc;
    stringBuilder2 = new StringBuilder(41);
    stringBuilder2.append("ElapsedRealTimeNanos ");
    stringBuilder2.append(l);
    stringBuilder1.append(stringBuilder2.toString());
    return stringBuilder1.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getActivityType());
    SafeParcelWriter.writeInt(paramParcel, 2, getTransitionType());
    SafeParcelWriter.writeLong(paramParcel, 3, getElapsedRealTimeNanos());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\ActivityTransitionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */