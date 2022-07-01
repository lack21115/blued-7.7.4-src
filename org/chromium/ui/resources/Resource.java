package org.chromium.ui.resources;

import android.graphics.Bitmap;
import android.graphics.Rect;
import org.chromium.ui.resources.statics.NinePatchData;

public interface Resource {
  long createNativeResource();
  
  Bitmap getBitmap();
  
  Rect getBitmapSize();
  
  NinePatchData getNinePatchData();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\resources\Resource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */