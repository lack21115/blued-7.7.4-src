package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Comparator;

public class DetectedActivity extends AbstractSafeParcelable {
  public static final Parcelable.Creator<DetectedActivity> CREATOR;
  
  public static final int IN_VEHICLE = 0;
  
  public static final int ON_BICYCLE = 1;
  
  public static final int ON_FOOT = 2;
  
  public static final int RUNNING = 8;
  
  public static final int STILL = 3;
  
  public static final int TILTING = 5;
  
  public static final int UNKNOWN = 4;
  
  public static final int WALKING = 7;
  
  private static final Comparator<DetectedActivity> zza = new zzm();
  
  private static final int[] zzb = new int[] { 9, 10 };
  
  private static final int[] zzc = new int[] { 
      0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 
      12, 13, 14, 16, 17, 18, 19, 20, 21, 22 };
  
  private int zzd;
  
  private int zze;
  
  static {
    CREATOR = new zzl();
  }
  
  public DetectedActivity(int paramInt1, int paramInt2) {
    this.zzd = paramInt1;
    this.zze = paramInt2;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof DetectedActivity) {
      paramObject = paramObject;
      if (this.zzd == ((DetectedActivity)paramObject).zzd && this.zze == ((DetectedActivity)paramObject).zze)
        return true; 
    } 
    return false;
  }
  
  public int getConfidence() {
    return this.zze;
  }
  
  public int getType() {
    int i = this.zzd;
    return (i > 22 || i < 0) ? 4 : i;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zzd), Integer.valueOf(this.zze) });
  }
  
  public String toString() {
    String str;
    int i = getType();
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4) {
              if (i != 5) {
                if (i != 7) {
                  if (i != 8) {
                    if (i != 16) {
                      if (i != 17) {
                        str = Integer.toString(i);
                      } else {
                        str = "IN_RAIL_VEHICLE";
                      } 
                    } else {
                      str = "IN_ROAD_VEHICLE";
                    } 
                  } else {
                    str = "RUNNING";
                  } 
                } else {
                  str = "WALKING";
                } 
              } else {
                str = "TILTING";
              } 
            } else {
              str = "UNKNOWN";
            } 
          } else {
            str = "STILL";
          } 
        } else {
          str = "ON_FOOT";
        } 
      } else {
        str = "ON_BICYCLE";
      } 
    } else {
      str = "IN_VEHICLE";
    } 
    i = this.zze;
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 48);
    stringBuilder.append("DetectedActivity [type=");
    stringBuilder.append(str);
    stringBuilder.append(", confidence=");
    stringBuilder.append(i);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzd);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zze);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\DetectedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */