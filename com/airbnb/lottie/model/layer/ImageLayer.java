package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;

public class ImageLayer extends BaseLayer {
  private final Paint e = (Paint)new LPaint(3);
  
  private final Rect f = new Rect();
  
  private final Rect g = new Rect();
  
  private BaseKeyframeAnimation<ColorFilter, ColorFilter> h;
  
  ImageLayer(LottieDrawable paramLottieDrawable, Layer paramLayer) {
    super(paramLottieDrawable, paramLayer);
  }
  
  private Bitmap f() {
    String str = this.c.g();
    return this.b.e(str);
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean) {
    super.a(paramRectF, paramMatrix, paramBoolean);
    Bitmap bitmap = f();
    if (bitmap != null) {
      paramRectF.set(0.0F, 0.0F, bitmap.getWidth() * Utils.a(), bitmap.getHeight() * Utils.a());
      this.a.mapRect(paramRectF);
    } 
  }
  
  public <T> void a(T paramT, LottieValueCallback<T> paramLottieValueCallback) {
    super.a(paramT, paramLottieValueCallback);
    if (paramT == LottieProperty.B) {
      if (paramLottieValueCallback == null) {
        this.h = null;
        return;
      } 
      this.h = (BaseKeyframeAnimation<ColorFilter, ColorFilter>)new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
    } 
  }
  
  public void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt) {
    Bitmap bitmap = f();
    if (bitmap != null) {
      if (bitmap.isRecycled())
        return; 
      float f = Utils.a();
      this.e.setAlpha(paramInt);
      BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.h;
      if (baseKeyframeAnimation != null)
        this.e.setColorFilter((ColorFilter)baseKeyframeAnimation.g()); 
      paramCanvas.save();
      paramCanvas.concat(paramMatrix);
      this.f.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
      this.g.set(0, 0, (int)(bitmap.getWidth() * f), (int)(bitmap.getHeight() * f));
      paramCanvas.drawBitmap(bitmap, this.f, this.g, this.e);
      paramCanvas.restore();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\layer\ImageLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */