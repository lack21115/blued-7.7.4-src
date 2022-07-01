package com.bytedance.sdk.openadsdk;

import android.graphics.Bitmap;

public interface TTDrawFeedAd extends TTFeedAd {
  void setCanInterruptVideoPlay(boolean paramBoolean);
  
  void setDrawVideoListener(DrawVideoListener paramDrawVideoListener);
  
  void setPauseIcon(Bitmap paramBitmap, int paramInt);
  
  public static interface DrawVideoListener {
    void onClick();
    
    void onClickRetry();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTDrawFeedAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */