package org.chromium.media;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

class MediaCodecBridge {
  private BitrateAdjuster mBitrateAdjuster;
  
  private boolean mFlushed;
  
  private ByteBuffer[] mInputBuffers;
  
  private long mLastPresentationTimeUs;
  
  protected MediaCodec mMediaCodec;
  
  private ByteBuffer[] mOutputBuffers;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  MediaCodecBridge(MediaCodec paramMediaCodec, BitrateAdjuster paramBitrateAdjuster) {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private MediaCodecBridge$DequeueInputResult dequeueInputBuffer(long paramLong) {
    int j;
    byte b = 1;
    int i = -1;
    try {
      j = this.mMediaCodec.dequeueInputBuffer(paramLong);
      if (j >= 0) {
        i = j;
        b = 0;
        return new MediaCodecBridge$DequeueInputResult(b, i, (byte)0);
      } 
    } catch (Exception exception) {
      Log.e("cr_MediaCodecBridge", "Failed to dequeue input buffer", new Object[] { exception });
      b = 5;
      return new MediaCodecBridge$DequeueInputResult(b, i, (byte)0);
    } 
    if (j == -1)
      return new MediaCodecBridge$DequeueInputResult(b, i, (byte)0); 
    StringBuilder stringBuilder = new StringBuilder("Unexpected index_or_status: ");
    stringBuilder.append(j);
    Log.e("cr_MediaCodecBridge", stringBuilder.toString(), new Object[0]);
    assert false;
    b = 5;
    return new MediaCodecBridge$DequeueInputResult(b, i, (byte)0);
  }
  
  @CalledByNative
  private MediaCodecBridge$DequeueOutputResult dequeueOutputBuffer(long paramLong) {
    int i;
    byte b;
    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
    try {
      int j = dequeueOutputBufferInternal(bufferInfo, paramLong);
      if (bufferInfo.presentationTimeUs < this.mLastPresentationTimeUs)
        bufferInfo.presentationTimeUs = this.mLastPresentationTimeUs; 
      this.mLastPresentationTimeUs = bufferInfo.presentationTimeUs;
      if (j >= 0) {
        i = 0;
        b = j;
      } else {
        if (j == -3) {
          this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
          j = 2;
        } else if (j == -2) {
          this.mMediaCodec.getOutputFormat();
          j = 3;
        } else if (j == -1) {
          j = 1;
        } else {
          StringBuilder stringBuilder = new StringBuilder("Unexpected index_or_status: ");
          stringBuilder.append(j);
          Log.e("cr_MediaCodecBridge", stringBuilder.toString(), new Object[0]);
          assert false;
          j = 5;
        } 
        b = -1;
        i = j;
      } 
    } catch (IllegalStateException illegalStateException) {
      Log.e("cr_MediaCodecBridge", "Failed to dequeue output buffer", new Object[] { illegalStateException });
      byte b1 = 5;
    } 
    return new MediaCodecBridge$DequeueOutputResult(i, b, bufferInfo.flags, bufferInfo.offset, bufferInfo.presentationTimeUs, bufferInfo.size, (byte)0);
  }
  
  @CalledByNative
  private int flush() {
    try {
      this.mFlushed = true;
      this.mMediaCodec.flush();
      return 0;
    } catch (Exception exception) {
      Log.e("cr_MediaCodecBridge", "Failed to flush MediaCodec", new Object[] { exception });
      return 5;
    } 
  }
  
  @SuppressLint({"NewApi"})
  @CalledByNative
  private ByteBuffer getInputBuffer(int paramInt) {
    if (Build.VERSION.SDK_INT > 19)
      try {
        return this.mMediaCodec.getInputBuffer(paramInt);
      } catch (IllegalStateException illegalStateException) {
        Log.e("cr_MediaCodecBridge", "Failed to get input buffer", new Object[] { illegalStateException });
        return null;
      }  
    return this.mInputBuffers[paramInt];
  }
  
  @TargetApi(19)
  @CalledByNative
  private String getName() {
    try {
      return this.mMediaCodec.getName();
    } catch (IllegalStateException illegalStateException) {
      Log.e("cr_MediaCodecBridge", "Cannot get codec name", new Object[] { illegalStateException });
      return "unknown";
    } 
  }
  
  @CalledByNative
  private MediaCodecBridge$GetOutputFormatResult getOutputFormat() {
    byte b;
    try {
      MediaFormat mediaFormat = this.mMediaCodec.getOutputFormat();
      b = 0;
    } catch (IllegalStateException illegalStateException) {
      Log.e("cr_MediaCodecBridge", "Failed to get output format", new Object[] { illegalStateException });
      b = 5;
      illegalStateException = null;
    } 
    return new MediaCodecBridge$GetOutputFormatResult(b, (MediaFormat)illegalStateException, (byte)0);
  }
  
  @CalledByNative
  private int queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4) {
    resetLastPresentationTimeIfNeeded(paramLong);
    try {
      this.mMediaCodec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      return 0;
    } catch (Exception exception) {
      Log.e("cr_MediaCodecBridge", "Failed to queue input buffer", new Object[] { exception });
      return 5;
    } 
  }
  
  @SuppressLint({"WrongConstant"})
  @CalledByNative
  private int queueSecureInputBuffer(int paramInt1, int paramInt2, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong) {
    StringBuilder stringBuilder;
    boolean bool;
    resetLastPresentationTimeIfNeeded(paramLong);
    switch (paramInt4) {
      default:
        try {
          StringBuilder stringBuilder1 = new StringBuilder("Unsupported cipher mode: ");
          stringBuilder1.append(paramInt4);
          Log.e("cr_MediaCodecBridge", stringBuilder1.toString(), new Object[0]);
          paramInt4 = -1;
        } catch (android.media.MediaCodec.CryptoException cryptoException) {
          if (cryptoException.getErrorCode() == 1)
            return 4; 
          stringBuilder = new StringBuilder("Failed to queue secure input buffer, CryptoException with error code ");
          stringBuilder.append(cryptoException.getErrorCode());
          Log.e("cr_MediaCodecBridge", stringBuilder.toString(), new Object[0]);
          return 5;
        } catch (IllegalArgumentException illegalArgumentException) {
          stringBuilder = new StringBuilder("Failed to queue secure input buffer, IllegalArgumentException ");
          stringBuilder.append(illegalArgumentException);
          Log.e("cr_MediaCodecBridge", stringBuilder.toString(), new Object[0]);
          return 5;
        } catch (IllegalStateException illegalStateException) {
          stringBuilder = new StringBuilder("Failed to queue secure input buffer, IllegalStateException ");
          stringBuilder.append(illegalStateException);
          Log.e("cr_MediaCodecBridge", stringBuilder.toString(), new Object[0]);
          return 5;
        } 
        break;
      case 2:
        paramInt4 = 2;
        break;
      case 1:
        paramInt4 = 1;
        break;
      case 0:
        paramInt4 = 0;
        break;
    } 
    if (paramInt4 == -1)
      return 5; 
    if (paramInt4 == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool && !MediaCodecUtil.platformSupportsCbcsEncryption(Build.VERSION.SDK_INT)) {
      Log.e("cr_MediaCodecBridge", "Encryption scheme 'cbcs' not supported on this platform.", new Object[0]);
      return 5;
    } 
    MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
    cryptoInfo.set(paramInt3, paramArrayOfint1, paramArrayOfint2, (byte[])stringBuilder, (byte[])illegalStateException, paramInt4);
    if (paramInt5 != 0 && paramInt6 != 0)
      if (bool) {
        MediaCodecUtil.setPatternIfSupported(cryptoInfo, paramInt5, paramInt6);
      } else {
        Log.e("cr_MediaCodecBridge", "Pattern encryption only supported for 'cbcs' scheme (CBC mode).", new Object[0]);
        return 5;
      }  
    this.mMediaCodec.queueSecureInputBuffer(paramInt1, paramInt2, cryptoInfo, paramLong, 0);
    return 0;
  }
  
  @TargetApi(19)
  @CalledByNative
  private void requestKeyFrameSoon() {
    Bundle bundle = new Bundle();
    bundle.putInt("request-sync", 0);
    try {
      this.mMediaCodec.setParameters(bundle);
      return;
    } catch (IllegalStateException illegalStateException) {
      Log.e("cr_MediaCodecBridge", "Failed to set MediaCodec parameters", new Object[] { illegalStateException });
      return;
    } 
  }
  
  private void resetLastPresentationTimeIfNeeded(long paramLong) {
    if (this.mFlushed) {
      this.mLastPresentationTimeUs = Math.max(paramLong - 100000L, 0L);
      this.mFlushed = false;
    } 
  }
  
  @TargetApi(23)
  @CalledByNative
  private boolean setSurface(Surface paramSurface) {
    try {
      this.mMediaCodec.setOutputSurface(paramSurface);
      return true;
    } catch (IllegalArgumentException|IllegalStateException illegalArgumentException) {
      Log.e("cr_MediaCodecBridge", "Cannot set output surface", new Object[] { illegalArgumentException });
      return false;
    } 
  }
  
  @TargetApi(19)
  @CalledByNative
  private void setVideoBitrate(int paramInt1, int paramInt2) {
    int i = this.mBitrateAdjuster.getTargetBitrate(paramInt1, paramInt2);
    Bundle bundle = new Bundle();
    bundle.putInt("video-bitrate", i);
    try {
      this.mMediaCodec.setParameters(bundle);
    } catch (IllegalStateException illegalStateException) {
      Log.e("cr_MediaCodecBridge", "Failed to set MediaCodec parameters", new Object[] { illegalStateException });
    } 
    StringBuilder stringBuilder = new StringBuilder("setVideoBitrate: input ");
    stringBuilder.append(paramInt1);
    stringBuilder.append("bps@");
    stringBuilder.append(paramInt2);
    stringBuilder.append(", targetBps ");
    stringBuilder.append(i);
  }
  
  @CalledByNative
  private void stop() {
    try {
      this.mMediaCodec.stop();
      return;
    } catch (IllegalStateException illegalStateException) {
      Log.e("cr_MediaCodecBridge", "Failed to stop MediaCodec", new Object[] { illegalStateException });
      return;
    } 
  }
  
  final boolean configureAudio(MediaFormat paramMediaFormat, MediaCrypto paramMediaCrypto, int paramInt) {
    try {
      this.mMediaCodec.configure(paramMediaFormat, null, paramMediaCrypto, paramInt);
      return true;
    } catch (IllegalArgumentException illegalArgumentException) {
      Log.e("cr_MediaCodecBridge", "Cannot configure the audio codec", new Object[] { illegalArgumentException });
    } catch (IllegalStateException illegalStateException) {
      Log.e("cr_MediaCodecBridge", "Cannot configure the audio codec", new Object[] { illegalStateException });
    } catch (android.media.MediaCodec.CryptoException cryptoException) {
      Log.e("cr_MediaCodecBridge", "Cannot configure the audio codec: DRM error", new Object[] { cryptoException });
    } catch (Exception exception) {
      Log.e("cr_MediaCodecBridge", "Cannot configure the audio codec", new Object[] { exception });
      return false;
    } 
    return false;
  }
  
  final boolean configureVideo(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto, int paramInt) {
    try {
      this.mMediaCodec.configure(paramMediaFormat, paramSurface, paramMediaCrypto, paramInt);
      return true;
    } catch (IllegalArgumentException illegalArgumentException) {
      Log.e("cr_MediaCodecBridge", "Cannot configure the video codec, wrong format or surface", new Object[] { illegalArgumentException });
    } catch (IllegalStateException illegalStateException) {
      Log.e("cr_MediaCodecBridge", "Cannot configure the video codec", new Object[] { illegalStateException });
    } catch (android.media.MediaCodec.CryptoException cryptoException) {
      Log.e("cr_MediaCodecBridge", "Cannot configure the video codec: DRM error", new Object[] { cryptoException });
    } catch (Exception exception) {
      Log.e("cr_MediaCodecBridge", "Cannot configure the video codec", new Object[] { exception });
      return false;
    } 
    return false;
  }
  
  protected int dequeueOutputBufferInternal(MediaCodec.BufferInfo paramBufferInfo, long paramLong) {
    return this.mMediaCodec.dequeueOutputBuffer(paramBufferInfo, paramLong);
  }
  
  @SuppressLint({"NewApi"})
  @CalledByNative
  protected ByteBuffer getOutputBuffer(int paramInt) {
    if (Build.VERSION.SDK_INT > 19)
      try {
        return this.mMediaCodec.getOutputBuffer(paramInt);
      } catch (IllegalStateException illegalStateException) {
        Log.e("cr_MediaCodecBridge", "Failed to get output buffer", new Object[] { illegalStateException });
        return null;
      }  
    return this.mOutputBuffers[paramInt];
  }
  
  @CalledByNative
  void release() {
    String str = "unknown";
    try {
      if (Build.VERSION.SDK_INT >= 18)
        str = this.mMediaCodec.getName(); 
      StringBuilder stringBuilder = new StringBuilder("Releasing: ");
      stringBuilder.append(str);
      Log.w("cr_MediaCodecBridge", stringBuilder.toString(), new Object[0]);
      this.mMediaCodec.release();
      Log.w("cr_MediaCodecBridge", "Codec released", new Object[0]);
    } catch (IllegalStateException illegalStateException) {
      Log.e("cr_MediaCodecBridge", "Cannot release media codec", new Object[] { illegalStateException });
    } 
    this.mMediaCodec = null;
  }
  
  @CalledByNative
  protected void releaseOutputBuffer(int paramInt, boolean paramBoolean) {
    try {
      this.mMediaCodec.releaseOutputBuffer(paramInt, paramBoolean);
      return;
    } catch (IllegalStateException illegalStateException) {
      Log.e("cr_MediaCodecBridge", "Failed to release output buffer", new Object[] { illegalStateException });
      return;
    } 
  }
  
  final boolean start() {
    try {
      this.mMediaCodec.start();
      if (Build.VERSION.SDK_INT <= 19) {
        this.mInputBuffers = this.mMediaCodec.getInputBuffers();
        this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
      } 
      return true;
    } catch (IllegalStateException illegalStateException) {
      Log.e("cr_MediaCodecBridge", "Cannot start the media codec", new Object[] { illegalStateException });
      return false;
    } catch (IllegalArgumentException illegalArgumentException) {
      Log.e("cr_MediaCodecBridge", "Cannot start the media codec", new Object[] { illegalArgumentException });
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaCodecBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */