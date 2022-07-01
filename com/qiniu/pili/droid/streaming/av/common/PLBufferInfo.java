package com.qiniu.pili.droid.streaming.av.common;

public final class PLBufferInfo {
  public static final int BUFFER_FLAG_CODEC_CONFIG = 2;
  
  public static final int BUFFER_FLAG_END_OF_STREAM = 4;
  
  public static final int BUFFER_FLAG_KEY_FRAME = 1;
  
  public static final int BUFFER_FLAG_P_FRAME = 8;
  
  public long dtsUs;
  
  public int flags;
  
  public boolean isNeedAddHeader = true;
  
  public int offset;
  
  public long presentationTimeUs;
  
  public int size;
  
  public PLBufferInfo() {
    set(0, 0, 0L, 0L, 0);
  }
  
  public PLBufferInfo dup() {
    PLBufferInfo pLBufferInfo = new PLBufferInfo();
    pLBufferInfo.set(this.offset, this.size, this.presentationTimeUs, this.dtsUs, this.flags);
    return pLBufferInfo;
  }
  
  public void set(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3) {
    this.offset = paramInt1;
    this.size = paramInt2;
    this.presentationTimeUs = paramLong1;
    this.dtsUs = paramLong2;
    this.flags = paramInt3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\av\common\PLBufferInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */