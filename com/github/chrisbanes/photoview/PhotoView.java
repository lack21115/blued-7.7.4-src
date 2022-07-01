package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

public class PhotoView extends AppCompatImageView {
  private PhotoViewAttacher a;
  
  private ImageView.ScaleType b;
  
  public PhotoView(Context paramContext) {
    this(paramContext, null);
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    this.a = new PhotoViewAttacher((ImageView)this);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    ImageView.ScaleType scaleType = this.b;
    if (scaleType != null) {
      setScaleType(scaleType);
      this.b = null;
    } 
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean) {
    this.a.a(paramFloat1, paramFloat2, paramFloat3, paramBoolean);
  }
  
  public void a(float paramFloat, boolean paramBoolean) {
    this.a.a(paramFloat, paramBoolean);
  }
  
  public PhotoViewAttacher getAttacher() {
    return this.a;
  }
  
  public RectF getDisplayRect() {
    return this.a.a();
  }
  
  public Matrix getImageMatrix() {
    return this.a.h();
  }
  
  public float getMaximumScale() {
    return this.a.d();
  }
  
  public float getMediumScale() {
    return this.a.c();
  }
  
  public float getMinimumScale() {
    return this.a.b();
  }
  
  public float getScale() {
    return this.a.e();
  }
  
  public ImageView.ScaleType getScaleType() {
    return this.a.f();
  }
  
  public void setAllowParentInterceptOnEdge(boolean paramBoolean) {
    this.a.a(paramBoolean);
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    if (bool)
      this.a.g(); 
    return bool;
  }
  
  public void setImageDrawable(Drawable paramDrawable) {
    super.setImageDrawable(paramDrawable);
    PhotoViewAttacher photoViewAttacher = this.a;
    if (photoViewAttacher != null)
      photoViewAttacher.g(); 
  }
  
  public void setImageResource(int paramInt) {
    super.setImageResource(paramInt);
    PhotoViewAttacher photoViewAttacher = this.a;
    if (photoViewAttacher != null)
      photoViewAttacher.g(); 
  }
  
  public void setImageURI(Uri paramUri) {
    super.setImageURI(paramUri);
    PhotoViewAttacher photoViewAttacher = this.a;
    if (photoViewAttacher != null)
      photoViewAttacher.g(); 
  }
  
  public void setMaximumScale(float paramFloat) {
    this.a.e(paramFloat);
  }
  
  public void setMediumScale(float paramFloat) {
    this.a.d(paramFloat);
  }
  
  public void setMinimumScale(float paramFloat) {
    this.a.c(paramFloat);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener) {
    this.a.a(paramOnClickListener);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener) {
    this.a.a(paramOnDoubleTapListener);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener) {
    this.a.a(paramOnLongClickListener);
  }
  
  public void setOnMatrixChangeListener(OnMatrixChangedListener paramOnMatrixChangedListener) {
    this.a.a(paramOnMatrixChangedListener);
  }
  
  public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener paramOnOutsidePhotoTapListener) {
    this.a.a(paramOnOutsidePhotoTapListener);
  }
  
  public void setOnPhotoTapListener(OnPhotoTapListener paramOnPhotoTapListener) {
    this.a.a(paramOnPhotoTapListener);
  }
  
  public void setOnScaleChangeListener(OnScaleChangedListener paramOnScaleChangedListener) {
    this.a.a(paramOnScaleChangedListener);
  }
  
  public void setOnSingleFlingListener(OnSingleFlingListener paramOnSingleFlingListener) {
    this.a.a(paramOnSingleFlingListener);
  }
  
  public void setOnViewDragListener(OnViewDragListener paramOnViewDragListener) {
    this.a.a(paramOnViewDragListener);
  }
  
  public void setOnViewTapListener(OnViewTapListener paramOnViewTapListener) {
    this.a.a(paramOnViewTapListener);
  }
  
  public void setRotationBy(float paramFloat) {
    this.a.b(paramFloat);
  }
  
  public void setRotationTo(float paramFloat) {
    this.a.a(paramFloat);
  }
  
  public void setScale(float paramFloat) {
    this.a.f(paramFloat);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType) {
    PhotoViewAttacher photoViewAttacher = this.a;
    if (photoViewAttacher == null) {
      this.b = paramScaleType;
      return;
    } 
    photoViewAttacher.a(paramScaleType);
  }
  
  public void setZoomTransitionDuration(int paramInt) {
    this.a.a(paramInt);
  }
  
  public void setZoomable(boolean paramBoolean) {
    this.a.b(paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\chrisbanes\photoview\PhotoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */