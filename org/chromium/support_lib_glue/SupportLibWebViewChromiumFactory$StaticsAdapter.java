package org.chromium.support_lib_glue;

import android.content.Context;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.android.webview.chromium.CallbackConverter;
import com.android.webview.chromium.SharedStatics;
import java.util.List;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;

final class SupportLibWebViewChromiumFactory$StaticsAdapter implements StaticsBoundaryInterface {
  public final Uri getSafeBrowsingPrivacyPolicyUrl() {
    return SharedStatics.getSafeBrowsingPrivacyPolicyUrl();
  }
  
  public final void initSafeBrowsing(Context paramContext, ValueCallback paramValueCallback) {
    SharedStatics.initSafeBrowsing(paramContext, CallbackConverter.fromValueCallback(paramValueCallback));
  }
  
  public final void setSafeBrowsingWhitelist(List paramList, ValueCallback paramValueCallback) {
    SharedStatics.setSafeBrowsingWhitelist(paramList, CallbackConverter.fromValueCallback(paramValueCallback));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_glue\SupportLibWebViewChromiumFactory$StaticsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */