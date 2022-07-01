package org.chromium.policy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import org.chromium.base.ThreadUtils;

public abstract class AbstractAppRestrictionsProvider extends PolicyProvider {
  private static Bundle sTestRestrictions;
  
  private final BroadcastReceiver mAppRestrictionsChangedReceiver = new AbstractAppRestrictionsProvider$1(this);
  
  private final Context mContext;
  
  public AbstractAppRestrictionsProvider(Context paramContext) {
    this.mContext = paramContext;
  }
  
  protected abstract Bundle getApplicationRestrictions(String paramString);
  
  protected abstract String getRestrictionChangeIntentAction();
  
  public final void refresh() {
    if (sTestRestrictions != null) {
      notifySettingsAvailable(sTestRestrictions);
      return;
    } 
    StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
    System.currentTimeMillis();
    Bundle bundle = getApplicationRestrictions(this.mContext.getPackageName());
    StrictMode.setThreadPolicy(threadPolicy);
    notifySettingsAvailable(bundle);
  }
  
  public final void startListeningForPolicyChanges() {
    String str = getRestrictionChangeIntentAction();
    if (str == null)
      return; 
    this.mContext.registerReceiver(this.mAppRestrictionsChangedReceiver, new IntentFilter(str), null, new Handler(ThreadUtils.getUiThreadLooper()));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\policy\AbstractAppRestrictionsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */