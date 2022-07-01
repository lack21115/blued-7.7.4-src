package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class FillContent implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener {
  private final Path a = new Path();
  
  private final Paint b = (Paint)new LPaint(1);
  
  private final BaseLayer c;
  
  private final String d;
  
  private final boolean e;
  
  private final List<PathContent> f = new ArrayList<PathContent>();
  
  private final BaseKeyframeAnimation<Integer, Integer> g;
  
  private final BaseKeyframeAnimation<Integer, Integer> h;
  
  private BaseKeyframeAnimation<ColorFilter, ColorFilter> i;
  
  private final LottieDrawable j;
  
  public FillContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer, ShapeFill paramShapeFill) {
    this.c = paramBaseLayer;
    this.d = paramShapeFill.a();
    this.e = paramShapeFill.e();
    this.j = paramLottieDrawable;
    if (paramShapeFill.b() == null || paramShapeFill.c() == null) {
      this.g = null;
      this.h = null;
      return;
    } 
    this.a.setFillType(paramShapeFill.d());
    this.g = paramShapeFill.b().a();
    this.g.a(this);
    paramBaseLayer.a(this.g);
    this.h = paramShapeFill.c().a();
    this.h.a(this);
    paramBaseLayer.a(this.h);
  }
  
  public void a() {
    this.j.invalidateSelf();
  }
  
  public void a(Canvas paramCanvas, Matrix paramMatrix, int paramInt) {
    if (this.e)
      return; 
    L.a("FillContent#draw");
    this.b.setColor(((ColorKeyframeAnimation)this.g).i());
    int i = (int)(paramInt / 255.0F * ((Integer)this.h.g()).intValue() / 100.0F * 255.0F);
    Paint paint = this.b;
    paramInt = 0;
    paint.setAlpha(MiscUtils.a(i, 0, 255));
    BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.i;
    if (baseKeyframeAnimation != null)
      this.b.setColorFilter((ColorFilter)baseKeyframeAnimation.g()); 
    this.a.reset();
    while (paramInt < this.f.size()) {
      this.a.addPath(((PathContent)this.f.get(paramInt)).e(), paramMatrix);
      paramInt++;
    } 
    paramCanvas.drawPath(this.a, this.b);
    L.b("FillContent#draw");
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean) {
    this.a.reset();
    int i;
    for (i = 0; i < this.f.size(); i++)
      this.a.addPath(((PathContent)this.f.get(i)).e(), paramMatrix); 
    this.a.computeBounds(paramRectF, false);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
  }
  
  public void a(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2) {
    MiscUtils.a(paramKeyPath1, paramInt, paramList, paramKeyPath2, this);
  }
  
  public <T> void a(T paramT, LottieValueCallback<T> paramLottieValueCallback) {
    if (paramT == LottieProperty.a) {
      this.g.a(paramLottieValueCallback);
      return;
    } 
    if (paramT == LottieProperty.d) {
      this.h.a(paramLottieValueCallback);
      return;
    } 
    if (paramT == LottieProperty.B) {
      if (paramLottieValueCallback == null) {
        this.i = null;
        return;
      } 
      this.i = (BaseKeyframeAnimation<ColorFilter, ColorFilter>)new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
      this.i.a(this);
      this.c.a(this.i);
    } 
  }
  
  public void a(List<Content> paramList1, List<Content> paramList2) {
    for (int i = 0; i < paramList2.size(); i++) {
      Content content = paramList2.get(i);
      if (content instanceof PathContent)
        this.f.add((PathContent)content); 
    } 
  }
  
  public String b() {
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\content\FillContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */