package com.amap.api.mapcore2d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

class ba {
  protected final a[] a;
  
  protected final int b;
  
  protected final int c;
  
  protected final a[] d;
  
  private boolean e = false;
  
  private long f = 0L;
  
  private an g;
  
  private Paint h = null;
  
  private Path i = null;
  
  public ba(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong, an paraman) {
    this.b = paramInt1;
    this.c = paramInt2;
    this.g = paraman;
    this.e = paramBoolean;
    this.f = paramLong * 1000000L;
    paramInt1 = this.b;
    if (paramInt1 > 0) {
      this.a = new a[paramInt1];
      this.d = new a[this.c];
      return;
    } 
    this.a = null;
    this.d = null;
  }
  
  private void a(Bitmap paramBitmap, List<bx> paramList) {
    j j = new j(this, paramList) {
        public void a(Canvas param1Canvas) {
          if (ba.a(this.b) == null) {
            ba.a(this.b, new Paint());
            ba.a(this.b).setStyle(Paint.Style.STROKE);
            ba.a(this.b).setDither(true);
            ba.a(this.b).setAntiAlias(true);
            ba.a(this.b).setStrokeJoin(Paint.Join.ROUND);
            ba.a(this.b).setStrokeCap(Paint.Cap.ROUND);
          } 
          if (ba.b(this.b) == null)
            ba.a(this.b, new Path()); 
          int k = this.a.size();
          for (int i = 0; i < k; i++) {
            bx bx = this.a.get(i);
            if (bx != null) {
              ba.a(this.b).setStrokeWidth(3.0F);
              int m = bx.b();
              if (m == 1) {
                ba.a(this.b).setColor(-65536);
              } else if (m == 2) {
                ba.a(this.b).setColor(-256);
              } else if (m == 3) {
                ba.a(this.b).setColor(-16711936);
              } 
              List<PointF> list = bx.a();
              int n = list.size();
              m = 0;
              boolean bool = true;
              while (m < n) {
                PointF pointF = list.get(m);
                if (pointF != null)
                  if (bool) {
                    ba.b(this.b).moveTo(pointF.x, pointF.y);
                    bool = false;
                  } else {
                    ba.b(this.b).lineTo(pointF.x, pointF.y);
                  }  
                m++;
              } 
              param1Canvas.drawPath(ba.b(this.b), ba.a(this.b));
              ba.b(this.b).reset();
            } 
          } 
        }
      };
    i i = new i(null);
    i.a(paramBitmap);
    i.a(j);
  }
  
  private long d() {
    return System.nanoTime();
  }
  
  protected int a() {
    int i;
    for (i = 0; i < this.c; i++)
      this.d[i] = null; 
    for (i = 0; i < this.b; i++) {
      a a1 = this.a[i];
      int k = 0;
      while (k < this.c) {
        a[] arrayOfA = this.d;
        if (arrayOfA[k] == null) {
          arrayOfA[k] = a1;
          break;
        } 
        a a2 = a1;
        if ((arrayOfA[k]).d > a1.d) {
          arrayOfA = this.d;
          a2 = arrayOfA[k];
          arrayOfA[k] = a1;
        } 
        k++;
        a1 = a2;
      } 
    } 
    i = 0;
    int j;
    for (j = -1; i < this.c; j = k) {
      a[] arrayOfA = this.d;
      int k = j;
      if (arrayOfA[i] != null) {
        (arrayOfA[i]).c = false;
        k = j;
        if (j < 0)
          k = (arrayOfA[i]).e; 
      } 
      i++;
    } 
    return j;
  }
  
  protected int a(String paramString) {
    if (paramString != null) {
      if (paramString.equals("") == true)
        return -1; 
      int i = 0;
      while (i < this.b) {
        a[] arrayOfA = this.a;
        if (arrayOfA[i] == null || (arrayOfA[i]).b == null || !(this.a[i]).b.equals(paramString)) {
          i++;
          continue;
        } 
        if (!(this.a[i]).c)
          return -1; 
        if (this.e == true && d() - (this.a[i]).f > this.f) {
          (this.a[i]).c = false;
          return -1;
        } 
        if ((this.a[i]).a == null)
          return -1; 
        (this.a[i]).d = d();
        return i;
      } 
    } 
    return -1;
  }
  
  protected int a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, boolean paramBoolean, List<bx> paramList, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 19
    //   6: aload_2
    //   7: ifnonnull -> 19
    //   10: aload #4
    //   12: ifnonnull -> 19
    //   15: aload_0
    //   16: monitorexit
    //   17: iconst_m1
    //   18: ireturn
    //   19: aload_0
    //   20: invokevirtual b : ()I
    //   23: istore #7
    //   25: iload #7
    //   27: istore #6
    //   29: iload #7
    //   31: ifge -> 47
    //   34: aload_0
    //   35: invokevirtual a : ()I
    //   38: istore #6
    //   40: goto -> 47
    //   43: astore_1
    //   44: goto -> 511
    //   47: iload #6
    //   49: ifge -> 56
    //   52: aload_0
    //   53: monitorexit
    //   54: iconst_m1
    //   55: ireturn
    //   56: iload #6
    //   58: istore #7
    //   60: aload_0
    //   61: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   64: astore #9
    //   66: aload #9
    //   68: ifnonnull -> 75
    //   71: aload_0
    //   72: monitorexit
    //   73: iconst_m1
    //   74: ireturn
    //   75: iload #6
    //   77: istore #7
    //   79: aload_0
    //   80: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   83: iload #6
    //   85: aaload
    //   86: ifnull -> 158
    //   89: iload #6
    //   91: istore #7
    //   93: aload_0
    //   94: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   97: iload #6
    //   99: aaload
    //   100: getfield a : Landroid/graphics/Bitmap;
    //   103: ifnull -> 158
    //   106: iload #6
    //   108: istore #7
    //   110: aload_0
    //   111: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   114: iload #6
    //   116: aaload
    //   117: getfield a : Landroid/graphics/Bitmap;
    //   120: invokevirtual isRecycled : ()Z
    //   123: ifne -> 158
    //   126: iload #6
    //   128: istore #7
    //   130: aload_0
    //   131: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   134: iload #6
    //   136: aaload
    //   137: getfield a : Landroid/graphics/Bitmap;
    //   140: invokevirtual recycle : ()V
    //   143: iload #6
    //   145: istore #7
    //   147: aload_0
    //   148: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   151: iload #6
    //   153: aaload
    //   154: aconst_null
    //   155: putfield a : Landroid/graphics/Bitmap;
    //   158: iload #6
    //   160: istore #7
    //   162: aload_0
    //   163: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   166: iload #6
    //   168: aaload
    //   169: getfield g : Ljava/util/List;
    //   172: ifnull -> 209
    //   175: iload #6
    //   177: istore #7
    //   179: aload_0
    //   180: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   183: iload #6
    //   185: aaload
    //   186: getfield g : Ljava/util/List;
    //   189: invokeinterface clear : ()V
    //   194: iload #6
    //   196: istore #7
    //   198: aload_0
    //   199: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   202: iload #6
    //   204: aaload
    //   205: aconst_null
    //   206: putfield g : Ljava/util/List;
    //   209: iload_3
    //   210: iconst_1
    //   211: if_icmpne -> 257
    //   214: aload_1
    //   215: ifnull -> 257
    //   218: aload_0
    //   219: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   222: iload #6
    //   224: aaload
    //   225: aload_1
    //   226: iconst_0
    //   227: aload_1
    //   228: arraylength
    //   229: invokestatic decodeByteArray : ([BII)Landroid/graphics/Bitmap;
    //   232: putfield a : Landroid/graphics/Bitmap;
    //   235: goto -> 294
    //   238: astore_1
    //   239: iload #6
    //   241: istore #7
    //   243: aload_1
    //   244: ldc 'BitmapManager'
    //   246: ldc 'setBitmapData'
    //   248: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   251: goto -> 294
    //   254: goto -> 294
    //   257: aload_2
    //   258: ifnull -> 294
    //   261: aload_0
    //   262: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   265: iload #6
    //   267: aaload
    //   268: aload_2
    //   269: iconst_0
    //   270: aload_2
    //   271: arraylength
    //   272: invokestatic decodeByteArray : ([BII)Landroid/graphics/Bitmap;
    //   275: putfield a : Landroid/graphics/Bitmap;
    //   278: goto -> 294
    //   281: astore_1
    //   282: iload #6
    //   284: istore #7
    //   286: aload_1
    //   287: ldc 'BitmapManager'
    //   289: ldc 'setBitmapData'
    //   291: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload #4
    //   296: ifnull -> 359
    //   299: iload #6
    //   301: istore #7
    //   303: aload_0
    //   304: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   307: iload #6
    //   309: aaload
    //   310: aload_0
    //   311: getfield g : Lcom/amap/api/mapcore2d/an;
    //   314: getfield a : Lcom/amap/api/mapcore2d/av;
    //   317: getfield a : I
    //   320: aload_0
    //   321: getfield g : Lcom/amap/api/mapcore2d/an;
    //   324: getfield a : Lcom/amap/api/mapcore2d/av;
    //   327: getfield a : I
    //   330: getstatic android/graphics/Bitmap$Config.ARGB_4444 : Landroid/graphics/Bitmap$Config;
    //   333: invokestatic createBitmap : (IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   336: putfield a : Landroid/graphics/Bitmap;
    //   339: iload #6
    //   341: istore #7
    //   343: aload_0
    //   344: aload_0
    //   345: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   348: iload #6
    //   350: aaload
    //   351: getfield a : Landroid/graphics/Bitmap;
    //   354: aload #4
    //   356: invokespecial a : (Landroid/graphics/Bitmap;Ljava/util/List;)V
    //   359: iload #6
    //   361: istore #7
    //   363: aload_0
    //   364: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   367: iload #6
    //   369: aaload
    //   370: getfield a : Landroid/graphics/Bitmap;
    //   373: ifnonnull -> 399
    //   376: iload #6
    //   378: istore #7
    //   380: aload_0
    //   381: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   384: iload #6
    //   386: aaload
    //   387: getfield g : Ljava/util/List;
    //   390: astore_1
    //   391: aload_1
    //   392: ifnonnull -> 399
    //   395: aload_0
    //   396: monitorexit
    //   397: iconst_m1
    //   398: ireturn
    //   399: iload #6
    //   401: istore #7
    //   403: iload #6
    //   405: istore #8
    //   407: aload_0
    //   408: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   411: iload #6
    //   413: aaload
    //   414: ifnull -> 523
    //   417: iload #6
    //   419: istore #7
    //   421: aload_0
    //   422: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   425: iload #6
    //   427: aaload
    //   428: iconst_1
    //   429: putfield c : Z
    //   432: iload #6
    //   434: istore #7
    //   436: aload_0
    //   437: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   440: iload #6
    //   442: aaload
    //   443: aload #5
    //   445: putfield b : Ljava/lang/String;
    //   448: iload #6
    //   450: istore #7
    //   452: aload_0
    //   453: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   456: iload #6
    //   458: aaload
    //   459: aload_0
    //   460: invokespecial d : ()J
    //   463: putfield d : J
    //   466: iload #6
    //   468: istore #7
    //   470: iload #6
    //   472: istore #8
    //   474: aload_0
    //   475: getfield e : Z
    //   478: iconst_1
    //   479: if_icmpne -> 523
    //   482: iload #6
    //   484: istore #7
    //   486: aload_0
    //   487: getfield a : [Lcom/amap/api/mapcore2d/ba$a;
    //   490: iload #6
    //   492: aaload
    //   493: aload_0
    //   494: invokespecial d : ()J
    //   497: putfield f : J
    //   500: iload #6
    //   502: istore #8
    //   504: goto -> 523
    //   507: astore_1
    //   508: iconst_m1
    //   509: istore #7
    //   511: aload_1
    //   512: ldc 'BitmapManager'
    //   514: ldc 'setBitmapData'
    //   516: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   519: iload #7
    //   521: istore #8
    //   523: aload_0
    //   524: monitorexit
    //   525: iload #8
    //   527: ireturn
    //   528: astore_1
    //   529: aload_0
    //   530: monitorexit
    //   531: aload_1
    //   532: athrow
    //   533: astore_1
    //   534: goto -> 254
    // Exception table:
    //   from	to	target	type
    //   19	25	507	finally
    //   34	40	43	finally
    //   60	66	43	finally
    //   79	89	43	finally
    //   93	106	43	finally
    //   110	126	43	finally
    //   130	143	43	finally
    //   147	158	43	finally
    //   162	175	43	finally
    //   179	194	43	finally
    //   198	209	43	finally
    //   218	235	533	java/lang/OutOfMemoryError
    //   218	235	238	finally
    //   243	251	43	finally
    //   261	278	533	java/lang/OutOfMemoryError
    //   261	278	281	finally
    //   286	294	43	finally
    //   303	339	43	finally
    //   343	359	43	finally
    //   363	376	43	finally
    //   380	391	43	finally
    //   407	417	43	finally
    //   421	432	43	finally
    //   436	448	43	finally
    //   452	466	43	finally
    //   474	482	43	finally
    //   486	500	43	finally
    //   511	519	528	finally
  }
  
  protected Bitmap a(int paramInt) {
    if (paramInt >= 0) {
      if (paramInt >= this.b)
        return null; 
      a[] arrayOfA = this.a;
      return (arrayOfA[paramInt] == null) ? null : (arrayOfA[paramInt]).a;
    } 
    return null;
  }
  
  protected int b() {
    int j = -1;
    int i = 0;
    while (i < this.b) {
      a[] arrayOfA = this.a;
      if (arrayOfA[i] == null) {
        arrayOfA[i] = new a(this);
        (this.a[i]).e = i;
        return i;
      } 
      int k = j;
      if (!(arrayOfA[i]).c) {
        k = j;
        if (j < 0)
          k = i; 
      } 
      i++;
      j = k;
    } 
    return j;
  }
  
  protected void c() {
    for (int i = 0; i < this.b; i++) {
      a[] arrayOfA = this.a;
      if (arrayOfA[i] != null) {
        if ((arrayOfA[i]).a != null && !(this.a[i]).a.isRecycled())
          (this.a[i]).a.recycle(); 
        (this.a[i]).a = null;
      } 
    } 
  }
  
  class a {
    Bitmap a = null;
    
    String b = "";
    
    boolean c = false;
    
    long d = 0L;
    
    int e = -1;
    
    long f = 0L;
    
    List<bx> g = null;
    
    public a(ba this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */