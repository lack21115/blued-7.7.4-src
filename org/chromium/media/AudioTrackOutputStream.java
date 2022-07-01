package org.chromium.media;

import android.media.AudioTrack;
import java.nio.ByteBuffer;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

class AudioTrackOutputStream {
  private AudioTrack mAudioTrack;
  
  private int mBufferSizeInBytes;
  
  private AudioTrackOutputStream$Callback mCallback;
  
  private int mLastPlaybackHeadPosition;
  
  private int mLeftSize;
  
  private long mNativeAudioTrackOutputStream;
  
  private ByteBuffer mReadBuffer;
  
  private long mTotalPlayedFrames;
  
  private long mTotalReadFrames;
  
  private AudioTrackOutputStream$WorkerThread mWorkerThread;
  
  private ByteBuffer mWriteBuffer;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private AudioTrackOutputStream(AudioTrackOutputStream$Callback paramAudioTrackOutputStream$Callback) {
    this.mCallback = paramAudioTrackOutputStream$Callback;
    if (this.mCallback != null)
      return; 
    this.mCallback = new AudioTrackOutputStream$1(this);
  }
  
  @CalledByNative
  private static AudioTrackOutputStream create() {
    return new AudioTrackOutputStream(null);
  }
  
  private native long nativeGetAddress(long paramLong, ByteBuffer paramByteBuffer);
  
  private native void nativeOnError(long paramLong);
  
  private native AudioTrackOutputStream$AudioBufferInfo nativeOnMoreData(long paramLong1, ByteBuffer paramByteBuffer, long paramLong2);
  
  @CalledByNative
  void close() {
    if (this.mAudioTrack != null) {
      this.mAudioTrack.release();
      this.mAudioTrack = null;
    } 
  }
  
  @CalledByNative
  AudioTrackOutputStream$AudioBufferInfo createAudioBufferInfo(int paramInt1, int paramInt2) {
    return new AudioTrackOutputStream$AudioBufferInfo(paramInt1, paramInt2);
  }
  
  @CalledByNative
  boolean open(int paramInt1, int paramInt2, int paramInt3) {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  void setVolume(double paramDouble) {
    float f = (float)(paramDouble * AudioTrack.getMaxVolume());
    this.mAudioTrack.setStereoVolume(f, f);
  }
  
  @CalledByNative
  void start(long paramLong) {
    if (this.mWorkerThread != null)
      return; 
    this.mNativeAudioTrackOutputStream = paramLong;
    this.mTotalReadFrames = 0L;
    int i = this.mBufferSizeInBytes;
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(i + 15);
    int j = 16 - (int)(this.mCallback.getAddress(byteBuffer) & 0xFL) & 0xF;
    byteBuffer.position(j);
    byteBuffer.limit(j + i);
    this.mReadBuffer = byteBuffer.slice();
    this.mAudioTrack.play();
    this.mWorkerThread = new AudioTrackOutputStream$WorkerThread(this);
    this.mWorkerThread.start();
  }
  
  @CalledByNative
  void stop() {
    if (this.mWorkerThread != null) {
      this.mWorkerThread.mDone = true;
      try {
        this.mWorkerThread.interrupt();
        this.mWorkerThread.join();
      } catch (SecurityException securityException) {
        Log.e("AudioTrackOutput", "Exception while waiting for AudioTrack worker thread finished: ", new Object[] { securityException });
      } catch (InterruptedException interruptedException) {
        Log.e("AudioTrackOutput", "Exception while waiting for AudioTrack worker thread finished: ", new Object[] { interruptedException });
      } 
      this.mWorkerThread = null;
    } 
    this.mAudioTrack.pause();
    this.mAudioTrack.flush();
    this.mLastPlaybackHeadPosition = 0;
    this.mTotalPlayedFrames = 0L;
    this.mNativeAudioTrackOutputStream = 0L;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\AudioTrackOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */