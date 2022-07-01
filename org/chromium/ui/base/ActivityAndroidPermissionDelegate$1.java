package org.chromium.ui.base;

final class ActivityAndroidPermissionDelegate$1 implements Runnable {
  public final void run() {
    int[] arrayOfInt = new int[permissions.length];
    for (int i = 0; i < permissions.length; i++) {
      byte b;
      if (ActivityAndroidPermissionDelegate.this.hasPermission(permissions[i])) {
        b = 0;
      } else {
        b = -1;
      } 
      arrayOfInt[i] = b;
    } 
    callback.onRequestPermissionsResult$6ce59818(arrayOfInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\base\ActivityAndroidPermissionDelegate$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */