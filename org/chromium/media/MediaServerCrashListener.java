package org.chromium.media;

import android.media.MediaPlayer;
import android.os.SystemClock;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

public class MediaServerCrashListener implements MediaPlayer.OnErrorListener {
  private long mLastReportedWatchdogCreationFailure;
  
  private long mNativeMediaServerCrashListener;
  
  private MediaPlayer mPlayer;
  
  private MediaServerCrashListener(long paramLong) {
    new Object();
    this.mLastReportedWatchdogCreationFailure = -1L;
    this.mNativeMediaServerCrashListener = paramLong;
  }
  
  @CalledByNative
  private static MediaServerCrashListener create(long paramLong) {
    return new MediaServerCrashListener(paramLong);
  }
  
  private native void nativeOnMediaServerCrashDetected(long paramLong, boolean paramBoolean);
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
    if (paramInt1 == 100) {
      nativeOnMediaServerCrashDetected(this.mNativeMediaServerCrashListener, true);
      releaseWatchdog();
    } 
    return true;
  }
  
  @CalledByNative
  public void releaseWatchdog() {
    if (this.mPlayer == null)
      return; 
    this.mPlayer.release();
    this.mPlayer = null;
  }
  
  @CalledByNative
  public boolean startListening() {
    if (this.mPlayer != null)
      return true; 
    try {
      this.mPlayer = MediaPlayer.create(ContextUtils.sApplicationContext, R$raw.empty);
    } catch (IllegalStateException illegalStateException) {
      Log.e("crMediaCrashListener", "Exception while creating the watchdog player.", new Object[] { illegalStateException });
    } catch (RuntimeException runtimeException) {
      Log.e("crMediaCrashListener", "Exception while creating the watchdog player.", new Object[] { runtimeException });
    } 
    if (this.mPlayer != null) {
      this.mPlayer.setOnErrorListener(this);
      this.mLastReportedWatchdogCreationFailure = -1L;
      return true;
    } 
    long l = SystemClock.elapsedRealtime();
    if (this.mLastReportedWatchdogCreationFailure == -1L || l - this.mLastReportedWatchdogCreationFailure > 5000L) {
      Log.e("crMediaCrashListener", "Unable to create watchdog player, treating it as server crash.", new Object[0]);
      nativeOnMediaServerCrashDetected(this.mNativeMediaServerCrashListener, false);
      this.mLastReportedWatchdogCreationFailure = l;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaServerCrashListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */