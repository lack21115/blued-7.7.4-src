package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;

public class BubbleDataSet extends BarLineScatterCandleBubbleDataSet<BubbleEntry> implements IBubbleDataSet {
  protected float o;
  
  protected boolean p;
  
  private float q;
  
  public float a() {
    return this.q;
  }
  
  protected void a(BubbleEntry paramBubbleEntry) {
    super.a(paramBubbleEntry);
    float f = paramBubbleEntry.a();
    if (f > this.o)
      this.o = f; 
  }
  
  public float b() {
    return this.o;
  }
  
  public boolean c() {
    return this.p;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\data\BubbleDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */