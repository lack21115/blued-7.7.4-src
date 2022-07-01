package com.soft.blued.utils.click;

import android.view.View;

public class SingleClickProxy implements View.OnClickListener {
  private View.OnClickListener a;
  
  private long b = 0L;
  
  private long c = 1000L;
  
  private IClickAgain d;
  
  public SingleClickProxy(View.OnClickListener paramOnClickListener) {
    this.a = paramOnClickListener;
  }
  
  public SingleClickProxy(View.OnClickListener paramOnClickListener, long paramLong, IClickAgain paramIClickAgain) {
    this.a = paramOnClickListener;
    this.d = paramIClickAgain;
    this.c = paramLong;
  }
  
  public void onClick(View paramView) {
    if (System.currentTimeMillis() - this.b >= this.c) {
      this.a.onClick(paramView);
      this.b = System.currentTimeMillis();
      return;
    } 
    IClickAgain iClickAgain = this.d;
    if (iClickAgain != null)
      iClickAgain.a(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\click\SingleClickProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */