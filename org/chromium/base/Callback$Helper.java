package org.chromium.base;

import org.chromium.base.annotations.CalledByNative;

public abstract class Callback$Helper {
  @CalledByNative
  static void onBooleanResultFromNative(Callback paramCallback, boolean paramBoolean) {
    paramCallback.onResult(Boolean.valueOf(paramBoolean));
  }
  
  @CalledByNative
  static void onIntResultFromNative(Callback paramCallback, int paramInt) {
    paramCallback.onResult(Integer.valueOf(paramInt));
  }
  
  @CalledByNative
  static void onObjectResultFromNative(Callback paramCallback, Object paramObject) {
    paramCallback.onResult(paramObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\Callback$Helper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */