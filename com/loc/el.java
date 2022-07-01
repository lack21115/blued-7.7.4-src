package com.loc;

import android.content.Context;
import com.amap.api.location.DPoint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class el {
  static double a = 3.141592653589793D;
  
  private static final List<DPoint> b = new ArrayList<DPoint>(Arrays.asList(new DPoint[] { new DPoint(23.379947D, 119.757001D), new DPoint(24.983296D, 120.474496D), new DPoint(25.518722D, 121.359866D), new DPoint(25.41329D, 122.443582D), new DPoint(24.862708D, 122.288354D), new DPoint(24.461292D, 122.188319D), new DPoint(21.584761D, 120.968923D), new DPoint(21.830837D, 120.654445D) }));
  
  private static double a(double paramDouble) {
    return Math.sin(paramDouble * 3000.0D * a / 180.0D) * 2.0E-5D;
  }
  
  private static double a(double paramDouble1, double paramDouble2) {
    return Math.cos(paramDouble2 / 100000.0D) * paramDouble1 / 18000.0D + Math.sin(paramDouble1 / 100000.0D) * paramDouble2 / 9000.0D;
  }
  
  public static DPoint a(Context paramContext, DPoint paramDPoint) {
    return (paramContext == null) ? null : b(paramDPoint);
  }
  
  public static DPoint a(DPoint paramDPoint) {
    if (paramDPoint != null)
      try {
        if (ej.a(paramDPoint.getLatitude(), paramDPoint.getLongitude()))
          return c(paramDPoint); 
        return paramDPoint;
      } finally {
        Exception exception = null;
      }  
    return paramDPoint;
  }
  
  private static double b(double paramDouble) {
    return Math.cos(paramDouble * 3000.0D * a / 180.0D) * 3.0E-6D;
  }
  
  private static double b(double paramDouble1, double paramDouble2) {
    return Math.sin(paramDouble2 / 100000.0D) * paramDouble1 / 18000.0D + Math.cos(paramDouble1 / 100000.0D) * paramDouble2 / 9000.0D;
  }
  
  public static DPoint b(Context paramContext, DPoint paramDPoint) {
    try {
      if (!ej.a(paramDPoint.getLatitude(), paramDPoint.getLongitude()))
        return paramDPoint; 
      double d2 = paramDPoint.getLongitude();
      double d1 = paramDPoint.getLatitude();
      d2 = ((long)(d2 * 100000.0D) % 36000000L);
      d1 = ((long)(d1 * 100000.0D) % 36000000L);
      int i = (int)(-a(d2, d1) + d2);
      int j = (int)(-b(d2, d1) + d1);
      double d4 = i;
      double d3 = j;
      d4 = -a(d4, d3);
      j = 1;
      if (d2 > 0.0D) {
        i = 1;
      } else {
        i = -1;
      } 
      d2 = (int)(d4 + d2 + i);
      d3 = -b(d2, d3);
      if (d1 > 0.0D) {
        i = j;
      } else {
        i = -1;
      } 
      return a(paramContext, new DPoint(i / 100000.0D, d1));
    } finally {
      paramContext = null;
      ej.a((Throwable)paramContext, "OffsetUtil", "marbar2G");
    } 
  }
  
  private static DPoint b(DPoint paramDPoint) {
    try {
      return paramDPoint;
    } finally {
      Exception exception = null;
      ej.a(exception, "OffsetUtil", "cover part2");
    } 
  }
  
  private static double c(double paramDouble) {
    return (new BigDecimal(paramDouble)).setScale(8, 4).doubleValue();
  }
  
  private static DPoint c(DPoint paramDPoint) {
    double d2 = 0.006401062D;
    double d1 = 0.0060424805D;
    DPoint dPoint = null;
    int i;
    for (i = 0; i < 2; i++) {
      double d3 = paramDPoint.getLongitude();
      double d4 = paramDPoint.getLatitude();
      dPoint = new DPoint();
      d2 = d3 - d2;
      d1 = d4 - d1;
      DPoint dPoint1 = new DPoint();
      double d5 = Math.cos(b(d2) + Math.atan2(d1, d2));
      double d6 = a(d1);
      double d10 = d2 * d2 + d1 * d1;
      double d7 = Math.sqrt(d10);
      double d8 = Math.sin(b(d2) + Math.atan2(d1, d2));
      double d9 = a(d1);
      d10 = Math.sqrt(d10);
      dPoint1.setLongitude(c(d5 * (d6 + d7) + 0.0065D));
      dPoint1.setLatitude(c(d8 * (d9 + d10) + 0.006D));
      dPoint.setLongitude(c(d3 + d2 - dPoint1.getLongitude()));
      dPoint.setLatitude(c(d4 + d1 - dPoint1.getLatitude()));
      d2 = paramDPoint.getLongitude() - dPoint.getLongitude();
      d1 = paramDPoint.getLatitude() - dPoint.getLatitude();
    } 
    return dPoint;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\el.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */