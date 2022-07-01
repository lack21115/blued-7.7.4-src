package com.qq.e.comm.plugin.m;

import android.content.Context;
import android.widget.FrameLayout;

public class a extends FrameLayout {
  private a a;
  
  public a(Context paramContext) {
    super(paramContext);
  }
  
  public void a(a parama) {
    this.a = parama;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    a a1 = this.a;
    if (a1 != null)
      a1.a(); 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    a a1 = this.a;
    if (a1 != null)
      a1.b(); 
  }
  
  public void onFinishTemporaryDetach() {
    super.onFinishTemporaryDetach();
    a a1 = this.a;
    if (a1 != null)
      a1.d(); 
  }
  
  public void onStartTemporaryDetach() {
    super.onStartTemporaryDetach();
    a a1 = this.a;
    if (a1 != null)
      a1.c(); 
  }
  
  protected void onWindowVisibilityChanged(int paramInt) {
    super.onWindowVisibilityChanged(paramInt);
    a a1 = this.a;
    if (a1 != null)
      a1.a(paramInt); 
  }
  
  public static interface a {
    void a();
    
    void a(int param1Int);
    
    void b();
    
    void c();
    
    void d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\m\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */