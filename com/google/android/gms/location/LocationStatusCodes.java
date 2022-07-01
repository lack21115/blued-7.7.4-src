package com.google.android.gms.location;

import com.google.android.gms.common.api.Status;

@Deprecated
public final class LocationStatusCodes {
  public static final int ERROR = 1;
  
  public static final int GEOFENCE_NOT_AVAILABLE = 1000;
  
  public static final int GEOFENCE_TOO_MANY_GEOFENCES = 1001;
  
  public static final int GEOFENCE_TOO_MANY_PENDING_INTENTS = 1002;
  
  public static final int SUCCESS = 0;
  
  public static int zza(int paramInt) {
    return ((paramInt >= 0 && paramInt <= 1) || (1000 <= paramInt && paramInt < 1006)) ? paramInt : 1;
  }
  
  public static Status zzb(int paramInt) {
    if (paramInt == 1)
      paramInt = 13; 
    return new Status(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\LocationStatusCodes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */