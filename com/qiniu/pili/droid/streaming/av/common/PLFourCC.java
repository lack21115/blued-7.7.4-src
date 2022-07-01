package com.qiniu.pili.droid.streaming.av.common;

public final class PLFourCC {
  public static final int FOURCC_ABGR;
  
  public static final int FOURCC_I420 = makeFourCC('I', '4', '2', '0');
  
  public static final int FOURCC_NV12;
  
  public static final int FOURCC_NV21 = makeFourCC('N', 'V', '2', '1');
  
  public static final int FOURCC_UNKNOWN = -1;
  
  static {
    FOURCC_NV12 = makeFourCC('N', 'V', '1', '2');
    FOURCC_ABGR = makeFourCC('A', 'B', 'G', 'R');
  }
  
  public static int makeFourCC(char paramChar1, char paramChar2, char paramChar3, char paramChar4) {
    return paramChar1 | paramChar2 << 8 | paramChar3 << 16 | paramChar4 << 24;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\av\common\PLFourCC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */