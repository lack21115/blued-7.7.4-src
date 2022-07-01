package org.chromium.media;

enum MediaCodecUtil$HWEncoderProperties {
  ExynosH264,
  ExynosVp8,
  MediatekH264,
  QcomH264,
  QcomVp8("video/x-vnd.on2.vp8", "OMX.qcom.", 19, BitrateAdjuster.NO_ADJUSTMENT);
  
  final BitrateAdjuster mBitrateAdjuster;
  
  final String mMime;
  
  final int mMinSDK;
  
  final String mPrefix;
  
  static {
    QcomH264 = new MediaCodecUtil$HWEncoderProperties("QcomH264", 1, "video/avc", "OMX.qcom.", 19, BitrateAdjuster.NO_ADJUSTMENT);
    ExynosVp8 = new MediaCodecUtil$HWEncoderProperties("ExynosVp8", 2, "video/x-vnd.on2.vp8", "OMX.Exynos.", 23, BitrateAdjuster.NO_ADJUSTMENT);
    ExynosH264 = new MediaCodecUtil$HWEncoderProperties("ExynosH264", 3, "video/avc", "OMX.Exynos.", 21, BitrateAdjuster.FRAMERATE_ADJUSTMENT);
    MediatekH264 = new MediaCodecUtil$HWEncoderProperties("MediatekH264", 4, "video/avc", "OMX.MTK.", 27, BitrateAdjuster.FRAMERATE_ADJUSTMENT);
    $VALUES = new MediaCodecUtil$HWEncoderProperties[] { QcomVp8, QcomH264, ExynosVp8, ExynosH264, MediatekH264 };
    throw new VerifyError("bad dex opcode");
  }
  
  MediaCodecUtil$HWEncoderProperties(String paramString1, String paramString2, int paramInt1, BitrateAdjuster paramBitrateAdjuster) {
    this.mMime = paramString1;
    this.mPrefix = paramString2;
    this.mMinSDK = paramInt1;
    this.mBitrateAdjuster = paramBitrateAdjuster;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaCodecUtil$HWEncoderProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */