package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;

public class AppCompatButton extends Button implements TintableBackgroundView, AutoSizeableTextView {
  private final AppCompatBackgroundHelper a = new AppCompatBackgroundHelper((View)this);
  
  private final AppCompatTextHelper b;
  
  public AppCompatButton(Context paramContext) {
    this(paramContext, null);
  }
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.buttonStyle);
  }
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
    this.b = new AppCompatTextHelper((TextView)this);
    this.b.a(paramAttributeSet, paramInt);
    this.b.b();
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.c(); 
    AppCompatTextHelper appCompatTextHelper = this.b;
    if (appCompatTextHelper != null)
      appCompatTextHelper.b(); 
  }
  
  public int getAutoSizeMaxTextSize() {
    if (PLATFORM_SUPPORTS_AUTOSIZE)
      return super.getAutoSizeMaxTextSize(); 
    AppCompatTextHelper appCompatTextHelper = this.b;
    return (appCompatTextHelper != null) ? appCompatTextHelper.h() : -1;
  }
  
  public int getAutoSizeMinTextSize() {
    if (PLATFORM_SUPPORTS_AUTOSIZE)
      return super.getAutoSizeMinTextSize(); 
    AppCompatTextHelper appCompatTextHelper = this.b;
    return (appCompatTextHelper != null) ? appCompatTextHelper.g() : -1;
  }
  
  public int getAutoSizeStepGranularity() {
    if (PLATFORM_SUPPORTS_AUTOSIZE)
      return super.getAutoSizeStepGranularity(); 
    AppCompatTextHelper appCompatTextHelper = this.b;
    return (appCompatTextHelper != null) ? appCompatTextHelper.f() : -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes() {
    if (PLATFORM_SUPPORTS_AUTOSIZE)
      return super.getAutoSizeTextAvailableSizes(); 
    AppCompatTextHelper appCompatTextHelper = this.b;
    return (appCompatTextHelper != null) ? appCompatTextHelper.i() : new int[0];
  }
  
  public int getAutoSizeTextType() {
    boolean bool1 = PLATFORM_SUPPORTS_AUTOSIZE;
    boolean bool = false;
    if (bool1) {
      if (super.getAutoSizeTextType() == 1)
        bool = true; 
      return bool;
    } 
    AppCompatTextHelper appCompatTextHelper = this.b;
    return (appCompatTextHelper != null) ? appCompatTextHelper.e() : 0;
  }
  
  public ColorStateList getSupportBackgroundTintList() {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    return (appCompatBackgroundHelper != null) ? appCompatBackgroundHelper.a() : null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode() {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    return (appCompatBackgroundHelper != null) ? appCompatBackgroundHelper.b() : null;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Button.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(Button.class.getName());
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppCompatTextHelper appCompatTextHelper = this.b;
    if (appCompatTextHelper != null)
      appCompatTextHelper.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (this.b != null && !PLATFORM_SUPPORTS_AUTOSIZE && this.b.d())
      this.b.c(); 
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4) throws IllegalArgumentException {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    } 
    AppCompatTextHelper appCompatTextHelper = this.b;
    if (appCompatTextHelper != null)
      appCompatTextHelper.a(paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfint, int paramInt) throws IllegalArgumentException {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfint, paramInt);
      return;
    } 
    AppCompatTextHelper appCompatTextHelper = this.b;
    if (appCompatTextHelper != null)
      appCompatTextHelper.a(paramArrayOfint, paramInt); 
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt) {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
      return;
    } 
    AppCompatTextHelper appCompatTextHelper = this.b;
    if (appCompatTextHelper != null)
      appCompatTextHelper.a(paramInt); 
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
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback) {
    super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback((TextView)this, paramCallback));
  }
  
  public void setSupportAllCaps(boolean paramBoolean) {
    AppCompatTextHelper appCompatTextHelper = this.b;
    if (appCompatTextHelper != null)
      appCompatTextHelper.a(paramBoolean); 
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
  
  public void setTextAppearance(Context paramContext, int paramInt) {
    super.setTextAppearance(paramContext, paramInt);
    AppCompatTextHelper appCompatTextHelper = this.b;
    if (appCompatTextHelper != null)
      appCompatTextHelper.a(paramContext, paramInt); 
  }
  
  public void setTextSize(int paramInt, float paramFloat) {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      super.setTextSize(paramInt, paramFloat);
      return;
    } 
    AppCompatTextHelper appCompatTextHelper = this.b;
    if (appCompatTextHelper != null)
      appCompatTextHelper.a(paramInt, paramFloat); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\AppCompatButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */