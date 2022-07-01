package org.chromium.content.browser.accessibility;

import android.view.ViewStructure;
import org.chromium.content_public.browser.AccessibilitySnapshotCallback;
import org.chromium.content_public.browser.AccessibilitySnapshotNode;

final class WebContentsAccessibilityImpl$1 extends AccessibilitySnapshotCallback {
  public final void onAccessibilitySnapshot(AccessibilitySnapshotNode paramAccessibilitySnapshotNode) {
    viewRoot.setClassName("");
    viewRoot.setHint(WebContentsAccessibilityImpl.access$200(WebContentsAccessibilityImpl.this));
    if (paramAccessibilitySnapshotNode == null) {
      viewRoot.asyncCommit();
      return;
    } 
    WebContentsAccessibilityImpl.access$300(WebContentsAccessibilityImpl.this, viewRoot, paramAccessibilitySnapshotNode, ignoreScrollOffset);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\accessibility\WebContentsAccessibilityImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */