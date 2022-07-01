package org.chromium.ui.base;

public interface AndroidPermissionDelegate {
  boolean canRequestPermission(String paramString);
  
  boolean hasPermission(String paramString);
  
  void requestPermissions(String[] paramArrayOfString, PermissionCallback paramPermissionCallback);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\base\AndroidPermissionDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */