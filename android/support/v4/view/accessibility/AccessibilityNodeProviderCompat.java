package android.support.v4.view.accessibility;

import android.os.Build;

public final class AccessibilityNodeProviderCompat {
  public final Object mProvider;
  
  public AccessibilityNodeProviderCompat() {
    if (Build.VERSION.SDK_INT >= 19) {
      this.mProvider = new AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19(this);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16) {
      this.mProvider = new AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi16();
      return;
    } 
    this.mProvider = null;
  }
  
  public AccessibilityNodeProviderCompat(Object paramObject) {
    this.mProvider = paramObject;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\accessibility\AccessibilityNodeProviderCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */