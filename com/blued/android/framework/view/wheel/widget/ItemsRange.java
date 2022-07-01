package com.blued.android.framework.view.wheel.widget;

public class ItemsRange {
  private int a;
  
  private int b;
  
  public ItemsRange() {
    this(0, 0);
  }
  
  public ItemsRange(int paramInt1, int paramInt2) {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public int a() {
    return this.a;
  }
  
  public boolean a(int paramInt) {
    return (paramInt >= a() && paramInt <= b());
  }
  
  public int b() {
    return a() + c() - 1;
  }
  
  public int c() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\wheel\widget\ItemsRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */