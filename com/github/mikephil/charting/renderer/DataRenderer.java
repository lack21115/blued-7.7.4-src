package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class DataRenderer extends Renderer {
  protected ChartAnimator g;
  
  protected Paint h;
  
  protected Paint i;
  
  protected Paint j;
  
  protected Paint k;
  
  public DataRenderer(ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler) {
    super(paramViewPortHandler);
    this.g = paramChartAnimator;
    this.h = new Paint(1);
    this.h.setStyle(Paint.Style.FILL);
    this.j = new Paint(4);
    this.k = new Paint(1);
    this.k.setColor(Color.rgb(63, 63, 63));
    this.k.setTextAlign(Paint.Align.CENTER);
    this.k.setTextSize(Utils.a(9.0F));
    this.i = new Paint(1);
    this.i.setStyle(Paint.Style.STROKE);
    this.i.setStrokeWidth(2.0F);
    this.i.setColor(Color.rgb(255, 187, 115));
  }
  
  public abstract void a();
  
  public abstract void a(Canvas paramCanvas);
  
  public abstract void a(Canvas paramCanvas, Highlight[] paramArrayOfHighlight);
  
  protected boolean a(ChartInterface paramChartInterface) {
    return (paramChartInterface.getData().j() < paramChartInterface.getMaxVisibleCount() * this.o.q());
  }
  
  public abstract void b(Canvas paramCanvas);
  
  protected void b(IDataSet paramIDataSet) {
    this.k.setTypeface(paramIDataSet.s());
    this.k.setTextSize(paramIDataSet.t());
  }
  
  public abstract void c(Canvas paramCanvas);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\renderer\DataRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */