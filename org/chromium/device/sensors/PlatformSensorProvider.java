package org.chromium.device.sensors;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashSet;
import java.util.Set;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;

class PlatformSensorProvider {
  final Set mActiveSensors = new HashSet();
  
  Handler mHandler;
  
  SensorManager mSensorManager;
  
  HandlerThread mSensorsThread;
  
  private PlatformSensorProvider(Context paramContext) {
    this.mSensorManager = (SensorManager)paramContext.getSystemService("sensor");
  }
  
  @CalledByNative
  protected static PlatformSensorProvider create() {
    return new PlatformSensorProvider(ContextUtils.sApplicationContext);
  }
  
  @CalledByNative
  protected PlatformSensor createSensor(int paramInt) {
    if (this.mSensorManager == null)
      return null; 
    if (paramInt != 1) {
      if (paramInt != 9) {
        if (paramInt != 11) {
          switch (paramInt) {
            default:
              return null;
            case 6:
              return PlatformSensor.create(2, 3, this);
            case 5:
              return PlatformSensor.create(4, 3, this);
            case 4:
              return PlatformSensor.create(10, 3, this);
            case 3:
              break;
          } 
          return PlatformSensor.create(1, 3, this);
        } 
        return PlatformSensor.create(15, 4, this);
      } 
      return PlatformSensor.create(11, 4, this);
    } 
    return PlatformSensor.create(5, 1, this);
  }
  
  @CalledByNative
  protected boolean hasSensorType(int paramInt) {
    if (this.mSensorManager == null)
      return false; 
    byte b = 11;
    if (paramInt != 1) {
      if (paramInt != 9) {
        if (paramInt != 11) {
          switch (paramInt) {
            default:
              return false;
            case 6:
              paramInt = 2;
              break;
            case 5:
              paramInt = 4;
              break;
            case 4:
              paramInt = 10;
              break;
            case 3:
              paramInt = 1;
              break;
          } 
        } else {
          paramInt = 15;
        } 
      } else {
        paramInt = b;
      } 
    } else {
      paramInt = 5;
    } 
    return !this.mSensorManager.getSensorList(paramInt).isEmpty();
  }
  
  @CalledByNative
  protected void setSensorManagerToNullForTesting() {
    this.mSensorManager = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\sensors\PlatformSensorProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */