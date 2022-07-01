package com.amap.api.mapcore2d;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.VisibleRegion;

class bi implements ah {
  private String a = "ProjectionDelegateImp";
  
  private y b;
  
  public bi(y paramy) {
    this.b = paramy;
  }
  
  public LatLng fromScreenLocation(Point paramPoint) throws RemoteException {
    s s = new s();
    this.b.a(paramPoint.x, paramPoint.y, s);
    return new LatLng(s.b, s.a);
  }
  
  public VisibleRegion getVisibleRegion() throws RemoteException {
    // Byte code:
    //   0: aconst_null
    //   1: astore #9
    //   3: aload_0
    //   4: getfield b : Lcom/amap/api/mapcore2d/y;
    //   7: invokeinterface getMapWidth : ()I
    //   12: istore_1
    //   13: aload_0
    //   14: getfield b : Lcom/amap/api/mapcore2d/y;
    //   17: invokeinterface getMapHeight : ()I
    //   22: istore_2
    //   23: aload_0
    //   24: new android/graphics/Point
    //   27: dup
    //   28: iconst_0
    //   29: iconst_0
    //   30: invokespecial <init> : (II)V
    //   33: invokevirtual fromScreenLocation : (Landroid/graphics/Point;)Lcom/amap/api/maps2d/model/LatLng;
    //   36: astore #5
    //   38: aload_0
    //   39: new android/graphics/Point
    //   42: dup
    //   43: iload_1
    //   44: iconst_0
    //   45: invokespecial <init> : (II)V
    //   48: invokevirtual fromScreenLocation : (Landroid/graphics/Point;)Lcom/amap/api/maps2d/model/LatLng;
    //   51: astore #7
    //   53: aload_0
    //   54: new android/graphics/Point
    //   57: dup
    //   58: iconst_0
    //   59: iload_2
    //   60: invokespecial <init> : (II)V
    //   63: invokevirtual fromScreenLocation : (Landroid/graphics/Point;)Lcom/amap/api/maps2d/model/LatLng;
    //   66: astore #8
    //   68: aload_0
    //   69: new android/graphics/Point
    //   72: dup
    //   73: iload_1
    //   74: iload_2
    //   75: invokespecial <init> : (II)V
    //   78: invokevirtual fromScreenLocation : (Landroid/graphics/Point;)Lcom/amap/api/maps2d/model/LatLng;
    //   81: astore #4
    //   83: invokestatic builder : ()Lcom/amap/api/maps2d/model/LatLngBounds$Builder;
    //   86: aload #8
    //   88: invokevirtual include : (Lcom/amap/api/maps2d/model/LatLng;)Lcom/amap/api/maps2d/model/LatLngBounds$Builder;
    //   91: aload #4
    //   93: invokevirtual include : (Lcom/amap/api/maps2d/model/LatLng;)Lcom/amap/api/maps2d/model/LatLngBounds$Builder;
    //   96: aload #5
    //   98: invokevirtual include : (Lcom/amap/api/maps2d/model/LatLng;)Lcom/amap/api/maps2d/model/LatLngBounds$Builder;
    //   101: aload #7
    //   103: invokevirtual include : (Lcom/amap/api/maps2d/model/LatLng;)Lcom/amap/api/maps2d/model/LatLngBounds$Builder;
    //   106: invokevirtual build : ()Lcom/amap/api/maps2d/model/LatLngBounds;
    //   109: astore_3
    //   110: goto -> 213
    //   113: astore #6
    //   115: aload #4
    //   117: astore_3
    //   118: aload #6
    //   120: astore #4
    //   122: aload #5
    //   124: astore #6
    //   126: aload #8
    //   128: astore #5
    //   130: goto -> 188
    //   133: astore #4
    //   135: aconst_null
    //   136: astore_3
    //   137: aload #5
    //   139: astore #6
    //   141: aload #8
    //   143: astore #5
    //   145: goto -> 188
    //   148: astore #4
    //   150: aconst_null
    //   151: astore_3
    //   152: aload_3
    //   153: astore #8
    //   155: aload #5
    //   157: astore #6
    //   159: aload #8
    //   161: astore #5
    //   163: goto -> 188
    //   166: astore #4
    //   168: aload #5
    //   170: astore #6
    //   172: goto -> 180
    //   175: astore #4
    //   177: aconst_null
    //   178: astore #6
    //   180: aconst_null
    //   181: astore #5
    //   183: aconst_null
    //   184: astore_3
    //   185: aconst_null
    //   186: astore #7
    //   188: aload #4
    //   190: aload_0
    //   191: getfield a : Ljava/lang/String;
    //   194: ldc 'getVisibleRegion'
    //   196: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload #5
    //   201: astore #8
    //   203: aload #6
    //   205: astore #5
    //   207: aload_3
    //   208: astore #4
    //   210: aload #9
    //   212: astore_3
    //   213: new com/amap/api/maps2d/model/VisibleRegion
    //   216: dup
    //   217: aload #8
    //   219: aload #4
    //   221: aload #5
    //   223: aload #7
    //   225: aload_3
    //   226: invokespecial <init> : (Lcom/amap/api/maps2d/model/LatLng;Lcom/amap/api/maps2d/model/LatLng;Lcom/amap/api/maps2d/model/LatLng;Lcom/amap/api/maps2d/model/LatLng;Lcom/amap/api/maps2d/model/LatLngBounds;)V
    //   229: areturn
    // Exception table:
    //   from	to	target	type
    //   3	38	175	finally
    //   38	53	166	finally
    //   53	68	148	finally
    //   68	83	133	finally
    //   83	110	113	finally
  }
  
  public PointF toMapLocation(LatLng paramLatLng) throws RemoteException {
    s s = new s();
    this.b.a(paramLatLng.latitude, paramLatLng.longitude, s);
    return new PointF((float)s.a, (float)s.b);
  }
  
  public Point toScreenLocation(LatLng paramLatLng) throws RemoteException {
    if (paramLatLng == null)
      return null; 
    ae ae = new ae();
    this.b.b(paramLatLng.latitude, paramLatLng.longitude, ae);
    return new Point(ae.a, ae.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */