package org.chromium.device.vibration;

import android.content.Context;
import android.media.AudioManager;
import android.os.Vibrator;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.device.mojom.VibrationManager;
import org.chromium.mojo.system.MojoException;

public class VibrationManagerImpl implements VibrationManager {
  private static boolean sVibrateCancelledForTesting;
  
  private static long sVibrateMilliSecondsForTesting = -1L;
  
  private final AudioManager mAudioManager;
  
  private final boolean mHasVibratePermission;
  
  private final Vibrator mVibrator;
  
  static {
    sVibrateCancelledForTesting = false;
    throw new VerifyError("bad dex opcode");
  }
  
  public VibrationManagerImpl() {
    boolean bool;
    Context context = ContextUtils.sApplicationContext;
    this.mAudioManager = (AudioManager)context.getSystemService("audio");
    this.mVibrator = (Vibrator)context.getSystemService("vibrator");
    if (context.checkCallingOrSelfPermission("android.permission.VIBRATE") == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.mHasVibratePermission = bool;
    if (!this.mHasVibratePermission)
      Log.w("VibrationManagerImpl", "Failed to use vibrate API, requires VIBRATE permission.", new Object[0]); 
  }
  
  @CalledByNative
  static boolean getVibrateCancelledForTesting() {
    return sVibrateCancelledForTesting;
  }
  
  @CalledByNative
  static long getVibrateMilliSecondsForTesting() {
    return sVibrateMilliSecondsForTesting;
  }
  
  public final void cancel(VibrationManager.CancelResponse paramCancelResponse) {
    if (this.mHasVibratePermission)
      this.mVibrator.cancel(); 
    sVibrateCancelledForTesting = true;
    paramCancelResponse.call();
  }
  
  public void close() {}
  
  public final void onConnectionError(MojoException paramMojoException) {}
  
  public final void vibrate(long paramLong, VibrationManager.VibrateResponse paramVibrateResponse) {
    paramLong = Math.max(1L, Math.min(paramLong, 10000L));
    if (this.mAudioManager.getRingerMode() != 0 && this.mHasVibratePermission)
      this.mVibrator.vibrate(paramLong); 
    sVibrateMilliSecondsForTesting = paramLong;
    paramVibrateResponse.call();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\vibration\VibrationManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */