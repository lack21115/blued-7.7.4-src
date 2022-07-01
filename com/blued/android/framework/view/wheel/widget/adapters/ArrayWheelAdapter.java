package com.blued.android.framework.view.wheel.widget.adapters;

public class ArrayWheelAdapter<T> extends AbstractWheelTextAdapter {
  private T[] f;
  
  public int a() {
    return this.f.length;
  }
  
  public CharSequence a(int paramInt) {
    if (paramInt >= 0) {
      T[] arrayOfT = this.f;
      if (paramInt < arrayOfT.length) {
        T t = arrayOfT[paramInt];
        return (t instanceof CharSequence) ? (CharSequence)t : t.toString();
      } 
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\wheel\widget\adapters\ArrayWheelAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */