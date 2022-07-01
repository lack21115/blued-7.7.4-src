package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;

class AccessibilityDelegateCompat$AccessibilityDelegateBaseImpl {
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View.AccessibilityDelegate paramAccessibilityDelegate, View paramView) {
    return null;
  }
  
  public View.AccessibilityDelegate newAccessibilityDelegateBridge(AccessibilityDelegateCompat paramAccessibilityDelegateCompat) {
    return new AccessibilityDelegateCompat$AccessibilityDelegateBaseImpl$1(paramAccessibilityDelegateCompat);
  }
  
  public boolean performAccessibilityAction(View.AccessibilityDelegate paramAccessibilityDelegate, View paramView, int paramInt, Bundle paramBundle) {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\AccessibilityDelegateCompat$AccessibilityDelegateBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */