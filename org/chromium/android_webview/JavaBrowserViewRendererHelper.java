package org.chromium.android_webview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import org.chromium.base.annotations.CalledByNative;

public class JavaBrowserViewRendererHelper {
  @CalledByNative
  private static Bitmap createBitmap(int paramInt1, int paramInt2, Canvas paramCanvas) {
    int j = paramInt1;
    int i = paramInt2;
    if (paramCanvas != null) {
      j = Math.min(paramInt1, paramCanvas.getMaximumBitmapWidth());
      i = Math.min(paramInt2, paramCanvas.getMaximumBitmapHeight());
    } 
    try {
      return Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
    } catch (OutOfMemoryError outOfMemoryError) {
      Log.e("JavaBrowserViewRendererHelper", "Error allocating bitmap");
      return null;
    } 
  }
  
  @CalledByNative
  private static void drawBitmapIntoCanvas(Bitmap paramBitmap, Canvas paramCanvas, int paramInt1, int paramInt2) {
    paramCanvas.translate(paramInt1, paramInt2);
    paramCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\JavaBrowserViewRendererHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */