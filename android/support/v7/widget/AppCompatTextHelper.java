package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class AppCompatTextHelper {
  boolean mAsyncFontPending;
  
  final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
  
  private TintInfo mDrawableBottomTint;
  
  private TintInfo mDrawableLeftTint;
  
  private TintInfo mDrawableRightTint;
  
  private TintInfo mDrawableTopTint;
  
  Typeface mFontTypeface;
  
  int mStyle = 0;
  
  final TextView mView;
  
  AppCompatTextHelper(TextView paramTextView) {
    this.mView = paramTextView;
    this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(this.mView);
  }
  
  static AppCompatTextHelper create(TextView paramTextView) {
    return (Build.VERSION.SDK_INT >= 17) ? new AppCompatTextHelperV17(paramTextView) : new AppCompatTextHelper(paramTextView);
  }
  
  protected static TintInfo createTintInfo(Context paramContext, AppCompatDrawableManager paramAppCompatDrawableManager, int paramInt) {
    ColorStateList colorStateList = paramAppCompatDrawableManager.getTintList(paramContext, paramInt);
    if (colorStateList != null) {
      TintInfo tintInfo = new TintInfo();
      tintInfo.mHasTintList = true;
      tintInfo.mTintList = colorStateList;
      return tintInfo;
    } 
    return null;
  }
  
  private void setAllCaps(boolean paramBoolean) {
    this.mView.setAllCaps(paramBoolean);
  }
  
  private void updateTypefaceAndStyle(Context paramContext, TintTypedArray paramTintTypedArray) {
    this.mStyle = paramTintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.mStyle);
    boolean bool1 = paramTintTypedArray.hasValue(R.styleable.TextAppearance_android_fontFamily);
    boolean bool = true;
    if (bool1 || paramTintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
      int i;
      AppCompatTextHelper$1 appCompatTextHelper$1 = null;
      this.mFontTypeface = null;
      if (paramTintTypedArray.hasValue(R.styleable.TextAppearance_android_fontFamily)) {
        i = R.styleable.TextAppearance_android_fontFamily;
      } else {
        i = R.styleable.TextAppearance_fontFamily;
      } 
      if (!paramContext.isRestricted()) {
        AppCompatTextHelper$1 appCompatTextHelper$11 = new AppCompatTextHelper$1(this, new WeakReference<TextView>(this.mView));
        try {
          Typeface typeface;
          int j = this.mStyle;
          int k = paramTintTypedArray.mWrapped.getResourceId(i, 0);
          if (k == 0) {
            appCompatTextHelper$11 = appCompatTextHelper$1;
          } else {
            if (paramTintTypedArray.mTypedValue == null)
              paramTintTypedArray.mTypedValue = new TypedValue(); 
            Context context = paramTintTypedArray.mContext;
            TypedValue typedValue = paramTintTypedArray.mTypedValue;
            if (context.isRestricted()) {
              appCompatTextHelper$11 = appCompatTextHelper$1;
            } else {
              Resources resources = context.getResources();
              resources.getValue(k, typedValue, true);
              typeface = ResourcesCompat.loadFont(context, resources, typedValue, k, j, appCompatTextHelper$11, null, true);
            } 
          } 
          this.mFontTypeface = typeface;
          if (this.mFontTypeface != null)
            bool = false; 
          this.mAsyncFontPending = bool;
        } catch (UnsupportedOperationException|android.content.res.Resources.NotFoundException unsupportedOperationException) {}
      } 
      if (this.mFontTypeface == null) {
        String str = paramTintTypedArray.mWrapped.getString(i);
        if (str != null)
          this.mFontTypeface = Typeface.create(str, this.mStyle); 
      } 
      return;
    } 
    if (paramTintTypedArray.hasValue(R.styleable.TextAppearance_android_typeface)) {
      this.mAsyncFontPending = false;
      switch (paramTintTypedArray.getInt(R.styleable.TextAppearance_android_typeface, 1)) {
        default:
          return;
        case 3:
          this.mFontTypeface = Typeface.MONOSPACE;
          return;
        case 2:
          this.mFontTypeface = Typeface.SERIF;
          return;
        case 1:
          break;
      } 
      this.mFontTypeface = Typeface.SANS_SERIF;
      return;
    } 
  }
  
  final void applyCompoundDrawableTint(Drawable paramDrawable, TintInfo paramTintInfo) {
    if (paramDrawable != null && paramTintInfo != null)
      AppCompatDrawableManager.tintDrawable(paramDrawable, paramTintInfo, this.mView.getDrawableState()); 
  }
  
  void applyCompoundDrawablesTints() {
    if (this.mDrawableLeftTint != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
      Drawable[] arrayOfDrawable = this.mView.getCompoundDrawables();
      applyCompoundDrawableTint(arrayOfDrawable[0], this.mDrawableLeftTint);
      applyCompoundDrawableTint(arrayOfDrawable[1], this.mDrawableTopTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], this.mDrawableRightTint);
      applyCompoundDrawableTint(arrayOfDrawable[3], this.mDrawableBottomTint);
    } 
  }
  
  @SuppressLint({"NewApi"})
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt) {
    float f1;
    float f2;
    float f3;
    boolean bool1;
    ColorStateList colorStateList1;
    ColorStateList colorStateList4;
    Context context = this.mView.getContext();
    AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
    TintTypedArray tintTypedArray1 = TintTypedArray.obtainStyledAttributes(context, paramAttributeSet, R.styleable.AppCompatTextHelper, paramInt, 0);
    int i = tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
    if (tintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableLeft))
      this.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager, tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableLeft, 0)); 
    if (tintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableTop))
      this.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager, tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableTop, 0)); 
    if (tintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableRight))
      this.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager, tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableRight, 0)); 
    if (tintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableBottom))
      this.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager, tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableBottom, 0)); 
    tintTypedArray1.mWrapped.recycle();
    boolean bool3 = this.mView.getTransformationMethod() instanceof android.text.method.PasswordTransformationMethod;
    tintTypedArray1 = null;
    TintTypedArray tintTypedArray2 = null;
    ColorStateList colorStateList2 = null;
    if (i != -1) {
      tintTypedArray2 = TintTypedArray.obtainStyledAttributes(context, i, R.styleable.TextAppearance);
      if (!bool3 && tintTypedArray2.hasValue(R.styleable.TextAppearance_textAllCaps)) {
        bool1 = tintTypedArray2.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        i = 1;
      } else {
        i = 0;
        bool1 = false;
      } 
      updateTypefaceAndStyle(context, tintTypedArray2);
      if (Build.VERSION.SDK_INT < 23) {
        if (tintTypedArray2.hasValue(R.styleable.TextAppearance_android_textColor)) {
          ColorStateList colorStateList = tintTypedArray2.getColorStateList(R.styleable.TextAppearance_android_textColor);
        } else {
          tintTypedArray1 = null;
        } 
        if (tintTypedArray2.hasValue(R.styleable.TextAppearance_android_textColorHint)) {
          colorStateList1 = tintTypedArray2.getColorStateList(R.styleable.TextAppearance_android_textColorHint);
        } else {
          appCompatDrawableManager = null;
        } 
        if (tintTypedArray2.hasValue(R.styleable.TextAppearance_android_textColorLink))
          colorStateList2 = tintTypedArray2.getColorStateList(R.styleable.TextAppearance_android_textColorLink); 
      } else {
        colorStateList2 = null;
        colorStateList1 = colorStateList2;
      } 
      tintTypedArray2.mWrapped.recycle();
    } else {
      colorStateList2 = null;
      colorStateList1 = colorStateList2;
      i = 0;
      bool1 = false;
      tintTypedArray1 = tintTypedArray2;
    } 
    TintTypedArray tintTypedArray4 = TintTypedArray.obtainStyledAttributes(context, paramAttributeSet, R.styleable.TextAppearance, paramInt, 0);
    int j = i;
    boolean bool2 = bool1;
    if (!bool3) {
      j = i;
      bool2 = bool1;
      if (tintTypedArray4.hasValue(R.styleable.TextAppearance_textAllCaps)) {
        bool2 = tintTypedArray4.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        j = 1;
      } 
    } 
    TintTypedArray tintTypedArray3 = tintTypedArray1;
    ColorStateList colorStateList5 = colorStateList2;
    ColorStateList colorStateList3 = colorStateList1;
    if (Build.VERSION.SDK_INT < 23) {
      ColorStateList colorStateList;
      if (tintTypedArray4.hasValue(R.styleable.TextAppearance_android_textColor))
        colorStateList = tintTypedArray4.getColorStateList(R.styleable.TextAppearance_android_textColor); 
      if (tintTypedArray4.hasValue(R.styleable.TextAppearance_android_textColorHint))
        colorStateList1 = tintTypedArray4.getColorStateList(R.styleable.TextAppearance_android_textColorHint); 
      colorStateList4 = colorStateList;
      colorStateList5 = colorStateList2;
      colorStateList3 = colorStateList1;
      if (tintTypedArray4.hasValue(R.styleable.TextAppearance_android_textColorLink)) {
        colorStateList5 = tintTypedArray4.getColorStateList(R.styleable.TextAppearance_android_textColorLink);
        colorStateList3 = colorStateList1;
        colorStateList4 = colorStateList;
      } 
    } 
    updateTypefaceAndStyle(context, tintTypedArray4);
    tintTypedArray4.mWrapped.recycle();
    if (colorStateList4 != null)
      this.mView.setTextColor(colorStateList4); 
    if (colorStateList3 != null)
      this.mView.setHintTextColor(colorStateList3); 
    if (colorStateList5 != null)
      this.mView.setLinkTextColor(colorStateList5); 
    if (!bool3 && j != 0)
      setAllCaps(bool2); 
    if (this.mFontTypeface != null)
      this.mView.setTypeface(this.mFontTypeface, this.mStyle); 
    AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
    TypedArray typedArray = appCompatTextViewAutoSizeHelper.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AppCompatTextView, paramInt, 0);
    if (typedArray.hasValue(R.styleable.AppCompatTextView_autoSizeTextType))
      appCompatTextViewAutoSizeHelper.mAutoSizeTextType = typedArray.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0); 
    if (typedArray.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity)) {
      f1 = typedArray.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0F);
    } else {
      f1 = -1.0F;
    } 
    if (typedArray.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize)) {
      f2 = typedArray.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0F);
    } else {
      f2 = -1.0F;
    } 
    if (typedArray.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize)) {
      f3 = typedArray.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0F);
    } else {
      f3 = -1.0F;
    } 
    if (typedArray.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes)) {
      paramInt = typedArray.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0);
      if (paramInt > 0) {
        TypedArray typedArray1 = typedArray.getResources().obtainTypedArray(paramInt);
        i = typedArray1.length();
        int[] arrayOfInt = new int[i];
        if (i > 0) {
          for (paramInt = 0; paramInt < i; paramInt++)
            arrayOfInt[paramInt] = typedArray1.getDimensionPixelSize(paramInt, -1); 
          appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = AppCompatTextViewAutoSizeHelper.cleanupAutoSizePresetSizes(arrayOfInt);
          appCompatTextViewAutoSizeHelper.setupAutoSizeUniformPresetSizesConfiguration();
        } 
        typedArray1.recycle();
      } 
    } 
    typedArray.recycle();
    if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
      if (appCompatTextViewAutoSizeHelper.mAutoSizeTextType == 1) {
        if (!appCompatTextViewAutoSizeHelper.mHasPresetAutoSizeValues) {
          DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
          float f = f2;
          if (f2 == -1.0F)
            f = TypedValue.applyDimension(2, 12.0F, displayMetrics); 
          f2 = f3;
          if (f3 == -1.0F)
            f2 = TypedValue.applyDimension(2, 112.0F, displayMetrics); 
          f3 = f1;
          if (f1 == -1.0F)
            f3 = 1.0F; 
          appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(f, f2, f3);
        } 
        appCompatTextViewAutoSizeHelper.setupAutoSizeText();
      } 
    } else {
      appCompatTextViewAutoSizeHelper.mAutoSizeTextType = 0;
    } 
    if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && this.mAutoSizeTextHelper.mAutoSizeTextType != 0) {
      int[] arrayOfInt = this.mAutoSizeTextHelper.mAutoSizeTextSizesInPx;
      if (arrayOfInt.length > 0) {
        if (this.mView.getAutoSizeStepGranularity() != -1.0F) {
          this.mView.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.mAutoSizeTextHelper.mAutoSizeMinTextSizeInPx), Math.round(this.mAutoSizeTextHelper.mAutoSizeMaxTextSizeInPx), Math.round(this.mAutoSizeTextHelper.mAutoSizeStepGranularityInPx), 0);
          throw new VerifyError("bad dex opcode");
        } 
        this.mView.setAutoSizeTextTypeUniformWithPresetSizes(arrayOfInt, 0);
      } 
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  final void onSetTextAppearance(Context paramContext, int paramInt) {
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramInt, R.styleable.TextAppearance);
    if (tintTypedArray.hasValue(R.styleable.TextAppearance_textAllCaps))
      setAllCaps(tintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false)); 
    if (Build.VERSION.SDK_INT < 23 && tintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor)) {
      ColorStateList colorStateList = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
      if (colorStateList != null)
        this.mView.setTextColor(colorStateList); 
    } 
    updateTypefaceAndStyle(paramContext, tintTypedArray);
    tintTypedArray.mWrapped.recycle();
    if (this.mFontTypeface != null)
      this.mView.setTypeface(this.mFontTypeface, this.mStyle); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\AppCompatTextHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */