package org.chromium.media;

import android.media.MediaCodec;
import android.util.SparseArray;
import java.nio.ByteBuffer;
import org.chromium.base.Log;

final class MediaCodecEncoder extends MediaCodecBridge {
  private ByteBuffer mConfigData = null;
  
  private SparseArray mOutputBuffers = new SparseArray();
  
  protected MediaCodecEncoder(MediaCodec paramMediaCodec, BitrateAdjuster paramBitrateAdjuster) {
    super(paramMediaCodec, paramBitrateAdjuster);
  }
  
  private ByteBuffer getMediaCodecOutputBuffer(int paramInt) {
    ByteBuffer byteBuffer = super.getOutputBuffer(paramInt);
    if (byteBuffer != null)
      return byteBuffer; 
    throw new IllegalStateException("Got null output buffer");
  }
  
  protected final int dequeueOutputBufferInternal(MediaCodec.BufferInfo paramBufferInfo, long paramLong) {
    int i = -1;
    try {
      int j = this.mMediaCodec.dequeueOutputBuffer(paramBufferInfo, paramLong);
      if (j >= 0)
        try {
          if ((paramBufferInfo.flags & 0x2) != 0) {
            i = 1;
          } else {
            i = 0;
          } 
          if (i != 0) {
            i = paramBufferInfo.offset;
            i = paramBufferInfo.size;
            ByteBuffer byteBuffer = getMediaCodecOutputBuffer(j);
            byteBuffer.position(paramBufferInfo.offset);
            byteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
            this.mConfigData = ByteBuffer.allocateDirect(paramBufferInfo.size);
            this.mConfigData.put(byteBuffer);
            StringBuilder stringBuilder = new StringBuilder();
            i = 0;
            while (true) {
              int m = paramBufferInfo.size;
              int k = 8;
              if (m < 8)
                k = paramBufferInfo.size; 
              if (i < k) {
                stringBuilder.append(Integer.toHexString(this.mConfigData.get(i) & 0xFF));
                stringBuilder.append(" ");
                i++;
                continue;
              } 
              Log.i("cr_MediaCodecEncoder", "spsData: %s", new Object[] { stringBuilder.toString() });
              this.mMediaCodec.releaseOutputBuffer(j, false);
              i = this.mMediaCodec.dequeueOutputBuffer(paramBufferInfo, paramLong);
              j = i;
              break;
            } 
          } 
        } catch (IllegalStateException illegalStateException) {} 
      if (j >= 0) {
        i = j;
        ByteBuffer byteBuffer = getMediaCodecOutputBuffer(j);
        i = j;
        byteBuffer.position(((MediaCodec.BufferInfo)illegalStateException).offset);
        i = j;
        byteBuffer.limit(((MediaCodec.BufferInfo)illegalStateException).offset + ((MediaCodec.BufferInfo)illegalStateException).size);
        i = j;
        if ((((MediaCodec.BufferInfo)illegalStateException).flags & 0x1) != 0) {
          i = 1;
        } else {
          i = 0;
        } 
        if (i != 0) {
          i = j;
          if (this.mConfigData != null) {
            i = j;
            this.mConfigData.capacity();
            i = j;
            int k = ((MediaCodec.BufferInfo)illegalStateException).size;
            i = j;
            ByteBuffer byteBuffer1 = ByteBuffer.allocateDirect(this.mConfigData.capacity() + ((MediaCodec.BufferInfo)illegalStateException).size);
            i = j;
            this.mConfigData.rewind();
            i = j;
            byteBuffer1.put(this.mConfigData);
            i = j;
            byteBuffer1.put(byteBuffer);
            i = j;
            byteBuffer1.rewind();
            i = j;
            ((MediaCodec.BufferInfo)illegalStateException).offset = 0;
            i = j;
            ((MediaCodec.BufferInfo)illegalStateException).size += this.mConfigData.capacity();
            i = j;
            this.mOutputBuffers.put(j, byteBuffer1);
            return j;
          } 
        } 
        i = j;
        this.mOutputBuffers.put(j, byteBuffer);
      } 
      return j;
    } catch (IllegalStateException illegalStateException) {
      int j = i;
      Log.e("cr_MediaCodecEncoder", "Failed to dequeue output buffer", new Object[] { illegalStateException });
      return j;
    } 
  }
  
  protected final ByteBuffer getOutputBuffer(int paramInt) {
    return (ByteBuffer)this.mOutputBuffers.get(paramInt);
  }
  
  protected final void releaseOutputBuffer(int paramInt, boolean paramBoolean) {
    try {
      this.mMediaCodec.releaseOutputBuffer(paramInt, paramBoolean);
      this.mOutputBuffers.remove(paramInt);
      return;
    } catch (IllegalStateException illegalStateException) {
      Log.e("cr_MediaCodecEncoder", "Failed to release output buffer", new Object[] { illegalStateException });
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaCodecEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */