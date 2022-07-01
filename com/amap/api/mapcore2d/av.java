package com.amap.api.mapcore2d;

import android.graphics.Point;
import android.graphics.PointF;
import java.util.ArrayList;

class av {
  public int a = 256;
  
  public int b = 256;
  
  float c = 1.0F;
  
  public double d = 156543.0339D;
  
  int e = 0;
  
  double f = -2.003750834E7D;
  
  double g = 2.003750834E7D;
  
  public int h = q.d;
  
  public int i = q.c;
  
  public float j = 10.0F;
  
  public double k = 0.0D;
  
  public w l = null;
  
  public w m = null;
  
  public Point n = null;
  
  public a o = null;
  
  az.c p = null;
  
  private double q = 116.39716D;
  
  private double r = 39.91669D;
  
  private double s = 0.01745329251994329D;
  
  public av(az.c paramc) {
    this.p = paramc;
  }
  
  private double[] b(PointF paramPointF1, PointF paramPointF2) {
    double d1 = this.k;
    w w1 = b(paramPointF1, this.l, this.n, d1, this.o);
    w w2 = b(paramPointF2, this.l, this.n, d1, this.o);
    d1 = w2.e();
    double d4 = w1.e();
    double d2 = w2.f();
    double d3 = w1.f();
    d1 = this.l.e() + d1 - d4;
    d3 = this.l.f() + d2 - d3;
    while (true) {
      d2 = d1;
      if (d1 < this.o.a) {
        d1 += (this.o.b - this.o.a);
        continue;
      } 
      break;
    } 
    while (true) {
      d1 = d3;
      if (d2 > this.o.b) {
        d2 -= (this.o.b - this.o.a);
        continue;
      } 
      break;
    } 
    while (true) {
      d3 = d1;
      if (d1 < this.o.d) {
        d1 += (this.o.c - this.o.d);
        continue;
      } 
      break;
    } 
    while (d3 > this.o.c)
      d3 -= (this.o.c - this.o.d); 
    return new double[] { d2, d3 };
  }
  
  public float a(w paramw1, w paramw2) {
    if (paramw1 == null || paramw2 == null)
      return 0.0F; 
    double d5 = r.a(paramw1.c());
    double d4 = r.a(paramw1.d());
    double d1 = r.a(paramw2.c());
    double d2 = r.a(paramw2.d());
    double d3 = this.s;
    d5 *= d3;
    double d6 = d4 * d3;
    d1 *= d3;
    d4 = d2 * d3;
    d2 = Math.sin(d5);
    d3 = Math.sin(d6);
    d5 = Math.cos(d5);
    d6 = Math.cos(d6);
    double d7 = Math.sin(d1);
    double d8 = Math.sin(d4);
    d1 = Math.cos(d1);
    d4 = Math.cos(d4);
    double[] arrayOfDouble1 = new double[3];
    double[] arrayOfDouble2 = new double[3];
    arrayOfDouble1[0] = d5 * d6;
    arrayOfDouble1[1] = d6 * d2;
    arrayOfDouble1[2] = d3;
    arrayOfDouble2[0] = d1 * d4;
    arrayOfDouble2[1] = d4 * d7;
    arrayOfDouble2[2] = d8;
    return (float)(Math.asin(Math.sqrt((arrayOfDouble1[0] - arrayOfDouble2[0]) * (arrayOfDouble1[0] - arrayOfDouble2[0]) + (arrayOfDouble1[1] - arrayOfDouble2[1]) * (arrayOfDouble1[1] - arrayOfDouble2[1]) + (arrayOfDouble1[2] - arrayOfDouble2[2]) * (arrayOfDouble1[2] - arrayOfDouble2[2])) / 2.0D) * 1.27420015798544E7D);
  }
  
  public PointF a(int paramInt1, int paramInt2) {
    double d1;
    int i = this.a;
    double d2 = (paramInt1 * i);
    double d3 = this.k;
    double d4 = this.f;
    paramInt1 = this.e;
    if (paramInt1 == 0) {
      d1 = this.g - (paramInt2 * i) * d3;
    } else if (paramInt1 == 1) {
      d1 = ((paramInt2 + 1) * i) * d3;
    } else {
      d1 = 0.0D;
    } 
    return a(new w(d1, d2 * d3 + d4, false), this.l, this.n, this.k);
  }
  
  PointF a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, PointF paramPointF, int paramInt5, int paramInt6) {
    PointF pointF = new PointF();
    pointF.x = ((paramInt1 - paramInt3) * this.a) + paramPointF.x;
    paramInt1 = this.e;
    if (paramInt1 == 0) {
      pointF.y = ((paramInt2 - paramInt4) * this.a) + paramPointF.y;
    } else if (paramInt1 == 1) {
      paramPointF.y -= ((paramInt2 - paramInt4) * this.a);
    } 
    return (pointF.x + this.a <= 0.0F || pointF.x >= paramInt5 || pointF.y + this.a <= 0.0F || pointF.y >= paramInt6) ? null : pointF;
  }
  
  PointF a(w paramw1, w paramw2, Point paramPoint, double paramDouble) {
    if (paramw1 != null) {
      if (paramw2 == null)
        return null; 
      try {
        PointF pointF = new PointF();
      } finally {
        paramw2 = null;
      } 
      cm.a((Throwable)paramw2, "MapProjection", "convertProjectionToScreen");
      return (PointF)paramw1;
    } 
    return null;
  }
  
  public w a(PointF paramPointF1, PointF paramPointF2) {
    double[] arrayOfDouble = b(paramPointF1, paramPointF2);
    w w1 = new w(this.l.b(), this.l.a());
    w1.b(arrayOfDouble[1]);
    w1.a(arrayOfDouble[0]);
    return w1;
  }
  
  public w a(PointF paramPointF, w paramw, Point paramPoint, double paramDouble, a parama) {
    return b(b(paramPointF, paramw, paramPoint, paramDouble, parama));
  }
  
  public w a(w paramw) {
    if (paramw == null)
      return null; 
    double d1 = paramw.b() / 1000000.0D;
    double d2 = paramw.a() / 1000000.0D * 2.003750834E7D / 180.0D;
    return new w(Math.log(Math.tan((d1 + 90.0D) * Math.PI / 360.0D)) / 0.017453292519943295D * 2.003750834E7D / 180.0D, d2, false);
  }
  
  public ArrayList<bs> a(w paramw, int paramInt1, int paramInt2, int paramInt3) {
    double d2 = this.k;
    double d1 = paramw.e();
    double d3 = this.f;
    paramInt1 = this.a;
    int k = (int)((d1 - d3) / paramInt1 * d2);
    double d4 = (paramInt1 * k);
    paramInt1 = this.e;
    if (paramInt1 == 0) {
      d1 = this.g;
      double d = paramw.f();
      int m = this.a;
      paramInt1 = (int)((d1 - d) / m * d2);
      d1 = this.g;
      d = (m * paramInt1);
      d1 -= d * d2;
    } else if (paramInt1 == 1) {
      d1 = paramw.f();
      double d = this.g;
      int m = this.a;
      paramInt1 = (int)((d1 - d) / m * d2);
      d1 = ((paramInt1 + 1) * m);
      d1 *= d2;
    } else {
      d1 = 0.0D;
      paramInt1 = 0;
    } 
    PointF pointF = a(new w(d1, d4 * d2 + d3, false), paramw, this.n, d2);
    bs bs = new bs(k, paramInt1, b(), -1);
    bs.g = pointF;
    ArrayList<bs> arrayList = new ArrayList();
    arrayList.add(bs);
    int j = 1;
    int i = paramInt1;
    while (true) {
      int n = k - j;
      int m = n;
      paramInt1 = 0;
      while (true) {
        int i1 = k + j;
        if (m <= i1) {
          int i3 = i + j;
          try {
            PointF pointF1 = a(m, i3, k, i, pointF, paramInt2, paramInt3);
            i1 = paramInt1;
            if (pointF1 != null) {
              i1 = paramInt1;
              if (paramInt1 == 0)
                i1 = 1; 
              bs bs1 = new bs(m, i3, b(), -1);
              bs1.g = pointF1;
              arrayList.add(bs1);
            } 
            i3 = i - j;
            pointF1 = a(m, i3, k, i, pointF, paramInt2, paramInt3);
            paramInt1 = i1;
            if (pointF1 != null) {
              paramInt1 = i1;
              if (i1 == 0)
                paramInt1 = 1; 
              bs bs1 = new bs(m, i3, b(), -1);
              bs1.g = pointF1;
              arrayList.add(bs1);
            } 
            m++;
          } catch (Error error) {
            cm.a(error, "MapProjection", "getTilesInDomain");
            return arrayList;
          } 
          continue;
        } 
        int i2 = i + j - 1;
        m = i1;
        while (i2 > i - j) {
          PointF pointF1 = a(m, i2, k, i, (PointF)error, paramInt2, paramInt3);
          i1 = paramInt1;
          if (pointF1 != null) {
            i1 = paramInt1;
            if (paramInt1 == 0)
              i1 = 1; 
            bs bs1 = new bs(m, i2, b(), -1);
            bs1.g = pointF1;
            arrayList.add(bs1);
          } 
          pointF1 = a(n, i2, k, i, (PointF)error, paramInt2, paramInt3);
          if (pointF1 != null) {
            paramInt1 = i1;
            if (i1 == 0)
              paramInt1 = 1; 
            bs bs1 = new bs(n, i2, b(), -1);
            bs1.g = pointF1;
            arrayList.add(bs1);
          } else {
            paramInt1 = i1;
          } 
          i2--;
        } 
        if (paramInt1 == 0)
          return arrayList; 
        j++;
      } 
      break;
    } 
  }
  
  public void a() {
    this.d = this.g * 2.0D / this.a;
    float f = this.j;
    int i = (int)f;
    this.k = this.d / (1 << i) / (f + 1.0F - i);
    this.l = a(new w(this.r, this.q, true));
    this.m = this.l.g();
    this.n = new Point(this.p.c() / 2, this.p.d() / 2);
    this.o = new a();
    a a1 = this.o;
    a1.a = -2.0037508E7F;
    a1.b = 2.0037508E7F;
    a1.c = 2.0037508E7F;
    a1.d = -2.0037508E7F;
  }
  
  public void a(Point paramPoint) {
    this.n = paramPoint;
  }
  
  public void a(PointF paramPointF1, PointF paramPointF2, float paramFloat) {
    if (this.l == null)
      return; 
    double[] arrayOfDouble = b(paramPointF1, paramPointF2);
    this.l.b(arrayOfDouble[1]);
    this.l.a(arrayOfDouble[0]);
  }
  
  int b() {
    float f = this.j;
    int i = (int)f;
    return ((f - i) < az.a) ? i : (i + 1);
  }
  
  public PointF b(w paramw1, w paramw2, Point paramPoint, double paramDouble) {
    if (this.p == null || paramw1 == null || paramw2 == null || paramPoint == null)
      return null; 
    PointF pointF = a(a(paramw1), paramw2, paramPoint, paramDouble);
    return this.p.g().b(pointF);
  }
  
  w b(PointF paramPointF, w paramw, Point paramPoint, double paramDouble, a parama) {
    az.c c1 = this.p;
    if (c1 == null || paramPointF == null || paramw == null || paramPoint == null || parama == null)
      return null; 
    paramPointF = c1.g().c(paramPointF);
    float f1 = paramPointF.x;
    float f2 = paramPoint.x;
    float f3 = paramPointF.y;
    float f4 = paramPoint.y;
    double d1 = paramw.e() + (f1 - f2) * paramDouble;
    double d2 = paramw.f() - (f3 - f4) * paramDouble;
    for (paramDouble = d1; paramDouble < parama.a; paramDouble += (parama.b - parama.a));
    d1 = paramDouble;
    while (true) {
      paramDouble = d2;
      if (d1 > parama.b) {
        d1 -= (parama.b - parama.a);
        continue;
      } 
      break;
    } 
    while (paramDouble < parama.d)
      paramDouble += (parama.c - parama.d); 
    while (paramDouble > parama.c)
      paramDouble -= (parama.c - parama.d); 
    return new w(paramDouble, d1, false);
  }
  
  public w b(w paramw) {
    if (paramw == null)
      return null; 
    float f = (float)(paramw.e() * 180.0D / 2.003750834E7D);
    return new w((int)((float)((Math.atan(Math.exp((float)(paramw.f() * 180.0D / 2.003750834E7D) * Math.PI / 180.0D)) * 2.0D - 1.5707963267948966D) * 57.29577951308232D) * 1000000.0D), (int)(f * 1000000.0D));
  }
  
  static class a {
    float a;
    
    float b;
    
    float c;
    
    float d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */