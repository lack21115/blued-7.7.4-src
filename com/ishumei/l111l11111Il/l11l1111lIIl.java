package com.ishumei.l111l11111Il;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import java.util.ArrayList;
import java.util.List;

public final class l11l1111lIIl {
  public static List<String> l1111l111111Il() {
    ArrayList<String> arrayList = new ArrayList();
    try {
      Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
      if (context != null)
        for (Sensor sensor : ((SensorManager)context.getSystemService("sensor")).getSensorList(-1)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(sensor.getType());
          stringBuilder.append(",");
          stringBuilder.append(sensor.getVendor());
          arrayList.add(stringBuilder.toString());
        }  
      return arrayList;
    } catch (Exception exception) {
      return arrayList;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l11l1111lIIl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */