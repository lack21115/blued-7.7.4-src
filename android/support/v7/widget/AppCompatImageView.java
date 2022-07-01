package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.widget.TintableImageSourceView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class AppCompatImageView extends ImageView implements TintableBackgroundView, TintableImageSourceView {
  private final AppCompatBackgroundHelper mBackgroundTintHelper = new AppCompatBackgroundHelper((View)this);
  
  private final AppCompatImageHelper mImageHelper;
  
  public AppCompatImageView(Context paramContext) {
    this(paramContext, null);
  }
  
  private AppCompatImageView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AppCompatImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    this.mBackgroundTintHelper.loadFromAttributes(paramAttributeSet, paramInt);
    this.mImageHelper = new AppCompatImageHelper(this);
    this.mImageHelper.loadFromAttributes(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.applySupportBackgroundTint(); 
    if (this.mImageHelper != null)
      this.mImageHelper.applySupportImageTint(); 
  }
  
  public final ColorStateList getSupportBackgroundTintList() {
    return (this.mBackgroundTintHelper != null) ? this.mBackgroundTintHelper.getSupportBackgroundTintList() : null;
  }
  
  public final PorterDuff.Mode getSupportBackgroundTintMode() {
    return (this.mBackgroundTintHelper != null) ? this.mBackgroundTintHelper.getSupportBackgroundTintMode() : null;
  }
  
  public final ColorStateList getSupportImageTintList() {
    return (this.mImageHelper != null) ? this.mImageHelper.getSupportImageTintList() : null;
  }
  
  public final PorterDuff.Mode getSupportImageTintMode() {
    return (this.mImageHelper != null) ? this.mImageHelper.getSupportImageTintMode() : null;
  }
  
  public boolean hasOverlappingRendering() {
    return (this.mImageHelper.hasOverlappingRendering() && super.hasOverlappingRendering());
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.onSetBackgroundDrawable$130e17e7(); 
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.onSetBackgroundResource(paramInt); 
  }
  
  public void setImageBitmap(Bitmap paramBitmap) {
    super.setImageBitmap(paramBitmap);
    if (this.mImageHelper != null)
      this.mImageHelper.applySupportImageTint(); 
  }
  
  public void setImageDrawable(Drawable paramDrawable) {
    super.setImageDrawable(paramDrawable);
    if (this.mImageHelper != null)
      this.mImageHelper.applySupportImageTint(); 
  }
  
  public void setImageResource(int paramInt) {
    if (this.mImageHelper != null)
      this.mImageHelper.setImageResource(paramInt); 
  }
  
  public void setImageURI(Uri paramUri) {
    super.setImageURI(paramUri);
    if (this.mImageHelper != null)
      this.mImageHelper.applySupportImageTint(); 
  }
  
  public final void setSupportBackgroundTintList(ColorStateList paramColorStateList) {
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList); 
  }
  
  public final void setSupportBackgroundTintMode(PorterDuff.Mode paramMode) {
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode); 
  }
  
  public final void setSupportImageTintList(ColorStateList paramColorStateList) {
    if (this.mImageHelper != null)
      this.mImageHelper.setSupportImageTintList(paramColorStateList); 
  }
  
  public final void setSupportImageTintMode(PorterDuff.Mode paramMode) {
    if (this.mImageHelper != null)
      this.mImageHelper.setSupportImageTintMode(paramMode); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\AppCompatImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */