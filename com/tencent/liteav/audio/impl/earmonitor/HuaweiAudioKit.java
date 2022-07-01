package com.tencent.liteav.audio.impl.earmonitor;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKaraokeFeatureKit;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKit;
import com.huawei.multimedia.liteav.audiokit.interfaces.IAudioKitCallback;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.i;
import java.util.concurrent.TimeUnit;

public class HuaweiAudioKit implements IAudioKitCallback, TXSystemAudioKit, i.a {
  private static final int BACKGROUND_CHECK_INTERVAL = (int)TimeUnit.SECONDS.toMillis(1L);
  
  private static final String TAG = "HuaweiAudioKit";
  
  private a mAudioKitCallback;
  
  private i mBackgroundCheckTimer;
  
  private HwAudioKit mHwAudioKit;
  
  private boolean mIsAudioKitIniting = false;
  
  private boolean mIsBackgroundWhenLastCheck = false;
  
  private boolean mIsEarMonitoringEnabled = false;
  
  private HwAudioKaraokeFeatureKit mKaraokeKit;
  
  private final Handler mUiHandler = new Handler(Looper.getMainLooper());
  
  private void dealWithAudioKitResultInternal(int paramInt) {
    TXCLog.i("HuaweiAudioKit", "on audio kit callback: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      this.mIsAudioKitIniting = false;
      a a1 = this.mAudioKitCallback;
      if (a1 != null)
        a1.onAudioKitInitFinished(this, true); 
      if (this.mHwAudioKit.a(HwAudioKit.FeatureType.a)) {
        this.mKaraokeKit = (HwAudioKaraokeFeatureKit)this.mHwAudioKit.b(HwAudioKit.FeatureType.a);
        return;
      } 
      a1 = this.mAudioKitCallback;
      if (a1 != null) {
        a1.onEarMonitoringInitialized(this, false);
        return;
      } 
    } else if (paramInt == 1000) {
      a a1 = this.mAudioKitCallback;
      if (a1 != null) {
        a1.onEarMonitoringInitialized(this, true);
        return;
      } 
    } else if (paramInt != 1805) {
      a a1 = this.mAudioKitCallback;
      if (a1 != null) {
        if (this.mIsAudioKitIniting) {
          a1.onAudioKitInitFinished(this, false);
          this.mIsAudioKitIniting = false;
          return;
        } 
        a1.onAudioKitError(this);
      } 
    } 
  }
  
  private boolean isAppInBackground() {
    boolean bool = false;
    try {
      ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(runningAppProcessInfo);
      int j = runningAppProcessInfo.importance;
      if (j != 100)
        bool = true; 
      return bool;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private void setSystemEarMonitoringVolumeInternal(int paramInt) {
    TXCLog.i("HuaweiAudioKit", "setSystemEarMonitoringVolumeInternal: %d, kit: %s", new Object[] { Integer.valueOf(paramInt), this.mKaraokeKit });
    HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = this.mKaraokeKit;
    if (hwAudioKaraokeFeatureKit != null) {
      paramInt = hwAudioKaraokeFeatureKit.a(HwAudioKaraokeFeatureKit.ParameName.b, paramInt);
      if (paramInt == 1806 || paramInt == -2)
        dealWithAudioKitResultInternal(-2); 
    } 
  }
  
  private void startSystemEarMonitoringInternal() {
    TXCLog.i("HuaweiAudioKit", "startSystemEarMonitoring kit: %s", new Object[] { this.mKaraokeKit });
    HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = this.mKaraokeKit;
    if (hwAudioKaraokeFeatureKit == null)
      return; 
    int j = hwAudioKaraokeFeatureKit.a(true);
    if (j != 0 && j != 1805) {
      dealWithAudioKitResultInternal(1003);
      return;
    } 
    this.mIsEarMonitoringEnabled = true;
  }
  
  private void startTimer() {
    if (this.mBackgroundCheckTimer != null)
      return; 
    TXCLog.i("HuaweiAudioKit", "start background checking timer");
    this.mBackgroundCheckTimer = new i(Looper.getMainLooper(), this);
    this.mBackgroundCheckTimer.a(0, BACKGROUND_CHECK_INTERVAL);
  }
  
  private void stopSystemEarMonitoringInternal() {
    TXCLog.i("HuaweiAudioKit", "stopSystemEarMonitoring");
    HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = this.mKaraokeKit;
    if (hwAudioKaraokeFeatureKit != null) {
      hwAudioKaraokeFeatureKit.a(false);
      this.mIsEarMonitoringEnabled = false;
    } 
  }
  
  private void stopTimer() {
    if (this.mBackgroundCheckTimer != null) {
      TXCLog.i("HuaweiAudioKit", "stop background checking timer");
      this.mBackgroundCheckTimer.a();
      this.mBackgroundCheckTimer = null;
    } 
  }
  
  public void initialize(Context paramContext, a parama) {
    this.mUiHandler.post(new Runnable(this, parama, paramContext) {
          public void run() {
            if (this.c.mHwAudioKit != null) {
              TXCLog.e("HuaweiAudioKit", "it's already initialized.");
              return;
            } 
            TXCLog.i("HuaweiAudioKit", "start initialize audio kit");
            HuaweiAudioKit.access$102(this.c, true);
            HuaweiAudioKit.access$202(this.c, this.a);
            HuaweiAudioKit.access$002(this.c, new HwAudioKit(this.b.getApplicationContext(), this.c));
            this.c.mHwAudioKit.a();
          }
        });
  }
  
  public void onResult(int paramInt) {
    this.mUiHandler.post(new Runnable(this, paramInt) {
          public void run() {
            this.b.dealWithAudioKitResultInternal(this.a);
          }
        });
  }
  
  public void onTimeout() {
    boolean bool = isAppInBackground();
    if (this.mIsEarMonitoringEnabled && this.mIsBackgroundWhenLastCheck && !bool) {
      stopSystemEarMonitoringInternal();
      startSystemEarMonitoringInternal();
    } else if (bool && !this.mIsBackgroundWhenLastCheck) {
      TXCLog.i("HuaweiAudioKit", "app has gone to background.");
    } 
    this.mIsBackgroundWhenLastCheck = bool;
  }
  
  public void setSystemEarMonitoringVolume(int paramInt) {
    this.mUiHandler.post(new Runnable(this, paramInt) {
          public void run() {
            this.b.setSystemEarMonitoringVolumeInternal(this.a);
          }
        });
  }
  
  public void startSystemEarMonitoring() {
    this.mUiHandler.post(new Runnable(this) {
          public void run() {
            this.a.startTimer();
            this.a.startSystemEarMonitoringInternal();
          }
        });
  }
  
  public void stopSystemEarMonitoring() {
    this.mUiHandler.post(new Runnable(this) {
          public void run() {
            this.a.stopTimer();
            this.a.stopSystemEarMonitoringInternal();
          }
        });
  }
  
  public void uninitialize() {
    this.mUiHandler.post(new Runnable(this) {
          public void run() {
            TXCLog.i("HuaweiAudioKit", "uninitialize");
            if (this.a.mKaraokeKit != null) {
              this.a.mKaraokeKit.a();
              HuaweiAudioKit.access$302(this.a, null);
            } 
            if (this.a.mHwAudioKit != null) {
              this.a.mHwAudioKit.b();
              HuaweiAudioKit.access$002(this.a, null);
            } 
            HuaweiAudioKit.access$102(this.a, false);
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\tencent\liteav\audio\impl\earmonitor\HuaweiAudioKit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */