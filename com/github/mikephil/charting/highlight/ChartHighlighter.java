package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import java.util.ArrayList;
import java.util.List;

public class ChartHighlighter<T extends BarLineScatterCandleBubbleDataProvider> implements IHighlighter {
  protected T a;
  
  protected List<Highlight> b = new ArrayList<Highlight>();
  
  public ChartHighlighter(T paramT) {
    this.a = paramT;
  }
  
  protected float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    return (float)Math.hypot((paramFloat1 - paramFloat3), (paramFloat2 - paramFloat4));
  }
  
  protected float a(Highlight paramHighlight) {
    return paramHighlight.d();
  }
  
  protected float a(List<Highlight> paramList, float paramFloat, YAxis.AxisDependency paramAxisDependency) {
    float f = Float.MAX_VALUE;
    int i = 0;
    while (i < paramList.size()) {
      Highlight highlight = paramList.get(i);
      float f1 = f;
      if (highlight.h() == paramAxisDependency) {
        float f2 = Math.abs(a(highlight) - paramFloat);
        f1 = f;
        if (f2 < f)
          f1 = f2; 
      } 
      i++;
      f = f1;
    } 
    return f;
  }
  
  protected BarLineScatterCandleBubbleData a() {
    return this.a.getData();
  }
  
  public Highlight a(float paramFloat1, float paramFloat2) {
    MPPointD mPPointD = b(paramFloat1, paramFloat2);
    float f = (float)mPPointD.a;
    MPPointD.a(mPPointD);
    return a(f, paramFloat1, paramFloat2);
  }
  
  protected Highlight a(float paramFloat1, float paramFloat2, float paramFloat3) {
    YAxis.AxisDependency axisDependency;
    List<Highlight> list = b(paramFloat1, paramFloat2, paramFloat3);
    if (list.isEmpty())
      return null; 
    if (a(list, paramFloat3, YAxis.AxisDependency.a) < a(list, paramFloat3, YAxis.AxisDependency.b)) {
      axisDependency = YAxis.AxisDependency.a;
    } else {
      axisDependency = YAxis.AxisDependency.b;
    } 
    return a(list, paramFloat2, paramFloat3, axisDependency, this.a.getMaxHighlightDistance());
  }
  
  public Highlight a(List<Highlight> paramList, float paramFloat1, float paramFloat2, YAxis.AxisDependency paramAxisDependency, float paramFloat3) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #9
    //   3: iconst_0
    //   4: istore #8
    //   6: iload #8
    //   8: aload_1
    //   9: invokeinterface size : ()I
    //   14: if_icmpge -> 112
    //   17: aload_1
    //   18: iload #8
    //   20: invokeinterface get : (I)Ljava/lang/Object;
    //   25: checkcast com/github/mikephil/charting/highlight/Highlight
    //   28: astore #11
    //   30: aload #4
    //   32: ifnull -> 53
    //   35: aload #9
    //   37: astore #10
    //   39: fload #5
    //   41: fstore #6
    //   43: aload #11
    //   45: invokevirtual h : ()Lcom/github/mikephil/charting/components/YAxis$AxisDependency;
    //   48: aload #4
    //   50: if_acmpne -> 95
    //   53: aload_0
    //   54: fload_2
    //   55: fload_3
    //   56: aload #11
    //   58: invokevirtual c : ()F
    //   61: aload #11
    //   63: invokevirtual d : ()F
    //   66: invokevirtual a : (FFFF)F
    //   69: fstore #7
    //   71: aload #9
    //   73: astore #10
    //   75: fload #5
    //   77: fstore #6
    //   79: fload #7
    //   81: fload #5
    //   83: fcmpg
    //   84: ifge -> 95
    //   87: aload #11
    //   89: astore #10
    //   91: fload #7
    //   93: fstore #6
    //   95: iload #8
    //   97: iconst_1
    //   98: iadd
    //   99: istore #8
    //   101: aload #10
    //   103: astore #9
    //   105: fload #6
    //   107: fstore #5
    //   109: goto -> 6
    //   112: aload #9
    //   114: areturn
  }
  
  protected List<Highlight> a(IDataSet paramIDataSet, int paramInt, float paramFloat, DataSet.Rounding paramRounding) {
    ArrayList<Highlight> arrayList = new ArrayList();
    List list2 = paramIDataSet.b(paramFloat);
    List list1 = list2;
    if (list2.size() == 0) {
      Entry entry = paramIDataSet.a(paramFloat, Float.NaN, paramRounding);
      list1 = list2;
      if (entry != null)
        list1 = paramIDataSet.b(entry.i()); 
    } 
    if (list1.size() == 0)
      return arrayList; 
    for (Entry entry : list1) {
      MPPointD mPPointD = this.a.a(paramIDataSet.C()).b(entry.i(), entry.b());
      arrayList.add(new Highlight(entry.i(), entry.b(), (float)mPPointD.a, (float)mPPointD.b, paramInt, paramIDataSet.C()));
    } 
    return arrayList;
  }
  
  protected MPPointD b(float paramFloat1, float paramFloat2) {
    return this.a.a(YAxis.AxisDependency.a).a(paramFloat1, paramFloat2);
  }
  
  protected List<Highlight> b(float paramFloat1, float paramFloat2, float paramFloat3) {
    this.b.clear();
    BarLineScatterCandleBubbleData barLineScatterCandleBubbleData = a();
    if (barLineScatterCandleBubbleData == null)
      return this.b; 
    int i = 0;
    int j = barLineScatterCandleBubbleData.d();
    while (i < j) {
      IDataSet iDataSet = barLineScatterCandleBubbleData.a(i);
      if (iDataSet.p())
        this.b.addAll(a(iDataSet, i, paramFloat1, DataSet.Rounding.c)); 
      i++;
    } 
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\highlight\ChartHighlighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */