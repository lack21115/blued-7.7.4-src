package org.chromium.ui.resources;

import android.graphics.Rect;
import org.chromium.ui.resources.statics.NinePatchData;

public class ResourceFactory {
  public static long createBitmapResource(NinePatchData paramNinePatchData) {
    if (paramNinePatchData == null)
      return nativeCreateBitmapResource(); 
    Rect rect2 = paramNinePatchData.mPadding;
    Rect rect1 = paramNinePatchData.mAperture;
    return nativeCreateNinePatchBitmapResource(rect2.left, rect2.top, rect2.right, rect2.bottom, rect1.left, rect1.top, rect1.right, rect1.bottom);
  }
  
  private static native long nativeCreateBitmapResource();
  
  private static native long nativeCreateNinePatchBitmapResource(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\resources\ResourceFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */