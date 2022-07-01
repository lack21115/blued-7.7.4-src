package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

public class ActivityRecognitionResult extends AbstractSafeParcelable implements ReflectedParcelable {
  public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new zzf();
  
  private List<DetectedActivity> zza;
  
  private long zzb;
  
  private long zzc;
  
  private int zzd;
  
  private Bundle zze;
  
  public ActivityRecognitionResult(DetectedActivity paramDetectedActivity, long paramLong1, long paramLong2) {
    this(paramDetectedActivity, paramLong1, paramLong2, 0, (Bundle)null);
  }
  
  private ActivityRecognitionResult(DetectedActivity paramDetectedActivity, long paramLong1, long paramLong2, int paramInt, Bundle paramBundle) {
    this(Collections.singletonList(paramDetectedActivity), paramLong1, paramLong2, 0, (Bundle)null);
  }
  
  public ActivityRecognitionResult(List<DetectedActivity> paramList, long paramLong1, long paramLong2) {
    this(paramList, paramLong1, paramLong2, 0, (Bundle)null);
  }
  
  public ActivityRecognitionResult(List<DetectedActivity> paramList, long paramLong1, long paramLong2, int paramInt, Bundle paramBundle) {
    boolean bool1;
    boolean bool2 = true;
    if (paramList != null && paramList.size() > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Preconditions.checkArgument(bool1, "Must have at least 1 detected activity");
    if (paramLong1 > 0L && paramLong2 > 0L) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    Preconditions.checkArgument(bool1, "Must set times");
    this.zza = paramList;
    this.zzb = paramLong1;
    this.zzc = paramLong2;
    this.zzd = paramInt;
    this.zze = paramBundle;
  }
  
  public static ActivityRecognitionResult extractResult(Intent paramIntent) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic hasResult : (Landroid/content/Intent;)Z
    //   4: ifeq -> 56
    //   7: aload_0
    //   8: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   11: ldc 'com.google.android.location.internal.EXTRA_ACTIVITY_RESULT'
    //   13: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   16: astore_1
    //   17: aload_1
    //   18: instanceof [B
    //   21: ifeq -> 41
    //   24: aload_1
    //   25: checkcast [B
    //   28: getstatic com/google/android/gms/location/ActivityRecognitionResult.CREATOR : Landroid/os/Parcelable$Creator;
    //   31: invokestatic deserializeFromBytes : ([BLandroid/os/Parcelable$Creator;)Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;
    //   34: checkcast com/google/android/gms/location/ActivityRecognitionResult
    //   37: astore_1
    //   38: goto -> 58
    //   41: aload_1
    //   42: instanceof com/google/android/gms/location/ActivityRecognitionResult
    //   45: ifeq -> 56
    //   48: aload_1
    //   49: checkcast com/google/android/gms/location/ActivityRecognitionResult
    //   52: astore_1
    //   53: goto -> 58
    //   56: aconst_null
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull -> 64
    //   62: aload_1
    //   63: areturn
    //   64: aload_0
    //   65: invokestatic zza : (Landroid/content/Intent;)Ljava/util/List;
    //   68: astore_0
    //   69: aload_0
    //   70: ifnull -> 102
    //   73: aload_0
    //   74: invokeinterface isEmpty : ()Z
    //   79: ifeq -> 84
    //   82: aconst_null
    //   83: areturn
    //   84: aload_0
    //   85: aload_0
    //   86: invokeinterface size : ()I
    //   91: iconst_1
    //   92: isub
    //   93: invokeinterface get : (I)Ljava/lang/Object;
    //   98: checkcast com/google/android/gms/location/ActivityRecognitionResult
    //   101: areturn
    //   102: aconst_null
    //   103: areturn
  }
  
  public static boolean hasResult(Intent paramIntent) {
    boolean bool;
    if (paramIntent == null)
      return false; 
    if (paramIntent == null) {
      bool = false;
    } else {
      bool = paramIntent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
    } 
    if (bool)
      return true; 
    List<ActivityRecognitionResult> list = zza(paramIntent);
    return (list != null && !list.isEmpty());
  }
  
  private static List<ActivityRecognitionResult> zza(Intent paramIntent) {
    boolean bool;
    if (paramIntent == null) {
      bool = false;
    } else {
      bool = paramIntent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST");
    } 
    return !bool ? null : SafeParcelableSerializer.deserializeIterableFromIntentExtra(paramIntent, "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST", CREATOR);
  }
  
  private static boolean zza(Bundle paramBundle1, Bundle paramBundle2) {
    if (paramBundle1 == null && paramBundle2 == null)
      return true; 
    if ((paramBundle1 == null && paramBundle2 != null) || (paramBundle1 != null && paramBundle2 == null))
      return false; 
    if (paramBundle1.size() != paramBundle2.size())
      return false; 
    for (Object object : paramBundle1.keySet()) {
      if (!paramBundle2.containsKey((String)object))
        return false; 
      if (paramBundle1.get((String)object) == null) {
        if (paramBundle2.get((String)object) != null)
          return false; 
        continue;
      } 
      if (paramBundle1.get((String)object) instanceof Bundle) {
        if (!zza(paramBundle1.getBundle((String)object), paramBundle2.getBundle((String)object)))
          return false; 
        continue;
      } 
      if (paramBundle1.get((String)object).getClass().isArray()) {
        if (paramBundle2.get((String)object) != null) {
          if (!paramBundle2.get((String)object).getClass().isArray())
            return false; 
          Object object1 = paramBundle1.get((String)object);
          object = paramBundle2.get((String)object);
          int j = Array.getLength(object1);
          if (j != Array.getLength(object))
            continue; 
          int i = 0;
          while (true) {
            if (i < j) {
              if (!Objects.equal(Array.get(object1, i), Array.get(object, i))) {
                i = 0;
                break;
              } 
              i++;
              continue;
            } 
            i = 1;
            break;
          } 
          if (i == 0)
            return false; 
          continue;
        } 
        return false;
      } 
      if (!paramBundle1.get((String)object).equals(paramBundle2.get((String)object)))
        return false; 
    } 
    return true;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      if (this.zzb == ((ActivityRecognitionResult)paramObject).zzb && this.zzc == ((ActivityRecognitionResult)paramObject).zzc && this.zzd == ((ActivityRecognitionResult)paramObject).zzd && Objects.equal(this.zza, ((ActivityRecognitionResult)paramObject).zza) && zza(this.zze, ((ActivityRecognitionResult)paramObject).zze))
        return true; 
    } 
    return false;
  }
  
  public int getActivityConfidence(int paramInt) {
    for (DetectedActivity detectedActivity : this.zza) {
      if (detectedActivity.getType() == paramInt)
        return detectedActivity.getConfidence(); 
    } 
    return 0;
  }
  
  public long getElapsedRealtimeMillis() {
    return this.zzc;
  }
  
  public DetectedActivity getMostProbableActivity() {
    return this.zza.get(0);
  }
  
  public List<DetectedActivity> getProbableActivities() {
    return this.zza;
  }
  
  public long getTime() {
    return this.zzb;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { Long.valueOf(this.zzb), Long.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zza, this.zze });
  }
  
  public String toString() {
    String str = String.valueOf(this.zza);
    long l1 = this.zzb;
    long l2 = this.zzc;
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 124);
    stringBuilder.append("ActivityRecognitionResult [probableActivities=");
    stringBuilder.append(str);
    stringBuilder.append(", timeMillis=");
    stringBuilder.append(l1);
    stringBuilder.append(", elapsedRealtimeMillis=");
    stringBuilder.append(l2);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, this.zza, false);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzb);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzc);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzd);
    SafeParcelWriter.writeBundle(paramParcel, 5, this.zze, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\ActivityRecognitionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */