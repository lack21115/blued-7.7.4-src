package com.blued.android.module.live.base.view.animation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live.base.R;

public class MoneyRainView extends BaseLiveAnimationView {
  private View b;
  
  private FlakeView c;
  
  public MoneyRainView(Context paramContext) {
    this.b = LayoutInflater.from(paramContext).inflate(R.layout.layout_money_rain, null);
    this.c = (FlakeView)this.b.findViewById(R.id.fv_money);
  }
  
  public View a() {
    return this.b;
  }
  
  public void a(IRequestHost paramIRequestHost) {
    FlakeView flakeView = this.c;
    if (flakeView != null)
      flakeView.b(); 
  }
  
  public void a(LiveAnimationListener paramLiveAnimationListener) {
    super.a(paramLiveAnimationListener);
    this.c.setAnimationListener(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\view\animation\MoneyRainView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */