package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.widget.AutoSizeableTextView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import java.util.Arrays;

public class AppCompatTextView extends TextView implements TintableBackgroundView, AutoSizeableTextView {
  private final AppCompatBackgroundHelper mBackgroundTintHelper = new AppCompatBackgroundHelper((View)this);
  
  private final AppCompatTextHelper mTextHelper;
  
  public AppCompatTextView(Context paramContext) {
    this(paramContext, null);
  }
  
  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    this.mBackgroundTintHelper.loadFromAttributes(paramAttributeSet, paramInt);
    this.mTextHelper = AppCompatTextHelper.create(this);
    this.mTextHelper.loadFromAttributes(paramAttributeSet, paramInt);
    this.mTextHelper.applyCompoundDrawablesTints();
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.applySupportBackgroundTint(); 
    if (this.mTextHelper != null)
      this.mTextHelper.applyCompoundDrawablesTints(); 
  }
  
  public int getAutoSizeMaxTextSize() {
    return PLATFORM_SUPPORTS_AUTOSIZE ? super.getAutoSizeMaxTextSize() : ((this.mTextHelper != null) ? Math.round(this.mTextHelper.mAutoSizeTextHelper.mAutoSizeMaxTextSizeInPx) : -1);
  }
  
  public int getAutoSizeMinTextSize() {
    return PLATFORM_SUPPORTS_AUTOSIZE ? super.getAutoSizeMinTextSize() : ((this.mTextHelper != null) ? Math.round(this.mTextHelper.mAutoSizeTextHelper.mAutoSizeMinTextSizeInPx) : -1);
  }
  
  public int getAutoSizeStepGranularity() {
    return PLATFORM_SUPPORTS_AUTOSIZE ? super.getAutoSizeStepGranularity() : ((this.mTextHelper != null) ? Math.round(this.mTextHelper.mAutoSizeTextHelper.mAutoSizeStepGranularityInPx) : -1);
  }
  
  public int[] getAutoSizeTextAvailableSizes() {
    return PLATFORM_SUPPORTS_AUTOSIZE ? super.getAutoSizeTextAvailableSizes() : ((this.mTextHelper != null) ? this.mTextHelper.mAutoSizeTextHelper.mAutoSizeTextSizesInPx : new int[0]);
  }
  
  public int getAutoSizeTextType() {
    return PLATFORM_SUPPORTS_AUTOSIZE ? ((super.getAutoSizeTextType() == 1) ? 1 : 0) : ((this.mTextHelper != null) ? this.mTextHelper.mAutoSizeTextHelper.mAutoSizeTextType : 0);
  }
  
  public final ColorStateList getSupportBackgroundTintList() {
    return (this.mBackgroundTintHelper != null) ? this.mBackgroundTintHelper.getSupportBackgroundTintList() : null;
  }
  
  public final PorterDuff.Mode getSupportBackgroundTintMode() {
    return (this.mBackgroundTintHelper != null) ? this.mBackgroundTintHelper.getSupportBackgroundTintMode() : null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mTextHelper != null) {
      AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
      if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE)
        appCompatTextHelper.mAutoSizeTextHelper.autoSizeText(); 
    } 
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (this.mTextHelper != null && !PLATFORM_SUPPORTS_AUTOSIZE && this.mTextHelper.mAutoSizeTextHelper.isAutoSizeEnabled())
      this.mTextHelper.mAutoSizeTextHelper.autoSizeText(); 
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
      throw new VerifyError("bad dex opcode");
    } 
    if (this.mTextHelper != null) {
      AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mTextHelper.mAutoSizeTextHelper;
      if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
        DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
        appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(paramInt4, paramInt1, displayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, displayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, displayMetrics));
        if (appCompatTextViewAutoSizeHelper.setupAutoSizeText())
          appCompatTextViewAutoSizeHelper.autoSizeText(); 
      } 
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfint, int paramInt) {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfint, paramInt);
      throw new VerifyError("bad dex opcode");
    } 
    if (this.mTextHelper != null) {
      AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mTextHelper.mAutoSizeTextHelper;
      if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
        int j = paramArrayOfint.length;
        int i = 0;
        if (j > 0) {
          int[] arrayOfInt1;
          int[] arrayOfInt2 = new int[j];
          if (paramInt == 0) {
            arrayOfInt1 = Arrays.copyOf(paramArrayOfint, j);
          } else {
            DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
            while (true) {
              arrayOfInt1 = arrayOfInt2;
              if (i < j) {
                arrayOfInt2[i] = Math.round(TypedValue.applyDimension(paramInt, paramArrayOfint[i], displayMetrics));
                i++;
                continue;
              } 
              break;
            } 
          } 
          appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = AppCompatTextViewAutoSizeHelper.cleanupAutoSizePresetSizes(arrayOfInt1);
          if (!appCompatTextViewAutoSizeHelper.setupAutoSizeUniformPresetSizesConfiguration()) {
            StringBuilder stringBuilder = new StringBuilder("None of the preset sizes is valid: ");
            stringBuilder.append(Arrays.toString(paramArrayOfint));
            throw new IllegalArgumentException(stringBuilder.toString());
          } 
        } else {
          appCompatTextViewAutoSizeHelper.mHasPresetAutoSizeValues = false;
        } 
        if (appCompatTextViewAutoSizeHelper.setupAutoSizeText())
          appCompatTextViewAutoSizeHelper.autoSizeText(); 
      } 
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt) {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
      throw new VerifyError("bad dex opcode");
    } 
    if (this.mTextHelper != null) {
      AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mTextHelper.mAutoSizeTextHelper;
      if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
        StringBuilder stringBuilder;
        DisplayMetrics displayMetrics;
        switch (paramInt) {
          default:
            stringBuilder = new StringBuilder("Unknown auto-size text type: ");
            stringBuilder.append(paramInt);
            throw new IllegalArgumentException(stringBuilder.toString());
          case 1:
            displayMetrics = ((AppCompatTextViewAutoSizeHelper)stringBuilder).mContext.getResources().getDisplayMetrics();
            stringBuilder.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0F, displayMetrics), TypedValue.applyDimension(2, 112.0F, displayMetrics), 1.0F);
            if (stringBuilder.setupAutoSizeText()) {
              stringBuilder.autoSizeText();
              throw new VerifyError("bad dex opcode");
            } 
            throw new VerifyError("bad dex opcode");
          case 0:
            break;
        } 
        ((AppCompatTextViewAutoSizeHelper)stringBuilder).mAutoSizeTextType = 0;
        ((AppCompatTextViewAutoSizeHelper)stringBuilder).mAutoSizeMinTextSizeInPx = -1.0F;
        ((AppCompatTextViewAutoSizeHelper)stringBuilder).mAutoSizeMaxTextSizeInPx = -1.0F;
        ((AppCompatTextViewAutoSizeHelper)stringBuilder).mAutoSizeStepGranularityInPx = -1.0F;
        ((AppCompatTextViewAutoSizeHelper)stringBuilder).mAutoSizeTextSizesInPx = new int[0];
        ((AppCompatTextViewAutoSizeHelper)stringBuilder).mNeedsAutoSizeText = false;
        throw new VerifyError("bad dex opcode");
      } 
    } 
    throw new VerifyError("bad dex opcode");
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
  
  public final void setSupportBackgroundTintList(ColorStateList paramColorStateList) {
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList); 
  }
  
  public final void setSupportBackgroundTintMode(PorterDuff.Mode paramMode) {
    if (this.mBackgroundTintHelper != null)
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode); 
  }
  
  public void setTextAppearance(Context paramContext, int paramInt) {
    super.setTextAppearance(paramContext, paramInt);
    if (this.mTextHelper != null)
      this.mTextHelper.onSetTextAppearance(paramContext, paramInt); 
  }
  
  public void setTextSize(int paramInt, float paramFloat) {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      super.setTextSize(paramInt, paramFloat);
      return;
    } 
    if (this.mTextHelper != null) {
      AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
      if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && !appCompatTextHelper.mAutoSizeTextHelper.isAutoSizeEnabled())
        appCompatTextHelper.mAutoSizeTextHelper.setTextSizeInternal(paramInt, paramFloat); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\AppCompatTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */