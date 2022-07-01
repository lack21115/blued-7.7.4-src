package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public class LineChartRenderer extends LineRadarRenderer {
  protected LineDataProvider a;
  
  protected Paint b;
  
  protected WeakReference<Bitmap> c;
  
  protected Canvas d;
  
  protected Bitmap.Config e = Bitmap.Config.ARGB_8888;
  
  protected Path l = new Path();
  
  protected Path m = new Path();
  
  protected Path n = new Path();
  
  private float[] p = new float[4];
  
  private HashMap<IDataSet, DataSetImageCache> q = new HashMap<IDataSet, DataSetImageCache>();
  
  private float[] r = new float[2];
  
  public LineChartRenderer(LineDataProvider paramLineDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler) {
    super(paramChartAnimator, paramViewPortHandler);
    this.a = paramLineDataProvider;
    this.b = new Paint(1);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setColor(-1);
  }
  
  private void a(ILineDataSet paramILineDataSet, int paramInt1, int paramInt2, Path paramPath) {
    boolean bool;
    float f1 = paramILineDataSet.N().getFillLinePosition(paramILineDataSet, this.a);
    float f2 = this.g.a();
    if (paramILineDataSet.a() == LineDataSet.Mode.b) {
      bool = true;
    } else {
      bool = false;
    } 
    paramPath.reset();
    Entry entry1 = paramILineDataSet.e(paramInt1);
    paramPath.moveTo(entry1.i(), f1);
    paramPath.lineTo(entry1.i(), entry1.b() * f2);
    Entry entry2;
    for (entry2 = null; ++paramInt1 <= paramInt2; entry2 = entry1) {
      entry2 = paramILineDataSet.e(paramInt1);
      if (bool)
        paramPath.lineTo(entry2.i(), entry1.b() * f2); 
      paramPath.lineTo(entry2.i(), entry2.b() * f2);
      paramInt1++;
      entry1 = entry2;
    } 
    if (entry2 != null)
      paramPath.lineTo(entry2.i(), f1); 
    paramPath.close();
  }
  
  public void a() {}
  
  public void a(Canvas paramCanvas) {
    // Byte code:
    //   0: aload_0
    //   1: getfield o : Lcom/github/mikephil/charting/utils/ViewPortHandler;
    //   4: invokevirtual n : ()F
    //   7: f2i
    //   8: istore_2
    //   9: aload_0
    //   10: getfield o : Lcom/github/mikephil/charting/utils/ViewPortHandler;
    //   13: invokevirtual m : ()F
    //   16: f2i
    //   17: istore_3
    //   18: aload_0
    //   19: getfield c : Ljava/lang/ref/WeakReference;
    //   22: astore #4
    //   24: aload #4
    //   26: ifnonnull -> 35
    //   29: aconst_null
    //   30: astore #4
    //   32: goto -> 45
    //   35: aload #4
    //   37: invokevirtual get : ()Ljava/lang/Object;
    //   40: checkcast android/graphics/Bitmap
    //   43: astore #4
    //   45: aload #4
    //   47: ifnull -> 72
    //   50: aload #4
    //   52: invokevirtual getWidth : ()I
    //   55: iload_2
    //   56: if_icmpne -> 72
    //   59: aload #4
    //   61: astore #5
    //   63: aload #4
    //   65: invokevirtual getHeight : ()I
    //   68: iload_3
    //   69: if_icmpeq -> 117
    //   72: iload_2
    //   73: ifle -> 196
    //   76: iload_3
    //   77: ifle -> 196
    //   80: iload_2
    //   81: iload_3
    //   82: aload_0
    //   83: getfield e : Landroid/graphics/Bitmap$Config;
    //   86: invokestatic createBitmap : (IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   89: astore #5
    //   91: aload_0
    //   92: new java/lang/ref/WeakReference
    //   95: dup
    //   96: aload #5
    //   98: invokespecial <init> : (Ljava/lang/Object;)V
    //   101: putfield c : Ljava/lang/ref/WeakReference;
    //   104: aload_0
    //   105: new android/graphics/Canvas
    //   108: dup
    //   109: aload #5
    //   111: invokespecial <init> : (Landroid/graphics/Bitmap;)V
    //   114: putfield d : Landroid/graphics/Canvas;
    //   117: aload #5
    //   119: iconst_0
    //   120: invokevirtual eraseColor : (I)V
    //   123: aload_0
    //   124: getfield a : Lcom/github/mikephil/charting/interfaces/dataprovider/LineDataProvider;
    //   127: invokeinterface getLineData : ()Lcom/github/mikephil/charting/data/LineData;
    //   132: invokevirtual i : ()Ljava/util/List;
    //   135: invokeinterface iterator : ()Ljava/util/Iterator;
    //   140: astore #4
    //   142: aload #4
    //   144: invokeinterface hasNext : ()Z
    //   149: ifeq -> 184
    //   152: aload #4
    //   154: invokeinterface next : ()Ljava/lang/Object;
    //   159: checkcast com/github/mikephil/charting/interfaces/datasets/ILineDataSet
    //   162: astore #6
    //   164: aload #6
    //   166: invokeinterface B : ()Z
    //   171: ifeq -> 142
    //   174: aload_0
    //   175: aload_1
    //   176: aload #6
    //   178: invokevirtual a : (Landroid/graphics/Canvas;Lcom/github/mikephil/charting/interfaces/datasets/ILineDataSet;)V
    //   181: goto -> 142
    //   184: aload_1
    //   185: aload #5
    //   187: fconst_0
    //   188: fconst_0
    //   189: aload_0
    //   190: getfield h : Landroid/graphics/Paint;
    //   193: invokevirtual drawBitmap : (Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   196: return
  }
  
  protected void a(Canvas paramCanvas, ILineDataSet paramILineDataSet) {
    if (paramILineDataSet.H() < 1)
      return; 
    this.h.setStrokeWidth(paramILineDataSet.R());
    this.h.setPathEffect((PathEffect)paramILineDataSet.f());
    int i = null.a[paramILineDataSet.a().ordinal()];
    if (i != 3) {
      if (i != 4) {
        b(paramCanvas, paramILineDataSet);
      } else {
        a(paramILineDataSet);
      } 
    } else {
      b(paramILineDataSet);
    } 
    this.h.setPathEffect(null);
  }
  
  protected void a(Canvas paramCanvas, ILineDataSet paramILineDataSet, Path paramPath, Transformer paramTransformer, BarLineScatterCandleBubbleRenderer.XBounds paramXBounds) {
    float f = paramILineDataSet.N().getFillLinePosition(paramILineDataSet, this.a);
    paramPath.lineTo(paramILineDataSet.e(paramXBounds.a + paramXBounds.c).i(), f);
    paramPath.lineTo(paramILineDataSet.e(paramXBounds.a).i(), f);
    paramPath.close();
    paramTransformer.a(paramPath);
    Drawable drawable = paramILineDataSet.P();
    if (drawable != null) {
      a(paramCanvas, paramPath, drawable);
      return;
    } 
    a(paramCanvas, paramPath, paramILineDataSet.O(), paramILineDataSet.Q());
  }
  
  protected void a(Canvas paramCanvas, ILineDataSet paramILineDataSet, Transformer paramTransformer, BarLineScatterCandleBubbleRenderer.XBounds paramXBounds) {
    int j;
    int n;
    Path path = this.n;
    int m = paramXBounds.a;
    int k = paramXBounds.c + paramXBounds.a;
    int i = 0;
    do {
      n = i * 128 + m;
      int i1 = n + 128;
      j = i1;
      if (i1 > k)
        j = k; 
      if (n <= j) {
        a(paramILineDataSet, n, j, path);
        paramTransformer.a(path);
        Drawable drawable = paramILineDataSet.P();
        if (drawable != null) {
          a(paramCanvas, path, drawable);
        } else {
          a(paramCanvas, path, paramILineDataSet.O(), paramILineDataSet.Q());
        } 
      } 
      i++;
    } while (n <= j);
  }
  
  public void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, int paramInt) {
    this.k.setColor(paramInt);
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.k);
  }
  
  public void a(Canvas paramCanvas, Highlight[] paramArrayOfHighlight) {
    LineData lineData = this.a.getLineData();
    int j = paramArrayOfHighlight.length;
    for (int i = 0; i < j; i++) {
      Highlight highlight = paramArrayOfHighlight[i];
      ILineDataSet iLineDataSet = (ILineDataSet)lineData.a(highlight.f());
      if (iLineDataSet != null && iLineDataSet.p()) {
        Entry entry = iLineDataSet.b(highlight.a(), highlight.b());
        if (a(entry, (IBarLineScatterCandleBubbleDataSet)iLineDataSet)) {
          MPPointD mPPointD = this.a.a(iLineDataSet.C()).b(entry.i(), entry.b() * this.g.a());
          highlight.a((float)mPPointD.a, (float)mPPointD.b);
          a(paramCanvas, (float)mPPointD.a, (float)mPPointD.b, (ILineScatterCandleRadarDataSet)iLineDataSet);
        } 
      } 
    } 
  }
  
  protected void a(ILineDataSet paramILineDataSet) {
    float f = this.g.a();
    Transformer transformer = this.a.a(paramILineDataSet.C());
    this.f.a((BarLineScatterCandleBubbleDataProvider)this.a, (IBarLineScatterCandleBubbleDataSet)paramILineDataSet);
    this.l.reset();
    if (this.f.c >= 1) {
      Entry entry = paramILineDataSet.e(this.f.a);
      this.l.moveTo(entry.i(), entry.b() * f);
      int i = this.f.a + 1;
      while (i <= this.f.c + this.f.a) {
        Entry entry1 = paramILineDataSet.e(i);
        float f1 = entry.i() + (entry1.i() - entry.i()) / 2.0F;
        this.l.cubicTo(f1, entry.b() * f, f1, entry1.b() * f, entry1.i(), entry1.b() * f);
        i++;
        entry = entry1;
      } 
    } 
    if (paramILineDataSet.S()) {
      this.m.reset();
      this.m.addPath(this.l);
      a(this.d, paramILineDataSet, this.m, transformer, this.f);
    } 
    this.h.setColor(paramILineDataSet.k());
    this.h.setStyle(Paint.Style.STROKE);
    transformer.a(this.l);
    this.d.drawPath(this.l, this.h);
    this.h.setPathEffect(null);
  }
  
  public void b() {
    Canvas canvas = this.d;
    if (canvas != null) {
      canvas.setBitmap(null);
      this.d = null;
    } 
    WeakReference<Bitmap> weakReference = this.c;
    if (weakReference != null) {
      Bitmap bitmap = weakReference.get();
      if (bitmap != null)
        bitmap.recycle(); 
      this.c.clear();
      this.c = null;
    } 
  }
  
  public void b(Canvas paramCanvas) {
    if (a((ChartInterface)this.a)) {
      List<ILineDataSet> list = this.a.getLineData().i();
      int i;
      for (i = 0; i < list.size(); i++) {
        ILineDataSet iLineDataSet = list.get(i);
        if (a((IDataSet)iLineDataSet) && iLineDataSet.H() >= 1) {
          b((IDataSet)iLineDataSet);
          Transformer transformer = this.a.a(iLineDataSet.C());
          int k = (int)(iLineDataSet.c() * 1.75F);
          int j = k;
          if (!iLineDataSet.g())
            j = k / 2; 
          this.f.a((BarLineScatterCandleBubbleDataProvider)this.a, (IBarLineScatterCandleBubbleDataSet)iLineDataSet);
          float[] arrayOfFloat = transformer.a(iLineDataSet, this.g.b(), this.g.a(), this.f.a, this.f.b);
          ValueFormatter valueFormatter = iLineDataSet.q();
          MPPointF mPPointF = MPPointF.a(iLineDataSet.A());
          mPPointF.a = Utils.a(mPPointF.a);
          mPPointF.b = Utils.a(mPPointF.b);
          for (k = 0; k < arrayOfFloat.length; k += 2) {
            float f1 = arrayOfFloat[k];
            float f2 = arrayOfFloat[k + 1];
            if (!this.o.h(f1))
              break; 
            if (this.o.g(f1) && this.o.f(f2)) {
              int m = k / 2;
              Entry entry = iLineDataSet.e(this.f.a + m);
              if (iLineDataSet.y())
                a(paramCanvas, valueFormatter.a(entry), f1, f2 - j, iLineDataSet.d(m)); 
              if (entry.g() != null && iLineDataSet.z()) {
                Drawable drawable = entry.g();
                Utils.a(paramCanvas, drawable, (int)(f1 + mPPointF.a), (int)(f2 + mPPointF.b), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
              } 
            } 
          } 
          MPPointF.b(mPPointF);
        } 
      } 
    } 
  }
  
  protected void b(Canvas paramCanvas, ILineDataSet paramILineDataSet) {
    int i;
    int j;
    Canvas canvas;
    int k = paramILineDataSet.H();
    if (paramILineDataSet.a() == LineDataSet.Mode.b) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      j = 4;
    } else {
      j = 2;
    } 
    Transformer transformer = this.a.a(paramILineDataSet.C());
    float f = this.g.a();
    this.h.setStyle(Paint.Style.STROKE);
    if (paramILineDataSet.e()) {
      canvas = this.d;
    } else {
      canvas = paramCanvas;
    } 
    this.f.a((BarLineScatterCandleBubbleDataProvider)this.a, (IBarLineScatterCandleBubbleDataSet)paramILineDataSet);
    if (paramILineDataSet.S() && k > 0)
      a(paramCanvas, paramILineDataSet, transformer, this.f); 
    if (paramILineDataSet.j().size() > 1) {
      int m = this.p.length;
      k = j * 2;
      if (m <= k)
        this.p = new float[j * 4]; 
      for (j = this.f.a; j <= this.f.c + this.f.a; j++) {
        Entry entry = paramILineDataSet.e(j);
        if (entry != null) {
          this.p[0] = entry.i();
          this.p[1] = entry.b() * f;
          if (j < this.f.b) {
            entry = paramILineDataSet.e(j + 1);
            if (entry == null)
              break; 
            if (i) {
              this.p[2] = entry.i();
              float[] arrayOfFloat = this.p;
              arrayOfFloat[3] = arrayOfFloat[1];
              arrayOfFloat[4] = arrayOfFloat[2];
              arrayOfFloat[5] = arrayOfFloat[3];
              arrayOfFloat[6] = entry.i();
              this.p[7] = entry.b() * f;
            } else {
              this.p[2] = entry.i();
              this.p[3] = entry.b() * f;
            } 
          } else {
            float[] arrayOfFloat = this.p;
            arrayOfFloat[2] = arrayOfFloat[0];
            arrayOfFloat[3] = arrayOfFloat[1];
          } 
          transformer.a(this.p);
          if (!this.o.h(this.p[0]))
            break; 
          if (this.o.g(this.p[2]) && (this.o.i(this.p[1]) || this.o.j(this.p[3]))) {
            this.h.setColor(paramILineDataSet.a(j));
            canvas.drawLines(this.p, 0, k, this.h);
          } 
        } 
      } 
    } else {
      int m = this.p.length;
      k *= j;
      if (m < Math.max(k, j) * 2)
        this.p = new float[Math.max(k, j) * 4]; 
      if (paramILineDataSet.e(this.f.a) != null) {
        k = this.f.a;
        for (m = 0; k <= this.f.c + this.f.a; m = n) {
          if (k == 0) {
            n = 0;
          } else {
            n = k - 1;
          } 
          Entry entry2 = paramILineDataSet.e(n);
          Entry entry1 = paramILineDataSet.e(k);
          int n = m;
          if (entry2 != null)
            if (entry1 == null) {
              n = m;
            } else {
              float[] arrayOfFloat2 = this.p;
              int i1 = m + 1;
              arrayOfFloat2[m] = entry2.i();
              arrayOfFloat2 = this.p;
              n = i1 + 1;
              arrayOfFloat2[i1] = entry2.b() * f;
              m = n;
              if (i) {
                arrayOfFloat2 = this.p;
                m = n + 1;
                arrayOfFloat2[n] = entry1.i();
                arrayOfFloat2 = this.p;
                n = m + 1;
                arrayOfFloat2[m] = entry2.b() * f;
                arrayOfFloat2 = this.p;
                i1 = n + 1;
                arrayOfFloat2[n] = entry1.i();
                arrayOfFloat2 = this.p;
                m = i1 + 1;
                arrayOfFloat2[i1] = entry2.b() * f;
              } 
              float[] arrayOfFloat1 = this.p;
              n = m + 1;
              arrayOfFloat1[m] = entry1.i();
              this.p[n] = entry1.b() * f;
              n++;
            }  
          k++;
        } 
        if (m > 0) {
          transformer.a(this.p);
          i = Math.max((this.f.c + 1) * j, j);
          this.h.setColor(paramILineDataSet.k());
          canvas.drawLines(this.p, 0, i * 2, this.h);
        } 
      } 
    } 
    this.h.setPathEffect(null);
  }
  
  protected void b(ILineDataSet paramILineDataSet) {
    float f1 = this.g.a();
    Transformer transformer = this.a.a(paramILineDataSet.C());
    this.f.a((BarLineScatterCandleBubbleDataProvider)this.a, (IBarLineScatterCandleBubbleDataSet)paramILineDataSet);
    float f2 = paramILineDataSet.b();
    this.l.reset();
    if (this.f.c >= 1) {
      int i = this.f.a + 1;
      int j = this.f.a;
      j = this.f.c;
      Entry entry3 = paramILineDataSet.e(Math.max(i - 2, 0));
      Entry entry1 = paramILineDataSet.e(Math.max(i - 1, 0));
      int k = -1;
      if (entry1 == null)
        return; 
      this.l.moveTo(entry1.i(), entry1.b() * f1);
      i = this.f.a + 1;
      Entry entry2 = entry1;
      while (i <= this.f.c + this.f.a) {
        if (k != i)
          entry2 = paramILineDataSet.e(i); 
        j = i + 1;
        if (j < paramILineDataSet.H())
          i = j; 
        Entry entry = paramILineDataSet.e(i);
        float f3 = entry2.i();
        float f4 = entry3.i();
        float f5 = entry2.b();
        float f6 = entry3.b();
        float f7 = entry.i();
        float f8 = entry1.i();
        float f9 = entry.b();
        float f10 = entry1.b();
        this.l.cubicTo(entry1.i() + (f3 - f4) * f2, (entry1.b() + (f5 - f6) * f2) * f1, entry2.i() - (f7 - f8) * f2, (entry2.b() - (f9 - f10) * f2) * f1, entry2.i(), entry2.b() * f1);
        entry3 = entry1;
        entry1 = entry2;
        entry2 = entry;
        k = i;
        i = j;
      } 
    } 
    if (paramILineDataSet.S()) {
      this.m.reset();
      this.m.addPath(this.l);
      a(this.d, paramILineDataSet, this.m, transformer, this.f);
    } 
    this.h.setColor(paramILineDataSet.k());
    this.h.setStyle(Paint.Style.STROKE);
    transformer.a(this.l);
    this.d.drawPath(this.l, this.h);
    this.h.setPathEffect(null);
  }
  
  public void c(Canvas paramCanvas) {
    d(paramCanvas);
  }
  
  protected void d(Canvas paramCanvas) {
    this.h.setStyle(Paint.Style.FILL);
    float f = this.g.a();
    float[] arrayOfFloat = this.r;
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 0.0F;
    List<ILineDataSet> list = this.a.getLineData().i();
    int i;
    for (i = 0; i < list.size(); i++) {
      ILineDataSet iLineDataSet = list.get(i);
      if (iLineDataSet.B() && iLineDataSet.g() && iLineDataSet.H() != 0) {
        boolean bool1;
        boolean bool2;
        DataSetImageCache dataSetImageCache;
        this.b.setColor(iLineDataSet.E());
        Transformer transformer = this.a.a(iLineDataSet.C());
        this.f.a((BarLineScatterCandleBubbleDataProvider)this.a, (IBarLineScatterCandleBubbleDataSet)iLineDataSet);
        float f1 = iLineDataSet.c();
        float f2 = iLineDataSet.d();
        if (iLineDataSet.F() && f2 < f1 && f2 > 0.0F) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (bool1 && iLineDataSet.E() == 1122867) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        if (this.q.containsKey(iLineDataSet)) {
          dataSetImageCache = this.q.get(iLineDataSet);
        } else {
          dataSetImageCache = new DataSetImageCache();
          this.q.put(iLineDataSet, dataSetImageCache);
        } 
        if (dataSetImageCache.a(iLineDataSet))
          dataSetImageCache.a(iLineDataSet, bool1, bool2); 
        int k = this.f.c;
        int m = this.f.a;
        int j;
        for (j = this.f.a; j <= k + m; j++) {
          Entry entry = iLineDataSet.e(j);
          if (entry == null)
            break; 
          this.r[0] = entry.i();
          this.r[1] = entry.b() * f;
          transformer.a(this.r);
          if (!this.o.h(this.r[0]))
            break; 
          if (this.o.g(this.r[0]) && this.o.f(this.r[1])) {
            Bitmap bitmap = dataSetImageCache.a(j);
            if (bitmap != null) {
              float[] arrayOfFloat1 = this.r;
              paramCanvas.drawBitmap(bitmap, arrayOfFloat1[0] - f1, arrayOfFloat1[1] - f1, null);
            } 
          } 
        } 
      } 
    } 
  }
  
  class DataSetImageCache {
    private Path b = new Path();
    
    private Bitmap[] c;
    
    private DataSetImageCache(LineChartRenderer this$0) {}
    
    protected Bitmap a(int param1Int) {
      Bitmap[] arrayOfBitmap = this.c;
      return arrayOfBitmap[param1Int % arrayOfBitmap.length];
    }
    
    protected void a(ILineDataSet param1ILineDataSet, boolean param1Boolean1, boolean param1Boolean2) {
      int j = param1ILineDataSet.D();
      float f1 = param1ILineDataSet.c();
      float f2 = param1ILineDataSet.d();
      int i;
      for (i = 0; i < j; i++) {
        Bitmap.Config config = Bitmap.Config.ARGB_4444;
        int k = (int)(f1 * 2.1D);
        Bitmap bitmap = Bitmap.createBitmap(k, k, config);
        Canvas canvas = new Canvas(bitmap);
        this.c[i] = bitmap;
        this.a.h.setColor(param1ILineDataSet.f(i));
        if (param1Boolean2) {
          this.b.reset();
          this.b.addCircle(f1, f1, f1, Path.Direction.CW);
          this.b.addCircle(f1, f1, f2, Path.Direction.CCW);
          canvas.drawPath(this.b, this.a.h);
        } else {
          canvas.drawCircle(f1, f1, f1, this.a.h);
          if (param1Boolean1)
            canvas.drawCircle(f1, f1, f2, this.a.b); 
        } 
      } 
    }
    
    protected boolean a(ILineDataSet param1ILineDataSet) {
      int i = param1ILineDataSet.D();
      Bitmap[] arrayOfBitmap = this.c;
      if (arrayOfBitmap == null) {
        this.c = new Bitmap[i];
        return true;
      } 
      if (arrayOfBitmap.length != i) {
        this.c = new Bitmap[i];
        return true;
      } 
      return false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\LineChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */