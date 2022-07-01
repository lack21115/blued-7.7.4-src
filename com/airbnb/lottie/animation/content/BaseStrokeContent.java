package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseStrokeContent implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener {
  protected final BaseLayer a;
  
  final Paint b = (Paint)new LPaint(1);
  
  private final PathMeasure c = new PathMeasure();
  
  private final Path d = new Path();
  
  private final Path e = new Path();
  
  private final RectF f = new RectF();
  
  private final LottieDrawable g;
  
  private final List<PathGroup> h = new ArrayList<PathGroup>();
  
  private final float[] i;
  
  private final BaseKeyframeAnimation<?, Float> j;
  
  private final BaseKeyframeAnimation<?, Integer> k;
  
  private final List<BaseKeyframeAnimation<?, Float>> l;
  
  private final BaseKeyframeAnimation<?, Float> m;
  
  private BaseKeyframeAnimation<ColorFilter, ColorFilter> n;
  
  BaseStrokeContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, Paint.Cap paramCap, Paint.Join paramJoin, float paramFloat, AnimatableIntegerValue paramAnimatableIntegerValue, AnimatableFloatValue paramAnimatableFloatValue1, List<AnimatableFloatValue> paramList, AnimatableFloatValue paramAnimatableFloatValue2) {
    this.g = paramLottieDrawable;
    this.a = paramBaseLayer;
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeCap(paramCap);
    this.b.setStrokeJoin(paramJoin);
    this.b.setStrokeMiter(paramFloat);
    this.k = paramAnimatableIntegerValue.a();
    this.j = paramAnimatableFloatValue1.a();
    if (paramAnimatableFloatValue2 == null) {
      this.m = null;
    } else {
      this.m = paramAnimatableFloatValue2.a();
    } 
    this.l = new ArrayList<BaseKeyframeAnimation<?, Float>>(paramList.size());
    this.i = new float[paramList.size()];
    boolean bool = false;
    int i;
    for (i = 0; i < paramList.size(); i++)
      this.l.add(((AnimatableFloatValue)paramList.get(i)).a()); 
    paramBaseLayer.a(this.k);
    paramBaseLayer.a(this.j);
    for (i = 0; i < this.l.size(); i++)
      paramBaseLayer.a(this.l.get(i)); 
    BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.m;
    if (baseKeyframeAnimation != null)
      paramBaseLayer.a(baseKeyframeAnimation); 
    this.k.a(this);
    this.j.a(this);
    for (i = bool; i < paramList.size(); i++)
      ((BaseKeyframeAnimation)this.l.get(i)).a(this); 
    baseKeyframeAnimation = this.m;
    if (baseKeyframeAnimation != null)
      baseKeyframeAnimation.a(this); 
  }
  
  private void a(Canvas paramCanvas, PathGroup paramPathGroup, Matrix paramMatrix) {
    L.a("StrokeContent#applyTrimPath");
    if (PathGroup.b(paramPathGroup) == null) {
      L.b("StrokeContent#applyTrimPath");
      return;
    } 
    this.d.reset();
    int i;
    for (i = PathGroup.a(paramPathGroup).size() - 1; i >= 0; i--)
      this.d.addPath(((PathContent)PathGroup.a(paramPathGroup).get(i)).e(), paramMatrix); 
    this.c.setPath(this.d, false);
    float f1;
    for (f1 = this.c.getLength(); this.c.nextContour(); f1 += this.c.getLength());
    float f2 = ((Float)PathGroup.b(paramPathGroup).f().g()).floatValue() * f1 / 360.0F;
    float f3 = ((Float)PathGroup.b(paramPathGroup).d().g()).floatValue() * f1 / 100.0F + f2;
    float f4 = ((Float)PathGroup.b(paramPathGroup).e().g()).floatValue() * f1 / 100.0F + f2;
    i = PathGroup.a(paramPathGroup).size() - 1;
    f2 = 0.0F;
    while (i >= 0) {
      this.e.set(((PathContent)PathGroup.a(paramPathGroup).get(i)).e());
      this.e.transform(paramMatrix);
      this.c.setPath(this.e, false);
      float f6 = this.c.getLength();
      float f5 = 1.0F;
      if (f4 > f1) {
        float f = f4 - f1;
        if (f < f2 + f6 && f2 < f) {
          float f8;
          if (f3 > f1) {
            f8 = (f3 - f1) / f6;
          } else {
            f8 = 0.0F;
          } 
          f5 = Math.min(f / f6, 1.0F);
          Utils.a(this.e, f8, f5, 0.0F);
          paramCanvas.drawPath(this.e, this.b);
          continue;
        } 
      } 
      float f7 = f2 + f6;
      if (f7 >= f3 && f2 <= f4)
        if (f7 <= f4 && f3 < f2) {
          paramCanvas.drawPath(this.e, this.b);
        } else {
          float f;
          if (f3 < f2) {
            f = 0.0F;
          } else {
            f = (f3 - f2) / f6;
          } 
          if (f4 <= f7)
            f5 = (f4 - f2) / f6; 
          Utils.a(this.e, f, f5, 0.0F);
          paramCanvas.drawPath(this.e, this.b);
        }  
      continue;
      f2 += SYNTHETIC_LOCAL_VARIABLE_10;
      i--;
    } 
    L.b("StrokeContent#applyTrimPath");
  }
  
  private void a(Matrix paramMatrix) {
    L.a("StrokeContent#applyDashPattern");
    if (this.l.isEmpty()) {
      L.b("StrokeContent#applyDashPattern");
      return;
    } 
    float f = Utils.a(paramMatrix);
    for (int i = 0; i < this.l.size(); i++) {
      this.i[i] = ((Float)((BaseKeyframeAnimation)this.l.get(i)).g()).floatValue();
      if (i % 2 == 0) {
        float[] arrayOfFloat1 = this.i;
        if (arrayOfFloat1[i] < 1.0F)
          arrayOfFloat1[i] = 1.0F; 
      } else {
        float[] arrayOfFloat1 = this.i;
        if (arrayOfFloat1[i] < 0.1F)
          arrayOfFloat1[i] = 0.1F; 
      } 
      float[] arrayOfFloat = this.i;
      arrayOfFloat[i] = arrayOfFloat[i] * f;
    } 
    BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.m;
    if (baseKeyframeAnimation == null) {
      f = 0.0F;
    } else {
      f = ((Float)baseKeyframeAnimation.g()).floatValue();
    } 
    this.b.setPathEffect((PathEffect)new DashPathEffect(this.i, f));
    L.b("StrokeContent#applyDashPattern");
  }
  
  public void a() {
    this.g.invalidateSelf();
  }
  
  public void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt) {
    L.a("StrokeContent#draw");
    if (Utils.b(paramMatrix)) {
      L.b("StrokeContent#draw");
      return;
    } 
    paramInt = (int)(paramInt / 255.0F * ((IntegerKeyframeAnimation)this.k).i() / 100.0F * 255.0F);
    Paint paint = this.b;
    int i = 0;
    paint.setAlpha(MiscUtils.a(paramInt, 0, 255));
    this.b.setStrokeWidth(((FloatKeyframeAnimation)this.j).i() * Utils.a(paramMatrix));
    if (this.b.getStrokeWidth() <= 0.0F) {
      L.b("StrokeContent#draw");
      return;
    } 
    a(paramMatrix);
    BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.n;
    paramInt = i;
    if (baseKeyframeAnimation != null) {
      this.b.setColorFilter((ColorFilter)baseKeyframeAnimation.g());
      paramInt = i;
    } 
    while (paramInt < this.h.size()) {
      PathGroup pathGroup = this.h.get(paramInt);
      if (PathGroup.b(pathGroup) != null) {
        a(paramCanvas, pathGroup, paramMatrix);
      } else {
        L.a("StrokeContent#buildPath");
        this.d.reset();
        for (i = PathGroup.a(pathGroup).size() - 1; i >= 0; i--)
          this.d.addPath(((PathContent)PathGroup.a(pathGroup).get(i)).e(), paramMatrix); 
        L.b("StrokeContent#buildPath");
        L.a("StrokeContent#drawPath");
        paramCanvas.drawPath(this.d, this.b);
        L.b("StrokeContent#drawPath");
      } 
      paramInt++;
    } 
    L.b("StrokeContent#draw");
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean) {
    L.a("StrokeContent#getBounds");
    this.d.reset();
    int i;
    for (i = 0; i < this.h.size(); i++) {
      PathGroup pathGroup = this.h.get(i);
      int j;
      for (j = 0; j < PathGroup.a(pathGroup).size(); j++)
        this.d.addPath(((PathContent)PathGroup.a(pathGroup).get(j)).e(), paramMatrix); 
    } 
    this.d.computeBounds(this.f, false);
    float f2 = ((FloatKeyframeAnimation)this.j).i();
    RectF rectF = this.f;
    float f1 = rectF.left;
    f2 /= 2.0F;
    rectF.set(f1 - f2, this.f.top - f2, this.f.right + f2, this.f.bottom + f2);
    paramRectF.set(this.f);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
    L.b("StrokeContent#getBounds");
  }
  
  public void a(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2) {
    MiscUtils.a(paramKeyPath1, paramInt, paramList, paramKeyPath2, this);
  }
  
  public <T> void a(T paramT, LottieValueCallback<T> paramLottieValueCallback) {
    if (paramT == LottieProperty.d) {
      this.k.a(paramLottieValueCallback);
      return;
    } 
    if (paramT == LottieProperty.o) {
      this.j.a(paramLottieValueCallback);
      return;
    } 
    if (paramT == LottieProperty.B) {
      if (paramLottieValueCallback == null) {
        this.n = null;
        return;
      } 
      this.n = (BaseKeyframeAnimation<ColorFilter, ColorFilter>)new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
      this.n.a(this);
      this.a.a(this.n);
    } 
  }
  
  public void a(List<Content> paramList1, List<Content> paramList2) {
    Content content1;
    Content content2;
    int i = paramList1.size() - 1;
    Content content3;
    for (content3 = null; i >= 0; content3 = content2) {
      Content content = paramList1.get(i);
      content2 = content3;
      if (content instanceof TrimPathContent) {
        content = content;
        content2 = content3;
        if (content.c() == ShapeTrimPath.Type.b)
          content2 = content; 
      } 
      i--;
    } 
    if (content3 != null)
      content3.a(this); 
    i = paramList2.size() - 1;
    paramList1 = null;
    while (i >= 0) {
      Content content = paramList2.get(i);
      if (content instanceof TrimPathContent) {
        TrimPathContent trimPathContent = (TrimPathContent)content;
        if (trimPathContent.c() == ShapeTrimPath.Type.b) {
          if (content1 != null)
            this.h.add(content1); 
          PathGroup pathGroup = new PathGroup(trimPathContent);
          trimPathContent.a(this);
          continue;
        } 
      } 
      content2 = content1;
      if (content instanceof PathContent) {
        PathGroup pathGroup;
        content2 = content1;
        if (content1 == null)
          pathGroup = new PathGroup((TrimPathContent)content3); 
        PathGroup.a(pathGroup).add((PathContent)content);
      } 
      continue;
      i--;
      content1 = content2;
    } 
    if (content1 != null)
      this.h.add(content1); 
  }
  
  static final class PathGroup {
    private final List<PathContent> a = new ArrayList<PathContent>();
    
    private final TrimPathContent b;
    
    private PathGroup(TrimPathContent param1TrimPathContent) {
      this.b = param1TrimPathContent;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\content\BaseStrokeContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */