package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;

final class AccessibilityDelegateCompat$AccessibilityDelegateApi16Impl extends AccessibilityDelegateCompat$AccessibilityDelegateBaseImpl {
  public final AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View.AccessibilityDelegate paramAccessibilityDelegate, View paramView) {
    AccessibilityNodeProvider accessibilityNodeProvider = paramAccessibilityDelegate.getAccessibilityNodeProvider(paramView);
    return (accessibilityNodeProvider != null) ? new AccessibilityNodeProviderCompat(accessibilityNodeProvider) : null;
  }
  
  public final View.AccessibilityDelegate newAccessibilityDelegateBridge(AccessibilityDelegateCompat paramAccessibilityDelegateCompat) {
    return new AccessibilityDelegateCompat$AccessibilityDelegateApi16Impl$1(paramAccessibilityDelegateCompat);
  }
  
  public final boolean performAccessibilityAction(View.AccessibilityDelegate paramAccessibilityDelegate, View paramView, int paramInt, Bundle paramBundle) {
    return paramAccessibilityDelegate.performAccessibilityAction(paramView, paramInt, paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\AccessibilityDelegateCompat$AccessibilityDelegateApi16Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */