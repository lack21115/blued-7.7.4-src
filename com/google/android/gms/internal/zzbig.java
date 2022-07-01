package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;

public final class zzbig {
  public Context mContext;
  
  public zzbig(Context paramContext) {
    this.mContext = paramContext;
  }
  
  public final ApplicationInfo getApplicationInfo(String paramString, int paramInt) {
    return this.mContext.getPackageManager().getApplicationInfo(paramString, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzbig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */