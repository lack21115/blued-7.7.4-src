package android.support.v4.widget;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;

final class NestedScrollView$AccessibilityDelegate extends AccessibilityDelegateCompat {
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    boolean bool;
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    NestedScrollView nestedScrollView = (NestedScrollView)paramView;
    paramAccessibilityEvent.setClassName(ScrollView.class.getName());
    if (nestedScrollView.getScrollRange() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    paramAccessibilityEvent.setScrollable(bool);
    paramAccessibilityEvent.setScrollX(nestedScrollView.getScrollX());
    paramAccessibilityEvent.setScrollY(nestedScrollView.getScrollY());
    int i = nestedScrollView.getScrollX();
    if (Build.VERSION.SDK_INT >= 15)
      paramAccessibilityEvent.setMaxScrollX(i); 
    i = nestedScrollView.getScrollRange();
    if (Build.VERSION.SDK_INT >= 15)
      paramAccessibilityEvent.setMaxScrollY(i); 
  }
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    NestedScrollView nestedScrollView = (NestedScrollView)paramView;
    String str = ScrollView.class.getName();
    paramAccessibilityNodeInfoCompat.mInfo.setClassName(str);
    if (nestedScrollView.isEnabled()) {
      int i = nestedScrollView.getScrollRange();
      if (i > 0) {
        paramAccessibilityNodeInfoCompat.mInfo.setScrollable(true);
        if (nestedScrollView.getScrollY() > 0)
          paramAccessibilityNodeInfoCompat.addAction(8192); 
        if (nestedScrollView.getScrollY() < i)
          paramAccessibilityNodeInfoCompat.addAction(4096); 
      } 
    } 
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle) {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle))
      return true; 
    NestedScrollView nestedScrollView = (NestedScrollView)paramView;
    if (!nestedScrollView.isEnabled())
      return false; 
    if (paramInt != 4096) {
      if (paramInt != 8192)
        return false; 
      paramInt = nestedScrollView.getHeight();
      int k = nestedScrollView.getPaddingBottom();
      int m = nestedScrollView.getPaddingTop();
      paramInt = Math.max(nestedScrollView.getScrollY() - paramInt - k - m, 0);
      if (paramInt != nestedScrollView.getScrollY()) {
        nestedScrollView.smoothScrollTo(0, paramInt);
        return true;
      } 
      return false;
    } 
    paramInt = nestedScrollView.getHeight();
    int i = nestedScrollView.getPaddingBottom();
    int j = nestedScrollView.getPaddingTop();
    paramInt = Math.min(nestedScrollView.getScrollY() + paramInt - i - j, nestedScrollView.getScrollRange());
    if (paramInt != nestedScrollView.getScrollY()) {
      nestedScrollView.smoothScrollTo(0, paramInt);
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\widget\NestedScrollView$AccessibilityDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */