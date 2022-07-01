package org.chromium.ui.gfx;

import android.graphics.Bitmap;
import org.chromium.base.annotations.CalledByNative;

public class BitmapHelper {
  @CalledByNative
  private static Bitmap createBitmap(int paramInt1, int paramInt2, int paramInt3) {
    Bitmap.Config config;
    if (paramInt3 != 4) {
      switch (paramInt3) {
        default:
          config = Bitmap.Config.ARGB_8888;
          return Bitmap.createBitmap(paramInt1, paramInt2, config);
        case 2:
          config = Bitmap.Config.ARGB_4444;
          return Bitmap.createBitmap(paramInt1, paramInt2, config);
        case 1:
          break;
      } 
      config = Bitmap.Config.ALPHA_8;
    } else {
      config = Bitmap.Config.RGB_565;
    } 
    return Bitmap.createBitmap(paramInt1, paramInt2, config);
  }
  
  @CalledByNative
  private static int getBitmapFormatForConfig(Bitmap.Config paramConfig) {
    switch (BitmapHelper$1.$SwitchMap$android$graphics$Bitmap$Config[paramConfig.ordinal()]) {
      default:
        return 0;
      case 4:
        return 4;
      case 3:
        return 3;
      case 2:
        return 2;
      case 1:
        break;
    } 
    return 1;
  }
  
  @CalledByNative
  private static int getByteCount(Bitmap paramBitmap) {
    return paramBitmap.getByteCount();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\gfx\BitmapHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */