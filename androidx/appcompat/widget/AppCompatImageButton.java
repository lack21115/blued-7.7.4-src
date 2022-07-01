package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.R;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableImageSourceView;

public class AppCompatImageButton extends ImageButton implements TintableBackgroundView, TintableImageSourceView {
  private final AppCompatBackgroundHelper a = new AppCompatBackgroundHelper((View)this);
  
  private final AppCompatImageHelper b;
  
  public AppCompatImageButton(Context paramContext) {
    this(paramContext, null);
  }
  
  public AppCompatImageButton(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.imageButtonStyle);
  }
  
  public AppCompatImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
    this.b = new AppCompatImageHelper((ImageView)this);
    this.b.loadFromAttributes(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.c(); 
    AppCompatImageHelper appCompatImageHelper = this.b;
    if (appCompatImageHelper != null)
      appCompatImageHelper.d(); 
  }
  
  public ColorStateList getSupportBackgroundTintList() {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    return (appCompatBackgroundHelper != null) ? appCompatBackgroundHelper.a() : null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode() {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    return (appCompatBackgroundHelper != null) ? appCompatBackgroundHelper.b() : null;
  }
  
  public ColorStateList getSupportImageTintList() {
    AppCompatImageHelper appCompatImageHelper = this.b;
    return (appCompatImageHelper != null) ? appCompatImageHelper.b() : null;
  }
  
  public PorterDuff.Mode getSupportImageTintMode() {
    AppCompatImageHelper appCompatImageHelper = this.b;
    return (appCompatImageHelper != null) ? appCompatImageHelper.c() : null;
  }
  
  public boolean hasOverlappingRendering() {
    return (this.b.a() && super.hasOverlappingRendering());
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    super.setBackgroundDrawable(paramDrawable);
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramDrawable); 
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramInt); 
  }
  
  public void setImageBitmap(Bitmap paramBitmap) {
    super.setImageBitmap(paramBitmap);
    AppCompatImageHelper appCompatImageHelper = this.b;
    if (appCompatImageHelper != null)
      appCompatImageHelper.d(); 
  }
  
  public void setImageDrawable(Drawable paramDrawable) {
    super.setImageDrawable(paramDrawable);
    AppCompatImageHelper appCompatImageHelper = this.b;
    if (appCompatImageHelper != null)
      appCompatImageHelper.d(); 
  }
  
  public void setImageResource(int paramInt) {
    this.b.setImageResource(paramInt);
  }
  
  public void setImageURI(Uri paramUri) {
    super.setImageURI(paramUri);
    AppCompatImageHelper appCompatImageHelper = this.b;
    if (appCompatImageHelper != null)
      appCompatImageHelper.d(); 
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList) {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramColorStateList); 
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode) {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramMode); 
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList) {
    AppCompatImageHelper appCompatImageHelper = this.b;
    if (appCompatImageHelper != null)
      appCompatImageHelper.a(paramColorStateList); 
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode) {
    AppCompatImageHelper appCompatImageHelper = this.b;
    if (appCompatImageHelper != null)
      appCompatImageHelper.a(paramMode); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\AppCompatImageButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */