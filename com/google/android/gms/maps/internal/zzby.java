package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.Parcelable;

public final class zzby {
  private static <T extends Parcelable> T zza(Bundle paramBundle, String paramString) {
    if (paramBundle == null)
      return null; 
    paramBundle.setClassLoader(zzby.class.getClassLoader());
    paramBundle = paramBundle.getBundle("map_state");
    if (paramBundle == null)
      return null; 
    paramBundle.setClassLoader(zzby.class.getClassLoader());
    return (T)paramBundle.getParcelable(paramString);
  }
  
  public static void zza(Bundle paramBundle1, Bundle paramBundle2) {
    if (paramBundle1 != null) {
      if (paramBundle2 == null)
        return; 
      Parcelable parcelable = (Parcelable)zza(paramBundle1, "MapOptions");
      if (parcelable != null)
        zza(paramBundle2, "MapOptions", parcelable); 
      parcelable = zza(paramBundle1, "StreetViewPanoramaOptions");
      if (parcelable != null)
        zza(paramBundle2, "StreetViewPanoramaOptions", parcelable); 
      parcelable = zza(paramBundle1, "camera");
      if (parcelable != null)
        zza(paramBundle2, "camera", parcelable); 
      if (paramBundle1.containsKey("position"))
        paramBundle2.putString("position", paramBundle1.getString("position")); 
      if (paramBundle1.containsKey("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT"))
        paramBundle2.putBoolean("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT", paramBundle1.getBoolean("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT", false)); 
    } 
  }
  
  public static void zza(Bundle paramBundle, String paramString, Parcelable paramParcelable) {
    paramBundle.setClassLoader(zzby.class.getClassLoader());
    Bundle bundle2 = paramBundle.getBundle("map_state");
    Bundle bundle1 = bundle2;
    if (bundle2 == null)
      bundle1 = new Bundle(); 
    bundle1.setClassLoader(zzby.class.getClassLoader());
    bundle1.putParcelable(paramString, paramParcelable);
    paramBundle.putBundle("map_state", bundle1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\zzby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */