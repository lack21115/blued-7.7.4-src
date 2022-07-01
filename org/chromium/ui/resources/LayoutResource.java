package org.chromium.ui.resources;

import android.graphics.Rect;
import android.graphics.RectF;
import org.chromium.ui.resources.statics.NinePatchData;

public final class LayoutResource {
  public LayoutResource(float paramFloat, Resource paramResource) {
    Rect rect2 = new Rect();
    Rect rect3 = new Rect();
    NinePatchData ninePatchData = paramResource.getNinePatchData();
    if (ninePatchData != null) {
      rect2 = ninePatchData.mPadding;
      rect3 = ninePatchData.mAperture;
    } 
    Rect rect1 = paramResource.getBitmapSize();
    new RectF(rect2.left * paramFloat, rect2.top * paramFloat, rect2.right * paramFloat, rect2.bottom * paramFloat);
    new RectF(rect1.left * paramFloat, rect1.top * paramFloat, rect1.right * paramFloat, rect1.bottom * paramFloat);
    new RectF(rect3.left * paramFloat, rect3.top * paramFloat, rect3.right * paramFloat, rect3.bottom * paramFloat);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\resources\LayoutResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */