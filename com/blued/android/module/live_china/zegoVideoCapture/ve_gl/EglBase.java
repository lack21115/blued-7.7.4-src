package com.blued.android.module.live_china.zegoVideoCapture.ve_gl;

import android.view.Surface;

public abstract class EglBase {
  protected static final String a = EglBase.class.getSimpleName();
  
  public static final Object c = new Object();
  
  public static final int[] d = new int[] { 12324, 8, 12323, 8, 12322, 8, 12352, 4, 12344 };
  
  public static final int[] e = new int[] { 
      12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 
      12344 };
  
  public static final int[] f = new int[] { 
      12324, 8, 12323, 8, 12322, 8, 12352, 4, 12339, 1, 
      12344 };
  
  public static final int[] g = new int[] { 
      12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 
      12339, 1, 12344 };
  
  public static final int[] h = new int[] { 
      12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 
      12344 };
  
  protected boolean b = false;
  
  public static EglBase a(Context paramContext, int[] paramArrayOfint) {
    return (EglBase)((EglBase14.i() && (paramContext == null || paramContext instanceof EglBase14.Context)) ? new EglBase14((EglBase14.Context)paramContext, paramArrayOfint) : new EglBase10((EglBase10.Context)paramContext, paramArrayOfint));
  }
  
  public abstract void a();
  
  public abstract void a(Surface paramSurface);
  
  public abstract Context b();
  
  public abstract boolean c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract void h();
  
  public static class Context {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\zegoVideoCapture\ve_gl\EglBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */