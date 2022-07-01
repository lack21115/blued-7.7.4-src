package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;

public class NullLayer extends BaseLayer {
  NullLayer(LottieDrawable paramLottieDrawable, Layer paramLayer) {
    super(paramLottieDrawable, paramLayer);
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean) {
    super.a(paramRectF, paramMatrix, paramBoolean);
    paramRectF.set(0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\layer\NullLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */