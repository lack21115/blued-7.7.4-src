package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import android.media.AudioTrack;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class TXCMultAudioTrackPlayer {
  private static final String TAG;
  
  private int mAudioMode = 0;
  
  private AudioTrackThread mAudioThread = null;
  
  private volatile boolean mAudioTrackStarted = false;
  
  private int mBits = 16;
  
  private int mChannel = 2;
  
  private Context mContext = null;
  
  private volatile boolean mIsStarted = false;
  
  private boolean mMute = false;
  
  private int mSampleRate = 48000;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AudioCenter:");
    stringBuilder.append(TXCMultAudioTrackPlayer.class.getSimpleName());
    TAG = stringBuilder.toString();
  }
  
  private TXCMultAudioTrackPlayer() {
    nativeClassInit();
  }
  
  public static TXCMultAudioTrackPlayer getInstance() {
    return TXCMultAudioTrackPlayerHolder.getInstance();
  }
  
  private native void nativeClassInit();
  
  private native byte[] nativeGetMixedTracksDataToAudioTrack();
  
  public boolean isPlaying() {
    return this.mIsStarted;
  }
  
  public void setAudioMode(Context paramContext, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield mContext : Landroid/content/Context;
    //   7: aload_0
    //   8: iload_2
    //   9: putfield mAudioMode : I
    //   12: aload_0
    //   13: getfield mAudioTrackStarted : Z
    //   16: ifeq -> 30
    //   19: getstatic com/tencent/liteav/audio/impl/Play/TXCMultAudioTrackPlayer.TAG : Ljava/lang/String;
    //   22: ldc 'mult-track-player setAudioRoute~'
    //   24: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)V
    //   27: goto -> 38
    //   30: getstatic com/tencent/liteav/audio/impl/Play/TXCMultAudioTrackPlayer.TAG : Ljava/lang/String;
    //   33: ldc 'mult-track-player do'not setAudioRoute~'
    //   35: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	41	finally
    //   30	38	41	finally
  }
  
  public void setMute(boolean paramBoolean) {
    this.mMute = paramBoolean;
  }
  
  public void start() {
    TXCLog.w(TAG, "mult-track-player start!");
    if (this.mIsStarted) {
      TXCLog.e(TAG, "mult-track-player can not start because of has started!");
      return;
    } 
    if (this.mSampleRate == 0 || this.mChannel == 0) {
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("strat mult-track-player failed with invalid audio info , samplerate:");
      stringBuilder.append(this.mSampleRate);
      stringBuilder.append(", channels:");
      stringBuilder.append(this.mChannel);
      TXCLog.e(str, stringBuilder.toString());
      return;
    } 
    this.mIsStarted = true;
    if (this.mAudioThread == null) {
      this.mAudioThread = new AudioTrackThread("AUDIO_TRACK") {
          public void run() {
            try {
              int i;
              int j;
              if (TXCMultAudioTrackPlayer.this.mChannel == 1) {
                i = 2;
              } else {
                i = 3;
              } 
              if (TXCMultAudioTrackPlayer.this.mBits == 8) {
                j = 3;
              } else {
                j = 2;
              } 
              int k = AudioTrack.getMinBufferSize(TXCMultAudioTrackPlayer.this.mSampleRate, i, j);
              AudioTrack audioTrack = new AudioTrack(3, TXCMultAudioTrackPlayer.this.mSampleRate, i, j, k, 1);
              String str = TXCMultAudioTrackPlayer.TAG;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("create audio track, samplerate:");
              stringBuilder.append(TXCMultAudioTrackPlayer.this.mSampleRate);
              stringBuilder.append(", channels:");
              stringBuilder.append(TXCMultAudioTrackPlayer.this.mChannel);
              stringBuilder.append(", bits:");
              stringBuilder.append(TXCMultAudioTrackPlayer.this.mBits);
              stringBuilder.append(" mMinBufferLength:");
              stringBuilder.append(k);
              TXCLog.i(str, stringBuilder.toString());
              try {
                audioTrack.play();
                TXCMultAudioTrackPlayer.access$502(TXCMultAudioTrackPlayer.this, true);
                TXCMultAudioTrackPlayer tXCMultAudioTrackPlayer = TXCMultAudioTrackPlayer.this;
                tXCMultAudioTrackPlayer.setAudioMode(tXCMultAudioTrackPlayer.mContext, TXCMultAudioTrackPlayer.this.mAudioMode);
                i = 100;
                j = 0;
                while (true) {
                  if (this.mIsLooping) {
                    byte[] arrayOfByte = TXCMultAudioTrackPlayer.this.nativeGetMixedTracksDataToAudioTrack();
                    if (arrayOfByte != null && arrayOfByte.length > 0) {
                      TXCAudioEngine.onCorePlayPcmData(arrayOfByte, 0L, TXCMultAudioTrackPlayer.this.mSampleRate, TXCMultAudioTrackPlayer.this.mChannel);
                      if (TXCMultAudioTrackPlayer.this.mMute)
                        Arrays.fill(arrayOfByte, (byte)0); 
                      int m = i;
                      k = j;
                      if (i != 0) {
                        m = i;
                        k = j;
                        if (j < 800) {
                          short[] arrayOfShort = new short[arrayOfByte.length / 2];
                          ByteBuffer.wrap(arrayOfByte).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(arrayOfShort);
                          for (k = 0; k < arrayOfShort.length; k++)
                            arrayOfShort[k] = (short)(arrayOfShort[k] / i); 
                          ByteBuffer.wrap(arrayOfByte).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(arrayOfShort);
                          k = j + arrayOfByte.length / TXCMultAudioTrackPlayer.this.mSampleRate * 2 / 1000;
                          m = i * (800 - k) / 800;
                        } 
                      } 
                      audioTrack.write(arrayOfByte, 0, arrayOfByte.length);
                      i = m;
                      j = k;
                      continue;
                    } 
                    try {
                      sleep(5L);
                    } catch (InterruptedException interruptedException) {}
                    continue;
                  } 
                  try {
                    audioTrack.pause();
                    audioTrack.flush();
                    audioTrack.stop();
                    audioTrack.release();
                  } catch (Exception exception) {
                    TXCLog.e(TXCMultAudioTrackPlayer.TAG, "stop AudioTrack failed.", exception);
                  } 
                  TXCLog.e(TXCMultAudioTrackPlayer.TAG, "mult-player thread stop finish!");
                  return;
                } 
              } catch (Exception exception) {
                TXCLog.e(TXCMultAudioTrackPlayer.TAG, "start play failed.", exception);
                return;
              } 
            } catch (Exception exception) {
              TXCLog.e(TXCMultAudioTrackPlayer.TAG, "create AudioTrack failed.", exception);
              return;
            } 
          }
        };
      this.mAudioThread.startLoop();
      this.mAudioThread.start();
    } 
    TXCLog.w(TAG, "mult-track-player thread start finish!");
  }
  
  public void stop() {
    TXCLog.w(TAG, "mult-track-player stop!");
    if (!this.mIsStarted) {
      TXCLog.w(TAG, "mult-track-player can not stop because of not started yet!");
      return;
    } 
    AudioTrackThread audioTrackThread = this.mAudioThread;
    if (audioTrackThread != null) {
      audioTrackThread.stopLoop();
      this.mAudioThread = null;
    } 
    this.mAudioMode = 0;
    this.mContext = null;
    this.mAudioTrackStarted = false;
    this.mIsStarted = false;
    TXCLog.w(TAG, "mult-track-player stop finish!");
  }
  
  class AudioTrackThread extends Thread {
    volatile boolean mIsLooping = false;
    
    public AudioTrackThread(String param1String) {
      super(param1String);
    }
    
    public void startLoop() {
      this.mIsLooping = true;
    }
    
    public void stopLoop() {
      this.mIsLooping = false;
    }
  }
  
  static class TXCMultAudioTrackPlayerHolder {
    private static TXCMultAudioTrackPlayer instance = new TXCMultAudioTrackPlayer();
    
    public static TXCMultAudioTrackPlayer getInstance() {
      return instance;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\tencent\liteav\audio\impl\Play\TXCMultAudioTrackPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */