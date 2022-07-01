package org.chromium.content.browser;

import android.media.AudioManager;
import org.chromium.base.annotations.CalledByNative;

public class AudioFocusDelegate implements AudioManager.OnAudioFocusChangeListener {
  private int mFocusType;
  
  private boolean mIsDucking;
  
  private long mNativeAudioFocusDelegateAndroid;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private AudioFocusDelegate(long paramLong) {
    this.mNativeAudioFocusDelegateAndroid = paramLong;
  }
  
  @CalledByNative
  private void abandonAudioFocus() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private static AudioFocusDelegate create(long paramLong) {
    return new AudioFocusDelegate(paramLong);
  }
  
  private native void nativeOnResume(long paramLong);
  
  private native void nativeOnStartDucking(long paramLong);
  
  private native void nativeOnStopDucking(long paramLong);
  
  private native void nativeOnSuspend(long paramLong);
  
  private native void nativeRecordSessionDuck(long paramLong);
  
  @CalledByNative
  private boolean requestAudioFocus(boolean paramBoolean) {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private void tearDown() {
    assert false;
    throw new AssertionError();
  }
  
  public void onAudioFocusChange(int paramInt) {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\AudioFocusDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */