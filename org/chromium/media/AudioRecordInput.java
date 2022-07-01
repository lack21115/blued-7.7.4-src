package org.chromium.media;

import android.annotation.SuppressLint;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import java.nio.ByteBuffer;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

class AudioRecordInput {
  private AcousticEchoCanceler mAEC;
  
  private AudioRecord mAudioRecord;
  
  private AudioRecordInput$AudioRecordThread mAudioRecordThread;
  
  private final int mBitsPerSample;
  
  private ByteBuffer mBuffer;
  
  private final int mChannels;
  
  private final long mNativeAudioRecordInputStream;
  
  private final int mSampleRate;
  
  private final boolean mUsePlatformAEC;
  
  private AudioRecordInput(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
    this.mNativeAudioRecordInputStream = paramLong;
    this.mSampleRate = paramInt1;
    this.mChannels = paramInt2;
    this.mBitsPerSample = paramInt3;
    this.mUsePlatformAEC = paramBoolean;
    this.mBuffer = ByteBuffer.allocateDirect(paramInt4);
    nativeCacheDirectBufferAddress(this.mNativeAudioRecordInputStream, this.mBuffer);
  }
  
  @SuppressLint({"NewApi"})
  @CalledByNative
  private void close() {
    if (this.mAudioRecordThread != null) {
      Log.e("cr.media", "close() called before stop().", new Object[0]);
      return;
    } 
    if (this.mAudioRecord == null)
      return; 
    if (this.mAEC != null) {
      this.mAEC.release();
      this.mAEC = null;
    } 
    this.mAudioRecord.release();
    this.mAudioRecord = null;
  }
  
  @CalledByNative
  private static AudioRecordInput createAudioRecordInput(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
    return new AudioRecordInput(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
  }
  
  private native void nativeCacheDirectBufferAddress(long paramLong, ByteBuffer paramByteBuffer);
  
  private native void nativeOnData(long paramLong, int paramInt1, int paramInt2);
  
  @SuppressLint({"NewApi"})
  @CalledByNative
  private boolean open() {
    int i;
    byte b;
    if (this.mAudioRecord != null) {
      Log.e("cr.media", "open() called twice without a close()", new Object[0]);
      return false;
    } 
    if (this.mChannels == 1) {
      i = 16;
    } else if (this.mChannels == 2) {
      i = 12;
    } else {
      Log.e("cr.media", "Unsupported number of channels: %d", new Object[] { Integer.valueOf(this.mChannels) });
      return false;
    } 
    if (this.mBitsPerSample == 8) {
      b = 3;
    } else if (this.mBitsPerSample == 16) {
      b = 2;
    } else {
      Log.e("cr.media", "Unsupported bits per sample: %d", new Object[] { Integer.valueOf(this.mBitsPerSample) });
      return false;
    } 
    int j = AudioRecord.getMinBufferSize(this.mSampleRate, i, b);
    if (j < 0) {
      Log.e("cr.media", "getMinBufferSize error: %d", new Object[] { Integer.valueOf(j) });
      return false;
    } 
    j = Math.max(this.mBuffer.capacity(), j);
    try {
      this.mAudioRecord = new AudioRecord(7, this.mSampleRate, i, b, j);
      if (AcousticEchoCanceler.isAvailable()) {
        this.mAEC = AcousticEchoCanceler.create(this.mAudioRecord.getAudioSessionId());
        if (this.mAEC == null) {
          Log.e("cr.media", "AcousticEchoCanceler.create failed", new Object[0]);
          return false;
        } 
        i = this.mAEC.setEnabled(this.mUsePlatformAEC);
        if (i != 0) {
          Log.e("cr.media", "setEnabled error: %d", new Object[] { Integer.valueOf(i) });
          return false;
        } 
      } 
      return true;
    } catch (IllegalArgumentException illegalArgumentException) {
      Log.e("cr.media", "AudioRecord failed", new Object[] { illegalArgumentException });
      return false;
    } 
  }
  
  @CalledByNative
  private void start() {
    if (this.mAudioRecord == null) {
      Log.e("cr.media", "start() called before open().", new Object[0]);
      return;
    } 
    if (this.mAudioRecordThread != null)
      return; 
    this.mAudioRecordThread = new AudioRecordInput$AudioRecordThread(this, (byte)0);
    this.mAudioRecordThread.start();
  }
  
  @CalledByNative
  private void stop() {
    if (this.mAudioRecordThread == null)
      return; 
    AudioRecordInput$AudioRecordThread audioRecordInput$AudioRecordThread = this.mAudioRecordThread;
    audioRecordInput$AudioRecordThread.mKeepAlive = false;
    while (audioRecordInput$AudioRecordThread.isAlive()) {
      try {
        audioRecordInput$AudioRecordThread.join();
      } catch (InterruptedException interruptedException) {}
    } 
    this.mAudioRecordThread = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\AudioRecordInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */