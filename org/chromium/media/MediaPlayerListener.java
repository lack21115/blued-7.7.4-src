package org.chromium.media;

import android.media.MediaPlayer;
import org.chromium.base.annotations.CalledByNative;

class MediaPlayerListener implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
  private long mNativeMediaPlayerListener;
  
  private MediaPlayerListener(long paramLong) {
    this.mNativeMediaPlayerListener = paramLong;
  }
  
  @CalledByNative
  private static MediaPlayerListener create(long paramLong, MediaPlayerBridge paramMediaPlayerBridge) {
    MediaPlayerListener mediaPlayerListener = new MediaPlayerListener(paramLong);
    if (paramMediaPlayerBridge != null) {
      paramMediaPlayerBridge.setOnBufferingUpdateListener(mediaPlayerListener);
      paramMediaPlayerBridge.setOnCompletionListener(mediaPlayerListener);
      paramMediaPlayerBridge.setOnErrorListener(mediaPlayerListener);
      paramMediaPlayerBridge.setOnPreparedListener(mediaPlayerListener);
      paramMediaPlayerBridge.setOnSeekCompleteListener(mediaPlayerListener);
      paramMediaPlayerBridge.setOnVideoSizeChangedListener(mediaPlayerListener);
    } 
    return mediaPlayerListener;
  }
  
  private native void nativeOnBufferingUpdate(long paramLong, int paramInt);
  
  private native void nativeOnMediaError(long paramLong, int paramInt);
  
  private native void nativeOnMediaInterrupted(long paramLong);
  
  private native void nativeOnMediaPrepared(long paramLong);
  
  private native void nativeOnPlaybackComplete(long paramLong);
  
  private native void nativeOnSeekComplete(long paramLong);
  
  private native void nativeOnVideoSizeChanged(long paramLong, int paramInt1, int paramInt2);
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt) {
    nativeOnBufferingUpdate(this.mNativeMediaPlayerListener, paramInt);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer) {
    nativeOnPlaybackComplete(this.mNativeMediaPlayerListener);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
    byte b = 3;
    if (paramInt1 != 1) {
      if (paramInt1 != 100) {
        if (paramInt1 != 200) {
          paramInt1 = b;
        } else {
          paramInt1 = 2;
        } 
      } else {
        paramInt1 = 4;
      } 
    } else if (paramInt2 != -1007) {
      if (paramInt2 != -110) {
        paramInt1 = 0;
      } else {
        paramInt1 = b;
      } 
    } else {
      paramInt1 = 1;
    } 
    nativeOnMediaError(this.mNativeMediaPlayerListener, paramInt1);
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer) {
    nativeOnMediaPrepared(this.mNativeMediaPlayerListener);
  }
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer) {
    nativeOnSeekComplete(this.mNativeMediaPlayerListener);
  }
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
    nativeOnVideoSizeChanged(this.mNativeMediaPlayerListener, paramInt1, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaPlayerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */