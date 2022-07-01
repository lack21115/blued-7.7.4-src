package com.facebook.stetho.inspector.elements.android;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.stetho.common.android.AccessibilityUtil;

public final class AccessibilityNodeInfoWrapper {
  public static AccessibilityNodeInfoCompat createNodeInfoFromView(View paramView) {
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
    ViewCompat.onInitializeAccessibilityNodeInfo(paramView, accessibilityNodeInfoCompat);
    return accessibilityNodeInfoCompat;
  }
  
  public static String getActions(View paramView) {
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = createNodeInfoFromView(paramView);
    try {
      StringBuilder stringBuilder = new StringBuilder();
      for (AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat : accessibilityNodeInfoCompat.getActionList()) {
        if (stringBuilder.length() > 0)
          stringBuilder.append(", "); 
        int i = accessibilityActionCompat.getId();
        if (i != 1) {
          if (i != 2) {
            switch (i) {
              case 131072:
                stringBuilder.append("set-selection");
                continue;
              case 65536:
                stringBuilder.append("cut");
                continue;
              case 32768:
                stringBuilder.append("paste");
                continue;
              case 16384:
                stringBuilder.append("copy");
                continue;
              case 8192:
                stringBuilder.append("scroll-backward");
                continue;
              case 4096:
                stringBuilder.append("scroll-forward");
                continue;
              case 2048:
                stringBuilder.append("previous-html-element");
                continue;
              case 1024:
                stringBuilder.append("next-html-element");
                continue;
              case 512:
                stringBuilder.append("previous-at-movement-granularity");
                continue;
              case 256:
                stringBuilder.append("next-at-movement-granularity");
                continue;
              case 128:
                stringBuilder.append("clear-accessibility-focus");
                continue;
              case 64:
                stringBuilder.append("accessibility-focus");
                continue;
              case 32:
                stringBuilder.append("long-click");
                continue;
              case 16:
                stringBuilder.append("click");
                continue;
              case 8:
                stringBuilder.append("clear-selection");
                continue;
              case 4:
                stringBuilder.append("select");
                continue;
            } 
            CharSequence charSequence = accessibilityActionCompat.getLabel();
            if (charSequence != null) {
              stringBuilder.append(charSequence);
              continue;
            } 
            stringBuilder.append("unknown");
            continue;
          } 
          stringBuilder.append("clear-focus");
          continue;
        } 
        stringBuilder.append("focus");
      } 
      if (stringBuilder.length() > 0) {
        String str = stringBuilder.toString();
      } else {
        stringBuilder = null;
      } 
      return (String)stringBuilder;
    } finally {
      accessibilityNodeInfoCompat.recycle();
    } 
  }
  
  public static CharSequence getDescription(View paramView) {
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = createNodeInfoFromView(paramView);
    try {
      int i;
      CharSequence charSequence1 = accessibilityNodeInfoCompat.getContentDescription();
      CharSequence charSequence2 = accessibilityNodeInfoCompat.getText();
      boolean bool1 = TextUtils.isEmpty(charSequence2);
      byte b = 0;
      if (!bool1) {
        i = 1;
      } else {
        i = 0;
      } 
      bool1 = paramView instanceof android.widget.EditText;
      boolean bool2 = TextUtils.isEmpty(charSequence1);
      if (!bool2 && (!bool1 || !i))
        return charSequence1; 
      if (i)
        return charSequence2; 
      bool1 = paramView instanceof ViewGroup;
      charSequence1 = null;
      if (bool1) {
        charSequence2 = new StringBuilder();
        ViewGroup viewGroup = (ViewGroup)paramView;
        int j = viewGroup.getChildCount();
        i = b;
        while (true) {
          if (i < j) {
            paramView = viewGroup.getChildAt(i);
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat1 = AccessibilityNodeInfoCompat.obtain();
            ViewCompat.onInitializeAccessibilityNodeInfo(paramView, accessibilityNodeInfoCompat1);
            if (AccessibilityUtil.isSpeakingNode(accessibilityNodeInfoCompat1, paramView) && !AccessibilityUtil.isAccessibilityFocusable(accessibilityNodeInfoCompat1, paramView)) {
              CharSequence charSequence3 = getDescription(paramView);
            } else {
              paramView = null;
            } 
            if (!TextUtils.isEmpty((CharSequence)paramView)) {
              if (charSequence2.length() > 0)
                charSequence2.append(", "); 
              charSequence2.append((CharSequence)paramView);
            } 
            accessibilityNodeInfoCompat1.recycle();
            i++;
            continue;
          } 
          CharSequence charSequence = charSequence1;
          if (charSequence2.length() > 0)
            charSequence = charSequence2.toString(); 
          return charSequence;
        } 
      } 
      return null;
    } finally {
      accessibilityNodeInfoCompat.recycle();
    } 
  }
  
  public static String getFocusableReasons(View paramView) {
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = createNodeInfoFromView(paramView);
    try {
      boolean bool1 = AccessibilityUtil.hasText(accessibilityNodeInfoCompat);
      boolean bool2 = accessibilityNodeInfoCompat.isCheckable();
      boolean bool3 = AccessibilityUtil.hasNonActionableSpeakingDescendants(accessibilityNodeInfoCompat, paramView);
      if (AccessibilityUtil.isActionableForAccessibility(accessibilityNodeInfoCompat)) {
        if (accessibilityNodeInfoCompat.getChildCount() <= 0)
          return "View is actionable and has no children."; 
        if (bool1)
          return "View is actionable and has a description."; 
        if (bool2)
          return "View is actionable and checkable."; 
        if (bool3)
          return "View is actionable and has non-actionable descendants with descriptions."; 
      } 
      if (AccessibilityUtil.isTopLevelScrollItem(accessibilityNodeInfoCompat, paramView)) {
        if (bool1)
          return "View is a direct child of a scrollable container and has a description."; 
        if (bool2)
          return "View is a direct child of a scrollable container and is checkable."; 
        if (bool3)
          return "View is a direct child of a scrollable container and has non-actionable descendants with descriptions."; 
      } 
      if (bool1)
        return "View has a description and is not actionable, but has no actionable ancestor."; 
      return null;
    } finally {
      accessibilityNodeInfoCompat.recycle();
    } 
  }
  
  public static boolean getIgnored(View paramView) {
    int i = ViewCompat.getImportantForAccessibility(paramView);
    if (i != 2) {
      if (i == 4)
        return true; 
      for (ViewParent viewParent = paramView.getParent(); viewParent instanceof View; viewParent = viewParent.getParent()) {
        if (ViewCompat.getImportantForAccessibility((View)viewParent) == 4)
          return true; 
      } 
      AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = createNodeInfoFromView(paramView);
      try {
        boolean bool = accessibilityNodeInfoCompat.isVisibleToUser();
        if (!bool)
          return true; 
        if (AccessibilityUtil.isAccessibilityFocusable(accessibilityNodeInfoCompat, paramView)) {
          i = accessibilityNodeInfoCompat.getChildCount();
          if (i <= 0)
            return false; 
          bool = AccessibilityUtil.isSpeakingNode(accessibilityNodeInfoCompat, paramView);
          if (bool)
            return false; 
          return true;
        } 
        if (!AccessibilityUtil.hasFocusableAncestor(accessibilityNodeInfoCompat, paramView)) {
          bool = AccessibilityUtil.hasText(accessibilityNodeInfoCompat);
          if (bool)
            return false; 
        } 
        return true;
      } finally {
        accessibilityNodeInfoCompat.recycle();
      } 
    } 
    return true;
  }
  
  public static String getIgnoredReasons(View paramView) {
    int i = ViewCompat.getImportantForAccessibility(paramView);
    if (i == 2)
      return "View has importantForAccessibility set to 'NO'."; 
    if (i == 4)
      return "View has importantForAccessibility set to 'NO_HIDE_DESCENDANTS'."; 
    for (ViewParent viewParent = paramView.getParent(); viewParent instanceof View; viewParent = viewParent.getParent()) {
      if (ViewCompat.getImportantForAccessibility((View)viewParent) == 4)
        return "An ancestor View has importantForAccessibility set to 'NO_HIDE_DESCENDANTS'."; 
    } 
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = createNodeInfoFromView(paramView);
    try {
      if (!accessibilityNodeInfoCompat.isVisibleToUser())
        return "View is not visible."; 
      if (AccessibilityUtil.isAccessibilityFocusable(accessibilityNodeInfoCompat, paramView))
        return "View is actionable, but has no description."; 
      if (AccessibilityUtil.hasText(accessibilityNodeInfoCompat))
        return "View is not actionable, and an ancestor View has co-opted its description."; 
      return "View is not actionable and has no description.";
    } finally {
      accessibilityNodeInfoCompat.recycle();
    } 
  }
  
  public static boolean getIsAccessibilityFocused(View paramView) {
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = createNodeInfoFromView(paramView);
    boolean bool = accessibilityNodeInfoCompat.isAccessibilityFocused();
    accessibilityNodeInfoCompat.recycle();
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\AccessibilityNodeInfoWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */