package com.airbnb.lottie.value;

import android.graphics.PointF;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieRelativePointValueCallback extends LottieValueCallback<PointF> {
  private final PointF a = new PointF();
  
  public final PointF b(LottieFrameInfo<PointF> paramLottieFrameInfo) {
    this.a.set(MiscUtils.a(((PointF)paramLottieFrameInfo.a()).x, ((PointF)paramLottieFrameInfo.b()).x, paramLottieFrameInfo.c()), MiscUtils.a(((PointF)paramLottieFrameInfo.a()).y, ((PointF)paramLottieFrameInfo.b()).y, paramLottieFrameInfo.c()));
    PointF pointF = c(paramLottieFrameInfo);
    this.a.offset(pointF.x, pointF.y);
    return this.a;
  }
  
  public PointF c(LottieFrameInfo<PointF> paramLottieFrameInfo) {
    if (this.b != null)
      return this.b; 
    throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\value\LottieRelativePointValueCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */