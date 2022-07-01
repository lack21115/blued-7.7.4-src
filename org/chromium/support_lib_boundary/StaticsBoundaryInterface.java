package org.chromium.support_lib_boundary;

import android.content.Context;
import android.net.Uri;
import android.webkit.ValueCallback;
import java.util.List;

public interface StaticsBoundaryInterface {
  Uri getSafeBrowsingPrivacyPolicyUrl();
  
  void initSafeBrowsing(Context paramContext, ValueCallback paramValueCallback);
  
  void setSafeBrowsingWhitelist(List paramList, ValueCallback paramValueCallback);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_boundary\StaticsBoundaryInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */