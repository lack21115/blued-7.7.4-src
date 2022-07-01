package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.util.concurrent.Future;

public class AppCompatTextView extends TextView implements TintableBackgroundView, AutoSizeableTextView, TintableCompoundDrawablesView {
  private final AppCompatBackgroundHelper a = new AppCompatBackgroundHelper((View)this);
  
  private final AppCompatTextHelper b;
  
  private final AppCompatTextClassifierHelper c;
  
  private Future<PrecomputedTextCompat> d;
  
  public AppCompatTextView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
    this.b = new AppCompatTextHelper(this);
    this.b.a(paramAttributeSet, paramInt);
    this.b.b();
    this.c = new AppCompatTextClassifierHelper(this);
  }
  
  private void a() {
    Future<PrecomputedTextCompat> future = this.d;
    if (future != null)
      try {
        this.d = null;
        TextViewCompat.setPrecomputedText(this, future.get());
        return;
      } catch (InterruptedException|java.util.concurrent.ExecutionException interruptedException) {
        return;
      }  
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
  
  public int getFirstBaselineToTopHeight() {
    return TextViewCompat.getFirstBaselineToTopHeight(this);
  }
  
  public int getLastBaselineToBottomHeight() {
    return TextViewCompat.getLastBaselineToBottomHeight(this);
  }
  
  public ColorStateList getSupportBackgroundTintList() {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    return (appCompatBackgroundHelper != null) ? appCompatBackgroundHelper.a() : null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode() {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
    return (appCompatBackgroundHelper != null) ? appCompatBackgroundHelper.b() : null;
  }
  
  public ColorStateList getSupportCompoundDrawablesTintList() {
    return this.b.j();
  }
  
  public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
    return this.b.k();
  }
  
  public CharSequence getText() {
    a();
    return super.getText();
  }
  
  public TextClassifier getTextClassifier() {
    if (Build.VERSION.SDK_INT < 28) {
      AppCompatTextClassifierHelper appCompatTextClassifierHelper = this.c;
      if (appCompatTextClassifierHelper != null)
        return appCompatTextClassifierHelper.getTextClassifier(); 
    } 
    return super.getTextClassifier();
  }
  
  public PrecomputedTextCompat.Params getTextMetricsParamsCompat() {
    return TextViewCompat.getTextMetricsParams(this);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) {
    return AppCompatHintHelper.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, (View)this);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppCompatTextHelper appCompatTextHelper = this.b;
    if (appCompatTextHelper != null)
      appCompatTextHelper.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    a();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
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
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4) {
    super.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    AppCompatTextHelper appCompatTextHelper = this.b;
    if (appCompatTextHelper != null)
      appCompatTextHelper.a(); 
  }
  
  public void setCompoundDrawablesRelative(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4) {
    super.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    AppCompatTextHelper appCompatTextHelper = this.b;
    if (appCompatTextHelper != null)
      appCompatTextHelper.a(); 
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Drawable drawable1;
    Drawable drawable2;
    Drawable drawable3;
    Context context = getContext();
    Drawable drawable4 = null;
    if (paramInt1 != 0) {
      drawable1 = AppCompatResources.getDrawable(context, paramInt1);
    } else {
      drawable1 = null;
    } 
    if (paramInt2 != 0) {
      drawable2 = AppCompatResources.getDrawable(context, paramInt2);
    } else {
      drawable2 = null;
    } 
    if (paramInt3 != 0) {
      drawable3 = AppCompatResources.getDrawable(context, paramInt3);
    } else {
      drawable3 = null;
    } 
    if (paramInt4 != 0)
      drawable4 = AppCompatResources.getDrawable(context, paramInt4); 
    setCompoundDrawablesRelativeWithIntrinsicBounds(drawable1, drawable2, drawable3, drawable4);
    AppCompatTextHelper appCompatTextHelper = this.b;
    if (appCompatTextHelper != null)
      appCompatTextHelper.a(); 
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4) {
    super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    AppCompatTextHelper appCompatTextHelper = this.b;
    if (appCompatTextHelper != null)
      appCompatTextHelper.a(); 
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Drawable drawable1;
    Drawable drawable2;
    Drawable drawable3;
    Context context = getContext();
    Drawable drawable4 = null;
    if (paramInt1 != 0) {
      drawable1 = AppCompatResources.getDrawable(context, paramInt1);
    } else {
      drawable1 = null;
    } 
    if (paramInt2 != 0) {
      drawable2 = AppCompatResources.getDrawable(context, paramInt2);
    } else {
      drawable2 = null;
    } 
    if (paramInt3 != 0) {
      drawable3 = AppCompatResources.getDrawable(context, paramInt3);
    } else {
      drawable3 = null;
    } 
    if (paramInt4 != 0)
      drawable4 = AppCompatResources.getDrawable(context, paramInt4); 
    setCompoundDrawablesWithIntrinsicBounds(drawable1, drawable2, drawable3, drawable4);
    AppCompatTextHelper appCompatTextHelper = this.b;
    if (appCompatTextHelper != null)
      appCompatTextHelper.a(); 
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4) {
    super.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    AppCompatTextHelper appCompatTextHelper = this.b;
    if (appCompatTextHelper != null)
      appCompatTextHelper.a(); 
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback) {
    super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, paramCallback));
  }
  
  public void setFirstBaselineToTopHeight(int paramInt) {
    if (Build.VERSION.SDK_INT >= 28) {
      super.setFirstBaselineToTopHeight(paramInt);
      return;
    } 
    TextViewCompat.setFirstBaselineToTopHeight(this, paramInt);
  }
  
  public void setLastBaselineToBottomHeight(int paramInt) {
    if (Build.VERSION.SDK_INT >= 28) {
      super.setLastBaselineToBottomHeight(paramInt);
      return;
    } 
    TextViewCompat.setLastBaselineToBottomHeight(this, paramInt);
  }
  
  public void setLineHeight(int paramInt) {
    TextViewCompat.setLineHeight(this, paramInt);
  }
  
  public void setPrecomputedText(PrecomputedTextCompat paramPrecomputedTextCompat) {
    TextViewCompat.setPrecomputedText(this, paramPrecomputedTextCompat);
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
  
  public void setSupportCompoundDrawablesTintList(ColorStateList paramColorStateList) {
    this.b.a(paramColorStateList);
    this.b.b();
  }
  
  public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode paramMode) {
    this.b.a(paramMode);
    this.b.b();
  }
  
  public void setTextAppearance(Context paramContext, int paramInt) {
    super.setTextAppearance(paramContext, paramInt);
    AppCompatTextHelper appCompatTextHelper = this.b;
    if (appCompatTextHelper != null)
      appCompatTextHelper.a(paramContext, paramInt); 
  }
  
  public void setTextClassifier(TextClassifier paramTextClassifier) {
    if (Build.VERSION.SDK_INT < 28) {
      AppCompatTextClassifierHelper appCompatTextClassifierHelper = this.c;
      if (appCompatTextClassifierHelper != null) {
        appCompatTextClassifierHelper.setTextClassifier(paramTextClassifier);
        return;
      } 
    } 
    super.setTextClassifier(paramTextClassifier);
  }
  
  public void setTextFuture(Future<PrecomputedTextCompat> paramFuture) {
    this.d = paramFuture;
    if (paramFuture != null)
      requestLayout(); 
  }
  
  public void setTextMetricsParamsCompat(PrecomputedTextCompat.Params paramParams) {
    TextViewCompat.setTextMetricsParams(this, paramParams);
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
  
  public void setTypeface(Typeface paramTypeface, int paramInt) {
    Typeface typeface;
    if (paramTypeface != null && paramInt > 0) {
      typeface = TypefaceCompat.create(getContext(), paramTypeface, paramInt);
    } else {
      typeface = null;
    } 
    if (typeface != null)
      paramTypeface = typeface; 
    super.setTypeface(paramTypeface, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\AppCompatTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */