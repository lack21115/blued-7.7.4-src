package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.List;

public class ShapeData {
  private final List<CubicCurveData> a;
  
  private PointF b;
  
  private boolean c;
  
  public ShapeData() {
    this.a = new ArrayList<CubicCurveData>();
  }
  
  public ShapeData(PointF paramPointF, boolean paramBoolean, List<CubicCurveData> paramList) {
    this.b = paramPointF;
    this.c = paramBoolean;
    this.a = new ArrayList<CubicCurveData>(paramList);
  }
  
  private void a(float paramFloat1, float paramFloat2) {
    if (this.b == null)
      this.b = new PointF(); 
    this.b.set(paramFloat1, paramFloat2);
  }
  
  public PointF a() {
    return this.b;
  }
  
  public void a(ShapeData paramShapeData1, ShapeData paramShapeData2, float paramFloat) {
    boolean bool;
    if (this.b == null)
      this.b = new PointF(); 
    if (paramShapeData1.b() || paramShapeData2.b()) {
      bool = true;
    } else {
      bool = false;
    } 
    this.c = bool;
    if (paramShapeData1.c().size() != paramShapeData2.c().size()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Curves must have the same number of control points. Shape 1: ");
      stringBuilder.append(paramShapeData1.c().size());
      stringBuilder.append("\tShape 2: ");
      stringBuilder.append(paramShapeData2.c().size());
      Logger.b(stringBuilder.toString());
    } 
    int j = Math.min(paramShapeData1.c().size(), paramShapeData2.c().size());
    if (this.a.size() < j) {
      int k;
      for (k = this.a.size(); k < j; k++)
        this.a.add(new CubicCurveData()); 
    } else if (this.a.size() > j) {
      int k;
      for (k = this.a.size() - 1; k >= j; k--) {
        List<CubicCurveData> list = this.a;
        list.remove(list.size() - 1);
      } 
    } 
    PointF pointF1 = paramShapeData1.a();
    PointF pointF2 = paramShapeData2.a();
    a(MiscUtils.a(pointF1.x, pointF2.x, paramFloat), MiscUtils.a(pointF1.y, pointF2.y, paramFloat));
    int i;
    for (i = this.a.size() - 1; i >= 0; i--) {
      CubicCurveData cubicCurveData2 = paramShapeData1.c().get(i);
      CubicCurveData cubicCurveData1 = paramShapeData2.c().get(i);
      pointF1 = cubicCurveData2.a();
      pointF2 = cubicCurveData2.b();
      PointF pointF4 = cubicCurveData2.c();
      PointF pointF5 = cubicCurveData1.a();
      PointF pointF6 = cubicCurveData1.b();
      PointF pointF3 = cubicCurveData1.c();
      ((CubicCurveData)this.a.get(i)).a(MiscUtils.a(pointF1.x, pointF5.x, paramFloat), MiscUtils.a(pointF1.y, pointF5.y, paramFloat));
      ((CubicCurveData)this.a.get(i)).b(MiscUtils.a(pointF2.x, pointF6.x, paramFloat), MiscUtils.a(pointF2.y, pointF6.y, paramFloat));
      ((CubicCurveData)this.a.get(i)).c(MiscUtils.a(pointF4.x, pointF3.x, paramFloat), MiscUtils.a(pointF4.y, pointF3.y, paramFloat));
    } 
  }
  
  public boolean b() {
    return this.c;
  }
  
  public List<CubicCurveData> c() {
    return this.a;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ShapeData{numCurves=");
    stringBuilder.append(this.a.size());
    stringBuilder.append("closed=");
    stringBuilder.append(this.c);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\content\ShapeData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */