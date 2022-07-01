package org.chromium.media;

enum BitrateAdjuster$2 {
  public final int getInitialFrameRate(int paramInt) {
    return 30;
  }
  
  public final int getTargetBitrate(int paramInt1, int paramInt2) {
    return (paramInt2 == 0) ? paramInt1 : (paramInt1 * 30 / paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\BitrateAdjuster$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */