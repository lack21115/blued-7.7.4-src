package com.loc;

import android.os.Bundle;
import com.amap.api.fence.GeoFence;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class c {
  private static long a;
  
  public static int a(String paramString, List<GeoFence> paramList, Bundle paramBundle) {
    byte b;
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      int i = jSONObject.optInt("status", 0);
      int j = jSONObject.optInt("infocode", 0);
      b = j;
    } finally {
      paramString = null;
    } 
    return b;
  }
  
  public static long a() {
    // Byte code:
    //   0: ldc com/loc/c
    //   2: monitorenter
    //   3: invokestatic b : ()J
    //   6: lstore_0
    //   7: lload_0
    //   8: getstatic com/loc/c.a : J
    //   11: lcmp
    //   12: ifle -> 22
    //   15: lload_0
    //   16: putstatic com/loc/c.a : J
    //   19: goto -> 30
    //   22: getstatic com/loc/c.a : J
    //   25: lconst_1
    //   26: ladd
    //   27: putstatic com/loc/c.a : J
    //   30: getstatic com/loc/c.a : J
    //   33: lstore_0
    //   34: ldc com/loc/c
    //   36: monitorexit
    //   37: lload_0
    //   38: lreturn
    //   39: astore_2
    //   40: ldc com/loc/c
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	39	finally
    //   22	30	39	finally
    //   30	34	39	finally
  }
  
  private List<DPoint> a(List<DPoint> paramList, float paramFloat) {
    List<DPoint> list2 = paramList;
    if (list2 == null)
      return null; 
    if (paramList.size() <= 2)
      return list2; 
    ArrayList<DPoint> arrayList = new ArrayList();
    DPoint dPoint1 = list2.get(0);
    DPoint dPoint2 = list2.get(paramList.size() - 1);
    double d = 0.0D;
    int i = 1;
    int j = 0;
    while (i < paramList.size() - 1) {
      boolean bool;
      DPoint dPoint = paramList.get(i);
      double d3 = dPoint.getLongitude();
      double d4 = dPoint1.getLongitude();
      double d5 = dPoint.getLatitude();
      double d6 = dPoint1.getLatitude();
      double d1 = dPoint2.getLongitude() - dPoint1.getLongitude();
      double d2 = dPoint2.getLatitude() - dPoint1.getLatitude();
      d3 = ((d3 - d4) * d1 + (d5 - d6) * d2) / (d1 * d1 + d2 * d2);
      if (dPoint1.getLongitude() == dPoint2.getLongitude() && dPoint1.getLatitude() == dPoint2.getLatitude()) {
        bool = true;
      } else {
        bool = false;
      } 
      if (d3 < 0.0D || bool) {
        d1 = dPoint1.getLongitude();
        d2 = dPoint1.getLatitude();
      } else if (d3 > 1.0D) {
        d1 = dPoint2.getLongitude();
        d2 = dPoint2.getLatitude();
      } else {
        d4 = dPoint1.getLongitude();
        d2 = dPoint1.getLatitude() + d3 * d2;
        d1 = d4 + d1 * d3;
      } 
      d2 = ep.a(new DPoint(dPoint.getLatitude(), dPoint.getLongitude()), new DPoint(d2, d1));
      d1 = d;
      if (d2 > d) {
        d1 = d2;
        j = i;
      } 
      i++;
      d = d1;
    } 
    if (d < paramFloat) {
      arrayList.add(dPoint1);
      arrayList.add(dPoint2);
      return arrayList;
    } 
    List<DPoint> list1 = a(paramList.subList(0, j + 1), paramFloat);
    paramList = a(paramList.subList(j, paramList.size()), paramFloat);
    arrayList.addAll(list1);
    arrayList.remove(arrayList.size() - 1);
    arrayList.addAll(paramList);
    return arrayList;
  }
  
  public final int b(String paramString, List<GeoFence> paramList, Bundle paramBundle) {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      int m = jSONObject.optInt("status", 0);
      int i = jSONObject.optInt("infocode", 0);
      paramString = paramBundle.getString("customId");
      String str = paramBundle.getString("pendingIntentAction");
      float f = paramBundle.getFloat("fenceRadius");
      long l = paramBundle.getLong("expiration");
      int k = paramBundle.getInt("activatesAction", 1);
      int j = i;
      return j;
    } finally {
      paramString = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */