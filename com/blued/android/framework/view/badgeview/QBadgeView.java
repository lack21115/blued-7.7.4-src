package com.blued.android.framework.view.badgeview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

public class QBadgeView extends View implements Badge {
  protected Paint.FontMetrics A;
  
  protected PointF B;
  
  protected PointF C;
  
  protected PointF D;
  
  protected PointF E;
  
  protected List<PointF> F;
  
  protected View G;
  
  protected int H;
  
  protected int I;
  
  protected TextPaint J;
  
  protected Paint K;
  
  protected Paint L;
  
  protected BadgeAnimator M;
  
  protected Badge.OnDragStateChangedListener N;
  
  protected ViewGroup O;
  
  public long P = 0L;
  
  protected int a;
  
  protected int b;
  
  protected int c;
  
  protected Drawable d;
  
  protected Bitmap e;
  
  protected boolean f;
  
  protected float g;
  
  protected float h;
  
  protected float i;
  
  protected int j;
  
  protected String k;
  
  protected boolean l;
  
  protected boolean m;
  
  protected boolean n;
  
  protected boolean o;
  
  protected int p;
  
  protected float q;
  
  protected float r;
  
  protected float s = 0.0F;
  
  protected float t;
  
  protected float u;
  
  protected int v;
  
  protected boolean w;
  
  protected RectF x;
  
  protected RectF y;
  
  protected Path z;
  
  public QBadgeView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  private QBadgeView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  private QBadgeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void a(Canvas paramCanvas) {
    this.K.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    int k = (int)this.y.left;
    int m = (int)this.y.top;
    int i = (int)this.y.right;
    int j = (int)this.y.bottom;
    if (this.f) {
      i = this.e.getWidth() + k;
      j = this.e.getHeight() + m;
      paramCanvas.saveLayer(k, m, i, j, null, 31);
    } 
    this.d.setBounds(k, m, i, j);
    this.d.draw(paramCanvas);
    if (this.f) {
      this.K.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      paramCanvas.drawBitmap(this.e, k, m, this.K);
      paramCanvas.restore();
      this.K.setXfermode(null);
      if (this.k.isEmpty() || this.k.length() == 1) {
        paramCanvas.drawCircle(this.y.centerX(), this.y.centerY(), this.y.width() / 2.0F, this.L);
        return;
      } 
      RectF rectF = this.y;
      paramCanvas.drawRoundRect(rectF, rectF.height() / 2.0F, this.y.height() / 2.0F, this.L);
      return;
    } 
    paramCanvas.drawRect(this.y, this.L);
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2) {
    Path.Direction direction;
    float f1 = this.C.y;
    float f2 = this.D.y;
    float f3 = this.C.x - this.D.x;
    this.F.clear();
    if (f3 != 0.0F) {
      double d = -1.0D / ((f1 - f2) / f3);
      MathUtil.a(this.C, paramFloat2, Double.valueOf(d), this.F);
      MathUtil.a(this.D, paramFloat1, Double.valueOf(d), this.F);
    } else {
      MathUtil.a(this.C, paramFloat2, Double.valueOf(0.0D), this.F);
      MathUtil.a(this.D, paramFloat1, Double.valueOf(0.0D), this.F);
    } 
    this.z.reset();
    Path path = this.z;
    paramFloat2 = this.D.x;
    f1 = this.D.y;
    int i = this.v;
    if (i == 1 || i == 2) {
      direction = Path.Direction.CCW;
    } else {
      direction = Path.Direction.CW;
    } 
    path.addCircle(paramFloat2, f1, paramFloat1, direction);
    this.E.x = (this.D.x + this.C.x) / 2.0F;
    this.E.y = (this.D.y + this.C.y) / 2.0F;
    this.z.moveTo(((PointF)this.F.get(2)).x, ((PointF)this.F.get(2)).y);
    this.z.quadTo(this.E.x, this.E.y, ((PointF)this.F.get(0)).x, ((PointF)this.F.get(0)).y);
    this.z.lineTo(((PointF)this.F.get(1)).x, ((PointF)this.F.get(1)).y);
    this.z.quadTo(this.E.x, this.E.y, ((PointF)this.F.get(3)).x, ((PointF)this.F.get(3)).y);
    this.z.lineTo(((PointF)this.F.get(2)).x, ((PointF)this.F.get(2)).y);
    this.z.close();
    paramCanvas.drawPath(this.z, this.K);
    if (this.b != 0 && this.g > 0.0F) {
      this.z.reset();
      this.z.moveTo(((PointF)this.F.get(2)).x, ((PointF)this.F.get(2)).y);
      this.z.quadTo(this.E.x, this.E.y, ((PointF)this.F.get(0)).x, ((PointF)this.F.get(0)).y);
      this.z.moveTo(((PointF)this.F.get(1)).x, ((PointF)this.F.get(1)).y);
      this.z.quadTo(this.E.x, this.E.y, ((PointF)this.F.get(3)).x, ((PointF)this.F.get(3)).y);
      i = this.v;
      if (i == 1 || i == 2) {
        f2 = ((PointF)this.F.get(2)).x - this.D.x;
        paramFloat2 = this.D.y;
        f1 = ((PointF)this.F.get(2)).y;
      } else {
        f2 = ((PointF)this.F.get(3)).x - this.D.x;
        paramFloat2 = this.D.y;
        f1 = ((PointF)this.F.get(3)).y;
      } 
      double d = Math.atan(((paramFloat2 - f1) / f2));
      i = this.v;
      if (i - 1 == 0) {
        i = 4;
      } else {
        i--;
      } 
      paramFloat2 = 360.0F - (float)MathUtil.a(MathUtil.a(d, i));
      if (Build.VERSION.SDK_INT >= 21) {
        this.z.addArc(this.D.x - paramFloat1, this.D.y - paramFloat1, this.D.x + paramFloat1, this.D.y + paramFloat1, paramFloat2, 180.0F);
      } else {
        this.z.addArc(new RectF(this.D.x - paramFloat1, this.D.y - paramFloat1, this.D.x + paramFloat1, this.D.y + paramFloat1), paramFloat2, 180.0F);
      } 
      paramCanvas.drawPath(this.z, this.L);
    } 
  }
  
  private void a(Canvas paramCanvas, PointF paramPointF, float paramFloat) {
    if (paramPointF.x == -1000.0F && paramPointF.y == -1000.0F)
      return; 
    if (this.k.isEmpty() || this.k.length() == 1) {
      RectF rectF = this.y;
      float f1 = paramPointF.x;
      float f2 = (int)paramFloat;
      rectF.left = f1 - f2;
      this.y.top = paramPointF.y - f2;
      this.y.right = paramPointF.x + f2;
      this.y.bottom = paramPointF.y + f2;
      if (this.d != null) {
        a(paramCanvas);
      } else {
        paramCanvas.drawCircle(paramPointF.x, paramPointF.y, paramFloat, this.K);
        if (this.b != 0 && this.g > 0.0F)
          paramCanvas.drawCircle(paramPointF.x, paramPointF.y, paramFloat, this.L); 
      } 
    } else {
      this.y.left = paramPointF.x - this.x.width() / 2.0F + this.i;
      this.y.top = paramPointF.y - this.x.height() / 2.0F + this.i * 0.3F;
      this.y.right = paramPointF.x + this.x.width() / 2.0F + this.i;
      this.y.bottom = paramPointF.y + this.x.height() / 2.0F + this.i * 0.3F;
      paramFloat = this.y.height() / 2.0F;
      if (this.d != null) {
        a(paramCanvas);
      } else {
        paramCanvas.drawRoundRect(this.y, paramFloat, paramFloat, this.K);
        if (this.b != 0 && this.g > 0.0F)
          paramCanvas.drawRoundRect(this.y, paramFloat, paramFloat, this.L); 
      } 
    } 
    if (!this.k.isEmpty())
      paramCanvas.drawText(this.k, paramPointF.x, (this.y.bottom + this.y.top - this.A.bottom - this.A.top) / 2.0F, (Paint)this.J); 
  }
  
  private void b(View paramView) {
    if (paramView.getParent() != null && paramView.getParent() instanceof View) {
      b((View)paramView.getParent());
      return;
    } 
    if (paramView instanceof ViewGroup)
      this.O = (ViewGroup)paramView; 
  }
  
  private void c() {
    setLayerType(1, null);
    this.x = new RectF();
    this.y = new RectF();
    this.z = new Path();
    this.B = new PointF();
    this.C = new PointF();
    this.D = new PointF();
    this.E = new PointF();
    this.F = new ArrayList<PointF>();
    this.J = new TextPaint();
    this.J.setAntiAlias(true);
    this.J.setSubpixelText(true);
    this.J.setFakeBoldText(true);
    this.J.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    this.K = new Paint();
    this.K.setAntiAlias(true);
    this.K.setStyle(Paint.Style.FILL);
    this.L = new Paint();
    this.L.setAntiAlias(true);
    this.L.setStyle(Paint.Style.STROKE);
    this.a = -1552832;
    this.c = -1;
    this.h = DisplayUtil.a(getContext(), 11.0F);
    this.i = DisplayUtil.a(getContext(), 5.0F);
    this.j = 0;
    this.p = 8388661;
    this.q = DisplayUtil.a(getContext(), 5.0F);
    this.r = DisplayUtil.a(getContext(), 5.0F);
    this.s = DisplayUtil.a(getContext(), 10.0F);
    this.u = DisplayUtil.a(getContext(), 90.0F);
    this.o = false;
    this.f = false;
    if (Build.VERSION.SDK_INT >= 21)
      setTranslationZ(1000.0F); 
  }
  
  private void d() {
    if (this.w) {
      a(this.C, true);
      return;
    } 
    b();
    e(4);
  }
  
  private void d(boolean paramBoolean) {
    float f;
    int i = DisplayUtil.a(getContext(), 1.0F);
    int j = DisplayUtil.a(getContext(), 1.5F);
    int k = this.v;
    if (k != 1) {
      if (k != 2) {
        if (k != 3) {
          if (k == 4) {
            i = DisplayUtil.a(getContext(), 1.0F);
            j = DisplayUtil.a(getContext(), 1.5F);
          } 
        } else {
          i = DisplayUtil.a(getContext(), -1.0F);
          j = DisplayUtil.a(getContext(), 1.5F);
        } 
      } else {
        i = DisplayUtil.a(getContext(), -1.0F);
        j = DisplayUtil.a(getContext(), -1.5F);
      } 
    } else {
      i = DisplayUtil.a(getContext(), 1.0F);
      j = DisplayUtil.a(getContext(), -1.5F);
    } 
    Paint paint = this.K;
    if (paramBoolean) {
      f = DisplayUtil.a(getContext(), 2.0F);
    } else {
      f = 0.0F;
    } 
    paint.setShadowLayer(f, i, j, 855638016);
  }
  
  private void e() {
    d(this.o);
    this.K.setColor(this.a);
    this.L.setColor(this.b);
    this.L.setStrokeWidth(this.g);
    this.J.setColor(this.c);
    this.J.setTextAlign(Paint.Align.CENTER);
  }
  
  private void f() {
    if (this.k == null)
      return; 
    if (!this.f)
      return; 
    Bitmap bitmap = this.e;
    if (bitmap != null && !bitmap.isRecycled())
      this.e.recycle(); 
    float f = getBadgeCircleRadius();
    if (this.k.isEmpty() || this.k.length() == 1) {
      int i = (int)f * 2;
      this.e = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_4444);
      Canvas canvas1 = new Canvas(this.e);
      canvas1.drawCircle(canvas1.getWidth() / 2.0F, canvas1.getHeight() / 2.0F, canvas1.getWidth() / 2.0F, this.K);
      return;
    } 
    this.e = Bitmap.createBitmap((int)(this.x.width() + this.i * 2.0F), (int)(this.x.height() + this.i), Bitmap.Config.ARGB_4444);
    Canvas canvas = new Canvas(this.e);
    if (Build.VERSION.SDK_INT >= 21) {
      canvas.drawRoundRect(0.0F, 0.0F, canvas.getWidth(), canvas.getHeight(), canvas.getHeight() / 2.0F, canvas.getHeight() / 2.0F, this.K);
      return;
    } 
    canvas.drawRoundRect(new RectF(0.0F, 0.0F, canvas.getWidth(), canvas.getHeight()), canvas.getHeight() / 2.0F, canvas.getHeight() / 2.0F, this.K);
  }
  
  private void g() {
    float f1;
    float f2;
    float f3;
    float f4;
    PointF pointF;
    if (this.x.height() > this.x.width()) {
      f1 = this.x.height();
    } else {
      f1 = this.x.width();
    } 
    switch (this.p) {
      case 8388693:
        pointF = this.B;
        f2 = this.H;
        f3 = this.q;
        f4 = this.i;
        pointF.x = f2 - f3 + f4 + f1 / 2.0F;
        pointF.y = this.I - this.r + f4 + this.x.height() / 2.0F;
        break;
      case 8388691:
        pointF = this.B;
        f2 = this.q;
        f3 = this.i;
        pointF.x = f2 + f3 + f1 / 2.0F;
        pointF.y = this.I - this.r + f3 + this.x.height() / 2.0F;
        break;
      case 8388661:
        pointF = this.B;
        f2 = this.H;
        f3 = this.q;
        f4 = this.i;
        pointF.x = f2 - f3 + f4 + f1 / 2.0F;
        pointF.y = this.r + f4 + this.x.height() / 2.0F;
        break;
      case 8388659:
        pointF = this.B;
        f2 = this.q;
        f3 = this.i;
        pointF.x = f2 + f3 + f1 / 2.0F;
        pointF.y = this.r + f3 + this.x.height() / 2.0F;
        break;
      case 8388629:
        pointF = this.B;
        pointF.x = this.H - this.q + this.i + f1 / 2.0F;
        pointF.y = this.I / 2.0F;
        break;
      case 8388627:
        pointF = this.B;
        pointF.x = this.q + this.i + f1 / 2.0F;
        pointF.y = this.I / 2.0F;
        break;
      case 81:
        pointF = this.B;
        pointF.x = this.H / 2.0F;
        pointF.y = this.I - this.r + this.i + this.x.height() / 2.0F;
        break;
      case 49:
        pointF = this.B;
        pointF.x = this.H / 2.0F;
        pointF.y = this.r + this.i + this.x.height() / 2.0F;
        break;
      case 17:
        pointF = this.B;
        pointF.x = this.H / 2.0F;
        pointF.y = this.I / 2.0F;
        break;
    } 
    i();
  }
  
  private float getBadgeCircleRadius() {
    if (this.k.isEmpty())
      return this.i; 
    if (this.k.length() == 1) {
      float f1;
      float f2;
      if (this.x.height() > this.x.width()) {
        f1 = this.x.height() / 2.0F;
        f2 = this.i;
      } else {
        f1 = this.x.width() / 2.0F;
        f2 = this.i;
      } 
      return f1 + f2 * 0.5F;
    } 
    return this.y.height() / 2.0F;
  }
  
  private void h() {
    RectF rectF = this.x;
    rectF.left = 0.0F;
    rectF.top = 0.0F;
    if (TextUtils.isEmpty(this.k)) {
      rectF = this.x;
      rectF.right = 0.0F;
      rectF.bottom = 0.0F;
    } else {
      this.J.setTextSize(this.h);
      this.x.right = this.J.measureText(this.k);
      this.A = this.J.getFontMetrics();
      this.x.bottom = this.A.descent - this.A.ascent;
    } 
    f();
  }
  
  private void i() {
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    this.B.x += arrayOfInt[0];
    this.B.y += arrayOfInt[1];
  }
  
  protected Bitmap a() {
    Bitmap bitmap = Bitmap.createBitmap((int)this.y.width() + DisplayUtil.a(getContext(), 3.0F), (int)this.y.height() + DisplayUtil.a(getContext(), 3.0F), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    a(canvas, new PointF(canvas.getWidth() / 2.0F, canvas.getHeight() / 2.0F), getBadgeCircleRadius());
    return bitmap;
  }
  
  public Badge a(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    float f = paramFloat1;
    if (paramBoolean)
      f = DisplayUtil.a(getContext(), paramFloat1); 
    this.q = f;
    paramFloat1 = paramFloat2;
    if (paramBoolean)
      paramFloat1 = DisplayUtil.a(getContext(), paramFloat2); 
    this.r = paramFloat1;
    invalidate();
    return this;
  }
  
  public Badge a(float paramFloat, boolean paramBoolean) {
    float f = paramFloat;
    if (paramBoolean)
      f = DisplayUtil.a(getContext(), paramFloat); 
    this.h = f;
    h();
    invalidate();
    return this;
  }
  
  public Badge a(int paramInt) {
    this.j = paramInt;
    paramInt = this.j;
    if (paramInt < 0) {
      this.k = "";
    } else if (paramInt > 99) {
      String str;
      if (this.n) {
        str = String.valueOf(paramInt);
      } else {
        str = "99+";
      } 
      this.k = str;
    } else if (paramInt > 0 && paramInt <= 99) {
      this.k = String.valueOf(paramInt);
    } else if (this.j == 0) {
      this.k = null;
    } 
    h();
    invalidate();
    return this;
  }
  
  public Badge a(int paramInt, float paramFloat, boolean paramBoolean) {
    this.b = paramInt;
    float f = paramFloat;
    if (paramBoolean)
      f = DisplayUtil.a(getContext(), paramFloat); 
    this.g = f;
    invalidate();
    return this;
  }
  
  public Badge a(View paramView) {
    if (paramView != null) {
      if (getParent() != null)
        ((ViewGroup)getParent()).removeView(this); 
      ViewParent viewParent = paramView.getParent();
      if (viewParent != null && viewParent instanceof ViewGroup) {
        this.G = paramView;
        if (viewParent instanceof BadgeContainer) {
          ((BadgeContainer)viewParent).addView(this);
          return this;
        } 
        ViewGroup viewGroup = (ViewGroup)viewParent;
        int i = viewGroup.indexOfChild(paramView);
        ViewGroup.LayoutParams layoutParams = paramView.getLayoutParams();
        viewGroup.removeView(paramView);
        BadgeContainer badgeContainer = new BadgeContainer(this, getContext());
        badgeContainer.setId(paramView.getId());
        viewGroup.addView((View)badgeContainer, i, layoutParams);
        badgeContainer.addView(paramView);
        badgeContainer.addView(this);
        return this;
      } 
      throw new IllegalStateException("targetView must have a parent");
    } 
    throw new IllegalStateException("targetView can not be null");
  }
  
  public Badge a(Badge.OnDragStateChangedListener paramOnDragStateChangedListener) {
    boolean bool;
    if (paramOnDragStateChangedListener != null) {
      bool = true;
    } else {
      bool = false;
    } 
    this.l = bool;
    this.N = paramOnDragStateChangedListener;
    return this;
  }
  
  public Badge a(String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      this.k = null;
    } else {
      this.k = paramString;
    } 
    this.j = 1;
    h();
    invalidate();
    return this;
  }
  
  protected void a(PointF paramPointF, boolean paramBoolean) {
    if (this.k == null) {
      a(0);
      return;
    } 
    BadgeAnimator badgeAnimator = this.M;
    if (badgeAnimator == null || !badgeAnimator.isRunning()) {
      a(true);
      this.M = new BadgeAnimator(a(), paramPointF, this, paramBoolean);
      this.M.start();
      a(0);
    } 
  }
  
  protected void a(boolean paramBoolean) {
    if (getParent() != null)
      ((ViewGroup)getParent()).removeView(this); 
    if (paramBoolean) {
      this.O.addView(this, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      return;
    } 
    a(this.G);
  }
  
  public Badge b(float paramFloat, boolean paramBoolean) {
    float f = paramFloat;
    if (paramBoolean)
      f = DisplayUtil.a(getContext(), paramFloat); 
    this.i = f;
    f();
    invalidate();
    return this;
  }
  
  public Badge b(int paramInt) {
    this.a = paramInt;
    if (this.a == 0) {
      this.J.setXfermode(null);
    } else {
      this.J.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    } 
    invalidate();
    return this;
  }
  
  public void b() {
    PointF pointF = this.C;
    pointF.x = -1000.0F;
    pointF.y = -1000.0F;
    this.v = 4;
    this.M = null;
    a(false);
    getParent().requestDisallowInterceptTouchEvent(false);
    invalidate();
  }
  
  public void b(boolean paramBoolean) {
    i();
    if (paramBoolean && this.O != null) {
      a(this.D, false);
      return;
    } 
    a(0);
  }
  
  public Badge c(int paramInt) {
    this.c = paramInt;
    invalidate();
    return this;
  }
  
  public Badge c(boolean paramBoolean) {
    this.n = paramBoolean;
    int i = this.j;
    if (i > 99)
      a(i); 
    return this;
  }
  
  public Badge d(int paramInt) {
    if (paramInt == 8388659 || paramInt == 8388661 || paramInt == 8388691 || paramInt == 8388693 || paramInt == 17 || paramInt == 49 || paramInt == 81 || paramInt == 8388627 || paramInt == 8388629) {
      this.p = paramInt;
      invalidate();
      return this;
    } 
    throw new IllegalStateException("only support Gravity.START | Gravity.TOP , Gravity.END | Gravity.TOP , Gravity.START | Gravity.BOTTOM , Gravity.END | Gravity.BOTTOM , Gravity.CENTER , Gravity.CENTER | Gravity.TOP , Gravity.CENTER | Gravity.BOTTOM ,Gravity.CENTER | Gravity.START , Gravity.CENTER | Gravity.END");
  }
  
  public void e(int paramInt) {
    Badge.OnDragStateChangedListener onDragStateChangedListener = this.N;
    if (onDragStateChangedListener != null)
      onDragStateChangedListener.a(paramInt, this, this.G); 
  }
  
  public Drawable getBadgeBackground() {
    return this.d;
  }
  
  public int getBadgeBackgroundColor() {
    return this.a;
  }
  
  public int getBadgeGravity() {
    return this.p;
  }
  
  public int getBadgeNumber() {
    return this.j;
  }
  
  public String getBadgeText() {
    return this.k;
  }
  
  public int getBadgeTextColor() {
    return this.c;
  }
  
  public PointF getDragCenter() {
    return (this.l && this.m) ? this.C : null;
  }
  
  public View getTargetView() {
    return this.G;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    if (this.O == null)
      b(this.G); 
  }
  
  protected void onDraw(Canvas paramCanvas) {
    BadgeAnimator badgeAnimator = this.M;
    if (badgeAnimator != null && badgeAnimator.isRunning()) {
      this.M.a(paramCanvas);
      return;
    } 
    if (this.k != null) {
      e();
      float f1 = getBadgeCircleRadius();
      float f2 = this.t * (1.0F - MathUtil.b(this.D, this.C) / this.u);
      if (this.l && this.m) {
        boolean bool;
        this.v = MathUtil.a(this.C, this.D);
        d(this.o);
        if (f2 < DisplayUtil.a(getContext(), 1.5F)) {
          bool = true;
        } else {
          bool = false;
        } 
        this.w = bool;
        if (bool) {
          e(3);
          a(paramCanvas, this.C, f1);
          return;
        } 
        e(2);
        a(paramCanvas, f2, f1);
        a(paramCanvas, this.C, f1);
        return;
      } 
      g();
      a(paramCanvas, this.B, f1);
    } 
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.H = paramInt1;
    this.I = paramInt2;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getActionMasked : ()I
    //   4: istore #4
    //   6: iconst_0
    //   7: istore #5
    //   9: iload #4
    //   11: ifeq -> 114
    //   14: iload #4
    //   16: iconst_1
    //   17: if_icmpeq -> 84
    //   20: iload #4
    //   22: iconst_2
    //   23: if_icmpeq -> 48
    //   26: iload #4
    //   28: iconst_3
    //   29: if_icmpeq -> 84
    //   32: iload #4
    //   34: iconst_5
    //   35: if_icmpeq -> 114
    //   38: iload #4
    //   40: bipush #6
    //   42: if_icmpeq -> 84
    //   45: goto -> 283
    //   48: aload_0
    //   49: getfield m : Z
    //   52: ifeq -> 283
    //   55: aload_0
    //   56: getfield C : Landroid/graphics/PointF;
    //   59: aload_1
    //   60: invokevirtual getRawX : ()F
    //   63: putfield x : F
    //   66: aload_0
    //   67: getfield C : Landroid/graphics/PointF;
    //   70: aload_1
    //   71: invokevirtual getRawY : ()F
    //   74: putfield y : F
    //   77: aload_0
    //   78: invokevirtual invalidate : ()V
    //   81: goto -> 283
    //   84: aload_1
    //   85: aload_1
    //   86: invokevirtual getActionIndex : ()I
    //   89: invokevirtual getPointerId : (I)I
    //   92: ifne -> 283
    //   95: aload_0
    //   96: getfield m : Z
    //   99: ifeq -> 283
    //   102: aload_0
    //   103: iconst_0
    //   104: putfield m : Z
    //   107: aload_0
    //   108: invokespecial d : ()V
    //   111: goto -> 283
    //   114: aload_1
    //   115: invokevirtual getX : ()F
    //   118: fstore_2
    //   119: aload_1
    //   120: invokevirtual getY : ()F
    //   123: fstore_3
    //   124: aload_0
    //   125: getfield l : Z
    //   128: ifeq -> 283
    //   131: aload_1
    //   132: aload_1
    //   133: invokevirtual getActionIndex : ()I
    //   136: invokevirtual getPointerId : (I)I
    //   139: ifne -> 283
    //   142: fload_2
    //   143: aload_0
    //   144: getfield y : Landroid/graphics/RectF;
    //   147: getfield left : F
    //   150: aload_0
    //   151: getfield s : F
    //   154: fsub
    //   155: fcmpl
    //   156: ifle -> 283
    //   159: fload_2
    //   160: aload_0
    //   161: getfield y : Landroid/graphics/RectF;
    //   164: getfield right : F
    //   167: aload_0
    //   168: getfield s : F
    //   171: fadd
    //   172: fcmpg
    //   173: ifge -> 283
    //   176: fload_3
    //   177: aload_0
    //   178: getfield y : Landroid/graphics/RectF;
    //   181: getfield top : F
    //   184: aload_0
    //   185: getfield s : F
    //   188: fsub
    //   189: fcmpl
    //   190: ifle -> 283
    //   193: fload_3
    //   194: aload_0
    //   195: getfield y : Landroid/graphics/RectF;
    //   198: getfield bottom : F
    //   201: aload_0
    //   202: getfield s : F
    //   205: fadd
    //   206: fcmpg
    //   207: ifge -> 283
    //   210: aload_0
    //   211: getfield k : Ljava/lang/String;
    //   214: ifnull -> 283
    //   217: aload_0
    //   218: invokespecial i : ()V
    //   221: aload_0
    //   222: iconst_1
    //   223: putfield m : Z
    //   226: aload_0
    //   227: iconst_1
    //   228: invokevirtual e : (I)V
    //   231: aload_0
    //   232: aload_0
    //   233: invokevirtual getContext : ()Landroid/content/Context;
    //   236: ldc_w 7.0
    //   239: invokestatic a : (Landroid/content/Context;F)I
    //   242: i2f
    //   243: putfield t : F
    //   246: aload_0
    //   247: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   250: iconst_1
    //   251: invokeinterface requestDisallowInterceptTouchEvent : (Z)V
    //   256: aload_0
    //   257: iconst_1
    //   258: invokevirtual a : (Z)V
    //   261: aload_0
    //   262: getfield C : Landroid/graphics/PointF;
    //   265: aload_1
    //   266: invokevirtual getRawX : ()F
    //   269: putfield x : F
    //   272: aload_0
    //   273: getfield C : Landroid/graphics/PointF;
    //   276: aload_1
    //   277: invokevirtual getRawY : ()F
    //   280: putfield y : F
    //   283: aload_0
    //   284: getfield m : Z
    //   287: ifne -> 298
    //   290: aload_0
    //   291: aload_1
    //   292: invokespecial onTouchEvent : (Landroid/view/MotionEvent;)Z
    //   295: ifeq -> 301
    //   298: iconst_1
    //   299: istore #5
    //   301: iload #5
    //   303: ireturn
  }
  
  class BadgeContainer extends ViewGroup {
    public BadgeContainer(QBadgeView this$0, Context param1Context) {
      super(param1Context);
    }
    
    protected void onLayout(boolean param1Boolean, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      for (param1Int1 = 0; param1Int1 < getChildCount(); param1Int1++) {
        View view = getChildAt(param1Int1);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
      } 
    }
    
    protected void onMeasure(int param1Int1, int param1Int2) {
      View view2 = null;
      int i = 0;
      View view1 = null;
      while (i < getChildCount()) {
        View view = getChildAt(i);
        if (!(view instanceof QBadgeView)) {
          view2 = view;
        } else {
          view1 = view;
        } 
        i++;
      } 
      if (view2 == null) {
        super.onMeasure(param1Int1, param1Int2);
        return;
      } 
      view2.measure(param1Int1, param1Int2);
      if (view1 != null)
        view1.measure(View.MeasureSpec.makeMeasureSpec(view2.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view2.getMeasuredHeight(), 1073741824)); 
      setMeasuredDimension(view2.getMeasuredWidth(), view2.getMeasuredHeight());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\badgeview\QBadgeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */