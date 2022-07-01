package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundButton;

public class AppCompatRadioButton extends RadioButton implements TintableBackgroundView, TintableCompoundButton {
  private final AppCompatCompoundButtonHelper a = new AppCompatCompoundButtonHelper((CompoundButton)this);
  
  private final AppCompatBackgroundHelper b;
  
  private final AppCompatTextHelper c;
  
  public AppCompatRadioButton(Context paramContext) {
    this(paramContext, null);
  }
  
  public AppCompatRadioButton(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.radioButtonStyle);
  }
  
  public AppCompatRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
    this.b = new AppCompatBackgroundHelper((View)this);
    this.b.a(paramAttributeSet, paramInt);
    this.c = new AppCompatTextHelper((TextView)this);
    this.c.a(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.b;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.c(); 
    AppCompatTextHelper appCompatTextHelper = this.c;
    if (appCompatTextHelper != null)
      appCompatTextHelper.b(); 
  }
  
  public int getCompoundPaddingLeft() {
    int j = super.getCompoundPaddingLeft();
    AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.a;
    int i = j;
    if (appCompatCompoundButtonHelper != null)
      i = appCompatCompoundButtonHelper.a(j); 
    return i;
  }
  
  public ColorStateList getSupportBackgroundTintList() {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.b;
    return (appCompatBackgroundHelper != null) ? appCompatBackgroundHelper.a() : null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode() {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.b;
    return (appCompatBackgroundHelper != null) ? appCompatBackgroundHelper.b() : null;
  }
  
  public ColorStateList getSupportButtonTintList() {
    AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.a;
    return (appCompatCompoundButtonHelper != null) ? appCompatCompoundButtonHelper.a() : null;
  }
  
  public PorterDuff.Mode getSupportButtonTintMode() {
    AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.a;
    return (appCompatCompoundButtonHelper != null) ? appCompatCompoundButtonHelper.b() : null;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    super.setBackgroundDrawable(paramDrawable);
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.b;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramDrawable); 
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.b;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramInt); 
  }
  
  public void setButtonDrawable(int paramInt) {
    setButtonDrawable(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setButtonDrawable(Drawable paramDrawable) {
    super.setButtonDrawable(paramDrawable);
    AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.a;
    if (appCompatCompoundButtonHelper != null)
      appCompatCompoundButtonHelper.c(); 
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList) {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.b;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramColorStateList); 
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode) {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.b;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramMode); 
  }
  
  public void setSupportButtonTintList(ColorStateList paramColorStateList) {
    AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.a;
    if (appCompatCompoundButtonHelper != null)
      appCompatCompoundButtonHelper.a(paramColorStateList); 
  }
  
  public void setSupportButtonTintMode(PorterDuff.Mode paramMode) {
    AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.a;
    if (appCompatCompoundButtonHelper != null)
      appCompatCompoundButtonHelper.a(paramMode); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\AppCompatRadioButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */