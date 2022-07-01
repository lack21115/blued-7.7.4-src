package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;

public class SwitchCompat extends CompoundButton {
  private static final int[] O;
  
  private static final Property<SwitchCompat, Float> c = new Property<SwitchCompat, Float>(Float.class, "thumbPos") {
      public Float get(SwitchCompat param1SwitchCompat) {
        return Float.valueOf(param1SwitchCompat.a);
      }
      
      public void set(SwitchCompat param1SwitchCompat, Float param1Float) {
        param1SwitchCompat.setThumbPosition(param1Float.floatValue());
      }
    };
  
  private int A;
  
  private int B;
  
  private int C;
  
  private int D;
  
  private int E;
  
  private int F;
  
  private int G;
  
  private final TextPaint H = new TextPaint(1);
  
  private ColorStateList I;
  
  private Layout J;
  
  private Layout K;
  
  private TransformationMethod L;
  
  private final AppCompatTextHelper M;
  
  private final Rect N = new Rect();
  
  float a;
  
  ObjectAnimator b;
  
  private Drawable d;
  
  private ColorStateList e = null;
  
  private PorterDuff.Mode f = null;
  
  private boolean g = false;
  
  private boolean h = false;
  
  private Drawable i;
  
  private ColorStateList j = null;
  
  private PorterDuff.Mode k = null;
  
  private boolean l = false;
  
  private boolean m = false;
  
  private int n;
  
  private int o;
  
  private int p;
  
  private boolean q;
  
  private CharSequence r;
  
  private CharSequence s;
  
  private boolean t;
  
  private int u;
  
  private int v;
  
  private float w;
  
  private float x;
  
  private VelocityTracker y = VelocityTracker.obtain();
  
  private int z;
  
  static {
    O = new int[] { 16842912 };
  }
  
  public SwitchCompat(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.switchStyle);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    Resources resources = getResources();
    this.H.density = (resources.getDisplayMetrics()).density;
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.SwitchCompat, paramInt, 0);
    this.d = tintTypedArray.getDrawable(R.styleable.SwitchCompat_android_thumb);
    Drawable drawable = this.d;
    if (drawable != null)
      drawable.setCallback((Drawable.Callback)this); 
    this.i = tintTypedArray.getDrawable(R.styleable.SwitchCompat_track);
    drawable = this.i;
    if (drawable != null)
      drawable.setCallback((Drawable.Callback)this); 
    this.r = tintTypedArray.getText(R.styleable.SwitchCompat_android_textOn);
    this.s = tintTypedArray.getText(R.styleable.SwitchCompat_android_textOff);
    this.t = tintTypedArray.getBoolean(R.styleable.SwitchCompat_showText, true);
    this.n = tintTypedArray.getDimensionPixelSize(R.styleable.SwitchCompat_thumbTextPadding, 0);
    this.o = tintTypedArray.getDimensionPixelSize(R.styleable.SwitchCompat_switchMinWidth, 0);
    this.p = tintTypedArray.getDimensionPixelSize(R.styleable.SwitchCompat_switchPadding, 0);
    this.q = tintTypedArray.getBoolean(R.styleable.SwitchCompat_splitTrack, false);
    ColorStateList colorStateList2 = tintTypedArray.getColorStateList(R.styleable.SwitchCompat_thumbTint);
    if (colorStateList2 != null) {
      this.e = colorStateList2;
      this.g = true;
    } 
    PorterDuff.Mode mode2 = DrawableUtils.parseTintMode(tintTypedArray.getInt(R.styleable.SwitchCompat_thumbTintMode, -1), null);
    if (this.f != mode2) {
      this.f = mode2;
      this.h = true;
    } 
    if (this.g || this.h)
      b(); 
    ColorStateList colorStateList1 = tintTypedArray.getColorStateList(R.styleable.SwitchCompat_trackTint);
    if (colorStateList1 != null) {
      this.j = colorStateList1;
      this.l = true;
    } 
    PorterDuff.Mode mode1 = DrawableUtils.parseTintMode(tintTypedArray.getInt(R.styleable.SwitchCompat_trackTintMode, -1), null);
    if (this.k != mode1) {
      this.k = mode1;
      this.m = true;
    } 
    if (this.l || this.m)
      a(); 
    int i = tintTypedArray.getResourceId(R.styleable.SwitchCompat_switchTextAppearance, 0);
    if (i != 0)
      setSwitchTextAppearance(paramContext, i); 
    this.M = new AppCompatTextHelper((TextView)this);
    this.M.a(paramAttributeSet, paramInt);
    tintTypedArray.recycle();
    ViewConfiguration viewConfiguration = ViewConfiguration.get(paramContext);
    this.v = viewConfiguration.getScaledTouchSlop();
    this.z = viewConfiguration.getScaledMinimumFlingVelocity();
    refreshDrawableState();
    setChecked(isChecked());
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3) {
    if (paramFloat1 < paramFloat2)
      return paramFloat2; 
    paramFloat2 = paramFloat1;
    if (paramFloat1 > paramFloat3)
      paramFloat2 = paramFloat3; 
    return paramFloat2;
  }
  
  private Layout a(CharSequence paramCharSequence) {
    boolean bool;
    TransformationMethod transformationMethod = this.L;
    CharSequence charSequence = paramCharSequence;
    if (transformationMethod != null)
      charSequence = transformationMethod.getTransformation(paramCharSequence, (View)this); 
    TextPaint textPaint = this.H;
    if (charSequence != null) {
      bool = (int)Math.ceil(Layout.getDesiredWidth(charSequence, textPaint));
    } else {
      bool = false;
    } 
    return (Layout)new StaticLayout(charSequence, textPaint, bool, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
  }
  
  private void a() {
    if (this.i != null && (this.l || this.m)) {
      this.i = DrawableCompat.wrap(this.i).mutate();
      if (this.l)
        DrawableCompat.setTintList(this.i, this.j); 
      if (this.m)
        DrawableCompat.setTintMode(this.i, this.k); 
      if (this.i.isStateful())
        this.i.setState(getDrawableState()); 
    } 
  }
  
  private void a(int paramInt1, int paramInt2) {
    Typeface typeface;
    if (paramInt1 != 1) {
      if (paramInt1 != 2) {
        if (paramInt1 != 3) {
          typeface = null;
        } else {
          typeface = Typeface.MONOSPACE;
        } 
      } else {
        typeface = Typeface.SERIF;
      } 
    } else {
      typeface = Typeface.SANS_SERIF;
    } 
    setSwitchTypeface(typeface, paramInt2);
  }
  
  private void a(MotionEvent paramMotionEvent) {
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(3);
    super.onTouchEvent(paramMotionEvent);
    paramMotionEvent.recycle();
  }
  
  private void a(boolean paramBoolean) {
    float f;
    if (paramBoolean) {
      f = 1.0F;
    } else {
      f = 0.0F;
    } 
    this.b = ObjectAnimator.ofFloat(this, c, new float[] { f });
    this.b.setDuration(250L);
    if (Build.VERSION.SDK_INT >= 18)
      this.b.setAutoCancel(true); 
    this.b.start();
  }
  
  private boolean a(float paramFloat1, float paramFloat2) {
    Drawable drawable = this.d;
    boolean bool2 = false;
    if (drawable == null)
      return false; 
    int k = getThumbOffset();
    this.d.getPadding(this.N);
    int i = this.E;
    int j = this.v;
    k = this.D + k - j;
    int m = this.C;
    int n = this.N.left;
    int i1 = this.N.right;
    int i2 = this.v;
    int i3 = this.G;
    boolean bool1 = bool2;
    if (paramFloat1 > k) {
      bool1 = bool2;
      if (paramFloat1 < (m + k + n + i1 + i2)) {
        bool1 = bool2;
        if (paramFloat2 > (i - j)) {
          bool1 = bool2;
          if (paramFloat2 < (i3 + i2))
            bool1 = true; 
        } 
      } 
    } 
    return bool1;
  }
  
  private void b() {
    if (this.d != null && (this.g || this.h)) {
      this.d = DrawableCompat.wrap(this.d).mutate();
      if (this.g)
        DrawableCompat.setTintList(this.d, this.e); 
      if (this.h)
        DrawableCompat.setTintMode(this.d, this.f); 
      if (this.d.isStateful())
        this.d.setState(getDrawableState()); 
    } 
  }
  
  private void b(MotionEvent paramMotionEvent) {
    this.u = 0;
    int i = paramMotionEvent.getAction();
    boolean bool1 = true;
    if (i == 1 && isEnabled()) {
      i = 1;
    } else {
      i = 0;
    } 
    boolean bool2 = isChecked();
    if (i != 0) {
      this.y.computeCurrentVelocity(1000);
      float f = this.y.getXVelocity();
      if (Math.abs(f) > this.z) {
        if (ViewUtils.isLayoutRtl((View)this) ? (f < 0.0F) : (f > 0.0F))
          bool1 = false; 
      } else {
        bool1 = getTargetCheckedState();
      } 
    } else {
      bool1 = bool2;
    } 
    if (bool1 != bool2)
      playSoundEffect(0); 
    setChecked(bool1);
    a(paramMotionEvent);
  }
  
  private void c() {
    ObjectAnimator objectAnimator = this.b;
    if (objectAnimator != null)
      objectAnimator.cancel(); 
  }
  
  private boolean getTargetCheckedState() {
    return (this.a > 0.5F);
  }
  
  private int getThumbOffset() {
    float f;
    if (ViewUtils.isLayoutRtl((View)this)) {
      f = 1.0F - this.a;
    } else {
      f = this.a;
    } 
    return (int)(f * getThumbScrollRange() + 0.5F);
  }
  
  private int getThumbScrollRange() {
    Drawable drawable = this.i;
    if (drawable != null) {
      Rect rect1;
      Rect rect2 = this.N;
      drawable.getPadding(rect2);
      drawable = this.d;
      if (drawable != null) {
        rect1 = DrawableUtils.getOpticalBounds(drawable);
      } else {
        rect1 = DrawableUtils.INSETS_NONE;
      } 
      return this.A - this.C - rect2.left - rect2.right - rect1.left - rect1.right;
    } 
    return 0;
  }
  
  public void draw(Canvas paramCanvas) {
    // Byte code:
    //   0: aload_0
    //   1: getfield N : Landroid/graphics/Rect;
    //   4: astore #12
    //   6: aload_0
    //   7: getfield D : I
    //   10: istore #5
    //   12: aload_0
    //   13: getfield E : I
    //   16: istore #8
    //   18: aload_0
    //   19: getfield F : I
    //   22: istore #6
    //   24: aload_0
    //   25: getfield G : I
    //   28: istore #9
    //   30: aload_0
    //   31: invokespecial getThumbOffset : ()I
    //   34: iload #5
    //   36: iadd
    //   37: istore_3
    //   38: aload_0
    //   39: getfield d : Landroid/graphics/drawable/Drawable;
    //   42: astore #11
    //   44: aload #11
    //   46: ifnull -> 59
    //   49: aload #11
    //   51: invokestatic getOpticalBounds : (Landroid/graphics/drawable/Drawable;)Landroid/graphics/Rect;
    //   54: astore #11
    //   56: goto -> 64
    //   59: getstatic androidx/appcompat/widget/DrawableUtils.INSETS_NONE : Landroid/graphics/Rect;
    //   62: astore #11
    //   64: aload_0
    //   65: getfield i : Landroid/graphics/drawable/Drawable;
    //   68: astore #13
    //   70: iload_3
    //   71: istore_2
    //   72: aload #13
    //   74: ifnull -> 275
    //   77: aload #13
    //   79: aload #12
    //   81: invokevirtual getPadding : (Landroid/graphics/Rect;)Z
    //   84: pop
    //   85: iload_3
    //   86: aload #12
    //   88: getfield left : I
    //   91: iadd
    //   92: istore #10
    //   94: aload #11
    //   96: ifnull -> 239
    //   99: iload #5
    //   101: istore_2
    //   102: aload #11
    //   104: getfield left : I
    //   107: aload #12
    //   109: getfield left : I
    //   112: if_icmple -> 130
    //   115: iload #5
    //   117: aload #11
    //   119: getfield left : I
    //   122: aload #12
    //   124: getfield left : I
    //   127: isub
    //   128: iadd
    //   129: istore_2
    //   130: aload #11
    //   132: getfield top : I
    //   135: aload #12
    //   137: getfield top : I
    //   140: if_icmple -> 161
    //   143: aload #11
    //   145: getfield top : I
    //   148: aload #12
    //   150: getfield top : I
    //   153: isub
    //   154: iload #8
    //   156: iadd
    //   157: istore_3
    //   158: goto -> 164
    //   161: iload #8
    //   163: istore_3
    //   164: iload #6
    //   166: istore #4
    //   168: aload #11
    //   170: getfield right : I
    //   173: aload #12
    //   175: getfield right : I
    //   178: if_icmple -> 197
    //   181: iload #6
    //   183: aload #11
    //   185: getfield right : I
    //   188: aload #12
    //   190: getfield right : I
    //   193: isub
    //   194: isub
    //   195: istore #4
    //   197: iload_2
    //   198: istore #5
    //   200: iload #4
    //   202: istore #6
    //   204: iload_3
    //   205: istore #7
    //   207: aload #11
    //   209: getfield bottom : I
    //   212: aload #12
    //   214: getfield bottom : I
    //   217: if_icmple -> 243
    //   220: iload #9
    //   222: aload #11
    //   224: getfield bottom : I
    //   227: aload #12
    //   229: getfield bottom : I
    //   232: isub
    //   233: isub
    //   234: istore #7
    //   236: goto -> 259
    //   239: iload #8
    //   241: istore #7
    //   243: iload #9
    //   245: istore_2
    //   246: iload #7
    //   248: istore_3
    //   249: iload_2
    //   250: istore #7
    //   252: iload #6
    //   254: istore #4
    //   256: iload #5
    //   258: istore_2
    //   259: aload_0
    //   260: getfield i : Landroid/graphics/drawable/Drawable;
    //   263: iload_2
    //   264: iload_3
    //   265: iload #4
    //   267: iload #7
    //   269: invokevirtual setBounds : (IIII)V
    //   272: iload #10
    //   274: istore_2
    //   275: aload_0
    //   276: getfield d : Landroid/graphics/drawable/Drawable;
    //   279: astore #11
    //   281: aload #11
    //   283: ifnull -> 350
    //   286: aload #11
    //   288: aload #12
    //   290: invokevirtual getPadding : (Landroid/graphics/Rect;)Z
    //   293: pop
    //   294: iload_2
    //   295: aload #12
    //   297: getfield left : I
    //   300: isub
    //   301: istore_3
    //   302: iload_2
    //   303: aload_0
    //   304: getfield C : I
    //   307: iadd
    //   308: aload #12
    //   310: getfield right : I
    //   313: iadd
    //   314: istore_2
    //   315: aload_0
    //   316: getfield d : Landroid/graphics/drawable/Drawable;
    //   319: iload_3
    //   320: iload #8
    //   322: iload_2
    //   323: iload #9
    //   325: invokevirtual setBounds : (IIII)V
    //   328: aload_0
    //   329: invokevirtual getBackground : ()Landroid/graphics/drawable/Drawable;
    //   332: astore #11
    //   334: aload #11
    //   336: ifnull -> 350
    //   339: aload #11
    //   341: iload_3
    //   342: iload #8
    //   344: iload_2
    //   345: iload #9
    //   347: invokestatic setHotspotBounds : (Landroid/graphics/drawable/Drawable;IIII)V
    //   350: aload_0
    //   351: aload_1
    //   352: invokespecial draw : (Landroid/graphics/Canvas;)V
    //   355: return
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2) {
    if (Build.VERSION.SDK_INT >= 21)
      super.drawableHotspotChanged(paramFloat1, paramFloat2); 
    Drawable drawable = this.d;
    if (drawable != null)
      DrawableCompat.setHotspot(drawable, paramFloat1, paramFloat2); 
    drawable = this.i;
    if (drawable != null)
      DrawableCompat.setHotspot(drawable, paramFloat1, paramFloat2); 
  }
  
  protected void drawableStateChanged() {
    boolean bool;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable drawable = this.d;
    int j = 0;
    int i = j;
    if (drawable != null) {
      i = j;
      if (drawable.isStateful())
        i = false | drawable.setState(arrayOfInt); 
    } 
    drawable = this.i;
    j = i;
    if (drawable != null) {
      j = i;
      if (drawable.isStateful())
        bool = i | drawable.setState(arrayOfInt); 
    } 
    if (bool)
      invalidate(); 
  }
  
  public int getCompoundPaddingLeft() {
    if (!ViewUtils.isLayoutRtl((View)this))
      return super.getCompoundPaddingLeft(); 
    int j = super.getCompoundPaddingLeft() + this.A;
    int i = j;
    if (!TextUtils.isEmpty(getText()))
      i = j + this.p; 
    return i;
  }
  
  public int getCompoundPaddingRight() {
    if (ViewUtils.isLayoutRtl((View)this))
      return super.getCompoundPaddingRight(); 
    int j = super.getCompoundPaddingRight() + this.A;
    int i = j;
    if (!TextUtils.isEmpty(getText()))
      i = j + this.p; 
    return i;
  }
  
  public boolean getShowText() {
    return this.t;
  }
  
  public boolean getSplitTrack() {
    return this.q;
  }
  
  public int getSwitchMinWidth() {
    return this.o;
  }
  
  public int getSwitchPadding() {
    return this.p;
  }
  
  public CharSequence getTextOff() {
    return this.s;
  }
  
  public CharSequence getTextOn() {
    return this.r;
  }
  
  public Drawable getThumbDrawable() {
    return this.d;
  }
  
  public int getThumbTextPadding() {
    return this.n;
  }
  
  public ColorStateList getThumbTintList() {
    return this.e;
  }
  
  public PorterDuff.Mode getThumbTintMode() {
    return this.f;
  }
  
  public Drawable getTrackDrawable() {
    return this.i;
  }
  
  public ColorStateList getTrackTintList() {
    return this.j;
  }
  
  public PorterDuff.Mode getTrackTintMode() {
    return this.k;
  }
  
  public void jumpDrawablesToCurrentState() {
    super.jumpDrawablesToCurrentState();
    Drawable drawable = this.d;
    if (drawable != null)
      drawable.jumpToCurrentState(); 
    drawable = this.i;
    if (drawable != null)
      drawable.jumpToCurrentState(); 
    ObjectAnimator objectAnimator = this.b;
    if (objectAnimator != null && objectAnimator.isStarted()) {
      this.b.end();
      this.b = null;
    } 
  }
  
  protected int[] onCreateDrawableState(int paramInt) {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked())
      mergeDrawableStates(arrayOfInt, O); 
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    Layout layout;
    super.onDraw(paramCanvas);
    Rect rect = this.N;
    Drawable drawable2 = this.i;
    if (drawable2 != null) {
      drawable2.getPadding(rect);
    } else {
      rect.setEmpty();
    } 
    int j = this.E;
    int k = this.G;
    int m = rect.top;
    int n = rect.bottom;
    Drawable drawable1 = this.d;
    if (drawable2 != null)
      if (this.q && drawable1 != null) {
        Rect rect1 = DrawableUtils.getOpticalBounds(drawable1);
        drawable1.copyBounds(rect);
        rect.left += rect1.left;
        rect.right -= rect1.right;
        int i1 = paramCanvas.save();
        paramCanvas.clipRect(rect, Region.Op.DIFFERENCE);
        drawable2.draw(paramCanvas);
        paramCanvas.restoreToCount(i1);
      } else {
        drawable2.draw(paramCanvas);
      }  
    int i = paramCanvas.save();
    if (drawable1 != null)
      drawable1.draw(paramCanvas); 
    if (getTargetCheckedState()) {
      layout = this.J;
    } else {
      layout = this.K;
    } 
    if (layout != null) {
      int i1;
      int[] arrayOfInt = getDrawableState();
      ColorStateList colorStateList = this.I;
      if (colorStateList != null)
        this.H.setColor(colorStateList.getColorForState(arrayOfInt, 0)); 
      this.H.drawableState = arrayOfInt;
      if (drawable1 != null) {
        Rect rect1 = drawable1.getBounds();
        i1 = rect1.left + rect1.right;
      } else {
        i1 = getWidth();
      } 
      i1 /= 2;
      int i2 = layout.getWidth() / 2;
      j = (j + m + k - n) / 2;
      k = layout.getHeight() / 2;
      paramCanvas.translate((i1 - i2), (j - k));
      layout.draw(paramCanvas);
    } 
    paramCanvas.restoreToCount(i);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("android.widget.Switch");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    CharSequence charSequence;
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("android.widget.Switch");
    if (isChecked()) {
      charSequence = this.r;
    } else {
      charSequence = this.s;
    } 
    if (!TextUtils.isEmpty(charSequence)) {
      CharSequence charSequence1 = paramAccessibilityNodeInfo.getText();
      if (TextUtils.isEmpty(charSequence1)) {
        paramAccessibilityNodeInfo.setText(charSequence);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(charSequence1);
      stringBuilder.append(' ');
      stringBuilder.append(charSequence);
      paramAccessibilityNodeInfo.setText(stringBuilder);
    } 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable drawable = this.d;
    paramInt1 = 0;
    if (drawable != null) {
      Rect rect1 = this.N;
      Drawable drawable1 = this.i;
      if (drawable1 != null) {
        drawable1.getPadding(rect1);
      } else {
        rect1.setEmpty();
      } 
      Rect rect2 = DrawableUtils.getOpticalBounds(this.d);
      paramInt2 = Math.max(0, rect2.left - rect1.left);
      paramInt1 = Math.max(0, rect2.right - rect1.right);
    } else {
      paramInt2 = 0;
    } 
    if (ViewUtils.isLayoutRtl((View)this)) {
      paramInt3 = getPaddingLeft() + paramInt2;
      paramInt1 = this.A + paramInt3 - paramInt2 - paramInt1;
      paramInt2 = paramInt3;
      paramInt3 = paramInt1;
    } else {
      paramInt3 = getWidth() - getPaddingRight() - paramInt1;
      paramInt2 = paramInt3 - this.A + paramInt2 + paramInt1;
    } 
    paramInt1 = getGravity() & 0x70;
    if (paramInt1 != 16) {
      if (paramInt1 != 80) {
        paramInt1 = getPaddingTop();
        paramInt4 = this.B;
      } else {
        paramInt4 = getHeight() - getPaddingBottom();
        paramInt1 = paramInt4 - this.B;
        this.D = paramInt2;
        this.E = paramInt1;
        this.G = paramInt4;
        this.F = paramInt3;
      } 
    } else {
      paramInt1 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2;
      paramInt4 = this.B;
      paramInt1 -= paramInt4 / 2;
    } 
    paramInt4 += paramInt1;
    this.D = paramInt2;
    this.E = paramInt1;
    this.G = paramInt4;
    this.F = paramInt3;
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    int j;
    if (this.t) {
      if (this.J == null)
        this.J = a(this.r); 
      if (this.K == null)
        this.K = a(this.s); 
    } 
    Rect rect = this.N;
    Drawable drawable2 = this.d;
    int m = 0;
    if (drawable2 != null) {
      drawable2.getPadding(rect);
      j = this.d.getIntrinsicWidth() - rect.left - rect.right;
      i = this.d.getIntrinsicHeight();
    } else {
      j = 0;
      i = 0;
    } 
    if (this.t) {
      k = Math.max(this.J.getWidth(), this.K.getWidth()) + this.n * 2;
    } else {
      k = 0;
    } 
    this.C = Math.max(k, j);
    drawable2 = this.i;
    if (drawable2 != null) {
      drawable2.getPadding(rect);
      j = this.i.getIntrinsicHeight();
    } else {
      rect.setEmpty();
      j = m;
    } 
    int i1 = rect.left;
    int n = rect.right;
    Drawable drawable1 = this.d;
    m = n;
    int k = i1;
    if (drawable1 != null) {
      Rect rect1 = DrawableUtils.getOpticalBounds(drawable1);
      k = Math.max(i1, rect1.left);
      m = Math.max(n, rect1.right);
    } 
    k = Math.max(this.o, this.C * 2 + k + m);
    int i = Math.max(j, i);
    this.A = k;
    this.B = i;
    super.onMeasure(paramInt1, paramInt2);
    if (getMeasuredHeight() < i)
      setMeasuredDimension(getMeasuredWidthAndState(), i); 
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    CharSequence charSequence;
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (isChecked()) {
      charSequence = this.r;
    } else {
      charSequence = this.s;
    } 
    if (charSequence != null)
      paramAccessibilityEvent.getText().add(charSequence); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    this.y.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    if (i != 0) {
      if (i != 1)
        if (i != 2) {
          if (i != 3)
            return super.onTouchEvent(paramMotionEvent); 
        } else {
          i = this.u;
          if (i != 0)
            if (i != 1) {
              if (i == 2) {
                float f3 = paramMotionEvent.getX();
                i = getThumbScrollRange();
                float f1 = f3 - this.w;
                if (i != 0) {
                  f1 /= i;
                } else if (f1 > 0.0F) {
                  f1 = 1.0F;
                } else {
                  f1 = -1.0F;
                } 
                float f2 = f1;
                if (ViewUtils.isLayoutRtl((View)this))
                  f2 = -f1; 
                f1 = a(this.a + f2, 0.0F, 1.0F);
                if (f1 != this.a) {
                  this.w = f3;
                  setThumbPosition(f1);
                } 
                return true;
              } 
            } else {
              float f1 = paramMotionEvent.getX();
              float f2 = paramMotionEvent.getY();
              if (Math.abs(f1 - this.w) > this.v || Math.abs(f2 - this.x) > this.v) {
                this.u = 2;
                getParent().requestDisallowInterceptTouchEvent(true);
                this.w = f1;
                this.x = f2;
                return true;
              } 
            }  
          return super.onTouchEvent(paramMotionEvent);
        }  
      if (this.u == 2) {
        b(paramMotionEvent);
        super.onTouchEvent(paramMotionEvent);
        return true;
      } 
      this.u = 0;
      this.y.clear();
    } else {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if (isEnabled() && a(f1, f2)) {
        this.u = 1;
        this.w = f1;
        this.x = f2;
      } 
    } 
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setChecked(boolean paramBoolean) {
    float f;
    super.setChecked(paramBoolean);
    paramBoolean = isChecked();
    if (getWindowToken() != null && ViewCompat.isLaidOut((View)this)) {
      a(paramBoolean);
      return;
    } 
    c();
    if (paramBoolean) {
      f = 1.0F;
    } else {
      f = 0.0F;
    } 
    setThumbPosition(f);
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback) {
    super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback((TextView)this, paramCallback));
  }
  
  public void setShowText(boolean paramBoolean) {
    if (this.t != paramBoolean) {
      this.t = paramBoolean;
      requestLayout();
    } 
  }
  
  public void setSplitTrack(boolean paramBoolean) {
    this.q = paramBoolean;
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt) {
    this.o = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt) {
    this.p = paramInt;
    requestLayout();
  }
  
  public void setSwitchTextAppearance(Context paramContext, int paramInt) {
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramInt, R.styleable.TextAppearance);
    ColorStateList colorStateList = tintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
    if (colorStateList != null) {
      this.I = colorStateList;
    } else {
      this.I = getTextColors();
    } 
    paramInt = tintTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
    if (paramInt != 0) {
      float f = paramInt;
      if (f != this.H.getTextSize()) {
        this.H.setTextSize(f);
        requestLayout();
      } 
    } 
    a(tintTypedArray.getInt(R.styleable.TextAppearance_android_typeface, -1), tintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, -1));
    if (tintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false)) {
      this.L = (TransformationMethod)new AllCapsTransformationMethod(getContext());
    } else {
      this.L = null;
    } 
    tintTypedArray.recycle();
  }
  
  public void setSwitchTypeface(Typeface paramTypeface) {
    if ((this.H.getTypeface() != null && !this.H.getTypeface().equals(paramTypeface)) || (this.H.getTypeface() == null && paramTypeface != null)) {
      this.H.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    } 
  }
  
  public void setSwitchTypeface(Typeface paramTypeface, int paramInt) {
    TextPaint textPaint;
    float f = 0.0F;
    boolean bool = false;
    if (paramInt > 0) {
      int i;
      if (paramTypeface == null) {
        paramTypeface = Typeface.defaultFromStyle(paramInt);
      } else {
        paramTypeface = Typeface.create(paramTypeface, paramInt);
      } 
      setSwitchTypeface(paramTypeface);
      if (paramTypeface != null) {
        i = paramTypeface.getStyle();
      } else {
        i = 0;
      } 
      paramInt = i & paramInt;
      textPaint = this.H;
      if ((paramInt & 0x1) != 0)
        bool = true; 
      textPaint.setFakeBoldText(bool);
      textPaint = this.H;
      if ((paramInt & 0x2) != 0)
        f = -0.25F; 
      textPaint.setTextSkewX(f);
      return;
    } 
    this.H.setFakeBoldText(false);
    this.H.setTextSkewX(0.0F);
    setSwitchTypeface((Typeface)textPaint);
  }
  
  public void setTextOff(CharSequence paramCharSequence) {
    this.s = paramCharSequence;
    requestLayout();
  }
  
  public void setTextOn(CharSequence paramCharSequence) {
    this.r = paramCharSequence;
    requestLayout();
  }
  
  public void setThumbDrawable(Drawable paramDrawable) {
    Drawable drawable = this.d;
    if (drawable != null)
      drawable.setCallback(null); 
    this.d = paramDrawable;
    if (paramDrawable != null)
      paramDrawable.setCallback((Drawable.Callback)this); 
    requestLayout();
  }
  
  void setThumbPosition(float paramFloat) {
    this.a = paramFloat;
    invalidate();
  }
  
  public void setThumbResource(int paramInt) {
    setThumbDrawable(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setThumbTextPadding(int paramInt) {
    this.n = paramInt;
    requestLayout();
  }
  
  public void setThumbTintList(ColorStateList paramColorStateList) {
    this.e = paramColorStateList;
    this.g = true;
    b();
  }
  
  public void setThumbTintMode(PorterDuff.Mode paramMode) {
    this.f = paramMode;
    this.h = true;
    b();
  }
  
  public void setTrackDrawable(Drawable paramDrawable) {
    Drawable drawable = this.i;
    if (drawable != null)
      drawable.setCallback(null); 
    this.i = paramDrawable;
    if (paramDrawable != null)
      paramDrawable.setCallback((Drawable.Callback)this); 
    requestLayout();
  }
  
  public void setTrackResource(int paramInt) {
    setTrackDrawable(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setTrackTintList(ColorStateList paramColorStateList) {
    this.j = paramColorStateList;
    this.l = true;
    a();
  }
  
  public void setTrackTintMode(PorterDuff.Mode paramMode) {
    this.k = paramMode;
    this.m = true;
    a();
  }
  
  public void toggle() {
    setChecked(isChecked() ^ true);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable) {
    return (super.verifyDrawable(paramDrawable) || paramDrawable == this.d || paramDrawable == this.i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\SwitchCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */