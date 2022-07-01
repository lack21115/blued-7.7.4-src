package com.alipay.sdk.widget;

import android.view.View;
import android.view.animation.Animation;

class m extends j.a {
  m(j paramj, p paramp, String paramString) {
    super(paramj, null);
  }
  
  public void onAnimationEnd(Animation paramAnimation) {
    this.c.removeView((View)this.a);
    j.a(this.c).a(this.b);
    j.a(this.c, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\widget\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */