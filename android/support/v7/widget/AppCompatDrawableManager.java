package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ContainerHelpers;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class AppCompatDrawableManager {
  private static final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
  
  private static final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED;
  
  private static final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
  
  private static final AppCompatDrawableManager$ColorFilterLruCache COLOR_FILTER_CACHE;
  
  private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
  
  private static AppCompatDrawableManager INSTANCE;
  
  private static final int[] TINT_CHECKABLE_BUTTON_LIST;
  
  private static final int[] TINT_COLOR_CONTROL_NORMAL;
  
  private static final int[] TINT_COLOR_CONTROL_STATE_LIST;
  
  private ArrayMap mDelegates;
  
  private final Object mDrawableCacheLock = new Object();
  
  private final WeakHashMap mDrawableCaches = new WeakHashMap<Object, Object>(0);
  
  private boolean mHasCheckedVectorDrawableSetup;
  
  private SparseArrayCompat mKnownDrawableIdTags;
  
  private WeakHashMap mTintLists;
  
  private TypedValue mTypedValue;
  
  static {
    COLOR_FILTER_CACHE = new AppCompatDrawableManager$ColorFilterLruCache(6);
    COLORFILTER_TINT_COLOR_CONTROL_NORMAL = new int[] { R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha };
    TINT_COLOR_CONTROL_NORMAL = new int[] { R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha };
    COLORFILTER_COLOR_CONTROL_ACTIVATED = new int[] { R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light };
    COLORFILTER_COLOR_BACKGROUND_MULTIPLY = new int[] { R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult };
    TINT_COLOR_CONTROL_STATE_LIST = new int[] { R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material };
    TINT_CHECKABLE_BUTTON_LIST = new int[] { R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material };
    throw new VerifyError("bad dex opcode");
  }
  
  private void addDelegate(String paramString, AppCompatDrawableManager$InflateDelegate paramAppCompatDrawableManager$InflateDelegate) {
    if (this.mDelegates == null)
      this.mDelegates = new ArrayMap(); 
    this.mDelegates.put(paramString, paramAppCompatDrawableManager$InflateDelegate);
  }
  
  private boolean addDrawableToCache(Context paramContext, long paramLong, Drawable paramDrawable) {
    Drawable.ConstantState constantState = paramDrawable.getConstantState();
    if (constantState != null)
      synchronized (this.mDrawableCacheLock) {
        LongSparseArray longSparseArray2 = (LongSparseArray)this.mDrawableCaches.get(paramContext);
        LongSparseArray longSparseArray1 = longSparseArray2;
        if (longSparseArray2 == null) {
          longSparseArray1 = new LongSparseArray();
          this.mDrawableCaches.put(paramContext, longSparseArray1);
        } 
        longSparseArray1.put(paramLong, new WeakReference<Drawable.ConstantState>(constantState));
        return true;
      }  
    return false;
  }
  
  private static boolean arrayContains(int[] paramArrayOfint, int paramInt) {
    int j = paramArrayOfint.length;
    for (int i = 0; i < j; i++) {
      if (paramArrayOfint[i] == paramInt)
        return true; 
    } 
    return false;
  }
  
  private static ColorStateList createButtonColorStateList(Context paramContext, int paramInt) {
    int k = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlHighlight);
    int i = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorButtonNormal);
    int[] arrayOfInt1 = ThemeUtils.DISABLED_STATE_SET;
    int[] arrayOfInt2 = ThemeUtils.PRESSED_STATE_SET;
    int j = ColorUtils.compositeColors(k, paramInt);
    int[] arrayOfInt3 = ThemeUtils.FOCUSED_STATE_SET;
    k = ColorUtils.compositeColors(k, paramInt);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, ThemeUtils.EMPTY_STATE_SET }, new int[] { i, j, k, paramInt });
  }
  
  private static long createCacheKey(TypedValue paramTypedValue) {
    return paramTypedValue.assetCookie << 32L | paramTypedValue.data;
  }
  
  public static AppCompatDrawableManager get() {
    if (INSTANCE == null) {
      AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
      INSTANCE = appCompatDrawableManager;
      if (Build.VERSION.SDK_INT < 24) {
        appCompatDrawableManager.addDelegate("vector", new AppCompatDrawableManager$VdcInflateDelegate());
        appCompatDrawableManager.addDelegate("animated-vector", new AppCompatDrawableManager$AvdcInflateDelegate());
      } 
    } 
    return INSTANCE;
  }
  
  private Drawable getCachedDrawable(Context paramContext, long paramLong) {
    synchronized (this.mDrawableCacheLock) {
      LongSparseArray longSparseArray = (LongSparseArray)this.mDrawableCaches.get(paramContext);
      if (longSparseArray == null)
        return null; 
      int i = ContainerHelpers.binarySearch(longSparseArray.mKeys, longSparseArray.mSize, paramLong);
      if (i < 0 || longSparseArray.mValues[i] == LongSparseArray.DELETED) {
        object = null;
      } else {
        object = longSparseArray.mValues[i];
      } 
      Object object = object;
      if (object != null) {
        object = object.get();
        if (object != null)
          return object.newDrawable(paramContext.getResources()); 
        i = ContainerHelpers.binarySearch(longSparseArray.mKeys, longSparseArray.mSize, paramLong);
        if (i >= 0 && longSparseArray.mValues[i] != LongSparseArray.DELETED) {
          longSparseArray.mValues[i] = LongSparseArray.DELETED;
          longSparseArray.mGarbage = true;
        } 
      } 
      return null;
    } 
  }
  
  private static PorterDuffColorFilter getPorterDuffColorFilter(int paramInt, PorterDuff.Mode paramMode) {
    PorterDuffColorFilter porterDuffColorFilter2 = (PorterDuffColorFilter)COLOR_FILTER_CACHE.get(Integer.valueOf(AppCompatDrawableManager$ColorFilterLruCache.generateCacheKey(paramInt, paramMode)));
    PorterDuffColorFilter porterDuffColorFilter1 = porterDuffColorFilter2;
    if (porterDuffColorFilter2 == null) {
      porterDuffColorFilter1 = new PorterDuffColorFilter(paramInt, paramMode);
      COLOR_FILTER_CACHE.put(Integer.valueOf(AppCompatDrawableManager$ColorFilterLruCache.generateCacheKey(paramInt, paramMode)), porterDuffColorFilter1);
    } 
    return porterDuffColorFilter1;
  }
  
  private static void setPorterDuffColorFilter(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode) {
    Drawable drawable = paramDrawable;
    if (DrawableUtils.canSafelyMutateDrawable(paramDrawable))
      drawable = paramDrawable.mutate(); 
    PorterDuff.Mode mode = paramMode;
    if (paramMode == null)
      mode = DEFAULT_MODE; 
    drawable.setColorFilter((ColorFilter)getPorterDuffColorFilter(paramInt, mode));
  }
  
  static void tintDrawable(Drawable paramDrawable, TintInfo paramTintInfo, int[] paramArrayOfint) {
    if (DrawableUtils.canSafelyMutateDrawable(paramDrawable) && paramDrawable.mutate() != paramDrawable)
      return; 
    if (paramTintInfo.mHasTintList || paramTintInfo.mHasTintMode) {
      PorterDuff.Mode mode1;
      PorterDuffColorFilter porterDuffColorFilter;
      ColorStateList colorStateList;
      boolean bool = paramTintInfo.mHasTintList;
      PorterDuff.Mode mode2 = null;
      if (bool) {
        colorStateList = paramTintInfo.mTintList;
      } else {
        colorStateList = null;
      } 
      if (paramTintInfo.mHasTintMode) {
        mode1 = paramTintInfo.mTintMode;
      } else {
        mode1 = DEFAULT_MODE;
      } 
      if (colorStateList == null || mode1 == null) {
        mode1 = mode2;
      } else {
        porterDuffColorFilter = getPorterDuffColorFilter(colorStateList.getColorForState(paramArrayOfint, 0), mode1);
      } 
      paramDrawable.setColorFilter((ColorFilter)porterDuffColorFilter);
    } else {
      paramDrawable.clearColorFilter();
    } 
    if (Build.VERSION.SDK_INT <= 23)
      paramDrawable.invalidateSelf(); 
  }
  
  static boolean tintDrawableUsingColorFilter(Context paramContext, int paramInt, Drawable paramDrawable) {
    // Byte code:
    //   0: getstatic android/support/v7/widget/AppCompatDrawableManager.DEFAULT_MODE : Landroid/graphics/PorterDuff$Mode;
    //   3: astore #6
    //   5: getstatic android/support/v7/widget/AppCompatDrawableManager.COLORFILTER_TINT_COLOR_CONTROL_NORMAL : [I
    //   8: iload_1
    //   9: invokestatic arrayContains : ([II)Z
    //   12: istore #5
    //   14: ldc_w 16842801
    //   17: istore_3
    //   18: iload #5
    //   20: ifeq -> 35
    //   23: getstatic android/support/v7/appcompat/R$attr.colorControlNormal : I
    //   26: istore_1
    //   27: iconst_1
    //   28: istore #4
    //   30: iconst_m1
    //   31: istore_3
    //   32: goto -> 115
    //   35: getstatic android/support/v7/widget/AppCompatDrawableManager.COLORFILTER_COLOR_CONTROL_ACTIVATED : [I
    //   38: iload_1
    //   39: invokestatic arrayContains : ([II)Z
    //   42: ifeq -> 52
    //   45: getstatic android/support/v7/appcompat/R$attr.colorControlActivated : I
    //   48: istore_1
    //   49: goto -> 27
    //   52: getstatic android/support/v7/widget/AppCompatDrawableManager.COLORFILTER_COLOR_BACKGROUND_MULTIPLY : [I
    //   55: iload_1
    //   56: invokestatic arrayContains : ([II)Z
    //   59: ifeq -> 72
    //   62: getstatic android/graphics/PorterDuff$Mode.MULTIPLY : Landroid/graphics/PorterDuff$Mode;
    //   65: astore #6
    //   67: iload_3
    //   68: istore_1
    //   69: goto -> 27
    //   72: iload_1
    //   73: getstatic android/support/v7/appcompat/R$drawable.abc_list_divider_mtrl_alpha : I
    //   76: if_icmpne -> 96
    //   79: ldc_w 16842800
    //   82: istore_1
    //   83: ldc_w 40.8
    //   86: invokestatic round : (F)I
    //   89: istore_3
    //   90: iconst_1
    //   91: istore #4
    //   93: goto -> 115
    //   96: iload_1
    //   97: getstatic android/support/v7/appcompat/R$drawable.abc_dialog_material_background : I
    //   100: if_icmpne -> 108
    //   103: iload_3
    //   104: istore_1
    //   105: goto -> 27
    //   108: iconst_0
    //   109: istore #4
    //   111: iconst_m1
    //   112: istore_3
    //   113: iconst_0
    //   114: istore_1
    //   115: iload #4
    //   117: ifeq -> 164
    //   120: aload_2
    //   121: astore #7
    //   123: aload_2
    //   124: invokestatic canSafelyMutateDrawable : (Landroid/graphics/drawable/Drawable;)Z
    //   127: ifeq -> 136
    //   130: aload_2
    //   131: invokevirtual mutate : ()Landroid/graphics/drawable/Drawable;
    //   134: astore #7
    //   136: aload #7
    //   138: aload_0
    //   139: iload_1
    //   140: invokestatic getThemeAttrColor : (Landroid/content/Context;I)I
    //   143: aload #6
    //   145: invokestatic getPorterDuffColorFilter : (ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuffColorFilter;
    //   148: invokevirtual setColorFilter : (Landroid/graphics/ColorFilter;)V
    //   151: iload_3
    //   152: iconst_m1
    //   153: if_icmpeq -> 162
    //   156: aload #7
    //   158: iload_3
    //   159: invokevirtual setAlpha : (I)V
    //   162: iconst_1
    //   163: ireturn
    //   164: iconst_0
    //   165: ireturn
  }
  
  public final Drawable getDrawable(Context paramContext, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mHasCheckedVectorDrawableSetup : Z
    //   4: ifne -> 85
    //   7: aload_0
    //   8: iconst_1
    //   9: putfield mHasCheckedVectorDrawableSetup : Z
    //   12: aload_0
    //   13: aload_1
    //   14: getstatic android/support/v7/appcompat/R$drawable.abc_vector_test : I
    //   17: invokevirtual getDrawable : (Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   20: astore #6
    //   22: aload #6
    //   24: ifnull -> 69
    //   27: aload #6
    //   29: instanceof android/support/graphics/drawable/VectorDrawableCompat
    //   32: ifne -> 60
    //   35: ldc_w 'android.graphics.drawable.VectorDrawable'
    //   38: aload #6
    //   40: invokevirtual getClass : ()Ljava/lang/Class;
    //   43: invokevirtual getName : ()Ljava/lang/String;
    //   46: invokevirtual equals : (Ljava/lang/Object;)Z
    //   49: ifeq -> 55
    //   52: goto -> 60
    //   55: iconst_0
    //   56: istore_3
    //   57: goto -> 62
    //   60: iconst_1
    //   61: istore_3
    //   62: iload_3
    //   63: ifeq -> 69
    //   66: goto -> 85
    //   69: aload_0
    //   70: iconst_0
    //   71: putfield mHasCheckedVectorDrawableSetup : Z
    //   74: new java/lang/IllegalStateException
    //   77: dup
    //   78: ldc_w 'This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.'
    //   81: invokespecial <init> : (Ljava/lang/String;)V
    //   84: athrow
    //   85: aload_0
    //   86: aload_1
    //   87: iload_2
    //   88: invokevirtual loadDrawableFromDelegates : (Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   91: astore #7
    //   93: aload #7
    //   95: astore #6
    //   97: aload #7
    //   99: ifnonnull -> 237
    //   102: aload_0
    //   103: getfield mTypedValue : Landroid/util/TypedValue;
    //   106: ifnonnull -> 120
    //   109: aload_0
    //   110: new android/util/TypedValue
    //   113: dup
    //   114: invokespecial <init> : ()V
    //   117: putfield mTypedValue : Landroid/util/TypedValue;
    //   120: aload_0
    //   121: getfield mTypedValue : Landroid/util/TypedValue;
    //   124: astore #8
    //   126: aload_1
    //   127: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   130: iload_2
    //   131: aload #8
    //   133: iconst_1
    //   134: invokevirtual getValue : (ILandroid/util/TypedValue;Z)V
    //   137: aload #8
    //   139: invokestatic createCacheKey : (Landroid/util/TypedValue;)J
    //   142: lstore #4
    //   144: aload_0
    //   145: aload_1
    //   146: lload #4
    //   148: invokespecial getCachedDrawable : (Landroid/content/Context;J)Landroid/graphics/drawable/Drawable;
    //   151: astore #7
    //   153: aload #7
    //   155: astore #6
    //   157: aload #7
    //   159: ifnonnull -> 237
    //   162: iload_2
    //   163: getstatic android/support/v7/appcompat/R$drawable.abc_cab_background_top_material : I
    //   166: if_icmpne -> 204
    //   169: new android/graphics/drawable/LayerDrawable
    //   172: dup
    //   173: iconst_2
    //   174: anewarray android/graphics/drawable/Drawable
    //   177: dup
    //   178: iconst_0
    //   179: aload_0
    //   180: aload_1
    //   181: getstatic android/support/v7/appcompat/R$drawable.abc_cab_background_internal_bg : I
    //   184: invokevirtual getDrawable : (Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   187: aastore
    //   188: dup
    //   189: iconst_1
    //   190: aload_0
    //   191: aload_1
    //   192: getstatic android/support/v7/appcompat/R$drawable.abc_cab_background_top_mtrl_alpha : I
    //   195: invokevirtual getDrawable : (Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   198: aastore
    //   199: invokespecial <init> : ([Landroid/graphics/drawable/Drawable;)V
    //   202: astore #7
    //   204: aload #7
    //   206: astore #6
    //   208: aload #7
    //   210: ifnull -> 237
    //   213: aload #7
    //   215: aload #8
    //   217: getfield changingConfigurations : I
    //   220: invokevirtual setChangingConfigurations : (I)V
    //   223: aload_0
    //   224: aload_1
    //   225: lload #4
    //   227: aload #7
    //   229: invokespecial addDrawableToCache : (Landroid/content/Context;JLandroid/graphics/drawable/Drawable;)Z
    //   232: pop
    //   233: aload #7
    //   235: astore #6
    //   237: aload #6
    //   239: astore #7
    //   241: aload #6
    //   243: ifnonnull -> 253
    //   246: aload_1
    //   247: iload_2
    //   248: invokestatic getDrawable : (Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   251: astore #7
    //   253: aload #7
    //   255: astore #6
    //   257: aload #7
    //   259: ifnull -> 273
    //   262: aload_0
    //   263: aload_1
    //   264: iload_2
    //   265: iconst_0
    //   266: aload #7
    //   268: invokevirtual tintDrawable : (Landroid/content/Context;IZLandroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    //   271: astore #6
    //   273: aload #6
    //   275: ifnull -> 283
    //   278: aload #6
    //   280: invokestatic fixDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   283: aload #6
    //   285: areturn
  }
  
  final ColorStateList getTintList(Context paramContext, int paramInt) {
    WeakHashMap weakHashMap = this.mTintLists;
    ColorStateList colorStateList1 = null;
    if (weakHashMap != null) {
      SparseArrayCompat sparseArrayCompat = (SparseArrayCompat)this.mTintLists.get(paramContext);
      if (sparseArrayCompat != null)
        colorStateList1 = (ColorStateList)sparseArrayCompat.get(paramInt); 
    } 
    ColorStateList colorStateList2 = colorStateList1;
    if (colorStateList1 == null) {
      if (paramInt == R.drawable.abc_edit_text_material) {
        colorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_edittext);
      } else if (paramInt == R.drawable.abc_switch_track_mtrl_alpha) {
        colorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_switch_track);
      } else if (paramInt == R.drawable.abc_switch_thumb_material) {
        int[][] arrayOfInt = new int[3][];
        int[] arrayOfInt1 = new int[3];
        ColorStateList colorStateList4 = ThemeUtils.getThemeAttrColorStateList(paramContext, R.attr.colorSwitchThumbNormal);
        if (colorStateList4 != null && colorStateList4.isStateful()) {
          arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
          arrayOfInt1[0] = colorStateList4.getColorForState(arrayOfInt[0], 0);
          arrayOfInt[1] = ThemeUtils.CHECKED_STATE_SET;
          arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
          arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
          arrayOfInt1[2] = colorStateList4.getDefaultColor();
        } else {
          arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
          arrayOfInt1[0] = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorSwitchThumbNormal);
          arrayOfInt[1] = ThemeUtils.CHECKED_STATE_SET;
          arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
          arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
          arrayOfInt1[2] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorSwitchThumbNormal);
        } 
        ColorStateList colorStateList3 = new ColorStateList(arrayOfInt, arrayOfInt1);
      } else if (paramInt == R.drawable.abc_btn_default_mtrl_shape) {
        colorStateList1 = createButtonColorStateList(paramContext, ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorButtonNormal));
      } else if (paramInt == R.drawable.abc_btn_borderless_material) {
        colorStateList1 = createButtonColorStateList(paramContext, 0);
      } else if (paramInt == R.drawable.abc_btn_colored_material) {
        colorStateList1 = createButtonColorStateList(paramContext, ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorAccent));
      } else if (paramInt == R.drawable.abc_spinner_mtrl_am_alpha || paramInt == R.drawable.abc_spinner_textfield_background_material) {
        colorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_spinner);
      } else if (arrayContains(TINT_COLOR_CONTROL_NORMAL, paramInt)) {
        colorStateList1 = ThemeUtils.getThemeAttrColorStateList(paramContext, R.attr.colorControlNormal);
      } else if (arrayContains(TINT_COLOR_CONTROL_STATE_LIST, paramInt)) {
        colorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_default);
      } else if (arrayContains(TINT_CHECKABLE_BUTTON_LIST, paramInt)) {
        colorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_btn_checkable);
      } else if (paramInt == R.drawable.abc_seekbar_thumb_material) {
        colorStateList1 = AppCompatResources.getColorStateList(paramContext, R.color.abc_tint_seek_thumb);
      } 
      colorStateList2 = colorStateList1;
      if (colorStateList1 != null) {
        if (this.mTintLists == null)
          this.mTintLists = new WeakHashMap<Object, Object>(); 
        SparseArrayCompat sparseArrayCompat2 = (SparseArrayCompat)this.mTintLists.get(paramContext);
        SparseArrayCompat sparseArrayCompat1 = sparseArrayCompat2;
        if (sparseArrayCompat2 == null) {
          sparseArrayCompat1 = new SparseArrayCompat();
          this.mTintLists.put(paramContext, sparseArrayCompat1);
        } 
        sparseArrayCompat1.append(paramInt, colorStateList1);
        colorStateList2 = colorStateList1;
      } 
    } 
    return colorStateList2;
  }
  
  final Drawable loadDrawableFromDelegates(Context paramContext, int paramInt) {
    if (this.mDelegates != null && !this.mDelegates.isEmpty()) {
      if (this.mKnownDrawableIdTags != null) {
        String str = (String)this.mKnownDrawableIdTags.get(paramInt);
        if (!"appcompat_skip_skip".equals(str)) {
          if (str != null && this.mDelegates.get(str) == null)
            return null; 
        } else {
          return null;
        } 
      } else {
        this.mKnownDrawableIdTags = new SparseArrayCompat();
      } 
      if (this.mTypedValue == null)
        this.mTypedValue = new TypedValue(); 
      TypedValue typedValue = this.mTypedValue;
      Resources resources = paramContext.getResources();
      resources.getValue(paramInt, typedValue, true);
      long l = createCacheKey(typedValue);
      Drawable drawable2 = getCachedDrawable(paramContext, l);
      if (drawable2 != null)
        return drawable2; 
      Drawable drawable1 = drawable2;
      if (typedValue.string != null) {
        drawable1 = drawable2;
        if (typedValue.string.toString().endsWith(".xml")) {
          Drawable drawable = drawable2;
          try {
            int i;
            XmlResourceParser xmlResourceParser = resources.getXml(paramInt);
            drawable = drawable2;
            AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
            do {
              drawable = drawable2;
              i = xmlResourceParser.next();
            } while (i != 2 && i != 1);
            if (i == 2) {
              drawable = drawable2;
              String str = xmlResourceParser.getName();
              drawable = drawable2;
              this.mKnownDrawableIdTags.append(paramInt, str);
              drawable = drawable2;
              AppCompatDrawableManager$InflateDelegate appCompatDrawableManager$InflateDelegate = (AppCompatDrawableManager$InflateDelegate)this.mDelegates.get(str);
              Drawable drawable3 = drawable2;
              if (appCompatDrawableManager$InflateDelegate != null) {
                drawable = drawable2;
                drawable3 = appCompatDrawableManager$InflateDelegate.createFromXmlInner(paramContext, (XmlPullParser)xmlResourceParser, attributeSet, paramContext.getTheme());
              } 
              if (drawable3 != null) {
                drawable = drawable3;
                drawable3.setChangingConfigurations(typedValue.changingConfigurations);
                drawable = drawable3;
                addDrawableToCache(paramContext, l, drawable3);
              } 
            } else {
              drawable = drawable2;
              throw new XmlPullParserException("No start tag found");
            } 
          } catch (Exception exception) {
            Log.e("AppCompatDrawableManag", "Exception while inflating drawable", exception);
            drawable1 = drawable;
          } 
        } 
      } 
      if (drawable1 == null)
        this.mKnownDrawableIdTags.append(paramInt, "appcompat_skip_skip"); 
      return drawable1;
    } 
    return null;
  }
  
  final Drawable tintDrawable(Context paramContext, int paramInt, boolean paramBoolean, Drawable paramDrawable) {
    PorterDuff.Mode mode;
    ColorStateList colorStateList = getTintList(paramContext, paramInt);
    Drawable drawable = null;
    if (colorStateList != null) {
      Drawable drawable1 = paramDrawable;
      if (DrawableUtils.canSafelyMutateDrawable(paramDrawable))
        drawable1 = paramDrawable.mutate(); 
      paramDrawable = DrawableCompat.wrap(drawable1);
      DrawableCompat.setTintList(paramDrawable, colorStateList);
      drawable1 = drawable;
      if (paramInt == R.drawable.abc_switch_thumb_material)
        mode = PorterDuff.Mode.MULTIPLY; 
      if (mode != null)
        DrawableCompat.setTintMode(paramDrawable, mode); 
      return paramDrawable;
    } 
    if (paramInt == R.drawable.abc_seekbar_track_material) {
      LayerDrawable layerDrawable = (LayerDrawable)paramDrawable;
      setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor((Context)mode, R.attr.colorControlNormal), DEFAULT_MODE);
      setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor((Context)mode, R.attr.colorControlNormal), DEFAULT_MODE);
      setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor((Context)mode, R.attr.colorControlActivated), DEFAULT_MODE);
      return paramDrawable;
    } 
    if (paramInt == R.drawable.abc_ratingbar_material || paramInt == R.drawable.abc_ratingbar_indicator_material || paramInt == R.drawable.abc_ratingbar_small_material) {
      LayerDrawable layerDrawable = (LayerDrawable)paramDrawable;
      setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor((Context)mode, R.attr.colorControlNormal), DEFAULT_MODE);
      setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor((Context)mode, R.attr.colorControlActivated), DEFAULT_MODE);
      setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor((Context)mode, R.attr.colorControlActivated), DEFAULT_MODE);
      return paramDrawable;
    } 
    return (!tintDrawableUsingColorFilter((Context)mode, paramInt, paramDrawable) && paramBoolean) ? null : paramDrawable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\AppCompatDrawableManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */