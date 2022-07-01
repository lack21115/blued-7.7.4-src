package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class BaseLayer implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
  final Matrix a = new Matrix();
  
  final LottieDrawable b;
  
  final Layer c;
  
  final TransformKeyframeAnimation d;
  
  private final Path e = new Path();
  
  private final Matrix f = new Matrix();
  
  private final Paint g = (Paint)new LPaint(1);
  
  private final Paint h = (Paint)new LPaint(1, PorterDuff.Mode.DST_IN);
  
  private final Paint i = (Paint)new LPaint(1, PorterDuff.Mode.DST_OUT);
  
  private final Paint j = (Paint)new LPaint(1);
  
  private final Paint k = (Paint)new LPaint(PorterDuff.Mode.CLEAR);
  
  private final RectF l = new RectF();
  
  private final RectF m = new RectF();
  
  private final RectF n = new RectF();
  
  private final RectF o = new RectF();
  
  private final String p;
  
  private MaskKeyframeAnimation q;
  
  private BaseLayer r;
  
  private BaseLayer s;
  
  private List<BaseLayer> t;
  
  private final List<BaseKeyframeAnimation<?, ?>> u = new ArrayList<BaseKeyframeAnimation<?, ?>>();
  
  private boolean v = true;
  
  BaseLayer(LottieDrawable paramLottieDrawable, Layer paramLayer) {
    this.b = paramLottieDrawable;
    this.c = paramLayer;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLayer.f());
    stringBuilder.append("#draw");
    this.p = stringBuilder.toString();
    if (paramLayer.l() == Layer.MatteType.c) {
      this.j.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    } else {
      this.j.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    } 
    this.d = paramLayer.o().j();
    this.d.a(this);
    if (paramLayer.j() != null && !paramLayer.j().isEmpty()) {
      this.q = new MaskKeyframeAnimation(paramLayer.j());
      null = this.q.b().iterator();
      while (null.hasNext())
        ((BaseKeyframeAnimation)null.next()).a(this); 
      for (BaseKeyframeAnimation<?, ?> baseKeyframeAnimation : (Iterable<BaseKeyframeAnimation<?, ?>>)this.q.c()) {
        a(baseKeyframeAnimation);
        baseKeyframeAnimation.a(this);
      } 
    } 
    f();
  }
  
  static BaseLayer a(Layer paramLayer, LottieDrawable paramLottieDrawable, LottieComposition paramLottieComposition) {
    StringBuilder stringBuilder;
    switch (null.a[paramLayer.k().ordinal()]) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown layer type ");
        stringBuilder.append(paramLayer.k());
        Logger.b(stringBuilder.toString());
        return null;
      case 6:
        return new TextLayer((LottieDrawable)stringBuilder, paramLayer);
      case 5:
        return new NullLayer((LottieDrawable)stringBuilder, paramLayer);
      case 4:
        return new ImageLayer((LottieDrawable)stringBuilder, paramLayer);
      case 3:
        return new SolidLayer((LottieDrawable)stringBuilder, paramLayer);
      case 2:
        return new CompositionLayer((LottieDrawable)stringBuilder, paramLayer, paramLottieComposition.b(paramLayer.g()), paramLottieComposition);
      case 1:
        break;
    } 
    return new ShapeLayer((LottieDrawable)stringBuilder, paramLayer);
  }
  
  private void a(Canvas paramCanvas) {
    L.a("Layer#clearLayer");
    paramCanvas.drawRect(this.l.left - 1.0F, this.l.top - 1.0F, this.l.right + 1.0F, this.l.bottom + 1.0F, this.k);
    L.b("Layer#clearLayer");
  }
  
  private void a(Canvas paramCanvas, Matrix paramMatrix) {
    L.a("Layer#saveLayer");
    RectF rectF = this.l;
    Paint paint = this.h;
    int i = 0;
    a(paramCanvas, rectF, paint, false);
    L.b("Layer#saveLayer");
    while (i < this.q.a().size()) {
      Mask mask = this.q.a().get(i);
      BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation = this.q.b().get(i);
      BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation1 = this.q.c().get(i);
      int j = null.b[mask.a().ordinal()];
      if (j != 1) {
        if (j != 2) {
          if (j == 3)
            if (mask.d()) {
              b(paramCanvas, paramMatrix, mask, baseKeyframeAnimation, baseKeyframeAnimation1);
            } else {
              a(paramCanvas, paramMatrix, mask, baseKeyframeAnimation, baseKeyframeAnimation1);
            }  
        } else if (mask.d()) {
          f(paramCanvas, paramMatrix, mask, baseKeyframeAnimation, baseKeyframeAnimation1);
        } else {
          e(paramCanvas, paramMatrix, mask, baseKeyframeAnimation, baseKeyframeAnimation1);
        } 
      } else {
        if (i == 0) {
          Paint paint1 = new Paint();
          paint1.setColor(-16777216);
          paramCanvas.drawRect(this.l, paint1);
        } 
        if (mask.d()) {
          d(paramCanvas, paramMatrix, mask, baseKeyframeAnimation, baseKeyframeAnimation1);
        } else {
          c(paramCanvas, paramMatrix, mask, baseKeyframeAnimation, baseKeyframeAnimation1);
        } 
      } 
      i++;
    } 
    L.a("Layer#restoreLayer");
    paramCanvas.restore();
    L.b("Layer#restoreLayer");
  }
  
  private void a(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, BaseKeyframeAnimation<ShapeData, Path> paramBaseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> paramBaseKeyframeAnimation1) {
    Path path = (Path)paramBaseKeyframeAnimation.g();
    this.e.set(path);
    this.e.transform(paramMatrix);
    this.g.setAlpha((int)(((Integer)paramBaseKeyframeAnimation1.g()).intValue() * 2.55F));
    paramCanvas.drawPath(this.e, this.g);
  }
  
  private void a(Canvas paramCanvas, RectF paramRectF, Paint paramPaint, boolean paramBoolean) {
    if (Build.VERSION.SDK_INT < 23) {
      byte b;
      if (paramBoolean) {
        b = 31;
      } else {
        b = 19;
      } 
      paramCanvas.saveLayer(paramRectF, paramPaint, b);
      return;
    } 
    paramCanvas.saveLayer(paramRectF, paramPaint);
  }
  
  private void a(RectF paramRectF, Matrix paramMatrix) {
    this.m.set(0.0F, 0.0F, 0.0F, 0.0F);
    if (!e())
      return; 
    int j = this.q.a().size();
    int i = 0;
    while (i < j) {
      Mask mask = this.q.a().get(i);
      Path path = (Path)((BaseKeyframeAnimation)this.q.b().get(i)).g();
      this.e.set(path);
      this.e.transform(paramMatrix);
      int k = null.b[mask.a().ordinal()];
      if (k != 1) {
        if ((k == 2 || k == 3) && mask.d())
          return; 
        this.e.computeBounds(this.o, false);
        if (i == 0) {
          this.m.set(this.o);
        } else {
          RectF rectF = this.m;
          rectF.set(Math.min(rectF.left, this.o.left), Math.min(this.m.top, this.o.top), Math.max(this.m.right, this.o.right), Math.max(this.m.bottom, this.o.bottom));
        } 
        i++;
        continue;
      } 
      return;
    } 
    if (!paramRectF.intersect(this.m))
      paramRectF.set(0.0F, 0.0F, 0.0F, 0.0F); 
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean != this.v) {
      this.v = paramBoolean;
      g();
    } 
  }
  
  private void b(float paramFloat) {
    this.b.r().c().a(this.c.f(), paramFloat);
  }
  
  private void b(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, BaseKeyframeAnimation<ShapeData, Path> paramBaseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> paramBaseKeyframeAnimation1) {
    a(paramCanvas, this.l, this.g, true);
    paramCanvas.drawRect(this.l, this.g);
    Path path = (Path)paramBaseKeyframeAnimation.g();
    this.e.set(path);
    this.e.transform(paramMatrix);
    this.g.setAlpha((int)(((Integer)paramBaseKeyframeAnimation1.g()).intValue() * 2.55F));
    paramCanvas.drawPath(this.e, this.i);
    paramCanvas.restore();
  }
  
  private void b(RectF paramRectF, Matrix paramMatrix) {
    if (!d())
      return; 
    if (this.c.l() == Layer.MatteType.c)
      return; 
    this.n.set(0.0F, 0.0F, 0.0F, 0.0F);
    this.r.a(this.n, paramMatrix, true);
    if (!paramRectF.intersect(this.n))
      paramRectF.set(0.0F, 0.0F, 0.0F, 0.0F); 
  }
  
  private void c(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, BaseKeyframeAnimation<ShapeData, Path> paramBaseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> paramBaseKeyframeAnimation1) {
    Path path = (Path)paramBaseKeyframeAnimation.g();
    this.e.set(path);
    this.e.transform(paramMatrix);
    paramCanvas.drawPath(this.e, this.i);
  }
  
  private void d(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, BaseKeyframeAnimation<ShapeData, Path> paramBaseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> paramBaseKeyframeAnimation1) {
    a(paramCanvas, this.l, this.i, true);
    paramCanvas.drawRect(this.l, this.g);
    this.i.setAlpha((int)(((Integer)paramBaseKeyframeAnimation1.g()).intValue() * 2.55F));
    Path path = (Path)paramBaseKeyframeAnimation.g();
    this.e.set(path);
    this.e.transform(paramMatrix);
    paramCanvas.drawPath(this.e, this.i);
    paramCanvas.restore();
  }
  
  private void e(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, BaseKeyframeAnimation<ShapeData, Path> paramBaseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> paramBaseKeyframeAnimation1) {
    a(paramCanvas, this.l, this.h, true);
    Path path = (Path)paramBaseKeyframeAnimation.g();
    this.e.set(path);
    this.e.transform(paramMatrix);
    this.g.setAlpha((int)(((Integer)paramBaseKeyframeAnimation1.g()).intValue() * 2.55F));
    paramCanvas.drawPath(this.e, this.g);
    paramCanvas.restore();
  }
  
  private void f() {
    boolean bool1 = this.c.d().isEmpty();
    boolean bool = true;
    if (!bool1) {
      FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(this.c.d());
      floatKeyframeAnimation.a();
      floatKeyframeAnimation.a(new BaseKeyframeAnimation.AnimationListener(this, floatKeyframeAnimation) {
            public void a() {
              boolean bool;
              BaseLayer baseLayer = this.b;
              if (this.a.i() == 1.0F) {
                bool = true;
              } else {
                bool = false;
              } 
              BaseLayer.a(baseLayer, bool);
            }
          });
      if (((Float)floatKeyframeAnimation.g()).floatValue() != 1.0F)
        bool = false; 
      a(bool);
      a((BaseKeyframeAnimation<?, ?>)floatKeyframeAnimation);
      return;
    } 
    a(true);
  }
  
  private void f(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, BaseKeyframeAnimation<ShapeData, Path> paramBaseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> paramBaseKeyframeAnimation1) {
    a(paramCanvas, this.l, this.h, true);
    paramCanvas.drawRect(this.l, this.g);
    this.i.setAlpha((int)(((Integer)paramBaseKeyframeAnimation1.g()).intValue() * 2.55F));
    Path path = (Path)paramBaseKeyframeAnimation.g();
    this.e.set(path);
    this.e.transform(paramMatrix);
    paramCanvas.drawPath(this.e, this.i);
    paramCanvas.restore();
  }
  
  private void g() {
    this.b.invalidateSelf();
  }
  
  private void h() {
    if (this.t != null)
      return; 
    if (this.s == null) {
      this.t = Collections.emptyList();
      return;
    } 
    this.t = new ArrayList<BaseLayer>();
    for (BaseLayer baseLayer = this.s; baseLayer != null; baseLayer = baseLayer.s)
      this.t.add(baseLayer); 
  }
  
  public void a() {
    g();
  }
  
  void a(float paramFloat) {
    this.d.a(paramFloat);
    MaskKeyframeAnimation maskKeyframeAnimation = this.q;
    byte b = 0;
    if (maskKeyframeAnimation != null)
      for (int j = 0; j < this.q.b().size(); j++)
        ((BaseKeyframeAnimation)this.q.b().get(j)).a(paramFloat);  
    float f = paramFloat;
    if (this.c.b() != 0.0F)
      f = paramFloat / this.c.b(); 
    BaseLayer baseLayer = this.r;
    int i = b;
    if (baseLayer != null) {
      paramFloat = baseLayer.c.b();
      this.r.a(paramFloat * f);
      i = b;
    } 
    while (i < this.u.size()) {
      ((BaseKeyframeAnimation)this.u.get(i)).a(f);
      i++;
    } 
  }
  
  public void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt) {
    L.a(this.p);
    if (!this.v || this.c.v()) {
      L.b(this.p);
      return;
    } 
    h();
    L.a("Layer#parentMatrix");
    this.f.reset();
    this.f.set(paramMatrix);
    int i;
    for (i = this.t.size() - 1; i >= 0; i--)
      this.f.preConcat(((BaseLayer)this.t.get(i)).d.d()); 
    L.b("Layer#parentMatrix");
    if (this.d.a() == null) {
      i = 100;
    } else {
      i = ((Integer)this.d.a().g()).intValue();
    } 
    paramInt = (int)(paramInt / 255.0F * i / 100.0F * 255.0F);
    if (!d() && !e()) {
      this.f.preConcat(this.d.d());
      L.a("Layer#drawLayer");
      b(paramCanvas, this.f, paramInt);
      L.b("Layer#drawLayer");
      b(L.b(this.p));
      return;
    } 
    L.a("Layer#computeBounds");
    a(this.l, this.f, false);
    b(this.l, paramMatrix);
    this.f.preConcat(this.d.d());
    a(this.l, this.f);
    L.b("Layer#computeBounds");
    if (!this.l.isEmpty()) {
      L.a("Layer#saveLayer");
      a(paramCanvas, this.l, this.g, true);
      L.b("Layer#saveLayer");
      a(paramCanvas);
      L.a("Layer#drawLayer");
      b(paramCanvas, this.f, paramInt);
      L.b("Layer#drawLayer");
      if (e())
        a(paramCanvas, this.f); 
      if (d()) {
        L.a("Layer#drawMatte");
        L.a("Layer#saveLayer");
        a(paramCanvas, this.l, this.j, false);
        L.b("Layer#saveLayer");
        a(paramCanvas);
        this.r.a(paramCanvas, paramMatrix, paramInt);
        L.a("Layer#restoreLayer");
        paramCanvas.restore();
        L.b("Layer#restoreLayer");
        L.b("Layer#drawMatte");
      } 
      L.a("Layer#restoreLayer");
      paramCanvas.restore();
      L.b("Layer#restoreLayer");
    } 
    b(L.b(this.p));
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean) {
    this.l.set(0.0F, 0.0F, 0.0F, 0.0F);
    h();
    this.a.set(paramMatrix);
    if (paramBoolean) {
      List<BaseLayer> list = this.t;
      if (list != null) {
        int i;
        for (i = list.size() - 1; i >= 0; i--)
          this.a.preConcat(((BaseLayer)this.t.get(i)).d.d()); 
      } else {
        BaseLayer baseLayer = this.s;
        if (baseLayer != null)
          this.a.preConcat(baseLayer.d.d()); 
      } 
    } 
    this.a.preConcat(this.d.d());
  }
  
  public void a(BaseKeyframeAnimation<?, ?> paramBaseKeyframeAnimation) {
    if (paramBaseKeyframeAnimation == null)
      return; 
    this.u.add(paramBaseKeyframeAnimation);
  }
  
  public void a(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2) {
    if (!paramKeyPath1.a(b(), paramInt))
      return; 
    KeyPath keyPath = paramKeyPath2;
    if (!"__container".equals(b())) {
      paramKeyPath2 = paramKeyPath2.a(b());
      keyPath = paramKeyPath2;
      if (paramKeyPath1.c(b(), paramInt)) {
        paramList.add(paramKeyPath2.a(this));
        keyPath = paramKeyPath2;
      } 
    } 
    if (paramKeyPath1.d(b(), paramInt))
      b(paramKeyPath1, paramInt + paramKeyPath1.b(b(), paramInt), paramList, keyPath); 
  }
  
  void a(BaseLayer paramBaseLayer) {
    this.r = paramBaseLayer;
  }
  
  public <T> void a(T paramT, LottieValueCallback<T> paramLottieValueCallback) {
    this.d.a(paramT, paramLottieValueCallback);
  }
  
  public void a(List<Content> paramList1, List<Content> paramList2) {}
  
  public String b() {
    return this.c.f();
  }
  
  abstract void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt);
  
  public void b(BaseKeyframeAnimation<?, ?> paramBaseKeyframeAnimation) {
    this.u.remove(paramBaseKeyframeAnimation);
  }
  
  void b(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2) {}
  
  void b(BaseLayer paramBaseLayer) {
    this.s = paramBaseLayer;
  }
  
  Layer c() {
    return this.c;
  }
  
  boolean d() {
    return (this.r != null);
  }
  
  boolean e() {
    MaskKeyframeAnimation maskKeyframeAnimation = this.q;
    return (maskKeyframeAnimation != null && !maskKeyframeAnimation.b().isEmpty());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\layer\BaseLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */