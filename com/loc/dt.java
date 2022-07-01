package com.loc;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

public final class dt implements SensorEventListener {
  SensorManager a = null;
  
  Sensor b = null;
  
  Sensor c = null;
  
  Sensor d = null;
  
  public boolean e = false;
  
  public double f = 0.0D;
  
  public float g = 0.0F;
  
  Handler h = new Handler();
  
  double i = 0.0D;
  
  double j = 0.0D;
  
  double k = 0.0D;
  
  double l = 0.0D;
  
  double[] m = new double[3];
  
  volatile double n = 0.0D;
  
  long o = 0L;
  
  long p = 0L;
  
  final int q = 100;
  
  final int r = 30;
  
  private Context s = null;
  
  private float t = 1013.25F;
  
  private float u = 0.0F;
  
  public dt(Context paramContext) {
    try {
      this.s = paramContext;
      if (this.a == null)
        this.a = (SensorManager)this.s.getSystemService("sensor"); 
    } finally {
      paramContext = null;
      ej.a((Throwable)paramContext, "AMapSensorManager", "<init>");
    } 
  }
  
  public final void a() {
    SensorManager sensorManager = this.a;
    if (sensorManager != null && !this.e) {
      this.e = true;
      try {
        if (this.b != null)
          sensorManager.registerListener(this, this.b, 3, this.h); 
      } finally {
        sensorManager = null;
      } 
    } 
  }
  
  public final void b() {
    SensorManager sensorManager = this.a;
    if (sensorManager != null && this.e) {
      this.e = false;
      try {
        if (this.b != null)
          sensorManager.unregisterListener(this, this.b); 
      } finally {}
      try {
        if (this.c != null)
          this.a.unregisterListener(this, this.c); 
      } finally {
        sensorManager = null;
      } 
    } 
  }
  
  public final float c() {
    return this.u;
  }
  
  public final double d() {
    return this.l;
  }
  
  public final void e() {
    try {
      b();
      this.b = null;
      this.c = null;
      this.a = null;
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "AMapSensorManager", "destroy");
    } 
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent) {
    float f;
    if (paramSensorEvent == null)
      return; 
    try {
      int i = paramSensorEvent.sensor.getType();
    } finally {
      paramSensorEvent = null;
    } 
    double d = f;
    this.u = (float)Math.floor(d);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */