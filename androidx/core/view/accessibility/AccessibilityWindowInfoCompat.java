package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityWindowInfo;

public class AccessibilityWindowInfoCompat {
  public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
  
  public static final int TYPE_APPLICATION = 1;
  
  public static final int TYPE_INPUT_METHOD = 2;
  
  public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
  
  public static final int TYPE_SYSTEM = 3;
  
  private Object a;
  
  private AccessibilityWindowInfoCompat(Object paramObject) {
    this.a = paramObject;
  }
  
  static AccessibilityWindowInfoCompat a(Object paramObject) {
    return (paramObject != null) ? new AccessibilityWindowInfoCompat(paramObject) : null;
  }
  
  private static String a(int paramInt) {
    return (paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? ((paramInt != 4) ? "<UNKNOWN>" : "TYPE_ACCESSIBILITY_OVERLAY") : "TYPE_SYSTEM") : "TYPE_INPUT_METHOD") : "TYPE_APPLICATION";
  }
  
  public static AccessibilityWindowInfoCompat obtain() {
    return (Build.VERSION.SDK_INT >= 21) ? a(AccessibilityWindowInfo.obtain()) : null;
  }
  
  public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat paramAccessibilityWindowInfoCompat) {
    int i = Build.VERSION.SDK_INT;
    AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = null;
    if (i >= 21) {
      if (paramAccessibilityWindowInfoCompat == null)
        return null; 
      accessibilityWindowInfoCompat = a(AccessibilityWindowInfo.obtain((AccessibilityWindowInfo)paramAccessibilityWindowInfoCompat.a));
    } 
    return accessibilityWindowInfoCompat;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof AccessibilityWindowInfoCompat))
      return false; 
    paramObject = paramObject;
    Object object = this.a;
    if (object == null) {
      if (((AccessibilityWindowInfoCompat)paramObject).a != null)
        return false; 
    } else if (!object.equals(((AccessibilityWindowInfoCompat)paramObject).a)) {
      return false;
    } 
    return true;
  }
  
  public AccessibilityNodeInfoCompat getAnchor() {
    return (Build.VERSION.SDK_INT >= 24) ? AccessibilityNodeInfoCompat.a(((AccessibilityWindowInfo)this.a).getAnchor()) : null;
  }
  
  public void getBoundsInScreen(Rect paramRect) {
    if (Build.VERSION.SDK_INT >= 21)
      ((AccessibilityWindowInfo)this.a).getBoundsInScreen(paramRect); 
  }
  
  public AccessibilityWindowInfoCompat getChild(int paramInt) {
    return (Build.VERSION.SDK_INT >= 21) ? a(((AccessibilityWindowInfo)this.a).getChild(paramInt)) : null;
  }
  
  public int getChildCount() {
    return (Build.VERSION.SDK_INT >= 21) ? ((AccessibilityWindowInfo)this.a).getChildCount() : 0;
  }
  
  public int getId() {
    return (Build.VERSION.SDK_INT >= 21) ? ((AccessibilityWindowInfo)this.a).getId() : -1;
  }
  
  public int getLayer() {
    return (Build.VERSION.SDK_INT >= 21) ? ((AccessibilityWindowInfo)this.a).getLayer() : -1;
  }
  
  public AccessibilityWindowInfoCompat getParent() {
    return (Build.VERSION.SDK_INT >= 21) ? a(((AccessibilityWindowInfo)this.a).getParent()) : null;
  }
  
  public AccessibilityNodeInfoCompat getRoot() {
    return (Build.VERSION.SDK_INT >= 21) ? AccessibilityNodeInfoCompat.a(((AccessibilityWindowInfo)this.a).getRoot()) : null;
  }
  
  public CharSequence getTitle() {
    return (Build.VERSION.SDK_INT >= 24) ? ((AccessibilityWindowInfo)this.a).getTitle() : null;
  }
  
  public int getType() {
    return (Build.VERSION.SDK_INT >= 21) ? ((AccessibilityWindowInfo)this.a).getType() : -1;
  }
  
  public int hashCode() {
    Object object = this.a;
    return (object == null) ? 0 : object.hashCode();
  }
  
  public boolean isAccessibilityFocused() {
    return (Build.VERSION.SDK_INT >= 21) ? ((AccessibilityWindowInfo)this.a).isAccessibilityFocused() : true;
  }
  
  public boolean isActive() {
    return (Build.VERSION.SDK_INT >= 21) ? ((AccessibilityWindowInfo)this.a).isActive() : true;
  }
  
  public boolean isFocused() {
    return (Build.VERSION.SDK_INT >= 21) ? ((AccessibilityWindowInfo)this.a).isFocused() : true;
  }
  
  public void recycle() {
    if (Build.VERSION.SDK_INT >= 21)
      ((AccessibilityWindowInfo)this.a).recycle(); 
  }
  
  public String toString() {
    boolean bool1;
    StringBuilder stringBuilder = new StringBuilder();
    Rect rect = new Rect();
    getBoundsInScreen(rect);
    stringBuilder.append("AccessibilityWindowInfo[");
    stringBuilder.append("id=");
    stringBuilder.append(getId());
    stringBuilder.append(", type=");
    stringBuilder.append(a(getType()));
    stringBuilder.append(", layer=");
    stringBuilder.append(getLayer());
    stringBuilder.append(", bounds=");
    stringBuilder.append(rect);
    stringBuilder.append(", focused=");
    stringBuilder.append(isFocused());
    stringBuilder.append(", active=");
    stringBuilder.append(isActive());
    stringBuilder.append(", hasParent=");
    AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = getParent();
    boolean bool2 = true;
    if (accessibilityWindowInfoCompat != null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    stringBuilder.append(bool1);
    stringBuilder.append(", hasChildren=");
    if (getChildCount() > 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    stringBuilder.append(bool1);
    stringBuilder.append(']');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\accessibility\AccessibilityWindowInfoCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */