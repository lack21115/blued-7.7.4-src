package com.qiniu.pili.droid.streaming.microphone;

import java.nio.ByteBuffer;

public class AudioTransformer {
  public native void destroy(long paramLong);
  
  public native long init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public native int resample(long paramLong, ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer2, int paramInt3);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\microphone\AudioTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */