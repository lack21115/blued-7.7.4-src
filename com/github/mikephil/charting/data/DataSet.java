package com.github.mikephil.charting.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class DataSet<T extends Entry> extends BaseDataSet<T> {
  protected List<T> u = null;
  
  protected float v = -3.4028235E38F;
  
  protected float w = Float.MAX_VALUE;
  
  protected float x = -3.4028235E38F;
  
  protected float y = Float.MAX_VALUE;
  
  public DataSet(List<T> paramList, String paramString) {
    super(paramString);
    this.u = paramList;
    if (this.u == null)
      this.u = new ArrayList<T>(); 
    G();
  }
  
  public void G() {
    List<T> list = this.u;
    if (list != null) {
      if (list.isEmpty())
        return; 
      this.v = -3.4028235E38F;
      this.w = Float.MAX_VALUE;
      this.x = -3.4028235E38F;
      this.y = Float.MAX_VALUE;
      Iterator<T> iterator = this.u.iterator();
      while (iterator.hasNext())
        a(iterator.next()); 
    } 
  }
  
  public int H() {
    return this.u.size();
  }
  
  public String I() {
    String str;
    StringBuffer stringBuffer = new StringBuffer();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DataSet, label: ");
    if (o() == null) {
      str = "";
    } else {
      str = o();
    } 
    stringBuilder.append(str);
    stringBuilder.append(", entries: ");
    stringBuilder.append(this.u.size());
    stringBuilder.append("\n");
    stringBuffer.append(stringBuilder.toString());
    return stringBuffer.toString();
  }
  
  public float J() {
    return this.w;
  }
  
  public float K() {
    return this.v;
  }
  
  public float L() {
    return this.y;
  }
  
  public float M() {
    return this.x;
  }
  
  public T a(float paramFloat1, float paramFloat2, Rounding paramRounding) {
    int i = b(paramFloat1, paramFloat2, paramRounding);
    return (T)((i > -1) ? (Entry)this.u.get(i) : null);
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    List<T> list = this.u;
    if (list != null) {
      if (list.isEmpty())
        return; 
      this.v = -3.4028235E38F;
      this.w = Float.MAX_VALUE;
      int i = b(paramFloat1, Float.NaN, Rounding.b);
      int j = b(paramFloat2, Float.NaN, Rounding.a);
      while (i <= j) {
        b(this.u.get(i));
        i++;
      } 
    } 
  }
  
  protected void a(T paramT) {
    if (paramT == null)
      return; 
    c(paramT);
    b(paramT);
  }
  
  public void a(List<T> paramList) {
    this.u = paramList;
    i();
  }
  
  public int b(float paramFloat1, float paramFloat2, Rounding paramRounding) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: fail exe a34 = a26\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\r\n\tat com.googlecode.dex2jar.ir.ts.Ir2JRegAssignTransformer.transform(Ir2JRegAssignTransformer.java:182)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:164)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\nCaused by: java.lang.NullPointerException: Cannot assign field \"used\" because \"aValue\" is null\r\n\tat com.googlecode.dex2jar.ir.ts.an.SimpleLiveAnalyze.onUseLocal(SimpleLiveAnalyze.java:89)\r\n\tat com.googlecode.dex2jar.ir.ts.an.SimpleLiveAnalyze.onUseLocal(SimpleLiveAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\r\n\t... 17 more\r\n");
  }
  
  public T b(float paramFloat1, float paramFloat2) {
    return a(paramFloat1, paramFloat2, Rounding.c);
  }
  
  public List<T> b(float paramFloat) {
    ArrayList<Entry> arrayList = new ArrayList();
    int j = this.u.size() - 1;
    int i = 0;
    while (i <= j) {
      int k = (j + i) / 2;
      Entry entry = (Entry)this.u.get(k);
      if (paramFloat == entry.i()) {
        for (i = k; i > 0 && ((Entry)this.u.get(i - 1)).i() == paramFloat; i--);
        j = this.u.size();
        while (i < j) {
          entry = (Entry)this.u.get(i);
          if (entry.i() == paramFloat) {
            arrayList.add(entry);
            i++;
          } 
        } 
        break;
      } 
      if (paramFloat > entry.i()) {
        i = k + 1;
        continue;
      } 
      j = k - 1;
    } 
    return (List)arrayList;
  }
  
  protected void b(T paramT) {
    if (paramT.b() < this.w)
      this.w = paramT.b(); 
    if (paramT.b() > this.v)
      this.v = paramT.b(); 
  }
  
  protected void c(T paramT) {
    if (paramT.i() < this.y)
      this.y = paramT.i(); 
    if (paramT.i() > this.x)
      this.x = paramT.i(); 
  }
  
  public int d(Entry paramEntry) {
    return this.u.indexOf(paramEntry);
  }
  
  public T e(int paramInt) {
    return this.u.get(paramInt);
  }
  
  public String toString() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(I());
    for (int i = 0; i < this.u.size(); i++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(((Entry)this.u.get(i)).toString());
      stringBuilder.append(" ");
      stringBuffer.append(stringBuilder.toString());
    } 
    return stringBuffer.toString();
  }
  
  public enum Rounding {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\data\DataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */