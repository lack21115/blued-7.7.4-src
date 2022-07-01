package com.alipay.sdk.widget;

import android.view.View;

class q implements View.OnClickListener {
  q(p paramp) {}
  
  public void onClick(View paramView) {
    p.c c = p.a(this.a);
    if (c != null) {
      paramView.setEnabled(false);
      p.b().postDelayed(new r(this, paramView), 256L);
      if (paramView == p.b(this.a)) {
        c.a(this.a);
        return;
      } 
      if (paramView == p.c(this.a))
        c.b(this.a); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\widget\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */