package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.blued.android.module.live_china.R;

public class WaveLoadingView extends View {
  private static final int a = Color.parseColor("#212121");
  
  private static final int b = Color.parseColor("#00000000");
  
  private static final int c = Color.parseColor("#212121");
  
  private static final int d = ShapeType.b.ordinal();
  
  private static final int e = TriangleDirection.a.ordinal();
  
  private Paint A;
  
  private Paint B;
  
  private Paint C;
  
  private Paint D;
  
  private Paint E;
  
  private Paint F;
  
  private Paint G;
  
  private Paint H;
  
  private ObjectAnimator I;
  
  private AnimatorSet J;
  
  private Context K;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private float i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private String o;
  
  private String p;
  
  private String q;
  
  private float r;
  
  private float s = 1.0F;
  
  private float t = 0.0F;
  
  private int u = 50;
  
  private boolean v;
  
  private BitmapShader w;
  
  private Bitmap x;
  
  private Matrix y;
  
  private Paint z;
  
  public WaveLoadingView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WaveLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(float paramFloat) {
    return (int)(paramFloat * (this.K.getResources().getDisplayMetrics()).scaledDensity + 0.5F);
  }
  
  private int a(int paramInt) {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    return (i == 1073741824) ? paramInt : ((i == Integer.MIN_VALUE) ? paramInt : this.h);
  }
  
  private int a(int paramInt, float paramFloat) {
    return Color.argb(Math.round(Color.alpha(paramInt) * paramFloat), Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt));
  }
  
  private Path a(Point paramPoint, int paramInt1, int paramInt2, int paramInt3) {
    Object object;
    Point point = null;
    if (paramInt3 == 0) {
      point = new Point(paramPoint.x + paramInt1, paramPoint.y);
      paramInt3 = paramPoint.x;
      paramInt1 /= 2;
      double d = paramInt2;
      object = new Point(paramInt3 + paramInt1, (int)(d - Math.sqrt(3.0D) / 2.0D * d));
    } else if (paramInt3 == 1) {
      point = new Point(paramPoint.x, paramPoint.y - paramInt2);
      object = new Point(paramPoint.x + paramInt1, paramPoint.y - paramInt2);
      paramPoint.x += paramInt1 / 2;
      paramPoint.y = (int)(Math.sqrt(3.0D) / 2.0D * paramInt2);
    } else if (paramInt3 == 2) {
      point = new Point(paramPoint.x, paramPoint.y - paramInt2);
      object = new Point((int)(Math.sqrt(3.0D) / 2.0D * paramInt1), paramPoint.y / 2);
    } else if (paramInt3 == 3) {
      point = new Point(paramPoint.x + paramInt1, paramPoint.y - paramInt2);
      object = new Point(paramPoint.x + paramInt1, paramPoint.y);
      double d = paramInt1;
      paramPoint.x = (int)(d - Math.sqrt(3.0D) / 2.0D * d);
      paramPoint.y /= 2;
    } else {
      object = null;
    } 
    Path path = new Path();
    path.moveTo(paramPoint.x, paramPoint.y);
    path.lineTo(point.x, point.y);
    path.lineTo(((Point)object).x, ((Point)object).y);
    return path;
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    this.K = paramContext;
    this.y = new Matrix();
    this.z = new Paint();
    this.z.setAntiAlias(true);
    this.A = new Paint();
    this.A.setAntiAlias(true);
    e();
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WaveLoadingView, paramInt, 0);
    this.l = typedArray.getInteger(R.styleable.WaveLoadingView_wlv_shapeType, d);
    this.k = typedArray.getColor(R.styleable.WaveLoadingView_wlv_waveColor, a);
    this.j = typedArray.getColor(R.styleable.WaveLoadingView_wlv_wave_background_Color, b);
    this.A.setColor(this.j);
    float f2 = typedArray.getFloat(R.styleable.WaveLoadingView_wlv_waveAmplitude, 50.0F) / 1000.0F;
    float f1 = f2;
    if (f2 > 0.1F)
      f1 = 0.1F; 
    this.i = f1;
    this.u = typedArray.getInteger(R.styleable.WaveLoadingView_wlv_progressValue, 50);
    setProgressValue(this.u);
    this.v = typedArray.getBoolean(R.styleable.WaveLoadingView_wlv_round_rectangle, false);
    this.n = typedArray.getInteger(R.styleable.WaveLoadingView_wlv_round_rectangle_x_and_y, 30);
    this.m = typedArray.getInteger(R.styleable.WaveLoadingView_wlv_triangle_direction, e);
    this.B = new Paint();
    this.B.setAntiAlias(true);
    this.B.setStyle(Paint.Style.STROKE);
    this.B.setStrokeWidth(typedArray.getDimension(R.styleable.WaveLoadingView_wlv_borderWidth, b(0.0F)));
    this.B.setColor(typedArray.getColor(R.styleable.WaveLoadingView_wlv_borderColor, a));
    this.C = new Paint();
    this.C.setColor(typedArray.getColor(R.styleable.WaveLoadingView_wlv_titleTopColor, c));
    this.C.setStyle(Paint.Style.FILL);
    this.C.setAntiAlias(true);
    this.C.setTextSize(typedArray.getDimension(R.styleable.WaveLoadingView_wlv_titleTopSize, a(18.0F)));
    this.F = new Paint();
    this.F.setColor(typedArray.getColor(R.styleable.WaveLoadingView_wlv_titleTopStrokeColor, 0));
    this.F.setStrokeWidth(typedArray.getDimension(R.styleable.WaveLoadingView_wlv_titleTopStrokeWidth, b(0.0F)));
    this.F.setStyle(Paint.Style.STROKE);
    this.F.setAntiAlias(true);
    this.F.setTextSize(this.C.getTextSize());
    this.o = typedArray.getString(R.styleable.WaveLoadingView_wlv_titleTop);
    this.E = new Paint();
    this.E.setColor(typedArray.getColor(R.styleable.WaveLoadingView_wlv_titleCenterColor, c));
    this.E.setStyle(Paint.Style.FILL);
    this.E.setAntiAlias(true);
    this.E.setTextSize(typedArray.getDimension(R.styleable.WaveLoadingView_wlv_titleCenterSize, a(22.0F)));
    this.H = new Paint();
    this.H.setColor(typedArray.getColor(R.styleable.WaveLoadingView_wlv_titleCenterStrokeColor, 0));
    this.H.setStrokeWidth(typedArray.getDimension(R.styleable.WaveLoadingView_wlv_titleCenterStrokeWidth, b(0.0F)));
    this.H.setStyle(Paint.Style.STROKE);
    this.H.setAntiAlias(true);
    this.H.setTextSize(this.E.getTextSize());
    this.p = typedArray.getString(R.styleable.WaveLoadingView_wlv_titleCenter);
    this.D = new Paint();
    this.D.setColor(typedArray.getColor(R.styleable.WaveLoadingView_wlv_titleBottomColor, c));
    this.D.setStyle(Paint.Style.FILL);
    this.D.setAntiAlias(true);
    this.D.setTextSize(typedArray.getDimension(R.styleable.WaveLoadingView_wlv_titleBottomSize, a(18.0F)));
    this.G = new Paint();
    this.G.setColor(typedArray.getColor(R.styleable.WaveLoadingView_wlv_titleBottomStrokeColor, 0));
    this.G.setStrokeWidth(typedArray.getDimension(R.styleable.WaveLoadingView_wlv_titleBottomStrokeWidth, b(0.0F)));
    this.G.setStyle(Paint.Style.STROKE);
    this.G.setAntiAlias(true);
    this.G.setTextSize(this.D.getTextSize());
    this.q = typedArray.getString(R.styleable.WaveLoadingView_wlv_titleBottom);
    typedArray.recycle();
  }
  
  private int b(float paramFloat) {
    return (int)(paramFloat * (this.K.getResources().getDisplayMetrics()).density + 0.5F);
  }
  
  private int b(int paramInt) {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i != 1073741824 && i != Integer.MIN_VALUE)
      paramInt = this.g; 
    return paramInt + 2;
  }
  
  private void c() {
    if (this.x == null || d()) {
      Bitmap bitmap = this.x;
      if (bitmap != null)
        bitmap.recycle(); 
      int j = getMeasuredWidth();
      int i = getMeasuredHeight();
      if (j > 0 && i > 0) {
        double d = 6.283185307179586D / j;
        float f1 = i;
        this.r = f1 * 0.5F;
        float f2 = j;
        Bitmap bitmap1 = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Paint paint = new Paint();
        paint.setStrokeWidth(2.0F);
        paint.setAntiAlias(true);
        j++;
        int k = i + 1;
        float[] arrayOfFloat = new float[j];
        paint.setColor(a(this.k, 0.3F));
        for (i = 0; i < j; i++) {
          double d1 = i;
          float f3 = (float)(this.r + (0.1F * f1) * Math.sin(d1 * d));
          float f4 = i;
          canvas.drawLine(f4, f3, f4, k, paint);
          arrayOfFloat[i] = f3;
        } 
        paint.setColor(this.k);
        int m = (int)(f2 / 4.0F);
        for (i = 0; i < j; i++) {
          f1 = i;
          canvas.drawLine(f1, arrayOfFloat[(i + m) % j], f1, k, paint);
        } 
        this.w = new BitmapShader(bitmap1, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
        this.z.setShader((Shader)this.w);
      } 
    } 
  }
  
  private boolean d() {
    return (getMeasuredWidth() != this.x.getWidth() || getMeasuredHeight() != this.x.getHeight());
  }
  
  private void e() {
    this.I = ObjectAnimator.ofFloat(this, "waveShiftRatio", new float[] { 0.0F, 1.0F });
    this.I.setRepeatCount(-1);
    this.I.setDuration(1000L);
    this.I.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.J = new AnimatorSet();
    this.J.play((Animator)this.I);
  }
  
  public void a() {
    AnimatorSet animatorSet = this.J;
    if (animatorSet != null)
      animatorSet.start(); 
  }
  
  public void b() {
    AnimatorSet animatorSet = this.J;
    if (animatorSet != null)
      animatorSet.cancel(); 
  }
  
  public float getAmplitudeRatio() {
    return this.i;
  }
  
  public int getBorderColor() {
    return this.B.getColor();
  }
  
  public float getBorderWidth() {
    return this.B.getStrokeWidth();
  }
  
  public String getBottomTitle() {
    return this.q;
  }
  
  public int getBottomTitleColor() {
    return this.D.getColor();
  }
  
  public float getBottomTitleSize() {
    return this.D.getTextSize();
  }
  
  public String getCenterTitle() {
    return this.p;
  }
  
  public int getCenterTitleColor() {
    return this.E.getColor();
  }
  
  public float getCenterTitleSize() {
    return this.E.getTextSize();
  }
  
  public int getProgressValue() {
    return this.u;
  }
  
  public int getShapeType() {
    return this.l;
  }
  
  public String getTopTitle() {
    return this.o;
  }
  
  public int getTopTitleColor() {
    return this.C.getColor();
  }
  
  public float getWaterLevelRatio() {
    return this.s;
  }
  
  public int getWaveBgColor() {
    return this.j;
  }
  
  public int getWaveColor() {
    return this.k;
  }
  
  public float getWaveShiftRatio() {
    return this.t;
  }
  
  public float getsetTopTitleSize() {
    return this.C.getTextSize();
  }
  
  protected void onAttachedToWindow() {
    a();
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow() {
    b();
    super.onDetachedFromWindow();
  }
  
  public void onDraw(Canvas paramCanvas) {
    this.f = paramCanvas.getWidth();
    if (paramCanvas.getHeight() < this.f)
      this.f = paramCanvas.getHeight(); 
    if (this.w != null) {
      if (this.z.getShader() == null)
        this.z.setShader((Shader)this.w); 
      this.y.setScale(1.0F, this.i / 0.1F, 0.0F, this.r);
      this.y.postTranslate(this.t * getWidth(), (0.5F - this.s) * getHeight());
      this.w.setLocalMatrix(this.y);
      float f = this.B.getStrokeWidth();
      int i = this.l;
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i == 3)
              if (this.v) {
                if (f > 0.0F) {
                  f /= 2.0F;
                  RectF rectF = new RectF(f, f, getWidth() - f - 0.5F, getHeight() - f - 0.5F);
                  i = this.n;
                  paramCanvas.drawRoundRect(rectF, i, i, this.B);
                  i = this.n;
                  paramCanvas.drawRoundRect(rectF, i, i, this.A);
                  i = this.n;
                  paramCanvas.drawRoundRect(rectF, i, i, this.z);
                } else {
                  RectF rectF = new RectF(0.0F, 0.0F, getWidth(), getHeight());
                  i = this.n;
                  paramCanvas.drawRoundRect(rectF, i, i, this.A);
                  i = this.n;
                  paramCanvas.drawRoundRect(rectF, i, i, this.z);
                } 
              } else if (f > 0.0F) {
                f /= 2.0F;
                paramCanvas.drawRect(f, f, getWidth() - f - 0.5F, getHeight() - f - 0.5F, this.A);
                paramCanvas.drawRect(f, f, getWidth() - f - 0.5F, getHeight() - f - 0.5F, this.z);
              } else {
                paramCanvas.drawRect(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), this.A);
                paramCanvas.drawRect(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), this.z);
              }  
          } else {
            if (f > 0.0F) {
              float f1 = f / 2.0F;
              paramCanvas.drawRect(f1, f1, getWidth() - f1 - 0.5F, getHeight() - f1 - 0.5F, this.B);
            } 
            paramCanvas.drawRect(f, f, getWidth() - f, getHeight() - f, this.A);
            paramCanvas.drawRect(f, f, getWidth() - f, getHeight() - f, this.z);
          } 
        } else {
          if (f > 0.0F)
            paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, (getWidth() - f) / 2.0F - 1.0F, this.B); 
          f = getWidth() / 2.0F - f;
          paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, f, this.A);
          paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, f, this.z);
        } 
      } else {
        Path path = a(new Point(0, getHeight()), getWidth(), getHeight(), this.m);
        paramCanvas.drawPath(path, this.A);
        paramCanvas.drawPath(path, this.z);
      } 
      if (!TextUtils.isEmpty(this.o)) {
        f = this.C.measureText(this.o);
        paramCanvas.drawText(this.o, (getWidth() - f) / 2.0F, (getHeight() * 2) / 10.0F, this.F);
        paramCanvas.drawText(this.o, (getWidth() - f) / 2.0F, (getHeight() * 2) / 10.0F, this.C);
      } 
      if (!TextUtils.isEmpty(this.p)) {
        f = this.E.measureText(this.p);
        paramCanvas.drawText(this.p, (getWidth() - f) / 2.0F, (getHeight() / 2) - (this.H.descent() + this.H.ascent()) / 2.0F, this.H);
        paramCanvas.drawText(this.p, (getWidth() - f) / 2.0F, (getHeight() / 2) - (this.E.descent() + this.E.ascent()) / 2.0F, this.E);
      } 
      if (!TextUtils.isEmpty(this.q)) {
        f = this.D.measureText(this.q);
        paramCanvas.drawText(this.q, (getWidth() - f) / 2.0F, (getHeight() * 8) / 10.0F - (this.G.descent() + this.G.ascent()) / 2.0F, this.G);
        paramCanvas.drawText(this.q, (getWidth() - f) / 2.0F, (getHeight() * 8) / 10.0F - (this.D.descent() + this.D.ascent()) / 2.0F, this.D);
        return;
      } 
    } else {
      this.z.setShader(null);
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    paramInt1 = a(paramInt1);
    paramInt2 = b(paramInt2);
    if (getShapeType() == 3) {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
    } 
    if (paramInt1 >= paramInt2)
      paramInt1 = paramInt2; 
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (getShapeType() == 3) {
      this.h = paramInt1;
      this.g = paramInt2;
    } else {
      this.f = paramInt1;
      if (paramInt2 < this.f)
        this.f = paramInt2; 
    } 
    c();
  }
  
  public void setAmplitudeRatio(int paramInt) {
    float f1 = this.i;
    float f2 = paramInt / 1000.0F;
    if (f1 != f2) {
      this.i = f2;
      invalidate();
    } 
  }
  
  public void setAnimDuration(long paramLong) {
    this.I.setDuration(paramLong);
  }
  
  public void setBorderColor(int paramInt) {
    this.B.setColor(paramInt);
    c();
    invalidate();
  }
  
  public void setBorderWidth(float paramFloat) {
    this.B.setStrokeWidth(paramFloat);
    invalidate();
  }
  
  public void setBottomTitle(String paramString) {
    this.q = paramString;
  }
  
  public void setBottomTitleColor(int paramInt) {
    this.D.setColor(paramInt);
  }
  
  public void setBottomTitleSize(float paramFloat) {
    this.D.setTextSize(a(paramFloat));
  }
  
  public void setBottomTitleStrokeColor(int paramInt) {
    this.G.setColor(paramInt);
  }
  
  public void setBottomTitleStrokeWidth(float paramFloat) {
    this.G.setStrokeWidth(b(paramFloat));
  }
  
  public void setCenterTitle(String paramString) {
    this.p = paramString;
  }
  
  public void setCenterTitleColor(int paramInt) {
    this.E.setColor(paramInt);
  }
  
  public void setCenterTitleSize(float paramFloat) {
    this.E.setTextSize(a(paramFloat));
  }
  
  public void setCenterTitleStrokeColor(int paramInt) {
    this.H.setColor(paramInt);
  }
  
  public void setCenterTitleStrokeWidth(float paramFloat) {
    this.H.setStrokeWidth(b(paramFloat));
  }
  
  public void setProgressValue(int paramInt) {
    this.u = paramInt;
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, "waterLevelRatio", new float[] { this.s, this.u / 100.0F });
    objectAnimator.setDuration(1000L);
    objectAnimator.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.play((Animator)objectAnimator);
    animatorSet.start();
  }
  
  public void setShapeType(ShapeType paramShapeType) {
    this.l = paramShapeType.ordinal();
    invalidate();
  }
  
  public void setTopTitle(String paramString) {
    this.o = paramString;
  }
  
  public void setTopTitleColor(int paramInt) {
    this.C.setColor(paramInt);
  }
  
  public void setTopTitleSize(float paramFloat) {
    this.C.setTextSize(a(paramFloat));
  }
  
  public void setTopTitleStrokeColor(int paramInt) {
    this.F.setColor(paramInt);
  }
  
  public void setTopTitleStrokeWidth(float paramFloat) {
    this.F.setStrokeWidth(b(paramFloat));
  }
  
  public void setWaterLevelRatio(float paramFloat) {
    if (this.s != paramFloat) {
      this.s = paramFloat;
      invalidate();
    } 
  }
  
  public void setWaveBgColor(int paramInt) {
    this.j = paramInt;
    this.A.setColor(this.j);
    c();
    invalidate();
  }
  
  public void setWaveColor(int paramInt) {
    this.k = paramInt;
    c();
    invalidate();
  }
  
  public void setWaveShiftRatio(float paramFloat) {
    if (this.t != paramFloat) {
      this.t = paramFloat;
      invalidate();
    } 
  }
  
  public enum ShapeType {
    a, b, c, d;
  }
  
  public enum TriangleDirection {
    a, b, c, d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\WaveLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */