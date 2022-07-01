package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.value.LottieValueCallback;

public class SolidLayer extends BaseLayer {
  private final RectF e = new RectF();
  
  private final Paint f = (Paint)new LPaint();
  
  private final float[] g = new float[8];
  
  private final Path h = new Path();
  
  private final Layer i;
  
  private BaseKeyframeAnimation<ColorFilter, ColorFilter> j;
  
  SolidLayer(LottieDrawable paramLottieDrawable, Layer paramLayer) {
    super(paramLottieDrawable, paramLayer);
    this.i = paramLayer;
    this.f.setAlpha(0);
    this.f.setStyle(Paint.Style.FILL);
    this.f.setColor(paramLayer.p());
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean) {
    super.a(paramRectF, paramMatrix, paramBoolean);
    this.e.set(0.0F, 0.0F, this.i.r(), this.i.q());
    this.a.mapRect(this.e);
    paramRectF.set(this.e);
  }
  
  public <T> void a(T paramT, LottieValueCallback<T> paramLottieValueCallback) {
    super.a(paramT, paramLottieValueCallback);
    if (paramT == LottieProperty.B) {
      if (paramLottieValueCallback == null) {
        this.j = null;
        return;
      } 
      this.j = (BaseKeyframeAnimation<ColorFilter, ColorFilter>)new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
    } 
  }
  
  public void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt) {
    int i;
    int j = Color.alpha(this.i.p());
    if (j == 0)
      return; 
    if (this.d.a() == null) {
      i = 100;
    } else {
      i = ((Integer)this.d.a().g()).intValue();
    } 
    paramInt = (int)(paramInt / 255.0F * j / 255.0F * i / 100.0F * 255.0F);
    this.f.setAlpha(paramInt);
    BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.j;
    if (baseKeyframeAnimation != null)
      this.f.setColorFilter((ColorFilter)baseKeyframeAnimation.g()); 
    if (paramInt > 0) {
      float[] arrayOfFloat = this.g;
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 0.0F;
      arrayOfFloat[2] = this.i.r();
      arrayOfFloat = this.g;
      arrayOfFloat[3] = 0.0F;
      arrayOfFloat[4] = this.i.r();
      this.g[5] = this.i.q();
      arrayOfFloat = this.g;
      arrayOfFloat[6] = 0.0F;
      arrayOfFloat[7] = this.i.q();
      paramMatrix.mapPoints(this.g);
      this.h.reset();
      Path path = this.h;
      arrayOfFloat = this.g;
      path.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
      path = this.h;
      arrayOfFloat = this.g;
      path.lineTo(arrayOfFloat[2], arrayOfFloat[3]);
      path = this.h;
      arrayOfFloat = this.g;
      path.lineTo(arrayOfFloat[4], arrayOfFloat[5]);
      path = this.h;
      arrayOfFloat = this.g;
      path.lineTo(arrayOfFloat[6], arrayOfFloat[7]);
      path = this.h;
      arrayOfFloat = this.g;
      path.lineTo(arrayOfFloat[0], arrayOfFloat[1]);
      this.h.close();
      paramCanvas.drawPath(this.h, this.f);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\layer\SolidLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */