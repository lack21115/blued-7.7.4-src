package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

final class DrawableWrapperApi14$DrawableWrapperStateBase extends DrawableWrapperApi14$DrawableWrapperState {
  DrawableWrapperApi14$DrawableWrapperStateBase(DrawableWrapperApi14$DrawableWrapperState paramDrawableWrapperApi14$DrawableWrapperState) {
    super(paramDrawableWrapperApi14$DrawableWrapperState);
  }
  
  public final Drawable newDrawable(Resources paramResources) {
    return new DrawableWrapperApi14(this, paramResources);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\graphics\drawable\DrawableWrapperApi14$DrawableWrapperStateBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */