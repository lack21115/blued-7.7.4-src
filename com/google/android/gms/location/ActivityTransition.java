package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ActivityTransition extends AbstractSafeParcelable {
  public static final int ACTIVITY_TRANSITION_ENTER = 0;
  
  public static final int ACTIVITY_TRANSITION_EXIT = 1;
  
  public static final Parcelable.Creator<ActivityTransition> CREATOR = new zzg();
  
  private final int zza;
  
  private final int zzb;
  
  ActivityTransition(int paramInt1, int paramInt2) {
    this.zza = paramInt1;
    this.zzb = paramInt2;
  }
  
  public static void zza(int paramInt) {
    boolean bool = true;
    if (paramInt < 0 || paramInt > 1)
      bool = false; 
    StringBuilder stringBuilder = new StringBuilder(41);
    stringBuilder.append("Transition type ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" is not valid.");
    Preconditions.checkArgument(bool, stringBuilder.toString());
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof ActivityTransition))
      return false; 
    paramObject = paramObject;
    return (this.zza == ((ActivityTransition)paramObject).zza && this.zzb == ((ActivityTransition)paramObject).zzb);
  }
  
  public int getActivityType() {
    return this.zza;
  }
  
  public int getTransitionType() {
    return this.zzb;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.zza), Integer.valueOf(this.zzb) });
  }
  
  public String toString() {
    int i = this.zza;
    int j = this.zzb;
    StringBuilder stringBuilder = new StringBuilder(75);
    stringBuilder.append("ActivityTransition [mActivityType=");
    stringBuilder.append(i);
    stringBuilder.append(", mTransitionType=");
    stringBuilder.append(j);
    stringBuilder.append(']');
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getActivityType());
    SafeParcelWriter.writeInt(paramParcel, 2, getTransitionType());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public static class Builder {
    private int zza = -1;
    
    private int zzb = -1;
    
    public ActivityTransition build() {
      boolean bool1;
      int i = this.zza;
      boolean bool2 = true;
      if (i != -1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      Preconditions.checkState(bool1, "Activity type not set.");
      if (this.zzb != -1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      Preconditions.checkState(bool1, "Activity transition type not set.");
      return new ActivityTransition(this.zza, this.zzb);
    }
    
    public Builder setActivityTransition(int param1Int) {
      ActivityTransition.zza(param1Int);
      this.zzb = param1Int;
      return this;
    }
    
    public Builder setActivityType(int param1Int) {
      this.zza = param1Int;
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SupportedActivityTransition {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\ActivityTransition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */