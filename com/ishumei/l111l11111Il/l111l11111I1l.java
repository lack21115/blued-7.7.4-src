package com.ishumei.l111l11111Il;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ishumei.l111l11111lIl.l111l1111l1Il;
import java.util.HashMap;
import java.util.Map;

public final class l111l11111I1l {
  public static Map<String, Integer> l1111l111111Il() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Context context = l111l1111l1Il.l1111l111111Il;
    if (context == null)
      return (Map)hashMap; 
    try {
      Intent intent = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (intent == null)
        return (Map)hashMap; 
      int i = intent.getIntExtra("status", 0);
      int j = intent.getIntExtra("level", 0);
      int k = intent.getIntExtra("scale", 100);
      int m = intent.getIntExtra("temperature", 0);
      int n = intent.getIntExtra("voltage", 0);
      hashMap.put("status", Integer.valueOf(i));
      hashMap.put("level", Integer.valueOf(j));
      hashMap.put("scale", Integer.valueOf(k));
      hashMap.put("temp", Integer.valueOf(m));
      hashMap.put("vol", Integer.valueOf(n));
      return (Map)hashMap;
    } catch (Exception exception) {
      return (Map)hashMap;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l111l11111I1l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */