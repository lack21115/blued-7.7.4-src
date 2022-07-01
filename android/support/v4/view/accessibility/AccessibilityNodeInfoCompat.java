package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

public final class AccessibilityNodeInfoCompat {
  public final AccessibilityNodeInfo mInfo;
  
  private AccessibilityNodeInfoCompat(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    this.mInfo = paramAccessibilityNodeInfo;
  }
  
  public static AccessibilityNodeInfoCompat wrap(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    return new AccessibilityNodeInfoCompat(paramAccessibilityNodeInfo);
  }
  
  public final void addAction(int paramInt) {
    this.mInfo.addAction(paramInt);
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    if (this.mInfo == null) {
      if (((AccessibilityNodeInfoCompat)paramObject).mInfo != null)
        return false; 
    } else if (!this.mInfo.equals(((AccessibilityNodeInfoCompat)paramObject).mInfo)) {
      return false;
    } 
    return true;
  }
  
  public final int hashCode() {
    return (this.mInfo == null) ? 0 : this.mInfo.hashCode();
  }
  
  public final String toString() {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(super.toString());
    Rect rect = new Rect();
    this.mInfo.getBoundsInParent(rect);
    StringBuilder stringBuilder3 = new StringBuilder("; boundsInParent: ");
    stringBuilder3.append(rect);
    stringBuilder2.append(stringBuilder3.toString());
    this.mInfo.getBoundsInScreen(rect);
    stringBuilder3 = new StringBuilder("; boundsInScreen: ");
    stringBuilder3.append(rect);
    stringBuilder2.append(stringBuilder3.toString());
    stringBuilder2.append("; packageName: ");
    stringBuilder2.append(this.mInfo.getPackageName());
    stringBuilder2.append("; className: ");
    stringBuilder2.append(this.mInfo.getClassName());
    stringBuilder2.append("; text: ");
    stringBuilder2.append(this.mInfo.getText());
    stringBuilder2.append("; contentDescription: ");
    stringBuilder2.append(this.mInfo.getContentDescription());
    stringBuilder2.append("; viewId: ");
    if (Build.VERSION.SDK_INT >= 18) {
      String str = this.mInfo.getViewIdResourceName();
    } else {
      rect = null;
    } 
    stringBuilder2.append((String)rect);
    stringBuilder2.append("; checkable: ");
    stringBuilder2.append(this.mInfo.isCheckable());
    stringBuilder2.append("; checked: ");
    stringBuilder2.append(this.mInfo.isChecked());
    stringBuilder2.append("; focusable: ");
    stringBuilder2.append(this.mInfo.isFocusable());
    stringBuilder2.append("; focused: ");
    stringBuilder2.append(this.mInfo.isFocused());
    stringBuilder2.append("; selected: ");
    stringBuilder2.append(this.mInfo.isSelected());
    stringBuilder2.append("; clickable: ");
    stringBuilder2.append(this.mInfo.isClickable());
    stringBuilder2.append("; longClickable: ");
    stringBuilder2.append(this.mInfo.isLongClickable());
    stringBuilder2.append("; enabled: ");
    stringBuilder2.append(this.mInfo.isEnabled());
    stringBuilder2.append("; password: ");
    stringBuilder2.append(this.mInfo.isPassword());
    StringBuilder stringBuilder1 = new StringBuilder("; scrollable: ");
    stringBuilder1.append(this.mInfo.isScrollable());
    stringBuilder2.append(stringBuilder1.toString());
    stringBuilder2.append("; [");
    int i = this.mInfo.getActions();
    while (i != 0) {
      String str;
      int j = 1 << Integer.numberOfTrailingZeros(i);
      i &= j ^ 0xFFFFFFFF;
      switch (j) {
        default:
          str = "ACTION_UNKNOWN";
          break;
        case 131072:
          str = "ACTION_SET_SELECTION";
          break;
        case 65536:
          str = "ACTION_CUT";
          break;
        case 32768:
          str = "ACTION_PASTE";
          break;
        case 16384:
          str = "ACTION_COPY";
          break;
        case 8192:
          str = "ACTION_SCROLL_BACKWARD";
          break;
        case 4096:
          str = "ACTION_SCROLL_FORWARD";
          break;
        case 2048:
          str = "ACTION_PREVIOUS_HTML_ELEMENT";
          break;
        case 1024:
          str = "ACTION_NEXT_HTML_ELEMENT";
          break;
        case 512:
          str = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
          break;
        case 256:
          str = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
          break;
        case 128:
          str = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
          break;
        case 64:
          str = "ACTION_ACCESSIBILITY_FOCUS";
          break;
        case 32:
          str = "ACTION_LONG_CLICK";
          break;
        case 16:
          str = "ACTION_CLICK";
          break;
        case 8:
          str = "ACTION_CLEAR_SELECTION";
          break;
        case 4:
          str = "ACTION_SELECT";
          break;
        case 2:
          str = "ACTION_CLEAR_FOCUS";
          break;
        case 1:
          str = "ACTION_FOCUS";
          break;
      } 
      stringBuilder2.append(str);
      if (i != 0)
        stringBuilder2.append(", "); 
    } 
    stringBuilder2.append("]");
    return stringBuilder2.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\accessibility\AccessibilityNodeInfoCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */