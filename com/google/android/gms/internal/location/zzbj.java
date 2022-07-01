package com.google.android.gms.internal.location;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbj {
  public static Looper zza() {
    boolean bool;
    if (Looper.myLooper() != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "Can't create handler inside thread that has not called Looper.prepare()");
    return Looper.myLooper();
  }
  
  public static Looper zza(Looper paramLooper) {
    return (paramLooper != null) ? paramLooper : zza();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */