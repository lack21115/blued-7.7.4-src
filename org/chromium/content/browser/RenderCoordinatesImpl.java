package org.chromium.content.browser;

public final class RenderCoordinatesImpl {
  public float mContentHeightCss;
  
  public float mContentWidthCss;
  
  public float mDeviceScaleFactor = 1.0F;
  
  float mLastFrameViewportHeightCss;
  
  float mMaxPageScaleFactor = 1.0F;
  
  float mMinPageScaleFactor = 1.0F;
  
  public float mPageScaleFactor = 1.0F;
  
  public float mScrollXCss;
  
  public float mScrollYCss;
  
  public float mTopContentOffsetYPix;
  
  public final float fromLocalCssToPix(float paramFloat) {
    return paramFloat * this.mPageScaleFactor * this.mDeviceScaleFactor;
  }
  
  public final float getScrollXPix() {
    return fromLocalCssToPix(this.mScrollXCss);
  }
  
  public final float getScrollYPix() {
    return fromLocalCssToPix(this.mScrollYCss);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\RenderCoordinatesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */