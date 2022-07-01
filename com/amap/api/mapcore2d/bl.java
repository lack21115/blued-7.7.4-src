package com.amap.api.mapcore2d;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.amap.api.maps2d.model.Marker;

public class bl implements SensorEventListener {
  private SensorManager a;
  
  private Sensor b;
  
  private long c = 0L;
  
  private final int d = 100;
  
  private float e;
  
  private Context f;
  
  private y g;
  
  private Marker h;
  
  private boolean i = true;
  
  public bl(Context paramContext, y paramy) {
    this.f = paramContext.getApplicationContext();
    this.g = paramy;
    try {
      return;
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  public static int a(Context paramContext) {
    int i = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRotation();
    return (i != 0) ? ((i != 1) ? ((i != 2) ? ((i != 3) ? 0 : -90) : 180) : 90) : 0;
  }
  
  public void a() {
    SensorManager sensorManager = this.a;
    if (sensorManager != null) {
      Sensor sensor = this.b;
      if (sensor != null)
        sensorManager.registerListener(this, sensor, 3); 
    } 
  }
  
  public void a(Marker paramMarker) {
    this.h = paramMarker;
  }
  
  public void a(boolean paramBoolean) {
    this.i = paramBoolean;
  }
  
  public void b() {
    SensorManager sensorManager = this.a;
    if (sensorManager != null) {
      Sensor sensor = this.b;
      if (sensor != null)
        sensorManager.unregisterListener(this, sensor); 
    } 
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent) {
    try {
      float f1;
      if (System.currentTimeMillis() - this.c < 100L)
        return; 
      if (paramSensorEvent.sensor.getType() != 3)
        return; 
      float f2 = (paramSensorEvent.values[0] + a(this.f)) % 360.0F;
      if (f2 > 180.0F) {
        f1 = f2 - 360.0F;
      } else {
        f1 = f2;
        if (f2 < -180.0F)
          f1 = f2 + 360.0F; 
      } 
      if (Math.abs(this.e - f1) < 3.0F)
        return; 
      f2 = f1;
      if (Float.isNaN(f1))
        f2 = 0.0F; 
      this.e = f2;
      Marker marker = this.h;
      return;
    } finally {
      paramSensorEvent = null;
      paramSensorEvent.printStackTrace();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */