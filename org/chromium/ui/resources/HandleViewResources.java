package org.chromium.ui.resources;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;

public class HandleViewResources {
  private static final int[] CENTER_HANDLE_ATTRS;
  
  private static final int[] LEFT_HANDLE_ATTRS;
  
  private static final int[] RIGHT_HANDLE_ATTRS;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @CalledByNative
  private static Bitmap getCenterHandleBitmap(Context paramContext) {
    return getHandleBitmap(paramContext, CENTER_HANDLE_ATTRS);
  }
  
  public static Drawable getCenterHandleDrawable(Context paramContext) {
    return getHandleDrawable(paramContext, CENTER_HANDLE_ATTRS);
  }
  
  private static Bitmap getHandleBitmap(Context paramContext, int[] paramArrayOfint) {
    Context context = paramContext;
    if (paramContext == null)
      context = ContextUtils.sApplicationContext; 
    TypedArray typedArray = context.getTheme().obtainStyledAttributes(paramArrayOfint);
    int i = typedArray.getResourceId(typedArray.getIndex(0), 0);
    Resources resources = typedArray.getResources();
    typedArray.recycle();
    Bitmap.Config config = Bitmap.Config.ARGB_8888;
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = false;
    options.inPreferredConfig = config;
    Bitmap bitmap = BitmapFactory.decodeResource(resources, i, options);
    if (bitmap != null)
      return bitmap; 
    if (resources != context.getResources()) {
      Bitmap bitmap1 = BitmapFactory.decodeResource(context.getResources(), i, options);
      if (bitmap1 != null)
        return bitmap1; 
    } 
    Drawable drawable = getHandleDrawable(context, paramArrayOfint);
    assert false;
    throw new AssertionError();
  }
  
  private static Drawable getHandleDrawable(Context paramContext, int[] paramArrayOfint) {
    TypedArray typedArray = paramContext.getTheme().obtainStyledAttributes(paramArrayOfint);
    Drawable drawable2 = typedArray.getDrawable(0);
    if (drawable2 == null) {
      Drawable drawable;
      try {
        drawable = ApiCompatibilityUtils.getDrawable(paramContext.getResources(), typedArray.getResourceId(0, 0));
      } catch (android.content.res.Resources.NotFoundException notFoundException) {
        drawable = drawable2;
      } 
      typedArray.recycle();
      return drawable;
    } 
    Drawable drawable1 = drawable2;
  }
  
  @CalledByNative
  public static float getHandleHorizontalPaddingRatio() {
    return 0.25F;
  }
  
  @CalledByNative
  private static Bitmap getLeftHandleBitmap(Context paramContext) {
    return getHandleBitmap(paramContext, LEFT_HANDLE_ATTRS);
  }
  
  public static Drawable getLeftHandleDrawable(Context paramContext) {
    return getHandleDrawable(paramContext, LEFT_HANDLE_ATTRS);
  }
  
  @CalledByNative
  private static Bitmap getRightHandleBitmap(Context paramContext) {
    return getHandleBitmap(paramContext, RIGHT_HANDLE_ATTRS);
  }
  
  public static Drawable getRightHandleDrawable(Context paramContext) {
    return getHandleDrawable(paramContext, RIGHT_HANDLE_ATTRS);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\resources\HandleViewResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */