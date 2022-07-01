package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.Collections;
import java.util.List;

public class ShapeLayer extends BaseLayer {
  private final ContentGroup e;
  
  ShapeLayer(LottieDrawable paramLottieDrawable, Layer paramLayer) {
    super(paramLottieDrawable, paramLayer);
    this.e = new ContentGroup(paramLottieDrawable, this, new ShapeGroup("__container", paramLayer.n(), false));
    this.e.a(Collections.emptyList(), Collections.emptyList());
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean) {
    super.a(paramRectF, paramMatrix, paramBoolean);
    this.e.a(paramRectF, this.a, paramBoolean);
  }
  
  void b(Canvas paramCanvas, Matrix paramMatrix, int paramInt) {
    this.e.a(paramCanvas, paramMatrix, paramInt);
  }
  
  protected void b(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2) {
    this.e.a(paramKeyPath1, paramInt, paramList, paramKeyPath2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\layer\ShapeLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */