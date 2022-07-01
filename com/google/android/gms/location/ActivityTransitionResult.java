package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Collections;
import java.util.List;

public class ActivityTransitionResult extends AbstractSafeParcelable {
  public static final Parcelable.Creator<ActivityTransitionResult> CREATOR = new zzk();
  
  private final List<ActivityTransitionEvent> zza;
  
  private Bundle zzb = null;
  
  public ActivityTransitionResult(List<ActivityTransitionEvent> paramList) {
    Preconditions.checkNotNull(paramList, "transitionEvents list can't be null.");
    if (!paramList.isEmpty())
      for (int i = 1; i < paramList.size(); i++) {
        boolean bool;
        if (((ActivityTransitionEvent)paramList.get(i)).getElapsedRealTimeNanos() >= ((ActivityTransitionEvent)paramList.get(i - 1)).getElapsedRealTimeNanos()) {
          bool = true;
        } else {
          bool = false;
        } 
        Preconditions.checkArgument(bool);
      }  
    this.zza = Collections.unmodifiableList(paramList);
  }
  
  public ActivityTransitionResult(List<ActivityTransitionEvent> paramList, Bundle paramBundle) {
    this(paramList);
    this.zzb = paramBundle;
  }
  
  public static ActivityTransitionResult extractResult(Intent paramIntent) {
    return !hasResult(paramIntent) ? null : (ActivityTransitionResult)SafeParcelableSerializer.deserializeFromIntentExtra(paramIntent, "com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_RESULT", CREATOR);
  }
  
  public static boolean hasResult(Intent paramIntent) {
    return (paramIntent == null) ? false : paramIntent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_RESULT");
  }
  
  public boolean equals(Object paramObject) {
    return (this == paramObject) ? true : ((paramObject == null || getClass() != paramObject.getClass()) ? false : this.zza.equals(((ActivityTransitionResult)paramObject).zza));
  }
  
  public List<ActivityTransitionEvent> getTransitionEvents() {
    return this.zza;
  }
  
  public int hashCode() {
    return this.zza.hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getTransitionEvents(), false);
    SafeParcelWriter.writeBundle(paramParcel, 2, this.zzb, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\ActivityTransitionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */