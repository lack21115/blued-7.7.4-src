package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract class bb {
  static float j = 1.0F;
  
  private static Method p;
  
  private static Method q;
  
  private static boolean r = false;
  
  private static boolean s = false;
  
  b a;
  
  int b = 0;
  
  Matrix c = new Matrix();
  
  Matrix d = new Matrix();
  
  PointF e = new PointF();
  
  PointF f = new PointF();
  
  PointF g = new PointF();
  
  float h = 1.0F;
  
  float i = 1.0F;
  
  boolean k = false;
  
  boolean l = false;
  
  boolean m = false;
  
  public int n = 0;
  
  public long o = 0L;
  
  public static a a(Context paramContext, b paramb) {
    a a = new a();
    a.a = paramb;
    return a;
  }
  
  private static void b(MotionEvent paramMotionEvent) {
    if (s)
      return; 
    s = true;
    try {
      p = paramMotionEvent.getClass().getMethod("getX", new Class[] { int.class });
      q = paramMotionEvent.getClass().getMethod("getY", new Class[] { int.class });
      if (p != null && q != null) {
        r = true;
        return;
      } 
    } catch (Exception exception) {
      cm.a(exception, "MutiTouchGestureDetector", "checkSDKForMuti");
    } 
  }
  
  public static class a extends bb {
    float p;
    
    float q;
    
    float r;
    
    float s;
    
    long t = 0L;
    
    int u = 0;
    
    int v = 0;
    
    private long w = 0L;
    
    private void a(PointF param1PointF, MotionEvent param1MotionEvent) {
      float f1;
      float f2 = 0.0F;
      try {
        f1 = ((Float)bb.b().invoke(param1MotionEvent, new Object[] { Integer.valueOf(0) })).floatValue();
        float f = ((Float)bb.b().invoke(param1MotionEvent, new Object[] { Integer.valueOf(1) })).floatValue();
        f1 += f;
      } catch (IllegalArgumentException illegalArgumentException) {
        cm.a(illegalArgumentException, "MutiTouchGestureDetector", "midPoint");
        f1 = 0.0F;
      } catch (IllegalAccessException illegalAccessException) {
        cm.a(illegalAccessException, "MutiTouchGestureDetector", "midPoint");
      } catch (InvocationTargetException invocationTargetException) {
        cm.a(invocationTargetException, "MutiTouchGestureDetector", "midPoint");
      } 
      try {
        float f5 = ((Float)bb.c().invoke(param1MotionEvent, new Object[] { Integer.valueOf(0) })).floatValue();
        float f6 = ((Float)bb.c().invoke(param1MotionEvent, new Object[] { Integer.valueOf(1) })).floatValue();
      } finally {
        param1MotionEvent = null;
      } 
      int i = this.u;
      float f4 = f2;
      float f3 = f1;
      if (i != 0) {
        int j = this.v;
        f4 = f2;
        f3 = f1;
        if (j != 0) {
          f3 = i;
          f4 = j;
        } 
      } 
      param1PointF.set(f3 / 2.0F, f4 / 2.0F);
    }
    
    private float b(MotionEvent param1MotionEvent) {
      float f1;
      float f2 = 0.0F;
      try {
        f1 = ((Float)bb.b().invoke(param1MotionEvent, new Object[] { Integer.valueOf(0) })).floatValue();
        float f = ((Float)bb.b().invoke(param1MotionEvent, new Object[] { Integer.valueOf(1) })).floatValue();
        f1 -= f;
      } catch (IllegalArgumentException illegalArgumentException) {
        cm.a(illegalArgumentException, "MutiTouchGestureDetector", "distance");
        f1 = 0.0F;
      } catch (IllegalAccessException illegalAccessException) {
        cm.a(illegalAccessException, "MutiTouchGestureDetector", "distance");
      } catch (InvocationTargetException invocationTargetException) {
        cm.a(invocationTargetException, "MutiTouchGestureDetector", "distance");
      } 
      try {
        float f3 = ((Float)bb.c().invoke(param1MotionEvent, new Object[] { Integer.valueOf(0) })).floatValue();
        float f4 = ((Float)bb.c().invoke(param1MotionEvent, new Object[] { Integer.valueOf(1) })).floatValue();
        f2 = f3 - f4;
      } catch (IllegalArgumentException illegalArgumentException) {
        cm.a(illegalArgumentException, "MutiTouchGestureDetector", "distance");
      } catch (IllegalAccessException illegalAccessException) {
        cm.a(illegalAccessException, "MutiTouchGestureDetector", "distance");
      } catch (InvocationTargetException invocationTargetException) {
        cm.a(invocationTargetException, "MutiTouchGestureDetector", "distance");
      } 
      return (float)Math.sqrt((f1 * f1 + f2 * f2));
    }
    
    public boolean a(MotionEvent param1MotionEvent, int param1Int1, int param1Int2) {
      this.u = param1Int1;
      this.v = param1Int2;
      bb.a(param1MotionEvent);
      if (!bb.a())
        return false; 
      param1Int1 = param1MotionEvent.getAction() & 0xFF;
      if (param1Int1 != 0) {
        if (param1Int1 != 1) {
          if (param1Int1 != 2) {
            if (param1Int1 != 3)
              if (param1Int1 != 5) {
                if (param1Int1 != 6)
                  return false; 
              } else {
                this.n++;
                if (this.n == 1) {
                  this.m = true;
                  j = 1.0F;
                  this.h = b(param1MotionEvent);
                  if (this.h > 10.0F) {
                    this.c.reset();
                    this.d.reset();
                    this.d.set(this.c);
                    a(this.f, param1MotionEvent);
                    this.b = 2;
                    this.k = true;
                    boolean bool = this.a.a(this.e);
                    this.r = this.f.x;
                    this.s = this.f.y;
                    return false | bool;
                  } 
                } 
                return false;
              }  
            this.n--;
            if (this.n < 0)
              this.n = 0; 
            if (this.n == 1) {
              this.m = true;
              this.b = 2;
            } 
            if (this.n == 0) {
              a(this.f, param1MotionEvent);
              this.l = false;
              this.m = false;
              if (this.k) {
                boolean bool = this.a.b(this.i, this.f);
                this.b = 0;
                return bool | false;
              } 
            } 
          } else {
            if (this.b == 1) {
              float f1 = param1MotionEvent.getX();
              float f2 = param1MotionEvent.getY();
              this.c.set(this.d);
              this.c.postTranslate(param1MotionEvent.getX() - this.e.x, param1MotionEvent.getY() - this.e.y);
              boolean bool1 = this.a.a(f1 - this.p, f2 - this.q);
              this.p = f1;
              this.q = f2;
              boolean bool2 = this.a.a(this.c);
              return (param1MotionEvent.getEventTime() - this.t < 30L) ? true : (bool2 | false | bool1);
            } 
            if (this.b == 2) {
              float f = b(param1MotionEvent);
              this.i = 1.0F;
              long l = param1MotionEvent.getEventTime();
              if (f > 10.0F && Math.abs(f - this.h) > 5.0F && l - this.w > 10L) {
                this.w = l;
                this.i = f / this.h;
                j = 1.0F;
                this.h = f;
                a(this.g, param1MotionEvent);
                boolean bool1 = this.a.a(this.g.x - this.r, this.g.y - this.s);
                this.r = this.g.x;
                this.s = this.g.y;
                boolean bool2 = this.a.a(this.i, this.f);
                this.l = true;
                return bool1 | false | bool2;
              } 
            } 
          } 
        } else {
          this.o = param1MotionEvent.getEventTime();
          this.k = false;
          this.b = 0;
          return false;
        } 
      } else {
        this.t = param1MotionEvent.getEventTime();
        this.p = param1MotionEvent.getX();
        this.q = param1MotionEvent.getY();
        this.d.set(this.c);
        this.e.set(this.p, this.q);
        this.b = 1;
      } 
      return false;
    }
  }
  
  public static interface b {
    boolean a(float param1Float1, float param1Float2);
    
    boolean a(float param1Float, PointF param1PointF);
    
    boolean a(Matrix param1Matrix);
    
    boolean a(PointF param1PointF);
    
    boolean b(float param1Float, PointF param1PointF);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */