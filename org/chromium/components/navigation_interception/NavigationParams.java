package org.chromium.components.navigation_interception;

import android.text.TextUtils;
import org.chromium.base.annotations.CalledByNative;

public class NavigationParams {
  public final String url;
  
  private NavigationParams(String paramString1, String paramString2) {
    this.url = paramString1;
    TextUtils.isEmpty(paramString2);
  }
  
  @CalledByNative
  public static NavigationParams create(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
    return new NavigationParams(paramString1, paramString2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\navigation_interception\NavigationParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */