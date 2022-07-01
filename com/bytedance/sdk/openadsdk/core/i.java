package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.d.i;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.nativeexpress.d;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.ah;

public class i {
  private final Context a;
  
  private final k b;
  
  private a c;
  
  private e d;
  
  private d e;
  
  private View f;
  
  private String g = "rewarded_video";
  
  public i(Context paramContext, k paramk, View paramView) {
    this.b = paramk;
    this.a = paramContext;
    this.f = paramView;
    this.g = ah.b(ah.c(paramk.P()));
    if (this.b.B() == 4)
      this.c = a.a(this.a, this.b, this.g); 
    String str = this.g;
    this.d = new e(paramContext, paramk, str, ah.a(str));
    this.d.a(this.f);
    this.d.a(this.c);
    str = this.g;
    this.e = new d(paramContext, paramk, str, ah.a(str));
    this.e.a(this.f);
    this.e.a(this.c);
  }
  
  public void a(int paramInt, i parami) {
    if (paramInt != -1) {
      if (parami == null)
        return; 
      int j = parami.a;
      int m = parami.b;
      int n = parami.c;
      int i1 = parami.d;
      if (paramInt != 1) {
        if (paramInt != 2)
          return; 
        d d1 = this.e;
        if (d1 != null) {
          d1.a(parami);
          this.e.a(this.f, j, m, n, i1);
          return;
        } 
      } else {
        e e1 = this.d;
        if (e1 != null) {
          e1.a(parami);
          this.d.a(this.f, j, m, n, i1);
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */