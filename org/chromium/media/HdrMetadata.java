package org.chromium.media;

import org.chromium.base.annotations.CalledByNative;

class HdrMetadata {
  final Object mLock = new Object();
  
  long mNativeJniHdrMetadata;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  HdrMetadata() {
    this.mNativeJniHdrMetadata = 0L;
  }
  
  private HdrMetadata(long paramLong) {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private void close() {
    synchronized (this.mLock) {
      this.mNativeJniHdrMetadata = 0L;
      return;
    } 
  }
  
  @CalledByNative
  private static HdrMetadata create(long paramLong) {
    return new HdrMetadata(paramLong);
  }
  
  native int nativeColorTransfer(long paramLong);
  
  native int nativeMaxContentLuminance(long paramLong);
  
  native int nativeMaxFrameAverageLuminance(long paramLong);
  
  native float nativeMaxMasteringLuminance(long paramLong);
  
  native float nativeMinMasteringLuminance(long paramLong);
  
  native int nativePrimaries(long paramLong);
  
  native float nativePrimaryBChromaticityX(long paramLong);
  
  native float nativePrimaryBChromaticityY(long paramLong);
  
  native float nativePrimaryGChromaticityX(long paramLong);
  
  native float nativePrimaryGChromaticityY(long paramLong);
  
  native float nativePrimaryRChromaticityX(long paramLong);
  
  native float nativePrimaryRChromaticityY(long paramLong);
  
  native int nativeRange(long paramLong);
  
  native float nativeWhitePointChromaticityX(long paramLong);
  
  native float nativeWhitePointChromaticityY(long paramLong);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\HdrMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */