package com.qq.e.comm.adevent;

public class ADEvent {
  private final int a;
  
  private final Object[] b;
  
  public ADEvent(int paramInt) {
    this(paramInt, null);
  }
  
  public ADEvent(int paramInt, Object[] paramArrayOfObject) {
    this.a = paramInt;
    this.b = paramArrayOfObject;
  }
  
  public Object[] getParas() {
    Object[] arrayOfObject2 = this.b;
    Object[] arrayOfObject1 = arrayOfObject2;
    if (arrayOfObject2 == null)
      arrayOfObject1 = new Object[0]; 
    return arrayOfObject1;
  }
  
  public int getType() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\adevent\ADEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */