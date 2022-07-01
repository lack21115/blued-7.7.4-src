package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.ArrayList;
import java.util.List;

public class CombinedData extends BarLineScatterCandleBubbleData<IBarLineScatterCandleBubbleDataSet<? extends Entry>> {
  private LineData j;
  
  private BarData k;
  
  private ScatterData l;
  
  private CandleData m;
  
  private BubbleData n;
  
  public BubbleData a() {
    return this.n;
  }
  
  public Entry a(Highlight paramHighlight) {
    if (paramHighlight.e() >= p().size())
      return null; 
    BarLineScatterCandleBubbleData barLineScatterCandleBubbleData = b(paramHighlight.e());
    if (paramHighlight.f() >= barLineScatterCandleBubbleData.d())
      return null; 
    for (Entry entry : barLineScatterCandleBubbleData.a(paramHighlight.f()).b(paramHighlight.a())) {
      if (entry.b() == paramHighlight.b() || Float.isNaN(paramHighlight.b()))
        return entry; 
    } 
    return null;
  }
  
  public BarLineScatterCandleBubbleData b(int paramInt) {
    return p().get(paramInt);
  }
  
  public IBarLineScatterCandleBubbleDataSet<? extends Entry> b(Highlight paramHighlight) {
    if (paramHighlight.e() >= p().size())
      return null; 
    BarLineScatterCandleBubbleData<IBarLineScatterCandleBubbleDataSet<? extends Entry>> barLineScatterCandleBubbleData = b(paramHighlight.e());
    return (paramHighlight.f() >= barLineScatterCandleBubbleData.d()) ? null : barLineScatterCandleBubbleData.i().get(paramHighlight.f());
  }
  
  public void b() {
    LineData lineData = this.j;
    if (lineData != null)
      lineData.b(); 
    BarData barData = this.k;
    if (barData != null)
      barData.b(); 
    CandleData candleData = this.m;
    if (candleData != null)
      candleData.b(); 
    ScatterData scatterData = this.l;
    if (scatterData != null)
      scatterData.b(); 
    BubbleData bubbleData = this.n;
    if (bubbleData != null)
      bubbleData.b(); 
    c();
  }
  
  public void c() {
    if (this.i == null)
      this.i = new ArrayList<IBarLineScatterCandleBubbleDataSet<? extends Entry>>(); 
    this.i.clear();
    this.a = -3.4028235E38F;
    this.b = Float.MAX_VALUE;
    this.c = -3.4028235E38F;
    this.d = Float.MAX_VALUE;
    this.e = -3.4028235E38F;
    this.f = Float.MAX_VALUE;
    this.g = -3.4028235E38F;
    this.h = Float.MAX_VALUE;
    for (ChartData chartData : p()) {
      chartData.c();
      List<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>> list = chartData.i();
      this.i.addAll(list);
      if (chartData.f() > this.a)
        this.a = chartData.f(); 
      if (chartData.e() < this.b)
        this.b = chartData.e(); 
      if (chartData.h() > this.c)
        this.c = chartData.h(); 
      if (chartData.g() < this.d)
        this.d = chartData.g(); 
      if (chartData.e > this.e)
        this.e = chartData.e; 
      if (chartData.f < this.f)
        this.f = chartData.f; 
      if (chartData.g > this.g)
        this.g = chartData.g; 
      if (chartData.h < this.h)
        this.h = chartData.h; 
    } 
  }
  
  public LineData l() {
    return this.j;
  }
  
  public BarData m() {
    return this.k;
  }
  
  public ScatterData n() {
    return this.l;
  }
  
  public CandleData o() {
    return this.m;
  }
  
  public List<BarLineScatterCandleBubbleData> p() {
    ArrayList<LineData> arrayList = new ArrayList();
    LineData lineData = this.j;
    if (lineData != null)
      arrayList.add(lineData); 
    BarData barData = this.k;
    if (barData != null)
      arrayList.add(barData); 
    ScatterData scatterData = this.l;
    if (scatterData != null)
      arrayList.add(scatterData); 
    CandleData candleData = this.m;
    if (candleData != null)
      arrayList.add(candleData); 
    BubbleData bubbleData = this.n;
    if (bubbleData != null)
      arrayList.add(bubbleData); 
    return (List)arrayList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\data\CombinedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */