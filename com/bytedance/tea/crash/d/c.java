package com.bytedance.tea.crash.d;

import android.content.Context;
import com.bytedance.tea.crash.c.a;
import com.bytedance.tea.crash.e.a.e;
import com.bytedance.tea.crash.g.d;
import com.bytedance.tea.crash.upload.a;

public class c implements b {
  private Context a;
  
  public c(Context paramContext) {
    this.a = paramContext;
  }
  
  public void a(long paramLong, Thread paramThread, Throwable paramThrowable) {
    a a = a.a(paramLong, this.a, paramThread, paramThrowable);
    d.a(this.a, com.bytedance.tea.crash.c.b.a(), Thread.currentThread().getName());
    a = e.a().a(com.bytedance.tea.crash.c.b, a);
    a.a().a(a.a());
  }
  
  public boolean a(Throwable paramThrowable) {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */