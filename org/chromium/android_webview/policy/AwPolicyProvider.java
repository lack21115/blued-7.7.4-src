package org.chromium.android_webview.policy;

import android.content.Context;
import android.os.Bundle;
import java.util.Iterator;
import org.chromium.policy.AppRestrictionsProvider;

public final class AwPolicyProvider extends AppRestrictionsProvider {
  public AwPolicyProvider(Context paramContext) {
    super(paramContext);
  }
  
  public final void notifySettingsAvailable(Bundle paramBundle) {
    Bundle bundle;
    if (paramBundle != null) {
      Bundle bundle1 = new Bundle();
      Iterator<String> iterator = paramBundle.keySet().iterator();
      while (true) {
        bundle = bundle1;
        if (iterator.hasNext()) {
          String str = iterator.next();
          if (str.startsWith("com.android.browser:"))
            bundle1.putSerializable(str.substring(20), paramBundle.getSerializable(str)); 
          continue;
        } 
        break;
      } 
    } else {
      bundle = null;
    } 
    super.notifySettingsAvailable(bundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\policy\AwPolicyProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */