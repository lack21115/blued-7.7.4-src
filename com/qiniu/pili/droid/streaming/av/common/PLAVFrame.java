package com.qiniu.pili.droid.streaming.av.common;

import java.nio.ByteBuffer;

public class PLAVFrame {
  public ByteBuffer mBuffer;
  
  public int mCurrentHeight = 0;
  
  public int mCurrentWidth = 0;
  
  public long mDtsUs;
  
  public long mPresentationTimeUs;
  
  public int mSize;
  
  public volatile long usedCounter = 0L;
  
  public PLAVFrame(ByteBuffer paramByteBuffer, int paramInt, long paramLong) {
    this.mBuffer = paramByteBuffer;
    this.mSize = paramInt;
    this.mPresentationTimeUs = paramLong;
  }
  
  public void fillFrame(ByteBuffer paramByteBuffer, int paramInt, long paramLong) {
    this.mBuffer.clear();
    this.mSize = paramInt;
    this.mBuffer = this.mBuffer.put(paramByteBuffer);
    this.mPresentationTimeUs = paramLong;
  }
  
  public void fillFrame(byte[] paramArrayOfbyte, long paramLong) {
    this.mBuffer.clear();
    this.mBuffer = this.mBuffer.put(paramArrayOfbyte);
    this.mSize = paramArrayOfbyte.length;
    this.mPresentationTimeUs = paramLong;
  }
  
  public void fillFrame(ByteBuffer[] paramArrayOfByteBuffer, long paramLong) {
    this.mBuffer.clear();
    int i = 0;
    this.mSize = 0;
    int j = paramArrayOfByteBuffer.length;
    while (i < j) {
      ByteBuffer byteBuffer = paramArrayOfByteBuffer[i];
      byteBuffer.rewind();
      this.mSize += byteBuffer.capacity();
      this.mBuffer.put(byteBuffer);
      i++;
    } 
    this.mPresentationTimeUs = paramLong;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\av\common\PLAVFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */