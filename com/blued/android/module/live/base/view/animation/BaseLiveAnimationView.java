package com.blued.android.module.live.base.view.animation;

import android.view.View;
import com.blued.android.core.net.IRequestHost;

public abstract class BaseLiveAnimationView {
  protected LiveAnimationListener a;
  
  public abstract View a();
  
  public void a(IRequestHost paramIRequestHost) {}
  
  public void a(LiveAnimationListener paramLiveAnimationListener) {
    this.a = paramLiveAnimationListener;
  }
  
  public void a(String paramString) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\view\animation\BaseLiveAnimationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */