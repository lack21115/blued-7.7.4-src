package com.bytedance.tea.crash.e.a;

import android.content.Context;
import com.bytedance.tea.crash.c;
import com.bytedance.tea.crash.c.a;
import com.bytedance.tea.crash.c.b;
import com.bytedance.tea.crash.g.k;
import com.bytedance.tea.crash.h;

class g extends c {
  g(Context paramContext, b paramb, d paramd) {
    super(c.b, paramContext, paramb, paramd);
  }
  
  public a a(a parama) {
    parama = super.a(parama);
    parama.a("app_count", Integer.valueOf(1));
    parama.a("magic_tag", "ss_app_log");
    c(parama);
    b b = b.a(this.b);
    b.a(h.a().a());
    b.a(h.c().a());
    b.b(this.c.c());
    parama.a(b);
    k.a(parama, b, this.a);
    return parama;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\e\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */