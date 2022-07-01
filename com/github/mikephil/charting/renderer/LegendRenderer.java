package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

public class LegendRenderer extends Renderer {
  protected Paint a;
  
  protected Paint b;
  
  protected Legend c;
  
  protected List<LegendEntry> d = new ArrayList<LegendEntry>(16);
  
  protected Paint.FontMetrics e = new Paint.FontMetrics();
  
  private Path f = new Path();
  
  public LegendRenderer(ViewPortHandler paramViewPortHandler, Legend paramLegend) {
    super(paramViewPortHandler);
    this.c = paramLegend;
    this.a = new Paint(1);
    this.a.setTextSize(Utils.a(9.0F));
    this.a.setTextAlign(Paint.Align.LEFT);
    this.b = new Paint(1);
    this.b.setStyle(Paint.Style.FILL);
  }
  
  public Paint a() {
    return this.a;
  }
  
  public void a(Canvas paramCanvas) {
    float f1;
    if (!this.c.z())
      return; 
    Typeface typeface = this.c.w();
    if (typeface != null)
      this.a.setTypeface(typeface); 
    this.a.setTextSize(this.c.x());
    this.a.setColor(this.c.y());
    float f9 = Utils.a(this.a, this.e);
    float f10 = Utils.b(this.a, this.e) + Utils.a(this.c.n());
    float f8 = f9 - Utils.b(this.a, "ABC") / 2.0F;
    LegendEntry[] arrayOfLegendEntry = this.c.a();
    float f6 = Utils.a(this.c.o());
    float f4 = Utils.a(this.c.m());
    Legend.LegendOrientation legendOrientation = this.c.f();
    Legend.LegendHorizontalAlignment legendHorizontalAlignment = this.c.d();
    Legend.LegendVerticalAlignment legendVerticalAlignment = this.c.e();
    Legend.LegendDirection legendDirection = this.c.h();
    float f7 = Utils.a(this.c.j());
    float f3 = Utils.a(this.c.p());
    float f5 = this.c.v();
    float f2 = this.c.u();
    int i = null.a[legendHorizontalAlignment.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          f1 = 0.0F;
        } else {
          float f;
          if (legendOrientation == Legend.LegendOrientation.b) {
            f1 = this.o.n() / 2.0F;
          } else {
            f1 = this.o.f() + this.o.i() / 2.0F;
          } 
          if (legendDirection == Legend.LegendDirection.a) {
            f = f2;
          } else {
            f = -f2;
          } 
          f1 += f;
          if (legendOrientation == Legend.LegendOrientation.b) {
            double d1;
            double d2 = f1;
            if (legendDirection == Legend.LegendDirection.a) {
              d1 = -this.c.a / 2.0D + f2;
            } else {
              d1 = this.c.a / 2.0D - f2;
            } 
            f1 = (float)(d2 + d1);
          } 
        } 
      } else {
        if (legendOrientation == Legend.LegendOrientation.b) {
          f1 = this.o.n();
        } else {
          f1 = this.o.g();
        } 
        f2 = f1 - f2;
        f1 = f2;
        if (legendDirection == Legend.LegendDirection.a)
          f1 = f2 - this.c.a; 
      } 
    } else {
      if (legendOrientation != Legend.LegendOrientation.b)
        f2 += this.o.f(); 
      f1 = f2;
      if (legendDirection == Legend.LegendDirection.b)
        f1 = f2 + this.c.a; 
    } 
    i = null.c[legendOrientation.ordinal()];
    if (i != 1) {
      if (i != 2)
        return; 
      i = null.b[legendVerticalAlignment.ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            f2 = 0.0F;
          } else {
            f2 = this.o.m() / 2.0F - this.c.b / 2.0F + this.c.v();
          } 
        } else {
          if (legendHorizontalAlignment == Legend.LegendHorizontalAlignment.b) {
            f2 = this.o.m();
          } else {
            f2 = this.o.h();
          } 
          f2 -= this.c.b + f5;
        } 
      } else {
        if (legendHorizontalAlignment == Legend.LegendHorizontalAlignment.b) {
          f2 = 0.0F;
        } else {
          f2 = this.o.e();
        } 
        f2 += f5;
      } 
      f4 = f2;
      i = 0;
      float f12 = 0.0F;
      boolean bool = false;
      f2 = f3;
      f3 = f4;
      float f11 = f8;
      Legend.LegendDirection legendDirection1 = legendDirection;
      while (i < arrayOfLegendEntry.length) {
        boolean bool1;
        LegendEntry legendEntry = arrayOfLegendEntry[i];
        if (legendEntry.b != Legend.LegendForm.a) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (Float.isNaN(legendEntry.c)) {
          f8 = f7;
        } else {
          f8 = Utils.a(legendEntry.c);
        } 
        if (bool1) {
          if (legendDirection1 == Legend.LegendDirection.a) {
            f4 = f1 + f12;
          } else {
            f4 = f1 - f8 - f12;
          } 
          f5 = f4;
          a(paramCanvas, f5, f3 + f11, legendEntry, this.c);
          f4 = f5;
          if (legendDirection1 == Legend.LegendDirection.a)
            f4 = f5 + f8; 
        } else {
          f4 = f1;
        } 
        f5 = f2;
        if (legendEntry.a != null) {
          if (bool1 && !bool) {
            if (legendDirection1 == Legend.LegendDirection.a) {
              f2 = f6;
            } else {
              f2 = -f6;
            } 
            f2 = f4 + f2;
          } else if (bool) {
            f2 = f1;
          } else {
            f2 = f4;
          } 
          f4 = f2;
          if (legendDirection1 == Legend.LegendDirection.b)
            f4 = f2 - Utils.a(this.a, legendEntry.a); 
          if (!bool) {
            a(paramCanvas, f4, f3 + f9, legendEntry.a);
          } else {
            f3 += f9 + f10;
            a(paramCanvas, f4, f3 + f9, legendEntry.a);
          } 
          f3 += f9 + f10;
          f2 = 0.0F;
        } else {
          f2 = f12 + f8 + f5;
          bool = true;
        } 
        i++;
        f12 = f2;
        f2 = f5;
      } 
    } else {
      List list1 = this.c.t();
      List list2 = this.c.r();
      List<Boolean> list = this.c.s();
      i = null.b[legendVerticalAlignment.ordinal()];
      f2 = f5;
      if (i != 1)
        if (i != 2) {
          if (i != 3) {
            f2 = 0.0F;
          } else {
            f2 = f5 + (this.o.m() - this.c.b) / 2.0F;
          } 
        } else {
          f2 = this.o.m() - f5 - this.c.b;
        }  
      int k = arrayOfLegendEntry.length;
      float f = f2;
      f5 = f1;
      i = 0;
      int j = 0;
      f2 = f4;
      f4 = f3;
      f3 = f1;
      for (f1 = f; i < k; f1 = f) {
        float f11;
        boolean bool1;
        boolean bool2;
        LegendEntry legendEntry = arrayOfLegendEntry[i];
        if (legendEntry.b != Legend.LegendForm.a) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (Float.isNaN(legendEntry.c)) {
          f11 = f7;
        } else {
          f11 = Utils.a(legendEntry.c);
        } 
        if (i < list.size() && ((Boolean)list.get(i)).booleanValue()) {
          f = f1 + f9 + f10;
          f1 = f3;
        } else {
          f = f1;
          f1 = f5;
        } 
        if (f1 == f3 && legendHorizontalAlignment == Legend.LegendHorizontalAlignment.b && j < list1.size()) {
          if (legendDirection == Legend.LegendDirection.b) {
            f5 = ((FSize)list1.get(j)).a;
          } else {
            f5 = -((FSize)list1.get(j)).a;
          } 
          f1 += f5 / 2.0F;
          j++;
        } 
        if (legendEntry.a == null) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        if (bool1) {
          f5 = f1;
          if (legendDirection == Legend.LegendDirection.b)
            f5 = f1 - f11; 
          a(paramCanvas, f5, f + f8, legendEntry, this.c);
          f1 = f5;
          if (legendDirection == Legend.LegendDirection.a)
            f1 = f5 + f11; 
        } 
        if (!bool2) {
          f5 = f1;
          if (bool1) {
            if (legendDirection == Legend.LegendDirection.b) {
              f5 = -f6;
            } else {
              f5 = f6;
            } 
            f5 = f1 + f5;
          } 
          f1 = f5;
          if (legendDirection == Legend.LegendDirection.b)
            f1 = f5 - ((FSize)list2.get(i)).a; 
          f5 = f1;
          a(paramCanvas, f5, f + f9, legendEntry.a);
          f1 = f5;
          if (legendDirection == Legend.LegendDirection.a)
            f1 = f5 + ((FSize)list2.get(i)).a; 
          if (legendDirection == Legend.LegendDirection.b) {
            f5 = -f2;
          } else {
            f5 = f2;
          } 
          f5 = f1 + f5;
        } else {
          if (legendDirection == Legend.LegendDirection.b) {
            f5 = -f4;
          } else {
            f5 = f4;
          } 
          f5 = f1 + f5;
        } 
        i++;
      } 
    } 
  }
  
  protected void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, LegendEntry paramLegendEntry, Legend paramLegend) {
    if (paramLegendEntry.f != 1122868 && paramLegendEntry.f != 1122867) {
      DashPathEffect dashPathEffect;
      if (paramLegendEntry.f == 0)
        return; 
      int i = paramCanvas.save();
      Legend.LegendForm legendForm2 = paramLegendEntry.b;
      Legend.LegendForm legendForm1 = legendForm2;
      if (legendForm2 == Legend.LegendForm.c)
        legendForm1 = paramLegend.i(); 
      this.b.setColor(paramLegendEntry.f);
      if (Float.isNaN(paramLegendEntry.c)) {
        f1 = paramLegend.j();
      } else {
        f1 = paramLegendEntry.c;
      } 
      float f2 = Utils.a(f1);
      float f1 = f2 / 2.0F;
      switch (null.d[legendForm1.ordinal()]) {
        case 6:
          if (Float.isNaN(paramLegendEntry.d)) {
            f1 = paramLegend.k();
          } else {
            f1 = paramLegendEntry.d;
          } 
          f1 = Utils.a(f1);
          if (paramLegendEntry.e == null) {
            dashPathEffect = paramLegend.l();
          } else {
            dashPathEffect = ((LegendEntry)dashPathEffect).e;
          } 
          this.b.setStyle(Paint.Style.STROKE);
          this.b.setStrokeWidth(f1);
          this.b.setPathEffect((PathEffect)dashPathEffect);
          this.f.reset();
          this.f.moveTo(paramFloat1, paramFloat2);
          this.f.lineTo(paramFloat1 + f2, paramFloat2);
          paramCanvas.drawPath(this.f, this.b);
          break;
        case 5:
          this.b.setStyle(Paint.Style.FILL);
          paramCanvas.drawRect(paramFloat1, paramFloat2 - f1, paramFloat1 + f2, paramFloat2 + f1, this.b);
          break;
        case 3:
        case 4:
          this.b.setStyle(Paint.Style.FILL);
          paramCanvas.drawCircle(paramFloat1 + f1, paramFloat2, f1, this.b);
          break;
      } 
      paramCanvas.restoreToCount(i);
    } 
  }
  
  protected void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, String paramString) {
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, this.a);
  }
  
  public void a(ChartData<?> paramChartData) {
    // Byte code:
    //   0: aload_1
    //   1: astore #5
    //   3: aload_0
    //   4: getfield c : Lcom/github/mikephil/charting/components/Legend;
    //   7: invokevirtual c : ()Z
    //   10: ifne -> 725
    //   13: aload_0
    //   14: getfield d : Ljava/util/List;
    //   17: invokeinterface clear : ()V
    //   22: iconst_0
    //   23: istore_2
    //   24: iload_2
    //   25: aload_1
    //   26: invokevirtual d : ()I
    //   29: if_icmpge -> 689
    //   32: aload #5
    //   34: iload_2
    //   35: invokevirtual a : (I)Lcom/github/mikephil/charting/interfaces/datasets/IDataSet;
    //   38: astore #6
    //   40: aload #6
    //   42: invokeinterface j : ()Ljava/util/List;
    //   47: astore #7
    //   49: aload #6
    //   51: invokeinterface H : ()I
    //   56: istore #4
    //   58: aload #6
    //   60: instanceof com/github/mikephil/charting/interfaces/datasets/IBarDataSet
    //   63: ifeq -> 240
    //   66: aload #6
    //   68: checkcast com/github/mikephil/charting/interfaces/datasets/IBarDataSet
    //   71: astore #8
    //   73: aload #8
    //   75: invokeinterface b : ()Z
    //   80: ifeq -> 240
    //   83: aload #8
    //   85: invokeinterface g : ()[Ljava/lang/String;
    //   90: astore #9
    //   92: iconst_0
    //   93: istore_3
    //   94: iload_3
    //   95: aload #7
    //   97: invokeinterface size : ()I
    //   102: if_icmpge -> 190
    //   105: iload_3
    //   106: aload #8
    //   108: invokeinterface a : ()I
    //   113: if_icmpge -> 190
    //   116: aload_0
    //   117: getfield d : Ljava/util/List;
    //   120: new com/github/mikephil/charting/components/LegendEntry
    //   123: dup
    //   124: aload #9
    //   126: iload_3
    //   127: aload #9
    //   129: arraylength
    //   130: irem
    //   131: aaload
    //   132: aload #6
    //   134: invokeinterface u : ()Lcom/github/mikephil/charting/components/Legend$LegendForm;
    //   139: aload #6
    //   141: invokeinterface v : ()F
    //   146: aload #6
    //   148: invokeinterface w : ()F
    //   153: aload #6
    //   155: invokeinterface x : ()Landroid/graphics/DashPathEffect;
    //   160: aload #7
    //   162: iload_3
    //   163: invokeinterface get : (I)Ljava/lang/Object;
    //   168: checkcast java/lang/Integer
    //   171: invokevirtual intValue : ()I
    //   174: invokespecial <init> : (Ljava/lang/String;Lcom/github/mikephil/charting/components/Legend$LegendForm;FFLandroid/graphics/DashPathEffect;I)V
    //   177: invokeinterface add : (Ljava/lang/Object;)Z
    //   182: pop
    //   183: iload_3
    //   184: iconst_1
    //   185: iadd
    //   186: istore_3
    //   187: goto -> 94
    //   190: aload #8
    //   192: invokeinterface o : ()Ljava/lang/String;
    //   197: ifnull -> 237
    //   200: aload_0
    //   201: getfield d : Ljava/util/List;
    //   204: new com/github/mikephil/charting/components/LegendEntry
    //   207: dup
    //   208: aload #6
    //   210: invokeinterface o : ()Ljava/lang/String;
    //   215: getstatic com/github/mikephil/charting/components/Legend$LegendForm.a : Lcom/github/mikephil/charting/components/Legend$LegendForm;
    //   218: ldc_w NaN
    //   221: ldc_w NaN
    //   224: aconst_null
    //   225: ldc_w 1122867
    //   228: invokespecial <init> : (Ljava/lang/String;Lcom/github/mikephil/charting/components/Legend$LegendForm;FFLandroid/graphics/DashPathEffect;I)V
    //   231: invokeinterface add : (Ljava/lang/Object;)Z
    //   236: pop
    //   237: goto -> 682
    //   240: aload #6
    //   242: instanceof com/github/mikephil/charting/interfaces/datasets/IPieDataSet
    //   245: ifeq -> 404
    //   248: aload #6
    //   250: checkcast com/github/mikephil/charting/interfaces/datasets/IPieDataSet
    //   253: astore #5
    //   255: iconst_0
    //   256: istore_3
    //   257: iload_3
    //   258: aload #7
    //   260: invokeinterface size : ()I
    //   265: if_icmpge -> 354
    //   268: iload_3
    //   269: iload #4
    //   271: if_icmpge -> 354
    //   274: aload_0
    //   275: getfield d : Ljava/util/List;
    //   278: new com/github/mikephil/charting/components/LegendEntry
    //   281: dup
    //   282: aload #5
    //   284: iload_3
    //   285: invokeinterface e : (I)Lcom/github/mikephil/charting/data/Entry;
    //   290: checkcast com/github/mikephil/charting/data/PieEntry
    //   293: invokevirtual a : ()Ljava/lang/String;
    //   296: aload #6
    //   298: invokeinterface u : ()Lcom/github/mikephil/charting/components/Legend$LegendForm;
    //   303: aload #6
    //   305: invokeinterface v : ()F
    //   310: aload #6
    //   312: invokeinterface w : ()F
    //   317: aload #6
    //   319: invokeinterface x : ()Landroid/graphics/DashPathEffect;
    //   324: aload #7
    //   326: iload_3
    //   327: invokeinterface get : (I)Ljava/lang/Object;
    //   332: checkcast java/lang/Integer
    //   335: invokevirtual intValue : ()I
    //   338: invokespecial <init> : (Ljava/lang/String;Lcom/github/mikephil/charting/components/Legend$LegendForm;FFLandroid/graphics/DashPathEffect;I)V
    //   341: invokeinterface add : (Ljava/lang/Object;)Z
    //   346: pop
    //   347: iload_3
    //   348: iconst_1
    //   349: iadd
    //   350: istore_3
    //   351: goto -> 257
    //   354: aload #5
    //   356: invokeinterface o : ()Ljava/lang/String;
    //   361: ifnull -> 679
    //   364: aload_0
    //   365: getfield d : Ljava/util/List;
    //   368: new com/github/mikephil/charting/components/LegendEntry
    //   371: dup
    //   372: aload #6
    //   374: invokeinterface o : ()Ljava/lang/String;
    //   379: getstatic com/github/mikephil/charting/components/Legend$LegendForm.a : Lcom/github/mikephil/charting/components/Legend$LegendForm;
    //   382: ldc_w NaN
    //   385: ldc_w NaN
    //   388: aconst_null
    //   389: ldc_w 1122867
    //   392: invokespecial <init> : (Ljava/lang/String;Lcom/github/mikephil/charting/components/Legend$LegendForm;FFLandroid/graphics/DashPathEffect;I)V
    //   395: invokeinterface add : (Ljava/lang/Object;)Z
    //   400: pop
    //   401: goto -> 679
    //   404: aload #6
    //   406: instanceof com/github/mikephil/charting/interfaces/datasets/ICandleDataSet
    //   409: ifeq -> 553
    //   412: aload #6
    //   414: checkcast com/github/mikephil/charting/interfaces/datasets/ICandleDataSet
    //   417: astore #5
    //   419: aload #5
    //   421: invokeinterface f : ()I
    //   426: ldc_w 1122867
    //   429: if_icmpeq -> 553
    //   432: aload #5
    //   434: invokeinterface f : ()I
    //   439: istore_3
    //   440: aload #5
    //   442: invokeinterface e : ()I
    //   447: istore #4
    //   449: aload_0
    //   450: getfield d : Ljava/util/List;
    //   453: new com/github/mikephil/charting/components/LegendEntry
    //   456: dup
    //   457: aconst_null
    //   458: aload #6
    //   460: invokeinterface u : ()Lcom/github/mikephil/charting/components/Legend$LegendForm;
    //   465: aload #6
    //   467: invokeinterface v : ()F
    //   472: aload #6
    //   474: invokeinterface w : ()F
    //   479: aload #6
    //   481: invokeinterface x : ()Landroid/graphics/DashPathEffect;
    //   486: iload_3
    //   487: invokespecial <init> : (Ljava/lang/String;Lcom/github/mikephil/charting/components/Legend$LegendForm;FFLandroid/graphics/DashPathEffect;I)V
    //   490: invokeinterface add : (Ljava/lang/Object;)Z
    //   495: pop
    //   496: aload_0
    //   497: getfield d : Ljava/util/List;
    //   500: new com/github/mikephil/charting/components/LegendEntry
    //   503: dup
    //   504: aload #6
    //   506: invokeinterface o : ()Ljava/lang/String;
    //   511: aload #6
    //   513: invokeinterface u : ()Lcom/github/mikephil/charting/components/Legend$LegendForm;
    //   518: aload #6
    //   520: invokeinterface v : ()F
    //   525: aload #6
    //   527: invokeinterface w : ()F
    //   532: aload #6
    //   534: invokeinterface x : ()Landroid/graphics/DashPathEffect;
    //   539: iload #4
    //   541: invokespecial <init> : (Ljava/lang/String;Lcom/github/mikephil/charting/components/Legend$LegendForm;FFLandroid/graphics/DashPathEffect;I)V
    //   544: invokeinterface add : (Ljava/lang/Object;)Z
    //   549: pop
    //   550: goto -> 679
    //   553: iconst_0
    //   554: istore_3
    //   555: iload_3
    //   556: aload #7
    //   558: invokeinterface size : ()I
    //   563: if_icmpge -> 679
    //   566: iload_3
    //   567: iload #4
    //   569: if_icmpge -> 679
    //   572: iload_3
    //   573: aload #7
    //   575: invokeinterface size : ()I
    //   580: iconst_1
    //   581: isub
    //   582: if_icmpge -> 599
    //   585: iload_3
    //   586: iload #4
    //   588: iconst_1
    //   589: isub
    //   590: if_icmpge -> 599
    //   593: aconst_null
    //   594: astore #5
    //   596: goto -> 611
    //   599: aload_1
    //   600: iload_2
    //   601: invokevirtual a : (I)Lcom/github/mikephil/charting/interfaces/datasets/IDataSet;
    //   604: invokeinterface o : ()Ljava/lang/String;
    //   609: astore #5
    //   611: aload_0
    //   612: getfield d : Ljava/util/List;
    //   615: new com/github/mikephil/charting/components/LegendEntry
    //   618: dup
    //   619: aload #5
    //   621: aload #6
    //   623: invokeinterface u : ()Lcom/github/mikephil/charting/components/Legend$LegendForm;
    //   628: aload #6
    //   630: invokeinterface v : ()F
    //   635: aload #6
    //   637: invokeinterface w : ()F
    //   642: aload #6
    //   644: invokeinterface x : ()Landroid/graphics/DashPathEffect;
    //   649: aload #7
    //   651: iload_3
    //   652: invokeinterface get : (I)Ljava/lang/Object;
    //   657: checkcast java/lang/Integer
    //   660: invokevirtual intValue : ()I
    //   663: invokespecial <init> : (Ljava/lang/String;Lcom/github/mikephil/charting/components/Legend$LegendForm;FFLandroid/graphics/DashPathEffect;I)V
    //   666: invokeinterface add : (Ljava/lang/Object;)Z
    //   671: pop
    //   672: iload_3
    //   673: iconst_1
    //   674: iadd
    //   675: istore_3
    //   676: goto -> 555
    //   679: aload_1
    //   680: astore #5
    //   682: iload_2
    //   683: iconst_1
    //   684: iadd
    //   685: istore_2
    //   686: goto -> 24
    //   689: aload_0
    //   690: getfield c : Lcom/github/mikephil/charting/components/Legend;
    //   693: invokevirtual b : ()[Lcom/github/mikephil/charting/components/LegendEntry;
    //   696: ifnull -> 714
    //   699: aload_0
    //   700: getfield d : Ljava/util/List;
    //   703: aload_0
    //   704: getfield c : Lcom/github/mikephil/charting/components/Legend;
    //   707: invokevirtual b : ()[Lcom/github/mikephil/charting/components/LegendEntry;
    //   710: invokestatic addAll : (Ljava/util/Collection;[Ljava/lang/Object;)Z
    //   713: pop
    //   714: aload_0
    //   715: getfield c : Lcom/github/mikephil/charting/components/Legend;
    //   718: aload_0
    //   719: getfield d : Ljava/util/List;
    //   722: invokevirtual a : (Ljava/util/List;)V
    //   725: aload_0
    //   726: getfield c : Lcom/github/mikephil/charting/components/Legend;
    //   729: invokevirtual w : ()Landroid/graphics/Typeface;
    //   732: astore_1
    //   733: aload_1
    //   734: ifnull -> 746
    //   737: aload_0
    //   738: getfield a : Landroid/graphics/Paint;
    //   741: aload_1
    //   742: invokevirtual setTypeface : (Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    //   745: pop
    //   746: aload_0
    //   747: getfield a : Landroid/graphics/Paint;
    //   750: aload_0
    //   751: getfield c : Lcom/github/mikephil/charting/components/Legend;
    //   754: invokevirtual x : ()F
    //   757: invokevirtual setTextSize : (F)V
    //   760: aload_0
    //   761: getfield a : Landroid/graphics/Paint;
    //   764: aload_0
    //   765: getfield c : Lcom/github/mikephil/charting/components/Legend;
    //   768: invokevirtual y : ()I
    //   771: invokevirtual setColor : (I)V
    //   774: aload_0
    //   775: getfield c : Lcom/github/mikephil/charting/components/Legend;
    //   778: aload_0
    //   779: getfield a : Landroid/graphics/Paint;
    //   782: aload_0
    //   783: getfield o : Lcom/github/mikephil/charting/utils/ViewPortHandler;
    //   786: invokevirtual a : (Landroid/graphics/Paint;Lcom/github/mikephil/charting/utils/ViewPortHandler;)V
    //   789: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\LegendRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */