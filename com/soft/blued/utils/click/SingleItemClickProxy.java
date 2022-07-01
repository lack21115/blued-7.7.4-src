package com.soft.blued.utils.click;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;

public class SingleItemClickProxy implements BaseQuickAdapter.OnItemClickListener {
  private BaseQuickAdapter.OnItemClickListener a;
  
  private long b = 0L;
  
  private long c = 1000L;
  
  private IClickAgain d;
  
  public SingleItemClickProxy(BaseQuickAdapter.OnItemClickListener paramOnItemClickListener) {
    this.a = paramOnItemClickListener;
  }
  
  public void onItemClick(BaseQuickAdapter paramBaseQuickAdapter, View paramView, int paramInt) {
    if (System.currentTimeMillis() - this.b >= this.c) {
      this.a.onItemClick(paramBaseQuickAdapter, paramView, paramInt);
      this.b = System.currentTimeMillis();
      return;
    } 
    IClickAgain iClickAgain = this.d;
    if (iClickAgain != null)
      iClickAgain.a(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\click\SingleItemClickProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */