package com.amap.api.mapcore2d;

import android.graphics.Canvas;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.GroundOverlayOptions;
import com.amap.api.maps2d.model.PolygonOptions;
import com.amap.api.maps2d.model.PolylineOptions;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class v {
  private static int b;
  
  y a;
  
  private CopyOnWriteArrayList<ad> c = new CopyOnWriteArrayList<ad>();
  
  private a d = new a();
  
  private Handler e = new Handler();
  
  private Runnable f = new Runnable(this) {
      public void run() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield a : Lcom/amap/api/mapcore2d/v;
        //   6: invokestatic a : (Lcom/amap/api/mapcore2d/v;)Ljava/util/concurrent/CopyOnWriteArrayList;
        //   9: invokevirtual toArray : ()[Ljava/lang/Object;
        //   12: astore_3
        //   13: aload_3
        //   14: aload_0
        //   15: getfield a : Lcom/amap/api/mapcore2d/v;
        //   18: invokestatic b : (Lcom/amap/api/mapcore2d/v;)Lcom/amap/api/mapcore2d/v$a;
        //   21: invokestatic sort : ([Ljava/lang/Object;Ljava/util/Comparator;)V
        //   24: aload_0
        //   25: getfield a : Lcom/amap/api/mapcore2d/v;
        //   28: invokestatic a : (Lcom/amap/api/mapcore2d/v;)Ljava/util/concurrent/CopyOnWriteArrayList;
        //   31: invokevirtual clear : ()V
        //   34: aload_3
        //   35: arraylength
        //   36: istore_2
        //   37: iconst_0
        //   38: istore_1
        //   39: iload_1
        //   40: iload_2
        //   41: if_icmpge -> 81
        //   44: aload_3
        //   45: iload_1
        //   46: aaload
        //   47: astore #4
        //   49: aload_0
        //   50: getfield a : Lcom/amap/api/mapcore2d/v;
        //   53: invokestatic a : (Lcom/amap/api/mapcore2d/v;)Ljava/util/concurrent/CopyOnWriteArrayList;
        //   56: aload #4
        //   58: checkcast com/amap/api/mapcore2d/ad
        //   61: invokevirtual add : (Ljava/lang/Object;)Z
        //   64: pop
        //   65: iload_1
        //   66: iconst_1
        //   67: iadd
        //   68: istore_1
        //   69: goto -> 39
        //   72: astore_3
        //   73: aload_3
        //   74: ldc 'MapOverlayImageView'
        //   76: ldc 'changeOverlayIndex'
        //   78: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
        //   81: aload_0
        //   82: monitorexit
        //   83: return
        //   84: astore_3
        //   85: aload_0
        //   86: monitorexit
        //   87: aload_3
        //   88: athrow
        // Exception table:
        //   from	to	target	type
        //   2	37	72	finally
        //   49	65	72	finally
        //   73	81	84	finally
      }
    };
  
  public v(y paramy) {
    this.a = paramy;
  }
  
  public static String a(String paramString) {
    // Byte code:
    //   0: ldc com/amap/api/mapcore2d/v
    //   2: monitorenter
    //   3: getstatic com/amap/api/mapcore2d/v.b : I
    //   6: iconst_1
    //   7: iadd
    //   8: putstatic com/amap/api/mapcore2d/v.b : I
    //   11: new java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial <init> : ()V
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_1
    //   26: getstatic com/amap/api/mapcore2d/v.b : I
    //   29: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_1
    //   34: invokevirtual toString : ()Ljava/lang/String;
    //   37: astore_0
    //   38: ldc com/amap/api/mapcore2d/v
    //   40: monitorexit
    //   41: aload_0
    //   42: areturn
    //   43: astore_0
    //   44: ldc com/amap/api/mapcore2d/v
    //   46: monitorexit
    //   47: aload_0
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   3	38	43	finally
  }
  
  private ad c(String paramString) throws RemoteException {
    for (ad ad : this.c) {
      if (ad != null && ad.getId().equals(paramString))
        return ad; 
    } 
    return null;
  }
  
  private void c() {
    this.e.removeCallbacks(this.f);
    this.e.postDelayed(this.f, 10L);
  }
  
  public aa a(GroundOverlayOptions paramGroundOverlayOptions) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 10
    //   6: aload_0
    //   7: monitorexit
    //   8: aconst_null
    //   9: areturn
    //   10: new com/amap/api/mapcore2d/x
    //   13: dup
    //   14: aload_0
    //   15: getfield a : Lcom/amap/api/mapcore2d/y;
    //   18: invokespecial <init> : (Lcom/amap/api/mapcore2d/y;)V
    //   21: astore_2
    //   22: aload_2
    //   23: aload_1
    //   24: invokevirtual getAnchorU : ()F
    //   27: aload_1
    //   28: invokevirtual getAnchorV : ()F
    //   31: invokevirtual setAnchor : (FF)V
    //   34: aload_2
    //   35: aload_1
    //   36: invokevirtual getWidth : ()F
    //   39: aload_1
    //   40: invokevirtual getHeight : ()F
    //   43: invokevirtual setDimensions : (FF)V
    //   46: aload_2
    //   47: aload_1
    //   48: invokevirtual getImage : ()Lcom/amap/api/maps2d/model/BitmapDescriptor;
    //   51: invokevirtual setImage : (Lcom/amap/api/maps2d/model/BitmapDescriptor;)V
    //   54: aload_2
    //   55: aload_1
    //   56: invokevirtual getLocation : ()Lcom/amap/api/maps2d/model/LatLng;
    //   59: invokevirtual setPosition : (Lcom/amap/api/maps2d/model/LatLng;)V
    //   62: aload_2
    //   63: aload_1
    //   64: invokevirtual getBounds : ()Lcom/amap/api/maps2d/model/LatLngBounds;
    //   67: invokevirtual setPositionFromBounds : (Lcom/amap/api/maps2d/model/LatLngBounds;)V
    //   70: aload_2
    //   71: aload_1
    //   72: invokevirtual getBearing : ()F
    //   75: invokevirtual setBearing : (F)V
    //   78: aload_2
    //   79: aload_1
    //   80: invokevirtual getTransparency : ()F
    //   83: invokevirtual setTransparency : (F)V
    //   86: aload_2
    //   87: aload_1
    //   88: invokevirtual isVisible : ()Z
    //   91: invokevirtual setVisible : (Z)V
    //   94: aload_2
    //   95: aload_1
    //   96: invokevirtual getZIndex : ()F
    //   99: invokevirtual setZIndex : (F)V
    //   102: aload_0
    //   103: aload_2
    //   104: invokevirtual a : (Lcom/amap/api/mapcore2d/ad;)V
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_2
    //   110: areturn
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_1
    //   115: athrow
    // Exception table:
    //   from	to	target	type
    //   10	107	111	finally
  }
  
  public af a(PolygonOptions paramPolygonOptions) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 10
    //   6: aload_0
    //   7: monitorexit
    //   8: aconst_null
    //   9: areturn
    //   10: new com/amap/api/mapcore2d/be
    //   13: dup
    //   14: aload_0
    //   15: getfield a : Lcom/amap/api/mapcore2d/y;
    //   18: invokespecial <init> : (Lcom/amap/api/mapcore2d/y;)V
    //   21: astore_2
    //   22: aload_2
    //   23: aload_1
    //   24: invokevirtual getFillColor : ()I
    //   27: invokevirtual setFillColor : (I)V
    //   30: aload_2
    //   31: aload_1
    //   32: invokevirtual getPoints : ()Ljava/util/List;
    //   35: invokevirtual setPoints : (Ljava/util/List;)V
    //   38: aload_2
    //   39: aload_1
    //   40: invokevirtual isVisible : ()Z
    //   43: invokevirtual setVisible : (Z)V
    //   46: aload_2
    //   47: aload_1
    //   48: invokevirtual getStrokeWidth : ()F
    //   51: invokevirtual setStrokeWidth : (F)V
    //   54: aload_2
    //   55: aload_1
    //   56: invokevirtual getZIndex : ()F
    //   59: invokevirtual setZIndex : (F)V
    //   62: aload_2
    //   63: aload_1
    //   64: invokevirtual getStrokeColor : ()I
    //   67: invokevirtual setStrokeColor : (I)V
    //   70: aload_0
    //   71: aload_2
    //   72: invokevirtual a : (Lcom/amap/api/mapcore2d/ad;)V
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_2
    //   78: areturn
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Exception table:
    //   from	to	target	type
    //   10	75	79	finally
  }
  
  public ag a(PolylineOptions paramPolylineOptions) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 10
    //   6: aload_0
    //   7: monitorexit
    //   8: aconst_null
    //   9: areturn
    //   10: new com/amap/api/mapcore2d/bf
    //   13: dup
    //   14: aload_0
    //   15: getfield a : Lcom/amap/api/mapcore2d/y;
    //   18: invokespecial <init> : (Lcom/amap/api/mapcore2d/y;)V
    //   21: astore_2
    //   22: aload_2
    //   23: aload_1
    //   24: invokevirtual getColor : ()I
    //   27: invokevirtual setColor : (I)V
    //   30: aload_2
    //   31: aload_1
    //   32: invokevirtual isDottedLine : ()Z
    //   35: invokevirtual setDottedLine : (Z)V
    //   38: aload_2
    //   39: aload_1
    //   40: invokevirtual isGeodesic : ()Z
    //   43: invokevirtual setGeodesic : (Z)V
    //   46: aload_2
    //   47: aload_1
    //   48: invokevirtual getPoints : ()Ljava/util/List;
    //   51: invokevirtual setPoints : (Ljava/util/List;)V
    //   54: aload_2
    //   55: aload_1
    //   56: invokevirtual isVisible : ()Z
    //   59: invokevirtual setVisible : (Z)V
    //   62: aload_2
    //   63: aload_1
    //   64: invokevirtual getWidth : ()F
    //   67: invokevirtual setWidth : (F)V
    //   70: aload_2
    //   71: aload_1
    //   72: invokevirtual getZIndex : ()F
    //   75: invokevirtual setZIndex : (F)V
    //   78: aload_0
    //   79: aload_2
    //   80: invokevirtual a : (Lcom/amap/api/mapcore2d/ad;)V
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_2
    //   86: areturn
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Exception table:
    //   from	to	target	type
    //   10	83	87	finally
  }
  
  public z a(CircleOptions paramCircleOptions) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 10
    //   6: aload_0
    //   7: monitorexit
    //   8: aconst_null
    //   9: areturn
    //   10: new com/amap/api/mapcore2d/o
    //   13: dup
    //   14: aload_0
    //   15: getfield a : Lcom/amap/api/mapcore2d/y;
    //   18: invokespecial <init> : (Lcom/amap/api/mapcore2d/y;)V
    //   21: astore_2
    //   22: aload_2
    //   23: aload_1
    //   24: invokevirtual getFillColor : ()I
    //   27: invokevirtual setFillColor : (I)V
    //   30: aload_2
    //   31: aload_1
    //   32: invokevirtual getCenter : ()Lcom/amap/api/maps2d/model/LatLng;
    //   35: invokevirtual setCenter : (Lcom/amap/api/maps2d/model/LatLng;)V
    //   38: aload_2
    //   39: aload_1
    //   40: invokevirtual isVisible : ()Z
    //   43: invokevirtual setVisible : (Z)V
    //   46: aload_2
    //   47: aload_1
    //   48: invokevirtual getStrokeWidth : ()F
    //   51: invokevirtual setStrokeWidth : (F)V
    //   54: aload_2
    //   55: aload_1
    //   56: invokevirtual getZIndex : ()F
    //   59: invokevirtual setZIndex : (F)V
    //   62: aload_2
    //   63: aload_1
    //   64: invokevirtual getStrokeColor : ()I
    //   67: invokevirtual setStrokeColor : (I)V
    //   70: aload_2
    //   71: aload_1
    //   72: invokevirtual getRadius : ()D
    //   75: invokevirtual setRadius : (D)V
    //   78: aload_0
    //   79: aload_2
    //   80: invokevirtual a : (Lcom/amap/api/mapcore2d/ad;)V
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_2
    //   86: areturn
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Exception table:
    //   from	to	target	type
    //   10	83	87	finally
  }
  
  public void a() {
    Iterator<ad> iterator = this.c.iterator();
    while (iterator.hasNext())
      ((ad)iterator.next()).destroy(); 
    try {
      iterator = this.c.iterator();
      while (iterator.hasNext())
        ((ad)iterator.next()).destroy(); 
      this.c.clear();
      return;
    } catch (Exception exception) {
      cm.a(exception, "GLOverlayLayer", "clear");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("GLOverlayLayer clear erro");
      stringBuilder.append(exception.getMessage());
      Log.d("amapApi", stringBuilder.toString());
      return;
    } 
  }
  
  public void a(Canvas paramCanvas) {
    Object[] arrayOfObject = this.c.toArray();
    Arrays.sort(arrayOfObject, this.d);
    this.c.clear();
    int j = arrayOfObject.length;
    int i;
    for (i = 0; i < j; i++)
      Object object = arrayOfObject[i]; 
    i = this.c.size();
    for (ad ad : this.c) {
      try {
        if (ad.isVisible()) {
          if (i > 20) {
            if (ad.a())
              ad.a(paramCanvas); 
            continue;
          } 
          ad.a(paramCanvas);
        } 
      } catch (RemoteException remoteException) {
        cm.a((Throwable)remoteException, "GLOverlayLayer", "draw");
      } 
    } 
  }
  
  public void a(ad paramad) throws RemoteException {
    try {
      b(paramad.getId());
      return;
    } finally {
      paramad = null;
      cm.a((Throwable)paramad, "GLOverlayLayer", "addOverlay");
    } 
  }
  
  public void b() {
    try {
      Iterator<ad> iterator = this.c.iterator();
      while (iterator.hasNext())
        ((ad)iterator.next()).destroy(); 
      a();
      return;
    } catch (Exception exception) {
      cm.a(exception, "GLOverlayLayer", "destory");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("GLOverlayLayer destory erro");
      stringBuilder.append(exception.getMessage());
      Log.d("amapApi", stringBuilder.toString());
      return;
    } 
  }
  
  public boolean b(String paramString) throws RemoteException {
    try {
      ad ad = c(paramString);
    } finally {
      paramString = null;
    } 
    return false;
  }
  
  class a implements Comparator<Object> {
    private a(v this$0) {}
    
    public int compare(Object param1Object1, Object param1Object2) {
      param1Object1 = param1Object1;
      param1Object2 = param1Object2;
      if (param1Object1 != null && param1Object2 != null)
        try {
          if (param1Object1.getZIndex() > param1Object2.getZIndex())
            return 1; 
          float f1 = param1Object1.getZIndex();
          float f2 = param1Object2.getZIndex();
          if (f1 < f2)
            return -1; 
        } catch (Exception exception) {
          cm.a(exception, "GLOverlayLayer", "compare");
        }  
      return 0;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */