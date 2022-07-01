package com.soft.blued.ui.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import com.blued.android.module.live_china.model.LiveFansRelationModel;
import com.soft.blued.ui.live.utils.FormatUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineView extends View {
  private float A;
  
  private float B;
  
  private int C = 6;
  
  private int D = 2171195;
  
  private int E = 10;
  
  private int F = -3750202;
  
  private int G = -10994177;
  
  private int H = -7368815;
  
  private float I = 1.5F;
  
  private float J;
  
  private float K;
  
  private float L;
  
  private float M = 10.0F;
  
  private Float N;
  
  private Float O;
  
  private float P = 2.0F;
  
  private int Q = -866030849;
  
  private int R = -10392833;
  
  private int S = -11842454;
  
  private int T;
  
  private int U;
  
  private int V = -1;
  
  private int a;
  
  private int b;
  
  private Paint c;
  
  private Paint d;
  
  private Paint e;
  
  private Paint f;
  
  private Paint g;
  
  private Paint h;
  
  private Paint i;
  
  private Paint j;
  
  private Paint k;
  
  private Paint l;
  
  private List<Float> m = new ArrayList<Float>();
  
  private List<Float> n = new ArrayList<Float>();
  
  private List<String> o = new ArrayList<String>();
  
  private float p = 15.0F;
  
  private float q = 2.0F;
  
  private float r = 8.0F;
  
  private float s = 3.0F;
  
  private float t = 10.0F;
  
  private int u;
  
  private int v;
  
  private int w;
  
  private int x;
  
  private Rect y;
  
  private Rect z;
  
  public LineView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public LineView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LineView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(Context paramContext, float paramFloat) {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  private Float a(Float paramFloat, int paramInt, boolean paramBoolean) {
    float f;
    if (paramBoolean) {
      f = (new BigDecimal(paramFloat.floatValue())).setScale(paramInt, 0).floatValue();
    } else {
      f = (new BigDecimal(paramFloat.floatValue())).setScale(paramInt, 1).floatValue();
    } 
    return Float.valueOf(f);
  }
  
  private Float a(List<Float> paramList, boolean paramBoolean) {
    if (paramBoolean) {
      paramList = Collections.max(paramList);
    } else {
      paramList = Collections.min(paramList);
    } 
    return (Float)paramList;
  }
  
  private void a() {
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.c.setDither(true);
    this.c.setColor(this.D);
    this.d = new Paint();
    this.d.setAntiAlias(true);
    this.d.setDither(true);
    this.d.setTextAlign(Paint.Align.CENTER);
    this.d.setTextSize(b(getContext(), this.E));
    this.d.setColor(this.F);
    this.e = new Paint();
    this.e.setAntiAlias(true);
    this.e.setDither(true);
    this.e.setTextAlign(Paint.Align.CENTER);
    this.e.setTextSize(b(getContext(), this.E));
    this.e.setColor(this.G);
    this.k = new Paint();
    this.k.setAntiAlias(true);
    this.k.setDither(true);
    this.k.setTextAlign(Paint.Align.CENTER);
    this.k.setTextSize(b(getContext(), 9.0F));
    this.k.setColor(this.H);
    this.f = new Paint();
    this.f.setAntiAlias(true);
    this.f.setDither(true);
    this.f.setColor(this.G);
    this.f.setStrokeWidth(a(getContext(), this.I));
    this.f.setStyle(Paint.Style.STROKE);
    this.g = new Paint();
    this.g.setAntiAlias(true);
    this.g.setDither(true);
    this.g.setColor(this.F);
    this.g.setStrokeWidth(a(getContext(), this.P));
    this.g.setStyle(Paint.Style.STROKE);
    this.T = a(getContext(), 2.0F);
    this.U = a(getContext(), 5.0F);
    this.p = a(getContext(), this.p);
    this.q = a(getContext(), this.q);
    this.r = a(getContext(), this.r);
    this.t = a(getContext(), this.t);
    this.s = a(getContext(), this.s);
    this.y = new Rect();
    this.d.getTextBounds("2.0-", 0, 4, this.y);
    this.u = this.y.width();
    this.d.getTextBounds("03-14", 0, 5, this.y);
    this.v = this.y.height();
    this.z = new Rect();
    this.k.getTextBounds(getContext().getString(2131757330), 0, getContext().getString(2131757330).length(), this.z);
    this.w = this.z.width();
    this.k.getTextBounds(getContext().getString(2131757330), 0, getContext().getString(2131757330).length(), this.z);
    this.x = this.z.height();
    this.K = this.x;
    this.h = new Paint();
    this.i = new Paint(this.h);
    this.h.setColor(this.Q);
    this.h.setAntiAlias(true);
    this.i.setColor(this.R);
    this.j = new Paint();
    this.j.setStyle(Paint.Style.STROKE);
    this.j.setColor(this.S);
    this.j.setStrokeWidth(3.0F);
    this.j.setPathEffect((PathEffect)new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F));
    this.l = new Paint();
    this.l.setStyle(Paint.Style.FILL);
  }
  
  private void a(float paramFloat, Canvas paramCanvas) {
    paramCanvas.save();
    paramCanvas.drawText(FormatUtils.a(paramFloat), this.L, this.M - b(getContext(), (this.E + 2)), this.e);
    paramCanvas.restore();
  }
  
  private void a(Canvas paramCanvas) {
    List<String> list = this.o;
    if (list != null) {
      if (list.size() == 0)
        return; 
      Float float_ = a(this.m, true);
      int i = 0;
      this.O = a(float_, 0, true);
      this.N = a(a(this.m, false), 0, false);
      while (i < this.m.size()) {
        this.L = a(i);
        this.M = a(this.m.get(i));
        if (i <= this.m.size() - 2) {
          int j = (int)a(i);
          int k = (int)a(this.m.get(i));
          int n = i + 1;
          int m = (int)a(n);
          n = (int)a(this.m.get(n));
          int i1 = (j + m) / 2;
          Point point1 = new Point();
          Point point2 = new Point();
          point1.y = k;
          point1.x = i1;
          point2.y = n;
          point2.x = i1;
          Path path = new Path();
          path.moveTo(j, k);
          path.cubicTo(point1.x, point1.y, point2.x, point2.y, m, n);
          paramCanvas.drawPath(path, this.f);
        } 
        a(((Float)this.m.get(i)).floatValue(), paramCanvas);
        i++;
      } 
    } 
  }
  
  private int b(Context paramContext, float paramFloat) {
    return (int)TypedValue.applyDimension(2, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  private void b(Canvas paramCanvas) {
    List<String> list = this.o;
    if (list != null) {
      if (list.size() == 0)
        return; 
      paramCanvas.save();
      paramCanvas.translate(this.a - this.A, this.B + this.p + this.q / 2.0F);
      this.J = this.A / (this.o.size() + 1);
      float f = this.J;
      paramCanvas.drawLine(f - this.u, 0.0F, f * this.o.size() + this.u, 0.0F, this.g);
      paramCanvas.translate(0.0F, this.q / 2.0F + this.r + (this.v / 2));
      for (String str : this.o) {
        paramCanvas.translate(this.J, 0.0F);
        paramCanvas.drawText(str, 0.0F, 0.0F, this.d);
      } 
      if (this.V >= 0) {
        paramCanvas.translate(-this.J * this.o.size() - b(getContext(), 2.0F), (this.v / 2) + this.s + (this.x / 2));
        paramCanvas.translate(this.J * (this.V + 1), a(getContext(), 1.0F));
        paramCanvas.drawText(getContext().getString(2131757330), 0.0F, 0.0F, this.d);
      } 
      paramCanvas.restore();
    } 
  }
  
  public float a(int paramInt) {
    return this.a - this.A + this.J * (paramInt + 1);
  }
  
  public float a(Float paramFloat) {
    if (this.O.floatValue() == 0.0F)
      return this.B; 
    float f1 = this.B;
    float f2 = this.K;
    f2 = f1 - f2 - (f1 - f2 - f2) / this.O.floatValue() * paramFloat.floatValue() + b(getContext(), (this.E + 2)) + this.U + this.T;
    float f3 = (b(getContext(), (this.E + 2)) + this.U + this.T);
    f1 = f3;
    if (f2 >= 0.0F)
      if (f2 < f3) {
        f1 = f3;
      } else {
        f1 = f2;
      }  
    f3 = this.B;
    f2 = f1;
    if (f1 > f3)
      f2 = f3; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(f2);
    stringBuilder.append("");
    Log.e("TAG", stringBuilder.toString());
    return f2;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    this.A = this.a;
    this.B = this.b - this.p - this.q - this.r - this.v - this.s - this.x;
    b(paramCanvas);
    a(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    this.a = View.MeasureSpec.getSize(paramInt1);
    if (paramInt2 != Integer.MIN_VALUE) {
      if (paramInt2 == 1073741824)
        this.b = i; 
    } else {
      this.b = a(getContext(), 350.0F);
    } 
    setMeasuredDimension(this.a, this.b);
  }
  
  public void setData(List<LiveFansRelationModel> paramList) {
    if (paramList == null)
      return; 
    this.o.clear();
    this.m.clear();
    for (int i = 0; i < paramList.size(); i++) {
      LiveFansRelationModel liveFansRelationModel = paramList.get(i);
      this.o.add(liveFansRelationModel.date);
      this.m.add(Float.valueOf(liveFansRelationModel.value));
      if (liveFansRelationModel.is_join == 1)
        this.V = i; 
    } 
    invalidate();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\view\LineView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */