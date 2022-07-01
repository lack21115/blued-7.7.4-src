package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ActivityTransitionRequest extends AbstractSafeParcelable {
  public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new zzj();
  
  public static final Comparator<ActivityTransition> IS_SAME_TRANSITION = new zzi();
  
  private final List<ActivityTransition> zza;
  
  private final String zzb;
  
  private final List<ClientIdentity> zzc;
  
  public ActivityTransitionRequest(List<ActivityTransition> paramList) {
    this(paramList, null, null);
  }
  
  public ActivityTransitionRequest(List<ActivityTransition> paramList, String paramString, List<ClientIdentity> paramList1) {
    boolean bool;
    Preconditions.checkNotNull(paramList, "transitions can't be null");
    if (paramList.size() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "transitions can't be empty.");
    TreeSet<ActivityTransition> treeSet = new TreeSet<ActivityTransition>(IS_SAME_TRANSITION);
    for (ActivityTransition activityTransition : paramList) {
      Preconditions.checkArgument(treeSet.add(activityTransition), String.format("Found duplicated transition: %s.", new Object[] { activityTransition }));
    } 
    this.zza = Collections.unmodifiableList(paramList);
    this.zzb = paramString;
    if (paramList1 == null) {
      paramList = Collections.emptyList();
    } else {
      paramList = Collections.unmodifiableList(paramList1);
    } 
    this.zzc = (List)paramList;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      if (Objects.equal(this.zza, ((ActivityTransitionRequest)paramObject).zza) && Objects.equal(this.zzb, ((ActivityTransitionRequest)paramObject).zzb) && Objects.equal(this.zzc, ((ActivityTransitionRequest)paramObject).zzc))
        return true; 
    } 
    return false;
  }
  
  public int hashCode() {
    byte b;
    int j = this.zza.hashCode();
    String str = this.zzb;
    int i = 0;
    if (str != null) {
      b = str.hashCode();
    } else {
      b = 0;
    } 
    List<ClientIdentity> list = this.zzc;
    if (list != null)
      i = list.hashCode(); 
    return (j * 31 + b) * 31 + i;
  }
  
  public void serializeToIntentExtra(Intent paramIntent) {
    SafeParcelableSerializer.serializeToIntentExtra((SafeParcelable)this, paramIntent, "com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_REQUEST");
  }
  
  public String toString() {
    String str1 = String.valueOf(this.zza);
    String str2 = this.zzb;
    String str3 = String.valueOf(this.zzc);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 61 + String.valueOf(str2).length() + String.valueOf(str3).length());
    stringBuilder.append("ActivityTransitionRequest [mTransitions=");
    stringBuilder.append(str1);
    stringBuilder.append(", mTag='");
    stringBuilder.append(str2);
    stringBuilder.append('\'');
    stringBuilder.append(", mClients=");
    stringBuilder.append(str3);
    stringBuilder.append(']');
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, this.zza, false);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzb, false);
    SafeParcelWriter.writeTypedList(paramParcel, 3, this.zzc, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\ActivityTransitionRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */