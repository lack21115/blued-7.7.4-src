package com.blued.android.framework.view.SuperToast.utils;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

public class AccessibilityUtils {
  public static boolean a(View paramView) {
    AccessibilityManager accessibilityManager = (AccessibilityManager)paramView.getContext().getSystemService("accessibility");
    if (!accessibilityManager.isEnabled())
      return false; 
    AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain(64);
    accessibilityEvent.setClassName(paramView.getClass().getName());
    accessibilityEvent.setPackageName(paramView.getContext().getPackageName());
    paramView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    accessibilityManager.sendAccessibilityEvent(accessibilityEvent);
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\SuperToas\\utils\AccessibilityUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */