package com.android.webview.chromium;

import android.webkit.RenderProcessGoneDetail;
import org.chromium.android_webview.AwRenderProcessGoneDetail;

final class ApiHelperForO$1 extends RenderProcessGoneDetail {
  public final boolean didCrash() {
    return detail.mDidCrash;
  }
  
  public final int rendererPriorityAtExit() {
    return detail.mRendererPriority;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\ApiHelperForO$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */