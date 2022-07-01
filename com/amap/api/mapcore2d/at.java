package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class at extends View {
  b a;
  
  a b = new a();
  
  private ArrayList<aj> c = new ArrayList<aj>(8);
  
  private ArrayList<ab> d = new ArrayList<ab>(8);
  
  private volatile int e = 0;
  
  private Handler f = new Handler();
  
  private Runnable g = new Runnable(this) {
      public void run() {
        /* monitor enter ThisExpression{InnerObjectType{ObjectType{com/amap/api/mapcore2d/at}.Lcom/amap/api/mapcore2d/at$1;}} */
        try {
          Collections.sort(at.a(this.a), this.a.b);
          Collections.sort(at.b(this.a), this.a.b);
          this.a.postInvalidate();
        } finally {
          Exception exception = null;
        } 
      }
    };
  
  private ae h;
  
  private ab i;
  
  private ab j = null;
  
  private float k = 0.0F;
  
  private CopyOnWriteArrayList<Integer> l = new CopyOnWriteArrayList<Integer>();
  
  public at(Context paramContext, AttributeSet paramAttributeSet, b paramb) {
    super(paramContext, paramAttributeSet);
    this.a = paramb;
  }
  
  private aj a(Iterator<aj> paramIterator, Rect paramRect, ae paramae) {
    while (paramIterator.hasNext()) {
      aj aj = paramIterator.next();
      LatLng latLng = aj.getPosition();
      if (latLng == null)
        continue; 
      this.a.b(latLng.latitude, latLng.longitude, paramae);
      if (a(paramRect, paramae.a, paramae.b))
        return aj; 
    } 
    return null;
  }
  
  private ab b(Iterator<ab> paramIterator, Rect paramRect, ae paramae) {
    while (paramIterator.hasNext()) {
      ab ab1 = paramIterator.next();
      LatLng latLng = ab1.getRealPosition();
      if (latLng == null)
        continue; 
      this.a.b(latLng.latitude, latLng.longitude, paramae);
      if (a(paramRect, paramae.a, paramae.b))
        return ab1; 
    } 
    return null;
  }
  
  private int h() {
    int i = this.e;
    this.e = i + 1;
    return i;
  }
  
  private void i() {
    for (ab ab1 : this.d) {
      if (ab1 != null) {
        ab ab2 = this.i;
        if (ab2 != null && ab2.getId().equals(ab1.getId())) {
          try {
            boolean bool = this.i.isViewMode();
            if (bool)
              return; 
          } catch (RemoteException remoteException) {
            cm.a((Throwable)remoteException, "MapOverlayImageView", "redrawInfoWindow");
          } 
          Rect rect = ab1.a();
          this.h = new ae(rect.left + ab1.getWidth() / 2, rect.top);
          this.a.redrawInfoWindow();
        } 
      } 
    } 
  }
  
  public ab a(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Ljava/util/ArrayList;
    //   6: invokevirtual size : ()I
    //   9: iconst_1
    //   10: isub
    //   11: istore_2
    //   12: iload_2
    //   13: iflt -> 75
    //   16: aload_0
    //   17: getfield d : Ljava/util/ArrayList;
    //   20: iload_2
    //   21: invokevirtual get : (I)Ljava/lang/Object;
    //   24: checkcast com/amap/api/mapcore2d/ab
    //   27: astore #4
    //   29: aload #4
    //   31: ifnonnull -> 37
    //   34: goto -> 68
    //   37: aload_0
    //   38: aload #4
    //   40: invokeinterface a : ()Landroid/graphics/Rect;
    //   45: aload_1
    //   46: invokevirtual getX : ()F
    //   49: f2i
    //   50: aload_1
    //   51: invokevirtual getY : ()F
    //   54: f2i
    //   55: invokevirtual a : (Landroid/graphics/Rect;II)Z
    //   58: istore_3
    //   59: iload_3
    //   60: ifeq -> 68
    //   63: aload_0
    //   64: monitorexit
    //   65: aload #4
    //   67: areturn
    //   68: iload_2
    //   69: iconst_1
    //   70: isub
    //   71: istore_2
    //   72: goto -> 12
    //   75: aload_0
    //   76: monitorexit
    //   77: aconst_null
    //   78: areturn
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	79	finally
    //   16	29	79	finally
    //   37	59	79	finally
  }
  
  public ab a(String paramString) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Ljava/util/ArrayList;
    //   6: invokevirtual iterator : ()Ljava/util/Iterator;
    //   9: astore_3
    //   10: aload_3
    //   11: invokeinterface hasNext : ()Z
    //   16: ifeq -> 56
    //   19: aload_3
    //   20: invokeinterface next : ()Ljava/lang/Object;
    //   25: checkcast com/amap/api/mapcore2d/ab
    //   28: astore #4
    //   30: aload #4
    //   32: ifnull -> 10
    //   35: aload #4
    //   37: invokeinterface getId : ()Ljava/lang/String;
    //   42: aload_1
    //   43: invokevirtual equals : (Ljava/lang/Object;)Z
    //   46: istore_2
    //   47: iload_2
    //   48: ifeq -> 10
    //   51: aload_0
    //   52: monitorexit
    //   53: aload #4
    //   55: areturn
    //   56: aload_0
    //   57: monitorexit
    //   58: aconst_null
    //   59: areturn
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	60	finally
    //   10	30	60	finally
    //   35	47	60	finally
  }
  
  public b a() {
    return this.a;
  }
  
  public void a(Canvas paramCanvas) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial i : ()V
    //   6: new android/graphics/Rect
    //   9: dup
    //   10: iconst_0
    //   11: iconst_0
    //   12: aload_0
    //   13: getfield a : Lcom/amap/api/mapcore2d/b;
    //   16: invokevirtual getMapWidth : ()I
    //   19: aload_0
    //   20: getfield a : Lcom/amap/api/mapcore2d/b;
    //   23: invokevirtual getMapHeight : ()I
    //   26: invokespecial <init> : (IIII)V
    //   29: astore #4
    //   31: new com/amap/api/mapcore2d/ae
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: astore #5
    //   40: aload_0
    //   41: getfield d : Ljava/util/ArrayList;
    //   44: invokevirtual iterator : ()Ljava/util/Iterator;
    //   47: astore #6
    //   49: aload_0
    //   50: getfield c : Ljava/util/ArrayList;
    //   53: invokevirtual iterator : ()Ljava/util/Iterator;
    //   56: astore #7
    //   58: aload_0
    //   59: aload #6
    //   61: aload #4
    //   63: aload #5
    //   65: invokespecial b : (Ljava/util/Iterator;Landroid/graphics/Rect;Lcom/amap/api/mapcore2d/ae;)Lcom/amap/api/mapcore2d/ab;
    //   68: astore_3
    //   69: aload_0
    //   70: aload #7
    //   72: aload #4
    //   74: aload #5
    //   76: invokespecial a : (Ljava/util/Iterator;Landroid/graphics/Rect;Lcom/amap/api/mapcore2d/ae;)Lcom/amap/api/mapcore2d/aj;
    //   79: astore_2
    //   80: aload_3
    //   81: ifnonnull -> 94
    //   84: aload_2
    //   85: ifnull -> 91
    //   88: goto -> 94
    //   91: aload_0
    //   92: monitorexit
    //   93: return
    //   94: aload_3
    //   95: ifnonnull -> 119
    //   98: aload_2
    //   99: aload_1
    //   100: invokeinterface draw : (Landroid/graphics/Canvas;)V
    //   105: aload_0
    //   106: aload #7
    //   108: aload #4
    //   110: aload #5
    //   112: invokespecial a : (Ljava/util/Iterator;Landroid/graphics/Rect;Lcom/amap/api/mapcore2d/ae;)Lcom/amap/api/mapcore2d/aj;
    //   115: astore_2
    //   116: goto -> 80
    //   119: aload_2
    //   120: ifnonnull -> 148
    //   123: aload_3
    //   124: aload_1
    //   125: aload_0
    //   126: getfield a : Lcom/amap/api/mapcore2d/b;
    //   129: invokeinterface a : (Landroid/graphics/Canvas;Lcom/amap/api/mapcore2d/y;)V
    //   134: aload_0
    //   135: aload #6
    //   137: aload #4
    //   139: aload #5
    //   141: invokespecial b : (Ljava/util/Iterator;Landroid/graphics/Rect;Lcom/amap/api/mapcore2d/ae;)Lcom/amap/api/mapcore2d/ab;
    //   144: astore_3
    //   145: goto -> 80
    //   148: aload_3
    //   149: invokeinterface getZIndex : ()F
    //   154: aload_2
    //   155: invokeinterface getZIndex : ()F
    //   160: fcmpg
    //   161: iflt -> 219
    //   164: aload_3
    //   165: invokeinterface getZIndex : ()F
    //   170: aload_2
    //   171: invokeinterface getZIndex : ()F
    //   176: fcmpl
    //   177: ifne -> 198
    //   180: aload_3
    //   181: invokeinterface getAddIndex : ()I
    //   186: aload_2
    //   187: invokeinterface getAddIndex : ()I
    //   192: if_icmpge -> 198
    //   195: goto -> 219
    //   198: aload_2
    //   199: aload_1
    //   200: invokeinterface draw : (Landroid/graphics/Canvas;)V
    //   205: aload_0
    //   206: aload #7
    //   208: aload #4
    //   210: aload #5
    //   212: invokespecial a : (Ljava/util/Iterator;Landroid/graphics/Rect;Lcom/amap/api/mapcore2d/ae;)Lcom/amap/api/mapcore2d/aj;
    //   215: astore_2
    //   216: goto -> 80
    //   219: aload_3
    //   220: aload_1
    //   221: aload_0
    //   222: getfield a : Lcom/amap/api/mapcore2d/b;
    //   225: invokeinterface a : (Landroid/graphics/Canvas;Lcom/amap/api/mapcore2d/y;)V
    //   230: aload_0
    //   231: aload #6
    //   233: aload #4
    //   235: aload #5
    //   237: invokespecial b : (Ljava/util/Iterator;Landroid/graphics/Rect;Lcom/amap/api/mapcore2d/ae;)Lcom/amap/api/mapcore2d/ab;
    //   240: astore_3
    //   241: goto -> 80
    //   244: astore_1
    //   245: aload_0
    //   246: monitorexit
    //   247: aload_1
    //   248: athrow
    // Exception table:
    //   from	to	target	type
    //   2	80	244	finally
    //   98	116	244	finally
    //   123	145	244	finally
    //   148	195	244	finally
    //   198	216	244	finally
    //   219	241	244	finally
  }
  
  public void a(ab paramab) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual e : (Lcom/amap/api/mapcore2d/ab;)V
    //   7: aload_1
    //   8: aload_0
    //   9: invokespecial h : ()I
    //   12: invokeinterface setAddIndex : (I)V
    //   17: aload_0
    //   18: getfield d : Ljava/util/ArrayList;
    //   21: aload_1
    //   22: invokevirtual remove : (Ljava/lang/Object;)Z
    //   25: pop
    //   26: aload_0
    //   27: getfield d : Ljava/util/ArrayList;
    //   30: aload_1
    //   31: invokevirtual add : (Ljava/lang/Object;)Z
    //   34: pop
    //   35: aload_0
    //   36: getfield d : Ljava/util/ArrayList;
    //   39: aload_0
    //   40: getfield b : Lcom/amap/api/mapcore2d/at$a;
    //   43: invokestatic sort : (Ljava/util/List;Ljava/util/Comparator;)V
    //   46: goto -> 58
    //   49: astore_1
    //   50: aload_1
    //   51: ldc 'MapOverlayImageView'
    //   53: ldc 'addMarker'
    //   55: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Exception table:
    //   from	to	target	type
    //   2	46	49	finally
    //   50	58	61	finally
  }
  
  public void a(aj paramaj) throws RemoteException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Ljava/util/ArrayList;
    //   6: aload_1
    //   7: invokevirtual remove : (Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_1
    //   12: aload_0
    //   13: invokespecial h : ()I
    //   16: invokeinterface setAddIndex : (I)V
    //   21: aload_0
    //   22: getfield c : Ljava/util/ArrayList;
    //   25: aload_1
    //   26: invokevirtual add : (Ljava/lang/Object;)Z
    //   29: pop
    //   30: aload_0
    //   31: getfield c : Ljava/util/ArrayList;
    //   34: aload_0
    //   35: getfield b : Lcom/amap/api/mapcore2d/at$a;
    //   38: invokestatic sort : (Ljava/util/List;Ljava/util/Comparator;)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   2	41	44	finally
  }
  
  public boolean a(Rect paramRect, int paramInt1, int paramInt2) {
    return paramRect.contains(paramInt1, paramInt2);
  }
  
  protected int b() {
    return this.d.size();
  }
  
  public void b(aj paramaj) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Ljava/util/ArrayList;
    //   6: aload_1
    //   7: invokevirtual remove : (Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: invokevirtual postInvalidate : ()V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	18	finally
  }
  
  public boolean b(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore #4
    //   5: aload_0
    //   6: getfield d : Ljava/util/ArrayList;
    //   9: invokevirtual size : ()I
    //   12: iconst_1
    //   13: isub
    //   14: istore_2
    //   15: iload #4
    //   17: istore_3
    //   18: iload_2
    //   19: iflt -> 120
    //   22: aload_0
    //   23: getfield d : Ljava/util/ArrayList;
    //   26: iload_2
    //   27: invokevirtual get : (I)Ljava/lang/Object;
    //   30: checkcast com/amap/api/mapcore2d/ab
    //   33: astore #5
    //   35: aload #5
    //   37: ifnonnull -> 43
    //   40: goto -> 113
    //   43: aload #5
    //   45: invokeinterface a : ()Landroid/graphics/Rect;
    //   50: astore #6
    //   52: aload_0
    //   53: aload #6
    //   55: aload_1
    //   56: invokevirtual getX : ()F
    //   59: f2i
    //   60: aload_1
    //   61: invokevirtual getY : ()F
    //   64: f2i
    //   65: invokevirtual a : (Landroid/graphics/Rect;II)Z
    //   68: istore_3
    //   69: iload_3
    //   70: ifeq -> 113
    //   73: aload_0
    //   74: new com/amap/api/mapcore2d/ae
    //   77: dup
    //   78: aload #6
    //   80: getfield left : I
    //   83: aload #5
    //   85: invokeinterface getWidth : ()I
    //   90: iconst_2
    //   91: idiv
    //   92: iadd
    //   93: aload #6
    //   95: getfield top : I
    //   98: invokespecial <init> : (II)V
    //   101: putfield h : Lcom/amap/api/mapcore2d/ae;
    //   104: aload_0
    //   105: aload #5
    //   107: putfield i : Lcom/amap/api/mapcore2d/ab;
    //   110: goto -> 120
    //   113: iload_2
    //   114: iconst_1
    //   115: isub
    //   116: istore_2
    //   117: goto -> 15
    //   120: aload_0
    //   121: monitorexit
    //   122: iload_3
    //   123: ireturn
    //   124: astore_1
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    // Exception table:
    //   from	to	target	type
    //   5	15	124	finally
    //   22	35	124	finally
    //   43	69	124	finally
    //   73	110	124	finally
  }
  
  public boolean b(ab paramab) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual e : (Lcom/amap/api/mapcore2d/ab;)V
    //   7: aload_0
    //   8: getfield d : Ljava/util/ArrayList;
    //   11: aload_1
    //   12: invokevirtual remove : (Ljava/lang/Object;)Z
    //   15: istore_2
    //   16: aload_0
    //   17: invokevirtual postInvalidate : ()V
    //   20: aload_0
    //   21: getfield a : Lcom/amap/api/mapcore2d/b;
    //   24: invokevirtual postInvalidate : ()V
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_2
    //   30: ireturn
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	31	finally
  }
  
  public void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Ljava/util/ArrayList;
    //   6: ifnull -> 50
    //   9: aload_0
    //   10: getfield d : Ljava/util/ArrayList;
    //   13: invokevirtual iterator : ()Ljava/util/Iterator;
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface hasNext : ()Z
    //   23: ifeq -> 43
    //   26: aload_1
    //   27: invokeinterface next : ()Ljava/lang/Object;
    //   32: checkcast com/amap/api/mapcore2d/ab
    //   35: invokeinterface destroy : ()V
    //   40: goto -> 17
    //   43: aload_0
    //   44: getfield d : Ljava/util/ArrayList;
    //   47: invokevirtual clear : ()V
    //   50: aload_0
    //   51: getfield c : Ljava/util/ArrayList;
    //   54: ifnull -> 64
    //   57: aload_0
    //   58: getfield c : Ljava/util/ArrayList;
    //   61: invokevirtual clear : ()V
    //   64: aload_0
    //   65: getfield a : Lcom/amap/api/mapcore2d/b;
    //   68: invokevirtual postInvalidate : ()V
    //   71: goto -> 84
    //   74: astore_1
    //   75: aload_1
    //   76: ldc 'MapOverlayImageView'
    //   78: ldc_w 'clear'
    //   81: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_0
    //   85: monitorexit
    //   86: return
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	74	finally
    //   17	40	74	finally
    //   43	50	74	finally
    //   50	64	74	finally
    //   64	71	74	finally
    //   75	84	87	finally
  }
  
  public void c(ab paramab) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 89
    //   6: aload_0
    //   7: getfield j : Lcom/amap/api/mapcore2d/ab;
    //   10: aload_1
    //   11: if_acmpne -> 17
    //   14: goto -> 89
    //   17: aload_0
    //   18: getfield j : Lcom/amap/api/mapcore2d/ab;
    //   21: ifnull -> 53
    //   24: aload_0
    //   25: getfield j : Lcom/amap/api/mapcore2d/ab;
    //   28: invokeinterface getZIndex : ()F
    //   33: ldc_w 2.14748365E9
    //   36: fcmpl
    //   37: ifne -> 53
    //   40: aload_0
    //   41: getfield j : Lcom/amap/api/mapcore2d/ab;
    //   44: aload_0
    //   45: getfield k : F
    //   48: invokeinterface setZIndex : (F)V
    //   53: aload_0
    //   54: aload_1
    //   55: invokeinterface getZIndex : ()F
    //   60: putfield k : F
    //   63: aload_0
    //   64: aload_1
    //   65: putfield j : Lcom/amap/api/mapcore2d/ab;
    //   68: aload_1
    //   69: ldc_w 2.14748365E9
    //   72: invokeinterface setZIndex : (F)V
    //   77: aload_0
    //   78: invokevirtual d : ()V
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    //   89: aload_0
    //   90: monitorexit
    //   91: return
    // Exception table:
    //   from	to	target	type
    //   6	14	84	finally
    //   17	53	84	finally
    //   53	81	84	finally
  }
  
  void d() {
    this.f.removeCallbacks(this.g);
    this.f.postDelayed(this.g, 5L);
  }
  
  public void d(ab paramab) {
    if (paramab == null)
      return; 
    if (this.h == null)
      this.h = new ae(); 
    Rect rect = paramab.a();
    this.h = new ae(rect.left + paramab.getWidth() / 2, rect.top);
    this.i = paramab;
    try {
      return;
    } finally {
      paramab = null;
      cm.a((Throwable)paramab, "MapOverlayImageView", "showInfoWindow");
    } 
  }
  
  public ab e() {
    return this.i;
  }
  
  public void e(ab paramab) {
    if (f(paramab))
      this.a.e(); 
  }
  
  public void f() {
    try {
      if (this.f != null)
        this.f.removeCallbacksAndMessages(null); 
      c();
      return;
    } catch (Exception exception) {
      cm.a(exception, "MapOverlayImageView", "destory");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("MapOverlayImageView clear erro");
      stringBuilder.append(exception.getMessage());
      Log.d("amapApi", stringBuilder.toString());
      return;
    } 
  }
  
  public boolean f(ab paramab) {
    return this.a.b(paramab);
  }
  
  public List<Marker> g() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_1
    //   10: new android/graphics/Rect
    //   13: dup
    //   14: iconst_0
    //   15: iconst_0
    //   16: aload_0
    //   17: getfield a : Lcom/amap/api/mapcore2d/b;
    //   20: invokevirtual getMapWidth : ()I
    //   23: aload_0
    //   24: getfield a : Lcom/amap/api/mapcore2d/b;
    //   27: invokevirtual getMapHeight : ()I
    //   30: invokespecial <init> : (IIII)V
    //   33: astore_2
    //   34: new com/amap/api/mapcore2d/ae
    //   37: dup
    //   38: invokespecial <init> : ()V
    //   41: astore_3
    //   42: aload_0
    //   43: getfield d : Ljava/util/ArrayList;
    //   46: invokevirtual iterator : ()Ljava/util/Iterator;
    //   49: astore #4
    //   51: aload #4
    //   53: invokeinterface hasNext : ()Z
    //   58: ifeq -> 143
    //   61: aload #4
    //   63: invokeinterface next : ()Ljava/lang/Object;
    //   68: checkcast com/amap/api/mapcore2d/ab
    //   71: astore #5
    //   73: aload #5
    //   75: invokeinterface getRealPosition : ()Lcom/amap/api/maps2d/model/LatLng;
    //   80: astore #6
    //   82: aload #6
    //   84: ifnonnull -> 90
    //   87: goto -> 143
    //   90: aload_0
    //   91: getfield a : Lcom/amap/api/mapcore2d/b;
    //   94: aload #6
    //   96: getfield latitude : D
    //   99: aload #6
    //   101: getfield longitude : D
    //   104: aload_3
    //   105: invokevirtual b : (DDLcom/amap/api/mapcore2d/ae;)V
    //   108: aload_0
    //   109: aload_2
    //   110: aload_3
    //   111: getfield a : I
    //   114: aload_3
    //   115: getfield b : I
    //   118: invokevirtual a : (Landroid/graphics/Rect;II)Z
    //   121: ifeq -> 51
    //   124: aload_1
    //   125: new com/amap/api/maps2d/model/Marker
    //   128: dup
    //   129: aload #5
    //   131: invokespecial <init> : (Lcom/amap/api/interfaces/IMarker;)V
    //   134: invokeinterface add : (Ljava/lang/Object;)Z
    //   139: pop
    //   140: goto -> 51
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_1
    //   146: areturn
    //   147: astore_1
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_1
    //   151: athrow
    // Exception table:
    //   from	to	target	type
    //   2	51	147	finally
    //   51	82	147	finally
    //   90	140	147	finally
  }
  
  static class a implements Serializable, Comparator<ac> {
    public int a(ac param1ac1, ac param1ac2) {
      if (param1ac1 != null && param1ac2 != null)
        try {
          if (param1ac1.getZIndex() > param1ac2.getZIndex())
            return 1; 
          float f1 = param1ac1.getZIndex();
          float f2 = param1ac2.getZIndex();
        } finally {
          param1ac1 = null;
        }  
      return 0;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */