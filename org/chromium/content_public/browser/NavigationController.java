package org.chromium.content_public.browser;

public interface NavigationController {
  boolean canGoBack();
  
  boolean canGoForward();
  
  boolean canGoToOffset(int paramInt);
  
  void cancelPendingReload();
  
  void clearHistory();
  
  void clearSslPreferences();
  
  void continuePendingReload();
  
  NavigationHistory getNavigationHistory();
  
  void goBack();
  
  void goForward();
  
  void goToOffset(int paramInt);
  
  void loadUrl(LoadUrlParams paramLoadUrlParams);
  
  void reload(boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\NavigationController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */