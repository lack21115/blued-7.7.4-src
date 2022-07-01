package com.github.mikephil.charting.jobs;

import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class ZoomJob extends ViewPortJob {
  private static ObjectPool<ZoomJob> e = ObjectPool.a(1, new ZoomJob(null, 0.0F, 0.0F, 0.0F, 0.0F, null, null, null));
  
  protected float a;
  
  protected float b;
  
  protected YAxis.AxisDependency c;
  
  protected Matrix d = new Matrix();
  
  static {
    e.a(0.5F);
  }
  
  public ZoomJob(ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Transformer paramTransformer, YAxis.AxisDependency paramAxisDependency, View paramView) {
    super(paramViewPortHandler, paramFloat3, paramFloat4, paramTransformer, paramView);
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramAxisDependency;
  }
  
  public static void a(ZoomJob paramZoomJob) {
    e.a(paramZoomJob);
  }
  
  public ObjectPool.Poolable b() {
    return new ZoomJob(null, 0.0F, 0.0F, 0.0F, 0.0F, null, null, null);
  }
  
  public void run() {
    Matrix matrix = this.d;
    this.m.a(this.a, this.b, matrix);
    this.m.a(matrix, this.q, false);
    float f1 = (((BarLineChartBase)this.q).b(this.c)).v / this.m.r();
    float f2 = (((BarLineChartBase)this.q).getXAxis()).v / this.m.q();
    this.l[0] = this.n - f2 / 2.0F;
    this.l[1] = this.o + f1 / 2.0F;
    this.p.a(this.l);
    this.m.a(this.l, matrix);
    this.m.a(matrix, this.q, false);
    ((BarLineChartBase)this.q).j();
    this.q.postInvalidate();
    a(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\jobs\ZoomJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */