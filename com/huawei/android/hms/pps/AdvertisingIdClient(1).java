package com.huawei.android.hms.pps;

import android.content.Context;

public class AdvertisingIdClient {
  public static native Info getAdvertisingIdInfo(Context paramContext);
  
  private static native String getTag();
  
  public static final class Info {
    private final String advertisingId;
    
    private final boolean limitAdTrackingEnabled;
    
    Info(String param1String, boolean param1Boolean) {
      this.advertisingId = param1String;
      this.limitAdTrackingEnabled = param1Boolean;
    }
    
    public final native String getId();
    
    public final native boolean isLimitAdTrackingEnabled();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\android\hms\pps\AdvertisingIdClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */