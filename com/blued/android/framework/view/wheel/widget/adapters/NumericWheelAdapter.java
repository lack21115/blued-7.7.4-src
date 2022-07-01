package com.blued.android.framework.view.wheel.widget.adapters;

public class NumericWheelAdapter extends AbstractWheelTextAdapter {
  private int f;
  
  private int g;
  
  private String h;
  
  public int a() {
    return this.g - this.f + 1;
  }
  
  public CharSequence a(int paramInt) {
    if (paramInt >= 0 && paramInt < a()) {
      paramInt = this.f + paramInt;
      String str = this.h;
      return (str != null) ? String.format(str, new Object[] { Integer.valueOf(paramInt) }) : Integer.toString(paramInt);
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\wheel\widget\adapters\NumericWheelAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */