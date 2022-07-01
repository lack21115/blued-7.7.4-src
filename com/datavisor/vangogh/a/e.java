package com.datavisor.vangogh.a;

import android.content.Context;
import android.hardware.SensorManager;
import com.datavisor.vangogh.b.c;
import com.datavisor.vangogh.bridge.crypto;
import com.datavisor.vangogh.d.b;
import com.datavisor.vangogh.f.d;
import com.datavisor.vangogh.f.f;
import com.datavisor.vangogh.f.h.a;
import org.json.JSONArray;
import org.json.JSONObject;

public class e {
  private static e a;
  
  private Context b = null;
  
  private e(Context paramContext) {
    if (paramContext != null) {
      this.b = paramContext;
      return;
    } 
    throw new IllegalArgumentException("SimulatorDetect initialization error: mContext is null.");
  }
  
  public static e a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/datavisor/vangogh/a/e.a : Lcom/datavisor/vangogh/a/e;
    //   3: ifnonnull -> 38
    //   6: ldc com/datavisor/vangogh/a/d
    //   8: monitorenter
    //   9: getstatic com/datavisor/vangogh/a/e.a : Lcom/datavisor/vangogh/a/e;
    //   12: ifnonnull -> 26
    //   15: new com/datavisor/vangogh/a/e
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/datavisor/vangogh/a/e.a : Lcom/datavisor/vangogh/a/e;
    //   26: ldc com/datavisor/vangogh/a/d
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/datavisor/vangogh/a/d
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/datavisor/vangogh/a/e.a : Lcom/datavisor/vangogh/a/e;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void a(JSONArray paramJSONArray, JSONObject paramJSONObject) {
    try {
      int i;
      JSONObject jSONObject = new JSONObject();
    } finally {
      paramJSONArray = null;
    } 
  }
  
  private void a(JSONObject paramJSONObject) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Landroid/content/Context;
    //   4: ldc 'android.permission.BLUETOOTH'
    //   6: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   9: istore_2
    //   10: iload_2
    //   11: ifeq -> 28
    //   14: getstatic com/datavisor/vangogh/b/b.a : Ljava/lang/String;
    //   17: ldc 'no permission BLUETOOTH'
    //   19: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc 'no_permission'
    //   24: astore_3
    //   25: goto -> 80
    //   28: aload_0
    //   29: getfield b : Landroid/content/Context;
    //   32: ifnonnull -> 49
    //   35: getstatic com/datavisor/vangogh/b/b.a : Ljava/lang/String;
    //   38: ldc 'context is null'
    //   40: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   43: ldc 'para_err'
    //   45: astore_3
    //   46: goto -> 80
    //   49: invokestatic getDefaultAdapter : ()Landroid/bluetooth/BluetoothAdapter;
    //   52: astore_3
    //   53: aload_3
    //   54: ifnonnull -> 60
    //   57: goto -> 141
    //   60: aload_3
    //   61: invokevirtual getName : ()Ljava/lang/String;
    //   64: astore #4
    //   66: aload #4
    //   68: astore_3
    //   69: aload #4
    //   71: invokestatic a : (Ljava/lang/String;)Z
    //   74: ifeq -> 80
    //   77: goto -> 141
    //   80: aload_3
    //   81: astore #4
    //   83: aload_3
    //   84: ldc 'no_permission'
    //   86: invokevirtual equals : (Ljava/lang/Object;)Z
    //   89: ifne -> 126
    //   92: aload_3
    //   93: astore #4
    //   95: aload_3
    //   96: ldc 'para_err'
    //   98: invokevirtual equals : (Ljava/lang/Object;)Z
    //   101: ifne -> 126
    //   104: aload_3
    //   105: astore #4
    //   107: aload_3
    //   108: ldc 'empty'
    //   110: invokevirtual equals : (Ljava/lang/Object;)Z
    //   113: ifne -> 126
    //   116: aload_3
    //   117: invokevirtual getBytes : ()[B
    //   120: iconst_2
    //   121: invokestatic encodeToString : ([BI)Ljava/lang/String;
    //   124: astore #4
    //   126: aload_1
    //   127: ldc 'OYqQyHXZ'
    //   129: invokestatic convert : (Ljava/lang/String;)Ljava/lang/String;
    //   132: aload #4
    //   134: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   137: pop
    //   138: return
    //   139: astore_1
    //   140: return
    //   141: ldc 'empty'
    //   143: astore_3
    //   144: goto -> 80
    // Exception table:
    //   from	to	target	type
    //   0	10	139	finally
    //   14	22	139	finally
    //   28	43	139	finally
    //   49	53	139	finally
    //   60	66	139	finally
    //   69	77	139	finally
    //   83	92	139	finally
    //   95	104	139	finally
    //   107	126	139	finally
    //   126	138	139	finally
  }
  
  private void b(JSONArray paramJSONArray, JSONObject paramJSONObject) {
    try {
      int i;
      JSONArray jSONArray = new JSONArray();
    } finally {
      paramJSONArray = null;
    } 
  }
  
  private void b(JSONObject paramJSONObject) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Landroid/content/Context;
    //   4: ldc 'sensor'
    //   6: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   9: checkcast android/hardware/SensorManager
    //   12: iconst_5
    //   13: invokevirtual getDefaultSensor : (I)Landroid/hardware/Sensor;
    //   16: astore_3
    //   17: aload_3
    //   18: ifnonnull -> 26
    //   21: iconst_0
    //   22: istore_2
    //   23: goto -> 28
    //   26: iconst_1
    //   27: istore_2
    //   28: aload_1
    //   29: ldc 'N5eZwWzPos4cX4Y='
    //   31: invokestatic convert : (Ljava/lang/String;)Ljava/lang/String;
    //   34: iload_2
    //   35: invokevirtual put : (Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   38: pop
    //   39: return
    //   40: astore_3
    //   41: goto -> 26
    //   44: astore_1
    //   45: return
    // Exception table:
    //   from	to	target	type
    //   0	17	40	finally
    //   28	39	44	finally
  }
  
  private void c(JSONArray paramJSONArray, JSONObject paramJSONObject) {
    try {
      int i;
      String str = a.b("/proc/cpuinfo");
      if (f.a(str))
        return; 
      JSONArray jSONArray = new JSONArray();
    } finally {
      paramJSONArray = null;
    } 
  }
  
  private void c(JSONObject paramJSONObject) {
    boolean bool = this.b.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    try {
      return;
    } finally {
      paramJSONObject = null;
    } 
  }
  
  private void d(JSONArray paramJSONArray, JSONObject paramJSONObject) {
    try {
      int i;
      JSONObject jSONObject = new JSONObject();
    } finally {
      paramJSONArray = null;
    } 
  }
  
  private void d(JSONObject paramJSONObject) {
    try {
      int i = ((SensorManager)this.b.getSystemService("sensor")).getSensorList(-1).size();
      return;
    } finally {
      paramJSONObject = null;
    } 
  }
  
  private void e(JSONArray paramJSONArray, JSONObject paramJSONObject) {
    try {
      int i;
      JSONObject jSONObject = new JSONObject();
    } finally {
      paramJSONArray = null;
    } 
  }
  
  private void e(JSONObject paramJSONObject) {
    try {
      return;
    } finally {
      paramJSONObject = null;
    } 
  }
  
  private void f(JSONObject paramJSONObject) {
    try {
      return;
    } finally {
      paramJSONObject = null;
    } 
  }
  
  private void g(JSONObject paramJSONObject) {
    try {
      String str = c.a().g(this.b);
      boolean bool = f.a(str);
      return;
    } finally {
      paramJSONObject = null;
      d.a((Throwable)paramJSONObject);
    } 
  }
  
  public String a() {
    JSONObject jSONObject2 = b.a(this.b).c(crypto.convert("KJeT3HTds88d"));
    if (jSONObject2 == null)
      return "empty"; 
    JSONObject jSONObject1 = new JSONObject();
    try {
      JSONArray jSONArray = jSONObject2.getJSONArray(crypto.convert("K4yR2Ws="));
      if (jSONArray != null && jSONArray.length() > 0)
        a(jSONArray, jSONObject1); 
    } finally {
      Exception exception;
    } 
    try {
      JSONArray jSONArray = jSONObject2.getJSONArray(crypto.convert("PZeSzH3ErtMb"));
      if (jSONArray != null && jSONArray.length() > 0)
        b(jSONArray, jSONObject1); 
    } finally {
      Exception exception;
    } 
    try {
      JSONArray jSONArray = jSONObject2.getJSONArray(crypto.convert("OI6L"));
      if (jSONArray != null && jSONArray.length() > 0)
        c(jSONArray, jSONObject1); 
    } finally {
      Exception exception;
    } 
    try {
      JSONArray jSONArray = jSONObject2.getJSONArray(crypto.convert("OJOa"));
      if (jSONArray != null && jSONArray.length() > 0)
        d(jSONArray, jSONObject1); 
    } finally {
      Exception exception;
    } 
    try {
      JSONArray jSONArray = jSONObject2.getJSONArray(crypto.convert("PZeSzGs="));
      if (jSONArray != null && jSONArray.length() > 0)
        e(jSONArray, jSONObject1); 
    } finally {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */