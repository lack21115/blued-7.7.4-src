package cn.shuzilm.core;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

class c implements SensorEventListener {
  c(DUHelper paramDUHelper, Context paramContext, SensorManager paramSensorManager) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent) {
    try {
      float[] arrayOfFloat = paramSensorEvent.values;
      paramSensorEvent.sensor.getType();
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < arrayOfFloat.length; i++) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(arrayOfFloat[i]);
        stringBuilder1.append("");
        stringBuilder.append(stringBuilder1.toString());
        stringBuilder.append(" , ");
      } 
      DUHelper.a(this.a, paramSensorEvent);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      unsatisfiedLinkError.printStackTrace();
    } 
    this.b.unregisterListener(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */