package org.chromium.device.bluetooth;

final class Wrappers$ThreadUtilsWrapper {
  private static Wrappers$ThreadUtilsWrapper$Factory sFactory;
  
  private static Wrappers$ThreadUtilsWrapper sInstance;
  
  public static Wrappers$ThreadUtilsWrapper getInstance() {
    if (sInstance == null)
      if (sFactory == null) {
        sInstance = new Wrappers$ThreadUtilsWrapper();
      } else {
        sInstance = sFactory.create();
      }  
    return sInstance;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\Wrappers$ThreadUtilsWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */