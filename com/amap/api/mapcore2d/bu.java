package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

class bu extends View {
  CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<Integer>();
  
  private y b;
  
  private CopyOnWriteArrayList<ak> c = new CopyOnWriteArrayList<ak>();
  
  private a d = new a();
  
  public bu(Context paramContext, y paramy) {
    super(paramContext);
    this.b = paramy;
  }
  
  protected void a(Canvas paramCanvas) {
    for (ak ak : this.c) {
      if (ak.isVisible())
        ak.a(paramCanvas); 
    } 
  }
  
  public void a(ak paramak) {
    if (paramak != null) {
      b(paramak);
      this.c.add(paramak);
      c();
    } 
  }
  
  public void a(boolean paramBoolean) {
    for (ak ak : this.c) {
      if (ak != null && ak.isVisible())
        ak.a(paramBoolean); 
    } 
  }
  
  protected boolean a() {
    return (this.c.size() > 0);
  }
  
  public void b() {
    for (ak ak : this.c) {
      if (ak != null)
        ak.remove(); 
    } 
    this.c.clear();
  }
  
  public boolean b(ak paramak) {
    return this.c.remove(paramak);
  }
  
  void c() {
    Object[] arrayOfObject = this.c.toArray();
    Arrays.sort(arrayOfObject, this.d);
    this.c.clear();
    int j = arrayOfObject.length;
    for (int i = 0; i < j; i++) {
      Object object = arrayOfObject[i];
      if (object != null)
        this.c.add((ak)object); 
    } 
  }
  
  public void d() {
    for (ak ak : this.c) {
      if (ak != null)
        ak.a(); 
    } 
  }
  
  public void e() {
    for (ak ak : this.c) {
      if (ak != null)
        ak.b(); 
    } 
  }
  
  public void f() {
    for (ak ak : this.c) {
      if (ak != null)
        ak.c(); 
    } 
  }
  
  class a implements Comparator<Object> {
    private a(bu this$0) {}
    
    public int compare(Object param1Object1, Object param1Object2) {
      param1Object1 = param1Object1;
      param1Object2 = param1Object2;
      if (param1Object1 != null && param1Object2 != null)
        try {
          if (param1Object1.getZIndex() > param1Object2.getZIndex())
            return 1; 
          float f1 = param1Object1.getZIndex();
          float f2 = param1Object2.getZIndex();
          if (f1 < f2)
            return -1; 
        } catch (Exception exception) {
          cm.a(exception, "TileOverlayView", "compare");
        }  
      return 0;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */