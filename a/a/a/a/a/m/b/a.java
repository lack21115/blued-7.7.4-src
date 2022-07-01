package a.a.a.a.a.m.b;

import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class a {
  public static boolean a = true;
  
  public static int b = 2;
  
  public static int c = 10;
  
  public static float d = 0.85F;
  
  public static float e = 0.25F;
  
  public static float f = 0.6F;
  
  public static float g = 0.4F;
  
  public static float h = 10.0F;
  
  public static int i = 4;
  
  public static int j = 3;
  
  public b k;
  
  public b l;
  
  public float m;
  
  public List<Float> n;
  
  public List<Float> o;
  
  public List<Float> p;
  
  public float q;
  
  public float r;
  
  public float s;
  
  public List<Float> t;
  
  public List<Float> u;
  
  public static a a() {
    return d.a();
  }
  
  public void a(float paramFloat) {
    this.m = paramFloat;
    c();
    List<Float> list = this.t;
    if (list == null) {
      this.t = new ArrayList<Float>(2);
    } else {
      list.clear();
    } 
    list = this.u;
    if (list == null) {
      this.u = new ArrayList<Float>(2);
    } else {
      list.clear();
    } 
    b b1 = b.a;
    this.k = b1;
    this.l = b1;
    e.k.c("PLTCPSendTimePredictor", "PLTCPSendTimePredictor init!");
  }
  
  public final void a(List<Float> paramList) {
    if (paramList == null)
      return; 
    c();
    Iterator<Float> iterator = paramList.iterator();
    while (iterator.hasNext())
      e(((Float)iterator.next()).floatValue()); 
    if (paramList.size() > 0)
      this.m = ((Float)paramList.get(paramList.size() - 1)).floatValue(); 
    e.k.b("PLTCPSendTimePredictor", "tcp predictor restart");
  }
  
  public final void a(List<Float> paramList, float paramFloat) {
    a(paramList, paramFloat, b);
  }
  
  public final void a(List<Float> paramList, float paramFloat, int paramInt) {
    if (paramList == null)
      return; 
    paramList.add(Float.valueOf(paramFloat));
    if (paramList.size() > paramInt)
      paramList.remove(0); 
  }
  
  public float b(float paramFloat) {
    if (paramFloat == 0.0F)
      return paramFloat; 
    if (a) {
      c c = c(paramFloat);
      if (c == c.c)
        return this.m; 
      if (c == c.b) {
        this.k = this.l;
      } else {
        this.k = b.a;
      } 
      float f1 = paramFloat - this.m;
      if (Math.abs(f1) / this.m > f && Math.abs(f1) > 15.0F) {
        f1 = this.s + 1.0F;
        this.s = f1;
        if (f1 >= j && paramFloat > this.m) {
          this.k = b.c;
          this.s = 0.0F;
        } 
      } else {
        this.s = 0.0F;
      } 
    } else {
      e(paramFloat);
    } 
    if (this.t.size() == 0 || this.u.size() == 0)
      d(paramFloat); 
    List<Float> list = this.t;
    int i = 0;
    double d2 = ((Float)list.get(0)).floatValue();
    if (this.t.size() == b) {
      list = this.t;
      d1 = ((Float)list.get(list.size() - 1)).floatValue();
    } else {
      d1 = d2;
    } 
    if (this.u.size() == c) {
      list = this.u;
      i = list.size() - 1;
    } else {
      list = this.u;
    } 
    double d4 = ((Float)list.get(i)).floatValue();
    float f = d;
    double d3 = (paramFloat * f + (1.0F - f) * this.m);
    paramFloat = e;
    double d1 = paramFloat * (d1 - d2) + (1.0F - paramFloat) * d4;
    a(this.t, (int)d3);
    a(this.u, (int)d1);
    paramFloat = (int)(d3 + d1);
    this.m = paramFloat;
    return paramFloat;
  }
  
  public b b() {
    return this.k;
  }
  
  public final c c(float paramFloat) {
    if (this.n.size() < i) {
      e(paramFloat);
      return c.a;
    } 
    float f1 = h.a(this.n);
    float f2 = paramFloat - f1;
    double d1 = Math.abs(f2);
    double d2 = f1;
    if (d1 / d2 >= f && Math.abs(f2) > h) {
      e.k.b("PLTCPSendTimePredictor", "[TCP Predictor] discard outlier sample.");
      this.p.add(Float.valueOf(paramFloat));
      if (this.p.size() < j)
        return c.c; 
      f1 = h.a(this.p) - f1;
      if (Math.abs(f1 / d2) >= g && Math.abs(f1) > 10.0F) {
        b b1;
        a(this.p);
        if (f1 > 0.0F) {
          b1 = b.c;
        } else {
          b1 = b.b;
        } 
        this.l = b1;
        return c.b;
      } 
      e.k.b("PLTCPSendTimePredictor", "[TCP Predictor] enqueue outlier sample");
      a(this.p, paramFloat, j);
      return c.c;
    } 
    if (paramFloat > this.r) {
      int i = a.a[this.l.ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i == 3) {
            this.o.add(Float.valueOf(paramFloat));
            if (this.o.size() >= j) {
              f1 = h.a(this.o);
              paramFloat = h.a(this.n);
              f1 -= paramFloat;
              d1 = Math.abs(f1) / paramFloat;
              a(this.o);
              if (d1 > g && Math.abs(f1) > h) {
                e.k.b("PLTCPSendTimePredictor", "[TCP Predictor] network quality trending down");
                return c.b;
              } 
              return c.a;
            } 
          } 
        } else {
          ArrayList<Float> arrayList = new ArrayList();
          arrayList.addAll(this.o);
          this.o.clear();
          Iterator<Float> iterator = arrayList.iterator();
          while (iterator.hasNext())
            e(((Float)iterator.next()).floatValue()); 
          this.l = b.a;
        } 
      } else {
        this.o.add(Float.valueOf(paramFloat));
        this.l = b.c;
      } 
    } else if (paramFloat < this.q) {
      int i = a.a[this.l.ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i == 3) {
            ArrayList<Float> arrayList = new ArrayList();
            arrayList.addAll(this.o);
            this.o.clear();
            Iterator<Float> iterator = arrayList.iterator();
            while (iterator.hasNext())
              e(((Float)iterator.next()).floatValue()); 
            this.l = b.a;
          } 
        } else {
          this.o.add(Float.valueOf(paramFloat));
          if (this.o.size() >= j) {
            f1 = h.a(this.o);
            paramFloat = h.a(this.n);
            f1 -= paramFloat;
            d1 = Math.abs(f1) / paramFloat;
            a(this.o);
            if (d1 > g && Math.abs(f1) > h) {
              e.k.b("PLTCPSendTimePredictor", "[TCP Predictor] network quality trending up");
              return c.b;
            } 
            return c.b;
          } 
        } 
      } else {
        this.o.add(Float.valueOf(paramFloat));
        this.l = b.b;
      } 
    } else {
      e(paramFloat);
    } 
    return c.a;
  }
  
  public final void c() {
    this.q = 2.14748365E9F;
    this.r = -2.14748365E9F;
    this.s = 0.0F;
    List<Float> list = this.n;
    if (list == null) {
      this.n = new ArrayList<Float>();
    } else {
      list.clear();
    } 
    list = this.o;
    if (list == null) {
      this.o = new ArrayList<Float>();
    } else {
      list.clear();
    } 
    list = this.p;
    if (list == null) {
      this.p = new ArrayList<Float>();
      return;
    } 
    list.clear();
  }
  
  public final void d(float paramFloat) {
    float f = this.m;
    a(this.t, f);
    a(this.u, f - paramFloat);
  }
  
  public final void e(float paramFloat) {
    a(this.n, paramFloat, c);
    if (!this.n.contains(Float.valueOf(this.q))) {
      this.q = ((Float)Collections.<Float>min(this.n)).floatValue();
    } else if (paramFloat < this.q) {
      this.q = paramFloat;
    } 
    if (!this.n.contains(Float.valueOf(this.r))) {
      this.r = ((Float)Collections.<Float>max(this.n)).floatValue();
    } else if (paramFloat > this.r) {
      this.r = paramFloat;
    } 
    if (this.p.size() > 0)
      this.p.clear(); 
  }
  
  public enum b {
    a, b, c;
    
    static {
      b b1 = new b("PLNetworkQualityShiftTrendingDown", 2);
      c = b1;
      d = new b[] { a, b, b1 };
    }
  }
  
  public enum c {
    a, b, c;
    
    static {
      c c1 = new c("PLSampleDetectionResultTypeOutlier", 2);
      c = c1;
      d = new c[] { a, b, c1 };
    }
  }
  
  public static class d {
    public static final a a = new a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\m\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */