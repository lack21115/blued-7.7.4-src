package org.chromium.content.browser.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.Iterator;
import org.chromium.content_public.browser.WebContents;

@TargetApi(19)
public class KitKatWebContentsAccessibility extends WebContentsAccessibilityImpl {
  private String mSupportedHtmlElementTypes;
  
  KitKatWebContentsAccessibility(WebContents paramWebContents) {
    super(paramWebContents);
  }
  
  protected int getAccessibilityServiceCapabilitiesMask() {
    Iterator<AccessibilityServiceInfo> iterator = this.mAccessibilityManager.getEnabledAccessibilityServiceList(-1).iterator();
    int i;
    for (i = 0; iterator.hasNext(); i |= ((AccessibilityServiceInfo)iterator.next()).getCapabilities());
    return i;
  }
  
  protected void onNativeInit() {
    super.onNativeInit();
    this.mSupportedHtmlElementTypes = nativeGetSupportedHtmlElementTypes(this.mNativeObj);
  }
  
  protected void setAccessibilityNodeInfoKitKatAttributes(AccessibilityNodeInfo paramAccessibilityNodeInfo, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean3) {
    Bundle bundle = paramAccessibilityNodeInfo.getExtras();
    bundle.putCharSequence("AccessibilityNodeInfo.chromeRole", paramString1);
    bundle.putCharSequence("AccessibilityNodeInfo.roleDescription", paramString2);
    bundle.putCharSequence("AccessibilityNodeInfo.hint", paramString3);
    if (paramBoolean3)
      bundle.putCharSequence("AccessibilityNodeInfo.hasImage", "true"); 
    if (paramBoolean1)
      bundle.putCharSequence("ACTION_ARGUMENT_HTML_ELEMENT_STRING_VALUES", this.mSupportedHtmlElementTypes); 
    if (paramBoolean2) {
      paramAccessibilityNodeInfo.setEditable(true);
      paramAccessibilityNodeInfo.setTextSelection(paramInt1, paramInt2);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\accessibility\KitKatWebContentsAccessibility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */