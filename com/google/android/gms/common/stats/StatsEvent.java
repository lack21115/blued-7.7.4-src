package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
  public String toString() {
    long l1 = zza();
    int i = zzb();
    long l2 = zzc();
    String str = zzd();
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 53);
    stringBuilder.append(l1);
    stringBuilder.append("\t");
    stringBuilder.append(i);
    stringBuilder.append("\t");
    stringBuilder.append(l2);
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
  
  public abstract long zza();
  
  public abstract int zzb();
  
  public abstract long zzc();
  
  public abstract String zzd();
  
  public static interface Types {
    public static final int EVENT_TYPE_ACQUIRE_WAKE_LOCK = 7;
    
    public static final int EVENT_TYPE_RELEASE_WAKE_LOCK = 8;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\stats\StatsEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */