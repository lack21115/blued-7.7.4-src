package org.chromium.ui;

import org.chromium.base.annotations.CalledByNative;

public interface OverscrollRefreshHandler {
  @CalledByNative
  void pull(float paramFloat);
  
  @CalledByNative
  void release(boolean paramBoolean);
  
  @CalledByNative
  void reset();
  
  @CalledByNative
  boolean start();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\OverscrollRefreshHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */