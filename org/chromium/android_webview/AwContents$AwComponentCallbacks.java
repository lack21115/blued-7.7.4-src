package org.chromium.android_webview;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import org.chromium.base.ThreadUtils;

final class AwContents$AwComponentCallbacks implements ComponentCallbacks2 {
  private AwContents$AwComponentCallbacks() {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {
    AwContents.updateDefaultLocale();
    AwContents.access$300(AwContents.this).updateAcceptLanguages();
  }
  
  public final void onLowMemory() {}
  
  public final void onTrimMemory(int paramInt) {
    boolean bool = AwContents.access$1800(AwContents.this).isEmpty();
    if (AwContents.access$1900(AwContents.this) && AwContents.access$2000(AwContents.this) && !bool) {
      bool = true;
    } else {
      bool = false;
    } 
    ThreadUtils.runOnUiThreadBlocking(new AwContents$AwComponentCallbacks$$Lambda$0(this, paramInt, bool));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContents$AwComponentCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */