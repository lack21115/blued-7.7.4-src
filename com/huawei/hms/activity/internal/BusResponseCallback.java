package com.huawei.hms.activity.internal;

import android.app.Activity;
import android.content.Intent;

public interface BusResponseCallback {
  BusResponseResult innerError(Activity paramActivity, int paramInt, String paramString);
  
  BusResponseResult succeedReturn(Activity paramActivity, int paramInt, Intent paramIntent);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\activity\internal\BusResponseCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */