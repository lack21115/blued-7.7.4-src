package com.google.android.gms.location;

import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.location.zzbg;

public interface Geofence {
  public static final int GEOFENCE_TRANSITION_DWELL = 4;
  
  public static final int GEOFENCE_TRANSITION_ENTER = 1;
  
  public static final int GEOFENCE_TRANSITION_EXIT = 2;
  
  public static final long NEVER_EXPIRE = -1L;
  
  String getRequestId();
  
  public static final class Builder {
    private String zza = null;
    
    private int zzb = 0;
    
    private long zzc = Long.MIN_VALUE;
    
    private short zzd = -1;
    
    private double zze;
    
    private double zzf;
    
    private float zzg;
    
    private int zzh = 0;
    
    private int zzi = -1;
    
    public final Geofence build() {
      if (this.zza != null) {
        int i = this.zzb;
        if (i != 0) {
          if ((i & 0x4) == 0 || this.zzi >= 0) {
            long l = this.zzc;
            if (l != Long.MIN_VALUE) {
              if (this.zzd != -1) {
                i = this.zzh;
                if (i >= 0)
                  return (Geofence)new zzbg(this.zza, this.zzb, (short)1, this.zze, this.zzf, this.zzg, l, i, this.zzi); 
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
              } 
              throw new IllegalArgumentException("Geofence region not set.");
            } 
            throw new IllegalArgumentException("Expiration not set.");
          } 
          throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
        } 
        throw new IllegalArgumentException("Transitions types not set.");
      } 
      throw new IllegalArgumentException("Request ID not set.");
    }
    
    public final Builder setCircularRegion(double param1Double1, double param1Double2, float param1Float) {
      this.zzd = 1;
      this.zze = param1Double1;
      this.zzf = param1Double2;
      this.zzg = param1Float;
      return this;
    }
    
    public final Builder setExpirationDuration(long param1Long) {
      if (param1Long < 0L) {
        this.zzc = -1L;
        return this;
      } 
      this.zzc = DefaultClock.getInstance().elapsedRealtime() + param1Long;
      return this;
    }
    
    public final Builder setLoiteringDelay(int param1Int) {
      this.zzi = param1Int;
      return this;
    }
    
    public final Builder setNotificationResponsiveness(int param1Int) {
      this.zzh = param1Int;
      return this;
    }
    
    public final Builder setRequestId(String param1String) {
      this.zza = param1String;
      return this;
    }
    
    public final Builder setTransitionTypes(int param1Int) {
      this.zzb = param1Int;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\Geofence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */