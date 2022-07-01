package com.blued.android.module.external_sense_library.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

public class Accelerometer {
  private static SensorEvent b;
  
  private static CLOCKWISE_ANGLE d;
  
  private SensorManager a = null;
  
  private boolean c = false;
  
  private SensorEventListener e = new SensorEventListener(this) {
      public void onAccuracyChanged(Sensor param1Sensor, int param1Int) {}
      
      public void onSensorChanged(SensorEvent param1SensorEvent) {
        Accelerometer.a(param1SensorEvent);
        if (param1SensorEvent.sensor.getType() == 1) {
          float f1 = param1SensorEvent.values[0];
          float f2 = param1SensorEvent.values[1];
          float f3 = param1SensorEvent.values[2];
          if (Math.abs(f1) > 3.0F || Math.abs(f2) > 3.0F) {
            if (Math.abs(f1) > Math.abs(f2)) {
              if (f1 > 0.0F) {
                Accelerometer.a(Accelerometer.CLOCKWISE_ANGLE.a);
                Log.i("ROTATION", "CLOCKWISE_ANGLE: Deg0");
                return;
              } 
              Accelerometer.a(Accelerometer.CLOCKWISE_ANGLE.c);
              Log.i("ROTATION", "CLOCKWISE_ANGLE: Deg180");
              return;
            } 
            if (f2 > 0.0F) {
              Accelerometer.a(Accelerometer.CLOCKWISE_ANGLE.b);
              Log.i("ROTATION", "CLOCKWISE_ANGLE: Deg90");
              return;
            } 
            Accelerometer.a(Accelerometer.CLOCKWISE_ANGLE.d);
            Log.i("ROTATION", "CLOCKWISE_ANGLE: Deg270");
          } 
        } 
      }
    };
  
  public Accelerometer(Context paramContext) {
    this.a = (SensorManager)paramContext.getSystemService("sensor");
    d = CLOCKWISE_ANGLE.b;
  }
  
  public static int c() {
    return d.a();
  }
  
  public void a() {
    if (this.c)
      return; 
    this.c = true;
    d = CLOCKWISE_ANGLE.b;
    SensorManager sensorManager = this.a;
    sensorManager.registerListener(this.e, sensorManager.getDefaultSensor(1), 3);
  }
  
  public void b() {
    if (!this.c)
      return; 
    this.c = false;
    this.a.unregisterListener(this.e);
  }
  
  public enum CLOCKWISE_ANGLE {
    a(0),
    b(1),
    c(2),
    d(3);
    
    private int e;
    
    CLOCKWISE_ANGLE(int param1Int1) {
      this.e = param1Int1;
    }
    
    public int a() {
      return this.e;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_librar\\utils\Accelerometer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */