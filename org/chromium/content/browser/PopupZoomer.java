package org.chromium.content.browser;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.Log;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.content.R;

public final class PopupZoomer extends View {
  private static float sOverlayCornerRadius;
  
  private static Drawable sOverlayDrawable;
  
  private static Rect sOverlayPadding;
  
  private boolean mAnimating;
  
  private long mAnimationStartTime;
  
  private float mBottomExtrusion;
  
  private RectF mClipRect;
  
  private RectF mDrawRect;
  
  private final GestureDetector mGestureDetector;
  
  private final Interpolator mHideInterpolator = new PopupZoomer$ReverseInterpolator(this.mShowInterpolator);
  
  private float mLeftExtrusion;
  
  private float mMaxScrollX;
  
  private float mMaxScrollY;
  
  private float mMinScrollX;
  
  private float mMinScrollY;
  
  private boolean mNeedsToInitDimensions;
  
  private final PopupZoomer$OnTapListener mOnTapListener;
  
  private final PopupZoomer$OnVisibilityChangedListener mOnVisibilityChangedListener;
  
  private float mPopupScrollX;
  
  private float mPopupScrollY;
  
  private float mRightExtrusion;
  
  private float mScale = 1.0F;
  
  private float mShiftX;
  
  private float mShiftY;
  
  private final Interpolator mShowInterpolator = (Interpolator)new OvershootInterpolator();
  
  boolean mShowing;
  
  Rect mTargetBounds;
  
  private long mTimeLeft;
  
  private float mTopExtrusion;
  
  final PointF mTouch = new PointF();
  
  private RectF mViewClipRect;
  
  Bitmap mZoomedBitmap;
  
  public PopupZoomer(Context paramContext, PopupZoomer$OnVisibilityChangedListener paramPopupZoomer$OnVisibilityChangedListener, PopupZoomer$OnTapListener paramPopupZoomer$OnTapListener) {
    super(paramContext);
    this.mOnVisibilityChangedListener = paramPopupZoomer$OnVisibilityChangedListener;
    this.mOnTapListener = paramPopupZoomer$OnTapListener;
    setVisibility(4);
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.mGestureDetector = new GestureDetector(paramContext, (GestureDetector.OnGestureListener)new PopupZoomer$1(this));
  }
  
  private static float constrain(float paramFloat1, float paramFloat2, float paramFloat3) {
    return (paramFloat1 < paramFloat2) ? paramFloat2 : ((paramFloat1 > paramFloat3) ? paramFloat3 : paramFloat1);
  }
  
  static float getOverlayCornerRadius(Context paramContext) {
    if (sOverlayCornerRadius == 0.0F)
      try {
        sOverlayCornerRadius = paramContext.getResources().getDimension(R.dimen.link_preview_overlay_radius);
      } catch (android.content.res.Resources.NotFoundException notFoundException) {
        Log.w("cr.PopupZoomer", "No corner radius resource for PopupZoomer overlay found.", new Object[0]);
        sOverlayCornerRadius = 1.0F;
      }  
    return sOverlayCornerRadius;
  }
  
  private static Drawable getOverlayDrawable(Context paramContext) {
    if (sOverlayDrawable == null) {
      try {
        sOverlayDrawable = ApiCompatibilityUtils.getDrawable(paramContext.getResources(), R.drawable.ondemand_overlay);
      } catch (android.content.res.Resources.NotFoundException notFoundException) {
        Log.w("cr.PopupZoomer", "No drawable resource for PopupZoomer overlay found.", new Object[0]);
        sOverlayDrawable = (Drawable)new ColorDrawable();
      } 
      sOverlayPadding = new Rect();
      sOverlayDrawable.getPadding(sOverlayPadding);
    } 
    return sOverlayDrawable;
  }
  
  static void recordHistogram(int paramInt) {
    RecordHistogram.recordEnumeratedHistogram("Touchscreen.TapDisambiguation", paramInt, 6);
  }
  
  final void hideImmediately() {
    this.mAnimating = false;
    this.mShowing = false;
    this.mTimeLeft = 0L;
    if (this.mOnVisibilityChangedListener != null)
      this.mOnVisibilityChangedListener.onPopupZoomerHidden(this); 
    setVisibility(4);
    this.mZoomedBitmap.recycle();
    this.mZoomedBitmap = null;
  }
  
  public final boolean isShowing() {
    return (this.mShowing || this.mAnimating);
  }
  
  protected final void onDraw(Canvas paramCanvas) {
    if (isShowing()) {
      if (this.mZoomedBitmap == null)
        return; 
      if (getWidth() != 0) {
        int i;
        if (getHeight() == 0)
          return; 
        if (this.mNeedsToInitDimensions) {
          this.mNeedsToInitDimensions = false;
          if (this.mTargetBounds != null && this.mTouch != null) {
            this.mScale = this.mZoomedBitmap.getWidth() / this.mTargetBounds.width();
            float f5 = this.mTouch.x - this.mScale * (this.mTouch.x - this.mTargetBounds.left);
            float f6 = this.mTouch.y - this.mScale * (this.mTouch.y - this.mTargetBounds.top);
            this.mClipRect = new RectF(f5, f6, this.mZoomedBitmap.getWidth() + f5, this.mZoomedBitmap.getHeight() + f6);
            i = getWidth();
            int k = getHeight();
            f5 = (i - 25);
            f6 = (k - 25);
            this.mViewClipRect = new RectF(25.0F, 25.0F, f5, f6);
            this.mShiftX = 0.0F;
            this.mShiftY = 0.0F;
            if (this.mClipRect.left < 25.0F) {
              this.mShiftX = 25.0F - this.mClipRect.left;
              RectF rectF = this.mClipRect;
              rectF.left += this.mShiftX;
              rectF = this.mClipRect;
              rectF.right += this.mShiftX;
            } else if (this.mClipRect.right > f5) {
              this.mShiftX = f5 - this.mClipRect.right;
              RectF rectF = this.mClipRect;
              rectF.right += this.mShiftX;
              rectF = this.mClipRect;
              rectF.left += this.mShiftX;
            } 
            if (this.mClipRect.top < 25.0F) {
              this.mShiftY = 25.0F - this.mClipRect.top;
              RectF rectF = this.mClipRect;
              rectF.top += this.mShiftY;
              rectF = this.mClipRect;
              rectF.bottom += this.mShiftY;
            } else if (this.mClipRect.bottom > f6) {
              this.mShiftY = f6 - this.mClipRect.bottom;
              RectF rectF = this.mClipRect;
              rectF.bottom += this.mShiftY;
              rectF = this.mClipRect;
              rectF.top += this.mShiftY;
            } 
            this.mMaxScrollY = 0.0F;
            this.mMinScrollY = 0.0F;
            this.mMaxScrollX = 0.0F;
            this.mMinScrollX = 0.0F;
            if (this.mViewClipRect.right + this.mShiftX < this.mClipRect.right)
              this.mMinScrollX = this.mViewClipRect.right - this.mClipRect.right; 
            if (this.mViewClipRect.left + this.mShiftX > this.mClipRect.left)
              this.mMaxScrollX = this.mViewClipRect.left - this.mClipRect.left; 
            if (this.mViewClipRect.top + this.mShiftY > this.mClipRect.top)
              this.mMaxScrollY = this.mViewClipRect.top - this.mClipRect.top; 
            if (this.mViewClipRect.bottom + this.mShiftY < this.mClipRect.bottom)
              this.mMinScrollY = this.mViewClipRect.bottom - this.mClipRect.bottom; 
            this.mClipRect.intersect(this.mViewClipRect);
            this.mLeftExtrusion = this.mTouch.x - this.mClipRect.left;
            this.mRightExtrusion = this.mClipRect.right - this.mTouch.x;
            this.mTopExtrusion = this.mTouch.y - this.mClipRect.top;
            this.mBottomExtrusion = this.mClipRect.bottom - this.mTouch.y;
            f5 = (this.mTouch.x - this.mTargetBounds.centerX()) / this.mTargetBounds.width() / 2.0F;
            f6 = (this.mTouch.y - this.mTargetBounds.centerY()) / this.mTargetBounds.height() / 2.0F;
            float f7 = this.mMaxScrollX;
            float f8 = this.mMinScrollX;
            float f9 = this.mMaxScrollY;
            float f10 = this.mMinScrollY;
            this.mPopupScrollX = -((f7 - f8) * (f5 + 0.5F));
            this.mPopupScrollY = -((f9 - f10) * (f6 + 0.5F));
            this.mPopupScrollX = constrain(this.mPopupScrollX, this.mMinScrollX, this.mMaxScrollX);
            this.mPopupScrollY = constrain(this.mPopupScrollY, this.mMinScrollY, this.mMaxScrollY);
            this.mDrawRect = new RectF();
          } 
        } 
        paramCanvas.save();
        float f1 = constrain((float)(SystemClock.uptimeMillis() - this.mAnimationStartTime + this.mTimeLeft) / 300.0F, 0.0F, 1.0F);
        if (f1 >= 1.0F) {
          this.mAnimating = false;
          if (!isShowing()) {
            hideImmediately();
            return;
          } 
        } else {
          invalidate();
        } 
        if (this.mShowing) {
          f1 = this.mShowInterpolator.getInterpolation(f1);
        } else {
          f1 = this.mHideInterpolator.getInterpolation(f1);
        } 
        paramCanvas.drawARGB((int)(80.0F * f1), 0, 0, 0);
        paramCanvas.save();
        float f2 = (this.mScale - 1.0F) * f1 / this.mScale + 1.0F / this.mScale;
        float f4 = -this.mShiftX;
        float f3 = 1.0F - f1;
        f4 = f4 * f3 / this.mScale;
        f3 = -this.mShiftY * f3 / this.mScale;
        this.mDrawRect.left = this.mTouch.x - this.mLeftExtrusion * f2 + f4;
        this.mDrawRect.top = this.mTouch.y - this.mTopExtrusion * f2 + f3;
        this.mDrawRect.right = this.mTouch.x + this.mRightExtrusion * f2 + f4;
        this.mDrawRect.bottom = this.mTouch.y + this.mBottomExtrusion * f2 + f3;
        paramCanvas.clipRect(this.mDrawRect);
        paramCanvas.scale(f2, f2, this.mDrawRect.left, this.mDrawRect.top);
        paramCanvas.translate(this.mPopupScrollX, this.mPopupScrollY);
        paramCanvas.drawBitmap(this.mZoomedBitmap, this.mDrawRect.left, this.mDrawRect.top, null);
        paramCanvas.restore();
        Drawable drawable = getOverlayDrawable(getContext());
        drawable.setBounds((int)this.mDrawRect.left - sOverlayPadding.left, (int)this.mDrawRect.top - sOverlayPadding.top, (int)this.mDrawRect.right + sOverlayPadding.right, (int)this.mDrawRect.bottom + sOverlayPadding.bottom);
        int j = (int)(f1 * 255.0F);
        if (j < 0) {
          i = 0;
        } else {
          i = j;
          if (j > 255)
            i = 255; 
        } 
        drawable.setAlpha(i);
        drawable.draw(paramCanvas);
        paramCanvas.restore();
        return;
      } 
      return;
    } 
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouchEvent(MotionEvent paramMotionEvent) {
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  final void startAnimation(boolean paramBoolean) {
    this.mAnimating = true;
    this.mShowing = paramBoolean;
    this.mTimeLeft = 0L;
    if (paramBoolean) {
      setVisibility(0);
      this.mNeedsToInitDimensions = true;
      if (this.mOnVisibilityChangedListener != null)
        this.mOnVisibilityChangedListener.onPopupZoomerShown(this); 
    } else {
      this.mTimeLeft = this.mAnimationStartTime + 300L - SystemClock.uptimeMillis();
      if (this.mTimeLeft < 0L)
        this.mTimeLeft = 0L; 
    } 
    this.mAnimationStartTime = SystemClock.uptimeMillis();
    invalidate();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\PopupZoomer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */