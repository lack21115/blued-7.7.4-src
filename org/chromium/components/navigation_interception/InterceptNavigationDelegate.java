package org.chromium.components.navigation_interception;

import org.chromium.base.annotations.CalledByNative;

public interface InterceptNavigationDelegate {
  @CalledByNative
  boolean shouldIgnoreNavigation(NavigationParams paramNavigationParams);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\navigation_interception\InterceptNavigationDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */