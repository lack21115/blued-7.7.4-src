package org.chromium.media;

enum BitrateAdjuster {
  FRAMERATE_ADJUSTMENT, NO_ADJUSTMENT;
  
  static {
    FRAMERATE_ADJUSTMENT = new BitrateAdjuster$2("FRAMERATE_ADJUSTMENT", 1);
    $VALUES = new BitrateAdjuster[] { NO_ADJUSTMENT, FRAMERATE_ADJUSTMENT };
    throw new VerifyError("bad dex opcode");
  }
  
  public abstract int getInitialFrameRate(int paramInt);
  
  public abstract int getTargetBitrate(int paramInt1, int paramInt2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\BitrateAdjuster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */