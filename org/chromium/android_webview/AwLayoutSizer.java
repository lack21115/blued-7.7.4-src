package org.chromium.android_webview;

public final class AwLayoutSizer {
  int mContentHeightCss;
  
  int mContentWidthCss;
  
  double mDIPScale;
  
  AwLayoutSizer$Delegate mDelegate;
  
  boolean mFreezeLayoutRequests;
  
  boolean mFrozenLayoutRequestPending;
  
  boolean mHeightMeasurementIsFixed;
  
  int mHeightMeasurementLimit;
  
  boolean mHeightMeasurementLimited;
  
  float mPageScaleFactor = 1.0F;
  
  boolean mWidthMeasurementIsFixed;
  
  final void doUpdate(int paramInt1, int paramInt2, float paramFloat) {
    boolean bool1;
    boolean bool2;
    int i = (int)((paramInt2 * this.mPageScaleFactor) * this.mDIPScale);
    float f = this.mPageScaleFactor;
    boolean bool3 = false;
    if (f != paramFloat) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (!this.mHeightMeasurementIsFixed && (!this.mHeightMeasurementLimited || i < this.mHeightMeasurementLimit)) {
      i = 1;
    } else {
      i = 0;
    } 
    if (!this.mWidthMeasurementIsFixed || i != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if ((this.mContentWidthCss != paramInt1 && !this.mWidthMeasurementIsFixed) || (this.mContentHeightCss != paramInt2 && i != 0) || (bool1 && bool2)) {
      bool1 = true;
    } else {
      bool1 = bool3;
    } 
    this.mContentWidthCss = paramInt1;
    this.mContentHeightCss = paramInt2;
    this.mPageScaleFactor = paramFloat;
    if (bool1) {
      if (this.mFreezeLayoutRequests) {
        this.mFrozenLayoutRequestPending = true;
        return;
      } 
      this.mDelegate.requestLayout();
    } 
  }
  
  public final void updateLayoutSettings() {
    this.mDelegate.setForceZeroLayoutHeight(this.mDelegate.isLayoutParamsHeightWrapContent());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwLayoutSizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */