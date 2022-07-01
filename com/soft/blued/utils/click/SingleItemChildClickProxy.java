package com.soft.blued.utils.click;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;

public class SingleItemChildClickProxy implements BaseQuickAdapter.OnItemChildClickListener {
  private BaseQuickAdapter.OnItemChildClickListener a;
  
  private long b = 0L;
  
  private long c = 1000L;
  
  private IClickAgain d;
  
  public SingleItemChildClickProxy(BaseQuickAdapter.OnItemChildClickListener paramOnItemChildClickListener) {
    this.a = paramOnItemChildClickListener;
  }
  
  public void onItemChildClick(BaseQuickAdapter paramBaseQuickAdapter, View paramView, int paramInt) {
    if (System.currentTimeMillis() - this.b >= this.c) {
      this.a.onItemChildClick(paramBaseQuickAdapter, paramView, paramInt);
      this.b = System.currentTimeMillis();
      return;
    } 
    IClickAgain iClickAgain = this.d;
    if (iClickAgain != null)
      iClickAgain.a(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\click\SingleItemChildClickProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */