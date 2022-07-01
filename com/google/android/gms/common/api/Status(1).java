package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
  public static final Parcelable.Creator<Status> CREATOR;
  
  public static final Status RESULT_CANCELED;
  
  public static final Status RESULT_DEAD_CLIENT;
  
  public static final Status RESULT_INTERNAL_ERROR;
  
  public static final Status RESULT_INTERRUPTED;
  
  public static final Status RESULT_SUCCESS = new Status(0);
  
  public static final Status RESULT_TIMEOUT;
  
  private static final Status zza;
  
  private final int zzb;
  
  private final int zzc;
  
  private final String zzd;
  
  private final PendingIntent zze;
  
  static {
    RESULT_INTERRUPTED = new Status(14);
    RESULT_INTERNAL_ERROR = new Status(8);
    RESULT_TIMEOUT = new Status(15);
    RESULT_CANCELED = new Status(16);
    zza = new Status(17);
    RESULT_DEAD_CLIENT = new Status(18);
    CREATOR = new zzb();
  }
  
  public Status(int paramInt) {
    this(paramInt, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent) {
    this.zzb = paramInt1;
    this.zzc = paramInt2;
    this.zzd = paramString;
    this.zze = paramPendingIntent;
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
    return (this.zzb == ((Status)paramObject).zzb && this.zzc == ((Status)paramObject).zzc && Objects.equal(this.zzd, ((Status)paramObject).zzd) && Objects.equal(this.zze, ((Status)paramObject).zze));
  }
  
  public final PendingIntent getResolution() {
    return this.zze;
  }
  
  public final Status getStatus() {
    return this;
  }
  
  public final int getStatusCode() {
    return this.zzc;
  }
  
  public final String getStatusMessage() {
    return this.zzd;
  }
  
  public final boolean hasResolution() {
    return (this.zze != null);
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd, this.zze });
  }
  
  public final boolean isCanceled() {
    return (this.zzc == 16);
  }
  
  public final boolean isInterrupted() {
    return (this.zzc == 14);
  }
  
  public final boolean isSuccess() {
    return (this.zzc <= 0);
  }
  
  public final void startResolutionForResult(Activity paramActivity, int paramInt) throws IntentSender.SendIntentException {
    if (!hasResolution())
      return; 
    paramActivity.startIntentSenderForResult(((PendingIntent)Preconditions.checkNotNull(this.zze)).getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public final String toString() {
    return Objects.toStringHelper(this).add("statusCode", zza()).add("resolution", this.zze).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getStatusCode());
    SafeParcelWriter.writeString(paramParcel, 2, getStatusMessage(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)this.zze, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.zzb);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final String zza() {
    String str = this.zzd;
    return (str != null) ? str : CommonStatusCodes.getStatusCodeString(this.zzc);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */