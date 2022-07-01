package com.qq.e.comm.plugin.nativeadunified;

import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.plugin.c.a.a;
import com.qq.e.comm.plugin.c.f;
import com.qq.e.comm.plugin.s.c;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;

class e implements View.OnClickListener {
  private g a;
  
  private h b;
  
  private c c;
  
  private a d;
  
  public e(g paramg, h paramh, a parama, c paramc) {
    this.b = paramh;
    this.a = paramg;
    this.d = parama;
    this.c = paramc;
  }
  
  private void a(View paramView) {
    c c1 = this.b.l();
    if (c1 == null)
      return; 
    String str = c1.c();
    if (!TextUtils.isEmpty(str))
      (new com.qq.e.comm.plugin.ac.e(paramView.getContext())).a(str); 
  }
  
  private void a(View paramView, int paramInt1, int paramInt2) {
    a(paramView, paramInt1, paramInt2, false);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean) {
    g g1 = this.a;
    g1.a(paramView, paramInt1, g1.getTitle(), this.a.p(), this.a.o(), this.a.m(), this.a.isAppAd(), paramInt2, false, paramBoolean);
  }
  
  public void onClick(View paramView) {
    GDTLogger.d("report click event");
    g g1 = this.a;
    boolean bool = g1.a((View)g1.a, paramView);
    char c1 = '眜';
    if (!bool) {
      u.a(30492, 0, this.c);
      GDTLogger.e("clicked view is not in NativeAdContainer");
      return;
    } 
    this.a.c.b(System.currentTimeMillis());
    bool = com.qq.e.comm.plugin.c.e.a(this.b);
    byte b = 2;
    if (bool) {
      com.qq.e.comm.plugin.c.e.c((new f.a(this.b, (View)this.a.a)).a(this.a.m()).a(), this.d);
      this.a.a(2, new Object[] { "" });
      return;
    } 
    c c2 = this.b.l();
    if (c2 != null) {
      int i = c2.a();
      c1 = '眈';
      if (i != 1) {
        if (i != 2) {
          b = 3;
          if (i != 3)
            return; 
          c1 = '〉';
        } else {
          a(paramView);
          a(paramView, 0, 9000);
          u.a(c1, 1, this.c);
        } 
      } else {
        c1 = '〈';
      } 
      a(paramView, 0, c1);
      u.a(30472, b, this.c);
      return;
    } 
    u.a(c1, 1, this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\nativeadunified\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */