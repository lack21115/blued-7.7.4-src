package android.support.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

final class VectorDrawableCompat$VectorDrawableCompatState extends Drawable.ConstantState {
  boolean mAutoMirrored;
  
  boolean mCacheDirty;
  
  boolean mCachedAutoMirrored;
  
  Bitmap mCachedBitmap;
  
  int mCachedRootAlpha;
  
  ColorStateList mCachedTint;
  
  PorterDuff.Mode mCachedTintMode;
  
  int mChangingConfigurations;
  
  Paint mTempPaint;
  
  ColorStateList mTint = null;
  
  PorterDuff.Mode mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
  
  VectorDrawableCompat$VPathRenderer mVPathRenderer;
  
  public VectorDrawableCompat$VectorDrawableCompatState() {
    this.mVPathRenderer = new VectorDrawableCompat$VPathRenderer();
  }
  
  public VectorDrawableCompat$VectorDrawableCompatState(VectorDrawableCompat$VectorDrawableCompatState paramVectorDrawableCompat$VectorDrawableCompatState) {
    if (paramVectorDrawableCompat$VectorDrawableCompatState != null) {
      this.mChangingConfigurations = paramVectorDrawableCompat$VectorDrawableCompatState.mChangingConfigurations;
      this.mVPathRenderer = new VectorDrawableCompat$VPathRenderer(paramVectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer);
      if (VectorDrawableCompat$VPathRenderer.access$000(paramVectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer) != null)
        VectorDrawableCompat$VPathRenderer.access$002(this.mVPathRenderer, new Paint(VectorDrawableCompat$VPathRenderer.access$000(paramVectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer))); 
      if (VectorDrawableCompat$VPathRenderer.access$100(paramVectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer) != null)
        VectorDrawableCompat$VPathRenderer.access$102(this.mVPathRenderer, new Paint(VectorDrawableCompat$VPathRenderer.access$100(paramVectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer))); 
      this.mTint = paramVectorDrawableCompat$VectorDrawableCompatState.mTint;
      this.mTintMode = paramVectorDrawableCompat$VectorDrawableCompatState.mTintMode;
      this.mAutoMirrored = paramVectorDrawableCompat$VectorDrawableCompatState.mAutoMirrored;
    } 
  }
  
  public final int getChangingConfigurations() {
    return this.mChangingConfigurations;
  }
  
  public final Drawable newDrawable() {
    return new VectorDrawableCompat(this);
  }
  
  public final Drawable newDrawable(Resources paramResources) {
    return new VectorDrawableCompat(this);
  }
  
  public final void updateCachedBitmap(int paramInt1, int paramInt2) {
    this.mCachedBitmap.eraseColor(0);
    Canvas canvas = new Canvas(this.mCachedBitmap);
    this.mVPathRenderer.draw(canvas, paramInt1, paramInt2, null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\graphics\drawable\VectorDrawableCompat$VectorDrawableCompatState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */