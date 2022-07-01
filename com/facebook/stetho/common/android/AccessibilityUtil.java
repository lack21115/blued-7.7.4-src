package com.facebook.stetho.common.android;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.List;

public final class AccessibilityUtil {
  public static boolean hasFocusableAncestor(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, View paramView) {
    if (paramAccessibilityNodeInfoCompat != null) {
      if (paramView == null)
        return false; 
      null = ViewCompat.getParentForAccessibility(paramView);
      if (!(null instanceof View))
        return false; 
      paramAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
      try {
        ViewCompat.onInitializeAccessibilityNodeInfo((View)null, paramAccessibilityNodeInfoCompat);
        if (paramAccessibilityNodeInfoCompat == null)
          return false; 
        boolean bool = isAccessibilityFocusable(paramAccessibilityNodeInfoCompat, (View)null);
        if (bool)
          return true; 
        bool = hasFocusableAncestor(paramAccessibilityNodeInfoCompat, (View)null);
        if (bool)
          return true; 
        return false;
      } finally {
        paramAccessibilityNodeInfoCompat.recycle();
      } 
    } 
    return false;
  }
  
  public static boolean hasNonActionableSpeakingDescendants(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, View paramView) {
    if (paramAccessibilityNodeInfoCompat != null && paramView != null) {
      if (!(paramView instanceof ViewGroup))
        return false; 
      ViewGroup viewGroup = (ViewGroup)paramView;
      int j = viewGroup.getChildCount();
      for (int i = 0;; i++) {
        if (i < j) {
          View view = viewGroup.getChildAt(i);
          if (view != null) {
            paramAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
            try {
              ViewCompat.onInitializeAccessibilityNodeInfo(view, paramAccessibilityNodeInfoCompat);
              boolean bool = isAccessibilityFocusable(paramAccessibilityNodeInfoCompat, view);
              if (!bool) {
                bool = isSpeakingNode(paramAccessibilityNodeInfoCompat, view);
                if (bool)
                  return true; 
              } 
              paramAccessibilityNodeInfoCompat.recycle();
            } finally {
              paramAccessibilityNodeInfoCompat.recycle();
            } 
            continue;
          } 
        } else {
          break;
        } 
      } 
    } 
    return false;
  }
  
  public static boolean hasText(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
    boolean bool = false;
    if (paramAccessibilityNodeInfoCompat == null)
      return false; 
    if (!TextUtils.isEmpty(paramAccessibilityNodeInfoCompat.getText()) || !TextUtils.isEmpty(paramAccessibilityNodeInfoCompat.getContentDescription()))
      bool = true; 
    return bool;
  }
  
  public static boolean isAccessibilityFocusable(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, View paramView) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAccessibilityNodeInfoCompat != null) {
      if (paramView == null)
        return false; 
      if (!paramAccessibilityNodeInfoCompat.isVisibleToUser())
        return false; 
      if (isActionableForAccessibility(paramAccessibilityNodeInfoCompat))
        return true; 
      bool1 = bool2;
      if (isTopLevelScrollItem(paramAccessibilityNodeInfoCompat, paramView)) {
        bool1 = bool2;
        if (isSpeakingNode(paramAccessibilityNodeInfoCompat, paramView))
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public static boolean isActionableForAccessibility(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
    boolean bool = false;
    if (paramAccessibilityNodeInfoCompat == null)
      return false; 
    if (!paramAccessibilityNodeInfoCompat.isClickable() && !paramAccessibilityNodeInfoCompat.isLongClickable()) {
      if (paramAccessibilityNodeInfoCompat.isFocusable())
        return true; 
      List list = paramAccessibilityNodeInfoCompat.getActionList();
      if (list.contains(Integer.valueOf(16)) || list.contains(Integer.valueOf(32)) || list.contains(Integer.valueOf(1)))
        bool = true; 
      return bool;
    } 
    return true;
  }
  
  public static boolean isSpeakingNode(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, View paramView) {
    boolean bool = false;
    null = bool;
    if (paramAccessibilityNodeInfoCompat != null) {
      if (paramView == null)
        return false; 
      if (!paramAccessibilityNodeInfoCompat.isVisibleToUser())
        return false; 
      int i = ViewCompat.getImportantForAccessibility(paramView);
      null = bool;
      if (i != 4) {
        if (i == 2 && paramAccessibilityNodeInfoCompat.getChildCount() <= 0)
          return false; 
        if (!paramAccessibilityNodeInfoCompat.isCheckable() && !hasText(paramAccessibilityNodeInfoCompat)) {
          null = bool;
          return hasNonActionableSpeakingDescendants(paramAccessibilityNodeInfoCompat, paramView) ? true : null;
        } 
      } else {
        return null;
      } 
    } else {
      return null;
    } 
    return true;
  }
  
  public static boolean isTopLevelScrollItem(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, View paramView) {
    boolean bool = false;
    if (paramAccessibilityNodeInfoCompat != null) {
      if (paramView == null)
        return false; 
      paramView = (View)ViewCompat.getParentForAccessibility(paramView);
      if (paramView == null)
        return false; 
      if (paramAccessibilityNodeInfoCompat.isScrollable())
        return true; 
      List list = paramAccessibilityNodeInfoCompat.getActionList();
      if (!list.contains(Integer.valueOf(4096))) {
        if (list.contains(Integer.valueOf(8192)))
          return true; 
        if (paramView instanceof android.widget.Spinner)
          return false; 
        if (paramView instanceof android.widget.AdapterView || paramView instanceof android.widget.ScrollView || paramView instanceof android.widget.HorizontalScrollView)
          bool = true; 
        return bool;
      } 
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\android\AccessibilityUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */