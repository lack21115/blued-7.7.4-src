package com.airbnb.lottie.animation;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.LocaleList;

public class LPaint extends Paint {
  public LPaint() {}
  
  public LPaint(int paramInt) {
    super(paramInt);
  }
  
  public LPaint(int paramInt, PorterDuff.Mode paramMode) {
    super(paramInt);
    setXfermode((Xfermode)new PorterDuffXfermode(paramMode));
  }
  
  public LPaint(PorterDuff.Mode paramMode) {
    setXfermode((Xfermode)new PorterDuffXfermode(paramMode));
  }
  
  public void setTextLocales(LocaleList paramLocaleList) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\animation\LPaint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */