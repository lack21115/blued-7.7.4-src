package com.qiniu.pili.droid.shortvideo.process.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.qiniu.pili.droid.shortvideo.PLBuiltinFilter;
import com.qiniu.pili.droid.shortvideo.PLGifWatermarkSetting;
import com.qiniu.pili.droid.shortvideo.PLWatermarkSetting;
import com.qiniu.pili.droid.shortvideo.c.a.a;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.gl.c.b;
import com.qiniu.pili.droid.shortvideo.gl.c.c;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class d {
  private Context a;
  
  private boolean b = false;
  
  private boolean c = true;
  
  private int d;
  
  private int e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private PLWatermarkSetting i;
  
  private ConcurrentHashMap<PLGifWatermarkSetting, b> j;
  
  private PLWatermarkSetting k;
  
  private PLWatermarkSetting l;
  
  private a m;
  
  private c n;
  
  private com.qiniu.pili.droid.shortvideo.gl.c.d o;
  
  private com.qiniu.pili.droid.shortvideo.gl.c.d p;
  
  private com.qiniu.pili.droid.shortvideo.gl.c.d q;
  
  private volatile boolean r;
  
  private boolean s = true;
  
  private ConcurrentHashMap<String, Runnable> t = new ConcurrentHashMap<String, Runnable>();
  
  public d(Context paramContext) {
    this.a = paramContext;
    QosManager.a(this.a).a(QosManager.KeyPoint.filter_init);
  }
  
  private void a(com.qiniu.pili.droid.shortvideo.gl.c.d paramd, PLWatermarkSetting paramPLWatermarkSetting, boolean paramBoolean, int paramInt1, int paramInt2) {
    paramd.c(paramBoolean);
    paramd.a(paramPLWatermarkSetting.getAlpha() / 255.0F);
    paramd.b(paramPLWatermarkSetting.getX(), paramPLWatermarkSetting.getY());
    if (paramPLWatermarkSetting.getWidth() > 0.0F && paramPLWatermarkSetting.getHeight() > 0.0F)
      paramd.a(paramPLWatermarkSetting.getWidth(), paramPLWatermarkSetting.getHeight()); 
    if (paramBoolean)
      paramd.a(paramInt1, paramInt2); 
    paramd.h();
  }
  
  private boolean a(PLGifWatermarkSetting paramPLGifWatermarkSetting, long paramLong) {
    return (paramLong >= paramPLGifWatermarkSetting.getStartTimeMs() && paramLong <= paramPLGifWatermarkSetting.getStartTimeMs() + paramPLGifWatermarkSetting.getDurationMs());
  }
  
  private com.qiniu.pili.droid.shortvideo.gl.c.d d(PLWatermarkSetting paramPLWatermarkSetting) {
    int i;
    int j;
    Bitmap bitmap2 = paramPLWatermarkSetting.getBitmap();
    Bitmap bitmap1 = bitmap2;
    if (bitmap2 == null)
      bitmap1 = BitmapFactory.decodeResource(this.a.getResources(), paramPLWatermarkSetting.getResourceId()); 
    com.qiniu.pili.droid.shortvideo.gl.c.d d1 = new com.qiniu.pili.droid.shortvideo.gl.c.d(bitmap1);
    d1.a(paramPLWatermarkSetting.getAlpha() / 255.0F);
    d1.b(paramPLWatermarkSetting.getX(), paramPLWatermarkSetting.getY());
    if (paramPLWatermarkSetting.getWidth() > 0.0F && paramPLWatermarkSetting.getHeight() > 0.0F)
      d1.a(paramPLWatermarkSetting.getWidth(), paramPLWatermarkSetting.getHeight()); 
    c c1 = this.n;
    if (c1 != null) {
      i = c1.n();
    } else {
      i = this.d;
    } 
    c1 = this.n;
    if (c1 != null) {
      j = c1.o();
    } else {
      j = this.e;
    } 
    d1.a(i, j);
    d1.b();
    return d1;
  }
  
  private void k() {
    a a1 = this.m;
    if (a1 != null) {
      a1.f();
      this.m = null;
    } 
    this.f = null;
  }
  
  private void l() {
    c c1 = this.n;
    if (c1 != null) {
      c1.f();
      this.n = null;
    } 
    this.g = null;
    this.h = null;
  }
  
  private void m() {
    com.qiniu.pili.droid.shortvideo.gl.c.d d1 = this.o;
    if (d1 != null) {
      d1.f();
      this.o = null;
    } 
    this.i = null;
  }
  
  private void n() {
    com.qiniu.pili.droid.shortvideo.gl.c.d d1 = this.q;
    if (d1 != null) {
      d1.f();
      this.q = null;
    } 
    this.k = null;
  }
  
  private void o() {
    com.qiniu.pili.droid.shortvideo.gl.c.d d1 = this.p;
    if (d1 != null) {
      d1.f();
      this.p = null;
    } 
    this.l = null;
  }
  
  private void p() {
    ConcurrentHashMap<PLGifWatermarkSetting, b> concurrentHashMap = this.j;
    if (concurrentHashMap == null)
      return; 
    Iterator iterator = concurrentHashMap.keySet().iterator();
    while (iterator.hasNext())
      ((b)this.j.get(iterator.next())).f(); 
    this.j.clear();
    this.j = null;
  }
  
  public int a(int paramInt) {
    return a(paramInt, 0L, true);
  }
  
  public int a(int paramInt, long paramLong, boolean paramBoolean) {
    return a(paramInt, paramLong, paramBoolean, 0L);
  }
  
  public int a(int paramInt, long paramLong1, boolean paramBoolean, long paramLong2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield t : Ljava/util/concurrent/ConcurrentHashMap;
    //   4: invokevirtual isEmpty : ()Z
    //   7: ifne -> 81
    //   10: aload_0
    //   11: getfield t : Ljava/util/concurrent/ConcurrentHashMap;
    //   14: invokevirtual entrySet : ()Ljava/util/Set;
    //   17: invokeinterface iterator : ()Ljava/util/Iterator;
    //   22: astore #11
    //   24: aload #11
    //   26: invokeinterface hasNext : ()Z
    //   31: ifeq -> 74
    //   34: aload #11
    //   36: invokeinterface next : ()Ljava/lang/Object;
    //   41: checkcast java/util/Map$Entry
    //   44: astore #12
    //   46: aload #12
    //   48: invokeinterface getValue : ()Ljava/lang/Object;
    //   53: ifnull -> 24
    //   56: aload #12
    //   58: invokeinterface getValue : ()Ljava/lang/Object;
    //   63: checkcast java/lang/Runnable
    //   66: invokeinterface run : ()V
    //   71: goto -> 24
    //   74: aload_0
    //   75: getfield t : Ljava/util/concurrent/ConcurrentHashMap;
    //   78: invokevirtual clear : ()V
    //   81: aload_0
    //   82: getfield m : Lcom/qiniu/pili/droid/shortvideo/c/a/a;
    //   85: astore #11
    //   87: iload_1
    //   88: istore #7
    //   90: aload #11
    //   92: ifnull -> 103
    //   95: aload #11
    //   97: iload_1
    //   98: invokevirtual a : (I)I
    //   101: istore #7
    //   103: aload_0
    //   104: getfield j : Ljava/util/concurrent/ConcurrentHashMap;
    //   107: astore #11
    //   109: iload #7
    //   111: istore #8
    //   113: aload #11
    //   115: ifnull -> 243
    //   118: iload #7
    //   120: istore #8
    //   122: aload #11
    //   124: invokevirtual isEmpty : ()Z
    //   127: ifne -> 243
    //   130: iload #4
    //   132: ifne -> 146
    //   135: iload #7
    //   137: istore #8
    //   139: aload_0
    //   140: getfield s : Z
    //   143: ifeq -> 243
    //   146: aload_0
    //   147: getfield j : Ljava/util/concurrent/ConcurrentHashMap;
    //   150: invokevirtual keySet : ()Ljava/util/Set;
    //   153: invokeinterface iterator : ()Ljava/util/Iterator;
    //   158: astore #11
    //   160: iload #7
    //   162: istore #8
    //   164: aload #11
    //   166: invokeinterface hasNext : ()Z
    //   171: ifeq -> 243
    //   174: aload #11
    //   176: invokeinterface next : ()Ljava/lang/Object;
    //   181: checkcast com/qiniu/pili/droid/shortvideo/PLGifWatermarkSetting
    //   184: astore #12
    //   186: iload #4
    //   188: ifeq -> 201
    //   191: lload_2
    //   192: ldc2_w 1000
    //   195: ldiv
    //   196: lstore #9
    //   198: goto -> 205
    //   201: lload #5
    //   203: lstore #9
    //   205: aload_0
    //   206: aload #12
    //   208: lload #9
    //   210: invokespecial a : (Lcom/qiniu/pili/droid/shortvideo/PLGifWatermarkSetting;J)Z
    //   213: ifeq -> 160
    //   216: aload_0
    //   217: getfield j : Ljava/util/concurrent/ConcurrentHashMap;
    //   220: aload #12
    //   222: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   225: checkcast com/qiniu/pili/droid/shortvideo/gl/c/b
    //   228: iload #7
    //   230: lload_2
    //   231: ldc2_w 1000
    //   234: ldiv
    //   235: invokevirtual a : (IJ)I
    //   238: istore #7
    //   240: goto -> 160
    //   243: aload_0
    //   244: getfield n : Lcom/qiniu/pili/droid/shortvideo/gl/c/c;
    //   247: astore #11
    //   249: iload #8
    //   251: istore_1
    //   252: aload #11
    //   254: ifnull -> 296
    //   257: iload #4
    //   259: ifeq -> 274
    //   262: aload #11
    //   264: iload #8
    //   266: lload_2
    //   267: invokevirtual b : (IJ)I
    //   270: istore_1
    //   271: goto -> 296
    //   274: aload_0
    //   275: getfield r : Z
    //   278: ifeq -> 285
    //   281: ldc2_w -1
    //   284: lstore_2
    //   285: aload_0
    //   286: getfield n : Lcom/qiniu/pili/droid/shortvideo/gl/c/c;
    //   289: iload #8
    //   291: lload_2
    //   292: invokevirtual a : (IJ)I
    //   295: istore_1
    //   296: iload #4
    //   298: ifeq -> 340
    //   301: aload_0
    //   302: getfield p : Lcom/qiniu/pili/droid/shortvideo/gl/c/d;
    //   305: astore #11
    //   307: aload #11
    //   309: ifnull -> 319
    //   312: aload #11
    //   314: iload_1
    //   315: invokevirtual a : (I)I
    //   318: ireturn
    //   319: aload_0
    //   320: getfield o : Lcom/qiniu/pili/droid/shortvideo/gl/c/d;
    //   323: astore #11
    //   325: iload_1
    //   326: istore #7
    //   328: aload #11
    //   330: ifnull -> 380
    //   333: aload #11
    //   335: iload_1
    //   336: invokevirtual a : (I)I
    //   339: ireturn
    //   340: aload_0
    //   341: getfield q : Lcom/qiniu/pili/droid/shortvideo/gl/c/d;
    //   344: astore #11
    //   346: aload #11
    //   348: ifnull -> 358
    //   351: aload #11
    //   353: iload_1
    //   354: invokevirtual a : (I)I
    //   357: ireturn
    //   358: aload_0
    //   359: getfield o : Lcom/qiniu/pili/droid/shortvideo/gl/c/d;
    //   362: astore #11
    //   364: iload_1
    //   365: istore #7
    //   367: aload #11
    //   369: ifnull -> 380
    //   372: aload #11
    //   374: iload_1
    //   375: invokevirtual a : (I)I
    //   378: istore #7
    //   380: iload #7
    //   382: ireturn
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.d = paramInt1;
    this.e = paramInt2;
    this.b = true;
  }
  
  public void a(PLGifWatermarkSetting paramPLGifWatermarkSetting) {
    if (paramPLGifWatermarkSetting == null) {
      e.g.d("VideoFilterManager", "addGifWatermark : PLGifWatermarkSetting is null");
      return;
    } 
    ConcurrentHashMap<String, Runnable> concurrentHashMap = this.t;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("add_gif_watermark");
    stringBuilder.append(paramPLGifWatermarkSetting.hashCode());
    concurrentHashMap.put(stringBuilder.toString(), new Runnable(this, paramPLGifWatermarkSetting) {
          public void run() {
            if (d.l(this.b) == null)
              d.a(this.b, new ConcurrentHashMap<Object, Object>()); 
            if (!d.l(this.b).containsKey(this.a)) {
              b b = new b(this.a);
              b.a(d.d(this.b), d.e(this.b));
              b.b();
              d.l(this.b).put(this.a, b);
            } 
          }
        });
  }
  
  public void a(PLWatermarkSetting paramPLWatermarkSetting) {
    this.t.put("watermark", new Runnable(this, paramPLWatermarkSetting) {
          public void run() {
            d.k(this.b);
            PLWatermarkSetting pLWatermarkSetting = this.a;
            if (pLWatermarkSetting != null) {
              d.a(this.b, pLWatermarkSetting);
              d d1 = this.b;
              d.a(d1, d.b(d1, this.a));
            } 
          }
        });
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2) {
    this.r = false;
    this.t.put("mv", new Runnable(this, paramString1, paramString2, paramInt1, paramInt2) {
          public void run() {
            d.g(this.e);
            String str = this.a;
            if (str != null && this.b != null) {
              d.b(this.e, str);
              d.c(this.e, this.b);
              d d1 = this.e;
              d.a(d1, new c(d.h(d1), d.i(this.e)));
              d.j(this.e).a(this.c, this.d);
              d.j(this.e).b(d.d(this.e), d.e(this.e));
            } 
          }
        });
    a(this.i);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    this.t.put("filter", new Runnable(this, paramString, paramBoolean) {
          public void run() {
            d.a(this.c);
            String str = this.a;
            if (str != null) {
              d.a(this.c, str);
              d.a(this.c, this.b);
              if (d.b(this.c)) {
                d d1 = this.c;
                Context context = d.c(d1);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("filters/");
                stringBuilder.append(this.a);
                stringBuilder.append("/filter.png");
                d.a(d1, new a(context, stringBuilder.toString(), true));
              } else {
                d d1 = this.c;
                d.a(d1, new a(d.c(d1), this.a, false));
              } 
              d.f(this.c).a(d.d(this.c), d.e(this.c));
              if (!d.f(this.c).b()) {
                e.g.e("VideoFilterManager", "setFilter failed, filter processor setup failed!");
                d.a(this.c, (a)null);
              } 
            } 
          }
        });
  }
  
  public void a(Set<PLGifWatermarkSetting> paramSet) {
    if (paramSet == null)
      return; 
    this.t.put("set_watermarks", new Runnable(this, paramSet) {
          public void run() {
            if (d.l(this.b) == null)
              d.a(this.b, new ConcurrentHashMap<Object, Object>()); 
            d.l(this.b).clear();
            for (PLGifWatermarkSetting pLGifWatermarkSetting : this.a) {
              b b = new b(pLGifWatermarkSetting);
              b.a(d.d(this.b), d.e(this.b));
              b.b();
              d.l(this.b).put(pLGifWatermarkSetting, b);
            } 
          }
        });
  }
  
  public void a(boolean paramBoolean) {
    this.s = paramBoolean;
  }
  
  public PLBuiltinFilter[] a() {
    try {
      String[] arrayOfString = this.a.getAssets().list("filters");
      if (arrayOfString != null) {
        PLBuiltinFilter[] arrayOfPLBuiltinFilter = new PLBuiltinFilter[arrayOfString.length];
        for (int i = 0; i < arrayOfString.length; i++) {
          arrayOfPLBuiltinFilter[i] = new PLBuiltinFilter();
          arrayOfPLBuiltinFilter[i].setName(arrayOfString[i]);
          PLBuiltinFilter pLBuiltinFilter = arrayOfPLBuiltinFilter[i];
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("filters/");
          stringBuilder.append(arrayOfString[i]);
          stringBuilder.append("/thumb.png");
          pLBuiltinFilter.setAssetFilePath(stringBuilder.toString());
        } 
        return arrayOfPLBuiltinFilter;
      } 
    } catch (IOException iOException) {
      e e = e.g;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get builtin filter list failed:");
      stringBuilder.append(iOException.getMessage());
      e.e("VideoFilterManager", stringBuilder.toString());
    } 
    return null;
  }
  
  public void b(PLGifWatermarkSetting paramPLGifWatermarkSetting) {
    if (paramPLGifWatermarkSetting == null) {
      e.g.d("VideoFilterManager", "removeGifWatermark : PLGifWatermarkSetting is null");
      return;
    } 
    ConcurrentHashMap<String, Runnable> concurrentHashMap = this.t;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("remove_gif_watermark");
    stringBuilder.append(paramPLGifWatermarkSetting.hashCode());
    concurrentHashMap.put(stringBuilder.toString(), new Runnable(this, paramPLGifWatermarkSetting) {
          public void run() {
            if (d.l(this.b) != null && d.l(this.b).containsKey(this.a)) {
              b b = (b)d.l(this.b).remove(this.a);
              if (b != null)
                b.f(); 
            } 
          }
        });
  }
  
  public void b(PLWatermarkSetting paramPLWatermarkSetting) {
    boolean bool1;
    boolean bool2;
    int i;
    int j;
    boolean bool3;
    if (paramPLWatermarkSetting == null) {
      o();
      return;
    } 
    if (this.p == null || this.l == null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (bool1 || this.l.getBitmap() != paramPLWatermarkSetting.getBitmap() || this.l.getResourceId() != paramPLWatermarkSetting.getResourceId()) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    c c1 = this.n;
    if (c1 != null) {
      i = c1.n();
    } else {
      i = this.d;
    } 
    c1 = this.n;
    if (c1 != null) {
      j = c1.o();
    } else {
      j = this.e;
    } 
    if (!bool1 && this.p.n() != i && this.p.o() != j) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (bool2) {
      this.p = d(paramPLWatermarkSetting);
      this.l = PLWatermarkSetting.fromSetting(paramPLWatermarkSetting);
      return;
    } 
    a(this.p, paramPLWatermarkSetting, bool3, i, j);
  }
  
  public void b(boolean paramBoolean) {
    this.r = paramBoolean;
  }
  
  public boolean b() {
    if (this.f == null && this.g == null && this.i == null) {
      ConcurrentHashMap<PLGifWatermarkSetting, b> concurrentHashMap = this.j;
      if (concurrentHashMap == null || concurrentHashMap.isEmpty())
        return false; 
    } 
    return true;
  }
  
  public void c(PLGifWatermarkSetting paramPLGifWatermarkSetting) {
    if (paramPLGifWatermarkSetting == null) {
      e.g.d("VideoFilterManager", "updateGifWatermark : PLGifWatermarkSetting is null");
      return;
    } 
    ConcurrentHashMap<String, Runnable> concurrentHashMap = this.t;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update_gif_watermark");
    stringBuilder.append(paramPLGifWatermarkSetting.hashCode());
    concurrentHashMap.put(stringBuilder.toString(), new Runnable(this, paramPLGifWatermarkSetting) {
          public void run() {
            if (d.l(this.b) != null && d.l(this.b).containsKey(this.a)) {
              b b = (b)d.l(this.b).remove(this.a);
              if (b != null)
                b.f(); 
              b = new b(this.a);
              b.a(d.d(this.b), d.e(this.b));
              b.b();
              d.l(this.b).put(this.a, b);
            } 
          }
        });
  }
  
  public void c(PLWatermarkSetting paramPLWatermarkSetting) {
    boolean bool1;
    boolean bool2;
    int i;
    int j;
    boolean bool3;
    if (paramPLWatermarkSetting == null) {
      n();
      return;
    } 
    if (this.q == null || this.k == null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (bool1 || this.k.getBitmap() != paramPLWatermarkSetting.getBitmap() || this.k.getResourceId() != paramPLWatermarkSetting.getResourceId()) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    c c1 = this.n;
    if (c1 != null) {
      i = c1.n();
    } else {
      i = this.d;
    } 
    c1 = this.n;
    if (c1 != null) {
      j = c1.o();
    } else {
      j = this.e;
    } 
    if (!bool1 && this.q.n() != i && this.q.o() != j) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (bool2) {
      this.q = d(paramPLWatermarkSetting);
      this.k = PLWatermarkSetting.fromSetting(paramPLWatermarkSetting);
      return;
    } 
    a(this.q, paramPLWatermarkSetting, bool3, i, j);
  }
  
  public boolean c() {
    return this.c;
  }
  
  public String d() {
    return this.f;
  }
  
  public String e() {
    return this.g;
  }
  
  public String f() {
    return this.h;
  }
  
  public PLWatermarkSetting g() {
    return this.i;
  }
  
  public Set<PLGifWatermarkSetting> h() {
    ConcurrentHashMap<PLGifWatermarkSetting, b> concurrentHashMap = this.j;
    return (concurrentHashMap == null) ? null : concurrentHashMap.keySet();
  }
  
  public boolean i() {
    return this.b;
  }
  
  public void j() {
    k();
    l();
    m();
    n();
    o();
    p();
    this.d = 0;
    this.e = 0;
    this.b = false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\process\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */