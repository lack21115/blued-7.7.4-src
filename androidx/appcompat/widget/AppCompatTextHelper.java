package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

class AppCompatTextHelper {
  private final TextView a;
  
  private TintInfo b;
  
  private TintInfo c;
  
  private TintInfo d;
  
  private TintInfo e;
  
  private TintInfo f;
  
  private TintInfo g;
  
  private TintInfo h;
  
  private final AppCompatTextViewAutoSizeHelper i;
  
  private int j = 0;
  
  private int k = -1;
  
  private Typeface l;
  
  private boolean m;
  
  AppCompatTextHelper(TextView paramTextView) {
    this.a = paramTextView;
    this.i = new AppCompatTextViewAutoSizeHelper(this.a);
  }
  
  private static TintInfo a(Context paramContext, AppCompatDrawableManager paramAppCompatDrawableManager, int paramInt) {
    ColorStateList colorStateList = paramAppCompatDrawableManager.a(paramContext, paramInt);
    if (colorStateList != null) {
      TintInfo tintInfo = new TintInfo();
      tintInfo.mHasTintList = true;
      tintInfo.mTintList = colorStateList;
      return tintInfo;
    } 
    return null;
  }
  
  private void a(Context paramContext, TintTypedArray paramTintTypedArray) {
    this.j = paramTintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.j);
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i >= 28) {
      this.k = paramTintTypedArray.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
      if (this.k != -1)
        this.j = this.j & 0x2 | 0x0; 
    } 
    if (paramTintTypedArray.hasValue(R.styleable.TextAppearance_android_fontFamily) || paramTintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
      this.l = null;
      if (paramTintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
        i = R.styleable.TextAppearance_fontFamily;
      } else {
        i = R.styleable.TextAppearance_android_fontFamily;
      } 
      int j = this.k;
      int k = this.j;
      if (!paramContext.isRestricted()) {
        ApplyTextViewCallback applyTextViewCallback = new ApplyTextViewCallback(this, j, k);
        try {
          boolean bool1;
          Typeface typeface = paramTintTypedArray.getFont(i, this.j, applyTextViewCallback);
          if (typeface != null)
            if (Build.VERSION.SDK_INT >= 28 && this.k != -1) {
              typeface = Typeface.create(typeface, 0);
              j = this.k;
              if ((this.j & 0x2) != 0) {
                bool1 = true;
              } else {
                bool1 = false;
              } 
              this.l = Typeface.create(typeface, j, bool1);
            } else {
              this.l = typeface;
            }  
          if (this.l == null) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          this.m = bool1;
        } catch (UnsupportedOperationException|android.content.res.Resources.NotFoundException unsupportedOperationException) {}
      } 
      if (this.l == null) {
        String str = paramTintTypedArray.getString(i);
        if (str != null) {
          Typeface typeface;
          if (Build.VERSION.SDK_INT >= 28 && this.k != -1) {
            typeface = Typeface.create(str, 0);
            i = this.k;
            boolean bool1 = bool;
            if ((this.j & 0x2) != 0)
              bool1 = true; 
            this.l = Typeface.create(typeface, i, bool1);
            return;
          } 
          this.l = Typeface.create((String)typeface, this.j);
        } 
      } 
      return;
    } 
    if (paramTintTypedArray.hasValue(R.styleable.TextAppearance_android_typeface)) {
      this.m = false;
      i = paramTintTypedArray.getInt(R.styleable.TextAppearance_android_typeface, 1);
      if (i != 1) {
        if (i != 2) {
          if (i != 3)
            return; 
          this.l = Typeface.MONOSPACE;
          return;
        } 
        this.l = Typeface.SERIF;
        return;
      } 
      this.l = Typeface.SANS_SERIF;
    } 
  }
  
  private void a(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4, Drawable paramDrawable5, Drawable paramDrawable6) {
    TextView textView;
    Drawable[] arrayOfDrawable;
    if (Build.VERSION.SDK_INT >= 17 && (paramDrawable5 != null || paramDrawable6 != null)) {
      arrayOfDrawable = this.a.getCompoundDrawablesRelative();
      textView = this.a;
      if (paramDrawable5 == null)
        paramDrawable5 = arrayOfDrawable[0]; 
      if (paramDrawable2 == null)
        paramDrawable2 = arrayOfDrawable[1]; 
      if (paramDrawable6 == null)
        paramDrawable6 = arrayOfDrawable[2]; 
      if (paramDrawable4 == null)
        paramDrawable4 = arrayOfDrawable[3]; 
      textView.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable5, paramDrawable2, paramDrawable6, paramDrawable4);
      return;
    } 
    if (textView != null || paramDrawable2 != null || arrayOfDrawable != null || paramDrawable4 != null) {
      Drawable drawable1;
      Drawable drawable2;
      if (Build.VERSION.SDK_INT >= 17) {
        Drawable[] arrayOfDrawable2 = this.a.getCompoundDrawablesRelative();
        if (arrayOfDrawable2[0] != null || arrayOfDrawable2[2] != null) {
          textView = this.a;
          drawable2 = arrayOfDrawable2[0];
          if (paramDrawable2 == null)
            paramDrawable2 = arrayOfDrawable2[1]; 
          paramDrawable6 = arrayOfDrawable2[2];
          if (paramDrawable4 == null)
            paramDrawable4 = arrayOfDrawable2[3]; 
          textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable2, paramDrawable2, paramDrawable6, paramDrawable4);
          return;
        } 
      } 
      Drawable[] arrayOfDrawable1 = this.a.getCompoundDrawables();
      TextView textView1 = this.a;
      if (textView == null)
        drawable1 = arrayOfDrawable1[0]; 
      if (paramDrawable2 == null)
        paramDrawable2 = arrayOfDrawable1[1]; 
      if (drawable2 == null)
        drawable2 = arrayOfDrawable1[2]; 
      if (paramDrawable4 == null)
        paramDrawable4 = arrayOfDrawable1[3]; 
      textView1.setCompoundDrawablesWithIntrinsicBounds(drawable1, paramDrawable2, drawable2, paramDrawable4);
    } 
  }
  
  private void a(Drawable paramDrawable, TintInfo paramTintInfo) {
    if (paramDrawable != null && paramTintInfo != null)
      AppCompatDrawableManager.a(paramDrawable, paramTintInfo, this.a.getDrawableState()); 
  }
  
  private void b(int paramInt, float paramFloat) {
    this.i.a(paramInt, paramFloat);
  }
  
  private void l() {
    TintInfo tintInfo = this.h;
    this.b = tintInfo;
    this.c = tintInfo;
    this.d = tintInfo;
    this.e = tintInfo;
    this.f = tintInfo;
    this.g = tintInfo;
  }
  
  void a() {
    b();
  }
  
  void a(int paramInt) {
    this.i.a(paramInt);
  }
  
  void a(int paramInt, float paramFloat) {
    if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && !d())
      b(paramInt, paramFloat); 
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) throws IllegalArgumentException {
    this.i.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  void a(Context paramContext, int paramInt) {
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramInt, R.styleable.TextAppearance);
    if (tintTypedArray.hasValue(R.styleable.TextAppearance_textAllCaps))
      a(tintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false)); 
    if (Build.VERSION.SDK_INT < 23 && tintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor)) {
      ColorStateList colorStateList = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
      if (colorStateList != null)
        this.a.setTextColor(colorStateList); 
    } 
    if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_textSize) && tintTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) == 0)
      this.a.setTextSize(0, 0.0F); 
    a(paramContext, tintTypedArray);
    if (Build.VERSION.SDK_INT >= 26 && tintTypedArray.hasValue(R.styleable.TextAppearance_fontVariationSettings)) {
      String str = tintTypedArray.getString(R.styleable.TextAppearance_fontVariationSettings);
      if (str != null)
        this.a.setFontVariationSettings(str); 
    } 
    tintTypedArray.recycle();
    Typeface typeface = this.l;
    if (typeface != null)
      this.a.setTypeface(typeface, this.j); 
  }
  
  void a(ColorStateList paramColorStateList) {
    boolean bool;
    if (this.h == null)
      this.h = new TintInfo(); 
    TintInfo tintInfo = this.h;
    tintInfo.mTintList = paramColorStateList;
    if (paramColorStateList != null) {
      bool = true;
    } else {
      bool = false;
    } 
    tintInfo.mHasTintList = bool;
    l();
  }
  
  void a(PorterDuff.Mode paramMode) {
    boolean bool;
    if (this.h == null)
      this.h = new TintInfo(); 
    TintInfo tintInfo = this.h;
    tintInfo.mTintMode = paramMode;
    if (paramMode != null) {
      bool = true;
    } else {
      bool = false;
    } 
    tintInfo.mHasTintMode = bool;
    l();
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt) {
    boolean bool1;
    String str1;
    ColorStateList colorStateList1;
    TintTypedArray tintTypedArray2;
    String str2;
    ColorStateList colorStateList2;
    ColorStateList colorStateList3;
    Context context = this.a.getContext();
    AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
    TintTypedArray tintTypedArray1 = TintTypedArray.obtainStyledAttributes(context, paramAttributeSet, R.styleable.AppCompatTextHelper, paramInt, 0);
    int i = tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
    if (tintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableLeft))
      this.b = a(context, appCompatDrawableManager, tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableLeft, 0)); 
    if (tintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableTop))
      this.c = a(context, appCompatDrawableManager, tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableTop, 0)); 
    if (tintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableRight))
      this.d = a(context, appCompatDrawableManager, tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableRight, 0)); 
    if (tintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableBottom))
      this.e = a(context, appCompatDrawableManager, tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableBottom, 0)); 
    if (Build.VERSION.SDK_INT >= 17) {
      if (tintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableStart))
        this.f = a(context, appCompatDrawableManager, tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableStart, 0)); 
      if (tintTypedArray1.hasValue(R.styleable.AppCompatTextHelper_android_drawableEnd))
        this.g = a(context, appCompatDrawableManager, tintTypedArray1.getResourceId(R.styleable.AppCompatTextHelper_android_drawableEnd, 0)); 
    } 
    tintTypedArray1.recycle();
    boolean bool3 = this.a.getTransformationMethod() instanceof android.text.method.PasswordTransformationMethod;
    if (i != -1) {
      TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(context, i, R.styleable.TextAppearance);
      if (!bool3 && tintTypedArray.hasValue(R.styleable.TextAppearance_textAllCaps)) {
        bool1 = tintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        i = 1;
      } else {
        i = 0;
        bool1 = false;
      } 
      a(context, tintTypedArray);
      if (Build.VERSION.SDK_INT < 23) {
        if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor)) {
          ColorStateList colorStateList = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
        } else {
          tintTypedArray1 = null;
        } 
        if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_textColorHint)) {
          colorStateList1 = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColorHint);
        } else {
          colorStateList1 = null;
        } 
        if (tintTypedArray.hasValue(R.styleable.TextAppearance_android_textColorLink)) {
          colorStateList2 = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColorLink);
          tintTypedArray2 = tintTypedArray1;
          tintTypedArray1 = (TintTypedArray)colorStateList1;
          colorStateList1 = (ColorStateList)tintTypedArray2;
        } else {
          tintTypedArray2 = tintTypedArray1;
          tintTypedArray1 = (TintTypedArray)colorStateList1;
          colorStateList1 = (ColorStateList)tintTypedArray2;
          colorStateList2 = null;
        } 
      } else {
        tintTypedArray1 = null;
        colorStateList1 = null;
        colorStateList2 = null;
      } 
      if (tintTypedArray.hasValue(R.styleable.TextAppearance_textLocale)) {
        str2 = tintTypedArray.getString(R.styleable.TextAppearance_textLocale);
      } else {
        str2 = null;
      } 
      if (Build.VERSION.SDK_INT >= 26 && tintTypedArray.hasValue(R.styleable.TextAppearance_fontVariationSettings)) {
        tintTypedArray2 = (TintTypedArray)tintTypedArray.getString(R.styleable.TextAppearance_fontVariationSettings);
      } else {
        tintTypedArray2 = null;
      } 
      tintTypedArray.recycle();
    } else {
      str2 = null;
      tintTypedArray1 = null;
      tintTypedArray2 = null;
      colorStateList1 = null;
      i = 0;
      bool1 = false;
      colorStateList2 = null;
    } 
    TintTypedArray tintTypedArray5 = TintTypedArray.obtainStyledAttributes(context, paramAttributeSet, R.styleable.TextAppearance, paramInt, 0);
    int j = i;
    boolean bool2 = bool1;
    if (!bool3) {
      j = i;
      bool2 = bool1;
      if (tintTypedArray5.hasValue(R.styleable.TextAppearance_textAllCaps)) {
        bool2 = tintTypedArray5.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        j = 1;
      } 
    } 
    TintTypedArray tintTypedArray4 = tintTypedArray1;
    ColorStateList colorStateList4 = colorStateList1;
    ColorStateList colorStateList5 = colorStateList2;
    if (Build.VERSION.SDK_INT < 23) {
      ColorStateList colorStateList;
      if (tintTypedArray5.hasValue(R.styleable.TextAppearance_android_textColor))
        colorStateList1 = tintTypedArray5.getColorStateList(R.styleable.TextAppearance_android_textColor); 
      if (tintTypedArray5.hasValue(R.styleable.TextAppearance_android_textColorHint))
        colorStateList = tintTypedArray5.getColorStateList(R.styleable.TextAppearance_android_textColorHint); 
      colorStateList3 = colorStateList;
      colorStateList4 = colorStateList1;
      colorStateList5 = colorStateList2;
      if (tintTypedArray5.hasValue(R.styleable.TextAppearance_android_textColorLink)) {
        colorStateList5 = tintTypedArray5.getColorStateList(R.styleable.TextAppearance_android_textColorLink);
        colorStateList4 = colorStateList1;
        colorStateList3 = colorStateList;
      } 
    } 
    if (tintTypedArray5.hasValue(R.styleable.TextAppearance_textLocale))
      str2 = tintTypedArray5.getString(R.styleable.TextAppearance_textLocale); 
    tintTypedArray1 = tintTypedArray2;
    if (Build.VERSION.SDK_INT >= 26) {
      tintTypedArray1 = tintTypedArray2;
      if (tintTypedArray5.hasValue(R.styleable.TextAppearance_fontVariationSettings))
        str1 = tintTypedArray5.getString(R.styleable.TextAppearance_fontVariationSettings); 
    } 
    if (Build.VERSION.SDK_INT >= 28 && tintTypedArray5.hasValue(R.styleable.TextAppearance_android_textSize) && tintTypedArray5.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) == 0)
      this.a.setTextSize(0, 0.0F); 
    a(context, tintTypedArray5);
    tintTypedArray5.recycle();
    if (colorStateList4 != null)
      this.a.setTextColor(colorStateList4); 
    if (colorStateList3 != null)
      this.a.setHintTextColor(colorStateList3); 
    if (colorStateList5 != null)
      this.a.setLinkTextColor(colorStateList5); 
    if (!bool3 && j != 0)
      a(bool2); 
    Typeface typeface = this.l;
    if (typeface != null)
      if (this.k == -1) {
        this.a.setTypeface(typeface, this.j);
      } else {
        this.a.setTypeface(typeface);
      }  
    if (str1 != null)
      this.a.setFontVariationSettings(str1); 
    if (str2 != null)
      if (Build.VERSION.SDK_INT >= 24) {
        this.a.setTextLocales(LocaleList.forLanguageTags(str2));
      } else if (Build.VERSION.SDK_INT >= 21) {
        str1 = str2.substring(0, str2.indexOf(','));
        this.a.setTextLocale(Locale.forLanguageTag(str1));
      }  
    this.i.a(paramAttributeSet, paramInt);
    if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && this.i.a() != 0) {
      int[] arrayOfInt = this.i.e();
      if (arrayOfInt.length > 0)
        if (this.a.getAutoSizeStepGranularity() != -1.0F) {
          this.a.setAutoSizeTextTypeUniformWithConfiguration(this.i.c(), this.i.d(), this.i.b(), 0);
        } else {
          this.a.setAutoSizeTextTypeUniformWithPresetSizes(arrayOfInt, 0);
        }  
    } 
    TintTypedArray tintTypedArray3 = TintTypedArray.obtainStyledAttributes(context, paramAttributeSet, R.styleable.AppCompatTextView);
    paramInt = tintTypedArray3.getResourceId(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
    if (paramInt != -1) {
      Drawable drawable = appCompatDrawableManager.getDrawable(context, paramInt);
    } else {
      paramAttributeSet = null;
    } 
    paramInt = tintTypedArray3.getResourceId(R.styleable.AppCompatTextView_drawableTopCompat, -1);
    if (paramInt != -1) {
      Drawable drawable = appCompatDrawableManager.getDrawable(context, paramInt);
    } else {
      str1 = null;
    } 
    paramInt = tintTypedArray3.getResourceId(R.styleable.AppCompatTextView_drawableRightCompat, -1);
    if (paramInt != -1) {
      Drawable drawable = appCompatDrawableManager.getDrawable(context, paramInt);
    } else {
      typeface = null;
    } 
    paramInt = tintTypedArray3.getResourceId(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
    if (paramInt != -1) {
      Drawable drawable = appCompatDrawableManager.getDrawable(context, paramInt);
    } else {
      tintTypedArray2 = null;
    } 
    paramInt = tintTypedArray3.getResourceId(R.styleable.AppCompatTextView_drawableStartCompat, -1);
    if (paramInt != -1) {
      Drawable drawable = appCompatDrawableManager.getDrawable(context, paramInt);
    } else {
      str2 = null;
    } 
    paramInt = tintTypedArray3.getResourceId(R.styleable.AppCompatTextView_drawableEndCompat, -1);
    if (paramInt != -1) {
      Drawable drawable = appCompatDrawableManager.getDrawable(context, paramInt);
    } else {
      colorStateList2 = null;
    } 
    a((Drawable)paramAttributeSet, (Drawable)str1, (Drawable)typeface, (Drawable)tintTypedArray2, (Drawable)str2, (Drawable)colorStateList2);
    if (tintTypedArray3.hasValue(R.styleable.AppCompatTextView_drawableTint)) {
      ColorStateList colorStateList = tintTypedArray3.getColorStateList(R.styleable.AppCompatTextView_drawableTint);
      TextViewCompat.setCompoundDrawableTintList(this.a, colorStateList);
    } 
    if (tintTypedArray3.hasValue(R.styleable.AppCompatTextView_drawableTintMode)) {
      PorterDuff.Mode mode = DrawableUtils.parseTintMode(tintTypedArray3.getInt(R.styleable.AppCompatTextView_drawableTintMode, -1), null);
      TextViewCompat.setCompoundDrawableTintMode(this.a, mode);
    } 
    paramInt = tintTypedArray3.getDimensionPixelSize(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
    i = tintTypedArray3.getDimensionPixelSize(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
    j = tintTypedArray3.getDimensionPixelSize(R.styleable.AppCompatTextView_lineHeight, -1);
    tintTypedArray3.recycle();
    if (paramInt != -1)
      TextViewCompat.setFirstBaselineToTopHeight(this.a, paramInt); 
    if (i != -1)
      TextViewCompat.setLastBaselineToBottomHeight(this.a, i); 
    if (j != -1)
      TextViewCompat.setLineHeight(this.a, j); 
  }
  
  void a(boolean paramBoolean) {
    this.a.setAllCaps(paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE)
      c(); 
  }
  
  void a(int[] paramArrayOfint, int paramInt) throws IllegalArgumentException {
    this.i.a(paramArrayOfint, paramInt);
  }
  
  void b() {
    if (this.b != null || this.c != null || this.d != null || this.e != null) {
      Drawable[] arrayOfDrawable = this.a.getCompoundDrawables();
      a(arrayOfDrawable[0], this.b);
      a(arrayOfDrawable[1], this.c);
      a(arrayOfDrawable[2], this.d);
      a(arrayOfDrawable[3], this.e);
    } 
    if (Build.VERSION.SDK_INT >= 17 && (this.f != null || this.g != null)) {
      Drawable[] arrayOfDrawable = this.a.getCompoundDrawablesRelative();
      a(arrayOfDrawable[0], this.f);
      a(arrayOfDrawable[2], this.g);
    } 
  }
  
  void c() {
    this.i.f();
  }
  
  boolean d() {
    return this.i.g();
  }
  
  int e() {
    return this.i.a();
  }
  
  int f() {
    return this.i.b();
  }
  
  int g() {
    return this.i.c();
  }
  
  int h() {
    return this.i.d();
  }
  
  int[] i() {
    return this.i.e();
  }
  
  ColorStateList j() {
    TintInfo tintInfo = this.h;
    return (tintInfo != null) ? tintInfo.mTintList : null;
  }
  
  PorterDuff.Mode k() {
    TintInfo tintInfo = this.h;
    return (tintInfo != null) ? tintInfo.mTintMode : null;
  }
  
  public void runOnUiThread(Runnable paramRunnable) {
    this.a.post(paramRunnable);
  }
  
  public void setTypefaceByCallback(Typeface paramTypeface) {
    if (this.m) {
      this.a.setTypeface(paramTypeface);
      this.l = paramTypeface;
    } 
  }
  
  static class ApplyTextViewCallback extends ResourcesCompat.FontCallback {
    private final WeakReference<AppCompatTextHelper> a;
    
    private final int b;
    
    private final int c;
    
    ApplyTextViewCallback(AppCompatTextHelper param1AppCompatTextHelper, int param1Int1, int param1Int2) {
      this.a = new WeakReference<AppCompatTextHelper>(param1AppCompatTextHelper);
      this.b = param1Int1;
      this.c = param1Int2;
    }
    
    public void onFontRetrievalFailed(int param1Int) {}
    
    public void onFontRetrieved(Typeface param1Typeface) {
      AppCompatTextHelper appCompatTextHelper = this.a.get();
      if (appCompatTextHelper == null)
        return; 
      Typeface typeface = param1Typeface;
      if (Build.VERSION.SDK_INT >= 28) {
        int i = this.b;
        typeface = param1Typeface;
        if (i != -1) {
          boolean bool;
          if ((this.c & 0x2) != 0) {
            bool = true;
          } else {
            bool = false;
          } 
          typeface = Typeface.create(param1Typeface, i, bool);
        } 
      } 
      appCompatTextHelper.runOnUiThread(new TypefaceApplyCallback(this, this.a, typeface));
    }
    
    class TypefaceApplyCallback implements Runnable {
      private final WeakReference<AppCompatTextHelper> b;
      
      private final Typeface c;
      
      TypefaceApplyCallback(AppCompatTextHelper.ApplyTextViewCallback this$0, WeakReference<AppCompatTextHelper> param2WeakReference, Typeface param2Typeface) {
        this.b = param2WeakReference;
        this.c = param2Typeface;
      }
      
      public void run() {
        AppCompatTextHelper appCompatTextHelper = this.b.get();
        if (appCompatTextHelper == null)
          return; 
        appCompatTextHelper.setTypefaceByCallback(this.c);
      }
    }
  }
  
  class TypefaceApplyCallback implements Runnable {
    private final WeakReference<AppCompatTextHelper> b;
    
    private final Typeface c;
    
    TypefaceApplyCallback(AppCompatTextHelper this$0, WeakReference<AppCompatTextHelper> param1WeakReference, Typeface param1Typeface) {
      this.b = param1WeakReference;
      this.c = param1Typeface;
    }
    
    public void run() {
      AppCompatTextHelper appCompatTextHelper = this.b.get();
      if (appCompatTextHelper == null)
        return; 
      appCompatTextHelper.setTypefaceByCallback(this.c);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\AppCompatTextHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */