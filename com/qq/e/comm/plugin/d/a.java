package com.qq.e.comm.plugin.d;

import java.lang.reflect.Method;

public class a {
  private Method a;
  
  private Method b;
  
  private Method c;
  
  private Method d;
  
  private final Object e;
  
  a(Object<?> paramObject) {
    this.e = paramObject;
    paramObject = (Object<?>)paramObject.getClass();
    try {
      this.a = paramObject.getMethod("setShowHideAnimationEnabled", new Class[] { boolean.class });
      this.b = paramObject.getMethod("isShowing", new Class[0]);
      this.c = paramObject.getMethod("show", new Class[0]);
      this.d = paramObject.getMethod("hide", new Class[0]);
      return;
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
      return;
    } 
  }
  
  public void a(boolean paramBoolean) {
    try {
      this.a.invoke(this.e, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public boolean a() {
    try {
      return ((Boolean)this.b.invoke(this.e, new Object[0])).booleanValue();
    } catch (Exception exception) {
      exception.printStackTrace();
      return false;
    } 
  }
  
  public void b() {
    try {
      this.c.invoke(this.e, new Object[0]);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void c() {
    try {
      this.d.invoke(this.e, new Object[0]);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */