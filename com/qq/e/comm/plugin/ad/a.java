package com.qq.e.comm.plugin.ad;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.au;
import com.qq.e.comm.plugin.y.u;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class a {
  private static volatile a a;
  
  private final Map<Integer, Pair<Float, Float>> b = new ConcurrentHashMap<Integer, Pair<Float, Float>>();
  
  private final Map<Integer, Pair<Integer, Integer>> c = new ConcurrentHashMap<Integer, Pair<Integer, Integer>>();
  
  private final Map<Integer, Pair<Integer, Integer>> d = new ConcurrentHashMap<Integer, Pair<Integer, Integer>>();
  
  private final Map<Integer, Pair<Float, Integer>> e = new ConcurrentHashMap<Integer, Pair<Float, Integer>>();
  
  private volatile a f = null;
  
  private Set<Integer> g = Collections.newSetFromMap(new ConcurrentHashMap<Integer, Boolean>());
  
  private View.OnAttachStateChangeListener h;
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/qq/e/comm/plugin/ad/a.a : Lcom/qq/e/comm/plugin/ad/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/qq/e/comm/plugin/ad/a
    //   8: monitorenter
    //   9: getstatic com/qq/e/comm/plugin/ad/a.a : Lcom/qq/e/comm/plugin/ad/a;
    //   12: ifnonnull -> 25
    //   15: new com/qq/e/comm/plugin/ad/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/qq/e/comm/plugin/ad/a.a : Lcom/qq/e/comm/plugin/ad/a;
    //   25: ldc com/qq/e/comm/plugin/ad/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/qq/e/comm/plugin/ad/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/qq/e/comm/plugin/ad/a.a : Lcom/qq/e/comm/plugin/ad/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void c() {
    if (this.c.size() > 100000) {
      this.c.clear();
      u.a(100012, 4, null);
    } 
    if (this.d.size() > 100000) {
      this.d.clear();
      u.a(100012, 3, null);
    } 
  }
  
  private void c(View paramView) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public Pair<Float, Float> a(int paramInt) {
    return this.b.get(Integer.valueOf(paramInt));
  }
  
  public void a(View paramView) {
    if (paramView != null && au.c()) {
      if (this.f == null)
        this.f = new a(paramView.getContext().getApplicationContext()); 
      int i = b(paramView);
      if (!this.g.contains(Integer.valueOf(i))) {
        ak.b("gdt_tag_p", "ADMonitor.onExposured : %s", new Object[] { paramView });
        if (this.h == null)
          this.h = new View.OnAttachStateChangeListener(this) {
              public void onViewAttachedToWindow(View param1View) {
                ak.b("gdt_tag_p", "ADMonitor.onViewAttachedToWindow : %s", new Object[] { param1View });
                this.a.a(param1View);
              }
              
              public void onViewDetachedFromWindow(View param1View) {
                Integer integer = Integer.valueOf(this.a.b(param1View));
                ak.b("gdt_tag_p", "ADMonitor.onViewDetachedFromWindow : (%d) %s", new Object[] { integer, param1View });
                a.a(this.a).remove(integer);
                a.b(this.a).remove(integer);
                if (a.c(this.a) != null && a.a(this.a).size() <= 0)
                  a.c(this.a).b(); 
              }
            }; 
        paramView.addOnAttachStateChangeListener(this.h);
        if (this.g.size() > 100000) {
          this.g.clear();
          u.a(100012, 2, null);
        } 
        this.g.add(Integer.valueOf(i));
        if (this.f != null && !this.f.c())
          this.f.a(); 
      } 
      paramView.post(new Runnable(this, paramView) {
            public void run() {
              a.a(this.b, this.a);
            }
          });
    } 
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent) {
    if (Build.VERSION.SDK_INT >= 12 && paramView != null && paramMotionEvent != null && au.c()) {
      float f1 = paramMotionEvent.getPressure();
      float f2 = paramMotionEvent.getSize();
      int i = b(paramView);
      ak.b("gdt_tag_p", "ADMonitor.onTouchUp (%d) : %f , %f", new Object[] { Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
      if (this.b.size() > 100000) {
        this.b.clear();
        u.a(100012, 1, null);
      } 
      this.b.put(Integer.valueOf(i), new Pair(Float.valueOf(f1), Float.valueOf(f2)));
      c(paramView);
    } 
  }
  
  public int b(View paramView) {
    return System.identityHashCode(paramView);
  }
  
  public Pair<Integer, Integer> b(int paramInt) {
    return this.c.get(Integer.valueOf(paramInt));
  }
  
  public int[] b() {
    return (this.f != null) ? this.f.d() : null;
  }
  
  public Pair<Integer, Integer> c(int paramInt) {
    return this.d.get(Integer.valueOf(paramInt));
  }
  
  public Pair<Float, Integer> d(int paramInt) {
    return this.e.get(Integer.valueOf(paramInt));
  }
  
  static class a {
    private SensorManager a;
    
    private Sensor b;
    
    private Sensor c;
    
    private a.a$a d;
    
    private float[] e = new float[3];
    
    private float[] f = new float[3];
    
    a(Context param1Context) {
      this.a = (SensorManager)param1Context.getSystemService("sensor");
      this.b = this.a.getDefaultSensor(1);
      this.c = this.a.getDefaultSensor(2);
    }
    
    private int[] e() {
      float[] arrayOfFloat1 = new float[3];
      float[] arrayOfFloat2 = new float[9];
      SensorManager.getRotationMatrix(arrayOfFloat2, null, this.e, this.f);
      SensorManager.getOrientation(arrayOfFloat2, arrayOfFloat1);
      int i = (int)Math.toDegrees(arrayOfFloat1[1]);
      int j = (int)Math.toDegrees(arrayOfFloat1[2]);
      int k = (int)Math.toDegrees(arrayOfFloat1[0]);
      ak.b("gdt_tag_p", "calculateOrientation x = %d , y = %d , z = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      return new int[] { i, j, k };
    }
    
    public void a() {
      if (this.d == null) {
        this.d = new a.a$a();
        this.a.registerListener(this.d, this.b, 1);
        this.a.registerListener(this.d, this.c, 2);
        ak.a("gdt_tag_p", "ADMonitor.SensorDetector start");
      } 
    }
    
    public void b() {
      a.a$a a$a1 = this.d;
      if (a$a1 != null) {
        this.a.unregisterListener(a$a1);
        this.d = null;
        ak.a("gdt_tag_p", "ADMonitor.SensorDetector stop");
      } 
    }
    
    public boolean c() {
      return (this.d != null);
    }
    
    public int[] d() {
      return e();
    }
    
    class a$a implements SensorEventListener {
      private a$a(a.a this$0) {}
      
      public void onAccuracyChanged(Sensor param2Sensor, int param2Int) {}
      
      public void onSensorChanged(SensorEvent param2SensorEvent) {
        int i = param2SensorEvent.sensor.getType();
        if (i != 1) {
          if (i != 2)
            return; 
          a.a.b(this.a, param2SensorEvent.values);
          return;
        } 
        a.a.a(this.a, param2SensorEvent.values);
      }
    }
  }
  
  class a$a implements SensorEventListener {
    private a$a(a this$0) {}
    
    public void onAccuracyChanged(Sensor param1Sensor, int param1Int) {}
    
    public void onSensorChanged(SensorEvent param1SensorEvent) {
      int i = param1SensorEvent.sensor.getType();
      if (i != 1) {
        if (i != 2)
          return; 
        a.a.b(this.a, param1SensorEvent.values);
        return;
      } 
      a.a.a(this.a, param1SensorEvent.values);
    }
  }
  
  class a$a implements SensorEventListener {
    private a$a(a this$0) {}
    
    public void onAccuracyChanged(Sensor param1Sensor, int param1Int) {}
    
    public void onSensorChanged(SensorEvent param1SensorEvent) {
      int i = param1SensorEvent.sensor.getType();
      if (i != 1) {
        if (i != 2)
          return; 
        a.a.b(this.a, param1SensorEvent.values);
        return;
      } 
      a.a.a(this.a, param1SensorEvent.values);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ad\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */