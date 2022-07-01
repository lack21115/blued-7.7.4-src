package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class DrawableWrapperApi19 extends DrawableWrapperApi14 {
  DrawableWrapperApi19(Drawable paramDrawable) {
    super(paramDrawable);
  }
  
  DrawableWrapperApi19(DrawableWrapperApi14$DrawableWrapperState paramDrawableWrapperApi14$DrawableWrapperState, Resources paramResources) {
    super(paramDrawableWrapperApi14$DrawableWrapperState, paramResources);
  }
  
  public boolean isAutoMirrored() {
    return this.mDrawable.isAutoMirrored();
  }
  
  DrawableWrapperApi14$DrawableWrapperState mutateConstantState() {
    return new DrawableWrapperApi19$DrawableWrapperStateKitKat(this.mState);
  }
  
  public void setAutoMirrored(boolean paramBoolean) {
    this.mDrawable.setAutoMirrored(paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\graphics\drawable\DrawableWrapperApi19.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */