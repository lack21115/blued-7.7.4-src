package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

public class PhotoViewAttacher implements View.OnLayoutChangeListener, View.OnTouchListener {
  private static float a = 3.0F;
  
  private static float b = 1.75F;
  
  private static float c = 1.0F;
  
  private static int d = 200;
  
  private static int e = 1;
  
  private OnScaleChangedListener A;
  
  private OnSingleFlingListener B;
  
  private OnViewDragListener C;
  
  private FlingRunnable D;
  
  private int E = 2;
  
  private int F = 2;
  
  private float G;
  
  private boolean H = true;
  
  private ImageView.ScaleType I = ImageView.ScaleType.FIT_CENTER;
  
  private OnGestureListener J = new OnGestureListener(this) {
      public void a(float param1Float1, float param1Float2) {
        if (PhotoViewAttacher.a(this.a).a())
          return; 
        if (PhotoViewAttacher.b(this.a) != null)
          PhotoViewAttacher.b(this.a).a(param1Float1, param1Float2); 
        PhotoViewAttacher.c(this.a).postTranslate(param1Float1, param1Float2);
        PhotoViewAttacher.d(this.a);
        ViewParent viewParent = PhotoViewAttacher.e(this.a).getParent();
        if (PhotoViewAttacher.f(this.a) && !PhotoViewAttacher.a(this.a).a() && !PhotoViewAttacher.g(this.a)) {
          if ((PhotoViewAttacher.h(this.a) == 2 || (PhotoViewAttacher.h(this.a) == 0 && param1Float1 >= 1.0F) || (PhotoViewAttacher.h(this.a) == 1 && param1Float1 <= -1.0F) || (PhotoViewAttacher.i(this.a) == 0 && param1Float2 >= 1.0F) || (PhotoViewAttacher.i(this.a) == 1 && param1Float2 <= -1.0F)) && viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(false);
            return;
          } 
        } else if (viewParent != null) {
          viewParent.requestDisallowInterceptTouchEvent(true);
        } 
      }
      
      public void a(float param1Float1, float param1Float2, float param1Float3) {
        if (this.a.e() < PhotoViewAttacher.k(this.a) || param1Float1 < 1.0F) {
          if (PhotoViewAttacher.l(this.a) != null)
            PhotoViewAttacher.l(this.a).a(param1Float1, param1Float2, param1Float3); 
          PhotoViewAttacher.c(this.a).postScale(param1Float1, param1Float1, param1Float2, param1Float3);
          PhotoViewAttacher.d(this.a);
        } 
      }
      
      public void a(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
        PhotoViewAttacher photoViewAttacher1 = this.a;
        PhotoViewAttacher.a(photoViewAttacher1, new PhotoViewAttacher.FlingRunnable(photoViewAttacher1, PhotoViewAttacher.e(photoViewAttacher1).getContext()));
        PhotoViewAttacher.FlingRunnable flingRunnable = PhotoViewAttacher.j(this.a);
        PhotoViewAttacher photoViewAttacher2 = this.a;
        int i = PhotoViewAttacher.a(photoViewAttacher2, PhotoViewAttacher.e(photoViewAttacher2));
        photoViewAttacher2 = this.a;
        flingRunnable.a(i, PhotoViewAttacher.b(photoViewAttacher2, PhotoViewAttacher.e(photoViewAttacher2)), (int)param1Float3, (int)param1Float4);
        PhotoViewAttacher.e(this.a).post(PhotoViewAttacher.j(this.a));
      }
    };
  
  private Interpolator f = (Interpolator)new AccelerateDecelerateInterpolator();
  
  private int g = d;
  
  private float h = c;
  
  private float i = b;
  
  private float j = a;
  
  private boolean k = true;
  
  private boolean l = false;
  
  private ImageView m;
  
  private GestureDetector n;
  
  private CustomGestureDetector o;
  
  private final Matrix p = new Matrix();
  
  private final Matrix q = new Matrix();
  
  private final Matrix r = new Matrix();
  
  private final RectF s = new RectF();
  
  private final float[] t = new float[9];
  
  private OnMatrixChangedListener u;
  
  private OnPhotoTapListener v;
  
  private OnOutsidePhotoTapListener w;
  
  private OnViewTapListener x;
  
  private View.OnClickListener y;
  
  private View.OnLongClickListener z;
  
  public PhotoViewAttacher(ImageView paramImageView) {
    this.m = paramImageView;
    paramImageView.setOnTouchListener(this);
    paramImageView.addOnLayoutChangeListener(this);
    if (paramImageView.isInEditMode())
      return; 
    this.G = 0.0F;
    this.o = new CustomGestureDetector(paramImageView.getContext(), this.J);
    this.n = new GestureDetector(paramImageView.getContext(), (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
          public boolean onFling(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
            if (PhotoViewAttacher.n(this.a) != null) {
              if (this.a.e() > PhotoViewAttacher.i())
                return false; 
              if (param1MotionEvent1.getPointerCount() <= PhotoViewAttacher.j())
                return (param1MotionEvent2.getPointerCount() > PhotoViewAttacher.j()) ? false : PhotoViewAttacher.n(this.a).a(param1MotionEvent1, param1MotionEvent2, param1Float1, param1Float2); 
            } 
            return false;
          }
          
          public void onLongPress(MotionEvent param1MotionEvent) {
            if (PhotoViewAttacher.m(this.a) != null)
              PhotoViewAttacher.m(this.a).onLongClick((View)PhotoViewAttacher.e(this.a)); 
          }
        });
    this.n.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener(this) {
          public boolean onDoubleTap(MotionEvent param1MotionEvent) {
            try {
              float f1 = this.a.e();
              float f2 = param1MotionEvent.getX();
              float f3 = param1MotionEvent.getY();
              if (f1 < this.a.c()) {
                this.a.a(this.a.c(), f2, f3, true);
                return true;
              } 
              if (f1 >= this.a.c() && f1 < this.a.d()) {
                this.a.a(this.a.d(), f2, f3, true);
                return true;
              } 
              this.a.a(this.a.b(), f2, f3, true);
              return true;
            } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
              return true;
            } 
          }
          
          public boolean onDoubleTapEvent(MotionEvent param1MotionEvent) {
            return false;
          }
          
          public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
            if (PhotoViewAttacher.o(this.a) != null)
              PhotoViewAttacher.o(this.a).onClick((View)PhotoViewAttacher.e(this.a)); 
            RectF rectF = this.a.a();
            float f2 = param1MotionEvent.getX();
            float f1 = param1MotionEvent.getY();
            if (PhotoViewAttacher.p(this.a) != null)
              PhotoViewAttacher.p(this.a).a((View)PhotoViewAttacher.e(this.a), f2, f1); 
            if (rectF != null) {
              if (rectF.contains(f2, f1)) {
                f2 = (f2 - rectF.left) / rectF.width();
                f1 = (f1 - rectF.top) / rectF.height();
                if (PhotoViewAttacher.q(this.a) != null)
                  PhotoViewAttacher.q(this.a).a(PhotoViewAttacher.e(this.a), f2, f1); 
                return true;
              } 
              if (PhotoViewAttacher.r(this.a) != null)
                PhotoViewAttacher.r(this.a).a(PhotoViewAttacher.e(this.a)); 
            } 
            return false;
          }
        });
  }
  
  private float a(Matrix paramMatrix, int paramInt) {
    paramMatrix.getValues(this.t);
    return this.t[paramInt];
  }
  
  private int a(ImageView paramImageView) {
    return paramImageView.getWidth() - paramImageView.getPaddingLeft() - paramImageView.getPaddingRight();
  }
  
  private void a(Matrix paramMatrix) {
    this.m.setImageMatrix(paramMatrix);
    if (this.u != null) {
      RectF rectF = b(paramMatrix);
      if (rectF != null)
        this.u.a(rectF); 
    } 
  }
  
  private void a(Drawable paramDrawable) {
    if (paramDrawable == null)
      return; 
    float f1 = a(this.m);
    float f2 = b(this.m);
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    this.p.reset();
    float f3 = i;
    float f5 = f1 / f3;
    float f4 = j;
    float f6 = f2 / f4;
    if (this.I == ImageView.ScaleType.CENTER) {
      this.p.postTranslate((f1 - f3) / 2.0F, (f2 - f4) / 2.0F);
    } else if (this.I == ImageView.ScaleType.CENTER_CROP) {
      f5 = Math.max(f5, f6);
      this.p.postScale(f5, f5);
      this.p.postTranslate((f1 - f3 * f5) / 2.0F, (f2 - f4 * f5) / 2.0F);
    } else if (this.I == ImageView.ScaleType.CENTER_INSIDE) {
      f5 = Math.min(1.0F, Math.min(f5, f6));
      this.p.postScale(f5, f5);
      this.p.postTranslate((f1 - f3 * f5) / 2.0F, (f2 - f4 * f5) / 2.0F);
    } else {
      RectF rectF1 = new RectF(0.0F, 0.0F, f3, f4);
      RectF rectF2 = new RectF(0.0F, 0.0F, f1, f2);
      if ((int)this.G % 180 != 0)
        rectF1 = new RectF(0.0F, 0.0F, f4, f3); 
      i = null.a[this.I.ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i == 4)
              this.p.setRectToRect(rectF1, rectF2, Matrix.ScaleToFit.FILL); 
          } else {
            this.p.setRectToRect(rectF1, rectF2, Matrix.ScaleToFit.END);
          } 
        } else {
          this.p.setRectToRect(rectF1, rectF2, Matrix.ScaleToFit.START);
        } 
      } else {
        this.p.setRectToRect(rectF1, rectF2, Matrix.ScaleToFit.CENTER);
      } 
    } 
    l();
  }
  
  private int b(ImageView paramImageView) {
    return paramImageView.getHeight() - paramImageView.getPaddingTop() - paramImageView.getPaddingBottom();
  }
  
  private RectF b(Matrix paramMatrix) {
    Drawable drawable = this.m.getDrawable();
    if (drawable != null) {
      this.s.set(0.0F, 0.0F, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
      paramMatrix.mapRect(this.s);
      return this.s;
    } 
    return null;
  }
  
  private Matrix k() {
    this.q.set(this.p);
    this.q.postConcat(this.r);
    return this.q;
  }
  
  private void l() {
    this.r.reset();
    b(this.G);
    a(k());
    n();
  }
  
  private void m() {
    if (n())
      a(k()); 
  }
  
  private boolean n() {
    RectF rectF = b(k());
    if (rectF == null)
      return false; 
    float f1 = rectF.height();
    float f4 = rectF.width();
    float f2 = b(this.m);
    float f3 = 0.0F;
    if (f1 <= f2) {
      int i = null.a[this.I.ordinal()];
      if (i != 2) {
        if (i != 3) {
          f2 = (f2 - f1) / 2.0F;
          f1 = rectF.top;
        } else {
          f2 -= f1;
          f1 = rectF.top;
        } 
        f1 = f2 - f1;
      } else {
        f1 = -rectF.top;
      } 
      this.F = 2;
    } else if (rectF.top > 0.0F) {
      this.F = 0;
      f1 = -rectF.top;
    } else if (rectF.bottom < f2) {
      this.F = 1;
      f1 = f2 - rectF.bottom;
    } else {
      this.F = -1;
      f1 = 0.0F;
    } 
    f2 = a(this.m);
    if (f4 <= f2) {
      int i = null.a[this.I.ordinal()];
      if (i != 2) {
        if (i != 3) {
          f3 = (f2 - f4) / 2.0F;
          f2 = rectF.left;
        } else {
          f3 = f2 - f4;
          f2 = rectF.left;
        } 
        f2 = f3 - f2;
      } else {
        f2 = -rectF.left;
      } 
      this.E = 2;
    } else if (rectF.left > 0.0F) {
      this.E = 0;
      f2 = -rectF.left;
    } else if (rectF.right < f2) {
      f2 -= rectF.right;
      this.E = 1;
    } else {
      this.E = -1;
      f2 = f3;
    } 
    this.r.postTranslate(f2, f1);
    return true;
  }
  
  private void o() {
    FlingRunnable flingRunnable = this.D;
    if (flingRunnable != null) {
      flingRunnable.a();
      this.D = null;
    } 
  }
  
  public RectF a() {
    n();
    return b(k());
  }
  
  public void a(float paramFloat) {
    this.r.setRotate(paramFloat % 360.0F);
    m();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean) {
    if (paramFloat1 >= this.h && paramFloat1 <= this.j) {
      if (paramBoolean) {
        this.m.post(new AnimatedZoomRunnable(this, e(), paramFloat1, paramFloat2, paramFloat3));
        return;
      } 
      this.r.setScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      m();
      return;
    } 
    throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
  }
  
  public void a(float paramFloat, boolean paramBoolean) {
    a(paramFloat, (this.m.getRight() / 2), (this.m.getBottom() / 2), paramBoolean);
  }
  
  public void a(int paramInt) {
    this.g = paramInt;
  }
  
  public void a(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener) {
    this.n.setOnDoubleTapListener(paramOnDoubleTapListener);
  }
  
  public void a(View.OnClickListener paramOnClickListener) {
    this.y = paramOnClickListener;
  }
  
  public void a(View.OnLongClickListener paramOnLongClickListener) {
    this.z = paramOnLongClickListener;
  }
  
  public void a(ImageView.ScaleType paramScaleType) {
    if (Util.a(paramScaleType) && paramScaleType != this.I) {
      this.I = paramScaleType;
      g();
    } 
  }
  
  public void a(OnMatrixChangedListener paramOnMatrixChangedListener) {
    this.u = paramOnMatrixChangedListener;
  }
  
  public void a(OnOutsidePhotoTapListener paramOnOutsidePhotoTapListener) {
    this.w = paramOnOutsidePhotoTapListener;
  }
  
  public void a(OnPhotoTapListener paramOnPhotoTapListener) {
    this.v = paramOnPhotoTapListener;
  }
  
  public void a(OnScaleChangedListener paramOnScaleChangedListener) {
    this.A = paramOnScaleChangedListener;
  }
  
  public void a(OnSingleFlingListener paramOnSingleFlingListener) {
    this.B = paramOnSingleFlingListener;
  }
  
  public void a(OnViewDragListener paramOnViewDragListener) {
    this.C = paramOnViewDragListener;
  }
  
  public void a(OnViewTapListener paramOnViewTapListener) {
    this.x = paramOnViewTapListener;
  }
  
  public void a(boolean paramBoolean) {
    this.k = paramBoolean;
  }
  
  public float b() {
    return this.h;
  }
  
  public void b(float paramFloat) {
    this.r.postRotate(paramFloat % 360.0F);
    m();
  }
  
  public void b(boolean paramBoolean) {
    this.H = paramBoolean;
    g();
  }
  
  public float c() {
    return this.i;
  }
  
  public void c(float paramFloat) {
    Util.a(paramFloat, this.i, this.j);
    this.h = paramFloat;
  }
  
  public float d() {
    return this.j;
  }
  
  public void d(float paramFloat) {
    Util.a(this.h, paramFloat, this.j);
    this.i = paramFloat;
  }
  
  public float e() {
    return (float)Math.sqrt(((float)Math.pow(a(this.r, 0), 2.0D) + (float)Math.pow(a(this.r, 3), 2.0D)));
  }
  
  public void e(float paramFloat) {
    Util.a(this.h, this.i, paramFloat);
    this.j = paramFloat;
  }
  
  public ImageView.ScaleType f() {
    return this.I;
  }
  
  public void f(float paramFloat) {
    a(paramFloat, false);
  }
  
  public void g() {
    if (this.H) {
      a(this.m.getDrawable());
      return;
    } 
    l();
  }
  
  public Matrix h() {
    return this.q;
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
    if (paramInt1 != paramInt5 || paramInt2 != paramInt6 || paramInt3 != paramInt7 || paramInt4 != paramInt8)
      a(this.m.getDrawable()); 
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield H : Z
    //   4: istore #8
    //   6: iconst_0
    //   7: istore #7
    //   9: iconst_0
    //   10: istore #6
    //   12: iload #7
    //   14: istore #5
    //   16: iload #8
    //   18: ifeq -> 342
    //   21: iload #7
    //   23: istore #5
    //   25: aload_1
    //   26: checkcast android/widget/ImageView
    //   29: invokestatic a : (Landroid/widget/ImageView;)Z
    //   32: ifeq -> 342
    //   35: aload_2
    //   36: invokevirtual getAction : ()I
    //   39: istore_3
    //   40: iload_3
    //   41: ifeq -> 174
    //   44: iload_3
    //   45: iconst_1
    //   46: if_icmpeq -> 57
    //   49: iload_3
    //   50: iconst_3
    //   51: if_icmpeq -> 57
    //   54: goto -> 194
    //   57: aload_0
    //   58: invokevirtual e : ()F
    //   61: aload_0
    //   62: getfield h : F
    //   65: fcmpg
    //   66: ifge -> 114
    //   69: aload_0
    //   70: invokevirtual a : ()Landroid/graphics/RectF;
    //   73: astore #9
    //   75: aload #9
    //   77: ifnull -> 194
    //   80: aload_1
    //   81: new com/github/chrisbanes/photoview/PhotoViewAttacher$AnimatedZoomRunnable
    //   84: dup
    //   85: aload_0
    //   86: aload_0
    //   87: invokevirtual e : ()F
    //   90: aload_0
    //   91: getfield h : F
    //   94: aload #9
    //   96: invokevirtual centerX : ()F
    //   99: aload #9
    //   101: invokevirtual centerY : ()F
    //   104: invokespecial <init> : (Lcom/github/chrisbanes/photoview/PhotoViewAttacher;FFFF)V
    //   107: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   110: pop
    //   111: goto -> 168
    //   114: aload_0
    //   115: invokevirtual e : ()F
    //   118: aload_0
    //   119: getfield j : F
    //   122: fcmpl
    //   123: ifle -> 194
    //   126: aload_0
    //   127: invokevirtual a : ()Landroid/graphics/RectF;
    //   130: astore #9
    //   132: aload #9
    //   134: ifnull -> 194
    //   137: aload_1
    //   138: new com/github/chrisbanes/photoview/PhotoViewAttacher$AnimatedZoomRunnable
    //   141: dup
    //   142: aload_0
    //   143: aload_0
    //   144: invokevirtual e : ()F
    //   147: aload_0
    //   148: getfield j : F
    //   151: aload #9
    //   153: invokevirtual centerX : ()F
    //   156: aload #9
    //   158: invokevirtual centerY : ()F
    //   161: invokespecial <init> : (Lcom/github/chrisbanes/photoview/PhotoViewAttacher;FFFF)V
    //   164: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   167: pop
    //   168: iconst_1
    //   169: istore #5
    //   171: goto -> 197
    //   174: aload_1
    //   175: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   178: astore_1
    //   179: aload_1
    //   180: ifnull -> 190
    //   183: aload_1
    //   184: iconst_1
    //   185: invokeinterface requestDisallowInterceptTouchEvent : (Z)V
    //   190: aload_0
    //   191: invokespecial o : ()V
    //   194: iconst_0
    //   195: istore #5
    //   197: aload_0
    //   198: getfield o : Lcom/github/chrisbanes/photoview/CustomGestureDetector;
    //   201: astore_1
    //   202: aload_1
    //   203: ifnull -> 310
    //   206: aload_1
    //   207: invokevirtual a : ()Z
    //   210: istore #5
    //   212: aload_0
    //   213: getfield o : Lcom/github/chrisbanes/photoview/CustomGestureDetector;
    //   216: invokevirtual b : ()Z
    //   219: istore #8
    //   221: aload_0
    //   222: getfield o : Lcom/github/chrisbanes/photoview/CustomGestureDetector;
    //   225: aload_2
    //   226: invokevirtual a : (Landroid/view/MotionEvent;)Z
    //   229: istore #7
    //   231: iload #5
    //   233: ifne -> 251
    //   236: aload_0
    //   237: getfield o : Lcom/github/chrisbanes/photoview/CustomGestureDetector;
    //   240: invokevirtual a : ()Z
    //   243: ifne -> 251
    //   246: iconst_1
    //   247: istore_3
    //   248: goto -> 253
    //   251: iconst_0
    //   252: istore_3
    //   253: iload #8
    //   255: ifne -> 274
    //   258: aload_0
    //   259: getfield o : Lcom/github/chrisbanes/photoview/CustomGestureDetector;
    //   262: invokevirtual b : ()Z
    //   265: ifne -> 274
    //   268: iconst_1
    //   269: istore #4
    //   271: goto -> 277
    //   274: iconst_0
    //   275: istore #4
    //   277: iload #6
    //   279: istore #5
    //   281: iload_3
    //   282: ifeq -> 297
    //   285: iload #6
    //   287: istore #5
    //   289: iload #4
    //   291: ifeq -> 297
    //   294: iconst_1
    //   295: istore #5
    //   297: aload_0
    //   298: iload #5
    //   300: putfield l : Z
    //   303: iload #7
    //   305: istore #6
    //   307: goto -> 314
    //   310: iload #5
    //   312: istore #6
    //   314: aload_0
    //   315: getfield n : Landroid/view/GestureDetector;
    //   318: astore_1
    //   319: iload #6
    //   321: istore #5
    //   323: aload_1
    //   324: ifnull -> 342
    //   327: iload #6
    //   329: istore #5
    //   331: aload_1
    //   332: aload_2
    //   333: invokevirtual onTouchEvent : (Landroid/view/MotionEvent;)Z
    //   336: ifeq -> 342
    //   339: iconst_1
    //   340: istore #5
    //   342: iload #5
    //   344: ireturn
  }
  
  class AnimatedZoomRunnable implements Runnable {
    private final float b;
    
    private final float c;
    
    private final long d;
    
    private final float e;
    
    private final float f;
    
    public AnimatedZoomRunnable(PhotoViewAttacher this$0, float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
      this.b = param1Float3;
      this.c = param1Float4;
      this.d = System.currentTimeMillis();
      this.e = param1Float1;
      this.f = param1Float2;
    }
    
    private float a() {
      float f = Math.min(1.0F, (float)(System.currentTimeMillis() - this.d) * 1.0F / PhotoViewAttacher.t(this.a));
      return PhotoViewAttacher.u(this.a).getInterpolation(f);
    }
    
    public void run() {
      float f1 = a();
      float f2 = this.e;
      f2 = (f2 + (this.f - f2) * f1) / this.a.e();
      PhotoViewAttacher.s(this.a).a(f2, this.b, this.c);
      if (f1 < 1.0F)
        Compat.a((View)PhotoViewAttacher.e(this.a), this); 
    }
  }
  
  class FlingRunnable implements Runnable {
    private final OverScroller b;
    
    private int c;
    
    private int d;
    
    public FlingRunnable(PhotoViewAttacher this$0, Context param1Context) {
      this.b = new OverScroller(param1Context);
    }
    
    public void a() {
      this.b.forceFinished(true);
    }
    
    public void a(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      int i;
      int j;
      RectF rectF = this.a.a();
      if (rectF == null)
        return; 
      int k = Math.round(-rectF.left);
      float f = param1Int1;
      if (f < rectF.width()) {
        j = Math.round(rectF.width() - f);
        i = 0;
      } else {
        param1Int1 = k;
        j = param1Int1;
        i = param1Int1;
      } 
      int m = Math.round(-rectF.top);
      f = param1Int2;
      if (f < rectF.height()) {
        param1Int2 = Math.round(rectF.height() - f);
        param1Int1 = 0;
      } else {
        param1Int1 = m;
        param1Int2 = param1Int1;
      } 
      this.c = k;
      this.d = m;
      if (k != j || m != param1Int2)
        this.b.fling(k, m, param1Int3, param1Int4, i, j, param1Int1, param1Int2, 0, 0); 
    }
    
    public void run() {
      if (this.b.isFinished())
        return; 
      if (this.b.computeScrollOffset()) {
        int i = this.b.getCurrX();
        int j = this.b.getCurrY();
        PhotoViewAttacher.c(this.a).postTranslate((this.c - i), (this.d - j));
        PhotoViewAttacher.d(this.a);
        this.c = i;
        this.d = j;
        Compat.a((View)PhotoViewAttacher.e(this.a), this);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\chrisbanes\photoview\PhotoViewAttacher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */