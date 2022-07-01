package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat {
  public static final int HOST_VIEW_ID = -1;
  
  private final Object a;
  
  public AccessibilityNodeProviderCompat() {
    if (Build.VERSION.SDK_INT >= 19) {
      this.a = new AccessibilityNodeProviderApi19(this);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16) {
      this.a = new AccessibilityNodeProviderApi16(this);
      return;
    } 
    this.a = null;
  }
  
  public AccessibilityNodeProviderCompat(Object paramObject) {
    this.a = paramObject;
  }
  
  public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int paramInt) {
    return null;
  }
  
  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String paramString, int paramInt) {
    return null;
  }
  
  public AccessibilityNodeInfoCompat findFocus(int paramInt) {
    return null;
  }
  
  public Object getProvider() {
    return this.a;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle) {
    return false;
  }
  
  static class AccessibilityNodeProviderApi16 extends AccessibilityNodeProvider {
    final AccessibilityNodeProviderCompat a;
    
    AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat param1AccessibilityNodeProviderCompat) {
      this.a = param1AccessibilityNodeProviderCompat;
    }
    
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int param1Int) {
      AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = this.a.createAccessibilityNodeInfo(param1Int);
      return (accessibilityNodeInfoCompat == null) ? null : accessibilityNodeInfoCompat.unwrap();
    }
    
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String param1String, int param1Int) {
      List<AccessibilityNodeInfoCompat> list = this.a.findAccessibilityNodeInfosByText(param1String, param1Int);
      if (list == null)
        return null; 
      ArrayList<AccessibilityNodeInfo> arrayList = new ArrayList();
      int i = list.size();
      for (param1Int = 0; param1Int < i; param1Int++)
        arrayList.add(((AccessibilityNodeInfoCompat)list.get(param1Int)).unwrap()); 
      return arrayList;
    }
    
    public boolean performAction(int param1Int1, int param1Int2, Bundle param1Bundle) {
      return this.a.performAction(param1Int1, param1Int2, param1Bundle);
    }
  }
  
  static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProviderApi16 {
    AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat param1AccessibilityNodeProviderCompat) {
      super(param1AccessibilityNodeProviderCompat);
    }
    
    public AccessibilityNodeInfo findFocus(int param1Int) {
      AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = this.a.findFocus(param1Int);
      return (accessibilityNodeInfoCompat == null) ? null : accessibilityNodeInfoCompat.unwrap();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\accessibility\AccessibilityNodeProviderCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */