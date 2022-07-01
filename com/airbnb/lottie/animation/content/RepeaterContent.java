package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class RepeaterContent implements DrawingContent, GreedyContent, KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener {
  private final Matrix a = new Matrix();
  
  private final Path b = new Path();
  
  private final LottieDrawable c;
  
  private final BaseLayer d;
  
  private final String e;
  
  private final boolean f;
  
  private final BaseKeyframeAnimation<Float, Float> g;
  
  private final BaseKeyframeAnimation<Float, Float> h;
  
  private final TransformKeyframeAnimation i;
  
  private ContentGroup j;
  
  public RepeaterContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, Repeater paramRepeater) {
    this.c = paramLottieDrawable;
    this.d = paramBaseLayer;
    this.e = paramRepeater.a();
    this.f = paramRepeater.e();
    this.g = paramRepeater.b().a();
    paramBaseLayer.a(this.g);
    this.g.a(this);
    this.h = paramRepeater.c().a();
    paramBaseLayer.a(this.h);
    this.h.a(this);
    this.i = paramRepeater.d().j();
    this.i.a(paramBaseLayer);
    this.i.a(this);
  }
  
  public void a() {
    this.c.invalidateSelf();
  }
  
  public void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt) {
    float f1 = ((Float)this.g.g()).floatValue();
    float f2 = ((Float)this.h.g()).floatValue();
    float f3 = ((Float)this.i.b().g()).floatValue() / 100.0F;
    float f4 = ((Float)this.i.c().g()).floatValue() / 100.0F;
    int i;
    for (i = (int)f1 - 1; i >= 0; i--) {
      this.a.set(paramMatrix);
      Matrix matrix = this.a;
      TransformKeyframeAnimation transformKeyframeAnimation = this.i;
      float f6 = i;
      matrix.preConcat(transformKeyframeAnimation.b(f6 + f2));
      float f5 = paramInt;
      f6 = MiscUtils.a(f3, f4, f6 / f1);
      this.j.a(paramCanvas, this.a, (int)(f5 * f6));
    } 
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean) {
    this.j.a(paramRectF, paramMatrix, paramBoolean);
  }
  
  public void a(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2) {
    MiscUtils.a(paramKeyPath1, paramInt, paramList, paramKeyPath2, this);
  }
  
  public <T> void a(T paramT, LottieValueCallback<T> paramLottieValueCallback) {
    if (this.i.a(paramT, paramLottieValueCallback))
      return; 
    if (paramT == LottieProperty.q) {
      this.g.a(paramLottieValueCallback);
      return;
    } 
    if (paramT == LottieProperty.r)
      this.h.a(paramLottieValueCallback); 
  }
  
  public void a(List<Content> paramList1, List<Content> paramList2) {
    this.j.a(paramList1, paramList2);
  }
  
  public void a(ListIterator<Content> paramListIterator) {
    if (this.j != null)
      return; 
    while (paramListIterator.hasPrevious() && paramListIterator.previous() != this);
    ArrayList<?> arrayList = new ArrayList();
    while (paramListIterator.hasPrevious()) {
      arrayList.add(paramListIterator.previous());
      paramListIterator.remove();
    } 
    Collections.reverse(arrayList);
    this.j = new ContentGroup(this.c, this.d, "Repeater", this.f, (List)arrayList, null);
  }
  
  public String b() {
    return this.e;
  }
  
  public Path e() {
    Path path = this.j.e();
    this.b.reset();
    float f1 = ((Float)this.g.g()).floatValue();
    float f2 = ((Float)this.h.g()).floatValue();
    for (int i = (int)f1 - 1; i >= 0; i--) {
      this.a.set(this.i.b(i + f2));
      this.b.addPath(path, this.a);
    } 
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\content\RepeaterContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */