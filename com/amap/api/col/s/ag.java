package com.amap.api.col.s;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import java.util.Iterator;
import java.util.List;

public class ag {
  private static volatile ag r;
  
  boolean a = true;
  
  boolean b = true;
  
  boolean c = true;
  
  boolean d = true;
  
  boolean e = true;
  
  boolean f = true;
  
  boolean g = true;
  
  int h = 25;
  
  int i = 100;
  
  int j = 100;
  
  int k = 100;
  
  int l = 6;
  
  int m = 100;
  
  int n = 5000;
  
  int o = 1200;
  
  int p = 100000000;
  
  int q = 16;
  
  public static ag a() {
    // Byte code:
    //   0: getstatic com/amap/api/col/s/ag.r : Lcom/amap/api/col/s/ag;
    //   3: ifnonnull -> 37
    //   6: ldc com/amap/api/col/s/ag
    //   8: monitorenter
    //   9: getstatic com/amap/api/col/s/ag.r : Lcom/amap/api/col/s/ag;
    //   12: ifnonnull -> 25
    //   15: new com/amap/api/col/s/ag
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/amap/api/col/s/ag.r : Lcom/amap/api/col/s/ag;
    //   25: ldc com/amap/api/col/s/ag
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/amap/api/col/s/ag
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/amap/api/col/s/ag.r : Lcom/amap/api/col/s/ag;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public final int a(int paramInt) {
    if (!this.d)
      return paramInt; 
    int i = this.m;
    return (i < paramInt) ? i : paramInt;
  }
  
  public final void a(RouteSearch.FromAndTo paramFromAndTo) throws AMapException {
    if (!this.e)
      return; 
    if (paramFromAndTo != null && paramFromAndTo.getFrom() != null) {
      if (paramFromAndTo.getTo() == null)
        return; 
      double d = i.a(paramFromAndTo.getFrom(), paramFromAndTo.getTo()) / 1000.0D;
      if (this.o >= d)
        return; 
      throw new AMapException("起点终点距离过长");
    } 
  }
  
  public final void a(RouteSearch.FromAndTo paramFromAndTo, List<LatLonPoint> paramList) throws AMapException {
    if (!this.c)
      return; 
    if (paramFromAndTo != null && paramFromAndTo.getFrom() != null) {
      LatLonPoint latLonPoint;
      if (paramFromAndTo.getTo() == null)
        return; 
      double d = 0.0D;
      if (paramList != null && paramList.size() != 0) {
        LatLonPoint latLonPoint1 = paramFromAndTo.getFrom();
        LatLonPoint latLonPoint2 = paramFromAndTo.getTo();
        Iterator<LatLonPoint> iterator = paramList.iterator();
        for (latLonPoint = latLonPoint1; iterator.hasNext(); latLonPoint = latLonPoint3) {
          LatLonPoint latLonPoint3 = iterator.next();
          d += i.a(latLonPoint, latLonPoint3);
        } 
        d += i.a(latLonPoint, latLonPoint2);
      } else {
        d = i.a(latLonPoint.getFrom(), latLonPoint.getTo());
      } 
      d /= 1000.0D;
      if (this.n >= d)
        return; 
      throw new AMapException("起点终点距离过长");
    } 
  }
  
  public final void a(String paramString) throws AMapException {
    if (paramString == null)
      return; 
    if (!this.b)
      return; 
    if (paramString.length() <= this.i)
      return; 
    throw new AMapException("关键字过长");
  }
  
  public final void a(List<LatLonPoint> paramList) throws AMapException {
    if (!this.g)
      return; 
    if (paramList == null)
      return; 
    int i = paramList.size();
    if (this.l >= i)
      return; 
    throw new AMapException("途经点个数超限");
  }
  
  public final int b(int paramInt) {
    if (!this.d)
      return paramInt; 
    int i = this.h;
    return (i < paramInt) ? i : paramInt;
  }
  
  public final void b(RouteSearch.FromAndTo paramFromAndTo) throws AMapException {
    if (!this.f)
      return; 
    if (paramFromAndTo != null && paramFromAndTo.getFrom() != null) {
      if (paramFromAndTo.getTo() == null)
        return; 
      double d = i.a(paramFromAndTo.getFrom(), paramFromAndTo.getTo()) / 1000.0D;
      if (this.k >= d)
        return; 
      throw new AMapException("起点终点距离过长");
    } 
  }
  
  public final void b(List<List<LatLonPoint>> paramList) throws AMapException {
    if (!this.a)
      return; 
    if (paramList == null)
      return; 
    int i = paramList.size();
    if (this.j >= i) {
      for (List<LatLonPoint> list : paramList) {
        double d1 = 0.0D;
        double d2 = d1;
        if (list != null)
          if (list.size() < 3) {
            d2 = d1;
          } else {
            int j = list.size();
            i = 0;
            while (i < j) {
              LatLonPoint latLonPoint1 = list.get(i);
              LatLonPoint latLonPoint2 = list.get(++i % j);
              d2 = latLonPoint1.getLongitude();
              double d3 = Math.cos(latLonPoint1.getLatitude() * 0.017453292519943295D);
              double d4 = latLonPoint1.getLatitude();
              double d5 = latLonPoint2.getLongitude();
              double d6 = Math.cos(latLonPoint2.getLatitude() * 0.017453292519943295D);
              d1 += d2 * 111319.49079327357D * d3 * latLonPoint2.getLatitude() * 111319.49079327357D - d5 * 111319.49079327357D * d6 * d4 * 111319.49079327357D;
            } 
            d2 = Math.abs(d1 / 2.0D);
          }  
        i = list.size();
        if (this.q >= i) {
          if (this.p >= d2)
            continue; 
          throw new AMapException("避让区域大小超限");
        } 
        throw new AMapException("避让区域点个数超限");
      } 
      return;
    } 
    throw new AMapException("避让区域个数超限");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */