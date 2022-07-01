package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;

public final class CollapsingTextHelper {
  private static final boolean a;
  
  private static final Paint b = null;
  
  private CharSequence A;
  
  private boolean B;
  
  private boolean C;
  
  private Bitmap D;
  
  private Paint E;
  
  private float F;
  
  private float G;
  
  private int[] H;
  
  private boolean I;
  
  private final TextPaint J;
  
  private final TextPaint K;
  
  private TimeInterpolator L;
  
  private TimeInterpolator M;
  
  private float N;
  
  private float O;
  
  private float P;
  
  private ColorStateList Q;
  
  private float R;
  
  private float S;
  
  private float T;
  
  private ColorStateList U;
  
  private StaticLayout V;
  
  private float W;
  
  private float X;
  
  private float Y;
  
  private CharSequence Z;
  
  private int aa = 1;
  
  private final View c;
  
  private boolean d;
  
  private float e;
  
  private final Rect f;
  
  private final Rect g;
  
  private final RectF h;
  
  private int i = 16;
  
  private int j = 16;
  
  private float k = 15.0F;
  
  private float l = 15.0F;
  
  private ColorStateList m;
  
  private ColorStateList n;
  
  private float o;
  
  private float p;
  
  private float q;
  
  private float r;
  
  private float s;
  
  private float t;
  
  private Typeface u;
  
  private Typeface v;
  
  private Typeface w;
  
  private CancelableFontCallback x;
  
  private CancelableFontCallback y;
  
  private CharSequence z;
  
  static {
    Paint paint = b;
    if (paint != null) {
      paint.setAntiAlias(true);
      b.setColor(-65281);
    } 
  }
  
  public CollapsingTextHelper(View paramView) {
    this.c = paramView;
    this.J = new TextPaint(129);
    this.K = new TextPaint((Paint)this.J);
    this.g = new Rect();
    this.f = new Rect();
    this.h = new RectF();
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, TimeInterpolator paramTimeInterpolator) {
    float f = paramFloat3;
    if (paramTimeInterpolator != null)
      f = paramTimeInterpolator.getInterpolation(paramFloat3); 
    return AnimationUtils.a(paramFloat1, paramFloat2, f);
  }
  
  private float a(int paramInt1, int paramInt2) {
    return (paramInt2 == 17 || (paramInt2 & 0x7) == 1) ? (paramInt1 / 2.0F - a() / 2.0F) : (((paramInt2 & 0x800005) == 8388613 || (paramInt2 & 0x5) == 5) ? (this.B ? this.g.left : (this.g.right - a())) : (this.B ? (this.g.right - a()) : this.g.left));
  }
  
  private static int a(int paramInt1, int paramInt2, float paramFloat) {
    float f1 = 1.0F - paramFloat;
    float f2 = Color.alpha(paramInt1);
    float f3 = Color.alpha(paramInt2);
    float f4 = Color.red(paramInt1);
    float f5 = Color.red(paramInt2);
    float f6 = Color.green(paramInt1);
    float f7 = Color.green(paramInt2);
    float f8 = Color.blue(paramInt1);
    float f9 = Color.blue(paramInt2);
    return Color.argb((int)(f2 * f1 + f3 * paramFloat), (int)(f4 * f1 + f5 * paramFloat), (int)(f6 * f1 + f7 * paramFloat), (int)(f8 * f1 + f9 * paramFloat));
  }
  
  private StaticLayout a(int paramInt, float paramFloat, boolean paramBoolean) {
    try {
      StaticLayout staticLayout = StaticLayoutBuilderCompat.a(this.z, this.J, (int)paramFloat).a(TextUtils.TruncateAt.END).b(paramBoolean).a(Layout.Alignment.ALIGN_NORMAL).a(false).a(paramInt).a();
    } catch (StaticLayoutBuilderCompatException staticLayoutBuilderCompatException) {
      Log.e("CollapsingTextHelper", staticLayoutBuilderCompatException.getCause().getMessage(), staticLayoutBuilderCompatException);
      staticLayoutBuilderCompatException = null;
    } 
    return (StaticLayout)Preconditions.checkNotNull(staticLayoutBuilderCompatException);
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2) {
    int i = this.J.getAlpha();
    paramCanvas.translate(paramFloat1, paramFloat2);
    TextPaint textPaint = this.J;
    paramFloat1 = this.X;
    paramFloat2 = i;
    textPaint.setAlpha((int)(paramFloat1 * paramFloat2));
    this.V.draw(paramCanvas);
    this.J.setAlpha((int)(this.W * paramFloat2));
    int j = this.V.getLineBaseline(0);
    CharSequence charSequence = this.Z;
    int k = charSequence.length();
    paramFloat1 = j;
    paramCanvas.drawText(charSequence, 0, k, 0.0F, paramFloat1, (Paint)this.J);
    String str = this.Z.toString().trim();
    charSequence = str;
    if (str.endsWith("…"))
      charSequence = str.substring(0, str.length() - 1); 
    this.J.setAlpha(i);
    paramCanvas.drawText((String)charSequence, 0, Math.min(this.V.getLineEnd(0), charSequence.length()), 0.0F, paramFloat1, (Paint)this.J);
  }
  
  private void a(TextPaint paramTextPaint) {
    paramTextPaint.setTextSize(this.k);
    paramTextPaint.setTypeface(this.v);
  }
  
  private static boolean a(float paramFloat1, float paramFloat2) {
    return (Math.abs(paramFloat1 - paramFloat2) < 0.001F);
  }
  
  private static boolean a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (paramRect.left == paramInt1 && paramRect.top == paramInt2 && paramRect.right == paramInt3 && paramRect.bottom == paramInt4);
  }
  
  private float b(RectF paramRectF, int paramInt1, int paramInt2) {
    return (paramInt2 == 17 || (paramInt2 & 0x7) == 1) ? (paramInt1 / 2.0F + a() / 2.0F) : (((paramInt2 & 0x800005) == 8388613 || (paramInt2 & 0x5) == 5) ? (this.B ? (paramRectF.left + a()) : this.g.right) : (this.B ? this.g.right : (paramRectF.left + a())));
  }
  
  private void b(TextPaint paramTextPaint) {
    paramTextPaint.setTextSize(this.l);
    paramTextPaint.setTypeface(this.u);
  }
  
  private boolean b(CharSequence paramCharSequence) {
    TextDirectionHeuristicCompat textDirectionHeuristicCompat;
    if (t()) {
      textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
    } else {
      textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    } 
    return textDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
  }
  
  private int c(ColorStateList paramColorStateList) {
    if (paramColorStateList == null)
      return 0; 
    int[] arrayOfInt = this.H;
    return (arrayOfInt != null) ? paramColorStateList.getColorForState(arrayOfInt, 0) : paramColorStateList.getDefaultColor();
  }
  
  private void c(float paramFloat) {
    d(paramFloat);
    this.s = a(this.q, this.r, paramFloat, this.L);
    this.t = a(this.o, this.p, paramFloat, this.L);
    g(a(this.k, this.l, paramFloat, this.M));
    e(1.0F - a(0.0F, 1.0F, 1.0F - paramFloat, AnimationUtils.b));
    f(a(1.0F, 0.0F, paramFloat, AnimationUtils.b));
    if (this.n != this.m) {
      this.J.setColor(a(q(), k(), paramFloat));
    } else {
      this.J.setColor(k());
    } 
    this.J.setShadowLayer(a(this.R, this.N, paramFloat, (TimeInterpolator)null), a(this.S, this.O, paramFloat, (TimeInterpolator)null), a(this.T, this.P, paramFloat, (TimeInterpolator)null), a(c(this.U), c(this.Q), paramFloat));
    ViewCompat.postInvalidateOnAnimation(this.c);
  }
  
  private void d(float paramFloat) {
    this.h.left = a(this.f.left, this.g.left, paramFloat, this.L);
    this.h.top = a(this.o, this.p, paramFloat, this.L);
    this.h.right = a(this.f.right, this.g.right, paramFloat, this.L);
    this.h.bottom = a(this.f.bottom, this.g.bottom, paramFloat, this.L);
  }
  
  private boolean d(Typeface paramTypeface) {
    CancelableFontCallback cancelableFontCallback = this.y;
    if (cancelableFontCallback != null)
      cancelableFontCallback.a(); 
    if (this.u != paramTypeface) {
      this.u = paramTypeface;
      return true;
    } 
    return false;
  }
  
  private void e(float paramFloat) {
    this.W = paramFloat;
    ViewCompat.postInvalidateOnAnimation(this.c);
  }
  
  private boolean e(Typeface paramTypeface) {
    CancelableFontCallback cancelableFontCallback = this.x;
    if (cancelableFontCallback != null)
      cancelableFontCallback.a(); 
    if (this.v != paramTypeface) {
      this.v = paramTypeface;
      return true;
    } 
    return false;
  }
  
  private void f(float paramFloat) {
    this.X = paramFloat;
    ViewCompat.postInvalidateOnAnimation(this.c);
  }
  
  private void g(float paramFloat) {
    boolean bool;
    h(paramFloat);
    if (a && this.F != 1.0F) {
      bool = true;
    } else {
      bool = false;
    } 
    this.C = bool;
    if (this.C)
      u(); 
    ViewCompat.postInvalidateOnAnimation(this.c);
  }
  
  private void h(float paramFloat) {
    float f1;
    int i;
    if (this.z == null)
      return; 
    float f2 = this.g.width();
    float f3 = this.f.width();
    boolean bool1 = a(paramFloat, this.l);
    boolean bool = false;
    byte b = 1;
    if (bool1) {
      f1 = this.l;
      this.F = 1.0F;
      Typeface typeface1 = this.w;
      Typeface typeface2 = this.u;
      if (typeface1 != typeface2) {
        this.w = typeface2;
        i = 1;
        paramFloat = f2;
      } else {
        i = 0;
        paramFloat = f2;
      } 
    } else {
      f1 = this.k;
      Typeface typeface1 = this.w;
      Typeface typeface2 = this.v;
      if (typeface1 != typeface2) {
        this.w = typeface2;
        i = 1;
      } else {
        i = 0;
      } 
      if (a(paramFloat, this.k)) {
        this.F = 1.0F;
      } else {
        this.F = paramFloat / this.k;
      } 
      paramFloat = this.l / this.k;
      if (f3 * paramFloat > f2) {
        paramFloat = Math.min(f2 / paramFloat, f3);
      } else {
        paramFloat = f3;
      } 
    } 
    int j = i;
    if (paramFloat > 0.0F) {
      if (this.G != f1 || this.I || i) {
        i = 1;
      } else {
        i = 0;
      } 
      this.G = f1;
      this.I = false;
      j = i;
    } 
    if (this.A == null || j) {
      this.J.setTextSize(this.G);
      this.J.setTypeface(this.w);
      TextPaint textPaint = this.J;
      if (this.F != 1.0F)
        bool = true; 
      textPaint.setLinearText(bool);
      this.B = b(this.z);
      i = b;
      if (s())
        i = this.aa; 
      this.V = a(i, paramFloat, this.B);
      this.A = this.V.getText();
    } 
  }
  
  private void p() {
    c(this.e);
  }
  
  private int q() {
    return c(this.m);
  }
  
  private void r() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean s() {
    return (this.aa > 1 && !this.B && !this.C);
  }
  
  private boolean t() {
    return (ViewCompat.getLayoutDirection(this.c) == 1);
  }
  
  private void u() {
    if (this.D == null && !this.f.isEmpty()) {
      if (TextUtils.isEmpty(this.A))
        return; 
      c(0.0F);
      int i = this.V.getWidth();
      int j = this.V.getHeight();
      if (i > 0) {
        if (j <= 0)
          return; 
        this.D = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.D);
        this.V.draw(canvas);
        if (this.E == null)
          this.E = new Paint(3); 
      } 
    } 
  }
  
  private void v() {
    Bitmap bitmap = this.D;
    if (bitmap != null) {
      bitmap.recycle();
      this.D = null;
    } 
  }
  
  public float a() {
    if (this.z == null)
      return 0.0F; 
    b(this.K);
    TextPaint textPaint = this.K;
    CharSequence charSequence = this.z;
    return textPaint.measureText(charSequence, 0, charSequence.length());
  }
  
  public void a(float paramFloat) {
    if (this.k != paramFloat) {
      this.k = paramFloat;
      l();
    } 
  }
  
  public void a(int paramInt) {
    if (this.i != paramInt) {
      this.i = paramInt;
      l();
    } 
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!a(this.f, paramInt1, paramInt2, paramInt3, paramInt4)) {
      this.f.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.I = true;
      d();
    } 
  }
  
  public void a(TimeInterpolator paramTimeInterpolator) {
    this.M = paramTimeInterpolator;
    l();
  }
  
  public void a(ColorStateList paramColorStateList) {
    if (this.n != paramColorStateList) {
      this.n = paramColorStateList;
      l();
    } 
  }
  
  public void a(Canvas paramCanvas) {
    int i = paramCanvas.save();
    if (this.A != null && this.d) {
      float f1 = this.s;
      StaticLayout staticLayout = this.V;
      boolean bool2 = false;
      float f2 = staticLayout.getLineLeft(0);
      float f3 = this.Y;
      this.J.setTextSize(this.G);
      float f4 = this.s;
      float f5 = this.t;
      boolean bool1 = bool2;
      if (this.C) {
        bool1 = bool2;
        if (this.D != null)
          bool1 = true; 
      } 
      float f6 = this.F;
      if (f6 != 1.0F)
        paramCanvas.scale(f6, f6, f4, f5); 
      if (bool1) {
        paramCanvas.drawBitmap(this.D, f4, f5, this.E);
        paramCanvas.restoreToCount(i);
        return;
      } 
      if (s()) {
        a(paramCanvas, f1 + f2 - f3 * 2.0F, f5);
      } else {
        paramCanvas.translate(f4, f5);
        this.V.draw(paramCanvas);
      } 
      paramCanvas.restoreToCount(i);
    } 
  }
  
  public void a(Rect paramRect) {
    a(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public void a(RectF paramRectF, int paramInt1, int paramInt2) {
    this.B = b(this.z);
    paramRectF.left = a(paramInt1, paramInt2);
    paramRectF.top = this.g.top;
    paramRectF.right = b(paramRectF, paramInt1, paramInt2);
    paramRectF.bottom = this.g.top + c();
  }
  
  public void a(Typeface paramTypeface) {
    if (d(paramTypeface))
      l(); 
  }
  
  public void a(CharSequence paramCharSequence) {
    if (paramCharSequence == null || !TextUtils.equals(this.z, paramCharSequence)) {
      this.z = paramCharSequence;
      this.A = null;
      v();
      l();
    } 
  }
  
  public final boolean a(int[] paramArrayOfint) {
    this.H = paramArrayOfint;
    if (i()) {
      l();
      return true;
    } 
    return false;
  }
  
  public float b() {
    a(this.K);
    return -this.K.ascent();
  }
  
  public void b(float paramFloat) {
    paramFloat = MathUtils.clamp(paramFloat, 0.0F, 1.0F);
    if (paramFloat != this.e) {
      this.e = paramFloat;
      p();
    } 
  }
  
  public void b(int paramInt) {
    if (this.j != paramInt) {
      this.j = paramInt;
      l();
    } 
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (!a(this.g, paramInt1, paramInt2, paramInt3, paramInt4)) {
      this.g.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.I = true;
      d();
    } 
  }
  
  public void b(TimeInterpolator paramTimeInterpolator) {
    this.L = paramTimeInterpolator;
    l();
  }
  
  public void b(ColorStateList paramColorStateList) {
    if (this.m != paramColorStateList) {
      this.m = paramColorStateList;
      l();
    } 
  }
  
  public void b(Rect paramRect) {
    b(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public void b(Typeface paramTypeface) {
    if (e(paramTypeface))
      l(); 
  }
  
  public float c() {
    b(this.K);
    return -this.K.ascent();
  }
  
  public void c(int paramInt) {
    TextAppearance textAppearance = new TextAppearance(this.c.getContext(), paramInt);
    if (textAppearance.b != null)
      this.n = textAppearance.b; 
    if (textAppearance.a != 0.0F)
      this.l = textAppearance.a; 
    if (textAppearance.i != null)
      this.Q = textAppearance.i; 
    this.O = textAppearance.j;
    this.P = textAppearance.k;
    this.N = textAppearance.l;
    CancelableFontCallback cancelableFontCallback = this.y;
    if (cancelableFontCallback != null)
      cancelableFontCallback.a(); 
    this.y = new CancelableFontCallback(new CancelableFontCallback.ApplyFont(this) {
          public void a(Typeface param1Typeface) {
            this.a.a(param1Typeface);
          }
        },  textAppearance.a());
    textAppearance.a(this.c.getContext(), (TextAppearanceFontCallback)this.y);
    l();
  }
  
  public void c(Typeface paramTypeface) {
    boolean bool1 = d(paramTypeface);
    boolean bool2 = e(paramTypeface);
    if (bool1 || bool2)
      l(); 
  }
  
  void d() {
    boolean bool;
    if (this.g.width() > 0 && this.g.height() > 0 && this.f.width() > 0 && this.f.height() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.d = bool;
  }
  
  public void d(int paramInt) {
    TextAppearance textAppearance = new TextAppearance(this.c.getContext(), paramInt);
    if (textAppearance.b != null)
      this.m = textAppearance.b; 
    if (textAppearance.a != 0.0F)
      this.k = textAppearance.a; 
    if (textAppearance.i != null)
      this.U = textAppearance.i; 
    this.S = textAppearance.j;
    this.T = textAppearance.k;
    this.R = textAppearance.l;
    CancelableFontCallback cancelableFontCallback = this.x;
    if (cancelableFontCallback != null)
      cancelableFontCallback.a(); 
    this.x = new CancelableFontCallback(new CancelableFontCallback.ApplyFont(this) {
          public void a(Typeface param1Typeface) {
            this.a.b(param1Typeface);
          }
        },  textAppearance.a());
    textAppearance.a(this.c.getContext(), (TextAppearanceFontCallback)this.x);
    l();
  }
  
  public int e() {
    return this.i;
  }
  
  public void e(int paramInt) {
    if (paramInt != this.aa) {
      this.aa = paramInt;
      v();
      l();
    } 
  }
  
  public int f() {
    return this.j;
  }
  
  public Typeface g() {
    Typeface typeface = this.u;
    return (typeface != null) ? typeface : Typeface.DEFAULT;
  }
  
  public Typeface h() {
    Typeface typeface = this.v;
    return (typeface != null) ? typeface : Typeface.DEFAULT;
  }
  
  public final boolean i() {
    ColorStateList colorStateList = this.n;
    if (colorStateList == null || !colorStateList.isStateful()) {
      colorStateList = this.m;
      if (colorStateList == null || !colorStateList.isStateful())
        return false; 
    } 
    return true;
  }
  
  public float j() {
    return this.e;
  }
  
  public int k() {
    return c(this.n);
  }
  
  public void l() {
    if (this.c.getHeight() > 0 && this.c.getWidth() > 0) {
      r();
      p();
    } 
  }
  
  public CharSequence m() {
    return this.z;
  }
  
  public int n() {
    return this.aa;
  }
  
  public ColorStateList o() {
    return this.n;
  }
  
  static {
    boolean bool;
    if (Build.VERSION.SDK_INT < 18) {
      bool = true;
    } else {
      bool = false;
    } 
    a = bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\CollapsingTextHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */