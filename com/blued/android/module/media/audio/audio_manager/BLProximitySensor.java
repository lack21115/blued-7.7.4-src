package com.blued.android.module.media.audio.audio_manager;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.Log;

public class BLProximitySensor implements SensorEventListener {
  private final ThreadUtils.ThreadChecker a = new ThreadUtils.ThreadChecker();
  
  private final Runnable b;
  
  private final SensorManager c;
  
  private Sensor d;
  
  private boolean e;
  
  private BLProximitySensor(Context paramContext, Runnable paramRunnable) {
    Log.d("BLProximitySensor", "BLProximitySensor");
    this.b = paramRunnable;
    this.c = (SensorManager)paramContext.getSystemService("sensor");
  }
  
  public static BLProximitySensor a(Context paramContext, Runnable paramRunnable) {
    return new BLProximitySensor(paramContext, paramRunnable);
  }
  
  private boolean d() {
    if (this.d != null)
      return true; 
    this.d = this.c.getDefaultSensor(8);
    if (this.d == null)
      return false; 
    e();
    return true;
  }
  
  private void e() {
    if (this.d == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder("Proximity sensor: ");
    stringBuilder.append("name=");
    stringBuilder.append(this.d.getName());
    stringBuilder.append(", vendor: ");
    stringBuilder.append(this.d.getVendor());
    stringBuilder.append(", power: ");
    stringBuilder.append(this.d.getPower());
    stringBuilder.append(", resolution: ");
    stringBuilder.append(this.d.getResolution());
    stringBuilder.append(", max range: ");
    stringBuilder.append(this.d.getMaximumRange());
    stringBuilder.append(", min delay: ");
    stringBuilder.append(this.d.getMinDelay());
    if (Build.VERSION.SDK_INT >= 20) {
      stringBuilder.append(", type: ");
      stringBuilder.append(this.d.getStringType());
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      stringBuilder.append(", max delay: ");
      stringBuilder.append(this.d.getMaxDelay());
      stringBuilder.append(", reporting mode: ");
      stringBuilder.append(this.d.getReportingMode());
      stringBuilder.append(", isWakeUpSensor: ");
      stringBuilder.append(this.d.isWakeUpSensor());
    } 
    Log.d("BLProximitySensor", stringBuilder.toString());
  }
  
  public boolean a() {
    this.a.a();
    Log.d("BLProximitySensor", "start");
    if (!d())
      return false; 
    this.c.registerListener(this, this.d, 3);
    return true;
  }
  
  public void b() {
    this.a.a();
    Log.d("BLProximitySensor", "stop");
    Sensor sensor = this.d;
    if (sensor == null)
      return; 
    this.c.unregisterListener(this, sensor);
  }
  
  public boolean c() {
    this.a.a();
    return this.e;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {
    boolean bool;
    this.a.a();
    if (paramSensor.getType() == 8) {
      bool = true;
    } else {
      bool = false;
    } 
    BLUtils.a(bool);
    if (paramInt == 0)
      Log.e("BLProximitySensor", "The values returned by this sensor cannot be trusted"); 
  }
  
  public final void onSensorChanged(SensorEvent paramSensorEvent) {
    boolean bool;
    this.a.a();
    if (paramSensorEvent.sensor.getType() == 8) {
      bool = true;
    } else {
      bool = false;
    } 
    BLUtils.a(bool);
    if (paramSensorEvent.values[0] < this.d.getMaximumRange()) {
      Log.d("BLProximitySensor", "Proximity sensor => NEAR state");
      this.e = true;
    } else {
      Log.d("BLProximitySensor", "Proximity sensor => FAR state");
      this.e = false;
    } 
    Runnable runnable = this.b;
    if (runnable != null)
      runnable.run(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onSensorChanged");
    stringBuilder.append(BLUtils.a());
    stringBuilder.append(": accuracy=");
    stringBuilder.append(paramSensorEvent.accuracy);
    stringBuilder.append(", timestamp=");
    stringBuilder.append(paramSensorEvent.timestamp);
    stringBuilder.append(", distance=");
    stringBuilder.append(paramSensorEvent.values[0]);
    Log.d("BLProximitySensor", stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\audio\audio_manager\BLProximitySensor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */