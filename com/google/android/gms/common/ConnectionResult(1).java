package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class ConnectionResult extends AbstractSafeParcelable {
  public static final int API_UNAVAILABLE = 16;
  
  public static final int CANCELED = 13;
  
  public static final Parcelable.Creator<ConnectionResult> CREATOR;
  
  public static final int DEVELOPER_ERROR = 10;
  
  @Deprecated
  public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
  
  public static final int INTERNAL_ERROR = 8;
  
  public static final int INTERRUPTED = 15;
  
  public static final int INVALID_ACCOUNT = 5;
  
  public static final int LICENSE_CHECK_FAILED = 11;
  
  public static final int NETWORK_ERROR = 7;
  
  public static final int RESOLUTION_REQUIRED = 6;
  
  public static final int RESTRICTED_PROFILE = 20;
  
  public static final ConnectionResult RESULT_SUCCESS = new ConnectionResult(0);
  
  public static final int SERVICE_DISABLED = 3;
  
  public static final int SERVICE_INVALID = 9;
  
  public static final int SERVICE_MISSING = 1;
  
  public static final int SERVICE_MISSING_PERMISSION = 19;
  
  public static final int SERVICE_UPDATING = 18;
  
  public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
  
  public static final int SIGN_IN_FAILED = 17;
  
  public static final int SIGN_IN_REQUIRED = 4;
  
  public static final int SUCCESS = 0;
  
  public static final int TIMEOUT = 14;
  
  public static final int UNKNOWN = -1;
  
  private final int zza;
  
  private final int zzb;
  
  private final PendingIntent zzc;
  
  private final String zzd;
  
  static {
    CREATOR = new zza();
  }
  
  public ConnectionResult(int paramInt) {
    this(paramInt, null, null);
  }
  
  ConnectionResult(int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString) {
    this.zza = paramInt1;
    this.zzb = paramInt2;
    this.zzc = paramPendingIntent;
    this.zzd = paramString;
  }
  
  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent) {
    this(paramInt, paramPendingIntent, null);
  }
  
  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent, String paramString) {
    this(1, paramInt, paramPendingIntent, paramString);
  }
  
  static String zza(int paramInt) {
    if (paramInt != 99) {
      if (paramInt != 1500) {
        StringBuilder stringBuilder;
        switch (paramInt) {
          default:
            switch (paramInt) {
              default:
                stringBuilder = new StringBuilder(31);
                stringBuilder.append("UNKNOWN_ERROR_CODE(");
                stringBuilder.append(paramInt);
                stringBuilder.append(")");
                return stringBuilder.toString();
              case 21:
                return "API_VERSION_UPDATE_REQUIRED";
              case 20:
                return "RESTRICTED_PROFILE";
              case 19:
                return "SERVICE_MISSING_PERMISSION";
              case 18:
                return "SERVICE_UPDATING";
              case 17:
                return "SIGN_IN_FAILED";
              case 16:
                return "API_UNAVAILABLE";
              case 15:
                return "INTERRUPTED";
              case 14:
                return "TIMEOUT";
              case 13:
                break;
            } 
            return "CANCELED";
          case 11:
            return "LICENSE_CHECK_FAILED";
          case 10:
            return "DEVELOPER_ERROR";
          case 9:
            return "SERVICE_INVALID";
          case 8:
            return "INTERNAL_ERROR";
          case 7:
            return "NETWORK_ERROR";
          case 6:
            return "RESOLUTION_REQUIRED";
          case 5:
            return "INVALID_ACCOUNT";
          case 4:
            return "SIGN_IN_REQUIRED";
          case 3:
            return "SERVICE_DISABLED";
          case 2:
            return "SERVICE_VERSION_UPDATE_REQUIRED";
          case 1:
            return "SERVICE_MISSING";
          case 0:
            return "SUCCESS";
          case -1:
            break;
        } 
        return "UNKNOWN";
      } 
      return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
    } 
    return "UNFINISHED";
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ConnectionResult))
      return false; 
    paramObject = paramObject;
    return (this.zzb == ((ConnectionResult)paramObject).zzb && Objects.equal(this.zzc, ((ConnectionResult)paramObject).zzc) && Objects.equal(this.zzd, ((ConnectionResult)paramObject).zzd));
  }
  
  public final int getErrorCode() {
    return this.zzb;
  }
  
  public final String getErrorMessage() {
    return this.zzd;
  }
  
  public final PendingIntent getResolution() {
    return this.zzc;
  }
  
  public final boolean hasResolution() {
    return (this.zzb != 0 && this.zzc != null);
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zzb), this.zzc, this.zzd });
  }
  
  public final boolean isSuccess() {
    return (this.zzb == 0);
  }
  
  public final void startResolutionForResult(Activity paramActivity, int paramInt) throws IntentSender.SendIntentException {
    if (!hasResolution())
      return; 
    paramActivity.startIntentSenderForResult(((PendingIntent)Preconditions.checkNotNull(this.zzc)).getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public final String toString() {
    return Objects.toStringHelper(this).add("statusCode", zza(this.zzb)).add("resolution", this.zzc).add("message", this.zzd).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zza);
    SafeParcelWriter.writeInt(paramParcel, 2, getErrorCode());
    SafeParcelWriter.writeParcelable(paramParcel, 3, (Parcelable)getResolution(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 4, getErrorMessage(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\ConnectionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */