package com.soft.blued.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;

public class ScalableImageView extends AppCompatImageView {
  private Matrix a;
  
  private Matrix b;
  
  private float c = 1.0F;
  
  private float d;
  
  private float e = 0.0F;
  
  private boolean f;
  
  private boolean g;
  
  private boolean h;
  
  private boolean i;
  
  private Mode j;
  
  private Context k;
  
  private PointF l = new PointF();
  
  private PointF m = new PointF();
  
  public ScalableImageView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ScalableImageView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScalableImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.k = paramContext;
    c();
  }
  
  private void a(float paramFloat1, float paramFloat2) {
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    valueAnimator.setDuration(500L).start();
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            if (!ScalableImageView.a(this.a)) {
              param1ValueAnimator.cancel();
              return;
            } 
            float f2 = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ScaleValues: ");
            stringBuilder.append(f2);
            Log.i("ScalableImageView", stringBuilder.toString());
            if (ScalableImageView.b(this.a)) {
              f1 = ScalableImageView.c(this.a).width();
            } else {
              f1 = ScalableImageView.c(this.a).height();
            } 
            float f1 = f2 / f1;
            ScalableImageView.d(this.a).postScale(f1, f1, (this.a.getMeasuredWidth() / 2), (this.a.getMeasuredHeight() / 2));
            ScalableImageView scalableImageView = this.a;
            scalableImageView.setImageMatrix(ScalableImageView.d(scalableImageView));
          }
        });
    valueAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) {
            super.onAnimationEnd(param1Animator);
            ScalableImageView.e(this.a).set(ScalableImageView.d(this.a));
            ScalableImageView.a(this.a, false);
          }
        });
  }
  
  private void a(PointF paramPointF, MotionEvent paramMotionEvent) {
    float f1 = paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getX(1);
    float f3 = paramMotionEvent.getY(0);
    float f4 = paramMotionEvent.getY(1);
    paramPointF.set((f1 + f2) / 2.0F, (f3 + f4) / 2.0F);
  }
  
  private void a(MotionEvent paramMotionEvent) {
    float f1 = b(paramMotionEvent);
    float f2 = f1 / this.c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("move: ");
    stringBuilder.append(f1);
    Log.v("ScalableImageView", stringBuilder.toString());
    if (f1 > 10.0F)
      this.a.postScale(f2, f2, (getMeasuredWidth() / 2), (getMeasuredHeight() / 2)); 
    RectF rectF = getMatrixRectf();
    if (f()) {
      if (f2 < 1.0F) {
        if (rectF.width() < getMeasuredWidth()) {
          this.a.postTranslate((getMeasuredWidth() - rectF.right - rectF.left) / 2.0F, 0.0F);
          return;
        } 
        if (rectF.left >= 0.0F && rectF.right - getMeasuredWidth() > 0.0F) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("postTranslate: ");
          stringBuilder1.append(-rectF.left);
          Log.v("ScalableImageView", stringBuilder1.toString());
          this.a.postTranslate(-rectF.left, 0.0F);
          return;
        } 
        if (rectF.right - getMeasuredWidth() <= 0.0F && rectF.left < 0.0F) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("postTranslate: ");
          stringBuilder1.append(getMeasuredWidth() - rectF.right);
          Log.v("ScalableImageView", stringBuilder1.toString());
          this.a.postTranslate(getMeasuredWidth() - rectF.right, 0.0F);
          return;
        } 
      } 
    } else if (f2 < 1.0F) {
      if (rectF.height() < getMeasuredHeight()) {
        this.a.postTranslate(0.0F, (getMeasuredHeight() - rectF.bottom - rectF.top) / 2.0F);
        return;
      } 
      if (rectF.top >= 0.0F && rectF.bottom - getMeasuredHeight() > 0.0F) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("postTranslate: ");
        stringBuilder1.append(-rectF.top);
        Log.v("ScalableImageView", stringBuilder1.toString());
        this.a.postTranslate(0.0F, -rectF.top);
        return;
      } 
      if (rectF.bottom - getMeasuredHeight() <= 0.0F && rectF.top < 0.0F) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("postTranslate: ");
        stringBuilder1.append(getMeasuredHeight() - rectF.bottom);
        Log.v("ScalableImageView", stringBuilder1.toString());
        this.a.postTranslate(0.0F, getMeasuredHeight() - rectF.bottom);
      } 
    } 
  }
  
  private void a(boolean paramBoolean) {
    int i;
    RectF rectF = getMatrixRectf();
    if (f()) {
      i = getMeasuredWidth();
    } else {
      i = getMeasuredHeight();
    } 
    i /= 6;
    if (f()) {
      if (rectF.width() <= getMeasuredWidth()) {
        if (!paramBoolean) {
          float f1 = rectF.left;
          float f2 = i;
          if (f1 >= f2 || getMeasuredWidth() - rectF.right > f2) {
            this.h = true;
            f1 = getMeasuredWidth() / rectF.width();
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("postScale: ");
            stringBuilder1.append(f1);
            Log.v("ScalableImageView", stringBuilder1.toString());
            a(rectF.width(), getMeasuredWidth());
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("postTranslate: ");
            stringBuilder1.append(-(getMatrixRectf()).left);
            Log.v("ScalableImageView", stringBuilder1.toString());
            b(0.0F, (getMeasuredWidth() - rectF.right - rectF.left) / 2.0F);
            return;
          } 
          return;
        } 
      } else {
        return;
      } 
    } else {
      if (rectF.height() <= getMeasuredHeight()) {
        if (!paramBoolean) {
          float f2 = rectF.top;
          float f3 = i;
          if (f2 >= f3 || getMeasuredHeight() - rectF.bottom > f3) {
            this.h = true;
            f2 = getMeasuredHeight() / rectF.height();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("postScale: ");
            stringBuilder2.append(f2);
            Log.v("ScalableImageView", stringBuilder2.toString());
            a(rectF.height(), getMeasuredHeight());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("postTranslate: ");
            stringBuilder2.append(-(getMatrixRectf()).top);
            Log.v("ScalableImageView", stringBuilder2.toString());
            b(0.0F, (getMeasuredHeight() - rectF.bottom - rectF.top) / 2.0F);
          } 
          return;
        } 
      } else {
        return;
      } 
      this.h = true;
      float f1 = getMeasuredHeight() / rectF.height();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("postScale: ");
      stringBuilder1.append(f1);
      Log.v("ScalableImageView", stringBuilder1.toString());
      a(rectF.height(), getMeasuredHeight());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("postTranslate: ");
      stringBuilder1.append(-(getMatrixRectf()).top);
      Log.v("ScalableImageView", stringBuilder1.toString());
      b(0.0F, (getMeasuredHeight() - rectF.bottom - rectF.top) / 2.0F);
    } 
    this.h = true;
    float f = getMeasuredWidth() / rectF.width();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("postScale: ");
    stringBuilder.append(f);
    Log.v("ScalableImageView", stringBuilder.toString());
    a(rectF.width(), getMeasuredWidth());
    stringBuilder = new StringBuilder();
    stringBuilder.append("postTranslate: ");
    stringBuilder.append(-(getMatrixRectf()).left);
    Log.v("ScalableImageView", stringBuilder.toString());
    b(0.0F, (getMeasuredWidth() - rectF.right - rectF.left) / 2.0F);
  }
  
  private float b(MotionEvent paramMotionEvent) {
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return (float)Math.sqrt((f1 * f1 + f2 * f2));
  }
  
  private void b(float paramFloat1, float paramFloat2) {
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    valueAnimator.setDuration(500L).start();
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          float a = 0.0F;
          
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            if (!ScalableImageView.a(this.b)) {
              param1ValueAnimator.cancel();
              return;
            } 
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TranslateValues: ");
            stringBuilder.append(f);
            Log.i("ScalableImageView", stringBuilder.toString());
            f -= this.a;
            if (ScalableImageView.b(this.b)) {
              ScalableImageView.d(this.b).postTranslate(f, 0.0F);
            } else {
              ScalableImageView.d(this.b).postTranslate(0.0F, f);
            } 
            ScalableImageView scalableImageView = this.b;
            scalableImageView.setImageMatrix(ScalableImageView.d(scalableImageView));
            this.a += f;
          }
        });
  }
  
  private float c(MotionEvent paramMotionEvent) {
    double d = (paramMotionEvent.getX(0) - paramMotionEvent.getX(1));
    return (float)Math.toDegrees(Math.atan2((paramMotionEvent.getY(0) - paramMotionEvent.getY(1)), d));
  }
  
  private void c() {
    this.a = new Matrix();
    this.b = new Matrix();
    this.j = Mode.a;
  }
  
  private void d() {
    RectF rectF = getMatrixRectf();
    if (f()) {
      if (rectF.top > 0.0F || rectF.bottom - getMeasuredHeight() < 0.0F) {
        this.a.postTranslate(0.0F, (getMeasuredHeight() - rectF.bottom - rectF.top) / 2.0F);
        return;
      } 
    } else if (rectF.left > 0.0F || rectF.right - getMeasuredWidth() < 0.0F) {
      this.a.postTranslate((getMeasuredWidth() - rectF.right - rectF.left) / 2.0F, 0.0F);
    } 
  }
  
  private void e() {
    RectF rectF = getMatrixRectf();
    if (f()) {
      if (rectF.top >= 0.0F) {
        this.a.postTranslate(0.0F, -rectF.top);
        return;
      } 
      if (rectF.bottom - getMeasuredHeight() <= 0.0F) {
        this.a.postTranslate(0.0F, getMeasuredHeight() - rectF.bottom);
        return;
      } 
    } else {
      if (rectF.left >= 0.0F) {
        this.a.postTranslate(-rectF.left, 0.0F);
        return;
      } 
      if (rectF.right - getMeasuredWidth() <= 0.0F)
        this.a.postTranslate(getMeasuredWidth() - rectF.right, 0.0F); 
    } 
  }
  
  private boolean f() {
    return (getMatrixRectf().width() / getMatrixRectf().height() > getMeasuredWidth() / getMeasuredHeight());
  }
  
  private void g() {
    RectF rectF = getMatrixRectf();
    int i = getWidth();
    int j = getHeight();
    float f1 = rectF.top;
    float f3 = 0.0F;
    if (f1 > 0.0F && this.g) {
      f1 = -rectF.top;
    } else {
      f1 = 0.0F;
    } 
    float f4 = rectF.bottom;
    float f5 = j;
    float f2 = f1;
    if (f4 < f5) {
      f2 = f1;
      if (this.g)
        f2 = f5 - rectF.bottom; 
    } 
    f1 = f3;
    if (rectF.left > 0.0F) {
      f1 = f3;
      if (this.f)
        f1 = -rectF.left; 
    } 
    f4 = rectF.right;
    f5 = i;
    f3 = f1;
    if (f4 < f5) {
      f3 = f1;
      if (this.f)
        f3 = f5 - rectF.right; 
    } 
    this.a.postTranslate(f3, f2);
  }
  
  private RectF getMatrixRectf() {
    Matrix matrix = this.a;
    RectF rectF = new RectF();
    if (getDrawable() != null) {
      rectF.set(0.0F, 0.0F, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
      matrix.mapRect(rectF);
    } 
    return rectF;
  }
  
  public void a(float paramFloat) {
    this.a.postScale(paramFloat, paramFloat, getPivotX(), getPivotY());
    setImageMatrix(this.a);
    a(true);
  }
  
  public void a(IRequestHost paramIRequestHost, String paramString) {
    ImageLoader.d(paramIRequestHost, paramString).e().a((ImageView)this);
  }
  
  public boolean a() {
    RectF rectF = getMatrixRectf();
    return (rectF.width() > (getMeasuredWidth() * 2) && rectF.height() > (getMeasuredHeight() * 2));
  }
  
  public void b(float paramFloat) {
    this.a.postRotate(paramFloat, getPivotX(), getPivotY());
    setImageMatrix(this.a);
  }
  
  public boolean b() {
    RectF rectF = getMatrixRectf();
    return (rectF.width() <= getMeasuredWidth() && rectF.height() <= getMeasuredHeight());
  }
  
  public Matrix getNowMatrix() {
    return this.a;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (getDrawable() == null)
      return super.onTouchEvent(paramMotionEvent); 
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0) {
      if (i != 1)
        if (i != 2) {
          if (i != 3)
            if (i != 5) {
              if (i != 6) {
                setImageMatrix(this.a);
                return true;
              } 
            } else {
              this.c = b(paramMotionEvent);
              if (this.c > 10.0F) {
                this.b.set(this.a);
                a(this.m, paramMotionEvent);
                this.j = Mode.c;
              } 
              this.d = c(paramMotionEvent);
              setImageMatrix(this.a);
              return true;
            }  
        } else {
          if (this.j == Mode.b) {
            RectF rectF = getMatrixRectf();
            float f1 = paramMotionEvent.getX() - this.l.x;
            float f2 = paramMotionEvent.getY() - this.l.y;
            this.f = true;
            if (rectF.width() < getWidth()) {
              this.f = false;
              f1 = 0.0F;
            } 
            this.g = true;
            if (rectF.height() < getHeight()) {
              this.g = false;
              f2 = 0.0F;
            } 
            this.a.set(this.b);
            this.a.postTranslate(f1, f2);
            g();
          } else if (this.j == Mode.c && paramMotionEvent.getPointerCount() == 2) {
            this.a.set(this.b);
            this.e = c(paramMotionEvent);
            float f1 = this.e;
            float f2 = this.d;
            this.a.postRotate(f1 - f2, (getMeasuredWidth() / 2), (getMeasuredHeight() / 2));
            a(paramMotionEvent);
            if ((f() && getMatrixRectf().height() > getMeasuredHeight()) || (!f() && getMatrixRectf().width() > getMeasuredWidth())) {
              e();
            } else {
              d();
            } 
          } 
          setImageMatrix(this.a);
          return true;
        }  
      a(true);
      this.i = false;
      this.j = Mode.a;
    } else {
      this.h = false;
      this.b.set(this.a);
      this.j = Mode.b;
      this.l.set(paramMotionEvent.getX(), paramMotionEvent.getY());
    } 
    setImageMatrix(this.a);
    return true;
  }
  
  public void setNowMatrix(Matrix paramMatrix) {
    this.a = paramMatrix;
    this.b.set(paramMatrix);
    setImageMatrix(paramMatrix);
  }
  
  enum Mode {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\ScalableImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */