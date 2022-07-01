package org.chromium.device.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.List;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

public class PlatformSensor implements SensorEventListener {
  private double mCurrentPollingFrequency;
  
  private final int mMinDelayUsec;
  
  private long mNativePlatformSensorAndroid;
  
  private final PlatformSensorProvider mProvider;
  
  private final int mReadingCount;
  
  private final Sensor mSensor;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private PlatformSensor(Sensor paramSensor, int paramInt, PlatformSensorProvider paramPlatformSensorProvider) {
    this.mReadingCount = paramInt;
    this.mProvider = paramPlatformSensorProvider;
    this.mSensor = paramSensor;
    this.mMinDelayUsec = this.mSensor.getMinDelay();
  }
  
  public static PlatformSensor create(int paramInt1, int paramInt2, PlatformSensorProvider paramPlatformSensorProvider) {
    List<Sensor> list = paramPlatformSensorProvider.mSensorManager.getSensorList(paramInt1);
    return list.isEmpty() ? null : new PlatformSensor(list.get(0), paramInt2, paramPlatformSensorProvider);
  }
  
  private static int getSamplingPeriod(double paramDouble) {
    return (int)(1.0D / paramDouble * 1000000.0D);
  }
  
  private native void nativeNotifyPlatformSensorError(long paramLong);
  
  private native void nativeUpdatePlatformSensorReading(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5);
  
  private void unregisterListener() {
    if (this.mCurrentPollingFrequency == 0.0D)
      return; 
    this.mProvider.mSensorManager.unregisterListener(this, this.mSensor);
  }
  
  private void updateSensorReading(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5) {
    nativeUpdatePlatformSensorReading(this.mNativePlatformSensorAndroid, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5);
  }
  
  @CalledByNative
  protected boolean checkSensorConfiguration(double paramDouble) {
    return (this.mMinDelayUsec <= getSamplingPeriod(paramDouble));
  }
  
  @CalledByNative
  protected double getDefaultConfiguration() {
    return 5.0D;
  }
  
  @CalledByNative
  protected double getMaximumSupportedFrequency() {
    return (this.mMinDelayUsec == 0) ? getDefaultConfiguration() : (1.0D / this.mMinDelayUsec * 1.0E-6D);
  }
  
  @CalledByNative
  protected int getReportingMode() {
    return (Build.VERSION.SDK_INT >= 21) ? ((this.mSensor.getReportingMode() == 0) ? 1 : 0) : 1;
  }
  
  @CalledByNative
  protected void initPlatformSensorAndroid(long paramLong) {
    assert false;
    throw new AssertionError();
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent) {
    if (this.mNativePlatformSensorAndroid == 0L) {
      Log.w("PlatformSensor", "Should not get sensor events after PlatformSensorAndroid is destroyed.", new Object[0]);
      return;
    } 
    if (paramSensorEvent.values.length < this.mReadingCount) {
      nativeNotifyPlatformSensorError(this.mNativePlatformSensorAndroid);
      stopSensor();
      return;
    } 
    double d = paramSensorEvent.timestamp * 1.0E-9D;
    switch (paramSensorEvent.values.length) {
      default:
        updateSensorReading(d, paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2], paramSensorEvent.values[3]);
        return;
      case 3:
        updateSensorReading(d, paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2], 0.0D);
        return;
      case 2:
        updateSensorReading(d, paramSensorEvent.values[0], paramSensorEvent.values[1], 0.0D, 0.0D);
        return;
      case 1:
        break;
    } 
    updateSensorReading(d, paramSensorEvent.values[0], 0.0D, 0.0D, 0.0D);
  }
  
  @CalledByNative
  protected void sensorDestroyed() {
    stopSensor();
    this.mNativePlatformSensorAndroid = 0L;
  }
  
  @CalledByNative
  protected boolean startSensor(double paramDouble) {
    if (this.mCurrentPollingFrequency == paramDouble)
      return true; 
    unregisterListener();
    null = this.mProvider;
    synchronized (null.mActiveSensors) {
      if (null.mActiveSensors.isEmpty() && null.mSensorsThread == null) {
        null.mSensorsThread = new HandlerThread("SensorsHandlerThread");
        null.mSensorsThread.start();
        null.mHandler = new Handler(null.mSensorsThread.getLooper());
      } 
      null.mActiveSensors.add(this);
      boolean bool = this.mProvider.mSensorManager.registerListener(this, this.mSensor, getSamplingPeriod(paramDouble), this.mProvider.mHandler);
      if (!bool) {
        stopSensor();
        return bool;
      } 
      this.mCurrentPollingFrequency = paramDouble;
      return bool;
    } 
  }
  
  @CalledByNative
  protected void stopSensor() {
    unregisterListener();
    null = this.mProvider;
    synchronized (null.mActiveSensors) {
      null.mActiveSensors.remove(this);
      if (null.mActiveSensors.isEmpty() && null.mSensorsThread != null) {
        if (Build.VERSION.SDK_INT >= 18) {
          null.mSensorsThread.quitSafely();
        } else {
          null.mSensorsThread.quit();
        } 
        null.mSensorsThread = null;
        null.mHandler = null;
      } 
      this.mCurrentPollingFrequency = 0.0D;
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\sensors\PlatformSensor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */