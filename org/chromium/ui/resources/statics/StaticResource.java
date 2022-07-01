package org.chromium.ui.resources.statics;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.ui.resources.Resource;
import org.chromium.ui.resources.ResourceFactory;

public final class StaticResource implements Resource {
  private final Bitmap mBitmap;
  
  private final Rect mBitmapSize;
  
  private final NinePatchData mNinePatchData;
  
  public StaticResource(Bitmap paramBitmap) {
    this.mBitmap = paramBitmap;
    this.mNinePatchData = NinePatchData.create(this.mBitmap);
    this.mBitmapSize = new Rect(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
  }
  
  public static StaticResource create(Resources paramResources, int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 <= 0)
      return null; 
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    if (paramInt2 != 0 && paramInt3 != 0) {
      options.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(paramResources, paramInt1, options);
      options.inJustDecodeBounds = false;
      if (options.outHeight > paramInt3 || options.outWidth > paramInt2)
        options.inSampleSize = Math.min(Math.round(options.outHeight / paramInt3), Math.round(options.outWidth / paramInt2)); 
    } 
    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    Bitmap bitmap1 = BitmapFactory.decodeResource(paramResources, paramInt1, options);
    if (bitmap1 == null) {
      bitmap1 = null;
    } else if (bitmap1.getConfig() != options.inPreferredConfig) {
      Bitmap bitmap = Bitmap.createBitmap(bitmap1.getWidth(), bitmap1.getHeight(), options.inPreferredConfig);
      (new Canvas(bitmap)).drawBitmap(bitmap1, 0.0F, 0.0F, null);
      bitmap1.recycle();
      bitmap1 = bitmap;
    } 
    Bitmap bitmap2 = bitmap1;
    if (bitmap1 == null)
      bitmap2 = decodeDrawable(paramResources, paramInt1, paramInt2, paramInt3); 
    return (bitmap2 == null) ? null : new StaticResource(bitmap2);
  }
  
  private static Bitmap decodeDrawable(Resources paramResources, int paramInt1, int paramInt2, int paramInt3) {
    try {
      Drawable drawable = ApiCompatibilityUtils.getDrawable(paramResources, paramInt1);
      paramInt1 = Math.max(drawable.getMinimumWidth(), Math.max(paramInt2, 1));
      paramInt2 = Math.max(drawable.getMinimumHeight(), Math.max(paramInt3, 1));
      Bitmap bitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Canvas canvas = new Canvas(bitmap);
      drawable.setBounds(0, 0, paramInt1, paramInt2);
      drawable.draw(canvas);
      return bitmap;
    } catch (android.content.res.Resources.NotFoundException notFoundException) {
      return null;
    } 
  }
  
  public final long createNativeResource() {
    return ResourceFactory.createBitmapResource(this.mNinePatchData);
  }
  
  public final Bitmap getBitmap() {
    return this.mBitmap;
  }
  
  public final Rect getBitmapSize() {
    return this.mBitmapSize;
  }
  
  public final NinePatchData getNinePatchData() {
    return this.mNinePatchData;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\resources\statics\StaticResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */