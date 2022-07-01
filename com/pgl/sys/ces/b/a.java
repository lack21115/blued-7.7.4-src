package com.pgl.sys.ces.b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.text.DecimalFormat;

public final class a implements SensorEventListener {
  private static a f;
  
  private SensorManager a = null;
  
  private int b;
  
  private int c = 0;
  
  private float[] d = new float[3];
  
  private DecimalFormat e = new DecimalFormat("0.0");
  
  private a(Context paramContext) {
    paramContext = paramContext.getApplicationContext();
    if (paramContext != null)
      this.a = (SensorManager)paramContext.getSystemService("sensor"); 
  }
  
  public static a a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/pgl/sys/ces/b/a.f : Lcom/pgl/sys/ces/b/a;
    //   3: ifnonnull -> 38
    //   6: ldc com/pgl/sys/ces/b/a
    //   8: monitorenter
    //   9: getstatic com/pgl/sys/ces/b/a.f : Lcom/pgl/sys/ces/b/a;
    //   12: ifnonnull -> 26
    //   15: new com/pgl/sys/ces/b/a
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/pgl/sys/ces/b/a.f : Lcom/pgl/sys/ces/b/a;
    //   26: ldc com/pgl/sys/ces/b/a
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/pgl/sys/ces/b/a
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/pgl/sys/ces/b/a.f : Lcom/pgl/sys/ces/b/a;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/SensorManager;
    //   6: ifnull -> 61
    //   9: aload_0
    //   10: getfield b : I
    //   13: ifne -> 43
    //   16: aload_0
    //   17: getfield a : Landroid/hardware/SensorManager;
    //   20: iconst_1
    //   21: invokevirtual getDefaultSensor : (I)Landroid/hardware/Sensor;
    //   24: astore_2
    //   25: aload_0
    //   26: getfield a : Landroid/hardware/SensorManager;
    //   29: aload_0
    //   30: aload_2
    //   31: iconst_3
    //   32: invokevirtual registerListener : (Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
    //   35: istore_1
    //   36: iload_1
    //   37: ifne -> 43
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: aload_0
    //   44: aload_0
    //   45: getfield b : I
    //   48: iconst_1
    //   49: iadd
    //   50: putfield b : I
    //   53: goto -> 61
    //   56: astore_2
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_2
    //   60: athrow
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: astore_2
    //   65: goto -> 61
    // Exception table:
    //   from	to	target	type
    //   2	36	64	java/lang/Exception
    //   2	36	56	finally
    //   43	53	64	java/lang/Exception
    //   43	53	56	finally
  }
  
  private void c() {
    /* monitor enter ThisExpression{ObjectType{com/pgl/sys/ces/b/a}} */
    try {
      if (this.a != null) {
        this.b--;
        if (this.b == 0)
          this.a.unregisterListener(this); 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } finally {
      Exception exception;
    } 
    /* monitor exit ThisExpression{ObjectType{com/pgl/sys/ces/b/a}} */
  }
  
  public String a() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial b : ()V
    //   4: aload_0
    //   5: monitorenter
    //   6: iconst_0
    //   7: istore_2
    //   8: aload_0
    //   9: getfield c : I
    //   12: ifne -> 35
    //   15: iload_2
    //   16: bipush #10
    //   18: if_icmpge -> 35
    //   21: iload_2
    //   22: iconst_1
    //   23: iadd
    //   24: istore_2
    //   25: aload_0
    //   26: ldc2_w 100
    //   29: invokevirtual wait : (J)V
    //   32: goto -> 8
    //   35: aload_0
    //   36: monitorexit
    //   37: new java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial <init> : ()V
    //   44: astore #4
    //   46: aload #4
    //   48: aload_0
    //   49: getfield e : Ljava/text/DecimalFormat;
    //   52: aload_0
    //   53: getfield d : [F
    //   56: iconst_0
    //   57: faload
    //   58: f2d
    //   59: invokevirtual format : (D)Ljava/lang/String;
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #4
    //   68: ldc ', '
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload #4
    //   76: aload_0
    //   77: getfield e : Ljava/text/DecimalFormat;
    //   80: aload_0
    //   81: getfield d : [F
    //   84: iconst_1
    //   85: faload
    //   86: f2d
    //   87: invokevirtual format : (D)Ljava/lang/String;
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload #4
    //   96: ldc ', '
    //   98: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_0
    //   103: getfield e : Ljava/text/DecimalFormat;
    //   106: astore_3
    //   107: aload_0
    //   108: getfield d : [F
    //   111: iconst_2
    //   112: faload
    //   113: fstore_1
    //   114: goto -> 208
    //   117: astore_3
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_3
    //   121: athrow
    //   122: astore_3
    //   123: goto -> 237
    //   126: astore_3
    //   127: aload_3
    //   128: invokevirtual printStackTrace : ()V
    //   131: new java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial <init> : ()V
    //   138: astore #4
    //   140: aload #4
    //   142: aload_0
    //   143: getfield e : Ljava/text/DecimalFormat;
    //   146: aload_0
    //   147: getfield d : [F
    //   150: iconst_0
    //   151: faload
    //   152: f2d
    //   153: invokevirtual format : (D)Ljava/lang/String;
    //   156: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload #4
    //   162: ldc ', '
    //   164: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload #4
    //   170: aload_0
    //   171: getfield e : Ljava/text/DecimalFormat;
    //   174: aload_0
    //   175: getfield d : [F
    //   178: iconst_1
    //   179: faload
    //   180: f2d
    //   181: invokevirtual format : (D)Ljava/lang/String;
    //   184: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload #4
    //   190: ldc ', '
    //   192: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload_0
    //   197: getfield e : Ljava/text/DecimalFormat;
    //   200: astore_3
    //   201: aload_0
    //   202: getfield d : [F
    //   205: iconst_2
    //   206: faload
    //   207: fstore_1
    //   208: aload #4
    //   210: aload_3
    //   211: fload_1
    //   212: f2d
    //   213: invokevirtual format : (D)Ljava/lang/String;
    //   216: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload #4
    //   222: invokevirtual toString : ()Ljava/lang/String;
    //   225: astore_3
    //   226: aload_0
    //   227: invokespecial c : ()V
    //   230: aload_0
    //   231: iconst_0
    //   232: putfield c : I
    //   235: aload_3
    //   236: areturn
    //   237: new java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial <init> : ()V
    //   244: astore #4
    //   246: aload #4
    //   248: aload_0
    //   249: getfield e : Ljava/text/DecimalFormat;
    //   252: aload_0
    //   253: getfield d : [F
    //   256: iconst_0
    //   257: faload
    //   258: f2d
    //   259: invokevirtual format : (D)Ljava/lang/String;
    //   262: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload #4
    //   268: ldc ', '
    //   270: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload #4
    //   276: aload_0
    //   277: getfield e : Ljava/text/DecimalFormat;
    //   280: aload_0
    //   281: getfield d : [F
    //   284: iconst_1
    //   285: faload
    //   286: f2d
    //   287: invokevirtual format : (D)Ljava/lang/String;
    //   290: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload #4
    //   296: ldc ', '
    //   298: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload #4
    //   304: aload_0
    //   305: getfield e : Ljava/text/DecimalFormat;
    //   308: aload_0
    //   309: getfield d : [F
    //   312: iconst_2
    //   313: faload
    //   314: f2d
    //   315: invokevirtual format : (D)Ljava/lang/String;
    //   318: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload #4
    //   324: invokevirtual toString : ()Ljava/lang/String;
    //   327: pop
    //   328: aload_0
    //   329: invokespecial c : ()V
    //   332: aload_0
    //   333: iconst_0
    //   334: putfield c : I
    //   337: aload_3
    //   338: athrow
    // Exception table:
    //   from	to	target	type
    //   4	6	126	java/lang/Exception
    //   4	6	122	finally
    //   8	15	117	finally
    //   25	32	117	finally
    //   35	37	117	finally
    //   118	120	117	finally
    //   120	122	126	java/lang/Exception
    //   120	122	122	finally
    //   127	131	122	finally
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent) {
    this.d = paramSensorEvent.values;
    this.c = 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\sys\ces\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */