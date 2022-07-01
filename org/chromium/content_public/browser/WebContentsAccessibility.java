package org.chromium.content_public.browser;

import android.annotation.TargetApi;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityNodeProvider;

public interface WebContentsAccessibility {
  AccessibilityNodeProvider getAccessibilityNodeProvider();
  
  @TargetApi(23)
  void onProvideVirtualStructure(ViewStructure paramViewStructure, boolean paramBoolean);
  
  boolean performAction$68e2e3ea();
  
  boolean supportsAction$134632();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\WebContentsAccessibility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */