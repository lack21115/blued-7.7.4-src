package com.github.mikephil.charting.utils;

public class TransformerHorizontalBarChart extends Transformer {
  public TransformerHorizontalBarChart(ViewPortHandler paramViewPortHandler) {
    super(paramViewPortHandler);
  }
  
  public void a(boolean paramBoolean) {
    this.b.reset();
    if (!paramBoolean) {
      this.b.postTranslate(this.c.a(), this.c.m() - this.c.d());
      return;
    } 
    this.b.setTranslate(-(this.c.n() - this.c.b()), this.c.m() - this.c.d());
    this.b.postScale(-1.0F, 1.0F);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\chartin\\utils\TransformerHorizontalBarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */